package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManaUser;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class DelManaUserAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DelUserAction.class);

	public ActionForward delAdmin(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String loginName = (String) PropertyUtils.getSimpleProperty(form,
					"loginName");
			List<ManaUser> vvv = super.getInviteManager().findManaUserByName(
					loginName);
			ManaUser manaUser = (ManaUser) vvv.get(0);
			manaUser.setDr("1");
			super.getInviteManager().delManaUser(manaUser);
			List<ManaUser> list = super.getInviteManager().findAllManaUser();
			HttpSession session = request.getSession(true);
			session.removeAttribute("allManaUser");
			session.setAttribute("allManaUser", list);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward(forward);

	}

}
