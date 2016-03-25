package ui.action.admin;

import javax.servlet.http.*;

import model.*;

import java.util.*;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.PaginationSupport;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class ShowAllCompanyAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowAllBespeakAction.class);

	/**
	 * 
	 * 描述：显示所有注册的企业信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showAllCompany(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession();
			String name = request.getParameter("qname");
			int pn = 0;
			int pageSize = 10;
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List arealist=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)arealist.get(0);
			PaginationSupport vvv = super.getInviteManager()
					.paginationshowAllCompany("",name,manaUser.getAreacode() , pn, pageSize, true);

			int contunt = vvv.getTotalCount();
			int pc = 0;
			if (vvv.getTotalCount() == 10)
				pc = 0;
			else {
				pc = (int) Math.ceil(vvv.getTotalCount() / pageSize);
				if(vvv.getTotalCount()%pageSize==0){
					pc=pc-1;
				}
			}
			
			session.removeAttribute("totleCount");
			session.removeAttribute("bespeak");
			session.removeAttribute("pagenum");
			session.removeAttribute("zongshu");
			session.setAttribute("bespeak", vvv.getItems());
			session.setAttribute("pagenum", pn);
			session.setAttribute("totleCount", pc);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("qname", name);
			forward = IConstants.SUCCESS_KEY;
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

	/**
	 * 
	 * 描述：显示一个企业信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showOneCompany(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			String userId = request.getParameter("userId");
			CompInfo oneComp = new CompInfo();
			CompBespeak oneBespeak = new CompBespeak();
			oneComp = super.getInviteManager().findCompInfoById(userId);
			if (oneComp != null) {
				String kindId = oneComp.getType().getId().toString();
				BdCompkind kind = super.getInviteManager().findCompKindById(
						kindId);
				oneComp.setType(kind);
				String bd=oneComp.getBd().getId().toString();
				BdTrade trade=super.getInviteManager().findTradeById(bd);
				oneComp.setBd(trade);
			}

			oneBespeak = super.getInviteManager().findCompBespeakById(userId);
			if(oneBespeak!=null){
				   String area=	oneBespeak.getComparea();
				   Areacode areacode1=super.getInviteManager().findAreaCodeByarea(area);
				   String areaname=areacode1.getAreaname();
				   oneBespeak.setComparea(areaname);
			   }
			HttpSession session = request.getSession(false);
			session.setAttribute("oneBespeak", oneBespeak);
			session.setAttribute("compInfo", oneComp);

			return mapping.findForward("manaCompany");
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}

	/**
	 * 
	 * 描述：禁用一个企业信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward updateCompany(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			HttpSession session = request.getSession(false);
			CompBespeak Comp = (CompBespeak) session.getAttribute("oneBespeak");
			String id=Comp.getId()+"";
			Comp=super.getInviteManager().findCompBespeakById(id);
			super.getInviteManager().updateCompRegister(Comp);
			return mapping.findForward("show");
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}
	
	public ActionForward batchUpdateCompany(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			
			String[] arr = request.getParameterValues("ids");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					CompBespeak oneComp = new CompBespeak();
					oneComp = super.getInviteManager().findCompBespeakById(
							arr[i]);
					if (oneComp.getId() != null) {
						super.getInviteManager().updateCompRegister(oneComp);
					}
				}
			}
			String name = request.getParameter("qname");
			int pageSize = 10;
			String pnum = request.getParameter("pnum");// 页码
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
			List arealist=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)arealist.get(0);
			PaginationSupport vvv = super.getInviteManager()
					.paginationshowAllCompany("",name,manaUser.getAreacode() , ddd, pageSize, true);
			int contunt = vvv.getTotalCount();
			int pc = 0;
			if (vvv.getTotalCount() == 10)
				pc = 0;
			else {
				pc = (int) Math.ceil(vvv.getTotalCount() / pageSize);
				if(vvv.getTotalCount()%pageSize==0){
					pc=pc-1;
				}
			}
			List list = (List) vvv.getItems();
			session.removeAttribute("bespeak");
			session.removeAttribute("pagenum");
			session.removeAttribute("zongshu");
			session.setAttribute("bespeak", list);
			session.setAttribute("totleCount", ppp);
			session.setAttribute("pagenum", ddd);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("totleCount", pc);
			session.setAttribute("qname", name);
			return mapping.findForward("success");
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}

	}
	
	public ActionForward nextShowAllCompany(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			String name = request.getParameter("qname");
			int pageSize = 10;
			String pnum = request.getParameter("pnum");// 页码
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
			List arealist=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)arealist.get(0);
			PaginationSupport vvv = super.getInviteManager()
					.paginationshowAllCompany("",name,manaUser.getAreacode() , ddd, pageSize, false);
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			session.removeAttribute("bespeak");
			session.removeAttribute("pagenum");
			session.removeAttribute("zongshu");
			session.setAttribute("bespeak", list);
			session.setAttribute("pagenum", ddd);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("qname", name);
			forward = IConstants.SUCCESS_KEY;
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
}