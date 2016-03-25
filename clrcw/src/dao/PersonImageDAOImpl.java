package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.PersonImage;
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
public class PersonImageDAOImpl extends AbstractManager implements
		IPersonImageDAO {
	
	/**
	 * 描述：
	 * @param personImage
	 * @throws DAOException
	 */
	public void delPersonImage(PersonImage personImage) throws DAOException {
		try{
			personImage.setDr(IConstants.DEL_SIGN);
			super.update(personImage);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
		
	}

	/**
	 * 描述：
	 * @param id 主键
	 * @return
	 * @throws DAOException
	 */
	public List<PersonImage> findPersonImage(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from PersonImage as a ");
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

	/**
	 * 描述：
	 * @param personImage
	 * @throws DAOException
	 */
	public void savePersonImage(PersonImage personImage) throws DAOException {
		try{
			personImage.setDr(IConstants.DEFAULT_SIGN);
			super.save(personImage);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param personImage
	 * @throws DAOException
	 */
	public void updatePersonImage(PersonImage personImage) throws DAOException {
		// TODO Auto-generated method stub
		try{
			super.update(personImage);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}
}
