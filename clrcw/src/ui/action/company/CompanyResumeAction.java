package ui.action.company;
import javax.servlet.http.*;

import util.PaginationSupport;
import model.*;

import java.util.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;
	//企业收到的简历action
public class  CompanyResumeAction extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanyResumeAction.class);
	/**
     * 描述：显示企业简历库第一页
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showCompResume(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException{
		String forward = IConstants.FAIL_KEY;
		try{
			String status=null;
			HttpSession session=request.getSession(false);
			String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
			int pageIndex=0;
 		   	int pageSize=5;
 		   	boolean desc=true;
 		 //企业简历库数据  
   		 PaginationSupport pagin=super.getInviteManager().paginationCompResume(compLoginName, status, pageIndex, pageSize, desc);
   		 List<?> list=pagin.getItems();
   		 int totalCount=pagin.getTotalCount();
   		 //计算总的页数tpp
   		 int tpp=(int) Math.ceil((totalCount-1)/pageSize);
		 List<CompResume> allResume=new ArrayList<CompResume>();
		 CompResume oneResume=new CompResume();
   		 if(list==null)
   			allResume=null;
   		 else{
   		 	for(int i=0;i<list.size();i++)
   		 		{
   		 		oneResume=(CompResume)list.get(i);
   		 		allResume.add(oneResume);
   		 		}
   		 	request.setAttribute("allResume", allResume);
   		 	request.setAttribute("pageIndex", pageIndex);
   		 	session.removeAttribute("totalCount");
   		 	session.setAttribute("totalCount", totalCount);
   		 	session.removeAttribute("tpp");
   		 	session.setAttribute("tpp", tpp);
   		}
   		 forward=IConstants.SUCCESS_KEY;
		
		}catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);

		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}	
			
	 /**
     * 
     * 描述：显示企业简历库其他页
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
    
    
    
    public ActionForward comOtherPage(ActionMapping mapping, ActionForm form,
   		 HttpServletRequest request, HttpServletResponse response) throws BaseException{
   	 try {
				int pageSize=5;
				boolean desc=true;
				String pnum=(String)PropertyUtils.getSimpleProperty(form,"pageIndex");
				HttpSession session = request.getSession(true);
			    int ppp=(Integer)session.getAttribute("totalCount");
				String status=null;
				String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
				int tpn=(int) Math.ceil(ppp/pageSize);
				int pn=new Integer(pnum).intValue();
					int ddd;
					if(pn>=tpn){
						ddd=tpn;
					}
					else if(pn<=0){
						 ddd=0;
					}
					else{
						 ddd=pn;
					}
			PaginationSupport pagin=super.getInviteManager().paginationCompResume(compLoginName, status, ddd, pageSize, desc);
	  		List<?> list=pagin.getItems();
			List<CompResume> allResume=new ArrayList<CompResume>();
			CompResume oneResume=new CompResume();
	   		if(list==null)
	   			allResume=null;
	   		else{
	   		 	for(int i=0;i<list.size();i++)
	   		 		{
	   		 		oneResume=(CompResume)list.get(i);
	   		 		allResume.add(oneResume);
	   		 		}
	   		 
		 	request.setAttribute("allResume", allResume);	
		 	request.setAttribute("pageIndex", ddd);
	   		}
	   		return mapping.findForward(IConstants.SUCCESS_KEY);
	   	}catch(BusinessException be){
	   		logger.error(be.getMessage(),be);
	   		throw new BaseException(be);
   	   
	   	}catch(Exception ex){
	   		logger.error("系统异常:",ex);
	   		throw new BaseException(ex);
      	}
	  
   	 }
    		

	/**
     * 
     * 描述：显示一份详细简历
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showOneResume(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws BaseException{
				try{
					String sta=request.getParameter("sta");
					String userKeyId=request.getParameter("userKeyId");
					String compResumekeyId=request.getParameter("compResumekeyId");
					HttpSession session=request.getSession();
					session.removeAttribute("compResumekeyId");
					session.setAttribute("compResumekeyId", compResumekeyId);
					UserInfo  user=new UserInfo();
					PersonResume resume=new PersonResume();
					PersonResumeB resumeB=new PersonResumeB();
					List<PersonResumeB> LResumeB=new ArrayList<PersonResumeB>();
					List<ApplyJobInfo>  applyJob=new ArrayList<ApplyJobInfo>();
					
					user=super.getInviteManager().findUserById(userKeyId);
					String loginId=user.getLoginId();
					List<?> list1=super.getInviteManager().queryPersonResume(loginId);
					if(!list1.isEmpty()){
						Object[] o1=(Object[])list1.get(0);
						resume=(PersonResume)o1[0];
						request.setAttribute("resume", resume);
					}
					List<PersonResumeB> list2=super.getInviteManager().findPersonResumesById(loginId);
					if(!list2.isEmpty()){
						for(int j=0;j<list2.size();j++){
							resumeB=(PersonResumeB)list2.get(j);
							LResumeB.add(resumeB);
						}
						 
						 request.setAttribute("resumeB", LResumeB);
					}
					List<?> list3=super.getInviteManager().queryApplyJobById(loginId);
					if(!list3.isEmpty()){
						for(int i=0;i<list3.size();i++){
							Object[] o=(Object[])list3.get(i);
							ApplyJobInfo oneJob=(ApplyJobInfo)o[0];
							applyJob.add(oneJob);
						}
						request.setAttribute("applyJob", applyJob);

					}
					request.setAttribute("sta", sta);
					return mapping.findForward("show");
					
				}catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);
	   
				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
			}
	/**
     * 
     * 描述：删除一份简历
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward delOneResume(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String id=request.getParameter("keyId");
			CompResume one=super.getInviteManager().findCompResumeById(id);
			super.getInviteManager().delCompResume(one);
			return mapping.findForward("return");
		
		}catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);

		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
		}
	}
	

	/**
     * 
     * 描述：和求职者建立联系
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward contact(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			HttpSession session=request.getSession();
			String compResumekeyId=(String)session.getAttribute("compResumekeyId");
			CompResume one=super.getInviteManager().findCompResumeById(compResumekeyId);
			one.setStatus("1");
			super.getInviteManager().updateCompResume(one);
			return mapping.findForward("return");
		}catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
		}
	}
}




		
		
		
		
		