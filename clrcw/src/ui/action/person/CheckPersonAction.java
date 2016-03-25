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

public class CheckPersonAction extends BaseAction {

	private static Logger logger = Logger.getLogger(CheckPersonAction.class);

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
		try {
			// 获取前台数据
			String username = (String) request.getParameter("username");
			
			List list = this.authenticate(request);
			

			// 判断用户名是否已被使用
			if (list.isEmpty()) {
				
				
			} else {
				
				
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
