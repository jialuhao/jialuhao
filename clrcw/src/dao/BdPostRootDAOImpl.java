package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.BdJob;
import model.BdPostRoot;
import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

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
public class BdPostRootDAOImpl extends AbstractManager implements
		IBdPostRootDAO {

	/**
	 * 描述：
	 * @param bdPostRoot
	 * @throws DAOException
	 */
	public void delBdPostRoot(BdPostRoot bdPostRoot) throws DAOException {
		
		try{
			bdPostRoot.setDr(IConstants.DEL_SIGN);
			super.update(bdPostRoot);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @return
	 * @throws DAOException
	 */
	public List<BdPostRoot> findAllPostRoot() throws DAOException {
		try{
			return 	super.findAll(BdPostRoot.class);
		}catch(DAOException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdPostRoot
	 * @throws DAOException
	 */
	public void saveBdPostRoot(BdPostRoot bdPostRoot) throws DAOException {
		try{
			bdPostRoot.setDr(IConstants.DEFAULT_SIGN);
			super.save(bdPostRoot);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
		
	}

	/**
	 * 描述：
	 * @param bdPostRoot
	 * @throws DAOException
	 */
	public void updateBdPostRoot(BdPostRoot bdPostRoot) throws DAOException {
		try{
			super.update(bdPostRoot);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public List<BdPostRoot> findPostRootById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from BdPostRoot as a ");
								
		sb.append(" where a.Id=:Id ");
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
