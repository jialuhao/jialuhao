package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PersonImage;
import model.PersonResume;
import model.ApplyJobInfo;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class ResumeViewAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ResumeViewAction.class);

	/**
	 * 
	 * 描述：个人简历预览内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward resumeView(ActionMapping mapping, ActionForm form,

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
			String dkind=personResume.getDkind();
			dkind=(super.inviteManager.findPostById(dkind)).getPostName();
			personResume.setDkind(dkind);
//			String imageid=personResume.getFkPersonImage().getId().toString();
//			
//			PersonImage image=super.getInviteManager().findPersonImageById(imageid);
//
			String version="false";
			if(personResume.getFkPersonImage()!=null){
				version="true";
			}
			List list = (List) super.getInviteManager().findPersonResumesById(
					id);
			List applyList = super.getInviteManager().queryApplyJobById(id);
			List educations = super.getInviteManager().findEducationsById(id);
           // ApplyJobInfo userInfo = (ApplyJobInfo) list.get(i);//提取审核状态			
			//String state=userInfo.getDatatime();
			request.setAttribute("allapply", applyList);//求职信息
			request.setAttribute("resumeb", list);//工作/实习经历
			request.setAttribute("version", version);
			request.setAttribute("educations", educations);//教育培训经历
			request.setAttribute("pr", personResume);//基本情况
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		return mapping.findForward(forward);

	}
}
