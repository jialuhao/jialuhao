package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import model.PersonResume;
import model.Recommends;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

public class RecommendsDAOImpl  extends AbstractManager implements IRecommendsDAO{

	public void saveRecommends(Recommends recommends) throws DAOException {
		
	try {
		
		super.save(recommends);

	} catch (DataAccessException e) {

		throw new DAOException(IConstants.SAVE_FAIL, e);
	}

		
	}
	public void delRecommends(Recommends recommends) throws DAOException {
		
		try {
			
			super.delete(recommends);

		} catch (DataAccessException e) {

			throw new DAOException(IConstants.SAVE_FAIL, e);
		}

			
		}
	
	public  List<?> findRecommendsbyservice(String id) throws DAOException {
		

		
		final String v_id = id;
		StringBuffer sb;
		sb = new StringBuffer("from Recommends a ");
		sb.append(" where a.serviceid=:fkUser ");
		
		final String hql = sb.toString();
		try{
		    List<PersonResume> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("fkUser",v_id);
				return q.list();
			}
		});
		    return list;
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}		
	}
public  List<?> findRecommendsbycardnumber(String cardnumber) throws DAOException {
		

		
		final String v_id = cardnumber;
		StringBuffer sb;
		sb = new StringBuffer("from Recommends a ");
		sb.append(" where a.cardnumber=:fkUser ");
		
		final String hql = sb.toString();
		try{
		    List<PersonResume> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(hql);
				q.setString("fkUser",v_id);
				return q.list();
			}
		});
		    return list;
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}		
	}
}
