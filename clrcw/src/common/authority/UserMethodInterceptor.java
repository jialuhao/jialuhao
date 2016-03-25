package common.authority;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts.action.ActionMapping;

import common.constants.IConstants;

/**
 *<p>Title: 个人用户权限拦截器</p>
 *
 *<p>Description: 实现AOP联盟MethodInterceptor接口,拦截对所有的方法进行处理</p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class UserMethodInterceptor implements MethodInterceptor {

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		HttpServletRequest request = null;
		ActionMapping mapping = null;
		//获取目标方法的全部参数
		Object[] args = invocation.getArguments();
		//遍历参数
		for(int i=0;i<args.length;i++){
			if(args[i] instanceof HttpServletRequest)
				request = (HttpServletRequest)args[i];
			if(args[i] instanceof ActionMapping)
				mapping = (ActionMapping)args[i];
		}
		//Object userid = request.getSession().getAttribute("userid");
		//String complevel =(String) request.getSession().getAttribute(IConstants.COMP_USER_ID);
		String personlevel =(String) request.getSession().getAttribute(IConstants.PERSON_USER_ID);
		//String a = invocation.getMethod().getName();
		//return invocation.proceed();
		
		if( personlevel!=null){
			//调用目标方法
			return invocation.proceed();
		}
		else{
			//企业用户没有登录
			//request.setAttribute(IConstants.RELOGIN,IConstants.RELOGIN_INFO);
			return mapping.findForward("personLogin");
		}
	}
}
