package ui.action.admin;

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

import util.JobShearchObject;
import util.PaginationSupport;
import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;
/**
 * 确认审核
 * @author suas
 *
 */
public class SHApplyJobAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DelJobAction.class);

	public ActionForward updateAJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session = request.getSession();
		String forward = IConstants.FAIL_KEY;
		try {

			String delId = (String) PropertyUtils.getSimpleProperty(form,
					"delId");
			
			
			session.setAttribute("delId",delId);
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);

	}
/*
 * 审核状态保存
 */
	public ActionForward bathUpdateAJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("delId");
		String state=request.getParameter("status");
		String opinion=request.getParameter("opinion");
		String forward = IConstants.FAIL_KEY;
		try {
			List list=super.getInviteManager().queryPersonResume(id);
			Object[] ttt=(Object[])list.get(0);
			PersonResume personresume=(PersonResume)ttt[0];
			personresume.setState(state);
			personresume.setOpinion(opinion);
			super.getInviteManager().updatePersonResume(personresume);
		forward="bathUpdateAJob";
		}

		 catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}
		 
		return mapping.findForward(forward);

	}
	/*
	 * 批量审核通过或不通过
	 */
	
	public ActionForward updateperson(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {

				String forward = IConstants.FAIL_KEY;
				String uname = request.getParameter("uname");
//				String qjobid = request.getParameter("qjobid");
				String postId = request.getParameter("postId");
				String sta = request.getParameter("sta");
//				String sTime = request.getParameter("sTime");
//				String eTime = request.getParameter("eTime");
//				String salary=request.getParameter("salary");
				String education=request.getParameter("education");
				String workyear=request.getParameter("workyear");
				JobShearchObject object= new JobShearchObject();
				object.setPostId(postId);//残疾类别
				//object.setQjobid(qjobid);
				object.setQname(uname);
				object.setSta(sta);
				//object.seteTime(eTime);
				//object.setsTime(sTime);
				object.setEducation(education);
				//object.setSalary(salary);
				object.setWorkyear(workyear);//区县
				try {
					String shapp = (String) PropertyUtils.getSimpleProperty(form,"shapp");// 页码
					String[] arr = request.getParameterValues("ids");
					if (arr != null && arr.length > 0) {
						for (int i = 0; i < arr.length; i++) {
							List oneApply=super.getInviteManager().queryPersonResume(arr[i]);							
							Object[] ttt=(Object[])oneApply.get(0);
							PersonResume personresume=(PersonResume)ttt[0];
							personresume.setState(shapp);
							if(shapp.equals("2")){
							personresume.setOpinion("同意");
							}else{
								personresume.setOpinion("不同意");
							}
							super.getInviteManager().updatePersonResume(personresume);
						}
					int pageSize = 10;// 设定显示行数
					String pnum = (String) PropertyUtils.getSimpleProperty(form,"apppnum");// 页码
					HttpSession session = request.getSession(true);
					
					int ppp = (Integer) session.getAttribute("apptotleCount");
					int tpn = ppp;// 总页数
					int pn = new Integer(pnum).intValue();// 页码
					int ddd;
					if (pn >= tpn) {
						ddd = tpn;
					} else if (pn <= 0) {
						ddd = 0;
					} else {
						ddd = pn;
					}
					PaginationSupport vvv = super.getInviteManager().paginationpersonresume(object,ddd, pageSize, false);
					List list = (List) vvv.getItems();
					session.removeAttribute("appInfo");
					session.removeAttribute("apppagenum");
					session.setAttribute("personresume", list);
					session.setAttribute("apppagenum", ddd);
					
					session.setAttribute("uname", uname);
					//session.setAttribute("qjobid", qjobid);
					session.setAttribute("postId", postId);
					session.setAttribute("sta", sta);
//					session.setAttribute("sTime", sTime);
//					session.setAttribute("eTime", eTime);
//					session.setAttribute("salary", salary);
					session.setAttribute("workyear", workyear);
					session.setAttribute("education", education);
					forward="updateperson";
					}
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);

				}

				return mapping.findForward(forward);
			}
}
