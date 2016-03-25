package ui.action.person;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BdEducate;
import model.PersonImage;
import model.PersonResume;
import model.UserInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import common.constants.IConstants;
import common.exception.BaseException;
import common.ui.BaseAction;

public class UpdateResumeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(UpdateResumeAction.class);
	

	/**
	 * 
	 * 描述：个人简历主表的修改
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 */
	public ActionForward updateResume(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String forward = IConstants.FAIL_KEY;

		try {
			// 获取session
			HttpSession session = request.getSession(true);
			String user = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
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
			FormFile file = (FormFile) dyForm.get("uploadphoto");
			byte [] b=file.getFileData();
			// 组织更改后的personResume对象
			List eee = (List) super.getInviteManager().queryPersonResume(user);
			Object[] ttt = (Object[]) eee.get(0);
			PersonResume personResume = (PersonResume) ttt[0];
			PersonImage image=null;
		
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
	          b=new byte[len];
	            ios.read(b, 0, len);
	            ios.close();
	            imgfile.delete();
	           
//	            if(b.length>0){
//					if(b.length>200*1024){
//						request.setAttribute("image", "toobig");
//						return mapping.findForward("return");
//					}
//				}
				
				
			
				System.out.print("b.lenth"+(b.length)/1024);
				
				

			}
			
			System.out.print("b,length"+b.length);
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
			personResume.setState("0");
			personResume.setOpinion("");
			// 更新数据（update）
			super.getInviteManager().updatePersonResume(personResume);
			
			request.setAttribute("pr", personResume);
			forward = IConstants.SUCCESS_KEY;

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);
		}
		return mapping.findForward(forward);
	}
	public static String getFileExt(FormFile file)
	 {
	  String fileName=file.getFileName();
	  return fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();
	 }


}
