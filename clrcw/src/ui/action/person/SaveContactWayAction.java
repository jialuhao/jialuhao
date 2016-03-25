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

public class SaveContactWayAction extends BaseAction {
	private static Logger logger = Logger
	.getLogger(SaveContactWayAction.class);

/**
* 
* 描述：保存个人联系方式
* 
* @param mapping
* @param form
* @param request
* @param response
* @return ActionForward
* @throws BaseException
*/
public ActionForward saveContactWay(ActionMapping mapping,
	ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
	throws BaseException {

String forward = IConstants.FAIL_KEY;

try {
	HttpSession session = request.getSession(true);
	String username = (String) session
			.getAttribute(IConstants.PERSON_USER_ID);
	String nowadd = (String) request.getParameter("nowadd");
	String postcode = (String)request.getParameter("postcode");
	String telnum = (String)request.getParameter("telnum");
	List eee = (List) super.getInviteManager().queryPersonResume(username);
	Object[] vvv = (Object[]) eee.get(0);
	PersonResume personResume = (PersonResume) vvv[0];
	personResume.setAddress(nowadd);
	personResume.setMailcode(postcode);
	personResume.setPhone(telnum);
	super.getInviteManager().updatePersonResume(personResume);
	
//	request.setAttribute("pr", personResume);
	forward = IConstants.SUCCESS_KEY;
} catch (Exception ex) {
	logger.error("系统异常:", ex);
	throw new BaseException(ex);
}
return mapping.findForward(forward);
}

}
