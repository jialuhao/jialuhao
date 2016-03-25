package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import model.*;
import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class CompkindManageAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowJobAction.class);
	/**
     * 
     * 描述：显示所有的企业类型信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws Exception 
     */
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws BaseException {
			String forward = IConstants.FAIL_KEY;
			try {
				List<BdCompkind> MCompkind = (List<BdCompkind>) super.getInviteManager().findAllBdCompKind();
				HttpSession session = request.getSession(true);
				session.removeAttribute("MCompkind");
				session.setAttribute("MCompkind", MCompkind);
				forward = IConstants.SUCCESS_KEY;
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
			return mapping.findForward(forward);
	}
	/**
     * 
     * 描述：添加企业类型信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws Exception 
     */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws BaseException {
			
			try {
				String kindName=(String)request.getParameter("kindName");
				BdCompkind oneKind=new BdCompkind();
				oneKind.setDr("0");
				oneKind.setCompTypeName(kindName);
				super.getInviteManager().saveBdCompKind(oneKind);
				return mapping.findForward("show");
			}catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
	}
	/**
     * 
     * 描述：删除企业类型
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws Exception 
     */
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws BaseException {
		try{
			String id=request.getParameter("id");
			BdCompkind oneKind=new BdCompkind();
			oneKind=super.getInviteManager().findCompKindById(id);
			super.getInviteManager().delBdCompkind(oneKind);
			return mapping.findForward("show");
		}catch(Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}
}
