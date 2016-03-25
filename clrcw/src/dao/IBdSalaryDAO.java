package dao;

import java.util.List;

import model.BdSalary;


import common.exception.DAOException;

public interface IBdSalaryDAO {
	public abstract void saveSalary(BdSalary areacode)throws DAOException;
	public abstract void updateSalary(BdSalary areacode)throws DAOException;
	public abstract List<BdSalary> findAllSalary() throws DAOException;
	public abstract void delSalary(BdSalary areacode)throws DAOException;
	public abstract List<BdSalary> findSalaryById(String id)throws DAOException;

}
