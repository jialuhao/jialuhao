package dao;

import java.sql.SQLException;
import java.util.List;

import model.Commoncode;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class CommonCodeDAOImpl extends AbstractManager implements
		ICommonCodeDAO {

	
	@SuppressWarnings("unchecked")
	public List<Commoncode> findAllCommonCode() throws DAOException {

		try {
			
			return super.findAll(Commoncode.class);
			
		} catch (DAOException de) {
			throw new DAOException(IConstants.QUERY_FAIL, de);
		}
	}

	
	public void delCommonCode(Commoncode commoncode) throws DAOException {
		try {
			commoncode.setDr(IConstants.DEL_SIGN);
			super.update(commoncode);
		} catch (DataAccessException de) {
			throw new DAOException(IConstants.DEL_FAIL, de);
		}									
	}

	
	
	public List<Commoncode> findCommonCodeById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from Commoncode as a");
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

	public void saveCommonCode(Commoncode commoncode) throws DAOException {
		try {
			commoncode.setFlag(IConstants.DEFAULT_SIGN);
			super.save(commoncode);
		} catch (DAOException de) {
			throw new DAOException(IConstants.SAVE_FAIL, de);
		}

	}

	public void updateCommonCode(Commoncode commoncode) throws DAOException {
		try {
			super.update(commoncode);
		} catch (DAOException de) {
			throw new DAOException(IConstants.UPDATE_FAIL, de);
		}
	}

}
