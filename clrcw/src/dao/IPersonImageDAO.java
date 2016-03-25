package dao;

import java.util.List;

import model.PersonImage;

import common.exception.DAOException;

public interface IPersonImageDAO {
	public void savePersonImage(PersonImage personImage) throws DAOException;
	public List<PersonImage> findPersonImage(String id) throws DAOException;
	public void updatePersonImage(PersonImage personImage) throws DAOException;
	public void delPersonImage(PersonImage personImage) throws DAOException;
}
