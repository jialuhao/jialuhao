package ui.action.admin;

import javax.servlet.http.*;

import model.*;

import java.util.*;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.JobShearchObject;
import util.PaginationSupport;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class ListAllCompanyAction extends BaseAction {
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
			String workyear=request.getParameter("workyear");
			int pn = 0;
			int pageSize = 10;
			JobShearchObject object= new JobShearchObject();
			object.setQname(name);
			if(workyear!=null&&workyear!=""){
			String areacode=super.getInviteManager().findAreaCodeByname(workyear).getAreacode();
			object.setWorkyear(areacode);}
			
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List arealist=super.getInviteManager().findManaUserByName(loginName);
			
			ManaUser manaUser=(ManaUser)arealist.get(0);
			if(manaUser.getAreacode().equals("110100")){
				session.setAttribute("areacode1", "areacode");
			}else{
				session.setAttribute("areacode1", "");
			}
			object.setComparea(manaUser.getAreacode());
			PaginationSupport vvv = super.getInviteManager()
					.paginationlcompanymessage(object,pn, pageSize);

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
			session.setAttribute("workyear", workyear);
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
			List<?> list=super.getInviteManager().queryJobInfoById(oneBespeak.getUserId());
			List<PublishJobInfo> jobInfo=new ArrayList<PublishJobInfo>();
			for(int i=0;i<list.size();i++){
				Object[] o=(Object[])list.get(i);
				PublishJobInfo job=(PublishJobInfo)o[0];
				jobInfo.add(job);
			}
			session.setAttribute("job", jobInfo);
			request.setAttribute("job",jobInfo);

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
			String workyear=request.getParameter("workyear");
			
			
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
			
			JobShearchObject object= new JobShearchObject();
			object.setQname(name);
			if(workyear!=null&&workyear!=""){
			String areacode=super.getInviteManager().findAreaCodeByname(workyear).getAreacode();
			object.setWorkyear(areacode);}
			object.setQname(name);
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List arealist=super.getInviteManager().findManaUserByName(loginName);
			
			ManaUser manaUser=(ManaUser)arealist.get(0);
			object.setComparea(manaUser.getAreacode());
			PaginationSupport vvv = super.getInviteManager()
					.paginationlcompanymessage(object,pn, pageSize);
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			session.removeAttribute("bespeak");
			session.removeAttribute("pagenum");
			session.removeAttribute("zongshu");
			session.setAttribute("bespeak", list);
			session.setAttribute("pagenum", ddd);
			session.setAttribute("workyear", workyear);
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