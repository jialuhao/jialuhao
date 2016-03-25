package dao;

import java.util.List;

import model.Areacode;

import common.exception.DAOException;

public interface IAreaCodeDAO {
	public abstract void saveAreaCode(Areacode areacode)throws DAOException;
	public abstract void updateAreaCode(Areacode areacode)throws DAOException;
	public abstract List<Areacode> findAllAreaCode() throws DAOException;
	public abstract void delAreaCode(Areacode areacode)throws DAOException;
	public abstract List<Areacode> findAreaCodeById(String id)throws DAOException;
	public abstract List<Areacode> findAreaCodeByarea(String code)throws DAOException;
	public abstract List<Areacode> findAreaCodeByname(String name)throws DAOException;
}
