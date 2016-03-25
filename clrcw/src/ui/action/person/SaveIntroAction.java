package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PersonResume;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class SaveIntroAction extends BaseAction {

	private static Logger logger = Logger.getLogger(SaveIntroAction.class);

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * 描述：保存个人说明
	 * 添加：修改审核状态信息（jialuhao）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward saveIntro(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {//获取内容
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			String intro = (String) request.getParameter("intro");
			String interests = (String) request.getParameter("interests");
			PersonResume personResume = new PersonResume();
			//组织数据
			List eee = (List) super.getInviteManager().queryPersonResume(
					username);
			Object[] vvv = (Object[]) eee.get(0);
			personResume = (PersonResume) vvv[0];
			personResume.setInterests(interests);
			personResume.setIntroSelf(intro);
			//保存更新
			personResume.setState("0");
			personResume.setOpinion("");
			super.getInviteManager().updatePersonResume(personResume);
			request.setAttribute("interests", interests);
			request.setAttribute("intro", intro);

			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}

}
