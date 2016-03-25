package ui.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.ManaUser;
import model.PersonResume;
import model.PublishJobInfo;

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
/**
 * 
 * 描述：向jsp页面传递审核信息的内容
 * 

 */
public class FindApplyJob extends BaseAction {
	private static Logger logger = Logger.getLogger(FindApplyJob.class);

	public ActionForward findApplyJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session = request.getSession(true);

		String forward = IConstants.FAIL_KEY;
		String uname = request.getParameter("uname");
//		String qjobid = request.getParameter("qjobid");
		String postId = request.getParameter("postId");//残疾类别
		String sta = request.getParameter("sta");
//		String sTime = request.getParameter("sTime");
//		String eTime = request.getParameter("eTime");
//		String salary=request.getParameter("salary");
		String education=request.getParameter("education");
		String workyear=request.getParameter("workyear");
		JobShearchObject object= new JobShearchObject();
		object.setPostId(postId);
		//object.setQjobid(qjobid);
		object.setQname(uname);
		object.setSta(sta);
		//object.seteTime(eTime);
		//object.setsTime(sTime);
		object.setEducation(education);
		//object.setSalary(salary);
		object.setWorkyear(workyear);
		String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
		List lisuser=super.getInviteManager().findManaUserByName(loginName);
		ManaUser manaUser=(ManaUser)lisuser.get(0);
		 List bdPost = (List) super.inviteManager.findAllBdPost();
		if(manaUser.getAreacode().equals("110100")){
			session.setAttribute("areacode", "areacode");
		}else{
			session.setAttribute("areacode", "");
		}
		String areacode=manaUser.getAreacode();
		String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
		object.setComparea(areaname);
		try {
			int pn = 0;
			int pageSize = 10;
			PaginationSupport vvv = super.getInviteManager().paginationpersonresume(object,pn, pageSize, true);
			List list = (List) vvv.getItems();
			for (int i = 0; i < list.size(); i++) {
			PersonResume personResume = (PersonResume) list.get(i);
			String dkind=personResume.getDkind();
			dkind=(super.inviteManager.findPostById(dkind)).getPostName();
			personResume.setDkind(dkind);}
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
			session.removeAttribute("apptotleCount");
			session.removeAttribute("appInfo");
			session.removeAttribute("apppagenum");
			session.removeAttribute("appzongshu");
			session.setAttribute("personresume", list);
			session.setAttribute("apppagenum", pn);
			session.setAttribute("apptotleCount", pc);
			session.setAttribute("appzongshu", contunt);
			session.setAttribute("bdPost",bdPost);
			session.setAttribute("uname", uname);
			//session.setAttribute("qjobid", qjobid);
			session.setAttribute("postId", postId);
			session.setAttribute("sta", sta);
//			session.setAttribute("sTime", sTime);
//			session.setAttribute("eTime", eTime);
//			session.setAttribute("salary", salary);
			session.setAttribute("workyear", workyear);
			session.setAttribute("education", education);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}

	public ActionForward nextfindapp(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session = request.getSession(true);
		String forward = IConstants.FAIL_KEY;
		String uname = request.getParameter("uname");
//		String qjobid = request.getParameter("qjobid");
		String postId = request.getParameter("postId");
		String sta = request.getParameter("sta");
//		String sTime = request.getParameter("sTime");
//		String eTime = request.getParameter("eTime");
//		String salary=request.getParameter("salary");
		String education=request.getParameter("education");
		String workyear=request.getParameter("workyear");
		JobShearchObject object= new JobShearchObject();
		object.setPostId(postId);//残疾类别
		//object.setQjobid(qjobid);
		object.setQname(uname);
		object.setSta(sta);
		//object.seteTime(eTime);
		//object.setsTime(sTime);
		object.setEducation(education);
		//object.setSalary(salary);
		object.setWorkyear(workyear);//区县
		String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
		List lisuser=super.getInviteManager().findManaUserByName(loginName);
		ManaUser manaUser=(ManaUser)lisuser.get(0);
		
		
		String areacode=manaUser.getAreacode();
		String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
		object.setComparea(areaname);
		try {
			int pageSize = 10;// 设定显示行数
			String pnum = (String) PropertyUtils.getSimpleProperty(form,"apppnum");// 页码
			
			
			int ppp = (Integer) session.getAttribute("apptotleCount");
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
			PaginationSupport vvv = super.getInviteManager().paginationpersonresume(object,ddd, pageSize, false);
			List list = (List) vvv.getItems();
			for (int i = 0; i < list.size(); i++) {
				PersonResume personResume = (PersonResume) list.get(i);
				String dkind=personResume.getDkind();
				dkind=(super.inviteManager.findPostById(dkind)).getPostName();
				personResume.setDkind(dkind);}
			session.removeAttribute("appInfo");
			session.removeAttribute("apppagenum");
			session.setAttribute("personresume", list);
			session.setAttribute("apppagenum", ddd);
			
			session.setAttribute("uname", uname);
			//session.setAttribute("qjobid", qjobid);
			session.setAttribute("postId", postId);
			session.setAttribute("sta", sta);
//			session.setAttribute("sTime", sTime);
//			session.setAttribute("eTime", eTime);
//			session.setAttribute("salary", salary);
			session.setAttribute("workyear", workyear);
			session.setAttribute("education", education);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
	
	public ActionForward bathDelApplyJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {

		String forward = IConstants.FAIL_KEY;
		String uname = request.getParameter("uname");
		String qjobid = request.getParameter("qjobid");
		String postId = request.getParameter("postId");
		String sta = request.getParameter("sta");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String education = request.getParameter("eTime");
		JobShearchObject object= new JobShearchObject();
		object.setPostId(postId);
		object.setQjobid(qjobid);
		object.setQname(uname);
		object.seteTime(eTime);
		object.setsTime(sTime);
		object.setSta(sta);
		object.setEducation(education);
		
		try {
			
			String[] arr = request.getParameterValues("ids");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					
					List oneApply=super.getInviteManager().findApplyJobInfoById(arr[i]);
					Object[] ttt=(Object[])oneApply.get(0);
					ApplyJobInfo  applyJobInfo=(ApplyJobInfo)ttt[0];
					
					applyJobInfo.setDr("1");
					super.getInviteManager().updateApplyJobInfo(applyJobInfo);
				}
			}
			
			String pnum = request.getParameter("pnum");// 页码
			int pageSize = 10;// 设定显示行数
			HttpSession session = request.getSession(true);
			int ppp = (Integer) session.getAttribute("apptotleCount");
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
			PaginationSupport vvv = super.getInviteManager().paginationSearchAppJob(object,ddd, pageSize, false);
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			session.removeAttribute("appInfo");
			session.removeAttribute("apppagenum");
			session.setAttribute("appInfo", list);
			session.setAttribute("apppagenum", ddd);
			session.setAttribute("appzongshu", contunt);
			
			session.setAttribute("uname", uname);
			session.setAttribute("qjobid", qjobid);
			session.setAttribute("postId", postId);
			session.setAttribute("sta", sta);
			session.setAttribute("sTime", sTime);
			session.setAttribute("eTime", eTime);
			
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
	/**
	 * 
	 * 描述：个人简历预览内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward resumeView(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			// 获取简历内容
			String id = request.getParameter("userId");
			List eee = (List) super.getInviteManager().queryPersonResume(id);
			Object[] vvv = (Object[]) eee.get(0);
			PersonResume personResume = (PersonResume) vvv[0];
			String dkind=personResume.getDkind();
			dkind=(super.inviteManager.findPostById(dkind)).getPostName();
			personResume.setDkind(dkind);
//			String imageid=personResume.getFkPersonImage().getId().toString();
//			
//			PersonImage image=super.getInviteManager().findPersonImageById(imageid);
//
			String version="false";
			if(personResume.getFkPersonImage()!=null){
				version="true";
			}
			List list = (List) super.getInviteManager().findPersonResumesById(
					id);
			List applyList = super.getInviteManager().queryApplyJobById(id);
			List educations = super.getInviteManager().findEducationsById(id);
           // ApplyJobInfo userInfo = (ApplyJobInfo) list.get(i);//提取审核状态			
			//String state=userInfo.getDatatime();
			session.setAttribute("allapply", applyList);//求职信息
			session.setAttribute("resumeb", list);//工作/实习经历
			session.setAttribute("version", version);
			session.setAttribute("educations", educations);//教育培训经历
			session.setAttribute("pr", personResume);//基本情况
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward("resumeView");

	}
}
