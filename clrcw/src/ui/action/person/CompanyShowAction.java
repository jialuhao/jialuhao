package ui.action.person;


import java.util.*;

import util.PaginationSupport;
import javax.servlet.http.*;

import model.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompanyShowAction  extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanyShowAction.class);
	
	 /**
     * 
     * 描述：在页面中显示企业招聘信息,显示第一页的信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
    
	public ActionForward showAll(ActionMapping mapping, ActionForm form,

             HttpServletRequest request, HttpServletResponse response) throws BaseException{
  	   
  	   try{
  		
  		  int pageIndex=0;
  		  int pageSize=12;
		
  		  boolean desc=true;
  		  PaginationSupport pagin=super.getInviteManager().paginationPublishJob(null,pageIndex, pageSize, desc);
  		  List<?> list=pagin.getItems();
  		  int totalCount=pagin.getTotalCount();
  		  int tpp=(int) Math.ceil((totalCount-1)/pageSize);
  		HttpSession session=request.getSession();
  		  //jialuhaoadd  获取简历投递状态
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List resume =  super.getInviteManager().queryPersonResume(username);
			List aaaa=null;
			
			Object[] eee=(Object[])resume.get(0);
			PersonResume personResume = (PersonResume)eee[0];
	    	String state= personResume.getState();
			String pkresume=personResume.getId()+"";//得到表中compresume字段pkresume
		    aaaa=super.getInviteManager().findCompResumeBypersonid(pkresume);
			
  		 
			List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
  		  PublishJobInfo jobInfo=new PublishJobInfo();
  		 	if(list==null)
  		 		 return mapping.findForward("fail");
  		 	else{	
  		 		ApplyJobInfo applyjob=new ApplyJobInfo();
		List<?> list11=super.inviteManager.queryApplyJobById(username);
		boolean e=true;
		
		if(list11==null||list11.size()==0){
			e=false;
		}else if("0".equals(state)||"1".equals(state)){
			e=false;
		}
		
		for(int i=0;i<list.size();i++)
	 		{
	 			jobInfo=(PublishJobInfo)list.get(i);
	 			//判断已经投递的企业
	 			String a="未投递";
	 		if(aaaa!=null){
	 			for(int j=0;j<aaaa.size();j++){
					Object[] vvv = (Object[]) aaaa.get(j);
			    	 CompResume compResume = (CompResume) vvv[0];
			    	  PublishJobInfo comjob= compResume.getCompPost(); 		      
	  		        if(jobInfo.equals(comjob))
	  		        {
	        	      a="已投递";
	  		        }
	  					}
	 		}
	 			jobInfo.setZp_flag(a);  
	 			allPublishJobInfo.add(jobInfo);	
									
	 		}
  		 		request.setAttribute("allPublishJobInfo", allPublishJobInfo);
  		 		request.setAttribute("pageIndex", pageIndex);
  		 		request.setAttribute("e", e);
  		 		session.removeAttribute("totalCount");
  		 		session.setAttribute("totalCount", totalCount);
  		 		session.removeAttribute("tpp");
  		 		session.setAttribute("tpp", tpp);
  		 		
  	   		
  				return mapping.findForward("success");
  		 	}
  	   		}catch(BusinessException be){
         	   logger.error(be.getMessage(),be);
         	   throw new BaseException(be);
         	   
            }catch(Exception ex){
         	   logger.error("系统异常:",ex);
         	   throw new BaseException(ex);
            }
  	   
     }
     /**
      * 
      * 描述：显示其他页的信息
      * @param mapping
      * @param form
      * @param request
      * @param response
      * @return ActionForward
      * @throws BaseException 
      */
     
     
     
     public ActionForward showOtherPage(ActionMapping mapping, ActionForm form,

             HttpServletRequest request, HttpServletResponse response) throws BaseException{
    	 
    	 try {
				int pageSize=12;
			
				
				String pnum=(String)PropertyUtils.getSimpleProperty(form,"pageIndex");
				HttpSession session = request.getSession(true);
			    int ppp=(Integer)session.getAttribute("totalCount");
				int tpn=(int) Math.ceil((ppp-1)/pageSize);
				int pn=new Integer(pnum).intValue();
				int ddd;
					if(pn>=tpn){
						ddd=tpn;
					}
					else if(pn<=0){
						 ddd=0;
					}
					else{
						 ddd=pn;
					}
			  	String jobName=request.getParameter("jobname"); 
				String address=request.getParameter("address"); 
				String starttime=request.getParameter("starttime"); 
				String endtime=request.getParameter("endtime"); 
				String compname=request.getParameter("compname"); 		  		   
				String username = (String) session
				.getAttribute(IConstants.PERSON_USER_ID);
				List resume =  super.getInviteManager().queryPersonResume(username);
				List aaaa=null;
				
				Object[] eee=(Object[])resume.get(0);
				PersonResume personResume = (PersonResume)eee[0];
				String state= personResume.getState();
				String pkresume=personResume.getId()+"";//得到表中compresume字段pkresume
			    aaaa=super.getInviteManager().findCompResumeBypersonid(pkresume);
				
				PublishJobInfo publishJobInfo=new PublishJobInfo();
				publishJobInfo.setJobAmount(jobName);
				publishJobInfo.setAddress(address);
				publishJobInfo.setCompLoginId(compname);
				publishJobInfo.setCloseTime(starttime);
				publishJobInfo.setPublishTime(endtime);
				PaginationSupport pagin=super.getInviteManager().paginationPublishJob(publishJobInfo,ddd, pageSize, true);
				
		  		 
				List<?> list=pagin.getItems();
				List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
	  			PublishJobInfo jobInfo=new PublishJobInfo();
	  			ApplyJobInfo applyjob=new ApplyJobInfo();
	  			List<?> list11=super.inviteManager.queryApplyJobById(username);
	  			boolean e=true;
	  			
	  			if(list11==null||list11.size()==0){
	  				e=false;
	  			}else if("0".equals(state)||"1".equals(state)){
	  				e=false;
	  			}
	  			for(int i=0;i<list.size();i++)
		 		{
		 			jobInfo=(PublishJobInfo)list.get(i);
		 			//判断已经投递的企业
		 			String a="未投递";
		 		if(aaaa!=null){
		 			for(int j=0;j<aaaa.size();j++){
						Object[] vvv = (Object[]) aaaa.get(j);
				    	 CompResume compResume = (CompResume) vvv[0];
				    	  PublishJobInfo comjob= compResume.getCompPost(); 		      
		  		        if(jobInfo.equals(comjob))
		  		        {
		        	      a="已投递";
		  		        }
		  					}
		 		}
		 			jobInfo.setZp_flag(a);  
		 			allPublishJobInfo.add(jobInfo);	
										
		 		}
		 	request.setAttribute("allPublishJobInfo", allPublishJobInfo);
		 	int totalCount=pagin.getTotalCount();
		 	 int tpp=(int) Math.ceil((totalCount-1)/pageSize);
		 	session.removeAttribute("totalCount");
		 	session.setAttribute("totalCount", totalCount);
		 	request.setAttribute("e", e);	
		 	
		 	request.setAttribute("pageIndex", ddd);
		 	session.setAttribute("tpp", tpp);
		 	request.setAttribute("jobname", jobName);
		 	request.setAttribute("address", address);
		 	request.setAttribute("starttime", starttime);
		 	request.setAttribute("endtime", endtime);
		 	request.setAttribute("compname", compname);
		 	return mapping.findForward("success");
    	 }catch(BusinessException be){
       	   logger.error(be.getMessage(),be);
       	   throw new BaseException(be);
       	   
          }catch(Exception ex){
       	   logger.error("系统异常:",ex);
       	   throw new BaseException(ex);
          }
     }
 
  	   

}
