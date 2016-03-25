package ui.servlet;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ApplyJobInfo;
import model.BdPostRoot;
import model.PublishJobInfo;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.PaginationSupport;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class IndexGoToAction  extends BaseAction{
	private static Logger logger = Logger.getLogger(IndexGoToAction.class);
	
	 /**
     * 
     * 描述：在页面中显示企业招聘以及个人求职的信息,显示第一页的信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
     public ActionForward show(ActionMapping mapping, ActionForm form,

             HttpServletRequest request, HttpServletResponse response) throws BaseException{
    	 try{
    		  int pageIndex=0;
    		  int pageSize=5;
    		  boolean desc=true;
    		   
    		 //岗位信息
    		 List<BdPostRoot> list=new ArrayList<BdPostRoot>();
    		 inviteManager=super.getInviteManager();
   			list=inviteManager.findAllBdPostRoot();
   			request.setAttribute("postRoot", list);
    		  
   			
    		 //企业招聘数据
    		 PaginationSupport pagin1=inviteManager.paginationPublishJob(null,pageIndex, pageSize, desc);
    		 List<?> list1=pagin1.getItems();
    		 List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
    		 PublishJobInfo jobInfo=new PublishJobInfo();
    		 if(list1!=null){
    			 for(int i=0;i<list1.size();i++){
 		 			jobInfo=(PublishJobInfo)list1.get(i);
 		 			allPublishJobInfo.add(jobInfo);
 		 		}
    		 }
    		 if(allPublishJobInfo!=null&&allPublishJobInfo.size()>0){
    			 for(int i=0;i<allPublishJobInfo.size();i++){
    				 String str = allPublishJobInfo.get(i).getJob().getJobName();
    				 String add = allPublishJobInfo.get(i).getAddress();
    				 if(str!=null&&str.length()>5){
    					 str = str.substring(0, 4);
    				 }
    				 if(add!=null&&add.length()>5){
    					 add = add.substring(0, 4);
    				 }
    				 allPublishJobInfo.get(i).setJobDesc(str);
    				 allPublishJobInfo.get(i).setGrading(add);
    			 }
    		 }
    		 request.setAttribute("publishjobinfo", allPublishJobInfo);
    		 
    		 //个人求职数据
    		 PaginationSupport pagin2=inviteManager.paginationS(null,pageIndex, pageSize, desc);
    		 List<?> list2=pagin2.getItems();
    		 List<ApplyJobInfo> all=new ArrayList<ApplyJobInfo>();
    		 ApplyJobInfo oneApply=new ApplyJobInfo();
    		 if(list2!=null){
    			 for(int i=0;i<list2.size();i++){
     		 		oneApply=(ApplyJobInfo)list2.get(i);
     		 		all.add(oneApply);
     		 		}
 		 		}
    		 if(all!=null&&all.size()>0){
    			 for(int i=0;i<all.size();i++){
    				 String str = all.get(i).getJobCode().getJobName();
    				 String add = all.get(i).getWorkYear();
    				 String time=all.get(i).getCreateTime();
    				 time=time.substring(0,10);
    				 if(str!=null&&str.length()>5){
    					 str = str.substring(0, 4);
    				 }
    				 
    				 all.get(i).setCreateTime(time);
    				 all.get(i).setSalary(str);
    				
    			 }
    		 }
    		 request.setAttribute("applyJobInfo", all);
    		 
    	return mapping.findForward(IConstants.SUCCESS_KEY);
    
     	}catch(BusinessException be){
        	   logger.error(be.getMessage(),be);
        	   throw new BaseException(be);
        	   
        }catch(Exception ex){
        	   logger.error("系统异常:",ex);
        	   throw new BaseException(ex);
        }
    }
  
 }