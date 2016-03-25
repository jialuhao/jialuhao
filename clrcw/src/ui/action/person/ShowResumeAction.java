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

public class ShowResumeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowResumeAction.class);

	/**
	 * 
	 * 描述：获取个人简历副表的详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward showResume(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {

			String rbid = (String) request.getParameter("id");// 简历副表的id
			// session内容
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List<PersonResumeB> list = super.getInviteManager()
					.findPersonResumesById(username);
			PersonResumeB vvv = new PersonResumeB();
			// 判断PersonResumeB找到需要的数据
			for (int i = 0; i < list.size(); i++) {
				vvv = (PersonResumeB) list.get(i);
				if (vvv.getId() == (new Integer(rbid).intValue()))
					break;
			}
			// 传值
			
//			session.setAttribute("rbid", rbid);
			request.setAttribute("resumeb", vvv);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
}
