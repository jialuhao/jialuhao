package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManaUser;

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

public class AddAdminAction extends BaseAction {
	private static Logger logger = Logger.getLogger(AddAdminAction.class);

	public ActionForward addAdmin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			String adminName = (String) request.getParameter("adminName");
			String password = (String) request.getParameter("password");
			String areacode = (String) request.getParameter("areacode");

			List<ManaUser> adminList = super.getInviteManager()
					.findManaUserByName(adminName);
			boolean exist = !adminList.isEmpty();
			if (exist) {
				ActionMessages messages = new ActionMessages();
				messages.add("user", new ActionMessage("loginForm.isExsist"));
				super.saveErrors(session, messages);
				forward = "nouser";
			} else {
				ManaUser manaUser = new ManaUser();
				manaUser.setAccount(adminName);
				// md5
				String md5Password = DigestUtils.md5Hex(password);
				manaUser.setPassword(md5Password);
				manaUser.setAreacode(areacode);

				
				manaUser.setDr("0");
				super.getInviteManager().saveManaUser(manaUser);
				List<ManaUser> list = super.getInviteManager()
						.findAllManaUser();

				session.removeAttribute("allManaUser");
				session.setAttribute("allManaUser", list);
				forward = IConstants.SUCCESS_KEY;
			}
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

		return mapping.findForward(forward);
	}
}
