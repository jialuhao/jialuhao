package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.CompImage;
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
public class CompImageDAOImpl extends AbstractManager implements 
ICompImageDAO {

	 private ICompImageDAO compImageDao;
	 
	
	public ICompImageDAO getCompImageDao() {
		return compImageDao;
	}

	public void setCompImageDao(ICompImageDAO compImageDao) {
		this.compImageDao = compImageDao;
	}

	/**
	 * 描述：
	 * @param personImage
	 * @throws DAOException
	 */
	public void delCompImage(CompImage compImage) throws DAOException {
		try{
			compImage.setDr(IConstants.DEL_SIGN);
			super.update(compImage);
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
	public List<CompImage> findCompImage(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from CompImage as a ");
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
	public void saveCompImage(CompImage compImage) throws DAOException {
		try{
			compImage.setDr(IConstants.DEFAULT_SIGN);
			super.save(compImage);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param personImage
	 * @throws DAOException
	 */
	public void updateCompImage(CompImage compImage) throws DAOException {
		// TODO Auto-generated method stub
		try{
			super.update(compImage);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}
}
