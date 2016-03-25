package ui.action.admin;

import java.util.HashSet; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BdJob;
import model.PublishJobInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class AddJobAction extends BaseAction {
	private static Logger logger = Logger.getLogger(AddJobAction.class);

	public ActionForward addJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String jobname = (String) request.getParameter("jobname");
			BdJob vvv = new BdJob();
			HashSet<PublishJobInfo> infoSet = new HashSet<PublishJobInfo>();
			vvv.setJobName(jobname);
			vvv.setPublishJobInfos(infoSet);
			vvv.setDr("0");
			vvv.setVersion((short) 1);
			super.getInviteManager().saveBdJob(vvv);
			List bdjob = (List) super.getInviteManager().findAllBdJob();
			HttpSession session = request.getSession(true);
			session.removeAttribute("bdjob");
			session.setAttribute("bdjob", bdjob);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
}
