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

public class ShowJobAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowJobAction.class);

	public ActionForward showJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			List bdJob = (List) super.getInviteManager().findAllBdJob();
			HttpSession session = request.getSession(true);
			session.removeAttribute("bdjob");
			session.setAttribute("bdjob", bdJob);
			// request.setAttribute("bdJob", bdJob);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			 throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
	public ActionForward showJobAll(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {

				String forward = IConstants.FAIL_KEY;
				try {
					List bdJob = (List) super.getInviteManager().findAllBdJob();
					HttpSession session = request.getSession(true);
					session.removeAttribute("bdjob");
					session.setAttribute("bdjob", bdJob);
					// request.setAttribute("bdJob", bdJob);
					forward = "zhiye";

				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					 throw new BaseException(ex);

				}

				return mapping.findForward(forward);
			}
}
