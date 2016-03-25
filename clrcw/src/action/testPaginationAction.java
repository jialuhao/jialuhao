package action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfo;
import model.ApplyJobInfo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;
import service.InviteManager;
import service.InviteManagerImpl;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class testPaginationAction extends BaseAction {

      
      private static Logger logger = Logger.getLogger(testPaginationAction.class);
      
      public ActionForward show(ActionMapping mapping, ActionForm form,

              HttpServletRequest request, HttpServletResponse response) throws BaseException {
      try{
    	 //DynaValidatorForm paginationForm=(DynaValidatorForm)form;
    	 //String pageIndex=(String)paginationForm.get("pageIndex");
    	 //String pageSize=(String)paginationForm.get("pageSize");
    	 //String order=(String)paginationForm.get("order");
    	 //request.setAttribute("paginationForm", paginationForm);
    	    String pageIndex = (String) PropertyUtils.getSimpleProperty(form, "pageIndex");
	  		String pageSize = (String) PropertyUtils.getSimpleProperty(form, "pageSize");
	  		String order = (String) PropertyUtils.getSimpleProperty(form, "order");
	  		
	  		int ipageIndex=new Integer(pageIndex).intValue();
	  		int ipageSize=new Integer(pageSize).intValue();
	  		boolean border=new Boolean(order).booleanValue();
	  		
	  		List<ApplyJobInfo> list=(List<ApplyJobInfo>)super.getInviteManager().paginationS("",ipageIndex, ipageSize, border);
	  		LinkedList<?> aa=new LinkedList<String>();
	  		aa.getFirst();
	  	
	  		request.setAttribute("paginationData", list);
	  	
	  		return mapping.findForward("success");
      }catch(Exception ex){
		  logger.error("系统异常:",ex);
		  throw new BaseException(ex);
		 
	  } 
	  		
  }
}

