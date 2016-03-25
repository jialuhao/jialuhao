package dao;

import java.util.List;

import model.BdEducate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: 教育学历下拉框</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class BdEducateDAOImpl extends AbstractManager implements IBdEducateDAO {

	
	/**
	 * 描述：
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdEducate> findAllEducate() throws DAOException {
		try{
			return 	super.findAll(BdEducate.class);
		}catch(DAOException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdEducate
	 * @throws DAOException
	 */
	public void saveBdEducate(BdEducate bdEducate) throws DAOException {
		
		try{
			bdEducate.setDr(IConstants.DEFAULT_SIGN);
			super.save(bdEducate);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdEducate
	 * @throws DAOException
	 */
	public void updateBdEducate(BdEducate bdEducate) throws DAOException {
		try{
			super.update(bdEducate);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdEducate
	 * @throws DAOException
	 */
	public void delBdEdEducate(BdEducate bdEducate) throws DAOException {
		try{
			bdEducate.setDr(IConstants.DEL_SIGN);
			super.update(bdEducate);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public List<BdEducate> findEducateById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from BdEducate as a ");
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
