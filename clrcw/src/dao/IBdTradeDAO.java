package dao;

import java.util.List;

import model.BdTrade;

import common.exception.DAOException;

public interface IBdTradeDAO {

	public abstract void saveBdTrade(BdTrade bdTrade)throws DAOException; 
	public abstract void updateBdTrade(BdTrade bdTrade)throws DAOException; 
	public abstract List<BdTrade> findAllTrade() throws DAOException;
	public abstract void delBdTrade(BdTrade bdTrade)throws DAOException; 
	public abstract List<BdTrade> findTradeById(String id) throws DAOException;
}
