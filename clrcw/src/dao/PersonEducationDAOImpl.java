package dao;

import java.util.List;

import model.PersonEducation;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: </p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 太极</p>
 *
 * @author 苏成龙
 *
 * @version 1.0
 */
public class PersonEducationDAOImpl extends AbstractManager implements IPersonEducationDAO {

	/* (non-Javadoc)
	 * @see dao.IPersonResumeBDAO#delPersonResume(model.PersonResumeB)
	 */
	public void delPersonEducation(PersonEducation personEducation)
			throws DAOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try{
			personEducation.setDr(IConstants.DEL_SIGN);
			super.update(personEducation);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}


	/* (non-Javadoc)
	 * @see dao.IpersonEducationDAO#findAllResume()
	 */
	public List<PersonEducation> findAllEducation() throws DAOException {
		// TODO Auto-generated method stub
		try{
			return super.findAll(PersonEducation.class);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonEducationDAO#findResumeById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List <PersonEducation> findEducationsById(String id) throws DAOException {
		// TODO Auto-generated method stub
		final String v_id = id;
		StringBuffer sb;
		sb = new StringBuffer("from PersonEducation a ");
		sb.append(" where a.UserLoginId = :loginId");
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
	 * @see dao.IPersonEducationDAO#findResumeById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List <PersonEducation> findEducationsByEduId(String id) throws DAOException {
		// TODO Auto-generated method stub
		final String v_id = id;
		StringBuffer sb;
		sb = new StringBuffer("from PersonEducation a ");
		sb.append(" where a.id = :Id");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try{
		    return  getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("Id",v_id);
				return q.list();
			}
		});
		    //return list.get(0);
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}
	/* (non-Javadoc)
	 * @see dao.IPersonEducationDAO#savePersonResume(model.PersonEducation)
	 */
	public void savePersonEducation(PersonEducation personEducation)
			throws DAOException {
		// TODO Auto-generated method stub

		try{
			personEducation.setDr(IConstants.DEFAULT_SIGN);
			super.save(personEducation);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonEducationDAO#updatePersonResume(model.PersonEducation)
	 */
	public void updatePersonEducation(PersonEducation PersonEducation)
			throws DAOException {
		// TODO Auto-generated method stub

		try{
			super.update(PersonEducation);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

}
