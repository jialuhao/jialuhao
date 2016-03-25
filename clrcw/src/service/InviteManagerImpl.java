package service;

import java.util.Calendar;
import java.util.List;

import model.ApplyJobInfo;
import model.Areacode;
import model.BdCompkind;
import model.BdEducate;
import model.BdJob;
import model.BdPost;
import model.BdPostRoot;
import model.BdSalary;
import model.BdTrade;
import model.Commoncode;
import model.CompBespeak;
import model.CompImage;
import model.CompInfo;
import model.CompResume;
import model.CompService;
import model.ManaUser;
import model.PersonEducation;
import model.PersonImage;
import model.PersonMailInfo;
import model.PersonResume;
import model.PersonResumeB;
import model.PublishJobInfo;
import model.Recommends;
import model.Servicelog;
import model.Servicepeople;
import model.UserInfo;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.DateUtil;
import util.JobShearchObject;
import util.PaginationSupport;

import common.constants.IConstants;
import common.exception.BusinessException;
import common.exception.DAOException;

import dao.IApplyJobInfoDAO;
import dao.IAreaCodeDAO;
import dao.IBdCompKindDAO;
import dao.IBdEducateDAO;
import dao.IBdJobDAO;
import dao.IBdPostDAO;
import dao.IBdPostRootDAO;
import dao.IBdSalaryDAO;
import dao.IBdTradeDAO;
import dao.ICommonCodeDAO;
import dao.ICompBespeakDAO;
import dao.ICompImageDAO;
import dao.ICompInfoDAO;
import dao.ICompResumeDAO;
import dao.ICompServiceDAO;
import dao.IManaUserDAO;
import dao.IPersonEducationDAO;
import dao.IPersonImageDAO;
import dao.IPersonMailInfoDAO;
import dao.IPersonResumeBDAO;
import dao.IPersonResumeDAO;
import dao.IPublishJobDAO;
import dao.IRecommendsDAO;
import dao.IServicelogDAO;
import dao.IServicepeopleDAO;
import dao.IUserInfoDAO;

/**
 *<p>
 * Title: 人才招聘管理系统后台入口实现类
 * </p>
 * 
 *<p>
 * Description: Facade模式实现类,该类是web层与后台交互的唯一联系
 * </p>
 * 
 *<p>
 * Company: 航天四创
 * </p>
 * 
 * @author 李滨
 * 
 * @version 1.0
 */
public class InviteManagerImpl implements InviteManager {

	private IUserInfoDAO userInfoDao;
	private ICompInfoDAO compInfoDao;
	private ICompResumeDAO compResumeDao;
	private IPublishJobDAO publishJobDao;
	private IPersonResumeDAO personResumeDao;
	private IPersonResumeBDAO personResumeBDao;
	private IApplyJobInfoDAO applyJobInfoDao;
	private IBdJobDAO bdJobDao;
	private IBdPostDAO bdPostDao;
	private IBdTradeDAO bdTradeDao;
	private IBdCompKindDAO bdCompKindDao;
	private IBdEducateDAO bdEducateDao;
	private IBdSalaryDAO bdSalaryDao;

	private IManaUserDAO manaUserDao;
	private ICompBespeakDAO compBespeakDao;
	private IPersonMailInfoDAO personMailInfoDao;
	private IBdPostRootDAO bdPostRootDao;
	private IPersonImageDAO personImageDao;
	private ICompImageDAO compImageDao;


	private IPersonEducationDAO personEducationDAO;

	//commoncode
	private ICommonCodeDAO commonCodeDao;
	//areacode
	private IAreaCodeDAO areaCodeDao;
	
	private IServicelogDAO servicelogDao;
	private IServicepeopleDAO servicepeopleDao;
	private ICompServiceDAO compserviceDao;
	private IRecommendsDAO recommendsssDao;
	public IRecommendsDAO getRecommendsssDao() {
		return recommendsssDao;
	}

	public void setRecommendsssDao(IRecommendsDAO recommendsssDao) {
		this.recommendsssDao = recommendsssDao;
	}
	public ICompServiceDAO getCompserviceDao() {
		return compserviceDao;
	}

	public void setCompserviceDao(ICompServiceDAO compserviceDao) {
		this.compserviceDao = compserviceDao;
	}

	public IServicepeopleDAO getServicepeopleDao() {
		return servicepeopleDao;
	}

	public void setServicepeopleDao(IServicepeopleDAO servicepeopleDao) {
		this.servicepeopleDao = servicepeopleDao;
	}

	public IServicelogDAO getServicelogDao() {
		return servicelogDao;
	}

	public void setServicelogDao(IServicelogDAO servicelogDao) {
		this.servicelogDao = servicelogDao;
	}

	public IAreaCodeDAO getAreaCodeDao() {
		return areaCodeDao;
	}

	public void setAreaCodeDao(IAreaCodeDAO areaCodeDao) {
		this.areaCodeDao = areaCodeDao;
	}

	public ICommonCodeDAO getCommonCodeDao() {
		return commonCodeDao;
	}

	public void setCommonCodeDao(ICommonCodeDAO commonCodeDao) {
		this.commonCodeDao = commonCodeDao;
	}
	
	private static Logger logger = Logger.getLogger(InviteManagerImpl.class);

	public IBdJobDAO getBdJobDao() {
		return bdJobDao;
	}

	public void setBdJobDao(IBdJobDAO bdJobDao) {
		this.bdJobDao = bdJobDao;
	}

	public IBdPostDAO getBdPostDao() {
		return bdPostDao;
	}

	public void setBdPostDao(IBdPostDAO bdPostDao) {
		this.bdPostDao = bdPostDao;
	}

	/**
	 * @return the bdPostRootDao
	 */
	public IBdPostRootDAO getBdPostRootDao() {
		return bdPostRootDao;
	}

	/**
	 * * 描述：依赖注入必须的seter
	 * 
	 * @param bdPostRootDao
	 *            the bdPostRootDao to set
	 */
	public void setBdPostRootDao(IBdPostRootDAO bdPostRootDao) {
		this.bdPostRootDao = bdPostRootDao;
	}

	public IBdTradeDAO getBdTradeDao() {
		return bdTradeDao;
	}

	public void setBdTradeDao(IBdTradeDAO bdTradeDao) {
		this.bdTradeDao = bdTradeDao;
	}

	public IBdCompKindDAO getBdCompKindDao() {
		return bdCompKindDao;
	}

	public void setBdCompKindDao(IBdCompKindDAO bdCompKindDao) {
		this.bdCompKindDao = bdCompKindDao;
	}

	public IBdEducateDAO getBdEducateDao() {
		return bdEducateDao;
	}

	public void setBdEducateDao(IBdEducateDAO bdEducateDao) {
		this.bdEducateDao = bdEducateDao;
	}

	/**
	 * 
	 * @return the userInfoDao
	 */
	public IUserInfoDAO getUserInfoDao() {
		return userInfoDao;
	}

	/**
	 * 描述：依赖注入必须的seter
	 * 
	 * @param userInfoDao
	 *            the userInfoDao to set
	 */
	public void setUserInfoDao(IUserInfoDAO userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	/**
	 * @return the compInfoDao
	 */
	public ICompInfoDAO getCompInfoDao() {
		return compInfoDao;
	}

	/**
	 * 描述：依赖注入必须的seter
	 * 
	 * @param compInfoDao
	 *            the compInfoDao to set
	 */
	public void setCompInfoDao(ICompInfoDAO compInfoDao) {
		this.compInfoDao = compInfoDao;
	}

	/**
	 * @return the compResumeDao
	 */
	public ICompResumeDAO getCompResumeDao() {
		return compResumeDao;
	}

	/**
	 * 描述：依赖注入必须的seter
	 * 
	 * @param compResumeDao
	 *            the compResumeDao to set
	 */
	public void setCompResumeDao(ICompResumeDAO compResumeDao) {
		this.compResumeDao = compResumeDao;
	}

	/**
	 * @return the publishJobDao
	 */
	public IPublishJobDAO getPublishJobDao() {
		return publishJobDao;
	}

	/**
	 * 描述：依赖注入必须的seter
	 * 
	 * @param publishJobDao
	 *            the publishJobDao to set
	 */
	public void setPublishJobDao(IPublishJobDAO publishJobDao) {
		this.publishJobDao = publishJobDao;
	}

	/**
	 * @return the personResumeDao
	 */
	public IPersonResumeDAO getPersonResumeDao() {
		return personResumeDao;
	}

	/**
	 * 描述：依赖注入必须的seter
	 * 
	 * @param personResumeDao
	 *            the personResumeDao to set
	 */
	public void setPersonResumeDao(IPersonResumeDAO personResumeDao) {
		this.personResumeDao = personResumeDao;
	}

	/**
	 * @return the personResumeBDao
	 */
	public IPersonResumeBDAO getPersonResumeBDao() {
		return personResumeBDao;
	}

	/**
	 * @param personResumeBDao
	 *            the personResumeBDao to set
	 */
	public void setPersonResumeBDao(IPersonResumeBDAO personResumeBDao) {
		this.personResumeBDao = personResumeBDao;
	}

	/**
	 * @return the manaUserDao
	 */
	public IManaUserDAO getManaUserDao() {
		return manaUserDao;
	}

	/**
	 * @param manaUserDao
	 *            the manaUserDao to set
	 */
	public void setManaUserDao(IManaUserDAO manaUserDao) {
		this.manaUserDao = manaUserDao;
	}

	/**
	 * @return the compBespeakDao
	 */
	public ICompBespeakDAO getCompBespeakDao() {
		return compBespeakDao;
	}

	/**
	 * @param compBespeakDao
	 *            the compBespeakDao to set
	 */
	public void setCompBespeakDao(ICompBespeakDAO compBespeakDao) {
		this.compBespeakDao = compBespeakDao;
	}

	public IPersonMailInfoDAO getPersonMailInfoDao() {
		return personMailInfoDao;
	}

	public void setPersonMailInfoDao(IPersonMailInfoDAO personMailInfoDao) {
		this.personMailInfoDao = personMailInfoDao;
	}

	/**
	 * @return the personImageDao
	 */
	public IPersonImageDAO getPersonImageDao() {
		return personImageDao;
	}

	/**
	 * * 描述：依赖注入必须的seter
	 * 
	 * @param personImageDao
	 *            the personImageDao to set
	 */
	public void setPersonImageDao(IPersonImageDAO personImageDao) {
		this.personImageDao = personImageDao;
	}

	
	
	public IPersonEducationDAO getPersonEducationDAO() {
		return personEducationDAO;
	}

	public void setPersonEducationDAO(IPersonEducationDAO personEducationDAO) {
		this.personEducationDAO = personEducationDAO;
	}

	
	/**
	 * 描述：依赖注入必须的seter
	 * 
	 * @param compResumeDao
	 *            the compResumeDao to set
	 */
	public IBdSalaryDAO getBdSalaryDao() {
		return bdSalaryDao;
	}

	/**
	 * @return the publishJobDao
	 */
	
	

	public void setBdSalaryDao(IBdSalaryDAO bdSalaryDao) {
		this.bdSalaryDao = bdSalaryDao;
	}

	/**
	 * 描述：根据企业id查询企业基本信息
	 * `
	 * @param id
	 *            企业id
	 * @return
	 * @throws
	 */
	public CompInfo findCompInfoById(String id) throws BusinessException {

		try {

			CompInfo compInfo = compInfoDao.findCompById(id);
			return compInfo;

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据个人id查询个人基本信息
	 */
	public List<?> findPersonResumeById(String id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<?> list = personResumeDao.findResumeById(id);
			return list;

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}
	
	/**
	 * 描述：保存企业信息
	 * 
	 * @param compbespeak
	 * @throws BusinessException
	 */
	public void saveCompBespeak(CompBespeak compBespeak)
			throws BusinessException {
		try {
			compBespeak.setCompStatus(IConstants.BESPEAK_SIGN);
			compBespeakDao.saveCompBespeak(compBespeak);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：查询所有待审核状态的企业(不包括已经待审核审核通过的企业)
	 * 
	 */
	public List<CompBespeak> findAllCompBespeak() throws BusinessException {
		// TODO Auto-generated method stub
		List<CompBespeak> list = null;
		try {
			list = compBespeakDao.findAllCompBespeak();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 
	 * 描述：查询所有通过审核的企业
	 * 
	 */
	public List<CompBespeak> findAllCompEnroll() throws BusinessException {
		// TODO Auto-generated method stub
		List<CompBespeak> list = null;
		try {
			list = compBespeakDao.findAllCompEnroll();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 
	 * 描述：查询所有的企业信息
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CompInfo> findAllCompInfo() throws BusinessException {
		// TODO Auto-generated method stub
		List<CompInfo> list = null;
		try {
			list = compInfoDao.findAllComp();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 
	 * 描述：查询所有的企业招聘信息
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<?> findAllCompResume(String comp_login_id)
			throws BusinessException {
		// TODO Auto-generated method stub

		try {
			return compResumeDao.findAllResume(comp_login_id);

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：查询所有的个人简历信息
	 * 
	 * @param comp_login_id
	 *            企业登录id
	 * @return
	 * @throws BusinessException
	 */
	public List<PersonResume> findAllPersonResume() throws BusinessException {
		// TODO Auto-generated method stub
		List<PersonResume> list = null;
		try {
			list = personResumeDao.findAllResume();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 
	 * 描述：查询所有的个人信息
	 * 
	 * @param
	 * @return
	 * @throws BusinessException
	 */
	public List<UserInfo> findAllUserInfo() throws BusinessException {
		// TODO Auto-generated method stub
		List<UserInfo> list = null;
		try {
			list = userInfoDao.findAllUser();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 
	 * 描述：检索所有企业发布职位信息
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<PublishJobInfo> findAllPublishJobInfo()
			throws BusinessException {
		// TODO Auto-generated method stub
		List<PublishJobInfo> list = null;
		try {
			list = publishJobDao.findAllJob();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 描述：保存个人申请职位历史信息
	 * 
	 * @param applyJobInfo
	 * @throws BusinessException
	 */
	public void saveApplyJob(ApplyJobInfo applyJobInfo)
			throws BusinessException {
		try {

			applyJobInfoDao.save(applyJobInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 
	 * 描述：保存企业基本信息
	 * 
	 * @param compInfo
	 * @exception BusinessException
	 *                自定义异常
	 */
	public void saveCompInfo(CompInfo compInfo) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			// compInfo.setCompStatus(IConstants.BESPEAK_SIGN);
			compInfoDao.saveCompInfo(compInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：个人求职信息保存到企业简历库
	 * 
	 * @param compResume
	 * @exception BusinessException
	 *                自定义异常
	 */
	/*
	 * public void saveCompResume(CompResume compResume) throws
	 * BusinessException { // TODO Auto-generated method stub try{
	 * compResumeDao.saveToCompResume(compResume); }catch(DAOException de){
	 * logger.error(de.getMessage(), de); throw new
	 * BusinessException(de.getMessage(),de); }
	 * 
	 * }
	 */
	/**
	 * 
	 * 描述：保存企业发布职位信息
	 * 
	 * @param publishJobInfo
	 * @exception BusinessException
	 *                自定义异常
	 */
	public void savePublishJobInfo(PublishJobInfo publishJobInfo)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {

			publishJobDao.savePublishJobInfo(publishJobInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	public void saveJobInfo(PublishJobInfo publishJobInfo)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {

			publishJobDao.saveJobInfo(publishJobInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 
	 * 描述：保存个人用户住册信息
	 * 
	 * @param userinfo
	 * @exception BusinessException
	 *                自定义异常
	 */
	public void saveUserinfo(UserInfo userinfo) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			userInfoDao.save(userinfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 
	 * 描述：保存个人简历档案
	 * 
	 * @param personResume
	 * @exception BusinessException
	 *                自定义异常
	 */
	public void savePersonResume(PersonResume personResume)
			throws BusinessException {
		try {
			personResumeDao.savePersonResume(personResume);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 描述：个人用户登录后台校验
	 * 
	 * @param loginName
	 *            登陆名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> findUserByName(String loginName, String password)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<UserInfo> list = userInfoDao.getUser(loginName, password);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：把待审核企业状态设置为已经注册
	 * 
	 */
	public void updateCompBespeak(CompBespeak compBespeak)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			compBespeakDao.updateCompBespeak(compBespeak);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：把已经注册企业状态设置为禁用
	 * 
	 */
	public void updateCompRegister(CompBespeak compBespeak)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			compBespeak.setCompStatus(IConstants.BESPEAK_SIGN);
			compBespeakDao.updateCompBespeak(compBespeak);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：更新企业基本信息
	 * 
	 * @param compInfo
	 * @throws BusinessException
	 */
	public void updateCompInfo(CompInfo compInfo) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			compInfoDao.updateCompInfo(compInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：更新企业简历
	 * 
	 * @param compResume
	 * @throws BusinessException
	 */
	public void updateCompResume(CompResume compResume)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			compResumeDao.updateCompResume(compResume);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：更新个人简历
	 * 
	 * @param personResume
	 * @throws BusinessException
	 */
	public void updatePersonResume(PersonResume personResume)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			personResumeDao.updatePersonResume(personResume);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：更新企业发布职位信息
	 * 
	 * @param publishJobInfo
	 * @throws BusinessException
	 */
	public void updatePublishJobInfo(PublishJobInfo publishJobInfo)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			publishJobDao.updatePublicJobInfo(publishJobInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：更新个人用户信息
	 * 
	 * @param userInfo
	 * @throws BusinessException
	 */
	public void updateUserinfo(UserInfo userInfo) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			userInfoDao.updateUserInfo(userInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 
	 * 描述：删除企业待审核信息
	 * 
	 * @param compLoginInfo
	 * @throws BusinessException
	 */
	public void delCompBespeak(CompBespeak compBespeak)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			compBespeakDao.delCompBespeak(compBespeak);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：删除企业基本信息
	 * 
	 * @param compInfo
	 * @throws BusinessException
	 */
	public void delCompInfo(CompInfo compInfo) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			compInfoDao.delCompInfo(compInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：删除企业简历
	 * 
	 * @param compResume
	 * @throws BusinessException
	 */
	public void delCompResume(CompResume compResume) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			compResumeDao.delCompResume(compResume);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：删除个人简历
	 * 
	 * @param personResume
	 * @throws BusinessException
	 */
	public void delPersonResume(PersonResume personResume)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			personResumeDao.delPersonResume(personResume);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：删除企业发布职位信息
	 * 
	 * @param publishJobInfo
	 * @throws BusinessException
	 */
	public void delPublishJobInfo(PublishJobInfo publishJobInfo)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			publishJobDao.delPublishJobInfo(publishJobInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：删除个人用户
	 * 
	 * @param userInfo
	 * @throws BusinessException
	 */
	public void delUserinfo(UserInfo userInfo) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			userInfoDao.delUserInfo(userInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：
	 * 
	 * @param personResumeB
	 * @throws BusinessException
	 */
	public void delPersonResumeB(PersonResumeB personResumeB)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			personResumeBDao.delPersonResume(personResumeB);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：根据个人登录id检索个人简历信息
	 * 
	 * @param id
	 *            个人登录id
	 * @return
	 * @throws BusinessException
	 */
	public List<PersonResumeB> findPersonResumesById(String loginId)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<PersonResumeB> list = personResumeBDao
					.findResumesById(loginId);
			return list;

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：
	 * 
	 * @param personResumeB
	 * @throws BusinessException
	 */
	public void savePersonResumeB(PersonResumeB personResumeB)
			throws BusinessException {

		try {
			personResumeBDao.savePersonResume(personResumeB);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：
	 * 
	 * @param personResumeB
	 * @throws BusinessException
	 */
	public void updatePersonResumeB(PersonResumeB personResumeB)
			throws BusinessException {

		try {
			personResumeBDao.updatePersonResume(personResumeB);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：依赖注入必须的seter
	 * 
	 * @param the
	 *            applyJobInfoDao to set
	 */

	public void setApplyJobInfoDao(IApplyJobInfoDAO applyJobInfoDao) {
		this.applyJobInfoDao = applyJobInfoDao;
	}

	/**
	 * 
	 * 描述：
	 * 
	 * @return
	 */
	public IApplyJobInfoDAO getApplyJobInfoDao() {
		return applyJobInfoDao;
	}

	/**
	 * 
	 * 描述：返回所有用户申请记录的方法的实现
	 * 
	 * @return
	 */
	public List<?> findAllApplyJobInfo() throws BusinessException {
		List<?> list = null;
		try {
			list = applyJobInfoDao.findAll();
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 
	 * 描述：在企业简历库中显示详细信息
	 * 
	 * @param v_personId
	 *            用户id
	 * @param v_resumeId
	 *            简历id
	 * @return 结果集
	 * @throws 自定义异常
	 */
	public List<?> showResumeInComp(String v_personId, String v_resumeId)
			throws BusinessException {
		List<?> list = null;
		try {
			list = applyJobInfoDao.findApplyJobByCont(v_personId, v_resumeId);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}
	/**
	 * 
	 * 描述：分页策略,客户端调用,个人职位信息查询
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示行数 如果为0,则取默认值
	 * @param desc
	 *            是否降序
	 * @return 返回查询结果集
	 */
	public PaginationSupport paginationS(String value, int pageIndex,
			int pageSize, boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		String sValue = StringUtils.trimToNull(value);

		DetachedCriteria dc = DetachedCriteria
				.forClass(ApplyJobInfo.class, "a");
		dc.createAlias("JobCode", "j").createAlias("ResumeCode", "r")
				.createAlias("r.Educate", "e").createAlias("PostCode", "p");
		dc.add(Restrictions.eq("r.state", "2"));
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (sValue != null)
			// dc.add(Property.forName("j.JobName").like(value));
			dc.add(Restrictions.like("j.JobName", sValue, MatchMode.ANYWHERE));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.createTime");
		else
			order = Order.asc("a.createTime");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = applyJobInfoDao.findPageByCriteria(dc,
				startIndex, pageSizes, order);
		// List<?> list = ps.getItems();
		// Object objects =(Object) list.get(0);
		return ps;
	}
	/**
	 * 
	 * 描述：分页策略,客户端调用,个人职位信息查询
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示行数 如果为0,则取默认值
	 * @param desc
	 *            是否降序
	 * @return 返回查询结果集
	 */
	public PaginationSupport paginationStrategy(ApplyJobInfo applyJobInfo, int pageIndex,
			int pageSize, boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		String JobName = StringUtils.trimToNull(applyJobInfo.getJobCode().getJobName());
		String workstate = StringUtils.trimToNull(applyJobInfo.getJobCode().getDr());
		String area = StringUtils.trimToNull(applyJobInfo.getPersonCode().getArea());
		String workarea = StringUtils.trimToNull(applyJobInfo.getWorkYear());
		DetachedCriteria dc = DetachedCriteria
				.forClass(ApplyJobInfo.class, "a");
		dc.createAlias("JobCode", "j").createAlias("ResumeCode", "r")
				.createAlias("r.Educate", "e").createAlias("PostCode", "p").createAlias("PersonCode", "userinfo");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		//dc.add(Restrictions.eq("a.Datatime", "1"));jialuhao
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (JobName != null)
			// dc.add(Property.forName("j.JobName").like(value));
			dc.add(Restrictions.like("j.JobName", JobName, MatchMode.ANYWHERE));
		if (workstate != null)
			// dc.add(Property.forName("j.JobName").like(value));
			dc.add(Restrictions.like("r.workstate", workstate, MatchMode.ANYWHERE));
		if (area != null&&area!=""){
			// dc.add(Property.forName("j.JobName").like(value));
			if(area.equals("2")){
			dc.add(Restrictions.like("r.Homeplace", "外埠", MatchMode.ANYWHERE));}else{
				dc.add(Restrictions.ne("r.Homeplace", "外埠"));
			}
		}
		if (workarea != null)
			// dc.add(Property.forName("j.JobName").like(value));
			dc.add(Restrictions.like("a.WorkYear", workarea, MatchMode.ANYWHERE));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.createTime");
		else
			order = Order.asc("a.createTime");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = applyJobInfoDao.findPageByCriteria(dc,
				startIndex, pageSizes, order);
		// List<?> list = ps.getItems();
		// Object objects =(Object) list.get(0);
		return ps;
	}

	public int getAllUser() {
		List list = userInfoDao.findAllUser();
		return list.size();
	}
	                       
	public PaginationSupport paginationshowAllCompany(String aglientcode,String name,String areacode,
			int pageIndex, int pageSize, boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		DetachedCriteria dc = DetachedCriteria.forClass(CompBespeak.class, "a");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		String[] cc={"1","2"};
		dc.add(Restrictions.in("a.CompStatus",cc ));
		
		if (name != null && !name.equals("")) {
			dc.add(Restrictions.like("a.CompName", "%" + name + "%"));
		}
		if (areacode != null && !areacode.equals("")&& !areacode.equals("110100")) {
			dc.add(Restrictions.eq("a.comparea", areacode));	
		}
		
		if (aglientcode != null && !aglientcode.equals("")) {
			dc.add(Restrictions.eq("a.aglientcode",aglientcode));
		}else{
			dc.add(Restrictions.isNull("a.aglientcode"));
		}
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.desc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = userInfoDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// ps.getTotalCount();
		// Object objects =(Object) list.get(0);
		return ps;
	}
	
public PaginationSupport paginationlcompanymessage(JobShearchObject object, int pageIndex,int pageSize) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		DetachedCriteria dc = DetachedCriteria.forClass(CompBespeak.class, "a");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		
		if (object.getQname() != null && !object.getQname() .equals("")) {
			dc.add(Restrictions.like("a.CompName", "%" + object.getQname()  + "%"));
		}
		if (object.getComparea()!= null && !object.getComparea().equals("")&& !object.getComparea().equals("110100")) {
			dc.add(Restrictions.eq("a.comparea", object.getComparea()));	
		}
		if (object.getWorkyear()!= null && !object.getWorkyear().equals("")&& !object.getWorkyear().equals("110100")) {
			dc.add(Restrictions.eq("a.comparea", object.getWorkyear()));	
		}
		
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		
			order = Order.desc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = userInfoDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// ps.getTotalCount();
		// Object objects =(Object) list.get(0);
		return ps;
	}
	public PaginationSupport paginationshowAllBespeak(String name,String areacode,
			int pageIndex, int pageSize, boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		DetachedCriteria dc = DetachedCriteria.forClass(CompBespeak.class, "a");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		dc.add(Restrictions.eq("a.CompStatus", IConstants.BESPEAK_SIGN));
		dc.add(Restrictions.isNull("a.aglientcode"));
		if (name != null && !name.equals("")) {
			dc.add(Restrictions.like("a.CompName", "%" + name + "%"));
		}
		
			
		
		if (areacode != null && !areacode.equals("")&&!areacode.equals("110100")) {
			dc.add(Restrictions.like("a.comparea", "%" + areacode + "%"));
		}
		
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.desc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = userInfoDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// ps.getTotalCount();
		// Object objects =(Object) list.get(0);
		return ps;
	}

	/**
	 * 描述：分页策略,客户端调用,个人基本信息查询
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示行数 如果为0,则取默认值
	 * @param desc
	 * @return
	 * @throws BusinessException
	 */
	public PaginationSupport paginationUserInfo(JobShearchObject object,
			int pageIndex, int pageSize, boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		DetachedCriteria dc = DetachedCriteria.forClass(PersonResume.class, "a");
		dc.createAlias("User", "u");
		
		dc.add(Restrictions.eq("u.Dr", IConstants.DEFAULT_SIGN));
		if (object.getQname()!= null && !object.getQname().equals("")) {
			dc.add(Restrictions.like("a.Name", "%" + object.getQname() + "%"));
		}
		if (object.geteTime() != null && !object.geteTime().equals("")) {
			dc.add(Restrictions.like("u.MailAddr", "%" + object.geteTime() + "%"));
		}
		if (object.getComparea() != null && !object.getComparea().equals("")&& !object.getComparea().equals("全市")) {
			dc.add(Restrictions.eq("a.Homeplace", object.getComparea()));	
		}
		dc.add(Restrictions.isNotNull("u.MailAddr"));
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.desc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps =personResumeDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// ps.getTotalCount();
		// Object objects =(Object) list.get(0);
		return ps;
	}

	public PaginationSupport paginationSearchPublishJobInfo(
			JobShearchObject object, int pageIndex, int pageSize, boolean desc)
			throws BusinessException {
		// TODO Auto-generated method stub

		int pageSizes;
		int startIndex;
		Order order = null;
		String currentDate = DateUtil.getNowTime(true);
		DetachedCriteria dc = DetachedCriteria.forClass(PublishJobInfo.class,
				"a");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		dc.createAlias("Job", "j").createAlias("PkComp", "p").createAlias(
				"p.Type", "t").createAlias("p.Comp", "c").createAlias(
				"Education", "e").createAlias("Post", "o");
		dc.add(Restrictions.eq("c.Dr", IConstants.DEFAULT_SIGN));
		
		if("all".equals(object.getAccount())){
			
		}else{
			dc.add(Restrictions.isNull("c.aglientcode"));
		}
		if (object.getQname() != null && !object.getQname().equals("")) {
			dc.add(Restrictions.like("c.CompName", "%" + object.getQname()
					+ "%"));
		}
		if (object.getWorkyear() != null && !object.getWorkyear().equals("")) {
			dc.add(Restrictions.like("c.comparea", "%" + object.getWorkyear()
					+ "%"));
		}
		if (object.getQjobid() != null && !object.getQjobid().equals("")) {
			dc.add(Restrictions
					.eq("j.Id", Integer.parseInt(object.getQjobid())));
		}
		if (object.getEducation() != null && !object.getEducation().equals("")) {
			dc.add(Restrictions.eq("e.Id", Integer.parseInt(object
					.getEducation())));
		}
		if (object.getGrading() != null && !object.getGrading().equals("")) {
			dc.add(Restrictions.eq("a.Grading", object.getGrading()));
		}
		if (object.getPostId() != null && !object.getPostId().equals("")) {
			dc.add(Restrictions
					.eq("o.Id", Integer.parseInt(object.getPostId())));
		}
		if (object.getSex() != null && !object.getSex().equals("")) {
			dc.add(Restrictions.eq("a.EngageSex", object.getSex()));
		}
		if (object.getSta() != null && !object.getSta().equals("")) {
			dc.add(Restrictions.eq("a.Status", object.getSta()));
		}
		if (object.getsTime() != null && !object.getsTime().equals("")
				&& object.geteTime() != null && !object.geteTime().equals("")) {
			dc.add(Restrictions.ge("a.PublishTime", object.getsTime()));
			dc.add(Restrictions.le("a.CloseTime", object.geteTime()));
		} else if (object.getsTime() != null && !object.getsTime().equals("")
				&& (object.geteTime() == null || object.geteTime().equals(""))) {
			dc.add(Restrictions.ge("a.PublishTime", object.getsTime()));
		} else if ((object.getsTime() == null || object.getsTime().equals(""))
				&& object.geteTime() != null && !object.geteTime().equals("")) {
			dc.add(Restrictions.le("a.CloseTime", object.geteTime()));
		} else {
			dc.add(Restrictions.gt("a.CloseTime", currentDate));
		}
		if (object.getComparea() != null && !object.getComparea().equals("")&& !object.getComparea().equals("110100")) {
			dc.add(Restrictions.eq("c.comparea", object.getComparea()));	
		}
		// dc.add(Restrictions.gt("a.CloseTime", currentDate));
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.desc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = publishJobDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// ps.getTotalCount();
		// Object objects =(Object) list.get(0);
		return ps;

	}

	public PaginationSupport paginationPublishJobInfo(int pageIndex,
			int pageSize, boolean desc) throws BusinessException {
		// TODO Auto-generated method stub

		int pageSizes;
		int startIndex;
		Order order = null; 
		String currentDate = DateUtil.getNowTime(true);
		DetachedCriteria dc = DetachedCriteria.forClass(PublishJobInfo.class,
				"a");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		dc.createAlias("Job", "j").createAlias("PkComp", "p").createAlias(
				"p.Type", "t").createAlias("p.Comp", "c").createAlias(
				"Education", "e").createAlias("Post", "o");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		dc.add(Restrictions.gt("a.CloseTime", currentDate));
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.asc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = publishJobDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// ps.getTotalCount();
		// Object objects =(Object) list.get(0);
		return ps;

	}

	/**
	 * 描述：分页策略,客户端调用,企业职位发布信息
	 * 
	 * @param pageIndex
	 *            当前页索引
	 * @param pageSize
	 *            每页显示行数 如果为0,则取默认值
	 * @param desc
	 * @return
	 * @throws BusinessException
	 */
	public PaginationSupport paginationPublishJob(PublishJobInfo publishJobInfo, int pageIndex,
		int pageSize, boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;

		// 取系统当前时间
		String currentDate = DateUtil.getNowTime(true);
		String jobName="";
		String address=""; 
		String publishtime=""; 
		String compname="";
		
		DetachedCriteria dc = DetachedCriteria.forClass(PublishJobInfo.class,
				"a");
		// dc.add(Restrictions.eq("a.JobCode", 1));
		// dc.createAlias("Job", "j").add(Property.forName("a.id").l	ike(value));
		dc.createAlias("Job", "j").createAlias("PkComp", "p").createAlias(
				"p.Type", "t").createAlias("p.Comp", "c").createAlias(
				"Education", "e");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		dc.add(Restrictions.eq("a.Status", "2"));
		dc.add(Restrictions.eq("a.validflag", "1"));
		dc.add(Restrictions.gt("a.CloseTime", currentDate));
		if (publishJobInfo!=null){
			if(publishJobInfo.getJobAmount()!=null&&!"".equals(publishJobInfo.getJobAmount())){
				dc.add(Restrictions.like("j.JobName",publishJobInfo.getJobAmount()));
			}
			if(publishJobInfo.getAddress()!=null&&!"".equals(publishJobInfo.getAddress())){
				dc.add(Restrictions.like("a.Address", publishJobInfo.getAddress(), MatchMode.ANYWHERE));
			}
			if(publishJobInfo.getPublishTime()!=null&&!"".equals(publishJobInfo.getPublishTime())){
				dc.add(Restrictions.le("a.PublishTime", publishJobInfo.getPublishTime()));
			}
			if(publishJobInfo.getCloseTime()!=null&&!"".equals(publishJobInfo.getCloseTime())){
				dc.add(Restrictions.ge("a.PublishTime", publishJobInfo.getCloseTime()));//借用closetime传递查询变量
			}
			if(publishJobInfo.getCompLoginId()!=null&&!"".equals(publishJobInfo.getCompLoginId())){
				dc.add(Restrictions.like("c.CompName", publishJobInfo.getCompLoginId(), MatchMode.ANYWHERE));
			}
		}
	
		if (!"".equals(address))
			dc.add(Restrictions.like("a.Address", address, MatchMode.ANYWHERE));
		if (!"".equals(publishtime))
			dc.add(Restrictions.like("a.PublishTime", publishtime, MatchMode.ANYWHERE));
		if (!"".equals(compname))
			dc.add(Restrictions.like("c.CompName", compname, MatchMode.ANYWHERE));

		// dc.add(Property.forName("j.JobName").like(value));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.asc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = publishJobDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// Object objects =(Object) list.get(0);
		return ps;
	}
	/**
	 * jialuhaoadd
	 */
	
	public PaginationSupport paginationpersonresume(JobShearchObject object,int pageIndex,int pageSize, boolean desc
			) throws BusinessException {
			int pageSizes;
			int startIndex;
			Order order = null;

			// 取系统当前时间
			String currentDate = DateUtil.getNowTime(true);
			String jobName="";
			String address=""; 
			String publishtime=""; 
			String compname="";
			
			DetachedCriteria dc = DetachedCriteria.forClass(PersonResume.class,
					"a");
			// dc.add(Restrictions.eq("a.JobCode", 1));
			// dc.createAlias("Job", "j").add(Property.forName("a.id").l	ike(value));
			dc.createAlias("User", "u").createAlias("Educate","e");
			dc.add(Restrictions.eq("u.Dr", IConstants.DEFAULT_SIGN));
			
			if (object!=null){
				if(object.getQname()!=null&&!"".equals(object.getQname())){
					dc.add(Restrictions.like("a.Name","%"+object.getQname()+"%"));
				}
				if(object.getAccount()!=null&&!"".equals(object.getAccount())){
					dc.add(Restrictions.eq("a.aglientcode",object.getAccount()));
				}else{
					dc.add(Restrictions.isNull("a.aglientcode"));
				}
				if(object.getPostId()!=null&&!"".equals(object.getPostId())){
					dc.add(Restrictions.eq("a.dkind",object.getPostId()));
				}
				if(object.getEducation()!=null&&!"".equals(object.getEducation())){
					dc.add(Restrictions.eq("e.Id",Integer.parseInt(object
							.getEducation())));
				}
				if(object.getWorkyear()!=null&&!"".equals(object.getWorkyear())){
					dc.add(Restrictions.eq("a.Homeplace",object.getWorkyear()));
				}
				if(object.getSta()!=null&&!"".equals(object.getSta())){
					dc.add(Restrictions.eq("a.state",object.getSta()));
				}
				if (object.getComparea() != null && !object.getComparea().equals("")&& !object.getComparea().equals("全市")) {
					dc.add(Restrictions.eq("a.Homeplace", object.getComparea()));	
				}
			}

			// dc.add(Property.forName("j.JobName").like(value));
			if (pageSize == 0)
				pageSizes = PaginationSupport.PAGESIZE;
			else
				pageSizes = pageSize;
			if (desc)
				order = Order.desc("a.Id");
			else
				order = Order.desc("a.Id");

			startIndex = pageIndex * pageSize;
			PaginationSupport ps = personResumeDao.findPageByCriteria(dc, startIndex,
					pageSizes, order);
			// List<?> list = ps.getItems();
			// Object objects =(Object) list.get(0);
			return ps;
		}
	/**
	 * jialuhaoadd(个人用户信息定制查询)
	 * (non-Javadoc)
	 * @see service.InviteManager#paginationpersonmessage(util.JobShearchObject, int, int)
	 */
	
	public PaginationSupport paginationpersonmessage(JobShearchObject object, int pageIndex,int pageSize)
			 throws BusinessException {
			int pageSizes;
			int startIndex;
			Order order = null;

			// 取系统当前时间
			String currentDate = DateUtil.getNowTime(true);
			String jobName="";
			String address=""; 
			String publishtime=""; 
			String compname="";
			
			DetachedCriteria dc = DetachedCriteria.forClass(PersonResume.class,
					"a");
			// dc.add(Restrictions.eq("a.JobCode", 1));
			// dc.createAlias("Job", "j").add(Property.forName("a.id").l	ike(value));
			dc.createAlias("User", "u").createAlias("Educate","e");
			dc.add(Restrictions.eq("u.Dr", IConstants.DEFAULT_SIGN));
			
			if (object!=null){
				if(object.getQname()!=null&&!"".equals(object.getQname())){
					dc.add(Restrictions.like("a.Name","%"+object.getQname()+"%"));
				}
				
				if(object.getPostId()!=null&&!"".equals(object.getPostId())){
					dc.add(Restrictions.eq("a.dkind",object.getPostId()));
				}
				if(object.getEducation()!=null&&!"".equals(object.getEducation())){
					dc.add(Restrictions.eq("e.Id",Integer.parseInt(object
							.getEducation())));
				}
				if(object.getWorkyear()!=null&&!"".equals(object.getWorkyear())){
					dc.add(Restrictions.eq("a.Homeplace",object.getWorkyear()));
				}
				if(object.getSta()!=null&&!"".equals(object.getSta())){
					dc.add(Restrictions.eq("a.state",object.getSta()));
				}
				if (object.getComparea() != null && !object.getComparea().equals("")&& !object.getComparea().equals("全市")) {
					dc.add(Restrictions.eq("a.Homeplace", object.getComparea()));	
				}
			}

			// dc.add(Property.forName("j.JobName").like(value));
			if (pageSize == 0)
				pageSizes = PaginationSupport.PAGESIZE;
			else
				pageSizes = pageSize;
			
				order = Order.desc("a.Id");
			

			startIndex = pageIndex * pageSize;
			PaginationSupport ps = personResumeDao.findPageByCriteria(dc, startIndex,
					pageSizes, order);
			// List<?> list = ps.getItems();
			// Object objects =(Object) list.get(0);
			return ps;
		}
	/**
	 * 描述：删除岗位类型下拉框
	 * 
	 * @param bdJob
	 * @throws BusinessException
	 */
	public void delBdJob(BdJob bdJob) throws BusinessException {

		try {
			bdJobDao.delBdJob(bdJob);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：删除职位类型下拉框
	 * 
	 * @param bdPost
	 * @throws BusinessException
	 */
	public void delBdPost(BdPost bdPost) throws BusinessException {
		try {
			bdPostDao.delBdPost(bdPost);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 描述：检索企业类型下拉框
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<BdCompkind> findAllBdCompKind() throws BusinessException {

		List<BdCompkind> list = null;
		try {
			list = bdCompKindDao.findAllCompkind();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 描述：检索教育程度下拉框
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<BdEducate> findAllBdEducate() throws BusinessException {

		List<BdEducate> list = null;
		try {
			list = bdEducateDao.findAllEducate();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 描述：检索职位类型下拉框
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<BdJob> findAllBdJob() throws BusinessException {

		List<BdJob> list = null;
		try {
			list = bdJobDao.findAllJob();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 描述：检索岗位类型下拉框
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<BdPost> findAllBdPost() throws BusinessException {

		List<BdPost> list = null;
		try {
			list = bdPostDao.findAllPost();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 描述：检索行业类型下拉框
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<BdTrade> findAllBdTrade() throws BusinessException {

		List<BdTrade> list = null;
		try {
			list = bdTradeDao.findAllTrade();

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}

	/**
	 * 描述：保存企业类型下拉框
	 * 
	 * @param bdCompKind
	 * @throws BusinessException
	 */
	public void saveBdCompKind(BdCompkind bdCompKind) throws BusinessException {
		try {

			bdCompKindDao.saveBdCompkind(bdCompKind);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：保存教育程度下拉框
	 * 
	 * @param bdEducate
	 * @throws BusinessException
	 */
	public void saveBdEducate(BdEducate bdEducate) throws BusinessException {
		try {

			bdEducateDao.saveBdEducate(bdEducate);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：保存职位类型下拉框
	 * 
	 * @param bdJob
	 * @throws BusinessException
	 */
	public void saveBdJob(BdJob bdJob) throws BusinessException {
		try {

			bdJobDao.saveBdJob(bdJob);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：保存岗位类型下拉框
	 * 
	 * @param bdPost
	 * @throws BusinessException
	 */
	public void saveBdPost(BdPost bdPost) throws BusinessException {
		try {

			bdPostDao.saveBdPost(bdPost);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：保存行业类型下拉框
	 * 
	 * @param bdTrade
	 * @throws BusinessException
	 */
	public void saveBdTrade(BdTrade bdTrade) throws BusinessException {
		try {

			bdTradeDao.saveBdTrade(bdTrade);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：更新公司类型下拉框
	 * 
	 * @param bdCompKind
	 * @throws BusinessException
	 */
	public void updateBdCompKind(BdCompkind bdCompKind)
			throws BusinessException {
		try {

			bdCompKindDao.updateBdCompkind(bdCompKind);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 描述：更新教育程度下拉框
	 * 
	 * @param bdEducate
	 * @throws BusinessException
	 */
	public void updateBdEducate(BdEducate bdEducate) throws BusinessException {
		try {

			bdEducateDao.updateBdEducate(bdEducate);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 描述：更新职位类型下拉框
	 * 
	 * @param bdJob
	 * @throws BusinessException
	 */
	public void updateBdJob(BdJob bdJob) throws BusinessException {
		try {

			bdJobDao.updateBdJob(bdJob);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 描述：更新岗位类型下拉框
	 * 
	 * @param bdPost
	 * @throws BusinessException
	 */
	public void updateBdPost(BdPost bdPost) throws BusinessException {

		try {

			bdPostDao.updateBdPost(bdPost);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：更新行业类型下拉框
	 * 
	 * @param bdTrade
	 * @throws BusinessException
	 */
	public void updateBdTrade(BdTrade bdTrade) throws BusinessException {
		try {

			bdTradeDao.updateBdTrade(bdTrade);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：多表联查个人基本信息(不包括个人照片)
	 *                                                     
	 * @param personId
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryPersonResume(String personId) throws BusinessException {
		try {
			List<?> list = personResumeDao.queryAssociate(personId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	
	/**
	 * 描述：多表联查个人基本信息(包括个人照片)
	 * 
	 * @param personId
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryPersonResumes(String personId) throws BusinessException {
		try {
			List<?> list = personResumeDao.queryAssociates(personId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：查询企业用户
	 * 
	 * @param compId
	 *            企业用户id
	 * @return
	 * @throws BusinessException
	 */
	public List<CompBespeak> queryCompUserById(String compId)
			throws BusinessException {

		try {
			List<CompBespeak> list = compBespeakDao.getCompUser(compId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}                          
	/**
	 * 描述：查询企业用户根据营业执照
	 * 
	 * @param compId
	 *            
	 * @return
	 * @throws BusinessException
	 */
	public List<CompBespeak> queryCompUserBycompnum(String compnum)
			throws BusinessException {

		try {
			List<CompBespeak> list = compBespeakDao.queryCompUserBycompnum(compnum);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}   
	/**
	 * 描述：检索本企业招聘职位历史信息
	 * 
	 * @param compLoginId
	 *            企业用户登录id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryJobInfoById(String compLoginId)
			throws BusinessException {

		try {
			List<?> list = publishJobDao.findJobInfoById(compLoginId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	public List<?> queryEnableJobInfoById(String compLoginId)
			throws BusinessException {

		try {
			List<?> list = publishJobDao.findEnableJobInfoById(compLoginId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据个人用户id查询求职的历史信息
	 * 
	 * @param personId
	 *            个人用户id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryApplyJobById(String personId) throws BusinessException {

		try {
			List<?> list = applyJobInfoDao.findApplyJobByCont(personId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据个人用户id查询
	 * 
	 * @param personId
	 *            个人用户id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryApplyJobBypersonId(String personId) throws BusinessException {

		try {
			List<?> list = applyJobInfoDao.findApplyJobBypersonid(personId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}
	/**
	 * 描述：删除管理用户
	 * 
	 * @param manaUser
	 * @throws BusinessException
	 */
	public void delManaUser(ManaUser manaUser) throws BusinessException {

		try {
			manaUserDao.delManaUser(manaUser);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：删除个人投送简历信息
	 * 
	 * @param personMailInfo
	 * @throws BusinessException
	 */
	public void delPersonMailInfo(PersonMailInfo personMailInfo)
			throws BusinessException {
		try {
			personMailInfoDao.delMailInfo(personMailInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 描述：检索个人投送简历信息
	 * 
	 * @param person_loginId
	 *            个人登录id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryPersonMailInfo(String person_loginId)
			throws BusinessException {

		try {
			List<?> list = personMailInfoDao.findMailInfo(person_loginId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：保存个人投送简历信息(注意需要两步操作在同一个事务中)
	 * 
	 * @param personMailInfo
	 * @throws BusinessException
	 */
	public void savePersonMailInfo(PersonMailInfo personMailInfo,
			CompResume compResume) throws BusinessException {
		try {
			personMailInfoDao.saveMailInfo(personMailInfo);
			compResumeDao.saveToCompResume(compResume);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：检索后台登陆验证
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public List<ManaUser> findManaUserByName(String loginName, String password)
			throws BusinessException {
		try {
			return manaUserDao.backLogin(loginName, password);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据职位id检索企业发布信息
	 * 
	 * @param jobId
	 * @throws BusinessException
	 */
	public Object[] queryJobById(Integer jobId) throws BusinessException {

		Object[] obj = null;
		try {
			List<Object[]> list = null;
			list = publishJobDao.findJobById(jobId);
			if (list != null)
				obj = list.get(0);
			return obj;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：删除个人用户申请职位信息
	 * 
	 * @param applyJobInfo
	 * @throws BusinessException
	 */
	public void delAppJobInfo(ApplyJobInfo applyJobInfo)
			throws BusinessException {
		try {
			applyJobInfoDao.delete(applyJobInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param manaUser
	 * @throws BusinessException
	 */
	public void saveManaUser(ManaUser manaUser) throws BusinessException {

		try {

			manaUserDao.saveManaUser(manaUser);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param manaUser
	 * @throws BusinessException
	 */
	public void updateManaUser(ManaUser manaUser) throws BusinessException {

		try {

			manaUserDao.updateManaUser(manaUser);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<ManaUser> findAllManaUser() throws BusinessException {
		try {
			List<ManaUser> list = manaUserDao.findAllManaUser();
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param bdEducate
	 * @throws BusinessException
	 */
	public void delBdBdEducate(BdEducate bdEducate) throws BusinessException {
		try {
			bdEducateDao.delBdEdEducate(bdEducate);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param bdCompkind
	 * @throws BusinessException
	 */
	public void delBdCompkind(BdCompkind bdCompkind) throws BusinessException {
		try {
			bdCompKindDao.delCompkind(bdCompkind);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param bdTrade
	 * @throws BusinessException
	 */
	public void delBdTrade(BdTrade bdTrade) throws BusinessException {
		try {
			bdTradeDao.delBdTrade(bdTrade);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param desc
	 * @return
	 * @throws BusinessException
	 */
	public PaginationSupport paginationCompResume(String compLogin,
			String status, int pageIndex, int pageSize, boolean desc)
			throws BusinessException {

		int pageSizes;
		int startIndex;
		Order order = null;
		DetachedCriteria dc = DetachedCriteria.forClass(CompResume.class, "a");
		dc.createAlias("CompPost", "c").createAlias("c.Job", "j").createAlias(
				"PkResume", "r").createAlias("r.Educate", "e").createAlias("r.User", "u");
		if (status != null)
			dc.add(Restrictions.eq("a.Status", status));
		dc.add(Restrictions.eq("a.CompLoginId", compLogin));
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		dc.add(Restrictions.eq("u.Dr", IConstants.DEFAULT_SIGN));
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.createtime");
		else
			order = Order.asc("a.createtime");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = compResumeDao.findPageByCriteria(dc, startIndex,
				pageSizes, order);
		// List<?> list = ps.getItems();
		// Object objects =(Object) list.get(0);
		return ps;
	}

	/**
	 * 描述：根据主键id查询企业简历库
	 * 
	 * @param id
	 *            主键id
	 * @return
	 * @throws BusinessException
	 */
	public CompResume findCompResumeById(String id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			CompResume compResume = null;
			List<CompResume> list = compResumeDao.findCompResumeById(id);
			if (list != null && list.size() > 0)
				compResume = list.get(0);
			return compResume;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据归档状态分页查询
	 * 
	 * @param file
	 *            归档状态
	 * @param compLogin
	 *            企业登录id
	 * @param pageIndex
	 * @param pageSize
	 * @param desc
	 * @return
	 * @throws BusinessException
	 */
	public PaginationSupport queryCompResumeByFile(String file,
			String compLogin,PersonResume resume , int pageIndex, int pageSize, boolean desc)
			throws BusinessException {

		int pageSizes;
		int startIndex;
		Order order = null;
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(CompResume.class,
					"a");
			// dc.createAlias("CompPost", "c").createAlias("c.Job","j")
			dc.createAlias("PkResume", "r").createAlias("r.Educate", "e").createAlias("r.User", "u");
			if (file != null)
				dc.add(Restrictions.eq("a.File", file)).add(
						Restrictions.eq("a.CompLoginId", compLogin));
			dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
			if (resume != null){
				if(resume.getPhone()!=null&&!"".equals(resume.getPhone())){
					dc.add(Restrictions.ge("e.Id",Integer.parseInt(resume.getPhone())));
				}
				if(resume.getLimitYear()!=null&&!"".equals(resume.getLimitYear())){
					dc.add(Restrictions.ge("r.LimitYear",resume.getLimitYear()));
				}
				if(resume.getDkind()!=null&&!"".equals(resume.getDkind())){
					dc.add(Restrictions.eq("r.dkind",resume.getDkind()));
				}
				dc.add(Restrictions.eq("r.Dr", IConstants.DEFAULT_SIGN));
				Calendar   mycalendar=Calendar.getInstance();//获取现在时间
                String year=String.valueOf(mycalendar.get(Calendar.YEAR));//获取年份
                int birth=Integer.parseInt(year);
				if(resume.getLang2()!=null&&!"".equals(resume.getLang2())){
					dc.add(Restrictions.lt("r.Birthday",(birth-Integer.parseInt(resume.getLang2()))+"-01-01"));
					System.out.println(birth-Integer.parseInt(resume.getLang2()));
				}
				if(resume.getLevel2()!=null&&!"".equals(resume.getLevel2())){
					dc.add(Restrictions.gt("r.Birthday",(birth-Integer.parseInt(resume.getLevel2()))+"-01-01"));
				}
			}
			// dc.createAlias("ResumeCode",
			// "a").add(Property.forName("a.id").like(value));
			if (pageSize == 0)
				pageSizes = PaginationSupport.PAGESIZE;
			else
				pageSizes = pageSize;
			if (desc)
				order = Order.desc("a.Id");
			else
				order = Order.asc("a.Id");

			startIndex = pageIndex * pageSize;
			PaginationSupport ps = compResumeDao.findPageByCriteria(dc,
					startIndex, pageSizes, order);

			return ps;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		} 
	}

	/**
	 * 描述：根据主键id查询
	 * 
	 * @param Id
	 *            主键id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> findApplyJobInfoById(String Id) throws BusinessException {
		try {
			List<?> list = applyJobInfoDao.findApplyJobById(Id);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}
	/**
	 * 描述：根据主键id查询
	 * 
	 * @param Id
	 *            主键id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryApplyJobInfoById(String Id) throws BusinessException {
		try {
			List<?> list = applyJobInfoDao.queryApplyJobById(Id);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：把个人简历归入人才库
	 * 
	 * @param compResume
	 * @throws BusinessException
	 */
	public void saveCompResumeFile(CompResume compResume)
			throws BusinessException {
		try {
			compResume.setFile(IConstants.PERSON_DATABASE);
			compResumeDao.saveToCompResume(compResume);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}

	}

	/**
	 * 描述：
	 * 
	 * @param bdPostRoot
	 * @return
	 * @throws BusinessException
	 */
	public List<BdPostRoot> findAllBdPostRoot() throws BusinessException {
		try {
			List<BdPostRoot> list = bdPostRootDao.findAllPostRoot();
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据岗位大类主键id查询岗位小类
	 * 
	 * @param id
	 *            岗位大类主键id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> queryBdPostByRoot(String id) throws BusinessException {

		try {
			return bdPostDao.findPostByRoot(id);

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param bdPostRoot
	 * @throws BusinessException
	 */
	public void saveBdPostRoot(BdPostRoot bdPostRoot) throws BusinessException {

		try {
			bdPostRootDao.saveBdPostRoot(bdPostRoot);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param bdPostRoot
	 * @throws BusinessException
	 */
	public void updateBdPostRoot(BdPostRoot bdPostRoot)
			throws BusinessException {
		try {
			bdPostRootDao.updateBdPostRoot(bdPostRoot);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param loginName
	 * @return
	 * @throws BusinessException
	 */
	public List<UserInfo> findUserByName(String loginName)
			throws BusinessException {

		try {
			return userInfoDao.getUser(loginName);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param loginName
	 * @return
	 * @throws BusinessException
	 */
	public List<ManaUser> findManaUserByName(String loginName)
			throws BusinessException {
		try {
			return manaUserDao.backLogin(loginName);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public BdCompkind findCompKindById(String id) throws BusinessException {
		BdCompkind bdCompkind = null;
		try {
			List<BdCompkind> list = null;
			list = bdCompKindDao.findCompkindById(id);
			if (list != null && list.size() > 0)
				bdCompkind = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return bdCompkind;
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public BdEducate findEducateById(String id) throws BusinessException {
		BdEducate bdEducate = null;
		try {
			List<BdEducate> list = null;
			list = bdEducateDao.findEducateById(id);
			if (list != null && list.size() > 0)
				bdEducate = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return bdEducate;
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public BdJob findJobById(String id) throws BusinessException {
		BdJob bdJob = null;
		try {
			List<BdJob> list = null;
			list = bdJobDao.findJobById(id);
			if (list != null && list.size() > 0)
				bdJob = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return bdJob;
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public BdPost findPostById(String id) throws BusinessException {
		BdPost bdPost = null;
		try {
			List<BdPost> list = null;
			list = bdPostDao.findPostById(id);
			if (list != null && list.size() > 0)
				bdPost = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return bdPost;
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public BdTrade findTradeById(String id) throws BusinessException {
		BdTrade bdTrade = null;
		try {
			List<BdTrade> list = null;
			list = bdTradeDao.findTradeById(id);
			if (list != null && list.size() > 0)
				bdTrade = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return bdTrade;
	}

	/**
	 * 描述：根据主键id查询
	 * 
	 * @param id
	 *            主键id
	 * @return
	 * @throws BusinessException
	 */
	public CompInfo findCompById(String id) throws BusinessException {
		CompInfo compInfo = null;
		try {
			List<CompInfo> list = null;
			list = compInfoDao.findCompInfoById(id);
			if (list != null && list.size() > 0)
				compInfo = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return compInfo;
	}

	/**
	 * 描述：根据主键id查询
	 * 
	 * @param id
	 *            主键id
	 * @return
	 * @throws BusinessException
	 */
	public PublishJobInfo findPublishJobById(String id)
			throws BusinessException {
		PublishJobInfo publishJobInfo = null;
		try {
			List<Object[]> list = null;
			list = publishJobDao.findPublicJobById(id);
			if (list != null && list.size() > 0){
				Object[] o=(Object[])list.get(0);
				 publishJobInfo=(PublishJobInfo)o[0];	
			}
				
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return publishJobInfo;
	}

	/**
	 * 描述：根据主键id查询
	 * 
	 * @param id
	 *            主键id
	 * @return
	 * @throws BusinessException
	 */
	public UserInfo findUserById(String id) throws BusinessException {
		UserInfo userinfo = null;
		try {
			List<UserInfo> list = null;
			list = userInfoDao.findUserById(id);
			if (list != null && list.size() > 0)
				userinfo = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return userinfo;
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public BdPostRoot findPostRootById(String id) throws BusinessException {
		BdPostRoot bdPostRoot = null;
		try {
			List<BdPostRoot> list = null;
			list = bdPostRootDao.findPostRootById(id);
			if (list != null && list.size() > 0)
				bdPostRoot = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return bdPostRoot;
	}

	/**
	 * 描述：
	 * 
	 * @param id
	 *            简历id
	 * @return
	 * @throws BusinessException
	 */
	public String findFileByResumeId(String resumeId, String compLoginId)
			throws BusinessException {
		CompResume compResume = null;
		String file = IConstants.PERSON_DATABASE_NULL;
		Object[] obj = null;
		try {
			List<?> list = null;
			list = compResumeDao
					.findCompResumeByResumeId(resumeId, compLoginId);
			if (list != null && list.size() > 0) {
				obj = (Object[]) list.get(0);
				compResume = (CompResume) obj[0];
				file = compResume.isFile();
			}
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return file;
	}
	/**
	 * 描述：
	 * jialuhaoadd
	 * @param id
	 *            简历id
	 * @return
	 * @throws BusinessException
	 */
	public List<?> findFileByResumecompId(String resumeId, String CompPost)
			throws BusinessException {
		CompResume comResume = null;
		List  list=null;
		try {	
	
			list= compResumeDao.findCompResumeByResumecompId(resumeId, CompPost);
					
			
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}
	/**
	 * 描述：   
	 * 
	 * @param id
	 *            简历id
	 * @return
	 * @throws BusinessException 
	 */
	public List<?> findFileBypkResume(String resumeId) throws BusinessException {
		CompResume compResume = null;
		String file = IConstants.PERSON_DATABASE_NULL;
		Object[] obj = null;
		List<?> list = null;
		try {
			list = compResumeDao
					.findCompResumeBypkresume(resumeId);
			
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}
	//jialuhaoadd
	public List<?> findCompResumeBypersonid(String resumeId) throws BusinessException {
		CompResume compResume = null;
		String file = IConstants.PERSON_DATABASE_NULL;
		Object[] obj = null;
		List<?> list = null;
		try {
			list = compResumeDao
					.findCompResumeBypersonid(resumeId);
			
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return list;
	}
	/**
	 * 描述：
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public CompBespeak findCompBespeakById(String id) throws BusinessException {
		CompBespeak compBespeak = null;
		try {
			List<CompBespeak> list = null;
			list = compBespeakDao.findCompBespeakById(id);
			if (list != null && list.size() > 0)
				compBespeak = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return compBespeak;
	}

	/**
	 * 描述：
	 * 
	 * @param applyJobInfo
	 * @return
	 * @throws BusinessException
	 */
	public void updateApplyJobInfo(ApplyJobInfo applyJobInfo)
			throws BusinessException {
		try {
			applyJobInfoDao.update(applyJobInfo);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param personImage
	 * @throws BusinessException
	 */
	public void delPersonImage(PersonImage personImage)
			throws BusinessException {
		try {
			personImageDao.delPersonImage(personImage);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param personImage
	 * @throws BusinessException
	 */
	public void savePersonImage(PersonImage personImage)
			throws BusinessException {
		try {
			personImageDao.savePersonImage(personImage);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：
	 * 
	 * @param personImage
	 * @throws BusinessException
	 */
	public void updatePersonImage(PersonImage personImage)
			throws BusinessException {
		try {
			personImageDao.updatePersonImage(personImage);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据主键查询个人照片
	 * 
	 * @param Id
	 * @return
	 * @throws BusinessException
	 */
	public PersonImage findPersonImageById(String Id) throws BusinessException {
		PersonImage personImage = null;
		try {
			List<PersonImage> list = null;
			list = personImageDao.findPersonImage(Id);
			if (list != null && list.size() > 0)
				personImage = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return personImage;
	}

	public int findAllPublisJob() throws BusinessException {
		// TODO Auto-generated method stub

		List list = publishJobDao.findAllJob();
		return list.size();
	}

	public PaginationSupport paginationAppJob(int pageIndex, int pageSize,
			boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		// String sValue = StringUtils.trimToNull(value);

		DetachedCriteria dc = DetachedCriteria
				.forClass(ApplyJobInfo.class, "a");
		dc.createAlias("JobCode", "j").createAlias("ResumeCode", "r")
				.createAlias("r.Educate", "e").createAlias("PostCode", "p");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		/*
		 * if(sValue!=null) //dc.add(Property.forName("j.JobName").like(value));
		 * dc.add(Restrictions.like("j.JobName", sValue, MatchMode.ANYWHERE));
		 */
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.asc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = applyJobInfoDao.findPageByCriteria(dc,
				startIndex, pageSizes, order);
		// List<?> list = ps.getItems();
		// Object objects =(Object) list.get(0);
		return ps;
	}

	public PaginationSupport paginationSearchAppJob(JobShearchObject object,
			int pageIndex, int pageSize, boolean desc) throws BusinessException {
		int pageSizes;
		int startIndex;
		Order order = null;
		// String sValue = StringUtils.trimToNull(value);

		DetachedCriteria dc = DetachedCriteria
				.forClass(ApplyJobInfo.class, "a");
		dc.createAlias("JobCode", "j").createAlias("ResumeCode", "r")
				.createAlias("r.Educate", "e").createAlias("PostCode", "p");
		dc.add(Restrictions.eq("a.Dr", IConstants.DEFAULT_SIGN));
		if (object.getAccount() != null && !object.getAccount().equals("")) {
			dc.add(Restrictions.eq("a.aglientcode", object.getAccount()));
		}
		if (object.getQname() != null && !object.getQname().equals("")) {
			dc.add(Restrictions.like("r.Name", "%" + object.getQname() + "%"));
		}
		if (object.getQjobid() != null && !object.getQjobid().equals("")) {
			dc.add(Restrictions
					.eq("j.Id", Integer.parseInt(object.getQjobid())));
		}
		if (object.getEducation() != null && !object.getEducation().equals("")) {
			dc.add(Restrictions
					.eq("e.Id", Integer.parseInt(object.getEducation())));
		}
		if (object.getSalary() != null && !object.getSalary().equals("")) {
			dc.add(Restrictions
					.eq("a.Salary", object.getSalary()));
		}
		if (object.getWorkyear() != null && !object.getWorkyear().equals("")) {
			dc.add(Restrictions.like("a.WorkYear", "%" + object.getWorkyear() + "%"));
		}
		if (object.getPostId() != null && !object.getPostId().equals("")) {
			dc.add(Restrictions
					.eq("p.Id", Integer.parseInt(object.getPostId())));
		}
		if (object.getsTime() != null && !object.getsTime().equals("")
				&& object.geteTime() != null && !object.geteTime().equals("")) {
			dc.add(Restrictions.ge("a.createTime", object.getsTime()));
			dc.add(Restrictions.le("a.createTime", object.geteTime()));
		} else if (object.getsTime() != null && !object.getsTime().equals("")
				&& (object.geteTime() == null || object.geteTime().equals(""))) {
			dc.add(Restrictions.ge("a.createTime", object.getsTime()));
		} else if ((object.getsTime() == null || object.getsTime().equals(""))
				&& object.geteTime() != null && !object.geteTime().equals("")) {
			dc.add(Restrictions.le("a.createTime", object.geteTime()));
		}
//		if (object.getSta() != null && !object.getSta().equals("")) {jialuhao
//			if (object.getSta().equals("1")) {
//				dc.add(Restrictions.eq("a.Datatime", object.getSta()));
//			} else if (object.getSta().equals("0")) {
//				dc.add(Restrictions.or(Restrictions.eq("a.Datatime", object
//						.getSta()), Restrictions.isNull("a.Datatime")));
//			}
//		}
		if (object.getComparea() != null && !object.getComparea().equals("")&& !object.getComparea().equals("110100")) {
			dc.add(Restrictions.eq("r.qzdq", object.getComparea()));	
		}
		// dc.createAlias("ResumeCode",
		// "a").add(Property.forName("a.id").like(value));
		/*
		 * if(sValue!=null) //dc.add(Property.forName("j.JobName").like(value));
		 * dc.add(Restrictions.like("j.JobName", sValue, MatchMode.ANYWHERE));
		 */
		if (pageSize == 0)
			pageSizes = PaginationSupport.PAGESIZE;
		else
			pageSizes = pageSize;
		if (desc)
			order = Order.desc("a.Id");
		else
			order = Order.desc("a.Id");

		startIndex = pageIndex * pageSize;
		PaginationSupport ps = applyJobInfoDao.findPageByCriteria(dc,
				startIndex, pageSizes, order);
		// List<?> list = ps.getItems();
		// Object objects =(Object) list.get(0);
		return ps;
	}

	public ApplyJobInfo findAppJobById(String id) throws BusinessException {
		ApplyJobInfo apply = (ApplyJobInfo) applyJobInfoDao
				.findApplyJobById(id).get(0);
		return apply;

	}

	public int findAllAppJob() throws BusinessException {
		List list = applyJobInfoDao.findAll();
		return list.size();
	}


	public ICompImageDAO getCompImageDao() {
		return compImageDao;
	}

	public void setCompImageDao(ICompImageDAO compImageDao) {
		this.compImageDao = compImageDao;
	}

	/**
	 * 描述：删除图片
	 * 
	 * @param personImage
	 * @throws BusinessException
	 */
	public void delCompImage(CompImage compImage)
			throws BusinessException {
		try {
			compImageDao.delCompImage(compImage);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：保存图片
	 * 
	 * @param compImage
	 * @throws BusinessException
	 */
	public void saveCompImage(CompImage compImage)
			throws BusinessException {
		try {
			compImageDao.saveCompImage(compImage);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：修改图片
	 * 
	 * @param compImage
	 * @throws BusinessException
	 */
	public void updateCompImage(CompImage compImage)
			throws BusinessException {
		try {
			compImageDao.updateCompImage(compImage);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 描述：根据主键查询企业上传照片
	 * 
	 * @param Id
	 * @return
	 * @throws BusinessException
	 */
	public CompImage findCompImageById(String Id) throws BusinessException {
		CompImage compImage = null;
		try {
			List<CompImage> list = null;
			list = compImageDao.findCompImage(Id);
			if (list != null && list.size() > 0)
				compImage = list.get(0);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
		return compImage;
	}
	
	/**
	 * 
	 * 描述：
	 * 
	 * @param personResumeB
	 * @throws BusinessException 
	 * @throws BusinessException
	 */
	public void delPersonEducation(PersonEducation personEducation) throws BusinessException
	{
		// TODO Auto-generated method stub
		try {
			personEducationDAO.delPersonEducation(personEducation);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：根据个人登录id检索个人简历信息
	 * 
	 * @param id
	 *            个人登录id
	 * @return
	 * @throws BusinessException   
	 * @throws BusinessException
	 */
	public List<PersonEducation> findEducationsById(String loginId) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<PersonEducation> list = personEducationDAO.findEducationsById(loginId);
			
			return list;

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}
	/**
	 * 
	 * 描述：根据个人登录id检索个人简历信息
	 * 
	 * @param id
	 *            个人登录id
	 * @return
	 * @throws BusinessException   
	 * @throws BusinessException
	 */
	public List<PersonEducation>  findEducationsByEduId(String Id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<PersonEducation> list = personEducationDAO.findEducationsByEduId(Id);
			
			return list;

		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}
	/**
	 * 
	 * 描述：
	 * 
	 * @param personResumeB
	 * @throws BusinessException 
	 */
	public void savePersonEducation(PersonEducation personEducation) {

		try {
			personEducationDAO.savePersonEducation(personEducation);
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new DAOException(de.getMessage(), de);
		}
	}

	/**
	 * 
	 * 描述：
	 * 
	 * @param personResumeB
	 * @throws BusinessException
	 */
	public void updatePersonEducation(PersonEducation personEducation) {

		try {
			personEducationDAO.updatePersonEducation(personEducation);
			} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new DAOException(de.getMessage(), de);
		}
	}

	public List<PersonEducation> findAllEducation() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	//commoncode
	public void delCommonCode(Commoncode commoncode) throws BusinessException {
		
		try {
			commonCodeDao.delCommonCode(commoncode);
			} catch (DAOException de) {
				logger.error(de.getMessage(),de);
				throw new BusinessException(de.getMessage(),de);
			}
	}

	public List<Commoncode> findAllCommonCode() throws BusinessException {
		List<Commoncode> list = null;
		try {
			list = commonCodeDao.findAllCommonCode();
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
		return list;
	}

	public Commoncode findCommonCodeById(String id)
			throws BusinessException {
		Commoncode commoncode=null;
		try {
			List<Commoncode> list = null;
			list = commonCodeDao.findCommonCodeById(id);
			if(list!=null&&list.size()>0){
				commoncode = list.get(0);
			}
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
		return commoncode;
	}

	public void saveCommonCode(Commoncode commoncode) throws BusinessException {
			try {
				commonCodeDao.saveCommonCode(commoncode);
			} catch (DAOException de) {
				logger.error(de.getMessage(),de);
				throw new BusinessException(de.getMessage(),de);
			}
	}

	public void updateCommonCode(Commoncode commoncode)
			throws BusinessException {
		try {
			commonCodeDao.updateCommonCode(commoncode);
		} catch (DAOException de) {
			throw new BusinessException(de.getMessage(),de);
		}
		
	}

	public List<Commoncode> queryCommonCodeById(String CommoncodeId)
			throws BusinessException {
		try {
			List<Commoncode> list = commonCodeDao.findCommonCodeById(CommoncodeId);
			return list;
		} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
		}
	}

	public void delAreaCode(Areacode areacode) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			areaCodeDao.delAreaCode(areacode);
			} catch (DAOException de) {
				logger.error(de.getMessage(),de);
				throw new BusinessException(de.getMessage(),de);
			}
	}

	public List<Areacode> findAllAreaCode() throws BusinessException {
		// TODO Auto-generated method stub
		List<Areacode> list = null;
		try {
			list = areaCodeDao.findAllAreaCode();
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
		return list;
	}

	public Areacode findAreaCodeById(String id) throws BusinessException {
		Areacode areacode=null;
		try {
		List<Areacode> list = null;
		list = areaCodeDao.findAreaCodeById(id);
		if(list!=null&&list.size()>0){
			areacode = list.get(0);
		}
		} catch (DAOException de) {
		logger.error(de.getMessage(),de);
		throw new BusinessException(de.getMessage(),de);
		}
		return areacode;
	}
	public Areacode findAreaCodeByarea(String code) throws BusinessException {
		Areacode areacode=null;
		try {
		List<Areacode> list = null;
		list = areaCodeDao.findAreaCodeByarea(code);
		if(list!=null&&list.size()>0){
			areacode = list.get(0);
		}
		} catch (DAOException de) {
		logger.error(de.getMessage(),de);
		throw new BusinessException(de.getMessage(),de);
		}
		return areacode;
	}
	public Areacode findAreaCodeByname(String name) throws BusinessException {
		Areacode areacode=null;
		try {
		List<Areacode> list = null;
		list = areaCodeDao.findAreaCodeByname(name);
		if(list!=null&&list.size()>0){
			areacode = list.get(0);
		}
		} catch (DAOException de) {
		logger.error(de.getMessage(),de);
		throw new BusinessException(de.getMessage(),de);
		}
		return areacode;
	}

	public void saveAreaCode(Areacode areacode) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			areaCodeDao.saveAreaCode(areacode);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public void updateAreaCode(Areacode areacode) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			areaCodeDao.updateAreaCode(areacode);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public List<Areacode> queryAreaCodeById(String AreacodeId)

			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<Areacode> list = areaCodeDao.findAreaCodeById(AreacodeId);
			return list;
			} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
			}
	}
	
/////////////////////////////////////////////////////
	public void delSalary(BdSalary salary) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			bdSalaryDao.delSalary(salary);
			} catch (DAOException de) {
				logger.error(de.getMessage(),de);
				throw new BusinessException(de.getMessage(),de);
			}
	}

	public List<BdSalary> findAllSalary() throws BusinessException {
		// TODO Auto-generated method stub
		List<BdSalary> list = null;
		try {
			list = bdSalaryDao.findAllSalary();
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
		return list;
	}

	public  BdSalary findSalaryById(String id)throws BusinessException {
		BdSalary salary=null;
		try {
		List<BdSalary> list = null;
		list = bdSalaryDao.findSalaryById(id);
		if(list!=null&&list.size()>0){
			salary = list.get(0);
		}
		} catch (DAOException de) {
		logger.error(de.getMessage(),de);
		throw new BusinessException(de.getMessage(),de);
		}
		return salary;
	}

	public void saveSalary(BdSalary salary) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			bdSalaryDao.saveSalary(salary);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public void updateSalary(BdSalary salary) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			bdSalaryDao.updateSalary(salary);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public  List<BdSalary> querySalaryById(String salaryId)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<BdSalary> list = bdSalaryDao.findSalaryById(salaryId);
			return list;
			} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
			}
	}
////////////////////////////////////////////////////
	public void delServicelog(Servicelog salary) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			servicelogDao.delServicelog(salary);
			} catch (DAOException de) {
				logger.error(de.getMessage(),de);
				throw new BusinessException(de.getMessage(),de);
			}
	}

	public List<Servicelog> findAllServicelog() throws BusinessException {
		// TODO Auto-generated method stub
		List<Servicelog> list = null;
		try {
			list = servicelogDao.findAllServicelog();
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
		return list;
	}

	public  List<?> findServicelogById(String id)throws BusinessException {
		List list=null;
		try {
		
		 list = servicelogDao.findServicelogById(id);
		
		} catch (DAOException de) {
		logger.error(de.getMessage(),de);
		throw new BusinessException(de.getMessage(),de);
		}
		return list;
	}

	public void saveServicelog(Servicelog salary) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			servicelogDao.saveServicelog(salary);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public void updateServicelog(Servicelog salary) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			servicelogDao.updateServicelog(salary);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public  Servicelog queryServicelogById(String salaryId)
			throws BusinessException {
		// TODO Auto-generated method stub
		Servicelog aa=null;
		try {
			List<Servicelog> list = servicelogDao.queryServicelogById(salaryId);
			 aa=list.get(0);
			
			} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
			}
			return aa;
	}
	
///////////////////////////////////////////////////
	public void delServicepeople(Servicepeople servicepeople) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			servicepeopleDao.delServicepeople(servicepeople);
			} catch (DAOException de) {
				logger.error(de.getMessage(),de);
				throw new BusinessException(de.getMessage(),de);
			}
	}

	public List<Servicepeople> findAllServicepeople() throws BusinessException {
		// TODO Auto-generated method stub
		List<Servicepeople> list = null;
		try {
			list = servicepeopleDao.findAllServicepeople();
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
		return list;
	}

	public List<Servicepeople> findServicepeopleById(String id)throws BusinessException {
		List<Servicepeople> list =null;
		try {
		
		 list = servicepeopleDao.findServicepeopleById(id);
		
		
		} catch (DAOException de) {
		logger.error(de.getMessage(),de);
		throw new BusinessException(de.getMessage(),de);
		}
		return list;
	}

	public void saveServicepeople(Servicepeople servicepeople) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			servicepeopleDao.saveServicepeople(servicepeople);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public void updateServicepeople(Servicepeople servicepeople) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			servicepeopleDao.updateServicepeople(servicepeople);
		} catch (DAOException de) {
			logger.error(de.getMessage(),de);
			throw new BusinessException(de.getMessage(),de);
		}
	}

	public  List<Servicepeople> queryServicepeopleById(String servicepeopleId)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			List<Servicepeople> list = servicepeopleDao.findServicepeopleById(servicepeopleId);
			return list;
			} catch (DAOException de) {
			logger.error(de.getMessage(), de);
			throw new BusinessException(de.getMessage(), de);
			}
	}
	public  void saveCompservice(CompService compservice)
	throws BusinessException {
// TODO Auto-generated method stub
    try {
    	compserviceDao.saveCompservice(compservice);
    
	   } catch (DAOException de) {
	   logger.error(de.getMessage(), de);
	   throw new BusinessException(de.getMessage(), de);
	   }
}
	public  List<?>findcompservicebyjobid(String id)throws BusinessException{
		 try {
			 List<?> list=compserviceDao.findCompservicebyjobid(id);
		    return list;
			   } catch (DAOException de) {
			   logger.error(de.getMessage(), de);
			   throw new BusinessException(de.getMessage(), de);
			   }
	}
	public  List<?>findResumeBycardnumber(String cardnumber)throws BusinessException{
		 try {
			 List<?> list=personResumeDao.findResumeBycardnumber(cardnumber);
		    return list;
			   } catch (DAOException de) {
			   logger.error(de.getMessage(), de);
			   throw new BusinessException(de.getMessage(), de);
			   }
	}
	public  void saveRecommends(Recommends recommends)
	throws BusinessException {
// TODO Auto-generated method stub
    try {
    	recommendsssDao.saveRecommends(recommends);
    
	   } catch (DAOException de) {
	   logger.error(de.getMessage(), de);
	   throw new BusinessException(de.getMessage(), de);
	   }
}
	public  void delRecommends(Recommends recommends)
	throws BusinessException {
// TODO Auto-generated method stub
    try {
    	recommendsssDao.delRecommends(recommends);
    
	   } catch (DAOException de) {
	   logger.error(de.getMessage(), de);
	   throw new BusinessException(de.getMessage(), de);
	   }
}
	
	 public   List<?> findRecommendsbyservice(String id)
	throws BusinessException {
// TODO Auto-generated method stub
    try {
    	List<?> list=recommendsssDao.findRecommendsbyservice(id);
    return list;
	   } catch (DAOException de) {
	   logger.error(de.getMessage(), de);
	   throw new BusinessException(de.getMessage(), de);
	   }
}
	 public List<?> findRecommendsbycardnumber(String cardnumber)
	 throws BusinessException {
// TODO Auto-generated method stub
    try {
    	List<?> list=recommendsssDao.findRecommendsbycardnumber(cardnumber);
    return list;
	   } catch (DAOException de) {
	   logger.error(de.getMessage(), de);
	   throw new BusinessException(de.getMessage(), de);
	   }
}
}

