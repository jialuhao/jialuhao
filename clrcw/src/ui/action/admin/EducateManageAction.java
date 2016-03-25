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

public class EducateManageAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowJobAction.class);
	/**
     * 
     * 描述：显示所有的学历信息
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
				List<BdEducate> MEducate = (List<BdEducate>) super.getInviteManager().findAllBdEducate();
				HttpSession session = request.getSession(true);
				session.removeAttribute("MEducate");
				session.setAttribute("MEducate", MEducate);
				forward = IConstants.SUCCESS_KEY;
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
			return mapping.findForward(forward);
	}
	/**
     * 
     * 描述：添加学历信息
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
				String eduName=(String)request.getParameter("eduName");
				BdEducate oneEd=new BdEducate();
				oneEd.setDr("0");
				oneEd.setEducateName(eduName);
				super.getInviteManager().saveBdEducate(oneEd);
				return mapping.findForward("show");
			}catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
	}
	/**
     * 
     * 描述：删除学历信息
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
			String id=request.getParameter("delId");
			BdEducate oneEd=new BdEducate();
			oneEd=super.getInviteManager().findEducateById(id);
			super.getInviteManager().delBdBdEducate(oneEd);
			return mapping.findForward("show");
		}catch(Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}
}
