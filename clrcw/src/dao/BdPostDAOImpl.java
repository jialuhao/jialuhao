package dao;

import java.util.List;

import model.BdPost;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>Title: 岗位下拉框</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class BdPostDAOImpl extends AbstractManager implements IBdPostDAO {

	/**
	 * 描述：
	 * @param bdPost
	 * @throws DAOException
	 */
	public void delBdPost(BdPost bdPost) throws DAOException {
		try{
			bdPost.setDr(IConstants.DEL_SIGN);
			super.update(bdPost);
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
	public List<BdPost> findAllPost() throws DAOException {
	
		try{
			return 	super.findAll(BdPost.class);
		}catch(DAOException de){
			throw new DAOException(IConstants.QUERY_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdPost
	 * @throws DAOException
	 */
	public void saveBdPost(BdPost bdPost) throws DAOException {
		try{
			bdPost.setDr(IConstants.DEFAULT_SIGN);
			super.save(bdPost);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.SAVE_FAIL,de);
		}
	}

	/**
	 * 描述：
	 * @param bdPost
	 * @throws DAOException
	 */
	public void updateBdPost(BdPost bdPost) throws DAOException {
		try{
			super.update(bdPost);
		}catch(DataAccessException de){
			throw new DAOException(IConstants.UPDATE_FAIL,de);
		}
	}

	/**
	 * 描述：根据岗位大类主键id查询岗位小类
	 * @param v_Id 岗位大类主键id
	 * @throws DAOException
	 */
	public List<?> findPostByRoot(String v_Id) throws DAOException {
		final String Id = v_Id;
		StringBuffer sb;
		sb = new StringBuffer("from BdPost as a join a.PostIdRoot as p");
								//" join a.ResumeCode as resume");
		sb.append(" where p.Id=:Id");
		sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
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
		}catch(DataAccessException e){
			throw new DAOException(IConstants.QUERY_FAIL,e);
		}
	}

	/**
	 * 描述：
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public List<BdPost> findPostById(String id) throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from BdPost as a ");
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
