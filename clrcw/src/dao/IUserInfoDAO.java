package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import util.PaginationSupport;

import model.UserInfo;

import common.exception.DAOException;

/**
 *<p>Title: 个人用户登录DAO接口</p>
 *
 *<p>Description: </p>
 *
 *
 *
 * @version 1.0
 */
public interface IUserInfoDAO {
	public List<UserInfo> findAllUser() throws DAOException;
	public void save(UserInfo userInfo) throws DAOException;
	public List<UserInfo> getUser(String v_name) throws DAOException;
	public List<UserInfo> getUser(String v_name,String v_password) throws DAOException;
	public void updateUserInfo(UserInfo userInfo)throws DAOException;
	public void delUserInfo(UserInfo userInfo)throws DAOException;
	public abstract PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
            int startIndex, int pageSize, Order order)throws DAOException;
	public List<UserInfo> findUserById(String id)throws DAOException;
}
