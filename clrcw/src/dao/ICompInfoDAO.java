package dao;

import java.util.List;

import model.CompInfo;

import common.exception.DAOException;

/**
 *<p>Title: 企业基本信息DAO接口</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface ICompInfoDAO {

	public abstract void saveCompInfo(CompInfo compInfo)  throws DAOException;
	public abstract List<CompInfo> findCompByCont(String queryString)  throws DAOException;
	public abstract void updateCompInfo(CompInfo compInfo) throws DAOException;
	public abstract void delCompInfo(CompInfo compInfo) throws DAOException;
	public abstract List<CompInfo> findAllComp() throws DAOException;
	public abstract CompInfo findCompById(String id)throws DAOException;
	public abstract List<CompInfo> findCompInfoById(String id)throws DAOException;
}
