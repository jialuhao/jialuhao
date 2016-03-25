package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PersonEducation;
import model.PersonResume;
import model.PersonResumeB;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist8Action extends BaseAction {

	private static Logger logger = Logger.getLogger(PersonRegist8Action.class);

	@SuppressWarnings("unchecked")
/**
 * 
 * 描述：得到个人简历副表的全部内容（教育培训）
 * 
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return ActionForward
 * @throws BaseException
 */
	public ActionForward personRegist8(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List<PersonEducation> list = super.getInviteManager().findEducationsById(username);

			List<?> list11=super.inviteManager.queryApplyJobBypersonId(username);
			if(list11.size()==0){
				request.setAttribute("notapply", "notapply");
			}
			request.setAttribute("education", list);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
	
	public ActionForward toUpdateEducation(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {    
				String forward = IConstants.FAIL_KEY;
				try {
					String rbid = (String) request.getParameter("id");// 简历副表的id
					// session内容
					HttpSession session = request.getSession(true);
					String username = (String) session
							.getAttribute(IConstants.PERSON_USER_ID);

					List<PersonEducation> list = super.getInviteManager().findEducationsById(username);
					PersonEducation personE = new PersonEducation();
					// 判断PersonResumeB找到需要的数据
					for (int i = 0; i < list.size(); i++) {
						personE = (PersonEducation) list.get(i);
						if (personE.getId() == (new Integer(rbid).intValue()))
							break;
					}
					request.setAttribute("education", personE);
					forward = "toupdate";
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward(forward);
			}
	

}
