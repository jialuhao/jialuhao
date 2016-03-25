package ui.action.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.CompBespeak;
import model.PublishJobInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import ui.action.person.LoginAction;


import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompanyLoginAction extends BaseAction{

    private static Logger logger = Logger.getLogger(LoginAction.class);
    /**
     * 
     * 描述：企业用户登陆action
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws BaseException 
     */
    public ActionForward login(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws BaseException {
  	  String forward = IConstants.FAIL_KEY;
  	  try{
  	  		String userId = (String) PropertyUtils.getSimpleProperty(form, "userId");
  	  		String password = (String) PropertyUtils.getSimpleProperty(form, "password");
  	  		List<CompBespeak> list = this.authenticate(form);

  	  		if(list.isEmpty()){
  	  				ActionMessages messages = new ActionMessages();
  	  				messages.add("noUser", new ActionMessage("errors.user"));
  	  				super.saveErrors(request, messages);
  	  		}
  	  		else{
  	  			String md5Password = DigestUtils.md5Hex(password);
  	  			for(int i=0;i<list.size();i++){  
  	  			CompBespeak compBespeak=(CompBespeak)list.get(i);
  	  				//判断md5密码相同且通过审核（status=1）
  	  				if(md5Password.equals(compBespeak.getPassword())&&"1".equals(compBespeak.getCompStatus())){
  	  					HttpSession session = request.getSession(true);
  	  					String ssoname = (String)session.getAttribute(IConstants.SSO_NAME);
  	  				//	SsoWebServicePortTypeProxy s = new SsoWebServicePortTypeProxy();
  	  				//	s.registerMapUser(ssoname, IConstants.APPNAME, userId);
  	  				    //获得企业招聘信息的审核状态
  	  					
  	  				    session.removeAttribute(IConstants.COMP_USER_ID);
  	  					session.setAttribute(IConstants.COMP_USER_ID,userId);
  	  					session.setAttribute("compBespeakId",compBespeak.getId());
  	  					session.setAttribute("compBespeakInfo", compBespeak);
  	  					return mapping.findForward(IConstants.SUCCESS_KEY);	
  	  					
			        }
			    }
  	  			ActionMessages messages = new ActionMessages();
    			messages.add("noUser", new ActionMessage("error.audi"));
    			super.saveErrors(request, messages);
    			
  	  		}
  	  }
  	  catch(Exception ex){
  		  logger.error("系统异常:",ex);
  		  throw new BaseException(ex);
  	  } 
  	 
  	  		return mapping.findForward(forward);	
    }
    
    
    private List<CompBespeak> authenticate(ActionForm form)throws Exception {
  	  String userId = (String) PropertyUtils.getSimpleProperty(form, "userId");
  	  //List list = null;
  	  List<CompBespeak> list = super.getInviteManager().queryCompUserById(userId);
  	  return list;
    }
    /**
     * 
     * 描述：企业退出登陆action
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws BaseException 
     */
    public ActionForward loginOut(ActionMapping mapping, ActionForm form,
    			HttpServletRequest request, HttpServletResponse response) throws BaseException {
    	String forward = IConstants.FAIL_KEY;
    	try {
    			HttpSession session = request.getSession(true);
    			session.invalidate();
    			
    			ActionMessages messages = new ActionMessages();
    			messages.add("noUser", new ActionMessage("login.out"));
    			super.saveErrors(request, messages);
    			
    			
    		} catch (Exception ex) {
    			logger.error("系统异常:", ex);
    		}
    		return mapping.findForward(forward);
    	}
    
    public ActionForward companyzc(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response) throws BaseException {

    			String forward = IConstants.FAIL_KEY;
    			HttpSession session = request.getSession();
    			System.out.println("---------------");
    	  	  try{   
    	  		List list= super.getInviteManager().findAllAreaCode();
    	  		System.out.println("---------------"+list.size());
    	  		session.setAttribute("arealist", list);
    	 	
    	        }catch(BusinessException be){
    	        	logger.error(be.getMessage(),be);
    	        	throw new BaseException(be);
    	     	      
    	        }catch(Exception ex){
    	        	logger.error("系统异常:",ex);   
    	        	throw new BaseException(ex);
    	        }
    	        	return mapping.findForward("zc"); //返回页。
    			}
    }
  	  
