package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PersonResume;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist5Action extends BaseAction {

	private static Logger logger = Logger.getLogger(PersonRegist5Action.class);

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * 描述：显示个人简介
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist5(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
		

			PersonResume personResume = new PersonResume();
			// 通过用户名查询个人简介
			List eee = (List) super.getInviteManager().queryPersonResume(
					username);
			Object[] vvv = (Object[]) eee.get(0);
			personResume = (PersonResume) vvv[0];
			String inte = personResume.getInterests();
			String sss = personResume.getIntroSelf();
			if(inte==null){
				inte="";
			}
			if(sss==null){
				sss="";
			}
         List<?> list11=super.inviteManager.queryApplyJobBypersonId(username);
			if(list11.size()==0){
				request.setAttribute("notapply","notapply");
			}
			request.setAttribute("intro", sss);
			request.setAttribute("interests", inte);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}

}
