package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import util.PaginationSupport;

import model.CompResume;

import common.exception.BusinessException;
import common.exception.DAOException;


/**
 *<p>Title: 企业简历库接口</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface ICompResumeDAO {
	public abstract void saveToCompResume(CompResume compResume)throws DAOException; 
	public abstract void updateCompResume(CompResume compResume)throws DAOException;
	public abstract List<?> findAllResume(String comp_login_Id) throws DAOException;
	public abstract void delCompResume(CompResume compResume)throws DAOException;
	public abstract PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order)throws DAOException;
	public abstract List<CompResume> findCompResumeById(String id)throws DAOException;
	public PaginationSupport queryCompResumeByFile(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order) throws DAOException;
	public abstract List<?> findCompResumeByResumeId(String resumeId,String compLoginId)throws DAOException;
	public abstract List <?>findCompResumeByResumecompId(String resumeId, String CompPost)
	throws DAOException;
	public abstract List<?> findCompResumeBypkresume(String id)throws DAOException;
	public abstract List<?> findCompResumeBypersonid(String id)throws DAOException;
}
