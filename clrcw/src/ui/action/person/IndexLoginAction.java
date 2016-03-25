package ui.action.person;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.PersonResume;
import model.UserInfo;

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

public class IndexLoginAction extends BaseAction {

	private static Logger logger = Logger.getLogger(IndexLoginAction.class);

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * 描述：首页个人登陆控制
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward indexLogin(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			// 获取页面的数据
			String username = (String) request.getParameter("userId");
			String password = (String) request.getParameter("password");
			// 获取该用户名的注册信息
			List list = this.authenticate(request);

			// 用户名不存在则返回不存在信息
			if (list.isEmpty()) {
				ActionMessages messages = new ActionMessages();
				messages.add("noUser", new ActionMessage("errors.user"));
				super.saveErrors(request, messages);
			} else {// 用户名存在，则登陆

				UserInfo sysUser = (UserInfo) list.get(0);
				// md5密码匹配
				String md5Password = DigestUtils.md5Hex(password);
				if (md5Password.equalsIgnoreCase(sysUser.getPassword())) {
					HttpSession session = request.getSession(true);
					// 添加登陆名和密码到session里
				//获得审核状态
					String reg="";
				List resume =  super.getInviteManager().queryPersonResume(username);
				if(resume.size()>0)	{
				Object[] eee=(Object[])resume.get(0);
					PersonResume personResume = (PersonResume)eee[0];
					String state=personResume.getState();
					if(state.equals("1")){
						state="审核未通过";
					}
					if(state.equals("0")){
						state="未审核";
					}	
					if(state.equals("2")){
						state="审核通过";
					}
					
					String opinion=personResume.getOpinion();
					if(opinion!=null&&!opinion.equals("")){
						opinion=":"+opinion;
					}else{
						opinion="";
					}
					session.removeAttribute("reg");
					session.setAttribute("reg", state+opinion);}
					session.removeAttribute(IConstants.PERSON_USER_ID);
             
					session.setAttribute(IConstants.PERSON_USER_ID, username);

					forward = IConstants.SUCCESS_KEY;
				} else {
					// 密码不匹配
					ActionMessages messages = new ActionMessages();
					messages
							.add("noUser", new ActionMessage("errors.password"));
					super.saveErrors(request, messages);
					 forward = IConstants.FAIL_KEY;
				}

			}
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

		return mapping.findForward(forward);
	}

	@SuppressWarnings("unchecked")
	private List authenticate(ServletRequest request) throws Exception {
		String username = (String) request.getParameter("userId");
		List list = super.getInviteManager().findUserByName(username);
		return list;
	}

}
