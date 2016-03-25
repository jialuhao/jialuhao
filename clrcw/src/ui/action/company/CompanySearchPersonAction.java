package ui.action.company;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.PublishJobInfo;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import ui.action.person.LoginAction;
import util.PaginationSupport;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompanySearchPersonAction extends BaseAction {
	private static Logger logger = Logger
			.getLogger(CompanySearchPersonAction.class);

	/**
	 * 
	 * 描述：在页面中显示个人求职信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showAll(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			HttpSession session = request.getSession();
			String compId = (String) session
			.getAttribute(IConstants.COMP_USER_ID);
			String search = request.getParameter("zhiwei");
			String workstate = (String) PropertyUtils.getSimpleProperty(form,
					"workstate");
			String area = (String) PropertyUtils
					.getSimpleProperty(form, "area");
			String workarea = (String) PropertyUtils.getSimpleProperty(form,
					"workarea");
			int pageIndex = 0;
			int pageSize = 5;
			boolean desc = true;
			PaginationSupport pagin = super.getInviteManager().paginationS(
					null, pageIndex, pageSize, desc);
			List<?> list = pagin.getItems();
			int personTotalCount = pagin.getTotalCount();
			int tpn = (int) Math.ceil((personTotalCount - 1) / pageSize)+1;
			List<ApplyJobInfo> all = new ArrayList<ApplyJobInfo>();
			ApplyJobInfo oneApply = new ApplyJobInfo();
			if (list == null)
				return mapping.findForward(IConstants.FAIL_KEY);
			else {
				for (int i = 0; i < list.size(); i++) {
					oneApply = (ApplyJobInfo) list.get(i);
					//判断是否已经加入人才库
					String createtime=oneApply.getCreateTime();
					createtime=createtime.substring(0, 10);
					oneApply.setCreateTime(createtime);
					String resumeKey = oneApply.getResumeCode().getId().toString();
					String isNo = super.getInviteManager().findFileByResumeId(
							resumeKey, compId);
					String a="未加入";
					if(isNo!=null&&"1".equals(isNo)){
						a="已加入";
					}
					
					oneApply.setIsNo(a);
					all.add(oneApply);
				}
				List arealist= super.getInviteManager().findAllAreaCode();
				request.setAttribute("arealist", arealist);

				request.setAttribute("allApplyJobInfo", all);
				request.setAttribute("pageIndex", pageIndex);
				
				session.removeAttribute("search");
				session.setAttribute("search", search);
				session.removeAttribute("personTotalCount");
				session.setAttribute("personTotalCount", personTotalCount);
				session.removeAttribute("tpn");
				session.setAttribute("tpn", tpn);
				return mapping.findForward(IConstants.SUCCESS_KEY);
			}
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			ActionMessages messages = new ActionMessages();
			messages.add("error", new ActionMessage("error.DB"));
			super.saveErrors(request, messages);
			return mapping.findForward(IConstants.ERROR_KEY);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			ActionMessages messages = new ActionMessages();
			messages.add("error", new ActionMessage("error.inform"));
			super.saveErrors(request, messages);
			return mapping.findForward(IConstants.ERROR_KEY);
		}
	}

	/**
	 * 
	 * 描述：显示其他页的信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */

	public ActionForward showOtherPage(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		try {
			HttpSession session = request.getSession(true);
			
			String compId = (String) session
			.getAttribute(IConstants.COMP_USER_ID);
			String search = (String) PropertyUtils.getSimpleProperty(form,
					"zhiwei");
			search = (String) request.getParameter("zhiwei");
			String workstate = (String) PropertyUtils.getSimpleProperty(form,
					"workstate");
			String area = (String) PropertyUtils
					.getSimpleProperty(form, "area");
			String workarea = (String) PropertyUtils.getSimpleProperty(form,
					"workarea");
			int pageSize = 5;
			// String pnum=(String)session.getAttribute("pageIndex");
			String pnum = (String) PropertyUtils.getSimpleProperty(form,
					"pageIndex");

			int personTotalCount = (Integer) session
					.getAttribute("personTotalCount");
			int tpn = (int) Math.ceil(personTotalCount / pageSize);
			int pn = new Integer(pnum).intValue();
			int ddd;
			if (pn >= tpn) {
				ddd = tpn;
			} else if (pn <= 0) {
				ddd = 0;
			} else {
				ddd = pn;
			}
			ApplyJobInfo applyJobInfo = new ApplyJobInfo();
			model.BdJob jobCode = new model.BdJob();
			UserInfo userInfo = new UserInfo();
			userInfo.setArea(area);
			jobCode.setDr(workstate);
			jobCode.setJobName(search);
			applyJobInfo.setJobCode(jobCode);
			applyJobInfo.setWorkYear(workarea);
			applyJobInfo.setPersonCode(userInfo);
			PaginationSupport pagin = super.getInviteManager()
					.paginationStrategy(applyJobInfo, ddd, pageSize, true);
			List<?> list = pagin.getItems();
			List<ApplyJobInfo> all = new ArrayList<ApplyJobInfo>();
			ApplyJobInfo oneApply = new ApplyJobInfo();
			for (int i = 0; i < list.size(); i++) {
				oneApply = (ApplyJobInfo) list.get(i);
				String createtime=oneApply.getCreateTime();
				createtime=createtime.substring(0, 10);
				oneApply.setCreateTime(createtime);
				String resumeKey = oneApply.getResumeCode().getId().toString();
				String isNo = super.getInviteManager().findFileByResumeId(
						resumeKey, compId);
				String a="未加入";
				if(isNo!=null&&"1".equals(isNo)){
					a="已加入";
				}
				oneApply.setIsNo(a);
				all.add(oneApply);
			}
			List arealist= super.getInviteManager().findAllAreaCode();
			request.setAttribute("arealist", arealist);
			personTotalCount = pagin.getTotalCount();
			tpn = pagin.getPageCount();
			request.setAttribute("allApplyJobInfo", all);
			request.setAttribute("pageIndex", ddd);
			session.removeAttribute("personTotalCount");
			session.setAttribute("personTotalCount", personTotalCount);
			session.removeAttribute("tpn");
			session.setAttribute("tpn", tpn);
			request.setAttribute("search", search);
			request.setAttribute("area", area);
			request.setAttribute("workarea", workarea);
			request.setAttribute("workstate", workstate);

			
			return mapping.findForward(IConstants.SUCCESS_KEY);
		} catch (BusinessException be) {
			logger.error(be.getMessage(), be);
			throw new BaseException(be);
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
	}
}
