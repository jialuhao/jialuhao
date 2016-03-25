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
public class  CompanyServiceAction extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanyServiceAction.class);
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
     * 描述：查看自己填写的招聘成功的信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showOneServicelog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws BaseException{
				try{
					String id=request.getParameter("jobid");
					
					List list=super.getInviteManager().findcompservicebyjobid(id);
					PublishJobInfo job=new PublishJobInfo();
					job=super.getInviteManager().findPublishJobById(id);
					String flag=job.getValidflag();
					request.setAttribute("list", list);
					request.setAttribute("flag", flag);
					return mapping.findForward("show");
	   
				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
			}
	/**
     * 
     * 描述：显示一份详细
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
//	public ActionForward showAdminServicelog(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response) throws BaseException{
//				try{
//					String id=request.getParameter("jobid");
//					Servicelog servicelog = new Servicelog();
//					servicelog=super.getInviteManager().findServicelogById(id);
//					List<Servicepeople> Allservicepeople=new ArrayList<Servicepeople>();
//					if(servicelog!=null){
//						Allservicepeople=super.getInviteManager().queryServicepeopleById(servicelog.getId()+"");
//					
//					}					
//					request.setAttribute("servicelog", servicelog);
//					request.setAttribute("Allservicepeople", Allservicepeople);
//					return mapping.findForward("adminshow");
//	   
//				}catch(Exception ex){
//					logger.error("系统异常:",ex);
//					throw new BaseException(ex);
//				}
//			}
	
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
     * 描述：修改后保存一条企业招聘信息
     * （招聘成功或失败后的入库）
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward saveServicelog(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			
			String sname=request.getParameter("sname");//姓名
			String disnumber=request.getParameter("disnumber");//残疾证号
			String phone=request.getParameter("phone");// 
			String house=request.getParameter("house");//户籍
			String workname=request.getParameter("workname");
			String remark=request.getParameter("remark");// 
			String losewhyobj=request.getParameter("losewhyobj");//未招用原因
			String otherwhy=request.getParameter("otherparts");
			String validflag=request.getParameter("validflag");
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("jobid");	
		   
			String[] snames=null;
			String[] phones=null;
			String[] disnumbers=null;
			String[] houses=null;
			String[] worknames=null;
			String[] remarks=null;
			if(sname!=null){
				snames=sname.split(",");
			}
			if(phone!=null){
				phones=phone.split(",");
			}
			if(disnumber!=null){
				disnumbers=disnumber.split(",");
			}
			if(house!=null){
				houses=house.split(",");
			}
			if(workname!=null){
				worknames=workname.split(",");
			}
			if(remark!=null){
				remarks=remark.split(",");
			}
			
			if("3".equals(validflag)){
				for(int i=0;i<snames.length&&snames[i]!=null;i++){
					CompService compservice=new CompService();
					compservice.setName(snames[i]);
					compservice.setNumber(disnumbers[i]);
					compservice.setPhone(phones[i]);
					compservice.setHouse(houses[i]);
					compservice.setWorkname(worknames[i]);
					if(remarks.length>i){
					compservice.setRemark(remarks[i]);}
					else{
						compservice.setRemark("");
					}
					compservice.setPkjob(id);
					super.getInviteManager().saveCompservice(compservice);
					
					
				}
				
			}else if("2".equals(validflag)){
				CompService compservice=new CompService();
				compservice.setOtherwhy(otherwhy);
				compservice.setLosewhy(losewhyobj);
				compservice.setPkjob(id);
				super.getInviteManager().saveCompservice(compservice);
			}
			
			//修改招聘成功与否的状态
		
					
			if(validflag!=null&&validflag!=""){
			PublishJobInfo job=new PublishJobInfo();
			job=super.getInviteManager().findPublishJobById(id);
			job.setValidflag(validflag);
			super.getInviteManager().updatePublishJobInfo(job);}
			return mapping.findForward("showInfo");
		} catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
	   
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}	
}




		
		
		
		
		