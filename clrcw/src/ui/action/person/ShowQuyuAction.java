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

public class ShowQuyuAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ShowQuyuAction.class);

	
	public ActionForward showQuyuAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				try {
					
					String quyu = (String) request.getParameter("quyu");
					if(quyu!=null){
					quyu=new String(new String(quyu.getBytes("ISO8859-1"),"UTF-8"));}
					List list = (List) super.getInviteManager().findAllAreaCode();
					HttpSession session = request.getSession(true);
					String[]quyus=null;
					if(quyu!=null){
						quyus=quyu.split(",");
					}
					session.setAttribute("quyulist", list);
					
					session.setAttribute("quyus", quyus);
					// request.setAttribute("bdJob", bdJob);
					forward = "quyu";

				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					 throw new BaseException(ex);
				}
				return mapping.findForward(forward);
			}
}
