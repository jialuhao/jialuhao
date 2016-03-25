package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BdEducate;
import model.PersonResume;
import model.UserInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class ChangeImgAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ChangeImgAction.class);

	/**
	 * 
	 * 描述：上传照片
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward changeImg(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;

		try {
			HttpSession session = request.getSession(true);
			String user = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			// 获取页面数据

			List loginName = (List) super.getInviteManager().findUserByName(
					user);
			List bdEducate = (List) super.inviteManager.findAllBdEducate();

			DynaActionForm dyForm = (DynaActionForm) form;

			FormFile file = (FormFile) dyForm.get("uploadphoto");
			byte[] b = file.getFileData();
			List eee = (List) super.getInviteManager().queryPersonResume(user);
			int j = eee.size();

			Object[] vvv = (Object[]) eee.get(0);
			PersonResume personResume = (PersonResume) vvv[0];
			personResume.setPersonImage(b);
			UserInfo userinfo = (UserInfo) loginName.get(0);
			personResume.setUser(userinfo);
			BdEducate educate = (BdEducate) bdEducate.get(0);
			// BdEducate bdEducate =
			// super.getInviteManager().findEducateById(education);
			personResume.setEducate(educate);
			super.getInviteManager().updatePersonResume(personResume);

			request.setAttribute("pr", personResume);
			request.setAttribute("bdEducate", bdEducate);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}

}
