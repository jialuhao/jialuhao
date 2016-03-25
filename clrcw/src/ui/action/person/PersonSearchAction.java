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
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class PersonSearchAction  extends BaseAction{
	private static Logger logger = Logger.getLogger(PersonSearchAction.class);
	
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
  		   String jobName=request.getParameter("textfield3"); 
  		   String address=request.getParameter("address"); 
  		   String publishtime=request.getParameter("publishtime"); 
  		   String compname=request.getParameter("compname"); 
  		   
//			//新加代码
//			String compName1=compname.toLowerCase();
//			if(compName1.indexOf("<SCRIPT>")==-1||compName1.indexOf("</SCRIPT>")==-1||compName1.indexOf("<")==-1||compName1.indexOf(">")==-1)
//			{
//				compname="";
//			}
//			//结束

  		   
  		   PublishJobInfo publishJobInfo=new PublishJobInfo();
  		   publishJobInfo.setJobAmount(jobName);
  		   publishJobInfo.setAddress(address);
  		   publishJobInfo.setCompLoginId(compname);
  		   publishJobInfo.setPublishTime(publishtime);
  		   PaginationSupport pagin=super.getInviteManager().paginationPublishJob(publishJobInfo,pageIndex, pageSize, desc);
  		   List<?> list=pagin.getItems();
  		   int totalCount=pagin.getTotalCount();
  		   int tpp=(int) Math.ceil((totalCount-1)/pageSize);
  		   List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
  		   PublishJobInfo jobInfo=new PublishJobInfo();
  		 	if(list==null)
  		 		 return mapping.findForward("fail");
  		 	else{
  		 		for(int i=0;i<list.size();i++)
  		 		{
  		 			jobInfo=(PublishJobInfo)list.get(i);
  		 			allPublishJobInfo.add(jobInfo);
  		 		}
  		 		request.setAttribute("allPublishJobInfo", allPublishJobInfo);
  		 		request.setAttribute("pageIndex", pageIndex);
  		 		HttpSession session=request.getSession();
  		 		session.removeAttribute("search2");
    		 	session.setAttribute("search2", jobName);
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
    		 	HttpSession session = request.getSession(true);
    		 	String jobName=(String)session.getAttribute("search2");
				int pageSize=12;
				String pnum=(String)PropertyUtils.getSimpleProperty(form,"pageIndex");
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
				
				String address=request.getParameter("address"); 
			  	String publishtime=request.getParameter("publishtime"); 
			  	String compname=request.getParameter("compname"); 

			  		   
			  	PublishJobInfo publishJobInfo=new PublishJobInfo();
			  	publishJobInfo.setJobAmount(jobName);
			  	publishJobInfo.setAddress(address);
			  	publishJobInfo.setCompLoginId(compname);
			  	publishJobInfo.setPublishTime(publishtime);
				PaginationSupport pagin=super.getInviteManager().paginationPublishJob(publishJobInfo,ddd, pageSize, true);
	  		List<?> list=pagin.getItems();
	  		List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
	  		PublishJobInfo jobInfo=new PublishJobInfo();
	  		for(int i=0;i<list.size();i++){
				jobInfo=(PublishJobInfo)list.get(i);
		 		allPublishJobInfo.add(jobInfo);
		 		}
		 	request.setAttribute("allPublishJobInfo", allPublishJobInfo);	
		 	request.setAttribute("pageIndex", ddd);
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
