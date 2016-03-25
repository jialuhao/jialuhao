package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Areacode;
import model.BdCompkind;
import model.BdEducate;
import model.BdJob;
import model.BdPost;
import model.BdTrade;
import model.PublishJobInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist7Action extends BaseAction {
	private static Logger logger = Logger.getLogger(PersonRegist7Action.class);

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * 描述：个人查看企业招聘职位的详细内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist7(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			// 获取数据
			String jobId = (String) request.getParameter("jobKey");
			String compName = new String (request.getParameter("compName").getBytes("ISO-8859-1"),"utf-8");
			
	
			Object[] list = (Object[]) super.getInviteManager().queryJobById(
					new Integer(jobId).intValue());
			PublishJobInfo vvv = (PublishJobInfo) list[0];
			
			
//			request.setAttribute("jobinfo", vvv);
			request.setAttribute("compName", compName);
			HttpSession session = request.getSession(true);
			session.removeAttribute("jobinfo");
			session.setAttribute("jobinfo", vvv);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
	 
		public ActionForward showmessage(ActionMapping mapping, ActionForm form,

		HttpServletRequest request, HttpServletResponse response)
				throws BaseException {

			String forward = IConstants.FAIL_KEY;
			try {
				// 获取数据
				String id=request.getParameter("id");
				PublishJobInfo job=super.getInviteManager().findPublishJobById(id);
				List<BdPost> bdPost=super.getInviteManager().findAllBdPost();
		 		List<BdJob> bdJob=super.getInviteManager().findAllBdJob();
		 		List<BdCompkind> bdCompkind=super.getInviteManager().findAllBdCompKind();
		 		List<BdTrade> bdTrade=super.getInviteManager().findAllBdTrade();
		 		List<BdEducate> bdEducate=super.getInviteManager().findAllBdEducate();
		 		List<Areacode> areacode=super.getInviteManager().findAllAreaCode();
				List arealist= super.getInviteManager().findAllAreaCode();
				request.setAttribute("arealist",arealist);
				List salarylist= super.getInviteManager().findAllSalary();
				request.setAttribute("salarylist",salarylist);
				request.setAttribute("bdPost", bdPost);
				request.setAttribute("bdJob", bdJob);
		 		request.setAttribute("bdCompkind", bdCompkind);
		 		request.setAttribute("bdTrade", bdTrade);
		 		request.setAttribute("bdEducate", bdEducate);
		 		request.setAttribute("areacode", areacode);
				
				
				request.setAttribute("oneJob",job);
				request.setAttribute("keyId",id);
				
				request.setAttribute("oneJob",job);
				forward = "showmessage";
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
			return mapping.findForward(forward);
		}
}
