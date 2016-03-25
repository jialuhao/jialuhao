package dao;

import java.util.List;

import model.Servicepeople;

import common.exception.DAOException;

public interface IServicepeopleDAO {
	public abstract void saveServicepeople(Servicepeople servicepeople)throws DAOException;
	public abstract void updateServicepeople(Servicepeople servicepeople)throws DAOException;
	public abstract List<Servicepeople> findAllServicepeople() throws DAOException;
	public abstract void delServicepeople(Servicepeople servicepeople)throws DAOException;
	public abstract List<Servicepeople> findServicepeopleById(String id)throws DAOException;

}
