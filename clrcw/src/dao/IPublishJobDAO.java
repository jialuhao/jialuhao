package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import util.JobShearchObject;
import util.PaginationSupport;

import model.PublishJobInfo;

import common.exception.DAOException;


public interface IPublishJobDAO {

	public abstract void savePublishJobInfo(PublishJobInfo publishJobInfo) throws DAOException;
	public abstract void updatePublicJobInfo(PublishJobInfo publishJobInfo) throws DAOException;
	public abstract List<PublishJobInfo> findAllJob() throws DAOException;
	public abstract void delPublishJobInfo(PublishJobInfo publishJobInfo) throws DAOException;
	public abstract List<?> findJobInfoById(String compLoginId) throws DAOException;
	public abstract List<?> findEnableJobInfoById(String compLoginId) throws DAOException;
	public abstract PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order)throws DAOException;
	public abstract List<Object[]> findJobById(Integer v_JobId) throws DAOException;
	public abstract List<Object[]> findPublicJobById(String id) throws DAOException;
	public abstract void saveJobInfo(PublishJobInfo publishJobInfo);
}
