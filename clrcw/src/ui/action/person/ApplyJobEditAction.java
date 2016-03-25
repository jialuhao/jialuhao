package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.BdJob;
import model.BdPost;
import model.BdTrade;
import model.PersonResume;
import model.UserInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class ApplyJobEditAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ApplyJobEditAction.class);

	/**
	 * 
	 * 描述：欲求职位的修改
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward applyJobEdit(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;

		try {
			// 获取session
			HttpSession session = request.getSession(true);
			String user = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List eee = (List) super.getInviteManager().queryPersonResume(
					user);
			Object[] vvv1 = (Object[]) eee.get(0);
			PersonResume personResume = (PersonResume) vvv1[0];
			 
			//保存更新
			personResume.setState("0");
			personResume.setOpinion("");
			super.getInviteManager().updatePersonResume(personResume);
			String apllyId = (String) session.getAttribute("apllyId");
			String post = (String) request.getParameter( "post");
			String job = (String) request.getParameter( "job");
			String workyears = (String) request.getParameter("workyears");
			workyears=workyears.substring(0,workyears.length()-1);
			String salary = (String) request.getParameter("salary");
			BdTrade bdPost=super.getInviteManager().findTradeById(post);
			BdJob bdJob=super.getInviteManager().findJobById(job);
			
			List salarylist= super.getInviteManager().findAllSalary();
			request.setAttribute("salarylist",salarylist);
			List www = (List) super.getInviteManager().findUserByName(user);
			UserInfo personCode = (UserInfo) www.get(0);
			List uuu = (List) super.getInviteManager().queryPersonResume(
					user);
			Object[] vvv = (Object[]) uuu.get(0);
			PersonResume resumeCode = (PersonResume) vvv[0];
			resumeCode.setState("0");
			super.getInviteManager().updatePersonResume(resumeCode);
			personCode.setLoginId(user);
			List oneApply=super.getInviteManager().findApplyJobInfoById(apllyId);
			Object[] ttt=(Object[])oneApply.get(0);
			ApplyJobInfo  applyJobInfo=(ApplyJobInfo)ttt[0];
	
			applyJobInfo.setPostCode(bdPost);
			applyJobInfo.setJobCode(bdJob);
			applyJobInfo.setWorkYear(workyears);
			applyJobInfo.setSalary(salary);
			applyJobInfo.setPersonCode(personCode);
			applyJobInfo.setResumeCode(resumeCode);		 
			//保存个人意向
			super.getInviteManager().updateApplyJobInfo(applyJobInfo);
			
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

}
