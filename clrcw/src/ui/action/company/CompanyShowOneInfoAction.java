package ui.action.company;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BdCompkind;
import model.BdTrade;
import model.CompBespeak;
import model.CompInfo;
import model.PublishJobInfo;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import ui.action.admin.ShowAllBespeakAction;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompanyShowOneInfoAction extends BaseAction{ 
	private static Logger logger = Logger.getLogger(CompanyShowOneInfoAction.class);
	/**
     * 
     * 描述：显示一个企业信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showOneCompany(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try {
			String userId=request.getParameter("userId");
			String loginId=new String (request.getParameter("loginId").getBytes("ISO-8859-1"),"utf-8");
			
			CompInfo oneComp=new CompInfo();
			CompBespeak oneBespeak=new CompBespeak();
			oneComp=super.getInviteManager().findCompInfoById(userId);
			//得到企业的企业类型名,所属行业
			String kindId=oneComp.getType().getId().toString();
			String tradeId=oneComp.getBd().getId().toString();
			
			BdCompkind kind=super.getInviteManager().findCompKindById(kindId);
			BdTrade trade=super.getInviteManager().findTradeById(tradeId);
			oneComp.setType(kind);
			oneComp.setBd(trade);
			oneBespeak=super.getInviteManager().findCompBespeakById(userId);
			
			if(oneBespeak.getPv()==null){
				oneBespeak.setPv(1);
			}else{
				oneBespeak.setPv(oneBespeak.getPv()+1);
			}
		
			super.getInviteManager().updateCompBespeak(oneBespeak);
			String comparea=oneBespeak.getComparea();
			comparea=super.getInviteManager().findAreaCodeByarea(comparea).getAreaname();
			oneBespeak.setComparea(comparea);
			//企业招聘信息
			List<?> list=super.getInviteManager().queryEnableJobInfoById(loginId);
			List<PublishJobInfo> jobInfo=new ArrayList<PublishJobInfo>();
			for(int i=0;i<list.size();i++){
				Object[] o=(Object[])list.get(i);
				PublishJobInfo job=(PublishJobInfo)o[0];
				jobInfo.add(job);
			}
			request.setAttribute("oneBespeak", oneBespeak);
			request.setAttribute("compInfo",oneComp);
			request.setAttribute("job",jobInfo);
			
			return mapping.findForward(IConstants.SUCCESS_KEY);
			}catch(BusinessException be){
				logger.error(be.getMessage(),be);
				throw new BaseException(be);
			}catch(Exception ex){
				logger.error("系统异常:",ex);
				throw new BaseException(ex);
		}
	
	}
}