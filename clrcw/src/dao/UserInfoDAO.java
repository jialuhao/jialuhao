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

import model.UserInfo;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class UserInfoDAO extends AbstractManager implements IUserInfoDAO {

	public void save(UserInfo userInfo) {
		try{
			userInfo.setDr(IConstants.DEFAULT_SIGN);
			getHibernateTemplate().save(userInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	@SuppressWarnings("unchecked")
	public List findAllUser() throws DAOException{
		try{
			return 	super.findAll(UserInfo.class);
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	@SuppressWarnings("unchecked")
	public List getUser(String v_name,String v_password) throws DAOException{
		final String username = v_name;
		final String password = v_password;
		StringBuffer sb;
		sb = new StringBuffer("from UserInfo a ");
		sb.append(" where a.LoginId=:name and a.Password=:password");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("name", username);
				q.setString("password", password);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List getUser(String v_name) throws DAOException{
		final String username = v_name;
		
		StringBuffer sb;
		sb = new StringBuffer("from UserInfo a ");
		sb.append(" where a.LoginId=:name ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("name", username);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserInfoDAO#updateUserInfo(model.UserInfo)
	 */
	public void updateUserInfo(UserInfo userInfo) throws DAOException {
		// TODO Auto-generated method stub
		try{
			getHibernateTemplate().update(userInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserInfoDAO#delUserInfo(model.UserInfo)
	 */
	public void delUserInfo(UserInfo userInfo) throws DAOException {
		// TODO Auto-generated method stub
		try{
			userInfo.setDr(IConstants.DEL_SIGN);
			getHibernateTemplate().update(userInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
		
	}
	public PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order){
		return super.findPageByCriteria(criteria, startIndex, pageSize, order);
	}

	/**
	 * 描述：
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public List<UserInfo> findUserById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from UserInfo as a ");
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
