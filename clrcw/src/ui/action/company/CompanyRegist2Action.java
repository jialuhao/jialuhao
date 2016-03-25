package ui.action.company;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompanyRegist2Action  extends BaseAction{
	private static Logger logger = Logger.getLogger(CompanyRegist2Action.class);
	
	/**
     * 
     * 描述：登录控制，没有填写其他信息的提示填写
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward companyShowInfo(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException {
		try{
			//在servletContext中定义bdPost,bdJob,bdCompkind,bdTrade,bdEducate
			HttpSession session = request.getSession(false);	
			List<BdPost> bdPost=super.getInviteManager().findAllBdPost();
		 		List<BdJob> bdJob=super.getInviteManager().findAllBdJob();
		 		List<BdCompkind> bdCompkind=super.getInviteManager().findAllBdCompKind();
		 		List<BdTrade> bdTrade=super.getInviteManager().findAllBdTrade();
		 		List<BdEducate> bdEducate=super.getInviteManager().findAllBdEducate();
		 		List<Areacode> areacode=super.getInviteManager().findAllAreaCode();
		 		//HttpSession session=request.getSession();
		 		ServletContext context=this.getServlet().getServletContext();
		 		CompBespeak compBespeak=(CompBespeak)session.getAttribute("compBespeakInfo");
		 		String area=	compBespeak.getComparea();
				   Areacode areacode1=super.getInviteManager().findAreaCodeByarea(area);
				   String areaname=areacode1.getAreaname();
		 		context.setAttribute("bdPost", bdPost);
		 		context.setAttribute("bdJob", bdJob);
		 		context.setAttribute("bdCompkind", bdCompkind);
		 		context.setAttribute("bdTrade", bdTrade);
		 		context.setAttribute("bdEducate", bdEducate);
		 		context.setAttribute("areacode", areacode);
		 		
		 		Integer beaspeakId=(Integer)session.getAttribute("compBespeakId");
		 		CompInfo info=super.getInviteManager().findCompInfoById(beaspeakId.toString());
		 		if(info==null){
		 			session.removeAttribute("compId");
		 			ActionMessages messages=new ActionMessages();
		 			messages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("error.return"));
		 			saveErrors(request, messages);
		 			return mapping.findForward("return");
		 			}
		 		else{
		 			Integer compId=info.getId();
		 			String kindId=info.getType().getId().toString();
		 			String tradeId=info.getBd().getId().toString();
		 			BdCompkind kind=super.getInviteManager().findCompKindById(kindId); 
		 			BdTrade trade=super.getInviteManager().findTradeById(tradeId);
		 			info.setBd(trade);
		 			info.setType(kind);
		 			session.setAttribute("compInfo", info);
		 			session.setAttribute("compId", compId);
		 			session.setAttribute("areaname", areaname);
		 			String state=compBespeak.getCompStatus();
		 			String show="show";
		 			String aa=(String)session.getAttribute("weitongguo");
		 			if(session.getAttribute("weitongguo")!=null&&session.getAttribute("weitongguo")!=""){
		 				show="showinfo";
		 			}
		 			if(state.equals("1")){
		 				session.setAttribute("weitongguo","weitongguo");
		 				show="showinfo";
		 			}
		 			return mapping.findForward(show);
		 			}
			}catch(BusinessException be){
	       	  logger.error(be.getMessage(),be);
	       	  throw new BaseException(be);
			} catch(Exception ex){
	       	  logger.error("系统异常:",ex);
	       	  throw new BaseException(ex);
		}
	}
	
	/**
     * 
     * 描述：保存企业详细信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward companyRegist2(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException {
		String forward = IConstants.FAIL_KEY;
		
		try {
	       	
			HttpSession session = request.getSession(false);
			CompBespeak compBespeak=(CompBespeak)session.getAttribute("compBespeakInfo");
		   
			String workScope = (String) PropertyUtils.getSimpleProperty(form,"workScrope");
			String netAddress = (String) PropertyUtils.getSimpleProperty(form, "netAddress");
			String compIntro = (String) PropertyUtils.getSimpleProperty(form,"compIntro");
			String type = (String) PropertyUtils.getSimpleProperty(form,"type");
			String bd = (String) PropertyUtils.getSimpleProperty(form,"bd");
			String compcount = (String) PropertyUtils.getSimpleProperty(form,"compcount");
			String fax = (String) PropertyUtils.getSimpleProperty(form,"fax");
			BdCompkind kind=super.getInviteManager().findCompKindById(type);
			BdTrade trade=super.getInviteManager().findTradeById(bd);
			CompInfo compInfo = new CompInfo();
			compInfo.setBd(trade);
			compInfo.setType(kind);
			compInfo.setComp(compBespeak);
			compInfo.setNetAddress(netAddress);
			compInfo.setWorkScrop(workScope);
			compInfo.setCompIntro(compIntro);
			compInfo.setDr("0");
			compInfo.setCompcount(compcount);
			compInfo.setFax(fax);
			super.getInviteManager().updateCompInfo(compInfo);
			ActionMessages messages=new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("save.ok"));
			saveErrors(request, messages);
			
			forward = IConstants.SUCCESS_KEY;
		}catch(BusinessException be){
	       	   logger.error(be.getMessage(),be);
	       	   throw new BaseException(be);
	       	   
	          } catch(Exception ex){
	       	   logger.error("系统异常:",ex);
	       	   throw new BaseException(ex);
		}
		return mapping.findForward(forward);
		
	}
	/**
     * 
     * 描述：修改企业详细信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward update(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException {
		String forward = IConstants.FAIL_KEY;
		
		try {
	       	
			HttpSession session = request.getSession(false);
			String keyId=((Integer)session.getAttribute("compId")).toString();
			CompBespeak compBespeak=(CompBespeak)session.getAttribute("compBespeakInfo");
			//jialuhaoadd  (修改审核状态)
			compBespeak.setCompStatus("0");	
//			String id=compBespeak.getId()+"";
//			CompBespeak compBespeak1=super.getInviteManager().findCompBespeakById(id);
//			compBespeak1.setCompStatus("0");
			
			String workScope = (String) PropertyUtils.getSimpleProperty(form,"workScrope");
			String netAddress = (String) PropertyUtils.getSimpleProperty(form, "netAddress");
			String compIntro = (String) PropertyUtils.getSimpleProperty(form,"compIntro");
			String compcount = (String) PropertyUtils.getSimpleProperty(form,"compcount");
			String fax = (String) PropertyUtils.getSimpleProperty(form,"fax");
			String type = (String) PropertyUtils.getSimpleProperty(form,"type");
			String bd = (String) PropertyUtils.getSimpleProperty(form,"bd");
			
			String companyplace=(String) PropertyUtils.getSimpleProperty(form,"companyplace");
			String comparea = (String) PropertyUtils.getSimpleProperty(form,"comparea");
			
			
			String mailPost = (String) PropertyUtils.getSimpleProperty(form,"mailPost");
			String linkman = (String) PropertyUtils.getSimpleProperty(form,"linkman");
			String cardnum = (String) PropertyUtils.getSimpleProperty(form,"cardnum");
			String telephone = (String) PropertyUtils.getSimpleProperty(form,"telephone");
			String mail = (String) PropertyUtils.getSimpleProperty(form,"mail");
			
		
			compBespeak.setComparea(comparea);
			compBespeak.setCompanyplace(companyplace);
			compBespeak.setMailPost(mailPost);
			compBespeak.setLinkman(linkman);
			compBespeak.setCardnum(cardnum);
			compBespeak.setTelephone(telephone);
			compBespeak.setMail(mail);
			super.getInviteManager().updateCompBespeak(compBespeak);
			BdCompkind kind=super.getInviteManager().findCompKindById(type);
			BdTrade trade=super.getInviteManager().findTradeById(bd);
			
			CompInfo compInfo = super.getInviteManager().findCompById(keyId);
			compInfo.setBd(trade);
			compInfo.setType(kind);
			compInfo.setComp(compBespeak);
			compInfo.setNetAddress(netAddress);
			compInfo.setWorkScrop(workScope);
			compInfo.setCompIntro(compIntro);
			compInfo.setCompcount(compcount);
			compInfo.setFax(fax);
			//compInfo.setDr("0");
			super.getInviteManager().updateCompInfo(compInfo);
			
			
			
			ActionMessages messages=new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("update.ok"));
			saveErrors(request, messages);
			
			forward = IConstants.SUCCESS_KEY;
		}catch(BusinessException be){
	       	   logger.error(be.getMessage(),be);
	       	   throw new BaseException(be);
	       	   
	          } catch(Exception ex){
	       	   logger.error("系统异常:",ex);
	       	   throw new BaseException(ex);
		}
		return mapping.findForward(forward);
		
	}
	
}
