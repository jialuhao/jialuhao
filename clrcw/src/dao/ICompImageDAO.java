package dao;

import java.util.List;

import model.CompImage;

import common.exception.DAOException;

public interface ICompImageDAO {
	public void saveCompImage(CompImage personImage) throws DAOException;
	public List<CompImage> findCompImage(String id) throws DAOException;
	public void updateCompImage(CompImage personImage) throws DAOException;
	public void delCompImage(CompImage personImage) throws DAOException;
}
