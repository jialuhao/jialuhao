package common.constants;

/**
 *<p>Title: </p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface IConstants {

	public final static String APPNAME="kgwrcw";		//应用标识	
	
	public final static String Person="1";				//个人
	public final static String Company="2";				//企业
	
	public final static String SUCCESS_KEY = "success";	//流转成功
	public final static String FAIL_KEY = "fail";		//流转失败
	public final static String ERROR_KEY = "error";		//系统级异常
	
	public final static String SAVE_FAIL = "����ʧ��保存失败!";
	public final static String QUERY_FAIL = "�查询失败!";
	public final static String UPDATE_FAIL = "����ʧ��更新失败!";
	public final static String DEL_FAIL = "删除失败!";
	
	public final static String DEFAULT_SIGN = "0";		//默认标识
	public final static String DEL_SIGN = "1";			//删除标识
	
	public final static String BESPEAK_SIGN = "0";		//企业待审核标识
	public final static String ENROLL_SIGN = "1";		//企业注册标识
	
	public final static String INTENT_YES = "0";		//已有意向
	public final static String INTENT_NO = "1";			//尚无意向
	
	public final static String COMP_USER_ID = "compUserId";			//企业用户id
	public final static String PERSON_USER_ID = "personUserId";		//个人用户id
	public final static String ADMIN_USER_ID = "adminUserId";		//后台用户id

	public final static String RELOGIN = "reLogin";
	public final static String RELOGIN_INFO = "您还没有登录请重新登录";

	public final static String PERSON_DATABASE  = "1";			//归入人才库
	public final static String PERSON_DATABASE_NULL  = "0";			//无归入人才库
	
	public final static String TOKEN  = "token";			//访问令牌
	public final static String SSO_NAME  = "ssoname";			//sso名称
}
