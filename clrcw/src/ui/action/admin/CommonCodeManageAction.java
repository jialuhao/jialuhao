package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Commoncode;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class CommonCodeManageAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowCommonCodeAction.class);

	/**
	 * 描述：显示所有commoncode信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			List<Commoncode> MCommoncode = super.inviteManager
					.findAllCommonCode();

			HttpSession session = request.getSession(true);
			session.removeAttribute("MCommoncode");
			session.setAttribute("MCommoncode", MCommoncode);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

		return mapping.findForward(forward);
	}

	/**
	 * 描述：添加commoncode信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.SUCCESS_KEY;
		try {
			String code = request.getParameter("code");
			String commonvalues = request.getParameter("commonvalues");
			List<Commoncode> comcode = (List<Commoncode>) super
					.getInviteManager().findAllCommonCode();
			Commoncode comc = new Commoncode();
			for (int i = 0; i < comcode.size(); i++) {
				comc = comcode.get(i);
				comc.setCommonvalues(commonvalues);
				super.getInviteManager().updateCommonCode(comc);
				
			}			
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward("show");
	}
	
	/**
	 * 描述：删除commoncode信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			String id = request.getParameter("delId");
			Commoncode oneCode = new Commoncode();
			oneCode = super.getInviteManager().findCommonCodeById(id);
			oneCode.setDr("1");
			super.getInviteManager().updateCommonCode(oneCode);
			return mapping.findForward("show");
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}

}