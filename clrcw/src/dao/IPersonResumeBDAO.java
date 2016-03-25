package dao;

import java.util.List;
import model.PersonResumeB;

import common.exception.DAOException;

/**
 *<p>Title: 个人简历字表接口</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface IPersonResumeBDAO {
	public abstract void savePersonResume(PersonResumeB personResumeB)throws DAOException; 
	public abstract void updatePersonResume(PersonResumeB personResumeB)throws DAOException; 
	public abstract List<PersonResumeB> findAllResume() throws DAOException;
	public abstract void delPersonResume(PersonResumeB personResumeB)throws DAOException; 
	public abstract List<PersonResumeB> findResumesById(String id) throws DAOException;
	
}
