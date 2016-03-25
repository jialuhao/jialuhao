package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.PersonResume;
import model.PersonResumeB;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist4_1Action extends BaseAction {
	private static Logger logger = Logger
			.getLogger(PersonRegist4_1Action.class);

	/**
	 * 添加：修改审核状态信息（jialuhao）
	 * 描述：添加并返回添加后个人简历副表的全部内容（工作/实习经历）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist4_1(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			// 获取数据
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);

			List login = (List) super.getInviteManager().findUserByName(
					username);
			UserInfo userInfo = (UserInfo) login.get(0);
			String id = userInfo.getId() + "";

			// PersonResume personResume = (PersonResume)
			// super.getInviteManager().findPersonResumeById(id.trim());
			List vvv = super.getInviteManager().findPersonResumeById(id);
			Object[] ttt = (Object[]) vvv.get(0);
			PersonResume personResume = (PersonResume) ttt[0];
			personResume.setState("0");
			personResume.setOpinion("");
			super.getInviteManager().updatePersonResume(personResume);
			String stime = (String) request.getParameter("stime");
			String etime = (String) request.getParameter("etime");
			String post = (String) request.getParameter("post");
			String company = (String) request.getParameter("company");
			String work = (String) request.getParameter("work");
			// 组织数据
			PersonResumeB personResumeB = new PersonResumeB();
			personResumeB.setResume(personResume);
			personResumeB.setStartTime(stime);
			personResumeB.setEndTime(etime);
			personResumeB.setJob(post);
			personResumeB.setWorkUnit(company);
			personResumeB.setWorkContent(work);
			personResumeB.setUserLoginId(username);
			// 保存数据
			super.getInviteManager().savePersonResumeB(personResumeB);
			// 查询表数据
			List list = (List) super.getInviteManager().findPersonResumesById(
					username);
			request.setAttribute("resumeb", list);
			
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);

	}
}
