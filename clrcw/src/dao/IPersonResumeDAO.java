package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import util.PaginationSupport;

import model.PersonResume;

import common.exception.DAOException;

/**
 *<p>Title: 个人简历信息库DAO接口</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface IPersonResumeDAO {

	public abstract void savePersonResume(PersonResume personResume)throws DAOException; 
	public abstract void updatePersonResume(PersonResume personResume)throws DAOException; 
	public abstract List<PersonResume> findAllResume() throws DAOException;
	public abstract void delPersonResume(PersonResume personResume)throws DAOException; 
	public abstract List<?> findResumeById(String id) throws DAOException;
	public abstract List<?> queryAssociate(String userId)throws DAOException;
	public abstract PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order)throws DAOException;
	public abstract List<?> queryAssociates(String userId)throws DAOException;
	public abstract List<?> findResumeBycardnumber(String cardnumber)throws DAOException;
}
