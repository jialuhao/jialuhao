package ui.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CompBespeak;
import model.CompInfo;
import model.ManaUser;
import model.PersonResume;
import model.PublishJobInfo;
import model.Recommends;
import model.Servicelog;
import model.Servicepeople;

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

public class FindPulishJob extends BaseAction {
	private static Logger logger = Logger.getLogger(FindPulishJob.class);

	public ActionForward findAllpublishJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session = request.getSession();
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
		String workyear = request.getParameter("workyear");
		JobShearchObject object= new JobShearchObject();
		if(workyear!=null&&!"".equals(workyear)){
			String areacode=(super.getInviteManager().findAreaCodeByname(workyear)).getAreacode();
			object.setWorkyear(areacode);	
		}
		
		object.setEducation(education);object.seteTime(eTime);object.setGrading(grading);object.setPostId(postId);
		object.setQjobid(qjobid);object.setQname(qname);object.setSex(sex);object.setsTime(sTime);object.setSta(sta);
		String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
		List lisuser=super.getInviteManager().findManaUserByName(loginName);
		 List bdPost = (List) super.inviteManager.findAllBdPost();
		ManaUser manaUser=(ManaUser)lisuser.get(0);
		object.setComparea(manaUser.getAreacode());
		if(manaUser.getAreacode().equals("110100")){
			session.setAttribute("areacode1", "areacode");
		}else{
			session.setAttribute("areacode1", "");
		}
		try {
			int pn = 0;
			int pageSize = 10;
			PaginationSupport vvv = super.getInviteManager()
					.paginationSearchPublishJobInfo(object,pn, pageSize, true);
			List list = (List) vvv.getItems();
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
			
			session.removeAttribute("jobtotleCount");
			session.removeAttribute("jobInfo");
			session.removeAttribute("jobpagenum");
			session.removeAttribute("jobzongshu");
			session.setAttribute("jobInfo", list);
			session.setAttribute("jobpagenum", pn);
			session.setAttribute("jobtotleCount", pc);
			session.setAttribute("jobzongshu", contunt);
			List areacode=super.getInviteManager().findAllAreaCode();
			session.setAttribute("bdPost",bdPost);
			session.setAttribute("arealist", areacode);
			session.setAttribute("qy", qname);
			session.setAttribute("qjobid", qjobid);
			session.setAttribute("education", education);
			session.setAttribute("grading", grading);
			session.setAttribute("postId", postId);
			session.setAttribute("sex", sex);
			session.setAttribute("sta", sta);
			session.setAttribute("sTime", sTime);
			session.setAttribute("eTime", eTime);
			session.setAttribute("workyear", workyear);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}

	public ActionForward nextfindpublish(ActionMapping mapping,
			ActionForm form,

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
		String workyear = request.getParameter("workyear");
		JobShearchObject object= new JobShearchObject();
		if(workyear!=null&&!"".equals(workyear)){
			String areacode=(super.getInviteManager().findAreaCodeByname(workyear)).getAreacode();
			object.setWorkyear(areacode);	
		}
		object.setEducation(education);object.seteTime(eTime);object.setGrading(grading);object.setPostId(postId);
		object.setQjobid(qjobid);object.setQname(qname);object.setSex(sex);object.setsTime(sTime);object.setSta(sta);
		try {
			int pageSize = 10;// 设定显示行数
			String pnum = (String) PropertyUtils.getSimpleProperty(form,
					"jobpnum");// 页码
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
			PaginationSupport vvv = super.getInviteManager().paginationSearchPublishJobInfo(object,pn, pageSize, false);
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			
			session.removeAttribute("jobInfo");
			session.removeAttribute("jobpagenum");
			session.setAttribute("zongshu", contunt);
			session.setAttribute("jobInfo", list);
			session.setAttribute("jobpagenum", ddd);
			List areacode=super.getInviteManager().findAllAreaCode();
			session.setAttribute("arealist", areacode);
			session.setAttribute("qy", qname);
			session.setAttribute("qjobid", qjobid);
			session.setAttribute("education", education);
			session.setAttribute("grading", grading);
			session.setAttribute("postId", postId);
			session.setAttribute("sex", sex);
			session.setAttribute("sTime", sTime);
			session.setAttribute("eTime", eTime);
			session.setAttribute("sta", sta);
			session.setAttribute("workyear", workyear);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}

	public ActionForward bathDelJob(ActionMapping mapping, ActionForm form,

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
		String sta = request.getParameter("sta");
		String eTime = request.getParameter("eTime");
		JobShearchObject object= new JobShearchObject();
		object.setEducation(education);object.seteTime(eTime);object.setGrading(grading);object.setPostId(postId);
		object.setQjobid(qjobid);object.setQname(qname);object.setSex(sex);object.setsTime(sTime);object.setSta(sta);
		try {

			String[] arr = request.getParameterValues("ids");
			int pageSize = 10;// 设定显示行数
			String pnum = request.getParameter("pnum");// 页码
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					PublishJobInfo job = super.getInviteManager()
							.findPublishJobById(arr[i]);
					job.setDr("1");
					super.getInviteManager().updatePublishJobInfo(job);
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
			PaginationSupport vvv = super.getInviteManager().paginationSearchPublishJobInfo(object,pn, pageSize, false);
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
			session.removeAttribute("jobInfo");
			session.removeAttribute("jobpagenum");
			session.setAttribute("jobzongshu", contunt);
			session.setAttribute("jobInfo", list);
			session.setAttribute("jobtotleCount", pc);
			session.setAttribute("jobpagenum", ddd);
			session.setAttribute("zongshu", contunt);
			
			session.setAttribute("qy", qname);
			session.setAttribute("qjobid", qjobid);
			session.setAttribute("education", education);
			session.setAttribute("grading", grading);
			session.setAttribute("postId", postId);
			session.setAttribute("sex", sex);
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
	/*
	 * jialuhaoadd(跳转服务记录的招聘的页面信息方法)
	 */
	public ActionForward findAllserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session = request.getSession();
		
		//查询条件
		String qname = request.getParameter("qy");
		String qjobid = request.getParameter("qjobid");
		String education = request.getParameter("education");
		String grading = request.getParameter("grading");
		String postId = request.getParameter("postId");
		String sex = request.getParameter("sex");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String workyear = request.getParameter("workyear");
		JobShearchObject object= new JobShearchObject();
		if(workyear!=null&&!"".equals(workyear)){
			String areacode=(super.getInviteManager().findAreaCodeByname(workyear)).getAreacode();
			object.setWorkyear(areacode);	
		}
		object.setAccount("all");
		object.setEducation(education);object.seteTime(eTime);object.setGrading(grading);object.setPostId(postId);
		object.setQjobid(qjobid);object.setQname(qname);object.setSex(sex);object.setsTime(sTime);object.setSta("2");
		String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
		List lisuser=super.getInviteManager().findManaUserByName(loginName);
		ManaUser manaUser=(ManaUser)lisuser.get(0);
		object.setComparea(manaUser.getAreacode());
		List bdPost = (List) super.inviteManager.findAllBdPost();
		if(manaUser.getAreacode().equals("110100")){
			session.setAttribute("areacode1", "areacode");
		}else{
			session.setAttribute("areacode1", "");
		}
		try {
			int pn = 0;
			int pageSize = 10;
			PaginationSupport vvv = super.getInviteManager()
					.paginationSearchPublishJobInfo(object,pn, pageSize, true);
			List list = (List) vvv.getItems();
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
			session.removeAttribute("jobtotleCount");
			session.removeAttribute("jobInfo");
			session.removeAttribute("jobpagenum");
			session.removeAttribute("jobzongshu");
			session.setAttribute("jobInfo", list);
			session.setAttribute("jobpagenum", pn);
			session.setAttribute("jobtotleCount", pc);
			session.setAttribute("jobzongshu", contunt);
			session.setAttribute("bdPost", bdPost);
			session.setAttribute("qy", qname);
			session.setAttribute("qjobid", qjobid);
			session.setAttribute("education", education);
			session.setAttribute("grading", grading);
			session.setAttribute("postId", postId);
			session.setAttribute("sex", sex);
			session.setAttribute("sTime", sTime);
			session.setAttribute("eTime", eTime);
			session.setAttribute("workyear", workyear);
			

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward("showservice");
	}
	/**
	 * 服务记录的翻页
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	
	public ActionForward nextfindservice(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		
		//查询条件
		String qname = request.getParameter("qy");
		String qjobid = request.getParameter("qjobid");
		String education = request.getParameter("education");
		String grading = request.getParameter("grading");
		String postId = request.getParameter("postId");
		String sex = request.getParameter("sex");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String workyear = request.getParameter("workyear");
		JobShearchObject object= new JobShearchObject();
		if(workyear!=null&&!"".equals(workyear)){
			String areacode=(super.getInviteManager().findAreaCodeByname(workyear)).getAreacode();
			object.setWorkyear(areacode);	
		}
		object.setAccount("all");
		object.setEducation(education);object.seteTime(eTime);object.setGrading(grading);object.setPostId(postId);
		object.setQjobid(qjobid);object.setQname(qname);object.setSex(sex);object.setsTime(sTime);object.setSta("2");
		try {
			int pageSize = 10;// 设定显示行数
			String pnum = (String) PropertyUtils.getSimpleProperty(form,
					"jobpnum");// 页码
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
			PaginationSupport vvv = super.getInviteManager().paginationSearchPublishJobInfo(object,pn, pageSize, false);
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			session.removeAttribute("jobInfo");
			session.removeAttribute("jobpagenum");
			session.setAttribute("zongshu", contunt);
			session.setAttribute("jobInfo", list);
			session.setAttribute("jobpagenum", ddd);
			
			session.setAttribute("qy", qname);
			session.setAttribute("qjobid", qjobid);
			session.setAttribute("education", education);
			session.setAttribute("grading", grading);
			session.setAttribute("postId", postId);
			session.setAttribute("sex", sex);
			session.setAttribute("sTime", sTime);
			session.setAttribute("eTime", eTime);
			session.setAttribute("workyear", workyear);

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward("showservice");
	}

	//jialuhaoadd
	//查询服务记录
	public ActionForward checkserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session=request.getSession();
		String id="";
		if(request.getParameter("jobid")!=null){
	 id=(String)request.getParameter("jobid");}//id为jobid
		else{
			id=(String)session.getAttribute("jobid");
		}
		List bdPost=super.getInviteManager().findAllBdPost();
		List list=super.getInviteManager().findServicelogById(id);
		session.removeAttribute("servicelog");
		session.setAttribute("bdPost", bdPost);
		session.setAttribute("servicelog", list);
		session.setAttribute("jobid",id);
		return mapping.findForward("checkservice");
	
	}
	//jialuhaoadd
	//查询一条服务记录
	public ActionForward checkoneserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session=request.getSession();
		String id=(String)request.getParameter("serviceid");//id为表的主键
		Servicelog servicelog=super.getInviteManager().queryServicelogById(id);
		String jobidid=(String)session.getAttribute("jobid");//id为jobid
		PublishJobInfo job=new PublishJobInfo();
		job=super.getInviteManager().findPublishJobById(jobidid);
		List list=super.getInviteManager().findServicepeopleById(id);
		List recommends=super.getInviteManager().findRecommendsbyservice(id);
		
		for(int i=0;i<recommends.size();i++){
			Recommends recom=(Recommends)recommends.get(i);
			String cardnumber=recom.getCardnumber();
			List eee=super.getInviteManager().findResumeBycardnumber(cardnumber);
			Object[] vvv = (Object[]) eee.get(0);
			PersonResume personresume= (PersonResume) vvv[0];
			recom.setName(personresume.getName());
			String dikind=super.getInviteManager().findPostById(personresume.getDkind()).getPostName();
			recom.setDikind(dikind);
			recom.setPhone(personresume.getPhone());
		}
		session.removeAttribute("servicelog");
		session.removeAttribute("servicepeople");
		session.setAttribute("recommends", recommends);
		session.setAttribute("servicelog", servicelog);
		session.setAttribute("servicepeople", list);
		session.setAttribute("job", job);
		return mapping.findForward("checkoneservice");
	
	}
	//jialuhaoadd
	//新增一条服务记录
	public ActionForward addserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("jobid");//id为jobid
		PublishJobInfo job=new PublishJobInfo();
		job=super.getInviteManager().findPublishJobById(id);
		String flag=job.getValidflag();
		List arealist= super.getInviteManager().findAllAreaCode();
		session.setAttribute("arealist",arealist);
		List<?> list=super.getInviteManager().findcompservicebyjobid(id);
		session.setAttribute("compservice", list);
		session.setAttribute("job", job);
		session.setAttribute("flag", flag);
		return mapping.findForward("addservice");                    
		
	
	}

	//jialuhaoadd
	//修改一条服务记录
	public ActionForward modifyserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		
		HttpSession session=request.getSession();
		String id=(String)request.getParameter("serviceid");//id为jobid
		Servicelog servicelog=super.getInviteManager().queryServicelogById(id);
		String jobidid=(String)session.getAttribute("jobid");//id为jobid
		PublishJobInfo job=new PublishJobInfo();
		job=super.getInviteManager().findPublishJobById(jobidid);
		List list=super.getInviteManager().findServicepeopleById(id);
		List arealist= super.getInviteManager().findAllAreaCode();
        List recommends=super.getInviteManager().findRecommendsbyservice(id);
		
		for(int i=0;i<recommends.size();i++){
			Recommends recom=(Recommends)recommends.get(i);
			String cardnumber=recom.getCardnumber();
			List eee=super.getInviteManager().findResumeBycardnumber(cardnumber);
			Object[] vvv = (Object[]) eee.get(0);
			PersonResume personresume= (PersonResume) vvv[0];
			recom.setName(personresume.getName());
			String dikind=super.getInviteManager().findPostById(personresume.getDkind()).getPostName();
			recom.setDikind(dikind);
			recom.setPhone(personresume.getPhone());
		}
		session.setAttribute("recommends", recommends);
		session.setAttribute("arealist",arealist);
		session.removeAttribute("servicelog");
		session.removeAttribute("servicepeople");
		session.setAttribute("servicelog", servicelog);
		session.setAttribute("servicepeople", list);
		session.setAttribute("serviceid", id);
		session.setAttribute("job", job);
		return mapping.findForward("modifyservice");               
		
	
	}
	//jialuhaoadd
	//保存修改的一条服务记录
	public ActionForward updateserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		//取出前台传过来的服务记录表的字段
		HttpSession session=request.getSession();
		String jobid=(String)session.getAttribute("jobid");//id为jobid
		String id=(String)session.getAttribute("serviceid");
		String writetime=(String)request.getParameter("writetime");
		String writeare=(String)request.getParameter("writeare");
		String writearename=(super.getInviteManager().findAreaCodeByarea(writeare)).getAreaname();
		String writepeople=(String)request.getParameter("writepeople");		
		String number=(String)request.getParameter("number");
		String losewhyobj=(String)request.getParameter("losewhyobjs");
		String otherwhy=(String)request.getParameter("otherparts");
		String serviceneed=(String)request.getParameter("problem1objs");//单位服务需求
		String opinion=(String)request.getParameter("opinion");
		String sname=request.getParameter("sname");
		String snumber=request.getParameter("snumber");
		String register=request.getParameter("register");
		String phone=request.getParameter("sphone");
		String sjob=request.getParameter("sjob");
		String remark=request.getParameter("remark");
		String validflag=request.getParameter("validflag");
		 String cardnumber=(String)request.getParameter("cardnumber");
			String commdpeople=(String)request.getParameter("commedpeople");
			String[] cardnumbers=null;
			String[] commdpeoples=null;		
			cardnumbers=cardnumber.split(",");
			commdpeoples=commdpeople.split(",");
		String[] snames=null;
		String[] snumbers = null;
		String[] registers=null;
		String[] sjobs=null;
		String[] phones=null;
		String[] remarks=null;
		Servicelog servicelog=super.getInviteManager().queryServicelogById(id);
		servicelog.setWritetime(writetime);
		servicelog.setWriteare(writearename);
		servicelog.setWritepeople(writepeople);
		servicelog.setNumber(number);

		if(validflag.equals("2")){
	    servicelog.setOtherwhy(otherwhy);	
		servicelog.setLosewhy(losewhyobj);
		List list=super.getInviteManager().findServicepeopleById(id);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Servicepeople servicepeople=(Servicepeople)list.get(i);
				super.getInviteManager().delServicepeople(servicepeople);
			}
		}
		}
		servicelog.setServiceneed(serviceneed);
		servicelog.setOpinion(opinion);
		List recommends=super.getInviteManager().findRecommendsbyservice(id);
		if(recommends!=null&&recommends.size()>0){
			for(int i=0;i<recommends.size();i++){
				Recommends  recom=(Recommends)recommends.get(i);
				super.getInviteManager().delRecommends(recom);
			}
		}
		PublishJobInfo job=new PublishJobInfo();
		job=super.getInviteManager().findPublishJobById(jobid);	
		String jobname=job.getJob().getJobName();
		String company=job.getPkComp().getComp().getCompName();
		Recommends recommend=new Recommends();
		 for(int j=0;j<cardnumbers.length;j++){
			 recommend.setCardnumber(cardnumbers[j]);
				recommend.setCommdpeople(commdpeoples[j]);
				recommend.setCompany(company);
				recommend.setJob(jobname);
				recommend.setServiceid(servicelog.getId()+"");
				super.getInviteManager().saveRecommends(recommend);	
			}
		super.getInviteManager().updateServicelog(servicelog);
		if(sname!=null){
			snames=sname.split(",");
		}
		if(snumber!=null){
			snumbers=snumber.split(",");
		}
		if(register!=null){
			registers=register.split(",");
		}
		if(phone!=null){
			phones=phone.split(",");
		}
		if(sjob!=null){
			sjobs=sjob.split(",");
		}
		if(remark!=null){
			remarks=remark.split(",");
		}
		if(validflag.equals("3")){
			servicelog.setLosewhy("");
			super.getInviteManager().updateServicelog(servicelog);
		List list=super.getInviteManager().findServicepeopleById(id);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Servicepeople servicepeople=(Servicepeople)list.get(i);
				super.getInviteManager().delServicepeople(servicepeople);
			}
		}
		
		if(snames!=null){
			for(int i=0;i<snames.length&&snames[i]!=null;i++){
				Servicepeople servicepeople=new Servicepeople();
				servicepeople.setSname(snames[i]);
				if(snumbers!=null&&snumbers.length>i){
				servicepeople.setDisnumber(snumbers[i]);}
				if(registers!=null&&registers.length>i){
				servicepeople.setRegister(registers[i]);}
				if(phones!=null&&phones.length>i){
				servicepeople.setPhone(phones[i]);}
				if(sjobs!=null&&sjobs.length>i){
				servicepeople.setJobname(sjobs[i]);}
				if(remarks!=null&&remarks.length>i){
				servicepeople.setRemark(remarks[i]);}
				servicepeople.setServiceid(servicelog.getId()+"");
				super.getInviteManager().saveServicepeople(servicepeople);
			}
			}
		}
		return mapping.findForward("lookservice");             
		
	
	}
	//jialuhaoadd
	//保存一条服务记录
	public ActionForward saveserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("jobid");//id为jobid
		//取出前台传过来的服务记录表的字段
		String writetime=(String)request.getParameter("writetime");
		String writeare=(String)request.getParameter("writeare");
		String writearename=(super.getInviteManager().findAreaCodeByarea(writeare)).getAreaname();
		String writepeople=(String)request.getParameter("writepeople");
		String number=(String)request.getParameter("number");
        String cardnumber=(String)request.getParameter("cardnumber");
		String commdpeople=(String)request.getParameter("commedpeople");
		String[] cardnumbers=null;
		String[] commdpeoples=null;		
		cardnumbers=cardnumber.split(",");
		commdpeoples=commdpeople.split(",");
		PublishJobInfo job=new PublishJobInfo();
		job=super.getInviteManager().findPublishJobById(id);
		String jobname=job.getJob().getJobName();
		String company=job.getPkComp().getComp().getCompName();
		
		
		String losewhyobj=(String)request.getParameter("losewhyobjs");
		String otherwhy=(String)request.getParameter("otherparts");
		String serviceneed=(String)request.getParameter("problem1objs");//单位服务需求
		String opinion=(String)request.getParameter("opinion");
		String sname=request.getParameter("sname");
		String snumber=request.getParameter("snumber");
		String register=request.getParameter("register");
		String phone=request.getParameter("sphone");
		String sjob=request.getParameter("sjob");
		String remark=request.getParameter("remark");
		String validflag=request.getParameter("validflag");
		String[] snames=null;
		String[] snumbers = null;
		String[] registers=null;
		String[] sjobs=null;
		String[] phones=null;
		String[] remarks=null;
		Servicelog servicelog=new Servicelog();
		
		servicelog.setWritetime(writetime);
		servicelog.setWriteare(writearename);
		servicelog.setWritepeople(writepeople);
		
		servicelog.setNumber(number);
		
		if(validflag.equals("2")){
		servicelog.setLosewhy(losewhyobj);
		servicelog.setOtherwhy(otherwhy);
		}
		servicelog.setServiceneed(serviceneed);
		servicelog.setOpinion(opinion);
		servicelog.setJobid(id);
		super.getInviteManager().saveServicelog(servicelog);
		Recommends recommends=new Recommends();
		 for(int j=0;j<cardnumbers.length;j++){
			 recommends.setCardnumber(cardnumbers[j]);
				recommends.setCommdpeople(commdpeoples[j]);
				recommends.setCompany(company);
				recommends.setJob(jobname);
				recommends.setServiceid(servicelog.getId()+"");
				super.getInviteManager().saveRecommends(recommends);	
			}
		if(sname!=null&&sname!=""){
			snames=sname.split(",");
		}
		if(snumber!=null){
			snumbers=snumber.split(",");
		}
		if(register!=null){
			registers=register.split(",");
		}
		if(phone!=null){
			phones=phone.split(",");
		}
		if(sjob!=null){
			sjobs=sjob.split(",");
		}
		if(remark!=null){
			remarks=remark.split(",");
		}
		if(validflag.equals("3")){
		if(snames!=null){
			for(int i=0;i<snames.length&&snames[i]!=null;i++){
				Servicepeople servicepeople=new Servicepeople();
				servicepeople.setSname(snames[i]);
				if(snumbers!=null&&snumbers.length>i){
				servicepeople.setDisnumber(snumbers[i]);}
				if(registers!=null&&registers.length>i){
				servicepeople.setRegister(registers[i]);}
				if(phones!=null&&phones.length>i){
				servicepeople.setPhone(phones[i]);}
				if(sjobs!=null&&sjobs.length>i){
				servicepeople.setJobname(sjobs[i]);}
				if(remarks!=null&&remarks.length>i){
				servicepeople.setRemark(remarks[i]);}
				servicepeople.setServiceid(servicelog.getId()+"");
				super.getInviteManager().saveServicepeople(servicepeople);
			}
		}
		}
		return mapping.findForward("lookservice");
	
	}
	//jialuhaoadd
	//删除一条服务记录
	public ActionForward deleteserviceJob(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session=request.getSession();
		String id=(String)request.getParameter("serviceid");//id为jobid
		Servicelog servicelog=super.getInviteManager().queryServicelogById(id);
		super.getInviteManager().delServicelog(servicelog);
		List list=super.getInviteManager().findServicepeopleById(id);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Servicepeople servicepeople=(Servicepeople)list.get(i);
				super.getInviteManager().delServicepeople(servicepeople);
			}
		}
		List recommends=super.getInviteManager().findRecommendsbyservice(id);
		if(recommends!=null&&recommends.size()>0){
			for(int i=0;i<recommends.size();i++){
				Recommends  recom=(Recommends)recommends.get(i);
				super.getInviteManager().delRecommends(recom);
			}
		}
		session.removeAttribute("servicelog");
		session.removeAttribute("servicepeople");
		session.setAttribute("servicelog", servicelog);
		session.setAttribute("servicepeople", list);
		session.setAttribute("serviceid", id);
		return mapping.findForward("lookservice");               
		
	
	}
public void  modifyserviceJob1(ActionMapping mapping,ActionForm form,

		HttpServletRequest request, HttpServletResponse response)
		throws BaseException, IOException {

	String cardnumber=request.getParameter("snumber");
List eee=super.getInviteManager().findResumeBycardnumber(cardnumber);
Object[] vvv = (Object[]) eee.get(0);
PersonResume personresume= (PersonResume) vvv[0];
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();

	String dikind=super.getInviteManager().findPostById(personresume.getDkind()).getPostName();
out.println(personresume.getName()+","+dikind+","+personresume.getPhone());

out.flush();
out.close(); 

}
}

