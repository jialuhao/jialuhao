package ui.action.person;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist1Action extends BaseAction {

	private static Logger logger = Logger.getLogger(PersonRegist1Action.class);

	/**
	 * 
	 * 描述：个人注册第一步
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist1(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		forward = IConstants.SUCCESS_KEY;
		try {
			// 获取前台数据
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			// String password2 = (String) request.getParameter("password2");
			String email = (String) request.getParameter("email");
			String ceshi=(String)request.getParameter("ceshi");
			
			System.out.println(ceshi);
			List list = this.authenticate(request);
	

			// 判断用户名是否已被使用
			if (list.isEmpty()) {
				// 保存前台的数据，插入数据库
				UserInfo userinfo = new UserInfo();
				userinfo.setLoginId(username);
				//md5Password
				HttpSession session = request.getSession(true);
				String md5Password = DigestUtils.md5Hex(password);
				String area=(String)session.getAttribute("red_add");//户籍所在地
				userinfo.setArea(area);
				userinfo.setPassword(md5Password);
				userinfo.setMailAddr(email);
				super.getInviteManager().saveUserinfo(userinfo);
				
				
				session.setAttribute(IConstants.PERSON_USER_ID, username);
				
				List bdEducate = (List) super.inviteManager.findAllBdEducate();
				request.setAttribute("bdEducate", bdEducate);
				forward = IConstants.SUCCESS_KEY;
			} else {
				ActionMessages messages = new ActionMessages();
				messages.add("user", new ActionMessage("loginForm.isExsist"));
				super.saveErrors(request, messages);
				
				return mapping.findForward("fail");
			}

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

	// 查询用户列表
	private List authenticate(ServletRequest request) throws Exception {
		String loginName = (String) request.getParameter("username");
		List list = super.getInviteManager().findUserByName(loginName);
		return list;
	}

}
