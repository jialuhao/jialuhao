package dao;

import java.sql.SQLException;
import java.util.List;

import model.BdSalary;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class BdSalaryDAOImpl extends AbstractManager implements IBdSalaryDAO {

	public void delSalary(BdSalary salary) throws DAOException {
		try {
			salary.setDr(IConstants.DEL_SIGN);
			super.update(salary);
		} catch (DataAccessException de) {
			throw new DAOException(IConstants.DEL_FAIL, de);
		}

	}

	@SuppressWarnings("unchecked")
	public List<BdSalary> findAllSalary() throws DAOException {
		try {
			return super.findAll(BdSalary.class);
			
		} catch (DAOException de) {
			throw new DAOException(IConstants.QUERY_FAIL, de);
		}
	}

	public List<BdSalary> findSalaryById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from BdSalary as a");
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

	public void saveSalary(BdSalary salary) throws DAOException {
		try {
			salary.setDr(IConstants.DEFAULT_SIGN);
			super.save(salary);
		} catch (DAOException de) {
			throw new DAOException(IConstants.SAVE_FAIL, de);
		}

	}

	public void updateSalary(BdSalary salary) throws DAOException {
			
		try{
			super.update(salary);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

}
