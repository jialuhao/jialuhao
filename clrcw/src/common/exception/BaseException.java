/**
 * 
 */
package common.exception;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *<p>Title: �Զ����自定义异常处理基类�������</p>
 *
 *<p>Description: 解决多样化异常处理���������</p>
 *
 *<p>Company: 航天四创����˼��</p>
 *
 * @author 李滨���
 *
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BaseException extends Exception{
	
	private String messageKey = null;
	private Object[] messageArgs = null;
	protected Throwable rootCause = null;
	
	private List<BaseException> exceptions = new ArrayList<BaseException>();
	
	/**
	 * 
	 */
	public BaseException() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @param arg0
	 */
	public BaseException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @param arg0
	 */
	public BaseException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		rootCause = arg0;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public BaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Object[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(Object[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	public List<BaseException> getExceptions() {
		return exceptions;
	}

	public void addExceptions(BaseException ex) {
		exceptions.add(ex);
	}
	public void printStackTrace(PrintWriter writer){
		super.printStackTrace(writer);
		if(getRootCause()!=null)
			getRootCause().printStackTrace(writer);
			writer.flush();
	}
}
