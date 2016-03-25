package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.UserInfo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;



import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class LoginAction extends BaseAction {

	private static Logger logger = Logger.getLogger(LoginAction.class);

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * 描述：个人登陆控制
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		response.addHeader("Set-Cookie", "uid=112;Path=/;HttpOnly");
		try {
			
			
			
			// 获取页面的数据
			String username = (String) PropertyUtils.getSimpleProperty(form,
					"userId");
			String password = (String) PropertyUtils.getSimpleProperty(form,
					"password");
			// 获取该用户名的注册信息
			List list = this.authenticate(form);
			HttpSession session = request.getSession();

			session.removeAttribute(IConstants.SSO_NAME);
			session.removeAttribute(IConstants.PERSON_USER_ID);
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
					// session = resquest.getSession(true);
					String ssoname = (String) session
							.getAttribute(IConstants.SSO_NAME);
					//SsoWebServicePortTypeProxy s = new SsoWebServicePortTypeProxy();
					//s.registerMapUser(ssoname, IConstants.APPNAME, username);
					// 添加登陆名和密码到session里
					session.removeAttribute(IConstants.PERSON_USER_ID);
					
					session.setAttribute(IConstants.PERSON_USER_ID, username);

					forward = IConstants.SUCCESS_KEY;
				} else {
					// 密码不匹配
					ActionMessages messages = new ActionMessages();
					messages
							.add("noUser", new ActionMessage("errors.password"));
					super.saveErrors(request, messages);
				}

			}
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

		return mapping.findForward(forward);
	}

	/**
	 * 
	 * 描述：注册个人用户
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward register(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {

			boolean exist = this.authenticate(form).isEmpty();
			if (!exist) {
				UserInfo userinfo = new UserInfo();
				BeanUtils.copyProperties(userinfo, form);
				super.getInviteManager().saveUserinfo(userinfo);
				// 保存前台的数据，插入数据库
				forward = IConstants.SUCCESS_KEY;
			}
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			// throw new BaseException(ex);

		}
		return mapping.findForward(forward); // 返回页。
	}

	/**
	 * 
	 * 描述：在页面中显示个人求职信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showAll(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		
		

		try {
			List<ApplyJobInfo> list = (List<ApplyJobInfo>) super
					.getInviteManager().findAllApplyJobInfo();
			if (list == null)
				return mapping.findForward("showInfo");
			else {
				request.setAttribute("allApplyJobInfo", list);
				return mapping.findForward("fail");
			}
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}

	@SuppressWarnings("unchecked")
	private List authenticate(ActionForm form) throws Exception {
		String loginName = (String) PropertyUtils.getSimpleProperty(form,
				"userId");
		List list = super.getInviteManager().findUserByName(loginName);
		return list;
	}

}
