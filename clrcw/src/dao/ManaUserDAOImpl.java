package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.ManaUser;
import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class ManaUserDAOImpl extends AbstractManager implements IManaUserDAO {


	/**
	 * 描述：检索
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManaUser> findAllManaUser() throws DAOException {
		try{
			//return super.findAll(ManaUser.class);
			 return getHibernateTemplate().find("from ManaUser where dr='"+IConstants.DEFAULT_SIGN+"' and account <>'admin'"); 
		}catch(DataAccessException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/**
	 * 描述：保存
	 * @param manaUser
	 * @throws DAOException
	 */
	public void saveManaUser(ManaUser manaUser) throws DAOException {
		try{
			manaUser.setDr(IConstants.DEFAULT_SIGN);
			super.save(manaUser);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：更新
	 * @param manaUser
	 * @throws DAOException
	 */
	public void updateManaUser(ManaUser manaUser) throws DAOException {
		try{
			super.update(manaUser);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param manaUser
	 * @throws DAOException
	 */
	public void delManaUser(ManaUser manaUser) throws DAOException {
		try{
			manaUser.setDr(IConstants.DEL_SIGN);
			super.update(manaUser);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
		
	}

	/**
	 * 描述：
	 * @param username
	 * @param password
	 * @throws DAOException
	 */
	public List<ManaUser> backLogin(String v_loginname, String v_password) throws DAOException {
		final String loginname = v_loginname;
		final String password = v_password;
		StringBuffer sb;
		sb = new StringBuffer("from ManaUser a ");
		sb.append(" where a.Account=:account and a.Password=:password");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("account", loginname);
				q.setString("password", password);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/**
	 * 描述：
	 * @param username
	 * @return
	 * @throws DAOException
	 */
	public List<ManaUser> backLogin(String username) throws DAOException {
		final String loginname = username;
		
		StringBuffer sb;
		sb = new StringBuffer("from ManaUser a ");
		sb.append(" where a.Account=:account");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("account", loginname);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	
}
