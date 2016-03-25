package dao;  

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import util.PaginationSupport;

import model.CompResume;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: 企业简历库实现类</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class CompResumeDAOImpl extends AbstractManager implements
		ICompResumeDAO {

	/* (non-Javadoc)
	 * @see dao.ICompResumeDAO#findAllResume()
	 */
	@SuppressWarnings("unchecked")
	public List<?> findAllResume(String comp_login_id) throws DAOException{
		final String v_id = comp_login_id;
		StringBuffer sb;
		sb = new StringBuffer("from CompResume a join a.PkResume as p");
		sb.append(" join p.Educate as e ");
		sb.append(" join a.CompPost as c");
		sb.append(" join c.Job as j ");
		sb.append(" where a.CompLoginId =:loginId ");
		
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		    return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("loginId",v_id);
				return q.list();
			}
		});
		    //return list.get(0);
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICompResumeDAO#saveToCompResume(model.CompResume)
	 */
	public void saveToCompResume(CompResume compResume)
			throws DAOException{
		// TODO Auto-generated method; stub
		try{
			compResume.setStatus(IConstants.INTENT_YES);
			compResume.setDr(IConstants.DEFAULT_SIGN);
			super.save(compResume);
		}catch(DataAccessException de){
			throw new DAOException(de.getMessage(),de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICompResumeDAO#updateCompResume(model.CompResume)
	 */
	public void updateCompResume(CompResume compResume) throws DAOException {
		// TODO Auto-generated method stub
		try{
			super.update(compResume);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICompResumeDAO#delCompResume(model.CompResume)
	 */
	public void delCompResume(CompResume compResume) throws DAOException {
		// TODO Auto-generated method stub
		try{
			compResume.setDr(IConstants.DEL_SIGN);
			super.update(compResume);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
	}
	public PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order)throws DAOException{
		return super.findPageByCriteria(criteria, startIndex, pageSize, order);
	}

	/**
	 * 描述：
	 * @param id
	 * @throws DAOException
	 */
	public List<CompResume> findCompResumeById(String v_id) throws DAOException {
		
		final String Id = v_id;
		StringBuffer sb;
		sb = new StringBuffer("from CompResume a ");
								//sb.append(" join a.JobCode as j join a.PersonCode as person");
		sb.append(" where a.Id=:Id ");
		//sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
			return   getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("Id", Id);
				return q.list();
			}
		});
		
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	
	
	/**
	 * 描述：
	 * @param resumeId
	 * @return
	 * @throws DAOException
	 */
	public List<?> findCompResumeByResumeId(String resumeId,String compLoginId)
			throws DAOException {
		final String Id = resumeId;
		final String loginId = compLoginId;
		StringBuffer sb;
		sb = new StringBuffer("from CompResume a join a.PkResume as p");
		sb.append(" where p.Id=:Id and a.CompLoginId=:loginId");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		sb.append(" and a.File="+IConstants.PERSON_DATABASE);
		final String hql = sb.toString();
		try{
			return   getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("Id", Id);
				q.setString("loginId", loginId);
				return q.list();
			}
		});
		
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	/**
	 * 描述：
	 * jialuhaoadd
	 * @param resumeId
	 * @return
	 * @throws DAOException
	 */
	public List<?> findCompResumeByResumecompId(String resumeId,String CompPost)
			throws DAOException {
		final String Id = resumeId;
		final String compost = CompPost;
		StringBuffer sb;
		sb = new StringBuffer("from CompResume a join a.PkResume as p");
		sb.append(" where p.Id=:Id and a.CompPost=:compost");
		final String hql = sb.toString();
		try{
			return   getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("Id", Id);
				q.setString("compost", compost);
				return q.list();
			}
		});
		
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	
	/**
	 * 描述：
	 * @param file
	 * @return
	 * @throws DAOException
	 */
	public PaginationSupport queryCompResumeByFile(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order) throws DAOException {
		try{
			return super.findPageByCriteria(criteria, startIndex, pageSize, order);
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	/**
	 * 描述：
	 * @param resumeId
	 * @return
	 * @throws DAOException
	 */
	public List<?> findCompResumeBypkresume(String resumeId)
			throws DAOException {
		final String Id = resumeId;
		StringBuffer sb;
		sb = new StringBuffer("from CompResume a join a.PkResume as p");
		sb.append(" where p.Id=:Id ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		sb.append(" and a.File="+IConstants.PERSON_DATABASE);
		final String hql = sb.toString();
		try{
			return   getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("Id", Id);
				return q.list();
			}
		});
		
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	/**
	 * 描述：根据resumeid查找（jialuhaoadd）
	 * @param resumeId
	 * @return
	 * @throws DAOException
	 */
	public List<?> findCompResumeBypersonid(String resumeId)
	throws DAOException {
   final String Id = resumeId;
   StringBuffer sb;
   sb = new StringBuffer("from CompResume a join a.PkResume as p");
   sb.append(" where p.Id=:Id ");
   sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
   final String hql = sb.toString();
   try{
	return   getHibernateTemplate().executeFind(new HibernateCallback() {
	public Object doInHibernate(Session session)
			throws HibernateException {
		Query q = session.createQuery(hql);
		q.setString("Id", Id);
		return q.list();
	}
});

}catch(DataAccessException e){
	throw new DAOException(IConstants.QUERY_FAIL,e);
}
}
}
