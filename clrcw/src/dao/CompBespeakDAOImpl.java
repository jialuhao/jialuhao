package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.CompBespeak;
import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class CompBespeakDAOImpl extends AbstractManager implements
		ICompBespeakDAO {

	/**
	 * 描述：
	 * @param compBespeak
	 * @throws DAOException
	 */
	public void delCompBespeak(CompBespeak compBespeak) throws DAOException {
		try{
			compBespeak.setDr(IConstants.DEL_SIGN);
			super.update(compBespeak);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CompBespeak> findAllCompBespeak() throws DAOException {
		
		
		StringBuffer sb;
		sb = new StringBuffer("from CompBespeak a ");
		sb.append(" where a.CompStatus=:status ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
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

	/**
	 * 
	 * 描述：检索
	 * @param v_userid
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CompBespeak> getCompUser(String v_userid) throws DAOException{
		final String userId = v_userid;
		
		StringBuffer sb;
		sb = new StringBuffer("from CompBespeak a ");
		sb.append(" where a.UserId=:userId ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("userId", userId);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	
	/**
	 * 描述：
	 * @param compBespeak
	 * @throws DAOException
	 */
	public void saveCompBespeak(CompBespeak compBespeak) throws DAOException {
		try{
			compBespeak.setDr(IConstants.DEFAULT_SIGN);
			super.save(compBespeak);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
		
	}

	/**
	 * 描述：
	 * @param compBespeak
	 * @throws DAOException
	 */
	public void updateCompBespeak(CompBespeak compBespeak) throws DAOException {
		
		try{
			super.update(compBespeak);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}
	/**
	 * 描述：查询所有通过审核，允许登录的企业用户
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CompBespeak> findAllCompEnroll() throws DAOException {
		
		
		StringBuffer sb;
		sb = new StringBuffer("from CompBespeak a ");
		sb.append(" where a.CompStatus=:status ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("status", IConstants.ENROLL_SIGN);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/**
	 * 描述：
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public List<CompBespeak> findCompBespeakById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from CompBespeak as a ");
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
	
	public List<CompBespeak> queryCompUserBycompnum(String compnum) throws DAOException {
		final String Id = compnum;
		StringBuffer sb;
		sb = new StringBuffer("from CompBespeak as a ");
								//sb.append(" join a.JobCode as j join a.ResumeCode as person");
								//sb.append(" join person.Educate as e");
		sb.append(" where a.compnum=:Id ");
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
	}
	catch(DataAccessException de){
		throw new DAOException(IConstants.DEL_FAIL,de);
	}
	}
}
