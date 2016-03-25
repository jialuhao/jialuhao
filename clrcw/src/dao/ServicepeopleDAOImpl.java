package dao;

import java.sql.SQLException;
import java.util.List;

import model.Areacode;
import model.Servicepeople;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class ServicepeopleDAOImpl extends AbstractManager implements IServicepeopleDAO {

	public void delServicepeople(Servicepeople servicepeople) throws DAOException {
		try {
//			servicepeople.setDr(IConstants.DEL_SIGN);
			super.delete(servicepeople);
		} catch (DataAccessException de) {
			throw new DAOException(IConstants.DEL_FAIL, de);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Servicepeople> findAllServicepeople() throws DAOException {
		try {
			return super.findAll(Servicepeople.class);
			
		} catch (DAOException de) {
			throw new DAOException(IConstants.QUERY_FAIL, de);
		}
	}

	public List<Servicepeople> findServicepeopleById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from Servicepeople as a");
									// sb.append(" join a.JobCode as j join a.ResumeCode as person");
									// sb.append(" join person.Educate as e");
		sb.append(" where a.serviceid=:Id ");
									// sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();

		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery(hql);
				q.setString("Id", Id);
				return q.list();
			}
		});
	}
	

	public void saveServicepeople(Servicepeople servicepeople) throws DAOException {
		try {
//			servicepeople.setDr(IConstants.DEFAULT_SIGN);
			super.save(servicepeople);
		} catch (DAOException de) {
			throw new DAOException(IConstants.SAVE_FAIL, de);
		}

	}

	public void updateServicepeople(Servicepeople servicepeople) throws DAOException {
			
		try{
			super.update(servicepeople);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

}
