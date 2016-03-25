package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BdJob;
import model.PublishJobInfo;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.JobShearchObject;
import util.PaginationSupport;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class SHPublishJobAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DelJobAction.class);

	public ActionForward savePJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		HttpSession session = request.getSession(true);
		try {
			String id=(String)session.getAttribute("delId");
			String state=request.getParameter("status");
			String opinion=request.getParameter("opinion");
			PublishJobInfo jobinfo = super.getInviteManager()
			.findPublishJobById(id);
			jobinfo.setOpinion(opinion);
			jobinfo.setStatus(state);
			super.getInviteManager().updatePublishJobInfo(jobinfo);
			forward = "savePJob";
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);

	}
	public ActionForward updatePJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				HttpSession session = request.getSession(true);
				try {
					String delId = (String) PropertyUtils.getSimpleProperty(form,
							"delId");
					session.setAttribute("delId", delId);
					forward = IConstants.SUCCESS_KEY;
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);

				}

				return mapping.findForward(forward);

			}

	public ActionForward bathUpdatePJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		//查询条件
		String qname = request.getParameter("qy");
		String qjobid = request.getParameter("qjobid");
		String education = request.getParameter("education");
		String grading = request.getParameter("grading");
		String postId = request.getParameter("postId");
		String sex = request.getParameter("sex");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String sta = request.getParameter("sta");
		JobShearchObject object= new JobShearchObject();
		object.setEducation(education);
		object.seteTime(eTime);
		object.setGrading(grading);
		object.setPostId(postId);
		object.setQjobid(qjobid);
		object.setQname(qname);
		object.setSex(sex);
		object.setsTime(sTime);
		object.setSta(sta);
		try {
			String[] arr = request.getParameterValues("ids");
			String shjob = (String) request.getParameter("shjob");
			int pageSize = 10;// 设定显示行数
			String pnum = request.getParameter("pnum");// 页码
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					PublishJobInfo jobinfo = super.getInviteManager()
							.findPublishJobById(arr[i]);
					jobinfo.setId(Integer.parseInt(arr[i]));
					jobinfo.setStatus(shjob);
					if("1".equals(shjob)){
					jobinfo.setOpinion("不同意");}else{
						jobinfo.setOpinion("同意");	
					}
					super.getInviteManager().updatePublishJobInfo(jobinfo);
				}
			}
			HttpSession session = request.getSession(true);

			int ppp = (Integer) session.getAttribute("jobtotleCount");
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
			PaginationSupport vvv = super.getInviteManager().paginationSearchPublishJobInfo(object,ddd, pageSize, false);
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
			int contunt = vvv.getTotalCount();
			session.removeAttribute("jobInfo");
			session.removeAttribute("jobpagenum");
			session.setAttribute("jobzongshu", contunt);
			session.setAttribute("jobInfo", list);
			session.setAttribute("jobtotleCount", pc);
			session.setAttribute("jobpagenum", ddd);
			
			session.setAttribute("qy", qname);
			session.setAttribute("qjobid", qjobid);
			session.setAttribute("education", education);
			session.setAttribute("grading", grading);
			session.setAttribute("postId", postId);
			session.setAttribute("sex", sex);
			session.setAttribute("sTime", sTime);
			session.setAttribute("sta", sta);
			session.setAttribute("eTime", eTime);
			forward = "successupdate";
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);

	}

}
