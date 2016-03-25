package ui.action.admin;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BdEducate;
import model.BdPost;
import model.BdPostRoot;
import model.PublishJobInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class AddPostAction extends BaseAction {
	private static Logger logger = Logger.getLogger(AddPostAction.class);

	public ActionForward addPost(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String postname = (String) request.getParameter("postname");
			String postRoot = (String) request.getParameter("postRoot");
			BdPost vvv = new BdPost();
			HashSet<PublishJobInfo> infoSet = new HashSet<PublishJobInfo>();
			vvv.setPostName(postname);
			vvv.setPublishJobInfos(infoSet);

			
			//vvv.setDr("0");
			//vvv.setVersion((short) 1);
			//BdPostRoot postIdRoot = new BdPostRoot();
			//BdPostRoot tt = new BdPostRoot();
			BdPostRoot tt =  super.getInviteManager().findPostRootById(postRoot);
			
			/*
			for(int i = 0; i < ttt.size(); i++){
				tt = (BdPostRoot) ttt.get(i);
				int j = tt.getId();
				if (new Integer(postRoot).intValue() == j) {
					break;
				}
			}
			*/
			vvv.setPostIdRoot(tt);
			super.getInviteManager().saveBdPost(vvv);
			List<BdPost> bdPost = super.getInviteManager().findAllBdPost();
			HttpSession session = request.getSession(true);
			session.removeAttribute("bdPost");
			session.setAttribute("bdPost", bdPost);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
}
