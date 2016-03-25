package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManaUser;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import util.JobShearchObject;
import util.PaginationSupport;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class DelUserAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DelUserAction.class);

	public ActionForward delUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String name = request.getParameter("qname");
			String mail = request.getParameter("qmail");
			
			String delId = (String) PropertyUtils.getSimpleProperty(form,
					"delId");
			List<UserInfo> eee = super.getInviteManager().findUserByName(delId);
			UserInfo userinfo = (UserInfo) eee.get(0);
			String userid = userinfo.getLoginId();
			super.getInviteManager().delUserinfo(userinfo);

			// SsoWebServicePortTypeProxy s = new SsoWebServicePortTypeProxy();
			// s.deleteMapUser(IConstants.APPNAME, userid);
			String pnum = (String) PropertyUtils
					.getSimpleProperty(form, "pnum");// 页码
			HttpSession session = request.getSession(true);
			int ppp = (Integer) session.getAttribute("totleCount");
			int tpn = ppp;// 总页数
			int pn = new Integer(pnum).intValue();// 页码
			int ddd;
			if (pn >= tpn) {
				ddd = tpn;
			} else if (pn <= 0) {
				ddd = 0;
			} else {
				ddd = pn;
			}
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List lisuser=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)lisuser.get(0);
			JobShearchObject object= new JobShearchObject();
			object.seteTime(mail);
			object.setQname(name);
			String areacode=manaUser.getAreacode();
			String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
			object.setComparea(areaname);
			PaginationSupport vvv = super.getInviteManager()
					.paginationUserInfo(object,ddd, 10, false);
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			session.removeAttribute("userInfo");
			session.removeAttribute("pagenum");
			session.setAttribute("userInfo", list);
			session.setAttribute("pagenum", ddd);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("qname", name);
			session.setAttribute("qmail", mail);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward(forward);

	}

	public ActionForward bathDelUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String name = request.getParameter("qname");
			String mail = request.getParameter("qmail");
			String[] arr = request.getParameterValues("ids");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					List<UserInfo> eee = super.getInviteManager()
							.findUserByName(arr[i]);
					UserInfo userinfo = (UserInfo) eee.get(0);
					super.getInviteManager().delUserinfo(userinfo);
				}
			}

			String pnum = (String) PropertyUtils
					.getSimpleProperty(form, "pnum");// 页码
			HttpSession session = request.getSession(true);
			int ppp = (Integer) session.getAttribute("totleCount");
			int tpn = ppp;// 总页数
			int pn = new Integer(pnum).intValue();// 页码
			int ddd;
			if (pn >= tpn) {
				ddd = tpn;
			} else if (pn <= 0) {
				ddd = 0;
			} else {
				ddd = pn;
			}
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List lisuser=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)lisuser.get(0);
			JobShearchObject object= new JobShearchObject();
			object.seteTime(mail);
			object.setQname(name);
			String areacode=manaUser.getAreacode();
			String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
			object.setComparea(areaname);
			PaginationSupport vvv = super.getInviteManager()
					.paginationUserInfo(object,ddd, 10, false);
			
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			session.removeAttribute("userInfo");
			session.removeAttribute("pagenum");
			session.setAttribute("userInfo", list);
			session.setAttribute("pagenum", ddd);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("qname", name);
			session.setAttribute("qmail", mail);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward(forward);

	}
	public ActionForward modifyUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			String delId = (String) PropertyUtils.getSimpleProperty(form,
					"delId");
			session.setAttribute("delId", delId);
			session.setAttribute("noUser", "");
			forward = "modify";
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward(forward);

	}
	
	public ActionForward savepassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		
		try {
			String newPassword = (String) PropertyUtils.getSimpleProperty(form,
			"newPassword");
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute(IConstants.ADMIN_USER_ID);
		
			
				// md5密码匹配
				
				    String id=(String)session.getAttribute("delId");
					String md5NewPassword = DigestUtils.md5Hex(newPassword);
					List<UserInfo> eee = super.getInviteManager().findUserByName(id);
					UserInfo userinfo = (UserInfo) eee.get(0);
					userinfo.setPassword(md5NewPassword);
					super.getInviteManager().updateUserinfo(userinfo);
					session.setAttribute("noUser", "修改密码成功");
				
			
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward("modify");

	}
}
