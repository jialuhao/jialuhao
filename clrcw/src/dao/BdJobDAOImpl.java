package dao;

import java.util.List;

import model.BdJob;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;


public class BdJobDAOImpl extends AbstractManager implements IBdJobDAO {

	/**
	 * 描述：
	 * @param bdJob
	 * @throws DAOException
	 */
	public void delBdJob(BdJob bdJob) throws DAOException {
		try{
			bdJob.setDr(IConstants.DEL_SIGN);
			super.update(bdJob);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.DEL_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdJob> findAllJob() throws DAOException {
		
		try{
			return 	super.findAll(BdJob.class);
		}catch(DAOException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdJob
	 * @throws DAOException
	 */
	public void saveBdJob(BdJob bdJob) throws DAOException {
		try{
			bdJob.setDr(IConstants.DEFAULT_SIGN);
			super.save(bdJob);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdJob
	 * @throws DAOException
	 */
	public void updateBdJob(BdJob bdJob) throws DAOException {
		try{
			super.update(bdJob);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public List<BdJob> findJobById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from BdJob as a ");
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
}
