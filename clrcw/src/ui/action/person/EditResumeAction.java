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

public class EditResumeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(EditResumeAction.class);

	/**
	 * 
	 * 描述：修改简历副表，编辑工作/实习经历
	 * 添加：修改审核状态信息（jialuhao）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward editResume(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;

		try {
			// 获取登陆名，密码，行号
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			
			String rbid = (String)request.getParameter("rbid");
			// 查询登陆信息
			List login = (List) super.getInviteManager().findUserByName(username);
			UserInfo userInfo = (UserInfo) login.get(0);
			String id = userInfo.getId() + "";
			List resume =  super.getInviteManager().queryPersonResume(username);
			Object[] eee=(Object[])resume.get(0);
			PersonResume personResume = (PersonResume)eee[0];
			personResume.setState("0");
			personResume.setOpinion("");
			super.getInviteManager().updatePersonResume(personResume);
			String stime = (String) PropertyUtils.getSimpleProperty(form,
					"stime");
			String etime = (String) PropertyUtils.getSimpleProperty(form,
					"etime");
			String post = (String) PropertyUtils
					.getSimpleProperty(form, "post");
			String company = (String) PropertyUtils.getSimpleProperty(form,
					"company");
			String work = (String) PropertyUtils
					.getSimpleProperty(form, "work");
			// 组织修改完的数据
			PersonResumeB personResumeB =new PersonResumeB();
			List<PersonResumeB> list = super.getInviteManager()
					.findPersonResumesById(username);
			for (int i = 0; i < list.size(); i++) {
				personResumeB = (PersonResumeB) list.get(i);
				if (personResumeB.getId() == (new Integer(rbid).intValue()))
					break;
			}
			
//			PersonResumeB personResumeB = (PersonResumeB)list.get(0);
			personResumeB.setResume(personResume);
			personResumeB.setStartTime(stime);
			personResumeB.setEndTime(etime);
			personResumeB.setJob(post);
		
			personResumeB.setWorkUnit(company);
			personResumeB.setWorkContent(work);
			personResumeB.setId(new Integer(rbid).intValue());
			personResumeB.setUserLoginId(username);
			personResumeB.setDr("0");
//			personResumeB.setVersion(1);
			// 更新修改的数据
			super.getInviteManager().updatePersonResumeB(personResumeB);
			session.removeAttribute("rbid");
/*			// 组织返回的数据
			List<PersonResumeB> list = super.getInviteManager()
					.findPersonResumesById(username);
			request.setAttribute("resumeb", list);*/
			
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
}
