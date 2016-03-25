package dao;

import java.util.List;

import model.BdEducate;

import common.exception.DAOException;

public interface IBdEducateDAO {

	public abstract void saveBdEducate(BdEducate bdEducate)throws DAOException; 
	public abstract void updateBdEducate(BdEducate bdEducate)throws DAOException; 
	public abstract List<BdEducate> findAllEducate() throws DAOException;
	public abstract void delBdEdEducate(BdEducate bdEducate)throws DAOException; 
	public abstract List<BdEducate> findEducateById(String id) throws DAOException;
}
