package ui.action.person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
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

public class DelResumeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DelResumeAction.class);

	public ActionForward delResume(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)throws BaseException {
		
		/**
	     * 
	     * 描述：删除个人简历副表
	     * @param mapping
	     * @param form
	     * @param request
	     * @param response
	     * @return ActionForward
	     * @throws BaseException 
	     */
		
		
		String forward = IConstants.FAIL_KEY;
			try {
				//获取登陆账号，密码
				HttpSession session = request.getSession(true);
				String username=(String)session.getAttribute(IConstants.PERSON_USER_ID);
				List login = (List) super.getInviteManager().findUserByName(username);
				UserInfo userInfo = (UserInfo) login.get(0);
				String id = userInfo.getId() + "";
				List resume =  super.getInviteManager().queryPersonResume(username);
				Object[] eee=(Object[])resume.get(0);
				PersonResume personResume = (PersonResume)eee[0];
				personResume.setState("0");
				personResume.setOpinion("");
				super.getInviteManager().updatePersonResume(personResume);
				//获取删除id
				String delId=(String) PropertyUtils.getSimpleProperty(form,
				"delId");
				//组织对象数据
				PersonResumeB personResumeB=new PersonResumeB();
				List vvv=super.getInviteManager().findPersonResumesById(username);
				for(int i=0;i<vvv.size();i++){
					personResumeB=(PersonResumeB)vvv.get(i);
					if(personResumeB.getId()==new Integer(delId).intValue())
						break;
				}
				
				//调用删除方法
				super.getInviteManager().delPersonResumeB(personResumeB);
				//获取删除后表中的内容
				List<PersonResumeB> list = super.getInviteManager()
				.findPersonResumesById(username);
				//向页面传值
				request.setAttribute("resumeb", list);
				
				forward=IConstants.SUCCESS_KEY;
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
			return mapping.findForward(forward);	
	}

}
