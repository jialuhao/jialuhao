package dao;

import java.sql.SQLException;
import java.util.List;

import model.Servicelog;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class ServiceDAOImpl extends AbstractManager implements IServicelogDAO {

	public void delServicelog(Servicelog servicelog) throws DAOException {
		try {
			//servicelog.setDr(IConstants.DEL_SIGN);
			super.delete(servicelog);
		} catch (DataAccessException de) {
			throw new DAOException(IConstants.DEL_FAIL, de);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Servicelog> findAllServicelog() throws DAOException {
		try {
			return super.findAll(Servicelog.class);
			
		} catch (DAOException de) {
			throw new DAOException(IConstants.QUERY_FAIL, de);
		}
	}

	public List<Servicelog> findServicelogById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from Servicelog as a");
									// sb.append(" join a.JobCode as j join a.ResumeCode as person");
									// sb.append(" join person.Educate as e");
		sb.append(" where a.jobid=:Id ");
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

	public void saveServicelog(Servicelog servicelog) throws DAOException {
		try {
			//servicelog.setDr(IConstants.DEFAULT_SIGN);
			super.save(servicelog);
		} catch (DAOException de) {
			throw new DAOException(IConstants.SAVE_FAIL, de);
		}

	}

	public void updateServicelog(Servicelog servicelog) throws DAOException {
			
		try{
			super.update(servicelog);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}
	
	public List<Servicelog> queryServicelogById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from Servicelog as a");
									// sb.append(" join a.JobCode as j join a.ResumeCode as person");
									// sb.append(" join person.Educate as e");
		sb.append(" where a.id=:Id ");
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
}
