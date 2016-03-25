/**
 * 
 */
package common.exception;

/**
 *<p>Title: </p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天思创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BusinessException extends BaseException {

	/**
	 * 
	 */
	public BusinessException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public BusinessException(String arg0) {
		super("应用环境异常:"+arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public BusinessException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public BusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
