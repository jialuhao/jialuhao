package dao;

import java.util.List;

import org.springside.core.exception.BusinessException;

import model.PersonEducation;

import common.exception.DAOException;

/**
 *<p>Title: 个人简历教育培训经历</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 太极</p>
 *
 * @author 苏成龙
 *
 * @version 1.0
 */
public interface IPersonEducationDAO {
	public abstract void savePersonEducation(PersonEducation personEducation)throws DAOException,BusinessException; 
	public abstract void updatePersonEducation(PersonEducation personEducation)throws DAOException; 
	public abstract List<PersonEducation> findAllEducation() throws DAOException;
	public abstract void delPersonEducation(PersonEducation personEducation)throws DAOException; 
	public abstract List<PersonEducation> findEducationsById(String id) throws DAOException;
	public abstract List<PersonEducation> findEducationsByEduId(String id) throws DAOException;
	
}
