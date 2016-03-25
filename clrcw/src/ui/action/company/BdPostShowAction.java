package ui.action.company;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import model.*;
import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class BdPostShowAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BdPostShowAction.class);
	/**
     * 
     * 描述：显示某一个岗位的详细列表
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws Exception 
     */
	public ActionForward showOne(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws BaseException {
			String forward = IConstants.FAIL_KEY;
			try {
				String keyId=request.getParameter("keyId");
				List<?> list=super.getInviteManager().queryBdPostByRoot(keyId);
				List<BdPost> Blist=new ArrayList<BdPost>();
				BdPost one=new BdPost();
				for(int i=0;i<list.size();i++){
					Object[] o=(Object[])list.get(i);
					one=(BdPost)o[0];
					Blist.add(one);
				}
				BdPostRoot oneRoot=super.getInviteManager().findPostRootById(keyId);
				String postRN=oneRoot.getPostName();
				request.setAttribute("postRN", postRN);
				request.setAttribute("Blist", Blist);
				forward = IConstants.SUCCESS_KEY;
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
			return mapping.findForward(forward);
	}
	/**
     * 
     * 描述：显示所有岗位的详细列表
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws Exception 
     */
	public ActionForward showAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws BaseException {
		try{
			List<BdPostRoot> listR=new ArrayList<BdPostRoot>();
			//List<BdPostRoot> allRoot=new ArrayList<BdPostRoot>();
			listR=super.getInviteManager().findAllBdPostRoot();
			for(int i=0;i<listR.size();i++){
				String id=listR.get(i).getId().toString();
				List<?> listB=super.getInviteManager().queryBdPostByRoot(id);
				Set<BdPost> Blist=new HashSet<BdPost>();
				BdPost one=new BdPost();
				for(int j=0;j<listB.size();j++){
					Object[] o=(Object[])listB.get(j);
					one=(BdPost)o[0];
					Blist.add(one); 
				}
			listR.get(i).setBdPosts(Blist);
			request.setAttribute("allPost", listR);
			}
			return mapping.findForward("findAll");
			
			} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		
	}
	}
}
