package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.PersonResume;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class DelApplyAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DelApplyAction.class);
	/**
     * 
     * 描述：删除个人求职意向
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	
	public ActionForward delApply(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			List eee1 = (List) super.getInviteManager().queryPersonResume(
					username);
			Object[] vvv1 = (Object[]) eee1.get(0);
			PersonResume personResume = (PersonResume) vvv1[0];
			
			//保存更新
			personResume.setState("0");
			personResume.setOpinion("");
			super.getInviteManager().updatePersonResume(personResume);
			String delId = (String) request.getParameter("delId");//获取删除id
//			ApplyJobInfo applyJobInfo = new ApplyJobInfo();
			List vvv=super.getInviteManager().findApplyJobInfoById(delId);
			Object[]ttt=(Object[])vvv.get(0);
			ApplyJobInfo applyJobInfo = (ApplyJobInfo)ttt[0];
/*			for(int i=0;i<vvv.size();i++){
				Object[]ttt=(Object[])vvv.get(i);
				applyJobInfo=(ApplyJobInfo)ttt[0];
				if(applyJobInfo.getId()==new Integer(delId).intValue())
					break;
			}*/
			//调用删除方法
			super.getInviteManager().delAppJobInfo(applyJobInfo);
			//组织返回页面的数据
			List eee = (List) super.getInviteManager().findAllBdPost();
			request.setAttribute("bdPost", eee);
			List rrr = (List) super.getInviteManager().findAllBdJob();
			request.setAttribute("bdJob", rrr);
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
