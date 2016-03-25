package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Areacode;
import model.BdEducate;
import model.Commoncode;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class AreaCodeManageAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowAreaCodeAction.class);
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			List<Areacode> MAreacode = super.inviteManager.findAllAreaCode();
			HttpSession session = request.getSession(true);
			session.removeAttribute("MAreacode");
			session.setAttribute("MAreacode", MAreacode);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

		return mapping.findForward(forward);
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws BaseException {
	
			try {
				String areacode=(String)request.getParameter("areacode");
				String areaname = (String)request.getParameter("areaname");
				Areacode oneAc=new Areacode();
				oneAc.setDr("0");
				oneAc.setAreacode(areacode);
				oneAc.setAreaname(areaname);
				super.getInviteManager().saveAreaCode(oneAc);
				return mapping.findForward("show");
			}catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
	}
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			String id = request.getParameter("delId");
			Areacode oneCode = new Areacode();
			
			oneCode = super.getInviteManager().findAreaCodeById(id);
			oneCode.setDr("1");
			super.getInviteManager().updateAreaCode(oneCode);
			return mapping.findForward("show");
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}
}
