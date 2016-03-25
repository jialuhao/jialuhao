package dao;

import java.util.List;
import model.BdCompkind;

import common.exception.DAOException;

public interface IBdCompKindDAO {

	public abstract void saveBdCompkind(BdCompkind bdCompkind)throws DAOException; 
	public abstract void updateBdCompkind(BdCompkind bdCompkind)throws DAOException; 
	public abstract List<BdCompkind> findAllCompkind() throws DAOException;
	public abstract void delCompkind(BdCompkind bdCompkind)throws DAOException; 
	public abstract List<BdCompkind> findCompkindById(String id)throws DAOException;
}
