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

import model.CompInfo;
import model.PersonResume;
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
public class PersonResumeDAOImpl extends AbstractManager implements
		IPersonResumeDAO {

	
	/* (non-Javadoc)
	 * @see dao.IPersonResumeDAO#findResumeById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
public List<?> findResumeBycardnumber(String cardnumber) throws DAOException {
		// TODO Auto-generated method stub
		
		final String v_id = cardnumber;
		StringBuffer sb;
		sb = new StringBuffer("from PersonResume a join a.Educate as e ");
		sb.append(" where a.cardnumber=:fkUser ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		    List<PersonResume> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("fkUser",v_id);
				return q.list();
			}
		});
		    return list;
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	public List<?> findResumeById(String id) throws DAOException {
		// TODO Auto-generated method stub
		
		final String v_id = id;
		StringBuffer sb;
		sb = new StringBuffer("from PersonResume a join a.Educate as e ");
		sb.append(" where a.User=:fkUser ");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		    List<PersonResume> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("fkUser",v_id);
				return q.list();
			}
		});
		    return list;
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonResumeDAO#findAllResume()
	 */
	@SuppressWarnings("unchecked")
	public List<PersonResume> findAllResume() throws DAOException {
		try{
			return super.findAll(PersonResume.class);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonResumeDAO#save(model.CompResume)
	 */
	public void savePersonResume(PersonResume personResume) {
		try{
			personResume.setDr(IConstants.DEFAULT_SIGN);
			super.save(personResume);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonResumeDAO#updatePersonResume(model.PersonResume)
	 */
	public void updatePersonResume(PersonResume personResume)
			throws DAOException {
		// TODO Auto-generated method stub
		try{
			super.update(personResume);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonResumeDAO#delPersonResume(model.PersonResume)
	 */
	public void delPersonResume(PersonResume personResume) throws DAOException {
		// TODO Auto-generated method stub
		try{
			personResume.setDr(IConstants.DEL_SIGN);
			super.update(personResume);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：多表联查(不包括个人照片)
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public List<?> queryAssociate(String v_userId) throws DAOException {

		final String userId = v_userId;
		StringBuffer sb;
		//sb = new StringBuffer("select p.Id,p.Name,p.Sex,p.Birthday,p.Homeplace,p.Address,p.Mailcode,p.Phone," +
				//"p.School,p.Specialty,p.LimitYear,p.CompLevel,p.Lang,p.Lang2,p.Level1,p.Level2,p.IntroSelf,p.Dr,u");
		sb = new StringBuffer(" from PersonResume as p join p.Educate as e " +
								" join p.User as u ");
		sb.append(" where p.User=u.Id and p.Educate=e.Id and u.LoginId=:userId ");
		sb.append(" and p.Dr="+IConstants.DEFAULT_SIGN);
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
	 * 描述：多表联查(包括个人照片)
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public List<?> queryAssociates(String v_userId) throws DAOException {

		final String userId = v_userId;
		StringBuffer sb;
		//sb = new StringBuffer("select p.Id,p.Name,p.Sex,p.Birthday,p.Homeplace,p.Address,p.Mailcode,p.Phone," +
				//"p.School,p.Specialty,p.LimitYear,p.CompLevel,p.Lang,p.Lang2,p.Level1,p.Level2,p.IntroSelf,p.Dr,u");
		sb = new StringBuffer(" from PersonResume as p join p.Educate as e " +
								" join p.User as u join p.FkPersonImage as f");
		sb.append(" where p.User=u.Id and p.Educate=e.Id and u.LoginId=:userId ");
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
	
	public PaginationSupport findPageByCriteria(DetachedCriteria criteria,
			int startIndex, int pageSize, Order order) {
		return super.findPageByCriteria(criteria, startIndex, pageSize, order);
	}

}
