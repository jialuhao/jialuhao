package ui.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.JobShearchObject;
import util.PaginationSupport;
import model.ManaUser;
import model.PersonResume;
import model.UserInfo;
import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;
/*
 * 个人用户定制查询
 * 
 */

public class FindAllUserIdAction extends BaseAction {
	private static Logger logger = Logger.getLogger(FindAllUserIdAction.class);

	public ActionForward findAllUserId(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			int pn = 0;
			int pageSize = 10;
			String name = request.getParameter("qname");
			String mail = request.getParameter("qmail");
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List lisuser=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)lisuser.get(0);
			JobShearchObject object= new JobShearchObject();
			object.seteTime(mail);
			object.setQname(name);
			String areacode=manaUser.getAreacode();
			String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
			object.setComparea(areaname);
			PaginationSupport vvv = super.getInviteManager().paginationUserInfo(object,pn, pageSize, false);
			List list = (List) vvv.getItems();
			
			List<PersonResume> userlist=new ArrayList<PersonResume>();
			for(int i=0;i<list.size();i++){
				PersonResume user=(PersonResume)list.get(i);
			
				
			   userlist.add(user);
			}
			int contunt = vvv.getTotalCount();

			int pc = 0;
			if (vvv.getTotalCount() == 10)
				pc = 0;
			else {
				pc = (int) Math.ceil(vvv.getTotalCount() / pageSize);
			}
			
			session.removeAttribute("totleCount");
			session.removeAttribute("userInfo");
			session.removeAttribute("pagenum");
			session.removeAttribute("zongshu");
			session.setAttribute("userInfo", userlist);
			session.setAttribute("pagenum", pn);
			session.setAttribute("totleCount", pc);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("qname", name);
			session.setAttribute("qmail", mail);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}

	public ActionForward nextfindAllUserId(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			String name = request.getParameter("qname");
			String mail = request.getParameter("qmail");
			int pageSize = 10;// 设定显示行数
			String pnum = (String) PropertyUtils
					.getSimpleProperty(form, "pnum");// 页码
			HttpSession session = request.getSession(true);
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List lisuser=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)lisuser.get(0);
			JobShearchObject object= new JobShearchObject();
			object.seteTime(mail);
			object.setQname(name);
			String areacode=manaUser.getAreacode();
			String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
			object.setComparea(areaname);
			int ppp = (Integer) session.getAttribute("totleCount");
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
			PaginationSupport vvv = super.getInviteManager()
					.paginationUserInfo(object,ddd, pageSize, false);
			int contunt = vvv.getTotalCount();
			List list = (List) vvv.getItems();
			List<PersonResume> userlist=new ArrayList<PersonResume>();
			for(int i=0;i<list.size();i++){
				PersonResume user=(PersonResume)list.get(i);
				
			   userlist.add(user);
			}
			session.removeAttribute("userInfo");
			session.removeAttribute("pagenum");
			session.setAttribute("zongshu", contunt);
			session.setAttribute("userInfo", userlist);
			session.setAttribute("pagenum", ddd);
			session.setAttribute("qname", name);
			session.setAttribute("qmail", mail);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward(forward);
	}
	
	
	
	public ActionForward findAllUserIdbymanage(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				HttpSession session = request.getSession(true);

				String forward = IConstants.FAIL_KEY;
				String uname = request.getParameter("uname");
//				String qjobid = request.getParameter("qjobid");
				String postId = request.getParameter("postId");//残疾类别
				String sta = request.getParameter("sta");
//				String sTime = request.getParameter("sTime");
//				String eTime = request.getParameter("eTime");
//				String salary=request.getParameter("salary");
				String education=request.getParameter("education");
				String workyear=request.getParameter("workyear");
				JobShearchObject object= new JobShearchObject();
				object.setPostId(postId);
				//object.setQjobid(qjobid);
				object.setQname(uname);
				object.setSta(sta);
				//object.seteTime(eTime);
				//object.setsTime(sTime);
				object.setEducation(education);
				//object.setSalary(salary);
				object.setWorkyear(workyear);
				String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
				List lisuser=super.getInviteManager().findManaUserByName(loginName);
				ManaUser manaUser=(ManaUser)lisuser.get(0);
				List bdPost = (List) super.inviteManager.findAllBdPost();
				if(manaUser.getAreacode().equals("110100")){
					session.setAttribute("areacode", "areacode");
				}else{
					session.setAttribute("areacode", "");
				}
				String areacode=manaUser.getAreacode();
				String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
				object.setComparea(areaname);
				try {
					int pn = 0;
					int pageSize = 10;
					PaginationSupport vvv = super.getInviteManager().paginationpersonmessage(object,pn, pageSize);
					List list = (List) vvv.getItems();
					for (int i = 0; i < list.size(); i++) {
						PersonResume personResume = (PersonResume) list.get(i);
						String dkind=personResume.getDkind();
						dkind=(super.inviteManager.findPostById(dkind)).getPostName();
						personResume.setDkind(dkind);}					
					int contunt = vvv.getTotalCount();

					int pc = 0;
					if (vvv.getTotalCount() == 10)
						pc = 0;
					else {
						pc = (int) Math.ceil(vvv.getTotalCount() / pageSize);
						if(vvv.getTotalCount()%pageSize==0){
							pc=pc-1;
						}
					}
					session.removeAttribute("apptotleCount");
					session.removeAttribute("appInfo");
					session.removeAttribute("apppagenum");
					session.removeAttribute("appzongshu");
					session.setAttribute("personresume", list);
					session.setAttribute("apppagenum", pn);
					session.setAttribute("apptotleCount", pc);
					session.setAttribute("appzongshu", contunt);
					session.setAttribute("uname", uname);
					session.setAttribute("uname", uname);
					//session.setAttribute("qjobid", qjobid);
					session.setAttribute("postId",postId);
					session.setAttribute("bdPost",bdPost);
					session.setAttribute("sta", sta);
//					session.setAttribute("sTime", sTime);
//					session.setAttribute("eTime", eTime);
//					session.setAttribute("salary", salary);
					session.setAttribute("workyear", workyear);
					session.setAttribute("education", education);
					
					forward = "showall";
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);

				}

					

				

				return mapping.findForward(forward);
			}

			public ActionForward nextfindAllUserIdbymanage(ActionMapping mapping,
					ActionForm form,

					HttpServletRequest request, HttpServletResponse response)
					throws BaseException {

				HttpSession session = request.getSession(true);
				String forward = IConstants.FAIL_KEY;
				String uname = request.getParameter("uname");

				String postId = request.getParameter("postId");
				String sta = request.getParameter("sta");

				String education=request.getParameter("education");
				String workyear=request.getParameter("workyear");
				JobShearchObject object= new JobShearchObject();
				object.setPostId(postId);//残疾类别
				
				object.setQname(uname);
				object.setSta(sta);
				
				object.setEducation(education);
			
				object.setWorkyear(workyear);//区县
				String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
				List lisuser=super.getInviteManager().findManaUserByName(loginName);
				ManaUser manaUser=(ManaUser)lisuser.get(0);
				
				
				String areacode=manaUser.getAreacode();
				String areaname=(super.getInviteManager().findAreaCodeByarea(areacode)).getAreaname();
				object.setComparea(areaname);
				try {
					int pageSize = 10;// 设定显示行数
					String pnum = (String) PropertyUtils.getSimpleProperty(form,"pnum");// 页码
					
					
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
					PaginationSupport vvv = super.getInviteManager().paginationpersonmessage(object,pn, pageSize);
					List list = (List) vvv.getItems();
					for (int i = 0; i < list.size(); i++) {
						PersonResume personResume = (PersonResume) list.get(i);
						String dkind=personResume.getDkind();
						dkind=(super.inviteManager.findPostById(dkind)).getPostName();
						personResume.setDkind(dkind);}	
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
					forward = "showall";
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);

				}

				return mapping.findForward(forward);
			}
}
