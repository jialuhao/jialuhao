package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BdJob;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class DelJobAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DelJobAction.class);

	public ActionForward delJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String delId = (String) PropertyUtils.getSimpleProperty(form,
					"delId");

			BdJob bdJob = new BdJob();
			BdJob tt = new BdJob();
			bdJob.setId(new Integer(delId).intValue());

			List uuu = (List) super.getInviteManager().findAllBdJob();
			for (int i = 0; i < uuu.size(); i++) {
				tt = (BdJob) uuu.get(i);
				int j = tt.getId();
				if (bdJob.getId() == j) {

					break;
				}
			}
			super.getInviteManager().delBdJob(tt);
			List vvv = (List) super.getInviteManager().findAllBdJob();
			HttpSession session = request.getSession(true);
			session.removeAttribute("bdjob");
			session.setAttribute("bdjob", vvv);
			// request.setAttribute("bdjob", vvv);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			 throw new BaseException(ex);

		}

		return mapping.findForward(forward);

	}

}
