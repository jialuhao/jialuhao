package dao;

import java.util.List;

import model.BdPost;

import common.exception.DAOException;

public interface IBdPostDAO {

	public abstract void saveBdPost(BdPost bdPost)throws DAOException; 
	public abstract void updateBdPost(BdPost bdPost)throws DAOException; 
	public abstract List<BdPost> findAllPost() throws DAOException;
	public abstract void delBdPost(BdPost bdPost)throws DAOException; 
	public abstract List<?> findPostByRoot(String id)throws DAOException; 
	public abstract List<BdPost> findPostById(String id)throws DAOException; 
}
