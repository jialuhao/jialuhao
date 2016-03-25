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

public class CompanySearchAction  extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanySearchAction.class);
	
	 /**
     * 
     * 描述：在页面中显示个人求职信息
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
    		 String search=request.getParameter("textfield3");
    		 int pageIndex=0;
    		 int pageSize=12;
    		 boolean desc=true;
    		 ApplyJobInfo applyJobInfo= new ApplyJobInfo();
			 model.BdJob jobCode =new model.BdJob();
			 jobCode.setJobName(search);
			 applyJobInfo.setJobCode(jobCode);
			 UserInfo personCode =new UserInfo();
			 applyJobInfo.setPersonCode(personCode);
    		 PaginationSupport pagin=super.getInviteManager().paginationStrategy(applyJobInfo,pageIndex, pageSize, desc);
    		 List<?> list=pagin.getItems();
    		 int personTotalCount=pagin.getTotalCount();
    		 int tpn=(int) Math.ceil((personTotalCount-1)/pageSize);
    		 List<ApplyJobInfo> all=new ArrayList<ApplyJobInfo>();
    		 ApplyJobInfo oneApply=new ApplyJobInfo();
    		 if(list==null)
    		 	return mapping.findForward(IConstants.FAIL_KEY);
    		 else{
    		 	for(int i=0;i<list.size();i++){
    		 		oneApply=(ApplyJobInfo)list.get(i);
    		 		String time=oneApply.getCreateTime();
    		 		time=time.substring(0,10);
    		 		oneApply.setCreateTime(time);
    		 		all.add(oneApply);
    		 		}
    		 	request.setAttribute("allApplyJobInfo", all);
    		 	request.setAttribute("pageIndex", pageIndex);
    		 	HttpSession session=request.getSession();
    		 	session.removeAttribute("search");
    		 	session.setAttribute("search", search);
    		 	session.removeAttribute("personTotalCount");
    		 	session.setAttribute("personTotalCount", personTotalCount);
    		 	session.removeAttribute("tpn");
    		 	session.setAttribute("tpn", tpn);
    		 	return mapping.findForward(IConstants.SUCCESS_KEY);
    		 	}
    	 }catch(BusinessException be){
           	   logger.error(be.getMessage(),be);
           	   ActionMessages messages = new ActionMessages();
           	   messages.add("error", new ActionMessage("error.DB"));
           	   super.saveErrors(request, messages);
           	   return mapping.findForward(IConstants.ERROR_KEY);
           	
         }catch(Exception ex){
           	   logger.error("系统异常:",ex);
           	   ActionMessages messages = new ActionMessages();
           	   messages.add("error", new ActionMessage("error.inform"));
           	   super.saveErrors(request, messages);
           	   return mapping.findForward(IConstants.ERROR_KEY);
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
    		 String search=(String)session.getAttribute("search");
    		 int pageSize=12;
    		 String pnum=(String)PropertyUtils.getSimpleProperty(form,"pageIndex");
			
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
			 ApplyJobInfo applyJobInfo= new ApplyJobInfo();
			 model.BdJob jobCode =new model.BdJob();
			 jobCode.setJobName(search);
			 applyJobInfo.setJobCode(jobCode);
			 model.UserInfo personCode =new model.UserInfo();
			 applyJobInfo.setPersonCode(personCode);
			PaginationSupport pagin=super.getInviteManager().paginationStrategy(applyJobInfo,ddd, pageSize, true);
	  		List<?> list=pagin.getItems();
	  		List<ApplyJobInfo> all=new ArrayList<ApplyJobInfo>();
	  		ApplyJobInfo oneApply=new ApplyJobInfo();
	  		for(int i=0;i<list.size();i++){
	  			oneApply=(ApplyJobInfo)list.get(i);
	  			String time=oneApply.getCreateTime();
		 		time=time.substring(0,10);
		 		oneApply.setCreateTime(time);
	  			all.add(oneApply);
		 		}
		 	request.setAttribute("allApplyJobInfo", all);	
		 	request.setAttribute("pageIndex", ddd);
		 	session.removeAttribute("search");
		 	session.setAttribute("search", search);
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
