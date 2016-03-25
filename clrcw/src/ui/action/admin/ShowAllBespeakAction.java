package ui.action.admin;

import javax.servlet.http.*;

import model.*;

import java.util.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.PaginationSupport;

import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class ShowAllBespeakAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowAllBespeakAction.class);

	/**
	 * 
	 * 描述：显示所有待审核注册的企业信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showAllBespeak(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String name = request.getParameter("qname");
			HttpSession session = request.getSession();
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List list=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)list.get(0);
			int pn = 0;
			int pageSize = 10;
			PaginationSupport vvv = super.getInviteManager().paginationshowAllBespeak(name,manaUser.getAreacode() ,pn, pageSize, true);
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

	public ActionForward nextShowAllBespeak(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String name = request.getParameter("qname");
			String area = request.getParameter("area");

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
			PaginationSupport vvv = super.getInviteManager()
					.paginationshowAllBespeak(name,area, ddd, pageSize, false);
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

	/**
	 * 
	 * 描述：查看待审核注册的企业信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward manaBespeak(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			String id = request.getParameter("id");
			CompBespeak oneComp = new CompBespeak();
	  
			CompInfo compInfo= new CompInfo();
			compInfo = super.getInviteManager().findCompInfoById(id);
			if (compInfo != null) {
				String kindId = compInfo.getType().getId().toString();
				BdCompkind kind = super.getInviteManager().findCompKindById(
						kindId);
				compInfo.setType(kind);
				String bd=compInfo.getBd().getId().toString();
				BdTrade trade=super.getInviteManager().findTradeById(bd);
				compInfo.setBd(trade);
			}

			oneComp = super.getInviteManager().findCompBespeakById(id);
			 if(oneComp!=null){
				   String area=	oneComp.getComparea();
				   Areacode areacode1=super.getInviteManager().findAreaCodeByarea(area);
				   String areaname=areacode1.getAreaname();
				   oneComp.setComparea(areaname);
			   }
			HttpSession session = request.getSession(false);
			session.setAttribute("oneComp", oneComp);
			session.setAttribute("compInfo", compInfo);
			return mapping.findForward("manaBespeak");
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
	}

	/**
	 * 
	 * 描述：确认审核
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward updateBespeak(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			HttpSession session = request.getSession(false);
			CompBespeak oneComp = (CompBespeak) session.getAttribute("oneComp");
			String id=oneComp.getId()+"";
            session.setAttribute("compid", id); 
			//			oneComp=super.getInviteManager().findCompBespeakById(id);
//			oneComp.setCompStatus("1");
//			super.getInviteManager().updateCompBespeak(oneComp);
			return mapping.findForward("show");
		

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
	}
	
	/**
	 * 
	 * 描述：审核信息保存
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward modifyBespeak(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			HttpSession session = request.getSession(false);
			String id=(String)session.getAttribute("compid");
			String status=request.getParameter("status");
			String opinion=request.getParameter("opinion");
			CompBespeak	oneComp=super.getInviteManager().findCompBespeakById(id);
			oneComp.setCompStatus(status);
			oneComp.setOpinion(opinion);
			super.getInviteManager().updateCompBespeak(oneComp);
			return mapping.findForward("showmessage");
		

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
	}


	/**
	 * 
	 * 描述：删除待审核注册的企业信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward delBespeak(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			String id = request.getParameter("id");
			CompBespeak oneComp = new CompBespeak();
			oneComp = super.getInviteManager().findCompBespeakById(id);
			if (oneComp.getId() == null)
				return mapping.findForward("show");
			else {
				super.getInviteManager().delCompBespeak(oneComp);

				return mapping.findForward("showmessage");
			}

		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
	}
	public ActionForward bathQYBespeak(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				try {
					String[] arr = request.getParameterValues("ids");
					if (arr != null && arr.length > 0) {
						for (int i = 0; i < arr.length; i++) {
							CompBespeak oneComp = new CompBespeak();
							
							oneComp = super.getInviteManager().findCompBespeakById(
									arr[i]);
							if (oneComp.getId() != null) {
								oneComp.setCompStatus("1");
								super.getInviteManager().updateCompBespeak(oneComp);
							}
						}
					}

					String name = request.getParameter("qname");
					String area = request.getParameter("area");

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
					PaginationSupport vvv = super.getInviteManager()
					.paginationshowAllBespeak(name,area, ddd, pageSize, true);
					int pc = 0;
					if (vvv.getTotalCount() == 10)
						pc = 0;
					else {
						pc = (int) Math.ceil(vvv.getTotalCount() / pageSize);
						if(vvv.getTotalCount()%pageSize==0){
							pc=pc-1;
						}
					}
					int contunt = vvv.getTotalCount();
					List list = (List) vvv.getItems();
					session.removeAttribute("bespeak");
					session.removeAttribute("pagenum");
					session.removeAttribute("zongshu");
					session.setAttribute("bespeak", list);
					session.setAttribute("pagenum", ddd);
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
	public ActionForward bathDelBespeak(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			String[] arr = request.getParameterValues("ids");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					CompBespeak oneComp = new CompBespeak();
					oneComp = super.getInviteManager().findCompBespeakById(
							arr[i]);
					if (oneComp.getId() != null) {
						super.getInviteManager().delCompBespeak(oneComp);
					}
				}
			}

			String name = request.getParameter("qname");
			String area = request.getParameter("area");

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
			PaginationSupport vvv = super.getInviteManager()
					.paginationshowAllBespeak(name,area, ddd, pageSize, false);
			int pc = 0;
			if (vvv.getTotalCount() == 10)
				pc = 0;
			else {
				pc = (int) Math.ceil(vvv.getTotalCount() / pageSize);
				if(vvv.getTotalCount()%pageSize==0){
					pc=pc-1;
				}
			}
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			session.removeAttribute("bespeak");
			session.removeAttribute("pagenum");
			session.removeAttribute("zongshu");
			session.setAttribute("bespeak", list);
			session.setAttribute("pagenum", ddd);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("qname", name);
			session.setAttribute("totleCount", pc);
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
	public ActionForward modifypassword(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				try {
					HttpSession session = request.getSession(true);
					String id = request.getParameter("id");
					session.setAttribute("id", id);
					session.setAttribute("noUser", "");
					forward = "modify";

				}  catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward(forward);
			}
	public ActionForward savepassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		
		try {
			String newPassword = request.getParameter("newPassword");
			
			HttpSession session = request.getSession();
			
		
			
				// md5密码匹配
				
				    
					String md5NewPassword = DigestUtils.md5Hex(newPassword);
					String id =(String) session.getAttribute("id");
					CompBespeak oneComp = new CompBespeak();
					oneComp = super.getInviteManager().findCompBespeakById(id);
					oneComp.setPassword(md5NewPassword);
					super.getInviteManager().updateCompBespeak(oneComp);
					session.setAttribute("noUser", "修改密码成功");
				
			
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward("modify");

	}
}
