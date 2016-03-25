package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.PersonImage;
import model.PersonResume;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class ResumeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ResumeAction.class);

	/**
	 * jialuhao  add
	 * 描述：查询返回个人简历内容（并将审核状态改为未审核）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward resume(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			// 获取简历内容
			String id = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List eee = (List) super.getInviteManager().queryPersonResume(id);
			Object[] vvv = (Object[]) eee.get(0);
			PersonResume personResume = (PersonResume) vvv[0];
			personResume.setState("0");
			super.getInviteManager().updatePersonResume(personResume);
			//修改审核状态
			String pkresume=personResume.getId()+"";		
			String userid=personResume.getUser().getId()+"";
			List list = super.getInviteManager().showResumeInComp(userid,pkresume);//一个人的信息
			ApplyJobInfo applyJobInfo=null;
		for(int i=0;i<list.size();i++){
			Object[] ttt=(Object[])list.get(i);
			  applyJobInfo=(ApplyJobInfo)ttt[0];
			  
			  super.getInviteManager().updateApplyJobInfo(applyJobInfo);
		}
			
	String version="false";    
			if(personResume.getFkPersonImage()!=null){
				version="true";
			}
			// 判断是否为空
			if (eee == null) {  
				forward = IConstants.FAIL_KEY;
			} else {  
				request.setAttribute("version", version);
				request.setAttribute("pr", personResume);
				
				forward = IConstants.SUCCESS_KEY;
			}
			// 得到学历信息
			List bdEducate = (List) super.inviteManager.findAllBdEducate();
			request.setAttribute("bdEducate", bdEducate);
			List bdPost = (List) super.inviteManager.findAllBdPost();
			request.setAttribute("bdPost", bdPost);
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward(forward);

	}
}
