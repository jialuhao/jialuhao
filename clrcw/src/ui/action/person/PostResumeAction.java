package ui.action.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.CompResume;
import model.PersonMailInfo;
import model.PersonResume;
import model.PublishJobInfo;
import model.UserInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PostResumeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(PostResumeAction.class);

	/**
	 * 
	 * 描述：投递个人简历
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward postResume(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			// 获取相应的投递信息
			PublishJobInfo compJob = (PublishJobInfo) request.getSession()
					.getAttribute("jobinfo");
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List list = super.getInviteManager().queryPersonResume(username);
			if(list.size()==0){
				ActionMessages messages = new ActionMessages();
				messages.add("error", new ActionMessage("errors.resume"));
				super.saveErrors(request, messages);

			}else{
				Object[] vvv = (Object[]) list.get(0);
				PersonResume pkResume = (PersonResume) vvv[0];
				// 组织投递内容
				PersonMailInfo personMailInfo = new PersonMailInfo();
				personMailInfo.setCompJob(compJob);
				personMailInfo.setUserLoginId(username);
				CompResume compResume = new CompResume();
				compResume.setCompLoginId(compJob.getCompLoginId());
				compResume.setCompPost(compJob);
				compResume.setPkResume(pkResume);
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(Calendar.getInstance().getTime());
				compResume.setCreatetime(time);
				//ApplyJobInfo apply = new ApplyJobInfo();
				//apply.setId(compJob.getJob().getId());
				//compResume.setPersonPost(apply);
				// 投递
				super.getInviteManager().savePersonMailInfo(personMailInfo,
						compResume);
				session.removeAttribute("jobinfo");
				forward = IConstants.SUCCESS_KEY;
			}


		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);

	}
	/**
	 * 
	 * 描述：简历刷新功能
	 * jialuhaoadd新加代码
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward refresh(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;
		try {
			// 获取相应的投递信息			
		   
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			
			List list=super.getInviteManager().queryApplyJobBypersonId(username);
			String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(Calendar.getInstance().getTime());
			for(int i=0;i<list.size();i++){
			Object[] vvv = (Object[]) list.get(i);
			ApplyJobInfo applyjobinfo = (ApplyJobInfo) vvv[0];
	    	 
	    	applyjobinfo.setRefreshtime(time);
	    	applyjobinfo.setCreateTime(time);
	    	super.getInviteManager().updateApplyJobInfo(applyjobinfo);
			}  
			List resume =  super.getInviteManager().queryPersonResume(username);
			Object[] eee=(Object[])resume.get(0);
			PersonResume personResume = (PersonResume)eee[0];
	    	 String pkresume=personResume.getId()+"";//得到表中compresume字段pkresume
			List aaaa=super.getInviteManager().findCompResumeBypersonid(pkresume);
			for(int i=0;i<aaaa.size();i++){
				Object[] vvv = (Object[]) aaaa.get(i);
		    	 CompResume compResume = (CompResume) vvv[0];
		    	 compResume.setCreatetime(time);
		    	 super.getInviteManager().updateCompResume(compResume);
			}
			
	    	 forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward("show");
	}	

}
	
