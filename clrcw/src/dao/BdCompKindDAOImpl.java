package dao;

import java.util.List;

import model.BdCompkind;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: 企业类型下拉框</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class BdCompKindDAOImpl extends AbstractManager implements
		IBdCompKindDAO {
	
	/**
	 * 描述：
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdCompkind> findAllCompkind() throws DAOException {
		
		try{
			return 	super.findAll(BdCompkind.class);
		}catch(DAOException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdCompkind
	 * @throws DAOException
	 */
	public void saveBdCompkind(BdCompkind bdCompkind) throws DAOException {
		try{
			bdCompkind.setDr(IConstants.DEFAULT_SIGN);
			super.save(bdCompkind);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdCompkind
	 * @throws DAOException
	 */
	public void updateBdCompkind(BdCompkind bdCompkind) throws DAOException {
		try{
			super.update(bdCompkind);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdCompkind
	 * @throws DAOException
	 */
	public void delCompkind(BdCompkind bdCompkind) throws DAOException {
		try{
			bdCompkind.setDr(IConstants.DEL_SIGN);
			super.update(bdCompkind);
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
	public List<BdCompkind> findCompkindById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from BdCompkind as a ");
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
