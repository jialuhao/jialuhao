package dao;

import java.util.List;
import model.CompBespeak;
import common.exception.DAOException;

public interface ICompBespeakDAO {
	public abstract void saveCompBespeak(CompBespeak compBespeak) throws DAOException;
	public abstract List<CompBespeak> findAllCompBespeak() throws DAOException;
	public abstract void updateCompBespeak(CompBespeak compBespeak) throws DAOException;
	public abstract void delCompBespeak(CompBespeak compBespeak) throws DAOException;
	public List<CompBespeak> getCompUser(String v_userid) throws DAOException;
	public abstract List<CompBespeak> findAllCompEnroll() throws DAOException;
	public abstract List<CompBespeak> findCompBespeakById(String id) throws DAOException;
	public abstract List<CompBespeak> queryCompUserBycompnum(String comnum) throws DAOException;
}
