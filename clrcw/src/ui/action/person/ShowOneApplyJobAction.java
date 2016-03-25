package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.BdEducate;
import model.BdJob;
import model.BdPost;
import model.PersonResume;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class ShowOneApplyJobAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowOneApplyJobAction.class);

	/**
	 * 
	 * 描述：一条欲求职位的显示
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showOneApplyJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;

		try {
			String apllyId = (String) request.getParameter( "apllyId");
			HttpSession session = request.getSession(true);
			session.removeAttribute("apllyId");
			session.setAttribute("apllyId", apllyId);
			List bdPost = (List) super.getInviteManager().findAllBdPost();
			request.setAttribute("bdPost", bdPost);
			List bdJob = (List) super.getInviteManager().findAllBdJob();
			request.setAttribute("bdJob", bdJob);
			List salarylist= super.getInviteManager().findAllSalary();
			request.setAttribute("salarylist",salarylist);
			List applylist = super.getInviteManager().findApplyJobInfoById(apllyId);
			Object[] vvv=(Object[])applylist.get(0);
			ApplyJobInfo  apply=(ApplyJobInfo)vvv[0];
			request.setAttribute("apply", apply);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

}
