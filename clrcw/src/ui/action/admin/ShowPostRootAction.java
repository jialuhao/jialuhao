package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class ShowPostRootAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowPostRootAction.class);

	public ActionForward showPostRoot(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			List bdPostRoot=super.getInviteManager().findAllBdPostRoot();
			HttpSession session = request.getSession(true);
			session.removeAttribute("bdPostRoot");
			session.setAttribute("bdPostRoot", bdPostRoot);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			 throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
}
