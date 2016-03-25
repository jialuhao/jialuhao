package service;

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
import util.JobShearchObject;
import util.PaginationSupport;

import common.exception.BusinessException;
import common.exception.DAOException;


/**
 *<p>Title: 人才招聘管理系统后台入口</p>
 *
 *<p>Description: Facade系统接口,web层只能与它交互</p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public interface InviteManager {
	
	public List<?> queryPersonResumes(String personId)throws BusinessException;
	public abstract List<?> queryPersonResume(String personId)throws BusinessException;
	public abstract PersonImage findPersonImageById(String Id)throws BusinessException;
	public abstract void updatePersonImage(PersonImage personImage)throws BusinessException;
	public abstract void delPersonImage(PersonImage personImage)throws BusinessException;
	public abstract void savePersonImage(PersonImage personImage)throws BusinessException;
	public abstract CompImage findCompImageById(String Id)throws BusinessException;
	public abstract void updateCompImage(CompImage personImage)throws BusinessException;
	public abstract void delCompImage(CompImage personImage)throws BusinessException;
	public abstract void saveCompImage(CompImage personImage)throws BusinessException;
	public abstract void updateApplyJobInfo(ApplyJobInfo applyJobInfo)throws BusinessException;
	public abstract CompBespeak findCompBespeakById(String id)throws BusinessException;
	public abstract String findFileByResumeId(String resumeId,String CompLoginId)throws BusinessException;
	public abstract List<?> findFileByResumecompId(String resumeId,String CompPost)throws BusinessException;
	public abstract BdPostRoot findPostRootById(String id)throws BusinessException;
	public abstract PublishJobInfo findPublishJobById(String id)throws BusinessException;
	public abstract UserInfo findUserById(String id)throws BusinessException;
	public abstract CompInfo findCompById(String id)throws BusinessException;
	public abstract BdPost findPostById(String id)throws BusinessException;
	public abstract BdCompkind findCompKindById(String id)throws BusinessException;
	public abstract BdJob findJobById(String id)throws BusinessException;
	public abstract BdEducate findEducateById(String id)throws BusinessException;
	public abstract BdTrade findTradeById(String id)throws BusinessException;
	public abstract void saveBdPostRoot(BdPostRoot bdPostRoot)throws BusinessException;
	public abstract void updateBdPostRoot(BdPostRoot bdPostRoot)throws BusinessException;
	public abstract List<BdPostRoot> findAllBdPostRoot()throws BusinessException;
	public abstract List<?> queryBdPostByRoot (String id)throws BusinessException;
	public abstract void saveCompResumeFile(CompResume compResume)throws BusinessException;
	public abstract List<?> findApplyJobInfoById(String Id)throws BusinessException;
	public abstract List<?> queryApplyJobInfoById(String Id)throws BusinessException;
	
	public abstract PaginationSupport queryCompResumeByFile(String file, String compLogin,PersonResume resume ,int pageIndex,int pageSize,boolean desc)throws BusinessException;
	public abstract CompResume findCompResumeById(String id)throws BusinessException;
	public abstract List<?> findFileBypkResume(String resumeId)throws BusinessException;
	public abstract List<?> findCompResumeBypersonid(String resumeId) throws BusinessException ;
	public abstract PaginationSupport paginationCompResume(String compLogin, String status, int pageIndex,int pageSize,boolean desc)throws BusinessException;
	public abstract void delBdBdEducate(BdEducate bdEducate)throws BusinessException;
	public abstract void delBdTrade(BdTrade bdTrade)throws BusinessException;
	public abstract void delBdCompkind(BdCompkind bdCompkind)throws BusinessException;
	public abstract List<ManaUser> findAllManaUser()throws BusinessException;
	public abstract void saveManaUser(ManaUser manaUser)throws BusinessException;
	public abstract void updateManaUser(ManaUser manaUser)throws BusinessException;
	
	public abstract void delAppJobInfo(ApplyJobInfo applyJobInfo)throws BusinessException;
	public abstract void updateCompRegister(CompBespeak compBespeak)throws BusinessException;
	public abstract Object[] queryJobById(Integer jobId)throws BusinessException;
	public abstract void savePersonMailInfo(PersonMailInfo personMailInfo ,CompResume compResume)throws BusinessException;
	public abstract void delPersonMailInfo(PersonMailInfo personMailInfo)throws BusinessException;
	public abstract List<?> queryPersonMailInfo(String person_loginId)throws BusinessException;
	public abstract void delManaUser(ManaUser manaUser) throws BusinessException;
	public abstract PaginationSupport paginationPublishJob(PublishJobInfo publishJobInfo , int pageIndex,int pageSize, boolean desc) throws BusinessException;
	public abstract PaginationSupport paginationpersonmessage(JobShearchObject object, int pageIndex,int pageSize) throws BusinessException;
	public abstract PaginationSupport paginationUserInfo(JobShearchObject object,int pageIndex,int pageSize, boolean desc) throws BusinessException;
	public abstract PaginationSupport paginationshowAllBespeak(String name,String areacode,int pageIndex,int pageSize, boolean desc) throws BusinessException;
	public abstract PaginationSupport paginationshowAllCompany(String aglientcode,String name,String areacode,int pageIndex,int pageSize, boolean desc) throws BusinessException;
	public abstract PaginationSupport paginationlcompanymessage(JobShearchObject object, int pageIndex,int pageSize)throws BusinessException;
	public abstract int getAllUser();
	public abstract void saveApplyJob(ApplyJobInfo applyJobInfo)throws BusinessException;
	public abstract List<?> queryApplyJobById(String personId)throws BusinessException;
	public abstract List<?> queryApplyJobBypersonId(String personId)throws BusinessException;
	public abstract List<?> queryJobInfoById(String compLoginId)throws BusinessException;
	public abstract List<?> queryEnableJobInfoById(String compLoginId)throws BusinessException;
	public abstract List<CompBespeak> queryCompUserById(String compId)throws BusinessException;
	public abstract List<CompBespeak> queryCompUserBycompnum(String compnum)throws BusinessException;
	public abstract void saveCompBespeak(CompBespeak compBespeak) throws BusinessException;
	public abstract void saveCompservice(CompService compservice)throws BusinessException;
	public abstract void saveUserinfo(UserInfo userinfo) throws BusinessException;
	public abstract void saveCompInfo(CompInfo compinfo) throws BusinessException;
	public abstract void savePublishJobInfo(PublishJobInfo publishJobInfo) throws BusinessException;
	public abstract void savePersonResume(PersonResume personResume)throws BusinessException;
	public abstract List<?> findResumeBycardnumber(String cardnumber)throws BusinessException;
	public abstract void savePersonResumeB(PersonResumeB personResumeB)throws BusinessException;
	public abstract void updateCompResume(CompResume compResume) throws BusinessException;
	public abstract void updateCompBespeak(CompBespeak compBespeak) throws BusinessException;
	public abstract void updateUserinfo(UserInfo userinfo) throws BusinessException;
	public abstract void updateCompInfo(CompInfo compinfo) throws BusinessException;
	public abstract void updatePublishJobInfo(PublishJobInfo publishJobInfo) throws BusinessException;
	public abstract void updatePersonResume(PersonResume personResume)throws BusinessException;
	public abstract void updatePersonResumeB(PersonResumeB personResumeB)throws BusinessException;
	public abstract List<UserInfo> findUserByName(String loginName,String password)throws BusinessException;
	public abstract List<UserInfo> findUserByName(String loginName)throws BusinessException;
	public abstract List<ManaUser> findManaUserByName(String loginName)throws BusinessException;
	public abstract List<ManaUser> findManaUserByName(String loginName,String password)throws BusinessException;
	public abstract List<CompBespeak> findAllCompBespeak()throws BusinessException;
	public abstract List<CompBespeak> findAllCompEnroll()throws BusinessException;
	public abstract List<UserInfo> findAllUserInfo() throws BusinessException;
	
	public abstract CompInfo findCompInfoById(String id)throws BusinessException;
	public abstract List<?> findPersonResumeById(String id)throws BusinessException;

	public abstract List<PersonResumeB> findPersonResumesById(String loginId)throws BusinessException;
	public abstract List<PersonResume> findAllPersonResume()throws BusinessException;
	public abstract List<PublishJobInfo> findAllPublishJobInfo()throws BusinessException;
	public abstract List<?> findAllCompResume(String comp_login_id)throws BusinessException;
	public abstract List<CompInfo> findAllCompInfo()throws BusinessException;
	public abstract void delCompResume(CompResume compResume) throws BusinessException;
	public abstract void delCompBespeak(CompBespeak compBespeak) throws BusinessException;
	public abstract void delUserinfo(UserInfo userinfo) throws BusinessException;
	public abstract void delCompInfo(CompInfo compinfo) throws BusinessException;
	public abstract void delPublishJobInfo(PublishJobInfo publishJobInfo) throws BusinessException;
	public abstract void delPersonResume(PersonResume personResume)throws BusinessException;
	public abstract void delPersonResumeB(PersonResumeB personResumeB)throws BusinessException;
	public abstract PaginationSupport paginationStrategy(ApplyJobInfo applyJobInfo , int pageIndex,int pageSize,boolean desc)throws BusinessException;
	public abstract PaginationSupport paginationS(String value , int pageIndex,int pageSize,boolean desc)throws BusinessException;
	public abstract List<?> showResumeInComp(String useId, String resumeId) throws BusinessException;
	public abstract List<?> findAllApplyJobInfo() throws BusinessException;
	
	public abstract void delBdJob(BdJob bdJob) throws BusinessException;
	public abstract void delBdPost(BdPost bdPost) throws BusinessException;
	public abstract void saveBdJob(BdJob bdJob) throws BusinessException;
	public abstract void saveBdPost(BdPost bdPost) throws BusinessException;
	public abstract void saveBdCompKind(BdCompkind bdCompKind) throws BusinessException;
	public abstract void saveBdTrade(BdTrade bdTrade) throws BusinessException;
	public abstract void saveBdEducate(BdEducate bdEducate)throws BusinessException;
	public abstract void updateBdJob(BdJob bdJob) throws BusinessException;
	public abstract void updateBdPost(BdPost bdPost) throws BusinessException;
	public abstract void updateBdCompKind(BdCompkind bdCompKind) throws BusinessException;
	public abstract void updateBdTrade(BdTrade bdTrade) throws BusinessException;
	public abstract void updateBdEducate(BdEducate bdEducate)throws BusinessException;
	public abstract List<BdJob> findAllBdJob()throws BusinessException;
	public abstract List<BdPost> findAllBdPost()throws BusinessException;
	public abstract List<BdCompkind> findAllBdCompKind()throws BusinessException;
	public abstract List<BdTrade> findAllBdTrade()throws BusinessException;
	public abstract List<BdEducate> findAllBdEducate()throws BusinessException;
	
	
	public abstract PaginationSupport paginationpersonresume(JobShearchObject object,int pageIndex,int pageSize, boolean desc) throws BusinessException;
	public abstract PaginationSupport paginationPublishJobInfo(int pageIndex,int pageSize, boolean desc) throws BusinessException;
	public abstract PaginationSupport paginationSearchPublishJobInfo(JobShearchObject object,int pageIndex,int pageSize, boolean desc) throws BusinessException;
	public abstract PaginationSupport paginationAppJob(int pageIndex,int pageSize,boolean desc)throws BusinessException;
	public abstract PaginationSupport paginationSearchAppJob(JobShearchObject object,int pageIndex,int pageSize,boolean desc)throws BusinessException;
	public abstract int findAllPublisJob()throws BusinessException;
	public abstract int findAllAppJob()throws BusinessException;
	
	public abstract  ApplyJobInfo findAppJobById(String id)throws BusinessException;
	public abstract void saveJobInfo(PublishJobInfo publishJobInfo) throws BusinessException;
	//2014年12月7日  新加
	public abstract void savePersonEducation(PersonEducation personEducation)throws DAOException; 
	public abstract void updatePersonEducation(PersonEducation personEducation)throws DAOException; 
	public abstract List<PersonEducation> findAllEducation() throws DAOException;
	public abstract void delPersonEducation(PersonEducation personEducation)throws DAOException, BusinessException; 
	public abstract List<PersonEducation> findEducationsById(String id) throws DAOException, BusinessException;
	public abstract List<PersonEducation> findEducationsByEduId(String id) throws DAOException, BusinessException;

	
	//commoncode
	public abstract void saveCommonCode(Commoncode commoncode)throws BusinessException;
	public abstract void updateCommonCode(Commoncode commoncode)throws BusinessException;
	public abstract List<Commoncode> findAllCommonCode() throws BusinessException;
	public abstract void delCommonCode(Commoncode commoncode)throws BusinessException;
	public abstract Commoncode findCommonCodeById(String id)throws BusinessException;
	public abstract List<Commoncode> queryCommonCodeById(String CommoncodeId)throws BusinessException;
	//area
	public abstract void saveAreaCode(Areacode areacode)throws BusinessException;
	public abstract void updateAreaCode(Areacode areacode)throws BusinessException;
	public abstract List<Areacode> findAllAreaCode() throws BusinessException;
	public abstract void delAreaCode(Areacode areacode)throws BusinessException;
	public abstract Areacode findAreaCodeById(String id)throws BusinessException;
	public abstract Areacode findAreaCodeByarea(String code)throws BusinessException;
	public abstract Areacode findAreaCodeByname(String name)throws BusinessException;
	public abstract List<Areacode> queryAreaCodeById(String AreacodeId)throws BusinessException;
	//salary
	public abstract void saveSalary(BdSalary salary)throws BusinessException;
	public abstract void updateSalary(BdSalary salary)throws BusinessException;
	public abstract List<BdSalary> findAllSalary() throws BusinessException;
	public abstract void delSalary(BdSalary salary)throws BusinessException;
	public abstract BdSalary findSalaryById(String id)throws BusinessException;
	public abstract List<BdSalary> querySalaryById(String salaryId)throws BusinessException;
	
	public abstract void saveServicelog(Servicelog servicelog)throws BusinessException;
	public abstract void updateServicelog(Servicelog servicelog)throws BusinessException;
	public abstract List<Servicelog> findAllServicelog() throws BusinessException;
	public abstract void delServicelog(Servicelog servicelog)throws BusinessException;
	public abstract List<?> findServicelogById(String id)throws BusinessException;
	public abstract Servicelog queryServicelogById(String id)throws BusinessException;
	
	public abstract void saveRecommends(Recommends recommends)throws BusinessException;
	public abstract List<?> findRecommendsbyservice(String id)throws BusinessException;
	public abstract List<?> findRecommendsbycardnumber(String cardnumber)throws BusinessException;	
	public abstract void delRecommends(Recommends recommends)throws BusinessException;
	
	public abstract void saveServicepeople(Servicepeople servicepeople)throws BusinessException;
	public abstract void updateServicepeople(Servicepeople servicepeople)throws BusinessException;
	public abstract List<Servicepeople> findAllServicepeople() throws BusinessException;
	public abstract void delServicepeople(Servicepeople servicelog)throws BusinessException;
	public abstract List<Servicepeople> findServicepeopleById(String id)throws BusinessException;
	public abstract List<Servicepeople> queryServicepeopleById(String id)throws BusinessException;
	public abstract List<?>findcompservicebyjobid(String id)throws BusinessException;
}