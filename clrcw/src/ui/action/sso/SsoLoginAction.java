package ui.action.sso;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import asop.sso.ws.SsoWebServiceLocator;
import asop.sso.ws.SsoWebServicePortTypeProxy;
import asop.sso.ws.xsd.UserInfo;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

/**
 *<p>Title: </p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class SsoLoginAction extends BaseAction {

	private static Logger logger = Logger.getLogger(SsoLoginAction.class);
	public ActionForward login(ActionMapping mapping, ActionForm form,

            HttpServletRequest request, HttpServletResponse response) throws BaseException{
		
		String forward="IConstants.ERROR_KEY";
		try{
			boolean isAppName= false;
			String token = request.getParameter("token");
			//String appname = request.getParameter("appname");
			String type = request.getParameter("type");
			HttpSession session=request.getSession();
			SsoWebServiceLocator ssoLocator = new SsoWebServiceLocator();
			String url = ssoLocator.getSsoWebServiceSOAP11port_httpAddress();
			//EngineConfiguration e = new EngineConfiguration();
			
			//String url="http://172.17.1.99:9191/asop-ua-ws/services/SsoWebService";
			//获得Stub实例
			SsoWebServicePortTypeProxy s = new SsoWebServicePortTypeProxy();
			s.setEndpoint(url);
			UserInfo userinfo = s.loginByToken(token, IConstants.APPNAME);
			String name = userinfo.getMapUserName();
			String ssoname = userinfo.getUserName();
			
			session.setAttribute(IConstants.SSO_NAME, ssoname);
			if(IConstants.Person.equals(type)){
				forward = "personLogin";
				if(name!=null){
				//session.setAttribute(IConstants.PERSON_USER_ID, userinfo.getMapUserName());
				List<model.UserInfo> user = super.getInviteManager().findAllUserInfo();
				for(int i = 0;i<user.size();i++){
					if(name.equalsIgnoreCase(user.get(i).getLoginId()))
						isAppName= true;
				}
				}
			}
			else if(IConstants.Company.equals(type)){
				forward = "compLogin";
				if(name!=null){
				//session.setAttribute(IConstants.COMP_USER_ID, userinfo.getMapUserName());
				List<model.CompBespeak> comp = super.getInviteManager().findAllCompEnroll();
				for(int i = 0;i<comp.size();i++){
					if(name.equalsIgnoreCase(comp.get(i).getUserId())){
						isAppName= true;
						break;
					}
				}
				}
			}
			
			if(userinfo.getHasError()){
				userinfo.getErrorMessage();
				return mapping.findForward(IConstants.ERROR_KEY);
			}else{
				if(name!=null && isAppName ){
					if(IConstants.Person.equals(type)){
						forward = "personsuccess";
						session.setAttribute(IConstants.PERSON_USER_ID, userinfo.getMapUserName());
						
						
					}
					else if(IConstants.Company.equals(type)){
						forward = "compsuccess";
						session.setAttribute(IConstants.COMP_USER_ID, userinfo.getMapUserName());
						
					}
					session.setAttribute(IConstants.TOKEN,token);
				}
			}
		}
		
		catch(Exception be){
			be.printStackTrace();
			logger.error(be.getMessage());
			throw new BaseException(be);
		}
		
		return mapping.findForward(forward);
	}
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return login(mapping, form, request, response);
	}
	
}
