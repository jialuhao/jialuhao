package action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ApplyJobInfo;
import model.PersonResume;
import model.UserInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.exception.BaseException;
import common.ui.BaseAction;

public class testFindCompInfoByIdAction extends BaseAction {

      
      private static Logger logger = Logger.getLogger(testFindCompInfoByIdAction.class);
      
      
      @SuppressWarnings("unchecked")
	public ActionForward show(ActionMapping mapping, ActionForm form,

              HttpServletRequest request, HttpServletResponse response) throws BaseException {
      try{
    	  String userId=request.getParameter("userId");
    	  String resumeId=request.getParameter("resumeId");
    	  List list=super.getInviteManager().showResumeInComp(userId, resumeId);
    	  if(list.size()>0){
    	  
    	  Object[] obj = (Object[])list.get(0);

    		  ApplyJobInfo a = (ApplyJobInfo)obj[0];
    		  UserInfo u = (UserInfo)obj[1];
    		  PersonResume p = (PersonResume)obj[2];
    		  Vector v = new Vector();
    		  v.add(obj[0]);
    		  
    	  if(list.size()>0){
    		  request.setAttribute("userId", userId);
    		  request.setAttribute("id",resumeId);
    		  //request.setAttribute("info",v);
    		  request.setAttribute("a",a);
    		  request.setAttribute("p",p);
    		  request.setAttribute("u",u);
    		  return mapping.findForward("success");
    	  }
    	  else
    		  return mapping.findForward("fail");
    	  }
    	  else
    		  return mapping.findForward("fail");
      }catch(Exception ex){
		  logger.error("系统异常:",ex);
		  throw new BaseException(ex);
		 
	  } 
	  		
  }
}

