package dao;

import java.util.List;

import model.BdJob;

import common.exception.DAOException;

public interface IBdJobDAO {

	public abstract void saveBdJob(BdJob bdJob)throws DAOException; 
	public abstract void updateBdJob(BdJob bdJob)throws DAOException; 
	public abstract List<BdJob> findAllJob() throws DAOException;
	public abstract void delBdJob(BdJob bdJob)throws DAOException; 
	public abstract List<BdJob> findJobById(String id) throws DAOException;
}
