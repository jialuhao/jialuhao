package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.BdTrade;
import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: 行业下拉框</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class BdTradeDAOImpl extends AbstractManager implements IBdTradeDAO {

	/**
	 * 描述：
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdTrade> findAllTrade() throws DAOException {

		try{
			return 	super.findAll(BdTrade.class);
		}catch(DAOException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdTrade
	 * @throws DAOException
	 */
	public void saveBdTrade(BdTrade bdTrade) throws DAOException {
		
		try{
			bdTrade.setDr(IConstants.DEFAULT_SIGN);
			super.save(bdTrade);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdTrade
	 * @throws DAOException
	 */
	public void updateBdTrade(BdTrade bdTrade) throws DAOException {
		try{
			super.update(bdTrade);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdTrade
	 * @throws DAOException
	 */
	public void delBdTrade(BdTrade bdTrade) throws DAOException {
		try{
			bdTrade.setDr(IConstants.DEL_SIGN);
			super.update(bdTrade);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @return
	 * @throws DAOException
	 */
	public List<BdTrade> findTradeById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from BdTrade as a ");
								//sb.append(" join a.JobCode as j join a.ResumeCode as person");
								//sb.append(" join person.Educate as e");
		sb.append(" where a.Id=:Id ");
		//sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
	try{
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("Id", Id);
				return q.list();
			}
		});
	}
	catch(DataAccessException de){
		throw new DAOException(IConstants.DEL_FAIL,de);
	}
	}
}
