package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PersonResume;
import model.UserInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class GoOnRegistAction extends BaseAction {

	private static Logger logger = Logger.getLogger(GoOnRegistAction.class);

	/**
	 * 
	 * 描述：继续填写个人资料
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward goOnRegist(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session=request.getSession();
			String area=(String)request.getParameter("area");
			String username=(String)request.getParameter("username");
			List<UserInfo> list= super.inviteManager.findUserByName(username);
			UserInfo userInfo=new UserInfo();
			userInfo=list.get(0);
			userInfo.setArea(area);
			super.inviteManager.updateUserinfo(userInfo);
		
			PersonResume personResume = new PersonResume();
			
			request.setAttribute("pr", personResume);
			List bdEducate = (List) super.inviteManager.findAllBdEducate();
			List bdPost = (List) super.inviteManager.findAllBdPost();
			request.setAttribute("bdPost", bdPost);
			request.setAttribute("bdEducate", bdEducate);
			
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

}
