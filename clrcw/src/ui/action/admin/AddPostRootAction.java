package ui.action.admin;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BdPostRoot;
import model.BdPost;
import model.PublishJobInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class AddPostRootAction extends BaseAction {
	private static Logger logger = Logger.getLogger(AddPostRootAction.class);

	public ActionForward addPostRoot(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String postRootname = (String) request.getParameter("postRootname");
			BdPostRoot bdPostRoot = new BdPostRoot();
			bdPostRoot.setPostName(postRootname);
			HashSet<BdPost> bdPosts = new HashSet<BdPost>();
			bdPostRoot.setBdPosts(bdPosts);
			bdPostRoot.setDr("0");
			// HashSet<PublishJobInfo> infoSet = new HashSet<PublishJobInfo>();
			// vvv.setPostName(postname);
			// vvv.setPublishJobInfos(infoSet);
			// vvv.setDr("0");
			// vvv.setVersion((short) 1);
			super.getInviteManager().saveBdPostRoot(bdPostRoot);
//			List bdPost = (List) super.getInviteManager().findAllBdPost();
//			HttpSession session = request.getSession(true);
//			session.removeAttribute("bdPost");
//			session.setAttribute("bdPost", bdPost);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
}
