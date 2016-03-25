package ui.action.company;

import javax.servlet.http.*;

import java.lang.Exception;
import model.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

	//企业发布职位信息action

public class  CompanyPubJobAction extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanyPubJobAction.class);
	/**
     * 
     * 描述：在页面中显示企业招聘信息  
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showPubJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException{
		String forward = IConstants.FAIL_KEY;
		
	try {
		HttpSession session=request.getSession(false);
		Integer coId=(Integer)session.getAttribute("compId");
		if(coId==null){
				ActionMessages messages=new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.return"));
				saveErrors(request, messages);
				return mapping.findForward("return");
		}
		else{
			String userId=(String)session.getAttribute(IConstants.COMP_USER_ID);
			List<?> list=super.getInviteManager().queryJobInfoById(userId);
			List<PublishJobInfo> jobInfo=new ArrayList<PublishJobInfo>();
			for(int i=0;i<list.size();i++){
				Object[] o=(Object[])list.get(i);
				PublishJobInfo job=(PublishJobInfo)o[0];
				
				jobInfo.add(job);
			}
			List<Commoncode> commonCodelist=super.getInviteManager().findAllCommonCode();
			   
	    	for(int i=0;i<commonCodelist.size();i++){
	    		Commoncode commoncode=new Commoncode();
	    		commoncode=commonCodelist.get(i);            
	    		if("65".equals(commoncode.getId()+""))
	    			request.setAttribute("compdays",commoncode.getCommonvalues());
	    		if("66".equals(commoncode.getId()+""))
	    			request.setAttribute("gongzi",commoncode.getCommonvalues());
	    	}
			request.setAttribute("job",jobInfo);
			List arealist= super.getInviteManager().findAllAreaCode();
			request.setAttribute("arealist",arealist);
			List salarylist= super.getInviteManager().findAllSalary();
			request.setAttribute("salarylist",salarylist);
			List bdPost=super.getInviteManager().findAllBdPost();
			request.setAttribute("bdPost",bdPost);
			forward=IConstants.SUCCESS_KEY;
			}
		}catch(BusinessException be){
				logger.error(be.getMessage(),be);
				throw new BaseException(be);
    	   
		}catch(Exception ex){
				logger.error("系统异常:",ex);
				throw new BaseException(ex);
		}
			return mapping.findForward(forward);
	}		

	
	/**
     * 
     * 描述：添加企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward addPubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
				
			try {

					String jobId = (String) PropertyUtils.getSimpleProperty(form, "jobId");
					String postId = (String) PropertyUtils.getSimpleProperty(form, "postId");
					String num = (String) PropertyUtils.getSimpleProperty(form, "num");
					String intro = (String) PropertyUtils.getSimpleProperty(form, "intro");
					String sTime = (String) PropertyUtils.getSimpleProperty(form, "sTime");
					String eTime = (String) PropertyUtils.getSimpleProperty(form, "eTime");
					String sex = (String) PropertyUtils.getSimpleProperty(form, "sex");
					String age = (String) PropertyUtils.getSimpleProperty(form, "age");
					String grading = (String) PropertyUtils.getSimpleProperty(form, "grading");
					String education = (String) PropertyUtils.getSimpleProperty(form, "education");
					String experience = (String) PropertyUtils.getSimpleProperty(form, "experience");
					String money = (String) PropertyUtils.getSimpleProperty(form, "money");
					String nature = (String) PropertyUtils.getSimpleProperty(form, "nature");
					String workarea = (String) PropertyUtils.getSimpleProperty(form, "workarea");
					String welfare = (String) PropertyUtils.getSimpleProperty(form, "welfare");
					//String address=(String) PropertyUtils.getSimpleProperty(form,"address");
					String addresss=(String)request.getParameter("address");
					//算出有效期
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
//					Date start=sdf.parse(sTime);
//				    Calendar calender = Calendar.getInstance();
//				    calender.setTime(start);
//				    calender.add(Calendar.MONTH, 6);
//				    String  validtime=  sdf.format(calender.getTime());
					
					HttpSession session=request.getSession(false);
					String userId=(String)session.getAttribute(IConstants.COMP_USER_ID);
					Integer compBespeakId=(Integer)session.getAttribute("compBespeakId");
					CompInfo comp=super.getInviteManager().findCompInfoById(compBespeakId.toString());
					BdJob job=super.getInviteManager().findJobById(jobId);
					BdEducate educate=super.getInviteManager().findEducateById(education);
					BdPost post=super.getInviteManager().findPostById(postId);
					PublishJobInfo publishJobInfo=new PublishJobInfo();
					publishJobInfo.setJob(job);
					publishJobInfo.setPkComp(comp);
					publishJobInfo.setPost(post);
					publishJobInfo.setCompLoginId(userId);
					publishJobInfo.setJobAmount(num);
					publishJobInfo.setJobDesc(intro);
					publishJobInfo.setPublishTime(sTime);
					publishJobInfo.setCloseTime(eTime);
					publishJobInfo.setEngageSex("1");
					publishJobInfo.setAgeLimit(age);
					publishJobInfo.setGrading(grading);//毕业生
					publishJobInfo.setEducation(educate);
					publishJobInfo.setWorkYear(experience);
					publishJobInfo.setSalary(money);
					publishJobInfo.setNature(nature);
					publishJobInfo.setWorkarea(workarea);
					publishJobInfo.setWelfare(welfare);
					publishJobInfo.setAddress(addresss);
					publishJobInfo.setValidflag("1");
					publishJobInfo.setStatus("0");
					//publishJobInfo.setValidtime(validtime);
					super.getInviteManager().savePublishJobInfo(publishJobInfo);
					return mapping.findForward("showInfo");
				} catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);
	    	   
				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
			}
				
				
			}

	
	
	
	/**
     * 
     * 描述：删除一条企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward delPubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String id=request.getParameter("id");
			PublishJobInfo job=new PublishJobInfo();
			job=super.getInviteManager().findPublishJobById(id);
			super.getInviteManager().delPublishJobInfo(job);
			return mapping.findForward("showInfo");
			} catch(BusinessException be){
				logger.error(be.getMessage(),be);
				throw new BaseException(be);
   
			}catch(Exception ex){
				logger.error("系统异常:",ex);
				throw new BaseException(ex);
			}
}
	
	/**
     * 
     * 描述：修改一条企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward updatePubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
				String id=request.getParameter("id");
				PublishJobInfo job=super.getInviteManager().findPublishJobById(id);
				List arealist= super.getInviteManager().findAllAreaCode();
				request.setAttribute("arealist",arealist);
				List salarylist= super.getInviteManager().findAllSalary();
				request.setAttribute("salarylist",salarylist);
				List bdPost=super.getInviteManager().findAllBdPost();
				
				request.setAttribute("bdPost",bdPost);
				request.setAttribute("oneJob",job);
				request.setAttribute("keyId",id);
				return mapping.findForward("update");
				} catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);
	   
				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
	}


	
	/**
     * 
     * 描述：修改后保存一条企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward savePubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String jobId = (String) PropertyUtils.getSimpleProperty(form, "jobId");
			String postId = (String) PropertyUtils.getSimpleProperty(form, "postId");
			String num = (String) PropertyUtils.getSimpleProperty(form, "num");
			String intro = (String) PropertyUtils.getSimpleProperty(form, "intro");
			String sTime = (String) PropertyUtils.getSimpleProperty(form, "sTime");
			String eTime = (String) PropertyUtils.getSimpleProperty(form, "eTime");
			String sex = (String) PropertyUtils.getSimpleProperty(form, "sex");
			String age = (String) PropertyUtils.getSimpleProperty(form, "age"); 
			String grading = (String) PropertyUtils.getSimpleProperty(form, "grading");
			String education = (String) PropertyUtils.getSimpleProperty(form, "education");
			String experience = (String) PropertyUtils.getSimpleProperty(form, "experience");
			String money = (String) PropertyUtils.getSimpleProperty(form, "money");
			String keyId=(String)PropertyUtils.getSimpleProperty(form, "infoKeyId");
			String nature = (String) PropertyUtils.getSimpleProperty(form, "nature");
			String workarea = (String) PropertyUtils.getSimpleProperty(form, "workarea");
			String welfare = (String) PropertyUtils.getSimpleProperty(form, "welfare");
			String address=(String)request.getParameter("address");
			
			PublishJobInfo publishJobInfo=super.getInviteManager().findPublishJobById(keyId);
			BdJob job=super.getInviteManager().findJobById(jobId);
			BdEducate educate=super.getInviteManager().findEducateById(education);
			BdPost post=super.getInviteManager().findPostById(postId);
			publishJobInfo.setPost(post);
			publishJobInfo.setJob(job);
			publishJobInfo.setEducation(educate);
		//	publishJobInfo.setPost(post);
			publishJobInfo.setJobAmount(num);
			publishJobInfo.setJobDesc(intro);
			publishJobInfo.setPublishTime(sTime);
			publishJobInfo.setCloseTime(eTime);
			publishJobInfo.setEngageSex(sex);
			publishJobInfo.setAgeLimit(age);
			publishJobInfo.setGrading(grading);//毕业生
			publishJobInfo.setEducation(educate);
			publishJobInfo.setWorkYear(experience);
			publishJobInfo.setSalary(money);
			publishJobInfo.setDr("0");
			publishJobInfo.setNature(nature);
			publishJobInfo.setWorkarea(workarea);
			publishJobInfo.setWelfare(welfare);
			publishJobInfo.setAddress(address);
			publishJobInfo.setStatus("0");
			
			super.getInviteManager().updatePublishJobInfo(publishJobInfo);
			return mapping.findForward("showInfo");
		} catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
	   
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}

	/**
     * 
     * 描述：修改后保存一条企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward savePubJobflag(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String id=request.getParameter("id");
			
//			PublishJobInfo job=new PublishJobInfo();
//			job=super.getInviteManager().findPublishJobById(id);
//			
//			super.getInviteManager().updatePublishJobInfo(job);
     		HttpSession session=request.getSession();
			session.setAttribute("jobid", id);
			return mapping.findForward("showServicelog");
		} catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}
	/**
     * 
     * 描述：招聘信息的延期（延长时间为6个月）
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward postponeJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String id=request.getParameter("id");
			PublishJobInfo job=super.getInviteManager().findPublishJobById(id);
			String time1=job.getCloseTime();
			//算出延期后的有效期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start=sdf.parse(time1);
		    Calendar calender = Calendar.getInstance();
		    calender.setTime(start);
		    calender.add(Calendar.MONTH, 6);
		    String  validtime=  sdf.format(calender.getTime());
		    job.setCloseTime(validtime);
			super.getInviteManager().updatePublishJobInfo(job);
			return mapping.findForward("showInfo");
		} catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}	
}



	
	

	    