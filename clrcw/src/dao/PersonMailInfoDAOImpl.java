package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.PersonMailInfo;
import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: 个人投送简历dao实现类</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class PersonMailInfoDAOImpl extends AbstractManager implements
		IPersonMailInfoDAO {

	/**
	 * 描述：删除
	 * @param personMailInfo
	 * @throws DAOException
	 */
	public void delMailInfo(PersonMailInfo personMailInfo) throws DAOException {
		try{
			personMailInfo.setDr(IConstants.DEL_SIGN);
			super.update(personMailInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}

	}

	/**
	 * 描述：根据个人登录id检索
	 * @param person_loginId 个人用户登录id
	 * @return
	 * @throws DAOException
	 */
	public List<?> findMailInfo(String person_loginId) throws DAOException {
		final String loginId = person_loginId;
		StringBuffer sb;
		sb = new StringBuffer("from PersonMailInfo a ");
		sb.append(" where a.UserLoginId=:loginId ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("loginId", loginId);
				return q.list();
			}
		});
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/**
	 * 描述：保存
	 * @param personMailInfo
	 * @throws DAOException
	 */
	public void saveMailInfo(PersonMailInfo personMailInfo) throws DAOException {
		try{
			personMailInfo.setDr(IConstants.DEFAULT_SIGN);
			super.save(personMailInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}

	}

	/**
	 * 描述：更新
	 * @param personMailInfo
	 * @throws DAOException
	 */
	public void updateMailInfo(PersonMailInfo personMailInfo)
			throws DAOException {
		try{
			super.update(personMailInfo);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}

	}

}
