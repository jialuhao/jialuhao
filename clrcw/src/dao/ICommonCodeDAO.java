package dao;

import java.util.List;

import model.Commoncode;

import common.exception.DAOException;
public interface ICommonCodeDAO {
	public abstract void saveCommonCode(Commoncode commoncode)throws DAOException;
	public abstract void updateCommonCode(Commoncode commoncode)throws DAOException;
	public abstract List<Commoncode> findAllCommonCode() throws DAOException;
	public abstract void delCommonCode(Commoncode commoncode)throws DAOException;
	public abstract List<Commoncode> findCommonCodeById(String id)throws DAOException;

}
