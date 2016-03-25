package ui.action.company;

import javax.servlet.http.*;
import model.*;

import java.util.*;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.log4j.Logger;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompShowPersonInfoAction extends BaseAction {
	private static Logger logger = Logger
			.getLogger(CompShowPersonInfoAction.class);

	/**
	 * 
	 * 描述：查看个人的详细资料
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showPersonInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			HttpSession session = request.getSession();
			String applyKeyId = request.getParameter("applyKeyId");
			String compId = (String) session
					.getAttribute(IConstants.COMP_USER_ID);
			if (compId == null) {
				ActionMessages messages = new ActionMessages();
				messages.add("loginfirst", new ActionMessage("login.first"));
				super.saveErrors(request, messages);
				return mapping.findForward(IConstants.FAIL_KEY);
			} else {
				List<?> list = super.getInviteManager().findApplyJobInfoById(
						applyKeyId);
				ApplyJobInfo Ajob = new ApplyJobInfo();
				if (list != null) {
					Object[] o = (Object[]) list.get(0);
					Ajob = (ApplyJobInfo) o[0];
				}
				// 得到用户主键UserKey，登录名loginId
				String UserKey = Ajob.getPersonCode().getId().toString();
				UserInfo user = new UserInfo();
				user = super.getInviteManager().findUserById(UserKey);

				String resumeKey = Ajob.getResumeCode().getId().toString();
				String isNo = super.getInviteManager().findFileByResumeId(
						resumeKey, compId);
				if (isNo == null)
					isNo = "3";
				String loginId = user.getLoginId();
				List<?> compResumelist = super.getInviteManager()
						.queryPersonResume(loginId);
				PersonResume personResume = new PersonResume();
				if (compResumelist != null) {
					Object[] o = (Object[]) compResumelist.get(0);
					personResume = (PersonResume) o[0];
				}
				if (personResume.getPv() == null) {
					personResume.setPv(1);
				} else {
					personResume.setPv(personResume.getPv() + 1);
				}
				super.getInviteManager().updatePersonResume(personResume);
				List<PersonResumeB> list3 = super.getInviteManager()
						.findPersonResumesById(loginId);
				List educations = super.getInviteManager().findEducationsById(loginId);
				request.setAttribute("educations", educations);
				request.setAttribute("isNo", isNo);
				request.setAttribute("applyJob", Ajob);
				request.setAttribute("ResumeB", list3);

				return mapping.findForward(IConstants.SUCCESS_KEY);
			}
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
	}

	/**
	 * 
	 * 描述：将个人加入人才库
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward join(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			HttpSession session = request.getSession();
			String compLoginId = (String) session
					.getAttribute(IConstants.COMP_USER_ID);
			String ResumeId = request.getParameter("ResumeId");
			PersonResume Presume = new PersonResume();
			List<?> listP = super.getInviteManager().findPersonResumeById(
					ResumeId);
			if (listP != null && listP.size() != 0) {
				Object[] o = (Object[]) listP.get(0);
				Presume = (PersonResume) o[0];
			}
			CompResume Cresume = new CompResume();
			Cresume.setCompLoginId(compLoginId);
			Cresume.setPkResume(Presume);
			Cresume.setFile(IConstants.PERSON_DATABASE);
			super.getInviteManager().saveCompResumeFile(Cresume);
			return mapping.findForward("show");
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
	}
}
