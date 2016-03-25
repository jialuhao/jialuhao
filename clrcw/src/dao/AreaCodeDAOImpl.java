package dao;

import java.sql.SQLException;
import java.util.List;

import model.Areacode;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class AreaCodeDAOImpl extends AbstractManager implements IAreaCodeDAO {

	public void delAreaCode(Areacode areacode) throws DAOException {
		try {
			areacode.setDr(IConstants.DEL_SIGN);
			super.update(areacode);
		} catch (DataAccessException de) {
			throw new DAOException(IConstants.DEL_FAIL, de);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Areacode> findAllAreaCode() throws DAOException {
		try {
			return super.findAll(Areacode.class);
			
		} catch (DAOException de) {
			throw new DAOException(IConstants.QUERY_FAIL, de);
		}
	}

	public List<Areacode> findAreaCodeById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from Areacode as a");
									// sb.append(" join a.JobCode as j join a.ResumeCode as person");
									// sb.append(" join person.Educate as e");
		sb.append(" where a.Id=:Id ");
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
	public List<Areacode> findAreaCodeByarea(String code) throws DAOException {
		final String Id = code;
		StringBuffer sb;
		sb = new StringBuffer("from Areacode as a");
									// sb.append(" join a.JobCode as j join a.ResumeCode as person");
									// sb.append(" join person.Educate as e");
		sb.append(" where a.Areacode=:Id ");
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
	public List<Areacode> findAreaCodeByname(String name) throws DAOException {
		final String Id = name;
		StringBuffer sb;
		sb = new StringBuffer("from Areacode as a");
									// sb.append(" join a.JobCode as j join a.ResumeCode as person");
									// sb.append(" join person.Educate as e");
		sb.append(" where a.Areaname=:Id ");
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

	public void saveAreaCode(Areacode areacode) throws DAOException {
		try {
			areacode.setDr(IConstants.DEFAULT_SIGN);
			super.save(areacode);
		} catch (DAOException de) {
			throw new DAOException(IConstants.SAVE_FAIL, de);
		}

	}

	public void updateAreaCode(Areacode areacode) throws DAOException {
			
		try{
			super.update(areacode);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

}
