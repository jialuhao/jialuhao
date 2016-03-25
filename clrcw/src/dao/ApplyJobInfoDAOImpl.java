package dao;

import java.util.List;

import model.ApplyJobInfo;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import util.PaginationSupport;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: 个人简历申请职位dao接口</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class ApplyJobInfoDAOImpl extends AbstractManager implements
		IApplyJobInfoDAO {

	/**
	 * 
	 * 描述：检索个人申请职位历史信息
	 */
	@SuppressWarnings("unchecked")
	public List<?> findAll() {
		
		StringBuffer sb;
		sb = new StringBuffer("from ApplyJobInfo as a ");
								sb.append(" join a.JobCode as j");
								sb.append(" join a.ResumeCode as r");
								sb.append(" join r.Educate as e");
								sb.append(" where a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<?> findApplyJobByCont(String v_personId ,String v_resumeId)
			throws DAOException {
		// TODO Auto-generated method stub
		final String personId = v_personId;
		final String resumeId = v_resumeId;
		StringBuffer sb;
		sb = new StringBuffer("from ApplyJobInfo as a join a.PersonCode as person " +
								" join a.ResumeCode as resume");
		sb.append(" where resume.Id=:resumeId and person.Id=:personCode ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("personCode", personId);
				q.setString("resumeId", resumeId);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	
	/**
	 * 描述：
	 * @param id 个人登录id
	 * @return
	 * @throws DAOException
	 */
	public List<?> findApplyJobByCont(String v_personId) throws DAOException {
		
		
		final String personId = v_personId;
		StringBuffer sb;
		sb = new StringBuffer("from ApplyJobInfo as a join a.PostCode as p ");
								sb.append(" join a.JobCode as j join a.PersonCode as person");
		sb.append(" where person.LoginId=:personId ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("personId", personId);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/**
	 * 描述：
	 * @param id 个人登录id
	 * @return
	 * @throws DAOException
	 */
	public List<?> findApplyJobBypersonid(String v_personId) throws DAOException {
		
		
		final String personId = v_personId;
		StringBuffer sb;
		sb = new StringBuffer("from ApplyJobInfo as a join a.PostCode as p ");
								sb.append(" join a.JobCode as j join a.PersonCode as person");
		sb.append(" where person.LoginId=:personId ");
		
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("personId", personId);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	public void save(ApplyJobInfo applyJobInfo) {
		// TODO Auto-generated method stub
		try{
			applyJobInfo.setDr(IConstants.DEFAULT_SIGN);
			super.save(applyJobInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}


	
	public void update(ApplyJobInfo applyJobInfo) throws DAOException {
		// TODO Auto-generated method stub
		try{
			super.update(applyJobInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}


	
	public void delete(ApplyJobInfo applyJobInfo) throws DAOException {
		// TODO Auto-generated method stub
		try{
			applyJobInfo.setDr(IConstants.DEL_SIGN);
			super.update(applyJobInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
	}
	
	public PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order) throws DAOException{
		return super.findPageByCriteria(criteria, startIndex, pageSize, order);
	}


	/**
	 * 描述：根据主键id查询
	 * @param Id 主键id
	 * @return
	 * @throws DAOException
	 */
	public List<?> findApplyJobById(String v_Id) throws DAOException {
		
			final String Id = v_Id;
			StringBuffer sb;
			sb = new StringBuffer("from ApplyJobInfo as a join a.PostCode as p ");
									sb.append(" join a.JobCode as j join a.ResumeCode as person");
									sb.append(" join person.Educate as e");
									sb.append(" join a.PersonCode as pe");
			sb.append(" where a.Id=:Id ");
			sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
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
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	/**
	 * 描述：根据主键id查询
	 * @param Id 主键id
	 * @return
	 * @throws DAOException
	 */
	public List<?> queryApplyJobById(String v_Id) throws DAOException {
		
			final String Id = v_Id;
			StringBuffer sb;
			sb = new StringBuffer("from ApplyJobInfo as a join a.PostCode as p ");
									sb.append(" join a.JobCode as j join a.ResumeCode as person");
									sb.append(" join person.Educate as e");
									sb.append(" join a.PersonCode as pe");
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
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
}
