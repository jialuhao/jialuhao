package ui.action.person;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.PersonEducation;
import model.PersonResume;
import model.PersonResumeB;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class PersonRegist8_1Action extends BaseAction {
	private static Logger logger = Logger
			.getLogger(PersonRegist8_1Action.class);

	/**
	 * 
	 * 添加：修改审核状态信息（jialuhao）
	 * 描述：添加并返回添加后个人简历副表的全部内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist8_1(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			// 获取数据
			String username = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);

			List login = (List) super.getInviteManager().findUserByName(
					username);
			UserInfo userInfo = (UserInfo) login.get(0);
			String id = userInfo.getId() + "";

			// PersonResume personResume = (PersonResume)
			// super.getInviteManager().findPersonResumeById(id.trim());
			List vvv = super.getInviteManager().findPersonResumeById(id);
			Object[] ttt = (Object[]) vvv.get(0);
			PersonResume personResume = (PersonResume) ttt[0];
			personResume.setOpinion("");
			personResume.setState("0");
			super.getInviteManager().updatePersonResume(personResume);
			String stime = (String) request.getParameter("stime");
			String etime = (String) request.getParameter("etime");
			String schoolname = (String) request.getParameter("schoolname");
			String profession = (String) request.getParameter("profession");
			String education = (String) request.getParameter("education");
			// 组织数据
			PersonEducation personEducation = new PersonEducation();
			personEducation.setResume(personResume);
			personEducation.setStartTime(stime);
			personEducation.setEndTime(etime);
			personEducation.setSchoolname(schoolname);
			personEducation.setProfession(profession);
			personEducation.setEducation(education);
			personEducation.setUserLoginId(username);
			// 保存数据
			super.getInviteManager().savePersonEducation(personEducation);
			//取最新毕业院校
			List<PersonEducation> edu = super.getInviteManager().findEducationsById(username);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long date=0;
			String school=null;
			if(edu!=null&&edu.size()>0){
			
			for(int i=0;i<edu.size();i++){
				PersonEducation personeducation=edu.get(i);
				String endtime=personeducation.getEndTime();
				
				long date1 = sdf.parse(endtime).getTime();
				if(date1>date){
					date=date1;
					school=personeducation.getSchoolname();
				}
}
				
			}
			personResume.setSchool(school);
			super.getInviteManager().updatePersonResume(personResume);
			
			// 查询表数据
			List list = (List) super.getInviteManager().findPersonResumesById(
					username);
			request.setAttribute("education", list);
			forward = IConstants.SUCCESS_KEY;
			
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);

	}
	/**
	 * 
	 * 描述：修改并返回教育经历列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward editPersonEducation(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				HttpSession session = request.getSession(true);
				String username = (String) session
				.getAttribute(IConstants.PERSON_USER_ID);
				try {
					String rbid = (String)request.getParameter("rbid");
					// 查询登陆信息
					List login = (List) super.getInviteManager().findUserByName(username);
					UserInfo userInfo = (UserInfo) login.get(0);
					String id = userInfo.getId() + "";
					List<PersonEducation> list = super.getInviteManager().findEducationsById(username);
					List resume =  super.getInviteManager().queryPersonResume(username);
					Object[] eee=(Object[])resume.get(0);
					PersonResume personResume = (PersonResume)eee[0];
					personResume.setState("0");
					personResume.setOpinion("");
					super.getInviteManager().updatePersonResume(personResume);
					String stime = (String) request.getParameter("stime");
					String etime = (String) request.getParameter("etime");
					String schoolname = (String) request.getParameter("schoolname");
					String profession = (String) request.getParameter("profession");
					String education = (String) request.getParameter("education");
					PersonEducation personEducation=new PersonEducation();
					for (int i = 0; i < list.size(); i++) {
						personEducation = (PersonEducation) list.get(i);
						if (personEducation.getId() == (new Integer(rbid).intValue()))
							break;
					}
					
//					PersonResumeB personResumeB = (PersonResumeB)list.get(0);
					personEducation.setResume(personResume);
					personEducation.setStartTime(stime);
					personEducation.setEndTime(etime);
					personEducation.setEducation(education);
					personEducation.setProfession(profession);
					personEducation.setSchoolname(schoolname);
					personEducation.setId(new Integer(rbid).intValue());
					personEducation.setUserLoginId(username);
					personEducation.setDr("0");
					super.getInviteManager().updatePersonEducation(personEducation);					
					request.setAttribute("education", list);
					//取最新毕业院校
					List<PersonEducation> edu = super.getInviteManager().findEducationsById(username);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					long date=0;
					String school=null;
					if(edu!=null&&edu.size()>0){
					
					for(int i=0;i<edu.size();i++){
						PersonEducation personeducation=edu.get(i);
						String endtime=personeducation.getEndTime();
						
						long date1 = sdf.parse(endtime).getTime();
						if(date1>date){
							date=date1;
							school=personeducation.getSchoolname();
						}
		}
						
					}
					personResume.setSchool(school);
					super.getInviteManager().updatePersonResume(personResume);
				
					forward = IConstants.SUCCESS_KEY;
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward(forward);
			}
	/**
	 * 
	 * 描述：删除并返回教育经历列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward delPersonEducation(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				HttpSession session = request.getSession(true);
				String username = (String) session
				.getAttribute(IConstants.PERSON_USER_ID);
				String delId = (String) request.getParameter("delId");//获取删除id

				try {
					List<PersonEducation> list = super.getInviteManager().findEducationsByEduId(delId);
					PersonEducation personEducation=new PersonEducation();
					personEducation = (PersonEducation) list.get(0);
					//调用删除方法
					super.getInviteManager().delPersonEducation(personEducation);
					List resume =  super.getInviteManager().queryPersonResume(username);
					Object[] eee=(Object[])resume.get(0);
					PersonResume personResume = (PersonResume)eee[0];
					personResume.setState("0");
					personResume.setOpinion("");
					super.getInviteManager().updatePersonResume(personResume);
					//取最新毕业院校
					
					List<PersonEducation> edu = super.getInviteManager().findEducationsById(username);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					long date=0;
					String school=null;
					if(edu!=null&&edu.size()>0){
					
					for(int i=0;i<edu.size();i++){
						PersonEducation personeducation=edu.get(i);
						String endtime=personeducation.getEndTime();
						
						long date1 = sdf.parse(endtime).getTime();
						if(date1>date){
							date=date1;
							school=personeducation.getSchoolname();
						}
		}
						
					}
					personResume.setSchool(school);
					super.getInviteManager().updatePersonResume(personResume);
					
					forward = IConstants.SUCCESS_KEY;
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward(forward);
			}
	
}
