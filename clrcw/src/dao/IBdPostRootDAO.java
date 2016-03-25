package dao;

import java.util.List;

import model.BdPostRoot;
import model.BdTrade;

import common.exception.DAOException;

/**
 *<p>Title: </p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface IBdPostRootDAO {
	public abstract void saveBdPostRoot(BdPostRoot bdPostRoot)throws DAOException; 
	public abstract void updateBdPostRoot(BdPostRoot bdPostRoot)throws DAOException; 
	public abstract List<BdPostRoot> findAllPostRoot() throws DAOException;
	public abstract void delBdPostRoot(BdPostRoot bdPostRoot)throws DAOException; 
	public abstract List<BdPostRoot> findPostRootById(String id) throws DAOException;
}
