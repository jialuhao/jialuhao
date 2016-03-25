package dao;

import java.util.List;

import model.CompInfo;

import common.constants.IConstants;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

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
public class CompInfoDAOImpl extends AbstractManager implements ICompInfoDAO {

	
	
	
	
	@SuppressWarnings("unchecked")
	public CompInfo findCompById(String id) throws DAOException {
		
		List<CompInfo> list =null;
		final String v_id = id;
		StringBuffer sb;
		sb = new StringBuffer("from CompInfo a ");
		sb.append(" where a.Comp=:pkComp ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		    list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("pkComp",v_id);
				return q.list();
			}
		});
		   if(list == null || list.size()<=0)
			   return null;
		   else
			   return list.get(0);
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
		
	}


	
	@SuppressWarnings("unchecked")
	public List<CompInfo> findAllComp() throws DAOException {
		
		try{
			return 	super.findAll(CompInfo.class);
		}catch(DAOException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}


	@SuppressWarnings("unchecked")
	public List<CompInfo> findCompByCont(String queryString) {
		
		StringBuffer sb;
		sb = new StringBuffer("from CompInfo a ");
		sb.append(" where a.Status=:status ");
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("status", IConstants.BESPEAK_SIGN);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	
	public void saveCompInfo(CompInfo compInfo) {
		
		try{
			compInfo.setDr(IConstants.DEFAULT_SIGN);
			super.save(compInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	
	public void updateCompInfo(CompInfo compInfo) throws DAOException {
		
		try{
			super.update(compInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}
	
	public void delCompInfo(CompInfo compInfo) throws DAOException {
		
		try{
			compInfo.setDr(IConstants.DEL_SIGN);
			super.update(compInfo);
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
	public List<CompInfo> findCompInfoById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from CompInfo as a ");
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
