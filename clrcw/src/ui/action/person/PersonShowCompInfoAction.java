package ui.action.person;

import javax.servlet.http.*;
import model.*;

import java.util.*;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.log4j.Logger;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;


public class PersonShowCompInfoAction extends BaseAction{ 
	private static Logger logger = Logger.getLogger(PersonShowCompInfoAction.class);
	/**
     * 
     * 描述：查看个人的详细资料
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showCompInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try {
			HttpSession session=request.getSession();
			String posId=(String)session.getAttribute(IConstants.PERSON_USER_ID);
			if(posId==null){
				ActionMessages messages = new ActionMessages();
				messages.add("loginfirst", new ActionMessage("login.first"));
				super.saveErrors(request, messages);
				return mapping.findForward(IConstants.FAIL_KEY);
			}
			else{
				List<?> list=super.getInviteManager().queryPersonResume(posId);
				PersonResume personResume=new PersonResume();
				if(list!=null){   
					Object[] o=(Object[])list.get(0);
					personResume=(PersonResume)o[0];   
				}            
				//得到用户主键UserKey，登录名loginId
				List<?> cResumelist=super.getInviteManager().findFileBypkResume(personResume.getId()+"");

				Object[] o=(Object[])cResumelist.get(0);
				CompResume compResume=new CompResume();
				compResume=(CompResume)o[0];
				System.out.println(compResume.getCompLoginId());
				ArrayList<CompBespeak> list2=new ArrayList();
				if(cResumelist!=null){
					CompBespeak cbespeak=super.getInviteManager().findCompBespeakById(compResume.getId()+"");
					list2.add(0, cbespeak);
					for(int i=0;i<cResumelist.size();i++){
						Object[] oo=(Object[])cResumelist.get(0);
						compResume=(CompResume)oo[0];
						
						for(int j=0;j<list2.size();j++){
							System.out.println(list2.get(j).getUserId());
							if(!compResume.getCompLoginId().equals(list2.get(j).getUserId())){
								CompBespeak cbespeak1=super.getInviteManager().findCompBespeakById(compResume.getId()+"");
								list2.add(j, cbespeak1);
							}
						}
						
					}
					
				}
				request.setAttribute("CompBespeak", list2);
				
				return mapping.findForward(IConstants.SUCCESS_KEY);
			}
		}catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
		}
	}
	
	

}
	
	