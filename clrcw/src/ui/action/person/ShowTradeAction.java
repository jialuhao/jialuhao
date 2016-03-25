package ui.action.person;

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

public class ShowTradeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowTradeAction.class);

	public ActionForward showTrade(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			List bdTrade = (List) super.getInviteManager().findAllBdTrade();
			HttpSession session = request.getSession(true);
			session.removeAttribute("bdtrade");
			session.setAttribute("bdtrade", bdTrade);
			// request.setAttribute("bdJob", bdJob);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			 throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
	public ActionForward showTradeAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				try {
					String postid = (String) request.getParameter("postid");
					
					List bdTrade = (List) super.getInviteManager().findAllBdTrade();
					HttpSession session = request.getSession(true);
					session.removeAttribute("bdtrade");
					session.setAttribute("bdtrade", bdTrade);
					session.removeAttribute("postid");
					session.setAttribute("postid", postid);
					// request.setAttribute("bdJob", bdJob);
					forward = "hangye";

				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					 throw new BaseException(ex);
				}
				return mapping.findForward(forward);
			}
}
