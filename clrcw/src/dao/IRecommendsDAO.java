package dao;
import java.util.List;

import model.Recommends;
import common.exception.DAOException;

public interface IRecommendsDAO {
	public abstract void saveRecommends(Recommends recommends) throws DAOException;
	public abstract void delRecommends(Recommends recommends) throws DAOException;
	public abstract List<?> findRecommendsbyservice(String id)throws DAOException;
	public abstract List<?> findRecommendsbycardnumber(String cardnumber)throws DAOException;
}
