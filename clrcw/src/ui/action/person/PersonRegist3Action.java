package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PersonImage;
import model.PersonResume;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist3Action extends BaseAction {
	private static Logger logger = Logger.getLogger(PersonRegist3Action.class);
	/**
	 * 
	 * 描述：查询个人简历主表内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist3(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)    
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			String id = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			//按登陆名查询
			List eee = (List) super.getInviteManager().queryPersonResume(id);
			int j=eee.size();    
			if(eee.size()<=0){
				List bdEducate = (List) super.inviteManager
				.findAllBdEducate();
				List bdPost = (List) super.inviteManager.findAllBdPost();
				request.setAttribute("bdPost", bdPost);
				request.setAttribute("bdEducate", bdEducate);
     

			return mapping.findForward("return");
			}else{
				
				Object[] vvv = (Object[]) eee.get(0);
				PersonResume personResume = (PersonResume) vvv[0];
				String dkind=personResume.getDkind();
				dkind=(super.inviteManager.findPostById(dkind)).getPostName();
				personResume.setDkind(dkind);
//				String imageid=personResume.getFkPersonImage().getId().toString();
				
//				PersonImage image=super.getInviteManager().findPersonImageById(imageid);
				String version="false";
				if(personResume.getFkPersonImage()!=null){

					version="true";
				}
				if(personResume.getName()==null){
					List bdEducate = (List) super.inviteManager
					.findAllBdEducate();    
					List bdPost = (List) super.inviteManager.findAllBdPost();
					request.setAttribute("bdPost", bdPost);
					request.setAttribute("bdEducate", bdEducate);
					
					if(personResume.getName()==null)personResume.setInterests("");
					return mapping.findForward("return");
				}else{
					 //jialuhao根据personcode判断简历表中是否有数据
					
					List<?> list=super.inviteManager.queryApplyJobBypersonId(id);
					if(list.size()==0){
						request.setAttribute("notapply", "notapply");
					}
				request.setAttribute("pr", personResume);
				request.setAttribute("version", version);
				forward = IConstants.SUCCESS_KEY;
				}
			}

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);

	}
}
