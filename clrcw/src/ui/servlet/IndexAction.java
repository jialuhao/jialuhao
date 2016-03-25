package ui.servlet; 

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
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

public class IndexAction  extends BaseAction{
	private static Logger logger = Logger.getLogger(IndexAction.class);
	
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
     public ActionForward showCompany(ActionMapping mapping, ActionForm form,

             HttpServletRequest request, HttpServletResponse response) throws BaseException{
    	 try{
    		   int pageIndex=0;
    		   int pageSize=10;
    		   boolean desc=true;
    		   PublishJobInfo publishJobInfo =null;
    		   
    		 //企业招聘数据  
    		 PaginationSupport pagin=super.getInviteManager().paginationPublishJob(publishJobInfo,pageIndex, pageSize, desc);
    		 List<?> list=pagin.getItems();
    		 int totalCount=pagin.getTotalCount();
    		 //计算总的页数tpp
    		 int tpp=(int) Math.ceil(totalCount/pageSize);
    		 List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
    		 PublishJobInfo jobInfo=new PublishJobInfo();
    		 if(list==null)
    		 	return mapping.findForward(IConstants.FAIL_KEY);
    		 else{
    		 	for(int i=0;i<list.size();i++)
    		 		{
    		 			jobInfo=(PublishJobInfo)list.get(i);
    		 			allPublishJobInfo.add(jobInfo);
    		 		}
    		 		//request.setAttribute("pJobCount", pJobCount);
    		 	request.setAttribute("publishjobinfo", allPublishJobInfo);
    		 	request.setAttribute("pageIndex", pageIndex);
    		 	HttpSession session=request.getSession();
    		 	session.removeAttribute("totalCount");
    		 	session.setAttribute("totalCount", totalCount);
    		 	session.removeAttribute("tpp");
    		 	session.setAttribute("tpp", tpp);
    		}
    		
    	return mapping.findForward("compIframe");
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
      * 描述：在页面中显示个人求职信息,显示第一页的信息
      * @param mapping
      * @param form
      * @param request
      * @param response
      * @return ActionForward
      * @throws BaseException 
      */
      public ActionForward showPerson(ActionMapping mapping, ActionForm form,

              HttpServletRequest request, HttpServletResponse response) throws BaseException{
     	 try{
     		  
     		   int page=0;
     		   int pageSize=5;
     		   boolean desc=true;
     		  //个人求职数据  
      		 PaginationSupport pagin2=super.getInviteManager().paginationS("",page, pageSize, desc);
      		 List<?> list2=pagin2.getItems();
      		 int personTotalCount=pagin2.getTotalCount();
      		 int tpn=(int) Math.ceil(personTotalCount/pageSize);
      		 List<ApplyJobInfo> all=new ArrayList<ApplyJobInfo>();
      		 ApplyJobInfo oneApply=new ApplyJobInfo();
      		 if(list2==null)
      		 return mapping.findForward(IConstants.FAIL_KEY);
      		 else{
      		 	for(int i=0;i<list2.size();i++){
      		 		oneApply=(ApplyJobInfo)list2.get(i);
      		 		all.add(oneApply);
      		 		}
      		 	//request.setAttribute("pJobCount", pJobCount);
      		 	request.setAttribute("applyJobInfo", all);
      		 	request.setAttribute("comPage", page);
      		 	HttpSession session=request.getSession();
      		 	session.removeAttribute("personTotalCount");
      		 	session.setAttribute("personTotalCount", personTotalCount);
      		 	session.removeAttribute("tpn");
      		 	session.setAttribute("tpn", tpn);
      		 }
      	return mapping.findForward("personIframe");
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
      * 描述：显示企业招聘其他页的信息
      * @param mapping
      * @param form
      * @param request
      * @param response
      * @return ActionForward
      * @throws BaseException 
      */
     
     
     
     public ActionForward comOtherPage(ActionMapping mapping, ActionForm form,
    		 HttpServletRequest request, HttpServletResponse response) throws BaseException{
    	 try {
				int pageSize=10;
				String pnum=(String)PropertyUtils.getSimpleProperty(form,"pageIndex");
				HttpSession session = request.getSession(true);
			    int ppp=(Integer)session.getAttribute("totalCount");
				int tpn=(int) Math.ceil(ppp/pageSize);
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
			PaginationSupport pagin=super.getInviteManager().paginationPublishJob(null,ddd, pageSize, true);
	  		List<?> list=pagin.getItems();
	  		List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
	  		PublishJobInfo jobInfo=new PublishJobInfo();
	  		for(int i=0;i<list.size();i++){
				jobInfo=(PublishJobInfo)list.get(i);
		 		allPublishJobInfo.add(jobInfo);
		 		}
		 	request.setAttribute("publishjobinfo", allPublishJobInfo);	
		 	request.setAttribute("pageIndex", ddd);
		 	return mapping.findForward("compIframe");
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
      * 描述：显示个人求职其他页的信息
      * @param mapping
      * @param form
      * @param request
      * @param response
      * @return ActionForward
      * @throws BaseException 
      */
     
     
     public ActionForward perOtherPage(ActionMapping mapping, ActionForm form,

             HttpServletRequest request, HttpServletResponse response) throws BaseException{
    	 
    	 try {
    		 int pageSize=5;
    		 String pnum=(String)PropertyUtils.getSimpleProperty(form,"comPage");
			 HttpSession session = request.getSession(true);
			 int ppp=(Integer)session.getAttribute("personTotalCount");
			 int tpn=(int) Math.ceil(ppp/pageSize);
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
			PaginationSupport pagin=super.getInviteManager().paginationS("",ddd, pageSize, true);
	  		List<?> list=pagin.getItems();
	  		List<ApplyJobInfo> all=new ArrayList<ApplyJobInfo>();
	  		ApplyJobInfo oneApply=new ApplyJobInfo();
	  		for(int i=0;i<list.size();i++){
	  			oneApply=(ApplyJobInfo)list.get(i);
	  			all.add(oneApply);
		 		}
		 	request.setAttribute("applyJobInfo", all);	
		 	request.setAttribute("comPage", ddd);
		 	return mapping.findForward("personIframe");
    	}catch(BusinessException be){
       	   logger.error(be.getMessage(),be);
       	   throw new BaseException(be);
       	   
         }catch(Exception ex){
       	   logger.error("系统异常:",ex);
       	   throw new BaseException(ex);
          }
     }
 }
