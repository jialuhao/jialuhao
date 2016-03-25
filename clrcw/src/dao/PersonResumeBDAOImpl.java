package dao;

import java.util.List;

import model.PersonResumeB;

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
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class PersonResumeBDAOImpl extends AbstractManager implements IPersonResumeBDAO {

	/* (non-Javadoc)
	 * @see dao.IPersonResumeBDAO#delPersonResume(model.PersonResumeB)
	 */
	public void delPersonResume(PersonResumeB personResumeB)
			throws DAOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try{
			personResumeB.setDr(IConstants.DEL_SIGN);
			super.update(personResumeB);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}


	/* (non-Javadoc)
	 * @see dao.IPersonResumeBDAO#findAllResume()
	 */
	public List<PersonResumeB> findAllResume() throws DAOException {
		// TODO Auto-generated method stub
		try{
			return super.findAll(PersonResumeB.class);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonResumeBDAO#findResumeById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List <PersonResumeB> findResumesById(String id) throws DAOException {
		// TODO Auto-generated method stub
		final String v_id = id;
		StringBuffer sb;
		sb = new StringBuffer("from PersonResumeB a ");
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
	 * @see dao.IPersonResumeBDAO#savePersonResume(model.PersonResumeB)
	 */
	public void savePersonResume(PersonResumeB personResumeB)
			throws DAOException {
		// TODO Auto-generated method stub

		try{
			personResumeB.setDr(IConstants.DEFAULT_SIGN);
			super.save(personResumeB);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/* (non-Javadoc)
	 * @see dao.IPersonResumeBDAO#updatePersonResume(model.PersonResumeB)
	 */
	public void updatePersonResume(PersonResumeB personResumeB)
			throws DAOException {
		// TODO Auto-generated method stub

		try{
			super.update(personResumeB);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

}
