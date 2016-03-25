package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonApplyListAction extends BaseAction {
	private static Logger logger = Logger
			.getLogger(PersonApplyListAction.class);

	/**
	 * 
	 * 描述：取得所有个人职位意向列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personApplyList(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		// 取得所有的岗位列表
		try {
			List bdPost = (List) super.getInviteManager().findAllBdPost();
			request.setAttribute("bdPost", bdPost);
			List bdJob = (List) super.getInviteManager().findAllBdJob();
			request.setAttribute("bdJob", bdJob);
			List salarylist= super.getInviteManager().findAllSalary();
			request.setAttribute("salarylist",salarylist);
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			// 得到个人申请的职位
			List list = super.getInviteManager().queryApplyJobById(username);
			request.setAttribute("allapply", list);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

}
