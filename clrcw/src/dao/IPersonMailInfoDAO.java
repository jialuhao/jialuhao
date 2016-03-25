package dao;

import java.util.List;

import model.PersonMailInfo;

import common.exception.DAOException;

/**
 *<p>Title: 个人投送简历dao接口</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface IPersonMailInfoDAO {

	public void saveMailInfo(PersonMailInfo personMailInfo) throws DAOException;
	public List<?> findMailInfo(String person_loginId) throws DAOException;
	public void updateMailInfo(PersonMailInfo personMailInfo) throws DAOException;
	public void delMailInfo(PersonMailInfo personMailInfo) throws DAOException;
	
}
