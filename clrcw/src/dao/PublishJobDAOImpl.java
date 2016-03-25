package dao;

import java.util.List;

import model.PublishJobInfo;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import util.DateUtil;
import util.JobShearchObject;
import util.PaginationSupport;

import common.constants.IConstants;
import common.dao.AbstractManager;
import common.exception.DAOException;

/**
 *<p>
 * Title: 企业发布职位信息实现类
 * </p>
 * 
 *<p>
 * Description:
 * </p>
 * 
 *<p>
 * Company: 航天四创
 * </p>
 * 
 * @author 李滨
 * 
 * @version 1.0
 */
public class PublishJobDAOImpl extends AbstractManager implements
		IPublishJobDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPublishJobDAO#findAllJob()
	 */


	@SuppressWarnings("unchecked")
	public List findAllJob() throws DAOException {

		// 取系统当前时间
		String currentDate = DateUtil.getNowTime(true);
		try {
			StringBuffer sb;
			sb = new StringBuffer("from PublishJobInfo as a join a.Post as p "
					+ " join a.Job as j");
			sb.append(" join a.Education as e");
			sb.append(" join a.PkComp as c ");
			sb.append(" join c.Type as t ");
			sb.append(" join c.Comp as comp ");
			sb.append(" where a.Dr=" + IConstants.DEFAULT_SIGN);
			sb.append(" and a.CloseTime> '" + currentDate + "'");
			final String hql = sb.toString();

			try {
				return getHibernateTemplate().executeFind(
						new HibernateCallback() {
							public Object doInHibernate(Session session)
									throws HibernateException {
								Query q = session.createQuery(hql);
								return q.list();
							}
						});
			} catch (DataAccessException e) {
				throw new DAOException(IConstants.QUERY_FAIL, e);
			}
		} catch (DataAccessException de) {
			throw new DAOException(IConstants.QUERY_FAIL, de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param compId
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<?> findJobInfoById(String v_compLoginId) throws DAOException {

		final String compLoginId = v_compLoginId;
		StringBuffer sb;
		sb = new StringBuffer("from PublishJobInfo as a join a.Post as p "
				+ " join a.Job as j join a.PkComp as c");
		sb.append(" join a.Education as e ");
		sb.append(" where a.CompLoginId=:loginId ");
		sb.append(" and a.Dr=" + IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException {
					Query q = session.createQuery(hql);
					q.setString("loginId", compLoginId);
					return q.list();
				}
			});
		} catch (DataAccessException e) {
			throw new DAOException(IConstants.QUERY_FAIL, e);
		}
	}
	
	public List<?> findEnableJobInfoById(String v_compLoginId) throws DAOException {
		// 取系统当前时间
		String currentDate = DateUtil.getNowTime(true);
		final String compLoginId = v_compLoginId;
		StringBuffer sb;
		sb = new StringBuffer("from PublishJobInfo as a join a.Post as p "
				+ " join a.Job as j join a.PkComp as c");
		sb.append(" join a.Education as e ");
		sb.append(" where a.CompLoginId=:loginId ");
		sb.append(" and a.Status=2" );
		sb.append(" and a.validflag=1" );
	
		sb.append(" and a.CloseTime>= '" + currentDate + "'");
		sb.append(" and a.Dr=" + IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException {
					Query q = session.createQuery(hql);
					q.setString("loginId", compLoginId);
					return q.list();
				}
			});
		} catch (DataAccessException e) {
			throw new DAOException(IConstants.QUERY_FAIL, e);
		}
	}
	/**
	 * 描述：根据id检索企业职位发布
	 * 
	 * @param v_JobId
	 *            职位id
	 * @return
	 * @throws DAOException
	 */
	public List<Object[]> findJobById(Integer v_JobId) throws DAOException {

		final Integer jobId = v_JobId;
		StringBuffer sb;
		sb = new StringBuffer("from PublishJobInfo as a ");
		sb.append(" join a.Education as e ");
		sb.append(" join a.Post as p ");
		sb.append(" join a.Job as j ");
		sb.append(" where a.Id=:jobId ");
		sb.append(" and a.Dr=" + IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException {
					Query q = session.createQuery(hql);
					q.setInteger("jobId", jobId);
					return q.list();
				}
			});
		} catch (DataAccessException e) {
			throw new DAOException(IConstants.QUERY_FAIL, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPublishJobDAO#savePublishJobInfo()
	 */
	public void savePublishJobInfo(PublishJobInfo publishJobInfo)
			throws DAOException {
		// TODO Auto-generated method stub
		try {
			publishJobInfo.setDr(IConstants.DEFAULT_SIGN);
			super.save(publishJobInfo);

		} catch (DataAccessException e) {

			throw new DAOException(IConstants.SAVE_FAIL, e);
		}
	}

	public void saveJobInfo(PublishJobInfo publishJobInfo) throws DAOException {
		// TODO Auto-generated method stub
		try {
			super.save(publishJobInfo);

		} catch (DataAccessException e) {

			throw new DAOException(IConstants.SAVE_FAIL, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPublishJobDAO#updatePublicJobInfo(model.PublishJobInfo)
	 */
	public void updatePublicJobInfo(PublishJobInfo publishJobInfo)
			throws DAOException {
		// TODO Auto-generated method stub
		try {
			super.update(publishJobInfo);

		} catch (DataAccessException e) {

			throw new DAOException(IConstants.UPDATE_FAIL, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPublishJobDAO#delPublishJobInfo(model.PublishJobInfo)
	 */
	public void delPublishJobInfo(PublishJobInfo publishJobInfo)
			throws DAOException {
		// TODO Auto-generated method stub
		try {
			publishJobInfo.setDr(IConstants.DEL_SIGN);
			super.update(publishJobInfo);

		} catch (DataAccessException e) {

			throw new DAOException(IConstants.DEL_FAIL, e);
		}
	}

	public PaginationSupport findPageByCriteria(DetachedCriteria criteria,
			int startIndex, int pageSize, Order order) {
		return super.findPageByCriteria(criteria, startIndex, pageSize, order);
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public List<Object[]> findPublicJobById(String id)
			throws DAOException {
		final String Id = id;
		StringBuffer sb;
		sb = new StringBuffer("from PublishJobInfo as a ");
		sb.append("join a.Post as p ");
		 sb.append(" join a.Job as j");
		sb.append(" join a.PkComp as c");
		sb.append(" join c.Comp as o");
		sb.append(" where a.Id=:Id ");
		// sb.append(" and a.Dr="+IConstants.DEFAULT_SIGN);
		final String hql = sb.toString();
		try {

			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException {
					Query q = session.createQuery(hql);
					q.setString("Id", Id);
					return q.list();
				}
			});
		} catch (DataAccessException de) {
			throw new DAOException(IConstants.DEL_FAIL, de);
		}
	}
}
