package ui.action.admin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.BdEducate;
import model.BdJob;
import model.BdTrade;
import model.CompBespeak;
import model.CompResume;
import model.ManaUser;
import model.PersonEducation;
import model.PersonImage;
import model.PersonMailInfo;
import model.PersonResume;
import model.PersonResumeB;
import model.PublishJobInfo;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import util.JobShearchObject;
import util.PaginationSupport;

import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

/**
 * 
 * 描述：个人代理招聘
 * jialuhao
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return ActionForward
 * @throws BaseException
 */
public class Aglientapply extends BaseAction {
	private static Logger logger = Logger.getLogger(FindApplyJob.class);
	public ActionForward aglientapply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
		HttpSession session = request.getSession(true);
		int pageIndex=0;
		  int pageSize=10;
		 
		   String account=(String)session.getAttribute(IConstants.ADMIN_USER_ID) ;//得到管理员名
		   List list=super.getInviteManager().findManaUserByName(account);
			ManaUser manaUser=(ManaUser)list.get(0); 
		   String uname = request.getParameter("uname");
			JobShearchObject object= new JobShearchObject();
			object.setQname(uname);
			object.setAccount(account);
		 PaginationSupport pagin2=inviteManager.paginationpersonresume(object,pageIndex, pageSize, true);
		 List<?> list2=pagin2.getItems();
		 List<PersonResume> all=new ArrayList<PersonResume>();
		PersonResume persoresume=new PersonResume();
		 if(list2!=null){
			 for(int i=0;i<list2.size();i++){
				 persoresume=(PersonResume)list2.get(i);
		 		all.add(persoresume);
		 		}
	 		}
		 int contunt = pagin2.getTotalCount();
		 int pc = 0;//总页数
			if (pagin2.getTotalCount() == 10)
				pc = 0;
			else {
				pc = (int) Math.ceil(pagin2.getTotalCount() / pageSize);
				if(pagin2.getTotalCount()%pageSize==0){
					pc=pc-1;
				}
			}
			session.removeAttribute("appzongshu");
			session.removeAttribute("pc");
			session.removeAttribute("applyJobInfo");
			
			session.setAttribute("appzongshu", contunt);
			session.setAttribute("pc",pc );
			
			session.setAttribute("uname", uname);
			
			session.setAttribute("pageIndex",pageIndex );
		 session.setAttribute("personresume", all);
		return mapping.findForward("aglient");
	}
	public ActionForward nextfindapp(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
		       HttpSession session = request.getSession(true);		
		       String account=(String)session.getAttribute(IConstants.ADMIN_USER_ID) ;//得到管理员名
			    String uname = request.getParameter("uname");
				JobShearchObject object= new JobShearchObject();
				object.setQname(uname);
				object.setAccount(account);
				try {
					int pageSize = 10;// 设定显示行数
					String pnum = (String) PropertyUtils.getSimpleProperty(form,"apppnum");// 页码
					
					int ppp = (Integer) session.getAttribute("pc");
					int tpn = ppp;// 总页数
					int pn = new Integer(pnum).intValue();// 页码
					int ddd;
					if (pn >= tpn) {
						ddd = tpn;
					} else if (pn <= 0) {
						ddd = 0;
					} else {
						ddd = pn;
					}
					 PaginationSupport vvv=inviteManager.paginationpersonresume(object,pn, pageSize, true);
					List list = (List) vvv.getItems();
					session.removeAttribute("applyJobInfo");
					session.removeAttribute("pageIndex");
					session.setAttribute("personresume", list);
					session.setAttribute("pageIndex", ddd);
					
					session.setAttribute("uname", uname);
				

				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);

				}

				return mapping.findForward("aglient");
			}	
	public ActionForward goOnRegist(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				
				try {
					HttpSession session = request.getSession(true);
					
					PersonResume personResume = new PersonResume();
					session.removeAttribute("pr");
					session.setAttribute("pr", personResume);
					List bdEducate = (List) super.inviteManager.findAllBdEducate();
					List bdPost = (List) super.inviteManager.findAllBdPost();
					session.removeAttribute("bdPost");
					session.removeAttribute("bdEducate");
					session.setAttribute("bdPost", bdPost);
					session.setAttribute("bdEducate", bdEducate);
					session.setAttribute("shenfenzheng", "");
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("goOnRegist");
			}
	//代理招聘注册后保存
	public ActionForward personRegist2(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				String forward = IConstants.FAIL_KEY;
				String account=(String)request.getSession().getAttribute(IConstants.ADMIN_USER_ID) ;
				try {

					HttpSession session = request.getSession(true);
					String cardnumber=(String)request.getParameter("cardnumber");
					// 获取页面数据
					session.setAttribute("cardnumber", cardnumber);
					List uu = (List) super.getInviteManager().findResumeBycardnumber(cardnumber);
							
					 boolean empty=uu.isEmpty();
						
						
					  if(!empty){
						request.getSession().setAttribute("shenfenzheng", "此身份证已经注册！");
						return mapping.findForward("goOnRegist");
					  }	
			
					//md5Password
				
					
					String truename = (String) request.getParameter("truename");
					String sex = (String) request.getParameter("sex");
					String birthday = (String) request.getParameter("birthday");
					String province = (String) request.getParameter("province");
					String education = (String) request.getParameter("education");
					String school = (String) request.getParameter("school");
					String speciality = (String) request.getParameter("speciality");
					String years = (String) request.getParameter("years");
					String level = (String) request.getParameter("level");
					String language = (String) request.getParameter("language");
					String languagelevel = (String) request
							.getParameter("languagelevel");
					String language2 = (String) request.getParameter("language2");
					String languagelevel2 = (String) request
							.getParameter("languagelevel2");
					String language3 = (String) request.getParameter("language3");
					String languagelevel3 = (String) request
							.getParameter("languagelevel3");
					String dkind = (String) request.getParameter("dkind");
					String dlevel = (String) request.getParameter("dlevel");
					String marriage = (String) request.getParameter("marriage");
					String  tool = (String) request.getParameter("tool");
					String political = (String) request.getParameter("political");
					String skill = (String) request.getParameter("skill");
					String workstate = (String) request.getParameter("workstate");
					String parts = (String) request.getParameter("parts");
					String address = (String) request.getParameter("nowadd");
					String phone = (String) request.getParameter("telnum");
					String mailcode = (String) request.getParameter("postcode");
				
					String otherparts=(String)request.getParameter("otherparts");
					String servicearea=(String)request.getParameter("servicearea");
					DynaActionForm dyForm = (DynaActionForm) form;

					FormFile file = (FormFile) dyForm.get("uploadphoto");
					PersonImage image = null;
					if (file!=null&&file.getFileData().length>0) {


						String path="/image/temp";
						  String realPath=request.getSession().getServletContext().getRealPath(path);
						  File dir=new File(realPath);
						  if(!dir.exists()) dir.mkdir();//判断该目录是否存在，不存在则创建
						  
						  //设置要进行保存的文件名称，防止出现重复文件名称，通过uuid确定其文件名的唯一性
						  String fileName=UUID.randomUUID().toString()+"."+getFileExt(file);//uuid+源文件后缀

						File saveFile=new File(dir,fileName);//创建文件对象，在dir目录下的fileName这个文件
						  FileOutputStream fos=new FileOutputStream(saveFile);//创建一个到saveFile中的输出流
						  fos.write(file.getFileData());
						  int scale=(int) Math.sqrt(file.getFileData().length/(200*1024));
						 
						  fos.close();
						  BufferedImage src = ImageIO.read(new File(dir,fileName)); // 读入文件
				            int width = src.getWidth(); // 得到源图宽
				            int height = src.getHeight(); // 得到源图长
				         
				                width = width /(scale+1);
				                height = height /(scale+1);
				          
				           //对图片进行缩放 
				           Image image2 = src.getScaledInstance(width, height,
				                    Image.SCALE_DEFAULT);
				            BufferedImage tag = new BufferedImage(width, height,
				                    BufferedImage.TYPE_INT_RGB);
				            //Returns:a Graphics2D, which can be used to draw into this BufferedImage
				            Graphics g = tag.getGraphics();
				            g.drawImage(image2, 0, 0, null); // 绘制缩小后的图
				            g.dispose();
				            File imgfile=new File(dir,fileName);
				            ImageIO.write(tag, "JPEG",imgfile );// 输出到文件流
				            FileInputStream ios=new FileInputStream(saveFile);//创建一个到saveFile中的输出流
				            int len = ios.available();
				           byte [] b=new byte[len];
				            ios.read(b, 0, len);
				            ios.close();
				            imgfile.delete();
				           
//				            if(b.length>0){
//								if(b.length>200*1024){
//									request.setAttribute("image", "toobig");
//									return mapping.findForward("return");
//								}
//							}
							
							
						
							System.out.print("b.lenth"+(b.length)/1024);
							
							

						
						PersonImage personImage = new PersonImage();
						personImage.setPersonImage(b);
						// personImage.s
						super.getInviteManager().savePersonImage(personImage);
						String imageid = personImage.getId().toString();

						image = super.getInviteManager().findPersonImageById(imageid);

					}
                    UserInfo userinfo = new UserInfo();
					userinfo.setLoginId(cardnumber);
			super.getInviteManager().saveUserinfo(userinfo);
				
			List list2 = (List) super.getInviteManager().findUserByName(
					cardnumber);
			UserInfo user=(UserInfo)list2.get(0);
					// 组织数据
					PersonResume personResume = new PersonResume();
					

					BdEducate bdEducate = super.getInviteManager().findEducateById(
							education);
					personResume.setCardnumber(cardnumber);
					personResume.setUser(user);
					personResume.setName(truename);
					personResume.setSex(sex);
					personResume.setBirthday(birthday);
					personResume.setHomeplace(province);

					personResume.setEducate(bdEducate);
					personResume.setSchool(school);
					personResume.setSpecialty(speciality);
					personResume.setLang(language);
					personResume.setLevel1(languagelevel);
					personResume.setLang2(language2);
					personResume.setLevel2(languagelevel2);
					personResume.setLang3(language3);
					personResume.setLevel3(languagelevel3);
					
					personResume.setLimitYear(years);
					personResume.setCompLevel(level);
					personResume.setFkPersonImage(image);
					personResume.setOtherparts(otherparts);
					personResume.setQzdq(servicearea);
					personResume.setMarriage(marriage);
					personResume.setDkind(dkind);
					personResume.setDlevel(dlevel);
					personResume.setParts(parts);
					personResume.setTool(tool);
					personResume.setPolitical(political);
					personResume.setSkill(skill);
					personResume.setWorkstate(workstate);
					personResume.setAddress(address);
					personResume.setMailcode(mailcode);
					personResume.setPhone(phone);
					personResume.setPv(0);
					personResume.setServicearea(servicearea);
					personResume.setAglientcode(account);
					personResume.setState("2");
					// 保存数据
					super.getInviteManager().savePersonResume(personResume);
                    
					
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("personRegist2");
			}

	
	/**
	 * 
	 * 描述：显示个人基本情况页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward personRegist3(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)    
			throws BaseException {	
		try {
			HttpSession session = request.getSession(true);
		    String cardnumber=(String) session.getAttribute("cardnumber");
		    List bdEducate = (List) super.inviteManager.findAllBdEducate();
			List bdPost = (List) super.inviteManager.findAllBdPost();
			session.removeAttribute("bdPost");
			session.removeAttribute("bdEducate");
			session.setAttribute("bdPost", bdPost);
			session.setAttribute("bdEducate", bdEducate);
		    //按登陆名查询
			List eee = (List) super.getInviteManager().queryPersonResume(cardnumber);
			   
			if(eee.size()>0){
				
			
				
				Object[] vvv = (Object[]) eee.get(0);
				PersonResume personResume = (PersonResume) vvv[0];
				String dkind=personResume.getDkind();
				dkind=(super.inviteManager.findPostById(dkind)).getPostName();
				personResume.setDkind(dkind);
//				String imageid=personResume.getFkPersonImage().getId().toString();
				
//				PersonImage image=super.getInviteManager().findPersonImageById(imageid);
				String version="false";
				if(personResume.getFkPersonImage()!=null){

					version="true";
				}
				if(personResume.getName()==null){
				
					
					if(personResume.getName()==null)personResume.setInterests("");
					
				}else{
					 //jialuhao根据personcode判断简历表中是否有数据
					
					session.removeAttribute("pr");
					session.removeAttribute("version");
				session.setAttribute("pr", personResume);
				session.setAttribute("version", version);
				session.setAttribute(IConstants.PERSON_USER_ID,cardnumber);
				}
			}

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward("personRegist3");

	}
/**
 * 个人基本情况后修改入库
*/
	public ActionForward updateResume(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				

				try {
					// 获取session
					HttpSession session = request.getSession(true);
					String user = (String) session
							.getAttribute("cardnumber");
					// 获取个人登陆信息
					List loginName = (List) super.getInviteManager().findUserByName(user);
					// 获取页面数据
					String id = (String) PropertyUtils.getSimpleProperty(form, "id");
					String truename = (String) PropertyUtils.getSimpleProperty(form,
							"truename");
					String sex = (String) PropertyUtils.getSimpleProperty(form, "sex");
					String birthday = (String) PropertyUtils.getSimpleProperty(form,
							"birthday");
					String province = (String) PropertyUtils.getSimpleProperty(form,
							"province");

					String education = (String) PropertyUtils.getSimpleProperty(form,
							"education");
					String school = (String) PropertyUtils.getSimpleProperty(form,
							"school");
					String speciality = (String) PropertyUtils.getSimpleProperty(form,
							"speciality");
					String years = (String) PropertyUtils.getSimpleProperty(form,
							"years");
					String level = (String) PropertyUtils.getSimpleProperty(form,
							"level");
					String language = (String) PropertyUtils.getSimpleProperty(form,
							"language");
					String languagelevel = (String) PropertyUtils.getSimpleProperty(
							form, "languagelevel");
					String language2 = (String) PropertyUtils.getSimpleProperty(form,
							"language2");
					String languagelevel2 = (String) request.getParameter("languagelevel2");
					String language3 = (String) request.getParameter("language3");
					String languagelevel3 = (String) request.getParameter("languagelevel3");
					String qzdq=(String)request.getParameter("qzdq");
					String dkind = (String) request.getParameter("dkind");
					String dlevel = (String) request.getParameter("dlevel");   
					String marriage = (String) request.getParameter("marriage");
					String  tool = (String) request.getParameter("tool");
					String  dr = (String) request.getParameter("dr");

					String political = (String) request.getParameter("political");
					String skill = (String) request.getParameter("skill");
					String workstate = (String) request.getParameter("workstate");
					String parts =  request.getParameter( "parts");   
					String otherparts =  request.getParameter("otherparts");      

					String address = (String) request.getParameter("nowadd");
					String phone = (String) request.getParameter("telnum");
					String mailcode = (String) request.getParameter("postcode");  
					String servicearea=(String)request.getParameter("servicearea");

					DynaActionForm dyForm = (DynaActionForm) form; 
					List eee = (List) super.getInviteManager().queryPersonResume(user);
					Object[] ttt = (Object[]) eee.get(0);
					PersonResume personResume = (PersonResume) ttt[0];
					PersonImage image=null;
					image=personResume.getFkPersonImage();
					FormFile file = (FormFile) dyForm.get("uploadphoto");
					if(file!=null&&file.getFileData().length>0){

						String path="/image/temp";
						  String realPath=request.getSession().getServletContext().getRealPath(path);
						  File dir=new File(realPath);
						  if(!dir.exists()) dir.mkdir();//判断该目录是否存在，不存在则创建
						  
						  //设置要进行保存的文件名称，防止出现重复文件名称，通过uuid确定其文件名的唯一性
						  String fileName=UUID.randomUUID().toString()+"."+getFileExt(file);//uuid+源文件后缀

						File saveFile=new File(dir,fileName);//创建文件对象，在dir目录下的fileName这个文件
						  FileOutputStream fos=new FileOutputStream(saveFile);//创建一个到saveFile中的输出流
						  fos.write(file.getFileData());
						  int scale=(int) Math.sqrt(file.getFileData().length/(200*1024));
						 
						  fos.close();
						  BufferedImage src = ImageIO.read(new File(dir,fileName)); // 读入文件
				            int width = src.getWidth(); // 得到源图宽
				            int height = src.getHeight(); // 得到源图长
				         
				                width = width /(scale+1);
				                height = height /(scale+1);
				          
				           //对图片进行缩放 
				           Image image2 = src.getScaledInstance(width, height,
				                    Image.SCALE_DEFAULT);
				            BufferedImage tag = new BufferedImage(width, height,
				                    BufferedImage.TYPE_INT_RGB);
				            //Returns:a Graphics2D, which can be used to draw into this BufferedImage
				            Graphics g = tag.getGraphics();
				            g.drawImage(image2, 0, 0, null); // 绘制缩小后的图
				            g.dispose();
				            File imgfile=new File(dir,fileName);
				            ImageIO.write(tag, "JPEG",imgfile );// 输出到文件流
				            FileInputStream ios=new FileInputStream(saveFile);//创建一个到saveFile中的输出流
				            int len = ios.available();
				           byte [] b=new byte[len];
				            ios.read(b, 0, len);
				            ios.close();
				            imgfile.delete();
				           
//				            if(b.length>0){
//								if(b.length>200*1024){
//									request.setAttribute("image", "toobig");
//									return mapping.findForward("return");
//								}
//							}
							
							
						
							System.out.print("b.lenth"+(b.length)/1024);
							
							if(b.length>0&&personResume.getFkPersonImage()!=null){
								String imageid=personResume.getFkPersonImage().getId().toString();
								image=super.getInviteManager().findPersonImageById(imageid);
								image.setPersonImage(b);
								super.getInviteManager().updatePersonImage(image);
								image=super.getInviteManager().findPersonImageById(imageid);
							}else if(b.length>0&&personResume.getFkPersonImage()==null){
								PersonImage personImage=new PersonImage();
								personImage.setPersonImage(b);
								super.getInviteManager().savePersonImage(personImage);
								String imageid=personImage.getId().toString();
								image=super.getInviteManager().findPersonImageById(imageid);
								
							}else if(b.length==0&&personResume.getFkPersonImage()!=null){
								image=personResume.getFkPersonImage();
							}

						}
					
					// 组织更改后的personResume对象
					
					
					

					UserInfo userinfo = (UserInfo) loginName.get(0);

					BdEducate bdEducate =  super.getInviteManager().findEducateById(education);

					personResume.setUser(userinfo);
					personResume.setName(truename);
					personResume.setSex(sex);
					personResume.setBirthday(birthday);
					personResume.setHomeplace(province);

					personResume.setEducate(bdEducate);
					personResume.setSchool(school);
					personResume.setSpecialty(speciality);
					personResume.setLang(language);
					personResume.setLevel1(languagelevel);
					personResume.setLang2(language2);
					personResume.setLevel2(languagelevel2);
					personResume.setLang3(language3);
					personResume.setLevel3(languagelevel3);
					personResume.setLimitYear(years);
					personResume.setCompLevel(level);
					personResume.setId(new Integer(id).intValue());
					personResume.setFkPersonImage(image);
					personResume.setQzdq(servicearea);
					personResume.setMarriage(marriage);
					personResume.setDkind(dkind);
					personResume.setDlevel(dlevel);
					personResume.setParts(parts);
					personResume.setOtherparts(otherparts);
					personResume.setTool(tool);
					personResume.setPolitical(political);
					personResume.setSkill(skill);
					personResume.setWorkstate(workstate);
					personResume.setAddress(address);
					personResume.setMailcode(mailcode);
					personResume.setPhone(phone);
					personResume.setServicearea(servicearea);
					personResume.setDr(dr);

					// 更新数据（update）
					super.getInviteManager().updatePersonResume(personResume);
					session.removeAttribute("pr");
					session.setAttribute("pr", personResume);
				

				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("personRegist2");
			}
	/**
	 * 显示教育经历
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward personRegist8(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				
				try {
					HttpSession session = request.getSession(true);
					String username = (String) session
							.getAttribute("cardnumber");
					List<PersonEducation> list = super.getInviteManager().findEducationsById(username);
					session.setAttribute("education", list);
					
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("personRegist8");
			}
		/**
		 * 添加一条教育经历	
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws BaseException
		 */
	public ActionForward personRegist8_1(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		
		try {
			HttpSession session = request.getSession(true);
			// 获取数据
			String username = (String) session
					.getAttribute("cardnumber");

			List login = (List) super.getInviteManager().findUserByName(
					username);
			UserInfo userInfo = (UserInfo) login.get(0);
			String id = userInfo.getId() + "";

			// PersonResume personResume = (PersonResume)
			// super.getInviteManager().findPersonResumeById(id.trim());
			List vvv = super.getInviteManager().findPersonResumeById(id);
			Object[] ttt = (Object[]) vvv.get(0);
			PersonResume personResume = (PersonResume) ttt[0];
			String stime = (String) request.getParameter("stime");
			String etime = (String) request.getParameter("etime");
			String schoolname = (String) request.getParameter("schoolname");
			String profession = (String) request.getParameter("profession");
			String education = (String) request.getParameter("education");
			// 组织数据
			PersonEducation personEducation = new PersonEducation();
			personEducation.setResume(personResume);
			personEducation.setStartTime(stime);
			personEducation.setEndTime(etime);
			personEducation.setSchoolname(schoolname);
			personEducation.setProfession(profession);
			personEducation.setEducation(education);
			personEducation.setUserLoginId(username);
			// 保存数据
			super.getInviteManager().savePersonEducation(personEducation);
			//取最新毕业院校
			List<PersonEducation> edu = super.getInviteManager().findEducationsById(username);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long date=0;
			String school=null;
			if(edu!=null&&edu.size()>0){
			
			for(int i=0;i<edu.size();i++){
				PersonEducation personeducation=edu.get(i);
				String endtime=personeducation.getEndTime();
				
				long date1 = sdf.parse(endtime).getTime();
				if(date1>date){
					date=date1;
					school=personeducation.getSchoolname();
				}
}
				
			}
			personResume.setSchool(school);
			super.getInviteManager().updatePersonResume(personResume);
			// 查询表数据
			List list = (List) super.getInviteManager().findPersonResumesById(
					username);
			

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward("personRegist8-1");

	}
	/**
	 * 修改教育经历
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward toUpdateEducation(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {    
				try {
					String rbid = (String) request.getParameter("id");// 简历副表的id
					// session内容
					HttpSession session = request.getSession(true);
					String username = (String) session
							.getAttribute("cardnumber");

					List<PersonEducation> list = super.getInviteManager().findEducationsById(username);
					PersonEducation personE = new PersonEducation();
					// 判断PersonResumeB找到需要的数据
					for (int i = 0; i < list.size(); i++) {
						personE = (PersonEducation) list.get(i);
						if (personE.getId() == (new Integer(rbid).intValue()))
							break;
					}
					session.setAttribute("education", personE);
					
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("toupdate");
			}
	/**
	 * 
	 * 描述：修改并返回教育经历列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward editPersonEducation(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				
				HttpSession session = request.getSession(true);
				String username = (String) session
				.getAttribute("cardnumber");
				try {
					String rbid = (String)request.getParameter("rbid");
					// 查询登陆信息
					List login = (List) super.getInviteManager().findUserByName(username);
					UserInfo userInfo = (UserInfo) login.get(0);
					String id = userInfo.getId() + "";
					List<PersonEducation> list = super.getInviteManager().findEducationsById(username);
					List resume =  super.getInviteManager().queryPersonResume(username);
					Object[] eee=(Object[])resume.get(0);
					PersonResume personResume = (PersonResume)eee[0];
					String stime = (String) request.getParameter("stime");
					String etime = (String) request.getParameter("etime");
					String schoolname = (String) request.getParameter("schoolname");
					String profession = (String) request.getParameter("profession");
					String education = (String) request.getParameter("education");
					PersonEducation personEducation=new PersonEducation();
					for (int i = 0; i < list.size(); i++) {
						personEducation = (PersonEducation) list.get(i);
						if (personEducation.getId() == (new Integer(rbid).intValue()))
							break;
					}
					
//					PersonResumeB personResumeB = (PersonResumeB)list.get(0);
					personEducation.setResume(personResume);
					personEducation.setStartTime(stime);
					personEducation.setEndTime(etime);
					personEducation.setEducation(education);
					personEducation.setProfession(profession);
					personEducation.setSchoolname(schoolname);
					personEducation.setId(new Integer(rbid).intValue());
					personEducation.setUserLoginId(username);
					personEducation.setDr("0");
					super.getInviteManager().updatePersonEducation(personEducation);					
					//取最新毕业院校
					List<PersonEducation> edu = super.getInviteManager().findEducationsById(username);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					long date=0;
					String school=null;
					if(edu!=null&&edu.size()>0){
					
					for(int i=0;i<edu.size();i++){
						PersonEducation personeducation=edu.get(i);
						String endtime=personeducation.getEndTime();
						
						long date1 = sdf.parse(endtime).getTime();
						if(date1>date){
							date=date1;
							school=personeducation.getSchoolname();
						}
		}
						
					}
					personResume.setSchool(school);
					super.getInviteManager().updatePersonResume(personResume);
					
					
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("personRegist8-1");
			}
	/**
	 * 
	 * 描述：删除并返回教育经历列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward delPersonEducation(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
			
				String delId = (String) request.getParameter("delId");//获取删除id
				String username = (String) request.getSession()
				.getAttribute("cardnumber");
				try {
					List<PersonEducation> list = super.getInviteManager().findEducationsByEduId(delId);
					PersonEducation personEducation=new PersonEducation();
					personEducation = (PersonEducation) list.get(0);
					//调用删除方法
					super.getInviteManager().delPersonEducation(personEducation);
				
					//取最新毕业院校
					List resume =  super.getInviteManager().queryPersonResume(username);
					Object[] eee=(Object[])resume.get(0);
					PersonResume personResume = (PersonResume)eee[0];
					List<PersonEducation> edu = super.getInviteManager().findEducationsById(username);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					long date=0;
					String school=null;
					if(edu!=null&&edu.size()>0){
					
					for(int i=0;i<edu.size();i++){
						PersonEducation personeducation=edu.get(i);
						String endtime=personeducation.getEndTime();
						
						long date1 = sdf.parse(endtime).getTime();
						if(date1>date){
							date=date1;
							school=personeducation.getSchoolname();
						}
		}
						
					}
					personResume.setSchool(school);
					super.getInviteManager().updatePersonResume(personResume);
					
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("personRegist8-1");
			}
	/**
	 * 显示工作/实习经历列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward personRegist4(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				
				try {
					HttpSession session = request.getSession(true);
					String username = (String) session
							.getAttribute("cardnumber");
					List<PersonResumeB> list = super.getInviteManager()
							.findPersonResumesById(username);
					
					
					session.setAttribute("resumeb", list);
					
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("personRegist4");
			}
	/**
	 * 保存工作/实习经历
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward personRegist4_1(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		String forward = IConstants.FAIL_KEY;
		try {
			HttpSession session = request.getSession(true);
			// 获取数据
			String username = (String) session
					.getAttribute("cardnumber");

			List login = (List) super.getInviteManager().findUserByName(
					username);
			UserInfo userInfo = (UserInfo) login.get(0);
			String id = userInfo.getId() + "";

			// PersonResume personResume = (PersonResume)
			// super.getInviteManager().findPersonResumeById(id.trim());
			List vvv = super.getInviteManager().findPersonResumeById(id);
			Object[] ttt = (Object[]) vvv.get(0);
			PersonResume personResume = (PersonResume) ttt[0];
			String stime = (String) request.getParameter("stime");
			String etime = (String) request.getParameter("etime");
			String post = (String) request.getParameter("post");
			String company = (String) request.getParameter("company");
			String work = (String) request.getParameter("work");
			// 组织数据
			PersonResumeB personResumeB = new PersonResumeB();
			personResumeB.setResume(personResume);
			personResumeB.setStartTime(stime);
			personResumeB.setEndTime(etime);
			personResumeB.setJob(post);
			personResumeB.setWorkUnit(company);
			personResumeB.setWorkContent(work);
			personResumeB.setUserLoginId(username);
			// 保存数据
			super.getInviteManager().savePersonResumeB(personResumeB);
		
			
			forward = IConstants.SUCCESS_KEY;
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward("personRegist4-1");

	}
	/**
     * 
     * 描述：删除工作/实习经历
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	
	public ActionForward delResume(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)throws BaseException {
	
				
					try {
						//获取登陆账号，密码
						HttpSession session = request.getSession(true);
						String username=(String)session.getAttribute("cardnumber");
						
						//获取删除id
						String delId=(String) request.getParameter("delId");
						//组织对象数据
						PersonResumeB personResumeB=new PersonResumeB();
						List vvv=super.getInviteManager().findPersonResumesById(username);
						for(int i=0;i<vvv.size();i++){
							personResumeB=(PersonResumeB)vvv.get(i);
							if(personResumeB.getId()==new Integer(delId).intValue())
								break;
						}
						
						//调用删除方法
						super.getInviteManager().delPersonResumeB(personResumeB);
						
					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);
					}
					return mapping.findForward("personRegist4-1");	
			}
	 /**
	  * 修改工作/实习经历
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws BaseException
	  */
		public ActionForward showResume(ActionMapping mapping, ActionForm form,

		HttpServletRequest request, HttpServletResponse response)
				throws BaseException {

			
			try {

				String rbid = (String) request.getParameter("id");// 简历副表的id
				// session内容
				HttpSession session = request.getSession(true);
				String username = (String) session
						.getAttribute("cardnumber");
				List<PersonResumeB> list = super.getInviteManager()
						.findPersonResumesById(username);
				PersonResumeB vvv = new PersonResumeB();
				// 判断PersonResumeB找到需要的数据
				for (int i = 0; i < list.size(); i++) {
					vvv = (PersonResumeB) list.get(i);
					if (vvv.getId() == (new Integer(rbid).intValue()))
						break;
				}
				// 传值
				
//				session.setAttribute("rbid", rbid);
				session.setAttribute("resumeb", vvv);
			
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);

			}

			return mapping.findForward("showResume");
		}
		/**
		 * 修改后保存工作/实习经历
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws BaseException
		 */
		public ActionForward editResume(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {


					try {
						// 获取登陆名，密码，行号
						HttpSession session = request.getSession(true);
						String username = (String) session
								.getAttribute("cardnumber");
						
						String rbid = (String)request.getParameter("rbid");
						// 查询登陆信息
						List login = (List) super.getInviteManager().findUserByName(username);
						UserInfo userInfo = (UserInfo) login.get(0);
						String id = userInfo.getId() + "";
						List resume =  super.getInviteManager().queryPersonResume(username);
						Object[] eee=(Object[])resume.get(0);
						PersonResume personResume = (PersonResume)eee[0];
						
						String stime = (String)request.getParameter("stime");
						String etime = (String)request.getParameter("etime");
						String post = (String)request.getParameter("post");
						String company = (String)request.getParameter("company");
						String work = (String)request.getParameter("work");
						// 组织修改完的数据
						PersonResumeB personResumeB =new PersonResumeB();
						List<PersonResumeB> list = super.getInviteManager()
								.findPersonResumesById(username);
						for (int i = 0; i < list.size(); i++) {
							personResumeB = (PersonResumeB) list.get(i);
							if (personResumeB.getId() == (new Integer(rbid).intValue()))
								break;
						}
						
//						PersonResumeB personResumeB = (PersonResumeB)list.get(0);
						personResumeB.setResume(personResume);
						personResumeB.setStartTime(stime);
						personResumeB.setEndTime(etime);
						personResumeB.setJob(post);
					
						personResumeB.setWorkUnit(company);
						personResumeB.setWorkContent(work);
						personResumeB.setId(new Integer(rbid).intValue());
						personResumeB.setUserLoginId(username);
						personResumeB.setDr("0");
//						personResumeB.setVersion(1);
						// 更新修改的数据
						super.getInviteManager().updatePersonResumeB(personResumeB);
						
			
						
					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);
					}
					return mapping.findForward("personRegist4-1");
				}
		/**
		 * 显示自我评价
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws BaseException
		 */
		public ActionForward personRegist5(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {
					
					try {
						HttpSession session = request.getSession(true);
						String username = (String) session
								.getAttribute("cardnumber");
					

						PersonResume personResume = new PersonResume();
						// 通过用户名查询个人简介
						List eee = (List) super.getInviteManager().queryPersonResume(
								username);
						Object[] vvv = (Object[]) eee.get(0);
						personResume = (PersonResume) vvv[0];
						String inte = personResume.getInterests();
						String sss = personResume.getIntroSelf();
						if(inte==null){
							inte="";
						}
						if(sss==null){
							sss="";
						}
			        
						session.setAttribute("intro", sss);
						session.setAttribute("interests", inte);
					

					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);

					}

					return mapping.findForward("personRegist5");
				}
		/**
		 * 保存自我介绍
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws BaseException
		 */
		public ActionForward saveIntro(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {
					
					try {//获取内容
						HttpSession session = request.getSession(true);
						String username = (String) session
								.getAttribute("cardnumber");
						String intro = (String) request.getParameter("intro");
						String interests = (String) request.getParameter("interests");
						PersonResume personResume = new PersonResume();
						//组织数据
						List eee = (List) super.getInviteManager().queryPersonResume(
								username);
						Object[] vvv = (Object[]) eee.get(0);
						personResume = (PersonResume) vvv[0];
						personResume.setInterests(interests);
						personResume.setIntroSelf(intro);
						//保存更新
						super.getInviteManager().updatePersonResume(personResume);
						session.setAttribute("interests", interests);
						session.setAttribute("intro", intro);
						
						

					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);

					}

					return mapping.findForward("saveIntro");
				}
		/**
		 * 
		 * 描述：取得所有个人职位意向列表
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 * @throws BaseException
		 */
		public ActionForward personApplyList(ActionMapping mapping,
				ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
				throws BaseException {

			HttpSession session = request.getSession(true);
			// 取得所有的岗位列表
			try {
				List bdPost = (List) super.getInviteManager().findAllBdPost();
				session.setAttribute("bdPost", bdPost);
				List bdJob = (List) super.getInviteManager().findAllBdJob();
				session.setAttribute("bdJob", bdJob);
				List salarylist= super.getInviteManager().findAllSalary();
				session.setAttribute("salarylist",salarylist);
				
				String username = (String) session
						.getAttribute("cardnumber");
				// 得到个人申请的职位
				List list = super.getInviteManager().queryApplyJobById(username);
				session.setAttribute("allapply", list);
				
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
			return mapping.findForward("personApplyList");
		}
		/**
		 * 
		 * 描述：保存个人意向（欲求职位）
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 * @throws BaseException
		 */
		public ActionForward personRegist6(ActionMapping mapping, ActionForm form,

		HttpServletRequest request, HttpServletResponse response)
				throws BaseException {

			try {
				HttpSession session = request.getSession(true);
				
				
				String username = (String) session
						.getAttribute("cardnumber");
				String post = (String) request.getParameter( "post");
				String job = (String) request.getParameter( "job");
				String workyears = (String) request.getParameter("workyears");
				workyears=workyears.substring(0,workyears.length()-1);
				String salary = (String) request.getParameter("salary");

				BdTrade bdPost=super.getInviteManager().findTradeById(post);
				BdJob bdJob=super.getInviteManager().findJobById(job);
				

				List www = (List) super.getInviteManager().findUserByName(username);
				UserInfo personCode = (UserInfo) www.get(0);
				List uuu = (List) super.getInviteManager().queryPersonResume(
						username);
				Object[] vvv = (Object[]) uuu.get(0);
				PersonResume resumeCode = (PersonResume) vvv[0];
				personCode.setLoginId(username);
				ApplyJobInfo applyJobInfo = new ApplyJobInfo();
				applyJobInfo.setPostCode(bdPost);
				applyJobInfo.setJobCode(bdJob);
				applyJobInfo.setWorkYear(workyears);
				applyJobInfo.setSalary(salary);
				applyJobInfo.setPersonCode(personCode);
				applyJobInfo.setResumeCode(resumeCode);
				
				
				String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(Calendar
						.getInstance().getTime());
				
				applyJobInfo.setCreateTime(createTime);
				//保存个人意向
				super.getInviteManager().saveApplyJob(applyJobInfo);
				//组织返回页面的数据
//				List eee = (List) super.getInviteManager().findAllBdPost();
//				request.setAttribute("bdPost", eee);
//				List rrr = (List) super.getInviteManager().findAllBdJob();
//				request.setAttribute("bdJob", rrr);
//				List list = super.getInviteManager().queryApplyJobById(username);
//				request.setAttribute("allapply", list);
				
			} catch (Exception ex) {
				logger.error("系统异常:", ex);
				throw new BaseException(ex);
			}
			return mapping.findForward("personRegist6");
		}
		/**
		 * 删除个人意向
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws BaseException
		 */
		public ActionForward delApply(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {

					String forward = IConstants.FAIL_KEY;
					try {
						HttpSession session = request.getSession(true);
						String username = (String) session
								.getAttribute("cardnumber");
						String delId = (String) request.getParameter("delId");//获取删除id
//						ApplyJobInfo applyJobInfo = new ApplyJobInfo();
						List vvv=super.getInviteManager().findApplyJobInfoById(delId);
						Object[]ttt=(Object[])vvv.get(0);
						ApplyJobInfo applyJobInfo = (ApplyJobInfo)ttt[0];
			/*			for(int i=0;i<vvv.size();i++){
							Object[]ttt=(Object[])vvv.get(i);
							applyJobInfo=(ApplyJobInfo)ttt[0];
							if(applyJobInfo.getId()==new Integer(delId).intValue())
								break;
						}*/
						//调用删除方法
						super.getInviteManager().delAppJobInfo(applyJobInfo);
						//组织返回页面的数据
						
					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						 throw new BaseException(ex);

					}
					return mapping.findForward("personRegist6");

				}
		/**
		 * 显示要修改的欲求职位的信息
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws BaseException
		 */
		public ActionForward showOneApplyJob(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {
					String forward = IConstants.FAIL_KEY;

					try {
						String apllyId = (String) request.getParameter( "apllyId");
						HttpSession session = request.getSession(true);
						session.removeAttribute("apllyId");
						session.setAttribute("apllyId", apllyId);
						
						List salarylist= super.getInviteManager().findAllSalary();
						session.setAttribute("salarylist",salarylist);
						List applylist = super.getInviteManager().findApplyJobInfoById(apllyId);
						Object[] vvv=(Object[])applylist.get(0);
						ApplyJobInfo  apply=(ApplyJobInfo)vvv[0];
						session.setAttribute("apply", apply);
						

					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);
					}
					return mapping.findForward("showOneApplyJob");
				}
		public ActionForward applyJobEdit(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {
					String forward = IConstants.FAIL_KEY;

					try {
						// 获取session
						HttpSession session = request.getSession(true);
						String user = (String) session
								.getAttribute("cardnumber");
						
						String apllyId = (String) session.getAttribute("apllyId");
						String post = (String) request.getParameter( "post");
						String job = (String) request.getParameter( "job");
						String workyears = (String) request.getParameter("workyears");
						workyears=workyears.substring(0,workyears.length()-1);
						String salary = (String) request.getParameter("salary");
						BdTrade bdPost=super.getInviteManager().findTradeById(post);
						BdJob bdJob=super.getInviteManager().findJobById(job);
						
						List salarylist= super.getInviteManager().findAllSalary();
						request.setAttribute("salarylist",salarylist);
						List www = (List) super.getInviteManager().findUserByName(user);
						UserInfo personCode = (UserInfo) www.get(0);
						List uuu = (List) super.getInviteManager().queryPersonResume(
								user);
						Object[] vvv = (Object[]) uuu.get(0);
						PersonResume resumeCode = (PersonResume) vvv[0];
						personCode.setLoginId(user);
						List oneApply=super.getInviteManager().findApplyJobInfoById(apllyId);
						Object[] ttt=(Object[])oneApply.get(0);
						ApplyJobInfo  applyJobInfo=(ApplyJobInfo)ttt[0];
				
						applyJobInfo.setPostCode(bdPost);
						applyJobInfo.setJobCode(bdJob);
						applyJobInfo.setWorkYear(workyears);
						applyJobInfo.setSalary(salary);
						applyJobInfo.setPersonCode(personCode);
						applyJobInfo.setResumeCode(resumeCode);
						 
						//保存个人意向
						super.getInviteManager().updateApplyJobInfo(applyJobInfo);
					

					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);
					}
					return mapping.findForward("applyJobEdit");
				}
		/**
		 * 查看代理过的个人信息
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws BaseException
		 */
				public ActionForward checkaglient(ActionMapping mapping, ActionForm form,

						HttpServletRequest request, HttpServletResponse response)
								throws BaseException {
							

							try {
								// 获取session
								HttpSession session = request.getSession(true);
								String resumeid = (String) request.getParameter("apllyId");
								UserInfo eee =  super.getInviteManager().findUserById(resumeid);
								String cardnumber=eee.getLoginId();
								session.setAttribute("cardnumber", cardnumber);
							} catch (Exception ex) {
								logger.error("系统异常:", ex);
								throw new BaseException(ex);
							}
							return mapping.findForward("checkaglient");
						}
				/**
				 * 
				 * 描述：个人简历预览内容
				 * 
				 * @param mapping
				 * @param form
				 * @param request
				 * @param response
				 * @return ActionForward
				 * @throws BaseException
				 */
				public ActionForward resumeView(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {
					String forward = IConstants.FAIL_KEY;
					try {
						HttpSession session = request.getSession(true);
						// 获取简历内容
						String id = (String) session
								.getAttribute("cardnumber");
						List eee = (List) super.getInviteManager().queryPersonResume(id);
						Object[] vvv = (Object[]) eee.get(0);
						PersonResume personResume = (PersonResume) vvv[0];
						String dkind=personResume.getDkind();
						dkind=(super.inviteManager.findPostById(dkind)).getPostName();
						personResume.setDkind(dkind);
//						String imageid=personResume.getFkPersonImage().getId().toString();
//						
//						PersonImage image=super.getInviteManager().findPersonImageById(imageid);
			//
						String version="false";
						if(personResume.getFkPersonImage()!=null){
							version="true";
						}
						List list = (List) super.getInviteManager().findPersonResumesById(
								id);
						List applyList = super.getInviteManager().queryApplyJobById(id);
						List educations = super.getInviteManager().findEducationsById(id);
			           // ApplyJobInfo userInfo = (ApplyJobInfo) list.get(i);//提取审核状态			
						//String state=userInfo.getDatatime();
						session.setAttribute("allapply", applyList);//求职信息
						session.setAttribute("resumeb", list);//工作/实习经历
						session.setAttribute("version", version);
						session.setAttribute("educations", educations);//教育培训经历
						session.setAttribute("pr", personResume);//基本情况
						forward = IConstants.SUCCESS_KEY;

					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);

					}
					return mapping.findForward("resumeView");

				}
				/**
				 * 
				 * 描述：简历刷新功能
				 * jialuhaoadd新加代码
				 * @param mapping
				 * @param form
				 * @param request
				 * @param response
				 * @return ActionForward
				 * @throws BaseException
				 */
				public ActionForward refresh(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {
					String forward = IConstants.FAIL_KEY;
					try {
						// 获取相应的投递信息			
					   
						HttpSession session = request.getSession(true);
						String username = (String) session
								.getAttribute("cardnumber");
						
						List list=super.getInviteManager().queryApplyJobBypersonId(username);
						String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(Calendar.getInstance().getTime());
						for(int i=0;i<list.size();i++){
						Object[] vvv = (Object[]) list.get(i);
						ApplyJobInfo applyjobinfo = (ApplyJobInfo) vvv[0];
				    	 
				    	applyjobinfo.setRefreshtime(time);
				    	applyjobinfo.setCreateTime(time);
				    	super.getInviteManager().updateApplyJobInfo(applyjobinfo);
						}  
						List resume =  super.getInviteManager().queryPersonResume(username);
						Object[] eee=(Object[])resume.get(0);
						PersonResume personResume = (PersonResume)eee[0];
				    	 String pkresume=personResume.getId()+"";//得到表中compresume字段pkresume
						List aaaa=super.getInviteManager().findCompResumeBypersonid(pkresume);
						for(int i=0;i<aaaa.size();i++){
							Object[] vvv = (Object[]) aaaa.get(i);
					    	 CompResume compResume = (CompResume) vvv[0];
					    	 compResume.setCreatetime(time);
					    	 super.getInviteManager().updateCompResume(compResume);
						}
						
				    	 forward = IConstants.SUCCESS_KEY;
					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);
					}
					return mapping.findForward("resumeView");
				}
				 /**
			     * 
			     * 描述：在页面中显示企业招聘信息,显示第一页的信息
			     * @param mapping
			     * @param form
			     * @param request
			     * @param response
			     * @return ActionForward
			     * @throws BaseException 
			     */
			    
				public ActionForward showAll(ActionMapping mapping, ActionForm form,

			             HttpServletRequest request, HttpServletResponse response) throws BaseException{
			  	   
			  	   try{
			  		
			  		  int pageIndex=0;
			  		  int pageSize=12;
					  String pageSizefor=request.getParameter("pageSize"); 
					  pageSize= pageSizefor!=null&&"".equals(pageSizefor)?Integer.valueOf(pageSizefor).intValue():12 ;
			  		  boolean desc=true;
			  		  PaginationSupport pagin=super.getInviteManager().paginationPublishJob(null,pageIndex, pageSize, desc);
			  		  List<?> list=pagin.getItems();
			  		  int totalCount=pagin.getTotalCount();
			  		  int tpp=(int) Math.ceil((totalCount-1)/pageSize);
			  		HttpSession session=request.getSession();
			  		  //jialuhaoadd  获取简历投递状态
						String username = (String) session
								.getAttribute("cardnumber");
						List resume =  super.getInviteManager().queryPersonResume(username);
						List aaaa=null;
						if(resume.size()!=0){
						Object[] eee=(Object[])resume.get(0);
						PersonResume personResume = (PersonResume)eee[0];
				    	 String pkresume=personResume.getId()+"";//得到表中compresume字段pkresume
					    aaaa=super.getInviteManager().findCompResumeBypersonid(pkresume);
						}
			  		 
						List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
			  		  PublishJobInfo jobInfo=new PublishJobInfo();
			  		 	if(list==null)
			  		 		 return mapping.findForward("fail");
			  		 	else{	
			  		
			  		 		boolean e=true;
			  		 		List<?> list11=super.inviteManager.queryApplyJobById(username);
							if(list11==null||list11.size()==0){
								e=false;
							}
							session.setAttribute("e", e);
					
					for(int i=0;i<list.size();i++){
				 		
						
				 			jobInfo=(PublishJobInfo)list.get(i);
				 			//判断已经投递的企业
				 			String a="未投递";
				 		if(aaaa!=null){
				 			for(int j=0;j<aaaa.size();j++){
								Object[] vvv = (Object[]) aaaa.get(j);
						    	 CompResume compResume = (CompResume) vvv[0];
						    	  PublishJobInfo comjob= compResume.getCompPost(); 		      
				  		        if(jobInfo.equals(comjob))
				  		        {
				        	      a="已投递";
				  		        }
				  					}
				 		}
				 			jobInfo.setZp_flag(a);  
				 			allPublishJobInfo.add(jobInfo);	
												
				 		}
			  		 		session.setAttribute("allPublishJobInfo", allPublishJobInfo);
			  		 		session.setAttribute("pageIndex", pageIndex);
			  		 		
			  				
			  		 		session.removeAttribute("totalCount");
			  		 		session.setAttribute("totalCount", totalCount);
			  		 		session.removeAttribute("tpp");
			  		 		session.setAttribute("tpp", tpp);
			  		 		
			  	   		
			  				return mapping.findForward("showAll");
			  		 	}
			  	   		}catch(BusinessException be){
			         	   logger.error(be.getMessage(),be);
			         	   throw new BaseException(be);
			         	   
			            }catch(Exception ex){
			         	   logger.error("系统异常:",ex);
			         	   throw new BaseException(ex);
			            }
			  	   
			     }
			     /**
			      * 
			      * 描述：显示其他页的信息
			      * @param mapping
			      * @param form
			      * @param request
			      * @param response
			      * @return ActionForward
			      * @throws BaseException 
			      */
			     
			     
			     
			     public ActionForward showOtherPage(ActionMapping mapping, ActionForm form,

			             HttpServletRequest request, HttpServletResponse response) throws BaseException{
			    	 
			    	 try {
							int pageSize=12;
							String pageSizefor=request.getParameter("pageSize"); 
							pageSize= pageSizefor!=null&&!"".equals(pageSizefor)?Integer.valueOf(pageSizefor).intValue():12 ;
							String pnum=(String)PropertyUtils.getSimpleProperty(form,"pageIndex");
							HttpSession session = request.getSession(true);
						    int ppp=(Integer)session.getAttribute("totalCount");
							int tpn=(int) Math.ceil((ppp-1)/pageSize);
							int pn=new Integer(pnum).intValue();
							int ddd;
								if(pn>=tpn){
									ddd=tpn;
								}
								else if(pn<=0){
									 ddd=0;
								}
								else{
									 ddd=pn;
								}
						  	String jobName=request.getParameter("jobname"); 
							String address=request.getParameter("address"); 
							String starttime=request.getParameter("starttime"); 
							String endtime=request.getParameter("endtime"); 
							String compname=request.getParameter("compname"); 		  		   
							String username = (String) session
							.getAttribute("cardnumber");
							List resume =  super.getInviteManager().queryPersonResume(username);
							List aaaa=null;
							if(resume.size()!=0){
							Object[] eee=(Object[])resume.get(0);
							PersonResume personResume = (PersonResume)eee[0];
					    	 String pkresume=personResume.getId()+"";//得到表中compresume字段pkresume
						    aaaa=super.getInviteManager().findCompResumeBypersonid(pkresume);
							}
							PublishJobInfo publishJobInfo=new PublishJobInfo();
							publishJobInfo.setJobAmount(jobName);
							publishJobInfo.setAddress(address);
							publishJobInfo.setCompLoginId(compname);
							publishJobInfo.setCloseTime(starttime);
							publishJobInfo.setPublishTime(endtime);
							PaginationSupport pagin=super.getInviteManager().paginationPublishJob(publishJobInfo,ddd, pageSize, true);
							
							List<?> list=pagin.getItems();
							List<PublishJobInfo> allPublishJobInfo=new ArrayList<PublishJobInfo>();
				  			PublishJobInfo jobInfo=new PublishJobInfo();
				  			boolean e=true;
			  		 		List<?> list11=super.inviteManager.queryApplyJobById(username);
							if(list11==null||list11.size()==0){
								e=false;
							}
							session.setAttribute("e", e);
				  			for(int i=0;i<list.size();i++)
					 		{
					 			jobInfo=(PublishJobInfo)list.get(i);
					 			//判断已经投递的企业
					 			String a="未投递";
					 		if(aaaa!=null){
					 			for(int j=0;j<aaaa.size();j++){
									Object[] vvv = (Object[]) aaaa.get(j);
							    	 CompResume compResume = (CompResume) vvv[0];
							    	  PublishJobInfo comjob= compResume.getCompPost(); 		      
					  		        if(jobInfo.equals(comjob))
					  		        {
					        	      a="已投递";
					  		        }
					  					}
					 		}
					 			jobInfo.setZp_flag(a);  
					 			allPublishJobInfo.add(jobInfo);	
													
					 		}
					 	session.setAttribute("allPublishJobInfo", allPublishJobInfo);
					 	int totalCount=pagin.getTotalCount();
					 	int tpp=(int) Math.ceil((totalCount-1)/pageSize);
					 	session.removeAttribute("totalCount");
					 	session.setAttribute("totalCount", totalCount); 	
					 	session.setAttribute("pageIndex", ddd);
					 	session.setAttribute("tpp", tpp);
					 	session.setAttribute("jobname", jobName);
					 	session.setAttribute("address", address);
					 	session.setAttribute("starttime", starttime);
					 	session.setAttribute("endtime", endtime);
					 	session.setAttribute("compname", compname);
					 	return mapping.findForward("showAll");
			    	 }catch(BusinessException be){
			       	   logger.error(be.getMessage(),be);
			       	   throw new BaseException(be);
			       	   
			          }catch(Exception ex){
			       	   logger.error("系统异常:",ex);
			       	   throw new BaseException(ex);
			          }
			     }
			     /**
			 	 * 
			 	 * 描述：投递个人简历
			 	 * 
			 	 * @param mapping
			 	 * @param form
			 	 * @param request
			 	 * @param response
			 	 * @return ActionForward
			 	 * @throws BaseException
			 	 */
			 	public ActionForward postResume(ActionMapping mapping, ActionForm form,

			 	HttpServletRequest request, HttpServletResponse response)
			 			throws BaseException {
			 		
			 		try {
			 			// 获取相应的投递信息
			 			PublishJobInfo compJob = (PublishJobInfo) request.getSession()
			 					.getAttribute("jobinfo");
			 			HttpSession session = request.getSession(true);
			 			String username = (String) session
			 					.getAttribute("cardnumber");
			 			List list = super.getInviteManager().queryPersonResume(username);
			 			if(list.size()==0){
			 				ActionMessages messages = new ActionMessages();
			 				messages.add("error", new ActionMessage("errors.resume"));
			 				super.saveErrors(request, messages);

			 			}else{
			 				Object[] vvv = (Object[]) list.get(0);
			 				PersonResume pkResume = (PersonResume) vvv[0];
			 				// 组织投递内容
			 				PersonMailInfo personMailInfo = new PersonMailInfo();
			 				personMailInfo.setCompJob(compJob);
			 				personMailInfo.setUserLoginId(username);
			 				CompResume compResume = new CompResume();
			 				compResume.setCompLoginId(compJob.getCompLoginId());
			 				compResume.setCompPost(compJob);
			 				compResume.setPkResume(pkResume);
			 				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(Calendar.getInstance().getTime());
			 				compResume.setCreatetime(time);
			 				//ApplyJobInfo apply = new ApplyJobInfo();
			 				//apply.setId(compJob.getJob().getId());
			 				//compResume.setPersonPost(apply);
			 				// 投递
			 				super.getInviteManager().savePersonMailInfo(personMailInfo,
			 						compResume);
			 				session.removeAttribute("jobinfo");
			 				
			 			}


			 		} catch (Exception ex) {
			 			logger.error("系统异常:", ex);
			 			throw new BaseException(ex);

			 		}

			 		return mapping.findForward("post");

			 	}
			 	/**
				 * 
				 * 描述：个人查看企业招聘职位的详细内容
				 * 
				 * @param mapping
				 * @param form
				 * @param request
				 * @param response
				 * @return ActionForward
				 * @throws BaseException
				 */
				public ActionForward personRegist7(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {

					String forward = IConstants.FAIL_KEY;
					try {
						// 获取数据
						String jobId = (String) request.getParameter("jobKey");
						String compName = new String (request.getParameter("compName").getBytes("ISO-8859-1"),"utf-8");
						
				
						Object[] list = (Object[]) super.getInviteManager().queryJobById(
								new Integer(jobId).intValue());
						PublishJobInfo vvv = (PublishJobInfo) list[0];
						
//						request.setAttribute("jobinfo", vvv);
						
						HttpSession session = request.getSession(true);
						session.setAttribute("compName", compName);
						session.removeAttribute("jobinfo");
						session.setAttribute("jobinfo", vvv);
						forward = IConstants.SUCCESS_KEY;
					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);
					}
					return mapping.findForward("personRegist7");
				}
				/**
				 * 
				 * 描述：代理求职的撤销
				 * 
				 * @param mapping
				 * @param form
				 * @param request
				 * @param response
				 * @return ActionForward
				 * @throws BaseException
				 */
				public ActionForward deleteaglient(ActionMapping mapping, ActionForm form,

				HttpServletRequest request, HttpServletResponse response)
						throws BaseException {

				
					try {
						String userid = (String) request.getParameter("apllyId");
						UserInfo user =  super.getInviteManager().findUserById(userid);
						String id=user.getLoginId();
						super.getInviteManager().delUserinfo(user);
						List apply=super.getInviteManager().queryApplyJobBypersonId(id);
						for(int i=0;i<apply.size();i++){
						Object[] ttt=(Object[])apply.get(i);
						ApplyJobInfo  applyJob=(ApplyJobInfo)ttt[0];
						super.getInviteManager().delAppJobInfo(applyJob);						
						}
						List list=super.getInviteManager().queryPersonResume(id);
						if(list.size()>0){
						Object[] vvv = (Object[]) list.get(0);
						PersonResume personResume = (PersonResume) vvv[0];
						super.getInviteManager().delPersonResume(personResume);}
						PersonResumeB personResumeB=new PersonResumeB();
						List uuu=super.getInviteManager().findPersonResumesById(id);
						for(int i=0;i<uuu.size();i++){
							personResumeB=(PersonResumeB)uuu.get(i);
							super.getInviteManager().delPersonResumeB(personResumeB);
						}
						PersonEducation personEducation=new PersonEducation();
						List www=super.getInviteManager().findEducationsById(id);
						for(int i=0;i<www.size();i++){
							personEducation=(PersonEducation)www.get(i);
							super.getInviteManager().delPersonEducation(personEducation);
						}
					} catch (Exception ex) {
						logger.error("系统异常:", ex);
						throw new BaseException(ex);
					}
					return mapping.findForward("deleteaglient");
				}
				public static String getFileExt(FormFile file)
				 {
				  String fileName=file.getFileName();
				  return fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();
				 }
}

