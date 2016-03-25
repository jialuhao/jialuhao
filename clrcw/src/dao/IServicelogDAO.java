package dao;

import java.util.List;

import model.Servicelog;

import common.exception.DAOException;

public interface IServicelogDAO {
	public abstract void saveServicelog(Servicelog servicelog)throws DAOException;
	public abstract void updateServicelog(Servicelog servicelog)throws DAOException;
	public abstract List<Servicelog> findAllServicelog() throws DAOException;
	public abstract void delServicelog(Servicelog servicelog)throws DAOException;
	public abstract List<Servicelog> findServicelogById(String id)throws DAOException;
	public abstract List<Servicelog> queryServicelogById(String id)throws DAOException;
}
