package ui.action.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CompBespeak;

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

public class ModifyPasswordAction extends BaseAction {

	private static Logger logger = Logger.getLogger(ModifyPasswordAction.class);

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * 描述：个人用户修改密码
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	@Override
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.SUCCESS_KEY;
		try {
			// 获取页面的数据
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute(IConstants.COMP_USER_ID);
			String password = (String) PropertyUtils.getSimpleProperty(form,
					"password");
			String newPassword = (String) PropertyUtils.getSimpleProperty(form,
			"newPassword");
			// 获取该用户名的注册信息
			List list = super.getInviteManager().queryCompUserById(username);
			// 用户名不存在则返回不存在信息
			if (list.isEmpty()) {
				ActionMessages messages = new ActionMessages();
				messages.add("noUser", new ActionMessage("errors.user"));
				super.saveErrors(request, messages);
			} else {// 用户名存在，则登陆

				CompBespeak compUser = (CompBespeak) list.get(0);
				// md5密码匹配
				String md5Password = DigestUtils.md5Hex(password);
				if (md5Password.equalsIgnoreCase(compUser.getPassword())) {
					String md5NewPassword = DigestUtils.md5Hex(newPassword);
					compUser.setPassword(md5NewPassword);
					super.getInviteManager().updateCompBespeak(compUser);
					
					ActionMessages messages = new ActionMessages();
					messages
					.add("noUser", new ActionMessage("modify.password.success"));
					super.saveErrors(request, messages);
				} else {
					// 密码不匹配
					ActionMessages messages = new ActionMessages();
					messages
							.add("noUser", new ActionMessage("errors.password"));
					super.saveErrors(request, messages);
				}
			}
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
}
