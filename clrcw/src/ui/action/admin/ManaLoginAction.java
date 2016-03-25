package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManaUser;

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

public class ManaLoginAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ManaLoginAction.class);

	/**
	 * 
	 * 描述：管理员登录验证
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
		try {
			String account = (String) PropertyUtils.getSimpleProperty(form,
					"account");
			String password = (String) PropertyUtils.getSimpleProperty(form,
					"password");
			HttpSession session = request.getSession();
			List<ManaUser> list2 = super.getInviteManager().findManaUserByName(
					account);

			if (list2.isEmpty()) {
				ActionMessages messages = new ActionMessages();
				messages.add("nou", new ActionMessage("errors.user"));
				super.saveErrors(session, messages);
				return mapping.findForward(forward);
			} else {
				for (int i = 0; i < list2.size(); i++) {
					ManaUser user = list2.get(i);
					// md5
					String md5Password = DigestUtils.md5Hex(password);
					//System.out.println("md5Password"+md5Password);
					if (md5Password.equals(user.getPassword())) {
						session.removeAttribute(IConstants.ADMIN_USER_ID);
						session.setAttribute(IConstants.ADMIN_USER_ID, account);
						if("110100".equals(user.getAreacode())){
							return mapping.findForward(IConstants.SUCCESS_KEY);
							
						}else{
							
							return mapping.findForward("successacre");
						}
					}
				}
				
				ActionMessages messages = new ActionMessages();
				messages.add("nop", new ActionMessage("errors.password"));
				super.saveErrors(session, messages);
			}
		}

		catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

		return mapping.findForward(forward);
	}

	/**
	 * 
	 * 描述:退出登录
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward loginOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			session.invalidate();
			ActionMessages messages = new ActionMessages();
			messages.add("out", new ActionMessage("login.out"));
			super.saveErrors(request, messages);
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
		}
		return mapping.findForward(forward);
	}
	public ActionForward checkmessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			int pn=0;
			int pageSize=10;
			JobShearchObject object= new JobShearchObject();
			object.setSta("0");
			String account=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List lisuser=super.getInviteManager().findManaUserByName(account);
			ManaUser manaUser=(ManaUser)lisuser.get(0);
			String areacode=manaUser.getAreacode();
			String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
			object.setComparea(areaname);
			PaginationSupport vvv = super.getInviteManager().paginationpersonresume(object,pn, pageSize, true);
			int number1=vvv.getTotalCount();//求职信息未审核条数
			session.setAttribute("number1", number1);
			PaginationSupport vvv1 = super.getInviteManager().paginationshowAllBespeak("",manaUser.getAreacode() ,pn, pageSize, true);
			int number2=vvv1.getTotalCount();//资质审核未审核条数
			session.setAttribute("number2", number2);
			JobShearchObject object1= new JobShearchObject();
			object1.setSta("0");
			object1.setComparea(areacode);
			PaginationSupport vvv3 = super.getInviteManager().paginationSearchPublishJobInfo(object1,pn, pageSize, true);
			int number3=vvv3.getTotalCount();//招聘信息未审核条数
			session.setAttribute("number3", number3);
			forward="checkmessage";
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
		}
		return mapping.findForward(forward);
	}

}
