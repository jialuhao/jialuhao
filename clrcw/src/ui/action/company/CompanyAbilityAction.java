package ui.action.company;
import javax.servlet.http.*;

import util.PaginationSupport;
import model.*;
import model.base.BasePersonResume;
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

	//企业人才库action

public class  CompanyAbilityAction extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanyPubJobAction.class);
	/**
     * 
     * 描述：显示企业人才库第一页信息 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showCompAbility(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		String forward = IConstants.FAIL_KEY;
		try{
			HttpSession session=request.getSession(false);
			String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
			String file="1";
			int pageIndex=0;
 		   	int pageSize=5;
 		   	boolean desc=true;
 		    String education = (String) request.getParameter("education");
 		    String years= (String) request.getParameter("years");
 		    String dkind= (String) request.getParameter("dkind");
 		    String startdate= (String) request.getParameter("startdate");
 		    String enddate= (String) request.getParameter("enddate");
			PersonResume resume=new PersonResume();
			resume.setLimitYear(years);
			resume.setPhone(education);
			resume.setDkind(dkind);
			resume.setLang2((startdate));
			resume.setLevel2(enddate);  
 		 //企业人才库数据  
		PaginationSupport pagin=super.getInviteManager().queryCompResumeByFile(file, compLoginName,resume, pageIndex, pageSize, desc);
   		 List<?> list=pagin.getItems();
   		 int totalCount=pagin.getTotalCount();
   		 //计算总的页数tpp
   		 int tpp=(int) Math.ceil((totalCount-1)/pageSize);
		 List<CompResume> allResume=new ArrayList<CompResume>();
		 List bdEducate = (List) super.inviteManager.findAllBdEducate();
		 List bdPost = (List) super.inviteManager.findAllBdPost();
		 BdPost post =new BdPost();
		 CompResume oneResume=new CompResume();
   		 if(list==null)
   			allResume=null;
   		 else{
   		 	for(int i=0;i<list.size();i++)
   		 		{
   		 		oneResume=(CompResume)list.get(i);
   		 	for(int j=0;j<bdPost.size();j++){
   		 		post=(BdPost)bdPost.get(j);
		 			if((post.getId()+"").equals(oneResume.getPkResume().getDkind()))
   		 			oneResume.getPkResume().setDkind(post.getPostName());
   		 		}
   		 
   		 Boolean reg=false;
   		 	
			PersonResume personResume = oneResume.getPkResume();
      String state=personResume.getState();
			if(state==null||"0".equals(state)||"1".equals(state)){
    reg=false;
  }else{
	   reg=true; 
  }
			oneResume.setReg(reg);
   		 		allResume.add(oneResume);
   		 		}
   		 	request.setAttribute("allResume", allResume);
   		 	request.setAttribute("pageIndex", pageIndex);
   		 	session.removeAttribute("totalCount");
   		 	session.setAttribute("totalCount", totalCount);
   		 	session.removeAttribute("tpp");
   		 	session.setAttribute("tpp", tpp);
   		}
		 
		 request.setAttribute("bdEducate", bdEducate);
		 request.setAttribute("bdPost", bdPost);
		 request.setAttribute("education",education);
		 request.setAttribute("years",years);
		 request.setAttribute("dkind",dkind);
		 request.setAttribute("startdate",startdate);
		 request.setAttribute("enddate",enddate);

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
     * 描述：显示人才库其他页
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
				String file="1";
				String pnum=(String)PropertyUtils.getSimpleProperty(form,"pageIndex");
				HttpSession session = request.getSession(true);
			  
			 
			    String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
				
				
				int pn=new Integer(pnum).intValue();
					
			String education = (String) request.getParameter("education");
			String years= (String) request.getParameter("years");
			String dkind= (String) request.getParameter("dkind");
			String startdate= (String) request.getParameter("startdate");
 		    String enddate= (String) request.getParameter("enddate");
			PersonResume resume=new PersonResume();
			resume.setLimitYear(years);
			resume.setPhone(education);
			resume.setDkind(dkind);
			resume.setLang2((startdate));
			resume.setLevel2(enddate);  

			PaginationSupport pagin=super.getInviteManager().queryCompResumeByFile(file, compLoginName,resume, pn, pageSize, desc);
	  		List<?> list=pagin.getItems();
	  		List bdEducate = (List) super.inviteManager.findAllBdEducate();
			List bdPost = (List) super.inviteManager.findAllBdPost();
			BdPost post =new BdPost();
			List<CompResume> allResume=new ArrayList<CompResume>();
			CompResume oneResume=new CompResume();
	   		if(list==null)
	   			allResume=null;
	   		else{
	   		 	for(int i=0;i<list.size();i++)
	   		 		{
	   		 		oneResume=(CompResume)list.get(i);
	   		 		for(int j=0;j<bdPost.size();j++){
	   		 		post=(BdPost)bdPost.get(j);
	   		 			if((post.getId()+"").equals(oneResume.getPkResume().getDkind()))
	   		 			oneResume.getPkResume().setDkind(post.getPostName());
	   		 		}
	   		 	 Boolean reg=false;
	    		 	
	 			PersonResume personResume = oneResume.getPkResume();
	       String state=personResume.getState();
	 			if(state==null||"0".equals(state)||"1".equals(state)){
	     reg=false;
	   }else{
	 	   reg=true; 
	   }
	   			oneResume.setReg(reg);
	   		 		allResume.add(oneResume);
	   		 		}
	   		int  totalCount=pagin.getTotalCount();
	   		int tpn=(int) Math.ceil(totalCount/pageSize);
	   		
		 	request.setAttribute("allResume", allResume);	
		 	request.setAttribute("pageIndex", pn);
		 	
		 	session.setAttribute("tpp", tpn);
		 	session.setAttribute("totalCount", totalCount);
	   		}
	   		
			
			request.setAttribute("bdEducate", bdEducate);
			request.setAttribute("bdPost", bdPost);
			request.setAttribute("education",education);
			request.setAttribute("years",years);
			request.setAttribute("education",education);
			request.setAttribute("dkind",dkind);
			request.setAttribute("startdate",startdate);
			request.setAttribute("enddate",enddate);

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
     * 描述：显示人才详细信息
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
					String userKeyId=request.getParameter("userKeyId");
					//String compResumekeyId=request.getParameter("compResumekeyId");
					//HttpSession session=request.getSession();
					//session.removeAttribute("compResumekeyId");
					//session.setAttribute("compResumekeyId", compResumekeyId);
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
						String dkind=resume.getDkind();
						dkind=(super.inviteManager.findPostById(dkind)).getPostName();
						resume.setDkind(dkind);
						
					}
					request.setAttribute("resume", resume);
					
					
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
					List educations = super.getInviteManager().findEducationsById(loginId);
					request.setAttribute("educations", educations);

					
					
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
     * 描述：显示人才详细信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showOneResumes(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
				try{
					String userKeyId=request.getParameter("userKeyId");
					//String compResumekeyId=request.getParameter("compResumekeyId");
					//HttpSession session=request.getSession();
					//session.removeAttribute("compResumekeyId");
					//session.setAttribute("compResumekeyId", compResumekeyId);
					UserInfo  user=new UserInfo();
					PersonResume resume=new PersonResume();
					PersonResumeB resumeB=new PersonResumeB();
					List<PersonResumeB> LResumeB=new ArrayList<PersonResumeB>();
					List<ApplyJobInfo>  applyJob=new ArrayList<ApplyJobInfo>();
					String cardnumber="";
					user=super.getInviteManager().findUserById(userKeyId);
					String loginId=user.getLoginId();
					List<?> list1=super.getInviteManager().queryPersonResume(loginId);
					if(!list1.isEmpty()){
						Object[] o1=(Object[])list1.get(0);
						resume=(PersonResume)o1[0];
						String dkind=resume.getDkind();
						dkind=(super.inviteManager.findPostById(dkind)).getPostName();
						resume.setDkind(dkind);
						cardnumber=resume.getCardnumber();
					}
					request.setAttribute("resume", resume);
					if(cardnumber!=null&&cardnumber!=""){
						List recommends=super.getInviteManager().findRecommendsbycardnumber(cardnumber);
						
						request.setAttribute("recommends", recommends);
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
					List educations = super.getInviteManager().findEducationsById(loginId);
					request.setAttribute("educations", educations);

					
					
					return mapping.findForward("showresume");
					
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
     * 描述：删除人才信息
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
			if(one!=null)
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
	

	
}




		
		
		
		
		