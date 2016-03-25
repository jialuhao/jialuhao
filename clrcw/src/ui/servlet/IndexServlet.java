package ui.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ApplyJobInfo;
import model.BdPostRoot;
import model.PublishJobInfo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.InviteManager;
import common.exception.BusinessException;



/**
 * 
 * 作用：控制index.jsp的转向，请求index.jsp时，转向IndexServlet
 * @method doGet()
 * @method doPost()
 * 
 */

public class IndexServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(IndexServlet.class);
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		try{
			String[] files = {"classpath*:/spring/kgwContext.xml",
							  "classpath*:/spring/dao-context.xml"};
			ApplicationContext app = new FileSystemXmlApplicationContext(files);
			InviteManager invite = (InviteManager)app.getBean("inviteManager");
			
			List<BdPostRoot> list=new ArrayList<BdPostRoot>();
			list=invite.findAllBdPostRoot();
			req.setAttribute("postRoot", list);
			
			//保存个人求职信息
			List<?> list1=invite.findAllApplyJobInfo();
			if(list1!=null && list1.size()>0){
				int leng=list1.size();
				List<ApplyJobInfo> all=new ArrayList<ApplyJobInfo>();
				ApplyJobInfo oneApply=new ApplyJobInfo();
				for(int i=leng;i>0;i--){
	  		 		Object[] o1=(Object[])list1.get(i-1);
	  		 		oneApply=(ApplyJobInfo)o1[0];
	  		 		all.add(oneApply);
	  		 	}
			req.setAttribute("applyJobInfo", all);
			}
	  		
	  			
			
			//保存企业招聘信息
			List<?> list2=invite.findAllPublishJobInfo();
			List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
			PublishJobInfo jobInfo=new PublishJobInfo();
			if(list2!=null && list2.size()>0){
				int leng2=list2.size();
				for(int j=leng2;j>0;j--){
	  		 	Object[] o2=(Object[])list2.get(j-1);
	  		 	jobInfo=(PublishJobInfo)o2[0];
	  		 	allPublishJobInfo.add(jobInfo);
	  		 }
			req.setAttribute("publishjobinfo", allPublishJobInfo);
			}
			
			RequestDispatcher rd=req.getRequestDispatcher("/pages/indexGoto.jsp");
			rd.forward(req, res);
		}	catch(BusinessException e){
			logger.error(e.getMessage(), e);
		}
			catch(Exception ex){
			logger.error(ex.getMessage(), ex);
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		doGet(req,res);
	}
}
