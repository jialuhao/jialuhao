package ui.action.person;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.BdEducate;
import model.BdJob;
import model.BdPost;
import model.BdTrade;
import model.PersonResume;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist6Action extends BaseAction {
	private static Logger logger = Logger.getLogger(PersonRegist6Action.class);
	/**
	 * 
	 * 描述：保存个人意向（欲求职位）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist6(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;

		try {
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			String post = (String) request.getParameter( "post");
			String job = (String) request.getParameter( "job");
			String workyears = (String) request.getParameter("workyears");
			workyears=workyears.substring(0,workyears.length()-1);
			String salary = (String) request.getParameter("salary");

			BdTrade bdPost=super.getInviteManager().findTradeById(post);
			BdJob bdJob=super.getInviteManager().findJobById(job);
			

			List www = (List) super.getInviteManager().findUserByName(username);
			UserInfo personCode = (UserInfo) www.get(0);
			List uuu = (List) super.getInviteManager().queryPersonResume(
					username);
			Object[] vvv = (Object[]) uuu.get(0);
			PersonResume resumeCode = (PersonResume) vvv[0];
			personCode.setLoginId(username);
			resumeCode.setState("0");
			resumeCode.setOpinion("");
			super.getInviteManager().updatePersonResume(resumeCode);
			ApplyJobInfo applyJobInfo = new ApplyJobInfo();
			applyJobInfo.setPostCode(bdPost);
			applyJobInfo.setJobCode(bdJob);
			applyJobInfo.setWorkYear(workyears);
			applyJobInfo.setSalary(salary);
			applyJobInfo.setPersonCode(personCode);
			applyJobInfo.setResumeCode(resumeCode);
			String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(Calendar
					.getInstance().getTime());
			
			applyJobInfo.setCreateTime(createTime);
			//保存个人意向
			super.getInviteManager().saveApplyJob(applyJobInfo);
			//组织返回页面的数据
//			List eee = (List) super.getInviteManager().findAllBdPost();
//			request.setAttribute("bdPost", eee);
//			List rrr = (List) super.getInviteManager().findAllBdJob();
//			request.setAttribute("bdJob", rrr);
//			List list = super.getInviteManager().queryApplyJobById(username);
//			request.setAttribute("allapply", list);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
}
