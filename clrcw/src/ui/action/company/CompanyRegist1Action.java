package ui.action.company;

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
import model.*;

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

import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class CompanyRegist1Action extends BaseAction {
	private static Logger logger = Logger.getLogger(CompanyRegist1Action.class);

	public ActionForward companyRegist1(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String forward = IConstants.FAIL_KEY;
		try {
			request.getSession().setAttribute("cunzai", "");
			boolean exist = this.authenticate(form).isEmpty();		
            boolean empty=this.empty(form).isEmpty();
			if (!exist) {
				// 验证企业登录名不能重复
			
				request.getSession().setAttribute("cunzai", "用户已存在！");
				
			} else if(!empty){
				request.getSession().setAttribute("yingye", "此营业执照或组织机构代码已经注册！");
			}
				
				else {
				String userId = (String) PropertyUtils.getSimpleProperty(form,
						"userId");
				String password = (String) PropertyUtils.getSimpleProperty(
						form, "password");
				String rePassword = (String) PropertyUtils.getSimpleProperty(
						form, "rePassword");
				String compName = (String) PropertyUtils.getSimpleProperty(
						form, "compName");
				String compAddr = (String) PropertyUtils.getSimpleProperty(
						form, "compAddr");
				String compnum = (String) PropertyUtils.getSimpleProperty(form,
						"compnum"); // 2014-11-14 新加
				String comparea = (String) PropertyUtils.getSimpleProperty(
						form, "comparea"); // 2014-11-14 新加
				String mailPost = (String) PropertyUtils.getSimpleProperty(
						form, "mailPost");
				String telephone = (String) PropertyUtils.getSimpleProperty(
						form, "telephone");
				String linkman = (String) PropertyUtils.getSimpleProperty(form,
						"linkman");
				String cardnum = (String) PropertyUtils.getSimpleProperty(form,
						"cardnum"); // 2014-11-14 新加
				String mail = (String) PropertyUtils.getSimpleProperty(form,
						"mail");
				String workScope = (String) PropertyUtils.getSimpleProperty(form,"workScrope");
				String netAddress = (String) PropertyUtils.getSimpleProperty(form, "netAddress");
				String compIntro = (String) PropertyUtils.getSimpleProperty(form,"compIntro");
				String type = (String) PropertyUtils.getSimpleProperty(form,"type");
				String bd = (String) PropertyUtils.getSimpleProperty(form,"bd");
				String compcount = (String) PropertyUtils.getSimpleProperty(form,"compcount");
				String fax = (String) PropertyUtils.getSimpleProperty(form,"fax");
				String companyplace = (String) PropertyUtils.getSimpleProperty(form,"companyplace");
				BdCompkind kind=super.getInviteManager().findCompKindById(type);
				BdTrade trade=super.getInviteManager().findTradeById(bd);
				if (!password.equals(rePassword)) {
					ActionMessages messages = new ActionMessages();
					messages.add("differ", new ActionMessage(
							"loginForm.passfail"));
					saveErrors(request, messages);
					return mapping.findForward(forward);
				}
				DynaActionForm dyForm = (DynaActionForm) form;
				FormFile file = (FormFile) dyForm.get("uploadphoto1");
				FormFile file1 = (FormFile) dyForm.get("uploadphoto2");
				byte[] b = file.getFileData();
				String imageid = "";
				if (b.length > 0) {
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
			           
//			            if(b.length>0){
//							if(b.length>200*1024){
//								request.setAttribute("image", "toobig");
//								return mapping.findForward("return");
//							}
//						}
						
						
					
						System.out.print("b.lenth"+(b.length)/1024);
						
						CompImage compImage = new CompImage();
						compImage.setCompImage(b);
						super.getInviteManager().saveCompImage(compImage);
						imageid = compImage.getId().toString();

					}
					
					
//					image = super.getInviteManager().findCompImageById(imageid);
				
				byte[] b1 = file1.getFileData();
				if (b1.length > 0) {

					String path="/image/temp";
					  String realPath=request.getSession().getServletContext().getRealPath(path);
					  File dir=new File(realPath);
					  if(!dir.exists()) dir.mkdir();//判断该目录是否存在，不存在则创建
					  
					  //设置要进行保存的文件名称，防止出现重复文件名称，通过uuid确定其文件名的唯一性
					  String fileName=UUID.randomUUID().toString()+"."+getFileExt(file1);//uuid+源文件后缀

					File saveFile=new File(dir,fileName);//创建文件对象，在dir目录下的fileName这个文件
					  FileOutputStream fos=new FileOutputStream(saveFile);//创建一个到saveFile中的输出流
					  fos.write(file1.getFileData());
					  int scale=(int) Math.sqrt(file1.getFileData().length/(200*1024));
					 
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
			          b1=new byte[len];
			            ios.read(b1, 0, len);
			            ios.close();
			            imgfile.delete();
			           
//			            if(b.length>0){
//							if(b.length>200*1024){
//								request.setAttribute("image", "toobig");
//								return mapping.findForward("return");
//							}
//						}
						
						
					
						System.out.print("b1.lenth"+(b1.length)/1024);
					
						CompImage idcardImage = new CompImage();
						idcardImage.setCompImage(b1);
						super.getInviteManager().saveCompImage(idcardImage);
						imageid =imageid+","+ idcardImage.getId().toString();
				  
					
					//image = super.getInviteManager().findCompImageById(imageid);
				}
				CompBespeak compBespeak = new CompBespeak();
				compBespeak.setCompAddr(compAddr);
				compBespeak.setComparea(comparea);
				compBespeak.setCompnum(compnum);
				compBespeak.setCardnum(cardnum);
				compBespeak.setCompName(compName);
				compBespeak.setLinkman(linkman);
				compBespeak.setMail(mail);
				compBespeak.setMailPost(mailPost);
				compBespeak.setFkcompanyimage(imageid);
				compBespeak.setCompanyplace(companyplace);
				// md5
				String md5Password = DigestUtils.md5Hex(password);
				compBespeak.setPassword(md5Password);
				compBespeak.setTelephone(telephone);
				compBespeak.setUserId(userId);
				compBespeak.setPv(0);
				super.getInviteManager().saveCompBespeak(compBespeak);
				CompInfo compInfo = new CompInfo();
				compInfo.setBd(trade);
				compInfo.setType(kind);
				compInfo.setComp(compBespeak);
				compInfo.setNetAddress(netAddress);
				compInfo.setWorkScrop(workScope);
				compInfo.setCompIntro(compIntro);
				compInfo.setDr("0");
				compInfo.setCompcount(compcount);
				compInfo.setFax(fax);
				super.getInviteManager().saveCompInfo(compInfo);
				forward = IConstants.SUCCESS_KEY;
			}
		} catch (Exception be) {
			logger.error(be.getMessage(), be);
			throw new Exception(be);

		}
		return mapping.findForward(forward); // 返回页。
	}

	private List<CompBespeak> authenticate(ActionForm form) throws Exception {
		String userId = (String) PropertyUtils
				.getSimpleProperty(form, "userId");
		// List list = null;
		List<CompBespeak> list = super.getInviteManager().queryCompUserById(
				userId);
		return list;
	}
	private List<CompBespeak> empty(ActionForm form) throws Exception {
		String compnum = (String) PropertyUtils
				.getSimpleProperty(form, "compnum");
		// List list = null;
		List<CompBespeak> list = super.getInviteManager().queryCompUserBycompnum(
				compnum);
		return list;
	}
	public static String getFileExt(FormFile file)
	 {
	  String fileName=file.getFileName();
	  return fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();
	 }
	
}
