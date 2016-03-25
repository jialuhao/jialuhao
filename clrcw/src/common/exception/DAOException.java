/**
 * 
 */
package common.exception;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

/**
 *<p>Title: 业务层自定义异常</p>
 *
 *<p>Description:
 * 1.spring在进行声明时事务管理时，通过捕获Service层方法的DataAccessException来提交和回滚事务的，而Service层方法的DataAccessException又是来自调用DAO层方法所产生的异常．
 * 2.我们一般在写DAO层代码时，如果继承JdbcDaoSupport 类，并使用此类所实现的JdbcTemplate来执行数据库操作，此类会自动把低层的SQLException转化成 DataAccessException以及DataAccessException的子类．
 * 3.一般在Service层我们可以自己捕获DAO方法所产成的DataAccessException，然后再抛出一个业务方法有意义的异常 ，此异常最好继承DataAccessException)，
 *   然后在Web层捕获，这样我们就可以手动编码的灵活实现通过业务方法执行的成功和失败来向用户转发不同的页面． </p>
 *
 *<p>Company: 航天思创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DAOException extends DataAccessException {

	static Logger logger = Logger.getLogger (DAOException.class);
	/**
	 * @param msg
	 */
	public DAOException(String msg) {
		super("DAO���쳣��"+msg);
	}

	/**
	 * @param msg
	 * @param cause
	 */
	public DAOException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

}
