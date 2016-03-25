package dao;

import java.util.List;
import model.ManaUser;

import common.exception.DAOException;

public interface IManaUserDAO {

	public abstract void saveManaUser(ManaUser manaUser)throws DAOException; 
	public abstract void updateManaUser(ManaUser manaUser)throws DAOException;
	public abstract List<ManaUser> findAllManaUser() throws DAOException;
	public abstract void delManaUser(ManaUser manaUser)throws DAOException;
	public abstract List<ManaUser> backLogin(String username,String password )throws DAOException;
	public abstract List<ManaUser> backLogin(String username)throws DAOException;
}
