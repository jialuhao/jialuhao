package ui.action.company;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CompBespeak;
import model.PublishJobInfo;

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

public class IndextCLoginAction extends BaseAction {

	private static Logger logger = Logger.getLogger(IndextCLoginAction.class);

	/**
	 * 
	 * 描述：企业用户登陆action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward indextCLogin(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {

			String userId = (String) request.getParameter("userId");
			String password = (String) request.getParameter("password");
			List<CompBespeak> list = this.authenticate(request);

			if (list.isEmpty()) {
				ActionMessages messages = new ActionMessages();
				messages.add("noUser", new ActionMessage("errors.user"));
				super.saveErrors(request, messages);
			} else {
				String md5Password = DigestUtils.md5Hex(password);
				for (int i = 0; i < list.size(); i++) {
					CompBespeak compBespeak = (CompBespeak) list.get(i);
					// 判断md5密码相同且通过审核（status=1）
					if (md5Password.equals(compBespeak.getPassword())
							&& !"0".equals(compBespeak.getCompStatus())) {
						HttpSession session = request.getSession(true);
						List publishjob=super.getInviteManager().queryJobInfoById(userId);
  	  				   
						if(publishjob.size()>0){
			         
					    
						session.setAttribute("publishjob", publishjob);}
					    session.removeAttribute(IConstants.COMP_USER_ID);
						session.setAttribute(IConstants.COMP_USER_ID, userId);
						session.setAttribute("compBespeakId", compBespeak
								.getId());
						session.setAttribute("compBespeakInfo", compBespeak);
						return mapping.findForward(IConstants.SUCCESS_KEY);
					}
				}
				ActionMessages messages = new ActionMessages();
				messages.add("noUser", new ActionMessage("error.audi"));
				super.saveErrors(request, messages);

			}
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

		return mapping.findForward(forward);
	}

	private List<CompBespeak> authenticate(ServletRequest request)
			throws Exception {

		String userId = (String) request.getParameter("userId");

		// List list = null;
		List<CompBespeak> list = super.getInviteManager().queryCompUserById(
				userId);
		return list;
	}

}
