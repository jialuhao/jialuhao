package dao;

import java.util.List;

import model.ApplyJobInfo;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import util.PaginationSupport;

import common.exception.DAOException;

/**
 *<p>Title: 个人用户申请职位</p>
 *
 *<p>Description: 定义dao接口,与实现分离</p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface IApplyJobInfoDAO {
	public abstract List<?> queryApplyJobById(String Id) throws DAOException;
	public abstract List<?> findApplyJobById(String Id) throws DAOException;
	public abstract void save(ApplyJobInfo applyJobInfo) throws DAOException;
	public abstract void update(ApplyJobInfo applyJobInfo) throws DAOException;
	public abstract List<?> findApplyJobByCont(String v_personId ,String v_resumeId) throws DAOException;
	public abstract List<?> findAll() throws DAOException;
	public abstract void delete(ApplyJobInfo applyJobInfo) throws DAOException;
	public abstract List<?> findApplyJobByCont(String v_personId) throws DAOException;
	public abstract List<?> findApplyJobBypersonid(String v_personId) throws DAOException;
	public abstract PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order)throws DAOException;
	
	//public abstract ApplyJobInfo findApplyJob(String jobId) throws DAOException;
}
