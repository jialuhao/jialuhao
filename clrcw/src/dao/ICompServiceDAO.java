package dao;


import java.util.List;

import model.CompService;
import common.exception.DAOException;

public interface ICompServiceDAO {
	public abstract void saveCompservice(CompService compservice)throws DAOException; 
	public abstract List<?> findCompservicebyjobid(String id)throws DAOException;
}
