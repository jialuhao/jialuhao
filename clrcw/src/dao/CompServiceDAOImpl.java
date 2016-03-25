package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.CompService;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class CompServiceDAOImpl extends AbstractManager implements ICompServiceDAO{
	public  void saveCompservice(CompService compservice)throws DAOException{
		try {
			
			super.save(compservice);
		} catch (DAOException de) {
			throw new DAOException(IConstants.SAVE_FAIL, de);
		}
	}
	public List<?> findCompservicebyjobid(String id)throws DAOException{
		try {
			
			final String vid = id;
			StringBuffer sb;
			sb = new StringBuffer("from CompService a");
			
			sb.append(" where a.pkjob =:jobid ");
			
			
			final String hql = sb.toString();
			try{
			    return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException {
					Query q = session.createQuery(hql);
					q.setString("jobid",vid);
					return q.list();
				}
			});
			    //return list.get(0);
			}catch(DataAccessException e){
				throw new DAOException(IConstants.QUERY_FAIL,e);
			}
		} catch (DAOException de) {
			throw new DAOException(IConstants.SAVE_FAIL, de);
		}
	}
}
