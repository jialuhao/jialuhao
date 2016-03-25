package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PersonResumeB;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist4Action extends BaseAction {

	private static Logger logger = Logger.getLogger(PersonRegist4Action.class);

	@SuppressWarnings("unchecked")
/**
 * 
 * 描述：得到个人简历副表的全部内容
 * 
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return ActionForward
 * @throws BaseException
 */
	public ActionForward personRegist4(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List<PersonResumeB> list = super.getInviteManager()
					.findPersonResumesById(username);
			List<?> list11=super.inviteManager.queryApplyJobBypersonId(username);
			
			request.setAttribute("resumeb", list);
			if(list11.size()==0){
				request.setAttribute("notapply","notapply");
			}
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

}
