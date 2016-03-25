package ui.action.company;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompanyjspAction  extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanyjspAction.class);

	public ActionForward companyjsp(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response) throws BaseException {

		String forward = IConstants.FAIL_KEY;
		HttpSession session = request.getSession();
		request.getSession().setAttribute("cunzai", "");
		request.getSession().setAttribute("yingye", "");
  	  try{   
  		List list= super.getInviteManager().findAllAreaCode();
  		List<BdCompkind> bdCompkind=super.getInviteManager().findAllBdCompKind();
 		List<BdTrade> bdTrade=super.getInviteManager().findAllBdTrade();
  		System.out.println("---------------"+list.size());
  		session.setAttribute("arealist", list);
  		session.setAttribute("bdCompkind", bdCompkind);
 		session.setAttribute("bdTrade", bdTrade);
        }catch(BusinessException be){	
        	logger.error(be.getMessage(),be);
        	throw new BaseException(be);
     	      
        }catch(Exception ex){
        	logger.error("系统异常:",ex);   
        	throw new BaseException(ex);
        }
        	return mapping.findForward(IConstants.SUCCESS_KEY); //返回页。
		}
        
   
        
       
}
      
