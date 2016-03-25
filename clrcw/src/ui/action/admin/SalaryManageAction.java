package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Areacode;
import model.BdEducate;
import model.Commoncode;
import model.BdSalary;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class SalaryManageAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowAreaCodeAction.class);
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			List<BdSalary> MSalary = super.inviteManager.findAllSalary();
			HttpSession session = request.getSession(true);
			session.removeAttribute("MSalary");
			session.setAttribute("MSalary", MSalary);
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
				String salarycode=(String)request.getParameter("salarycode");
				String salaryname = (String)request.getParameter("salaryname");
				BdSalary oneAc=new BdSalary();
				oneAc.setDr("0");
				oneAc.setSalarycode(salarycode);
				oneAc.setSalaryname(salaryname);
				super.getInviteManager().saveSalary(oneAc);
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
			BdSalary oneCode = new BdSalary();
			
			oneCode = super.getInviteManager().findSalaryById(id);
			oneCode.setDr("1");
			super.getInviteManager().updateSalary(oneCode);
			return mapping.findForward("show");
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}
}
