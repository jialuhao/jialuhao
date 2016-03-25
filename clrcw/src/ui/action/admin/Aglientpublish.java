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
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyJobInfo;
import model.Areacode;
import model.BdCompkind;
import model.BdEducate;
import model.BdJob;
import model.BdPost;
import model.BdTrade;
import model.Commoncode;
import model.CompBespeak;
import model.CompImage;
import model.CompInfo;
import model.CompResume;
import model.CompService;
import model.ManaUser;
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

public class Aglientpublish extends BaseAction{
	private static Logger logger = Logger.getLogger(Aglientpublish.class);
	public ActionForward aglientpublish(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			HttpSession session = request.getSession();
			
			String name = request.getParameter("qname");
			String loginName=(String)session.getAttribute(IConstants.ADMIN_USER_ID);
			List list=super.getInviteManager().findManaUserByName(loginName);
			ManaUser manaUser=(ManaUser)list.get(0);
			int pn = 0;
			int pageSize = 10;                               
			PaginationSupport vvv = super.getInviteManager().paginationshowAllCompany(loginName, name,manaUser.getAreacode() ,pn, pageSize, true );
			int contunt = vvv.getTotalCount();
			int pc = 0;
			if (vvv.getTotalCount() == 10)
				pc = 0;
			else {
				pc = (int) Math.ceil(vvv.getTotalCount() / pageSize);
				if(vvv.getTotalCount()%pageSize==0){
					pc=pc-1;
				}
			}
			session.removeAttribute("totleCount");
			session.removeAttribute("bespeak");
			session.removeAttribute("pagenum");
			session.removeAttribute("zongshu");
			session.setAttribute("bespeak", vvv.getItems());
			session.setAttribute("pagenum", pn);
			session.setAttribute("totleCount", pc);
			session.setAttribute("zongshu", contunt);
			session.setAttribute("qname", name);
			

		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward("aglientpublish");
	}
	public ActionForward nextfindaglient(ActionMapping mapping,
			ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try{
			HttpSession session = request.getSession();
			String account=(String)session.getAttribute(IConstants.ADMIN_USER_ID) ;//得到管理员名
		String name = request.getParameter("qname");
		String area = request.getParameter("area");

		int pageSize = 10;
		String pnum = request.getParameter("pnum");// 页码
		
		int ppp = (Integer) session.getAttribute("totleCount");
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
		PaginationSupport vvv = super.getInviteManager()
				.paginationshowAllCompany(account,name,area, ddd, pageSize, false);
		int contunt = vvv.getTotalCount();
		List list = (List) vvv.getItems();
		session.removeAttribute("bespeak");
		session.removeAttribute("pagenum");
		session.removeAttribute("zongshu");
		session.setAttribute("bespeak", list);
		session.setAttribute("pagenum", ddd);
		session.setAttribute("zongshu", contunt);
		session.setAttribute("qname", name);
		} catch (Exception ex) {
			logger.error("系统异常:", ex);
			throw new BaseException(ex);

		}

		return mapping.findForward("aglientpublish");
	}
	/**
	 * 企业注册页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public ActionForward companyjsp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

				HttpSession session = request.getSession();
				request.getSession().setAttribute("cunzai", "");
				request.getSession().setAttribute("yingye", "");
		  	  try{   
		  		List list= super.getInviteManager().findAllAreaCode();
		  		List<BdCompkind> bdCompkind=super.getInviteManager().findAllBdCompKind();
		 		List<BdTrade> bdTrade=super.getInviteManager().findAllBdTrade();
		 		session.setAttribute("bdCompkind", bdCompkind);
		 		session.setAttribute("bdTrade", bdTrade);
		  		session.setAttribute("arealist", list);
		 	
		        }catch(BusinessException be){	
		        	logger.error(be.getMessage(),be);
		        	throw new BaseException(be);
		     	      
		        }catch(Exception ex){
		        	logger.error("系统异常:",ex);   
		        	throw new BaseException(ex);
		        }
		        	return mapping.findForward("companyjsp"); //返回页。
				}
	/**
	 * 注册信息后保存
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward companyRegist1(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		HttpSession session = request.getSession(true);
				try {
					String account=(String)session.getAttribute(IConstants.ADMIN_USER_ID) ;//得到管理员名	
		            boolean empty=this.empty(form).isEmpty();
					
						
					  if(!empty){
						request.getSession().setAttribute("yingye", "此营业执照或组织机构代码已经注册！");
						return mapping.findForward("failed");
					  }
						
						else {
						
						String compName = (String) PropertyUtils.getSimpleProperty(
								form, "compName");
						String compAddr = (String) PropertyUtils.getSimpleProperty(
								form, "compAddr");
						String compnum = (String) PropertyUtils.getSimpleProperty(form,
								"compnum"); // 2014-11-14 新加
						session.setAttribute("compnum", compnum);
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
					           
//					            if(b.length>0){
//									if(b.length>200*1024){
//										request.setAttribute("image", "toobig");
//										return mapping.findForward("return");
//									}
//								}
								
								
							
								System.out.print("b.lenth"+(b.length)/1024);
								
								CompImage compImage = new CompImage();
								compImage.setCompImage(b);
								super.getInviteManager().saveCompImage(compImage);
								imageid = compImage.getId().toString();

							}
							
							
//							image = super.getInviteManager().findCompImageById(imageid);
						
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
					           
//					            if(b.length>0){
//									if(b.length>200*1024){
//										request.setAttribute("image", "toobig");
//										return mapping.findForward("return");
//									}
//								}
								
								
							
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
						compBespeak.setUserId(compnum);
						compBespeak.setCardnum(cardnum);
						compBespeak.setCompName(compName);
						compBespeak.setLinkman(linkman);
						compBespeak.setMail(mail);
						compBespeak.setMailPost(mailPost);
						compBespeak.setFkcompanyimage(imageid);
						compBespeak.setTelephone(telephone);
						compBespeak.setCompStatus("1");
						compBespeak.setCompanyplace(companyplace);
						compBespeak.setPv(0);
						compBespeak.setAglientcode(account);
						session.setAttribute(IConstants.COMP_USER_ID, compnum);
						List<BdPost> bdPost=super.getInviteManager().findAllBdPost();
						List<BdJob> bdJob=super.getInviteManager().findAllBdJob();
				 		List<BdCompkind> bdCompkind=super.getInviteManager().findAllBdCompKind();
				 		List<BdTrade> bdTrade=super.getInviteManager().findAllBdTrade();
				 		List<BdEducate> bdEducate=super.getInviteManager().findAllBdEducate();
				 		List<Areacode> areacode=super.getInviteManager().findAllAreaCode();
				 	
				 		
				 		session.setAttribute("bdPost", bdPost);
				 		session.setAttribute("bdJob", bdJob);
				 		session.setAttribute("bdCompkind", bdCompkind);
				 		session.setAttribute("bdTrade", bdTrade);
				 		session.setAttribute("bdEducate", bdEducate);
				 		session.setAttribute("areacode", areacode);
				 		session.setAttribute("compBespeakInfo", compBespeak);
						super.getInviteManager().saveCompBespeak(compBespeak);
						compBespeak.setCompStatus("1");
						super.getInviteManager().updateCompBespeak(compBespeak);
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
					}
				} catch (Exception be) {
					logger.error(be.getMessage(), be);
					throw new Exception(be);

				}
				return mapping.findForward("companyRegist2"); // 返回页。
			}
	
	private List<CompBespeak> empty(ActionForm form) throws Exception {
		String compnum = (String) PropertyUtils
				.getSimpleProperty(form, "compnum");
		// List list = null;
		List<CompBespeak> list = super.getInviteManager().queryCompUserBycompnum(
				compnum);
		return list;
	}
	/**
     * 
     * 描述：保存企业详细信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward companyRegist2(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		
		try {
	       	
			HttpSession session = request.getSession(false);
			CompBespeak compBespeak=(CompBespeak)session.getAttribute("compBespeakInfo");
		   
			String workScope = (String) PropertyUtils.getSimpleProperty(form,"workScrope");
			String netAddress = (String) PropertyUtils.getSimpleProperty(form, "netAddress");
			String compIntro = (String) PropertyUtils.getSimpleProperty(form,"compIntro");
			String type = (String) PropertyUtils.getSimpleProperty(form,"type");
			String bd = (String) PropertyUtils.getSimpleProperty(form,"bd");
			String compcount = (String) PropertyUtils.getSimpleProperty(form,"compcount");
			String fax = (String) PropertyUtils.getSimpleProperty(form,"fax");
			BdCompkind kind=super.getInviteManager().findCompKindById(type);
			BdTrade trade=super.getInviteManager().findTradeById(bd);
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
			super.getInviteManager().updateCompInfo(compInfo);
			
			
			
		}catch(BusinessException be){
	       	   logger.error(be.getMessage(),be);
	       	   throw new BaseException(be);
	       	   
	          } catch(Exception ex){
	       	   logger.error("系统异常:",ex);
	       	   throw new BaseException(ex);
		}
		return mapping.findForward("companyRegist2");
		
	}
	/**
     * 
     * 描述：跳转到企业基本情况页面
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward companyShowInfo(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException {
		try{
			
			HttpSession session = request.getSession();	
		
		 	
		 		//HttpSession session=request.getSession();
		 		
		 		CompBespeak compBespeak=(CompBespeak)session.getAttribute("compBespeakInfo");
		 		String compname=compBespeak.getCompName();
		 		String area=	compBespeak.getComparea();
				   Areacode areacode1=super.getInviteManager().findAreaCodeByarea(area);
				   String areaname=areacode1.getAreaname();
				  String compnum=(String) session.getAttribute("compnum");
				   List<CompBespeak> list= super.getInviteManager().queryCompUserBycompnum(compnum);
				   CompBespeak compBespeak11=list.get(0);
				   List<BdPost> bdPost=super.getInviteManager().findAllBdPost();
					List<BdJob> bdJob=super.getInviteManager().findAllBdJob();
			 		List<BdCompkind> bdCompkind=super.getInviteManager().findAllBdCompKind();
			 		List<BdTrade> bdTrade=super.getInviteManager().findAllBdTrade();
			 		List<BdEducate> bdEducate=super.getInviteManager().findAllBdEducate();
			 		List<Areacode> areacode=super.getInviteManager().findAllAreaCode();
			 	
			 		
			 		session.setAttribute("compname",compname);
			 		session.setAttribute("bdPost", bdPost);
			 		session.setAttribute("bdJob", bdJob);
			 		session.setAttribute("bdCompkind", bdCompkind);
			 		session.setAttribute("bdTrade", bdTrade);
			 		session.setAttribute("bdEducate", bdEducate);
			 		session.setAttribute("areacode", areacode);
			 		session.setAttribute("compBespeakInfo", compBespeak);
			 		session.setAttribute(IConstants.COMP_USER_ID, compnum);
		 		Integer beaspeakId=compBespeak11.getId();
		 		CompInfo info=super.getInviteManager().findCompInfoById(beaspeakId.toString());
		 		if(info==null){
		 			return mapping.findForward("companyRegist1");
		 		}else{
		 		session.setAttribute("compBespeakId", beaspeakId);
		 			
		 		Integer compId=info.getId();
		 			String kindId=info.getType().getId().toString();
		 			String tradeId=info.getBd().getId().toString();
		 			BdCompkind kind=super.getInviteManager().findCompKindById(kindId); 
		 			BdTrade trade=super.getInviteManager().findTradeById(tradeId);
		 			info.setBd(trade);
		 			info.setType(kind);
		 			session.setAttribute("compInfo", info);
		 			session.setAttribute("compId", compId);
		 			session.setAttribute("areaname", areaname);
		 			return mapping.findForward("show");
		 		}
			}catch(BusinessException be){
	       	  logger.error(be.getMessage(),be);
	       	  throw new BaseException(be);
			} catch(Exception ex){
	       	  logger.error("系统异常:",ex);
	       	  throw new BaseException(ex);
		}
	}
	/**
     * 
     * 描述：修改企业详细信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward update(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException {
	
		
		try {
	       	
			HttpSession session = request.getSession(false);
			String keyId=((Integer)session.getAttribute("compId")).toString();
			CompBespeak compBespeak=(CompBespeak)session.getAttribute("compBespeakInfo");			
			String workScope = (String) PropertyUtils.getSimpleProperty(form,"workScrope");
			String netAddress = (String) PropertyUtils.getSimpleProperty(form, "netAddress");
			String compIntro = (String) PropertyUtils.getSimpleProperty(form,"compIntro");
			String compcount = (String) PropertyUtils.getSimpleProperty(form,"compcount");
			String fax = (String) PropertyUtils.getSimpleProperty(form,"fax");
			String type = (String) PropertyUtils.getSimpleProperty(form,"type");
			String bd = (String) PropertyUtils.getSimpleProperty(form,"bd");
			
			String companyplace=(String) PropertyUtils.getSimpleProperty(form,"companyplace");
			String comparea = (String) PropertyUtils.getSimpleProperty(form,"comparea");
			
			
			String mailPost = (String) PropertyUtils.getSimpleProperty(form,"mailPost");
			String linkman = (String) PropertyUtils.getSimpleProperty(form,"linkman");
			String cardnum = (String) PropertyUtils.getSimpleProperty(form,"cardnum");
			String telephone = (String) PropertyUtils.getSimpleProperty(form,"telephone");
			String mail = (String) PropertyUtils.getSimpleProperty(form,"mail");
			
	
			compBespeak.setComparea(comparea);
			compBespeak.setCompanyplace(companyplace);
			
			compBespeak.setMailPost(mailPost);
			compBespeak.setLinkman(linkman);
			compBespeak.setCardnum(cardnum);
			compBespeak.setTelephone(telephone);
			compBespeak.setMail(mail);
			super.getInviteManager().updateCompBespeak(compBespeak);
			BdCompkind kind=super.getInviteManager().findCompKindById(type);
			BdTrade trade=super.getInviteManager().findTradeById(bd);
			
			CompInfo compInfo = super.getInviteManager().findCompById(keyId);
			compInfo.setBd(trade);
			compInfo.setType(kind);
			compInfo.setComp(compBespeak);
			compInfo.setNetAddress(netAddress);
			compInfo.setWorkScrop(workScope);
			compInfo.setCompIntro(compIntro);
			compInfo.setCompcount(compcount);
			compInfo.setFax(fax);
			//compInfo.setDr("0");
			super.getInviteManager().updateCompInfo(compInfo);
			
			
			
			ActionMessages messages=new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("update.ok"));
			saveErrors(request, messages);
			
			
		}catch(BusinessException be){
	       	   logger.error(be.getMessage(),be);
	       	   throw new BaseException(be);
	       	   
	          } catch(Exception ex){
	       	   logger.error("系统异常:",ex);
	       	   throw new BaseException(ex);
		}
		return mapping.findForward("update");
		
	}
	/**
     * 
     * 描述：在页面中显示企业招聘信息  
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward showPubJob(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException{
		
		
	try {
		HttpSession session=request.getSession();
		Integer coId=(Integer)session.getAttribute("compId");
		if(coId==null){
				ActionMessages messages=new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.return"));
				saveErrors(request, messages);
				return mapping.findForward("return");
		}
		else{
			String userId=(String)session.getAttribute(IConstants.COMP_USER_ID);
			List<?> list=super.getInviteManager().queryJobInfoById(userId);
			List<PublishJobInfo> jobInfo=new ArrayList<PublishJobInfo>();
			for(int i=0;i<list.size();i++){
				Object[] o=(Object[])list.get(i);
				PublishJobInfo job=(PublishJobInfo)o[0];
				
				jobInfo.add(job);
			}
			List<Commoncode> commonCodelist=super.getInviteManager().findAllCommonCode();
			   
	    	for(int i=0;i<commonCodelist.size();i++){
	    		Commoncode commoncode=new Commoncode();
	    		commoncode=commonCodelist.get(i);            
	    		if("65".equals(commoncode.getId()+""))
	    			request.setAttribute("compdays",commoncode.getCommonvalues());
	    		if("66".equals(commoncode.getId()+""))
	    			request.setAttribute("gongzi",commoncode.getCommonvalues());
	    	}
			session.setAttribute("job",jobInfo);
			List arealist= super.getInviteManager().findAllAreaCode();
			session.setAttribute("arealist",arealist);
			List salarylist= super.getInviteManager().findAllSalary();
			session.setAttribute("salarylist",salarylist);
			List bdPost=super.getInviteManager().findAllBdPost();
			session.setAttribute("bdPost",bdPost);
			}
		}catch(BusinessException be){
				logger.error(be.getMessage(),be);
				throw new BaseException(be);
    	   
		}catch(Exception ex){
				logger.error("系统异常:",ex);
				throw new BaseException(ex);
		}
			return mapping.findForward("showPubJob");
	}		
	/**
     * 
     * 描述：添加企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward addPubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
				
			try {
				HttpSession session=request.getSession();
				
					String jobId = (String) PropertyUtils.getSimpleProperty(form, "jobId");
					String postId = (String) PropertyUtils.getSimpleProperty(form, "postId");
					String num = (String) PropertyUtils.getSimpleProperty(form, "num");
					String intro = (String) PropertyUtils.getSimpleProperty(form, "intro");
					String sTime = (String) PropertyUtils.getSimpleProperty(form, "sTime");
					String eTime = (String) PropertyUtils.getSimpleProperty(form, "eTime");
					String sex = (String) PropertyUtils.getSimpleProperty(form, "sex");
					String age = (String) PropertyUtils.getSimpleProperty(form, "age");
					String grading = (String) PropertyUtils.getSimpleProperty(form, "grading");
					String education = (String) PropertyUtils.getSimpleProperty(form, "education");
					String experience = (String) PropertyUtils.getSimpleProperty(form, "experience");
					String money = (String) PropertyUtils.getSimpleProperty(form, "money");
					String nature = (String) PropertyUtils.getSimpleProperty(form, "nature");
					String workarea = (String) PropertyUtils.getSimpleProperty(form, "workarea");
					String welfare = (String) PropertyUtils.getSimpleProperty(form, "welfare");
					//String address=(String) PropertyUtils.getSimpleProperty(form,"address");
					String addresss=(String)request.getParameter("address");
					String userId=(String)session.getAttribute(IConstants.COMP_USER_ID);
					Integer compBespeakId=(Integer)session.getAttribute("compBespeakId");
					CompInfo comp=super.getInviteManager().findCompInfoById(compBespeakId.toString());
					BdJob job=super.getInviteManager().findJobById(jobId);
					BdEducate educate=super.getInviteManager().findEducateById(education);
					BdPost post=super.getInviteManager().findPostById(postId);
					PublishJobInfo publishJobInfo=new PublishJobInfo();
					publishJobInfo.setJob(job);
					publishJobInfo.setPkComp(comp);
					publishJobInfo.setPost(post);
					publishJobInfo.setCompLoginId(userId);
					publishJobInfo.setJobAmount(num);
					publishJobInfo.setJobDesc(intro);
					publishJobInfo.setPublishTime(sTime);
					publishJobInfo.setCloseTime(eTime);
					publishJobInfo.setEngageSex("1");
					publishJobInfo.setAgeLimit(age);
					publishJobInfo.setGrading(grading);//毕业生
					publishJobInfo.setEducation(educate);
					publishJobInfo.setWorkYear(experience);
					publishJobInfo.setSalary(money);
					publishJobInfo.setNature(nature);
					publishJobInfo.setWorkarea(workarea);
					publishJobInfo.setWelfare(welfare);
					publishJobInfo.setAddress(addresss);
					publishJobInfo.setValidflag("1");
					publishJobInfo.setStatus("2");
					
					//publishJobInfo.setValidtime(validtime);
					super.getInviteManager().savePublishJobInfo(publishJobInfo);
					return mapping.findForward("showInfo");
				} catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);
	    	   
				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
			}
				
				
			}
	/**
     * 
     * 描述：修改一条企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward updatePubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		HttpSession session=request.getSession();
		try{
				String id=request.getParameter("id");
				PublishJobInfo job=super.getInviteManager().findPublishJobById(id);
				List arealist= super.getInviteManager().findAllAreaCode();
				request.setAttribute("arealist",arealist);
				List salarylist= super.getInviteManager().findAllSalary();
				session.setAttribute("salarylist",salarylist);
				session.setAttribute("oneJob",job);
				session.setAttribute("keyId",id);
				return mapping.findForward("updatemessage");
				} catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);
	   
				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
	}

	/**
     * 
     * 描述：修改后保存一条企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward savePubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String jobId = (String) PropertyUtils.getSimpleProperty(form, "jobId");
			String postId = (String) PropertyUtils.getSimpleProperty(form, "postId");
			String num = (String) PropertyUtils.getSimpleProperty(form, "num");
			String intro = (String) PropertyUtils.getSimpleProperty(form, "intro");
			String sTime = (String) PropertyUtils.getSimpleProperty(form, "sTime");
			String eTime = (String) PropertyUtils.getSimpleProperty(form, "eTime");
			String sex = (String) PropertyUtils.getSimpleProperty(form, "sex");
			String age = (String) PropertyUtils.getSimpleProperty(form, "age"); 
			String grading = (String) PropertyUtils.getSimpleProperty(form, "grading");
			String education = (String) PropertyUtils.getSimpleProperty(form, "education");
			String experience = (String) PropertyUtils.getSimpleProperty(form, "experience");
			String money = (String) PropertyUtils.getSimpleProperty(form, "money");
			String keyId=(String)PropertyUtils.getSimpleProperty(form, "infoKeyId");
			String nature = (String) PropertyUtils.getSimpleProperty(form, "nature");
			String workarea = (String) PropertyUtils.getSimpleProperty(form, "workarea");
			String welfare = (String) PropertyUtils.getSimpleProperty(form, "welfare");
			String address=(String)request.getParameter("address");
			
			PublishJobInfo publishJobInfo=super.getInviteManager().findPublishJobById(keyId);
			BdJob job=super.getInviteManager().findJobById(jobId);
			BdEducate educate=super.getInviteManager().findEducateById(education);
			BdPost post=super.getInviteManager().findPostById(postId);
			publishJobInfo.setPost(post);
			publishJobInfo.setJob(job);
			publishJobInfo.setEducation(educate);
		//	publishJobInfo.setPost(post);
			publishJobInfo.setJobAmount(num);
			publishJobInfo.setJobDesc(intro);
			publishJobInfo.setPublishTime(sTime);
			publishJobInfo.setCloseTime(eTime);
			publishJobInfo.setEngageSex(sex);
			publishJobInfo.setAgeLimit(age);
			publishJobInfo.setGrading(grading);//毕业生
			publishJobInfo.setEducation(educate);
			publishJobInfo.setWorkYear(experience);
			publishJobInfo.setSalary(money);
			publishJobInfo.setDr("0");
			publishJobInfo.setNature(nature);
			publishJobInfo.setWorkarea(workarea);
			publishJobInfo.setWelfare(welfare);
			publishJobInfo.setAddress(address);
			
			
			super.getInviteManager().updatePublishJobInfo(publishJobInfo);
			return mapping.findForward("showInfo");
		} catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
	   
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}
	/**
     * 
     * 描述：删除一条企业招聘信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward delPubJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String id=request.getParameter("id");
			PublishJobInfo job=new PublishJobInfo();
			job=super.getInviteManager().findPublishJobById(id);
			super.getInviteManager().delPublishJobInfo(job);
			return mapping.findForward("showInfo");
			} catch(BusinessException be){
				logger.error(be.getMessage(),be);
				throw new BaseException(be);
   
			}catch(Exception ex){
				logger.error("系统异常:",ex);
				throw new BaseException(ex);
			}
}
	/**
     * 
     * 描述：招聘信息的延期（延长时间为6个月）
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward postponeJob(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String id=request.getParameter("id");
			PublishJobInfo job=super.getInviteManager().findPublishJobById(id);
			String time1=job.getCloseTime();
			//算出延期后的有效期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start=sdf.parse(time1);
		    Calendar calender = Calendar.getInstance();
		    calender.setTime(start);
		    calender.add(Calendar.MONTH, 6);
		    String  validtime=  sdf.format(calender.getTime());
		    job.setCloseTime(validtime);
			super.getInviteManager().updatePublishJobInfo(job);
			return mapping.findForward("showInfo");
		} catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}
	/**
     * 
     * 描述：结束招聘
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward savePubJobflag(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			String id=request.getParameter("id");
			
//			PublishJobInfo job=new PublishJobInfo();
//			job=super.getInviteManager().findPublishJobById(id);
//			
//			super.getInviteManager().updatePublishJobInfo(job);
     		HttpSession session=request.getSession();
			session.setAttribute("jobid", id);
			return mapping.findForward("showServicelog");
		} catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}
	/**
     * 
     * 描述：
     * （招聘成功或失败后的入库）
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward saveServicelog(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			
			String sname=request.getParameter("sname");//姓名
			String disnumber=request.getParameter("disnumber");//残疾证号
			String phone=request.getParameter("phone");// 
			String house=request.getParameter("house");//户籍
			String workname=request.getParameter("workname");
			String remark=request.getParameter("remark");// 
			String losewhyobj=request.getParameter("losewhyobj");//未招用原因
			String otherwhy=request.getParameter("otherparts");
			String validflag=request.getParameter("validflag");
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("jobid");	
		
			String[] snames=null;
			String[] phones=null;
			String[] disnumbers=null;
			String[] houses=null;
			String[] worknames=null;
			String[] remarks=null;
			
			if(sname!=null){
				snames=sname.split(",");
			}
			if(phone!=null){
				phones=phone.split(",");
			}
			if(disnumber!=null){
				disnumbers=disnumber.split(",");
			}
			if(house!=null){
				houses=house.split(",");
			}
			if(workname!=null){
				worknames=workname.split(",");
			}
			if(remark!=null){
				remarks=remark.split(",");
			}
			if("3".equals(validflag)){
				for(int i=0;i<snames.length&&snames[i]!=null;i++){
					CompService compservice=new CompService();
					compservice.setName(snames[i]);
					compservice.setNumber(disnumbers[i]);
					compservice.setPhone(phones[i]);
					compservice.setHouse(houses[i]);
					compservice.setWorkname(worknames[i]);
					if(remarks.length>i){
						compservice.setRemark(remarks[i]);}
						else{
							compservice.setRemark("");
						}
					compservice.setPkjob(id);
					super.getInviteManager().saveCompservice(compservice);
					
					
				}
				
			}else if("2".equals(validflag)){
				CompService compservice=new CompService();
				compservice.setLosewhy(losewhyobj);
				compservice.setPkjob(id);
				compservice.setOtherwhy(otherwhy);
				super.getInviteManager().saveCompservice(compservice);
			}
			
			//修改招聘成功与否的状态
		
					
			if(validflag!=null&&validflag!=""){
			PublishJobInfo job=new PublishJobInfo();
			job=super.getInviteManager().findPublishJobById(id);
			job.setValidflag(validflag);
			super.getInviteManager().updatePublishJobInfo(job);}
			return mapping.findForward("showInfo");
		} catch(BusinessException be){
			logger.error(be.getMessage(),be);
			throw new BaseException(be);
	   
		}catch(Exception ex){
			logger.error("系统异常:",ex);
			throw new BaseException(ex);
	}
		
	}
	/**
	 * 查看代理过的企业信息
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
							String compid= (String) request.getParameter("apllyId");
							CompBespeak compBespeak=super.getInviteManager().findCompBespeakById(compid);
						
							String compnum=compBespeak.getCompnum();
							session.setAttribute("compnum", compnum);
							session.setAttribute("compBespeakInfo", compBespeak);
						} catch (Exception ex) {
							logger.error("系统异常:", ex);
							throw new BaseException(ex);
						}
						return mapping.findForward("companyRegist2");
					}
			/**
		     * 
		     * 描述：查看自己填写的招聘成功的信息
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward showOneServicelog(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws BaseException{
						try{
							String id=request.getParameter("jobid");
						
							List list=super.getInviteManager().findcompservicebyjobid(id);
							PublishJobInfo job=new PublishJobInfo();
							job=super.getInviteManager().findPublishJobById(id);
							String flag=job.getValidflag();
							request.getSession().setAttribute("list", list);
							request.getSession().setAttribute("flag", flag);
							return mapping.findForward("showservice");
			   
						}catch(Exception ex){
							logger.error("系统异常:",ex);
							throw new BaseException(ex);
						}
					}
			/**
			 * 
			 * 描述：在页面中显示个人求职信息（人才搜索）
			 * 
			 * @param mapping
			 * @param form
			 * @param request
			 * @param response
			 * @return ActionForward
			 * @throws BaseException
			 */
			public ActionForward showAll(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				try {
					HttpSession session = request.getSession();
					String compId = (String) session
					.getAttribute(IConstants.COMP_USER_ID);
					String search = request.getParameter("zhiwei");
					
					int pageIndex = 0;
					int pageSize = 5;
					boolean desc = true;
					PaginationSupport pagin = super.getInviteManager().paginationS(
							null, pageIndex, pageSize, desc);
					List<?> list = pagin.getItems();
					int personTotalCount = pagin.getTotalCount();
					int tpn = (int) Math.ceil((personTotalCount - 1) / pageSize)+1;
					List<ApplyJobInfo> all = new ArrayList<ApplyJobInfo>();
					ApplyJobInfo oneApply = new ApplyJobInfo();
					if (list == null)
						return mapping.findForward(IConstants.FAIL_KEY);
					else {
						for (int i = 0; i < list.size(); i++) {
							oneApply = (ApplyJobInfo) list.get(i);
							//判断是否已经加入人才库
							String createtime=oneApply.getCreateTime();
							createtime=createtime.substring(0, 10);
							oneApply.setCreateTime(createtime);
							String resumeKey = oneApply.getResumeCode().getId().toString();
							String isNo = super.getInviteManager().findFileByResumeId(
									resumeKey, compId);
							String a="未加入";
							if(isNo!=null&&"1".equals(isNo)){
								a="已加入";
							}
							oneApply.setIsNo(a);
							all.add(oneApply);
						}
						List arealist= super.getInviteManager().findAllAreaCode();
						session.setAttribute("arealist", arealist);

						session.setAttribute("allApplyJobInfo", all);
						session.setAttribute("pageIndex", pageIndex);
						
						session.removeAttribute("search");
						session.setAttribute("search", search);
						session.removeAttribute("personTotalCount");
						session.setAttribute("personTotalCount", personTotalCount);
						session.removeAttribute("tpn");
						session.setAttribute("tpn", tpn);
						return mapping.findForward("showAll");
					}
				} catch (BusinessException be) {
					logger.error(be.getMessage(), be);
					ActionMessages messages = new ActionMessages();
					messages.add("error", new ActionMessage("error.DB"));
					super.saveErrors(request, messages);
					return mapping.findForward(IConstants.ERROR_KEY);

				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					ActionMessages messages = new ActionMessages();
					messages.add("error", new ActionMessage("error.inform"));
					super.saveErrors(request, messages);
					return mapping.findForward(IConstants.ERROR_KEY);
				}
			}
			/**
			 * 
			 * 描述：显示其他页的信息
			 * 
			 * @param mapping
			 * @param form
			 * @param request
			 * @param response
			 * @return ActionForward
			 * @throws BaseException
			 */

			public ActionForward showOtherPage(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)
					throws BaseException {

				try {
					HttpSession session = request.getSession(true);
					
					String compId = (String) session
					.getAttribute(IConstants.COMP_USER_ID);
					 
					 String search = (String) request.getParameter("zhiwei");
					String workstate = (String) request.getParameter("workstate");
							
					String area = (String) (String) request.getParameter("area");
							
					String workarea = (String) request.getParameter("workarea");
							
					int pageSize = 5;
					// String pnum=(String)session.getAttribute("pageIndex");
					String pnum = (String) request.getParameter("pageIndex");
							

					int personTotalCount = (Integer) session
							.getAttribute("personTotalCount");
					int tpn = (int) Math.ceil(personTotalCount / pageSize);
					int pn = new Integer(pnum).intValue();
					int ddd;
					if (pn >= tpn) {
						ddd = tpn;
					} else if (pn <= 0) {
						ddd = 0;
					} else {
						ddd = pn;
					}
					ApplyJobInfo applyJobInfo = new ApplyJobInfo();
					model.BdJob jobCode = new model.BdJob();
					UserInfo userInfo = new UserInfo();
					userInfo.setArea(area);
					jobCode.setDr(workstate);
					jobCode.setJobName(search);
					applyJobInfo.setJobCode(jobCode);
					applyJobInfo.setWorkYear(workarea);
					applyJobInfo.setPersonCode(userInfo);
					PaginationSupport pagin = super.getInviteManager()
							.paginationStrategy(applyJobInfo, ddd, pageSize, true);
					List<?> list = pagin.getItems();
					List<ApplyJobInfo> all = new ArrayList<ApplyJobInfo>();
					ApplyJobInfo oneApply = new ApplyJobInfo();
					for (int i = 0; i < list.size(); i++) {
						oneApply = (ApplyJobInfo) list.get(i);
						String createtime=oneApply.getCreateTime();
						createtime=createtime.substring(0, 10);
						oneApply.setCreateTime(createtime);
						String resumeKey = oneApply.getResumeCode().getId().toString();
						String isNo = super.getInviteManager().findFileByResumeId(
								resumeKey, compId);
						String a="未加入";
						if(isNo!=null&&"1".equals(isNo)){
							a="已加入";
						}
						oneApply.setIsNo(a);
						all.add(oneApply);
					}
					List arealist= super.getInviteManager().findAllAreaCode();
					session.setAttribute("arealist", arealist);
					personTotalCount = pagin.getTotalCount();
					tpn = pagin.getPageCount();
					session.setAttribute("allApplyJobInfo", all);
					session.setAttribute("pageIndex", ddd);
					session.removeAttribute("personTotalCount");
					session.setAttribute("personTotalCount", personTotalCount);
					session.removeAttribute("tpn");
					session.setAttribute("tpn", tpn);
					session.setAttribute("search", search);
					session.setAttribute("area", area);
					session.setAttribute("workarea", workarea);
					session.setAttribute("workstate", workstate);

					
					return mapping.findForward("showAll");
				} catch (BusinessException be) {
					logger.error(be.getMessage(), be);
					throw new BaseException(be);
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
			}
			/**
			 * 
			 * 描述：查看个人的详细资料
			 * 
			 * @param mapping
			 * @param form
			 * @param request
			 * @param response
			 * @return ActionForward
			 * @throws BaseException
			 */
			public ActionForward showPersonInfo(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				try {
					HttpSession session = request.getSession();
					String applyKeyId = request.getParameter("applyKeyId");
					String compId = (String) session
							.getAttribute(IConstants.COMP_USER_ID);
					if (compId == null) {
						ActionMessages messages = new ActionMessages();
						messages.add("loginfirst", new ActionMessage("login.first"));
						super.saveErrors(request, messages);
						return mapping.findForward(IConstants.FAIL_KEY);
					} else {
						List<?> list = super.getInviteManager().findApplyJobInfoById(
								applyKeyId);
						ApplyJobInfo Ajob = new ApplyJobInfo();
						if (list != null) {
							Object[] o = (Object[]) list.get(0);
							Ajob = (ApplyJobInfo) o[0];
						}
						// 得到用户主键UserKey，登录名loginId
						String UserKey = Ajob.getPersonCode().getId().toString();
						UserInfo user = new UserInfo();
						user = super.getInviteManager().findUserById(UserKey);

						String resumeKey = Ajob.getResumeCode().getId().toString();
						String isNo = super.getInviteManager().findFileByResumeId(
								resumeKey, compId);
						if (isNo == null)
							isNo = "3";
						String loginId = user.getLoginId();
						List<?> compResumelist = super.getInviteManager()
								.queryPersonResume(loginId);
						PersonResume personResume = new PersonResume();
						if (compResumelist != null) {
							Object[] o = (Object[]) compResumelist.get(0);
							personResume = (PersonResume) o[0];
						}
						if (personResume.getPv() == null) {
							personResume.setPv(1);
						} else {
							personResume.setPv(personResume.getPv() + 1);
						}
						super.getInviteManager().updatePersonResume(personResume);
						List<PersonResumeB> list3 = super.getInviteManager()
								.findPersonResumesById(loginId);
						List educations = super.getInviteManager().findEducationsById(loginId);
						session.setAttribute("educations", educations);
						session.setAttribute("isNo", isNo);
						session.setAttribute("applyJob", Ajob);
						session.setAttribute("ResumeB", list3);

						return mapping.findForward("showPersonInfo");
					}
				} catch (BusinessException be) {
					logger.error(be.getMessage(), be);
					throw new BaseException(be);
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
			}

			/**
			 * 
			 * 描述：将个人加入人才库
			 * 
			 * @param mapping
			 * @param form
			 * @param request
			 * @param response
			 * @return ActionForward
			 * @throws BaseException
			 */
			public ActionForward join(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws BaseException {
				try {
					HttpSession session = request.getSession();
					String compLoginId = (String) session
							.getAttribute(IConstants.COMP_USER_ID);
					String ResumeId = request.getParameter("ResumeId");
					PersonResume Presume = new PersonResume();
					List<?> listP = super.getInviteManager().findPersonResumeById(
							ResumeId);
					if (listP != null && listP.size() != 0) {
						Object[] o = (Object[]) listP.get(0);
						Presume = (PersonResume) o[0];
					}
					CompResume Cresume = new CompResume();
					Cresume.setCompLoginId(compLoginId);
					Cresume.setPkResume(Presume);
					Cresume.setFile(IConstants.PERSON_DATABASE);
					super.getInviteManager().saveCompResumeFile(Cresume);
					return mapping.findForward("join");
				} catch (BusinessException be) {
					logger.error(be.getMessage(), be);
					throw new BaseException(be);
				} catch (Exception ex) {
					logger.error("系统异常:", ex);
					throw new BaseException(ex);
				}
			}
			/**
		     * 
		     * 描述：显示尚无意向简历库第一页
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward showCompResume(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
				String forward = IConstants.FAIL_KEY;
				try{
					String Resumestatus="0";
					HttpSession session=request.getSession();
					session.removeAttribute("Resumestatus");
					session.setAttribute("Resumestatus", Resumestatus);
					String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
					
					int pageIndex=0;
		 		   	int pageSize=5;
		 		   	boolean desc=true;
					
		 		 //企业简历库数据  
		   		 PaginationSupport pagin=super.getInviteManager().paginationCompResume(compLoginName, Resumestatus, pageIndex, pageSize, desc);
		   		 List<?> list=pagin.getItems();
		   		 int totalCount=pagin.getTotalCount();
		   		 //计算总的页数tpp
		   		 int tpp=(int) Math.ceil((totalCount-1)/pageSize);
				 List<CompResume> allResume=new ArrayList<CompResume>();
				 CompResume oneResume=new CompResume();
		   		 if(list==null)
		   			allResume=null;
		   		 else{
		   		 	for(int i=0;i<list.size();i++)
		   		 		{
		   		 		oneResume=(CompResume)list.get(i);
		   		 	String time=oneResume.getCreatetime();
		   		 	time=time.substring(0,10);
		   		    oneResume.setCreatetime(time);
		   		 	String username=oneResume.getPkResume().getUser().getLoginId();
		   		 Boolean reg=false;
			  	   
					List login = (List) super.getInviteManager().findUserByName(
							username);
					UserInfo userInfo = (UserInfo) login.get(0);
					String id = userInfo.getId() + "";
					List vvv = super.getInviteManager().findPersonResumeById(id);
					Object[] ttt1 = (Object[]) vvv.get(0);
					PersonResume personResume = (PersonResume) ttt1[0];
	             String state=personResume.getState();
					if(state==null||"0".equals(state)||"1".equals(state)){
	           reg=false;
	         }else{
	     	   reg=true; 
	         }
					oneResume.setReg(reg);
		   		 		allResume.add(oneResume);
		   		 		}
		   		 
		   		 	session.setAttribute("allResume", allResume);
		   		 	session.setAttribute("pageIndex", pageIndex);
		   		 	session.removeAttribute("totalCount");
		   		 	session.setAttribute("totalCount", totalCount);
		   		 	session.removeAttribute("tpp");
		   		 	session.setAttribute("tpp", tpp);
		   		}
		   		 
				
				}catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);

				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("showCompResume");
			}	
			/**
		     * 
		     * 描述：删除一份简历
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward delOneResume(ActionMapping mapping, ActionForm form,

					HttpServletRequest request, HttpServletResponse response) throws BaseException{
				try{
					String id=request.getParameter("keyId");
					CompResume one=super.getInviteManager().findCompResumeById(id);
					super.getInviteManager().delCompResume(one);
					return mapping.findForward("OneResume");
				
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
		     * 描述：显示一份详细简历
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward showOneResume(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws BaseException{
						try{
							String userKeyId=request.getParameter("userKeyId");
							String compResumekeyId=request.getParameter("compResumekeyId");
							HttpSession session=request.getSession();
							session.removeAttribute("compResumekeyId");
							session.setAttribute("compResumekeyId", compResumekeyId);
							UserInfo  user=new UserInfo();
							PersonResume resume=new PersonResume();
							PersonResumeB resumeB=new PersonResumeB();
							CompResume one=super.getInviteManager().findCompResumeById(compResumekeyId);
							one.setStatus("1");
							super.getInviteManager().updateCompResume(one);
							List<PersonResumeB> LResumeB=new ArrayList<PersonResumeB>();
							List<ApplyJobInfo>  applyJob=new ArrayList<ApplyJobInfo>();
							
							user=super.getInviteManager().findUserById(userKeyId);
							String loginId=user.getLoginId();
							List<?> list1=super.getInviteManager().queryPersonResume(loginId);
							if(!list1.isEmpty()){
								Object[] o1=(Object[])list1.get(0);
								resume=(PersonResume)o1[0];
								
								session.setAttribute("resume", resume);
							}
							List<PersonResumeB> list2=super.getInviteManager().findPersonResumesById(loginId);
							if(!list2.isEmpty()){
								for(int j=0;j<list2.size();j++){
									resumeB=(PersonResumeB)list2.get(j);
									LResumeB.add(resumeB);
								}
								 
								session.setAttribute("resumeB", LResumeB);
							}
							List<?> list3=super.getInviteManager().queryApplyJobById(loginId);
							if(!list3.isEmpty()){
								for(int i=0;i<list3.size();i++){
									Object[] o=(Object[])list3.get(i);
									ApplyJobInfo oneJob=(ApplyJobInfo)o[0];
									applyJob.add(oneJob);
								}
								session.setAttribute("applyJob", applyJob);

							}
							List educations = super.getInviteManager().findEducationsById(loginId);
							session.setAttribute("educations", educations);
							return mapping.findForward("show11");
							
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
		     * 描述：显示尚无意向简历库其他页
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
		    
		    
		    
		    public ActionForward comOtherPage(ActionMapping mapping, ActionForm form,
		   		 HttpServletRequest request, HttpServletResponse response) throws BaseException{
		   	 try {
						int pageSize=5;
						boolean desc=true;
						String pnum=request.getParameter("pageIndex");
							
						HttpSession session = request.getSession(true);
					    int ppp=(Integer)session.getAttribute("totalCount");
						String Resumestatus=(String)session.getAttribute("Resumestatus");
						String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
						int tpn=(int) Math.ceil(ppp/pageSize);
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
					PaginationSupport pagin=super.getInviteManager().paginationCompResume(compLoginName, Resumestatus, ddd, pageSize, desc);
			  		List<?> list=pagin.getItems();
					List<CompResume> allResume=new ArrayList<CompResume>();
					CompResume oneResume=new CompResume();
			   		if(list==null)
			   			allResume=null;
			   		else{
			   		 	for(int i=0;i<list.size();i++)
			   		 		{
			   		 		oneResume=(CompResume)list.get(i);
			   		 	String time=oneResume.getCreatetime();
			   		 	time=time.substring(0,10);
			   		    oneResume.setCreatetime(time);
			   		 	String username=oneResume.getPkResume().getUser().getLoginId();
			   		 Boolean reg=false;
				  	   
						List login = (List) super.getInviteManager().findUserByName(
								username);
						UserInfo userInfo = (UserInfo) login.get(0);
						String id = userInfo.getId() + "";
						List vvv = super.getInviteManager().findPersonResumeById(id);
						Object[] ttt1 = (Object[]) vvv.get(0);
						PersonResume personResume = (PersonResume) ttt1[0];
		             String state=personResume.getState();
						if(state==null||"0".equals(state)||"1".equals(state)){
		           reg=false;
		         }else{
		     	   reg=true; 
		         }
			             
						oneResume.setReg(reg);
			   		 		allResume.add(oneResume);
			   		 		}
			   		 
				 	session.setAttribute("allResume", allResume);	
				 	session.setAttribute("pageIndex", ddd);
			   		}
			   		return mapping.findForward("showCompResume");
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
		     * 描述：查询已有意向的第一页
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward showqueryCompResume(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws BaseException{
				String forward = IConstants.FAIL_KEY;
				try{
					String Resumestatus="1";
					HttpSession session=request.getSession();
					session.removeAttribute("Resumestatus");
					session.setAttribute("Resumestatus", Resumestatus);
					String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
					
					int pageIndex=0;
		 		   	int pageSize=5;
		 		   	boolean desc=true;
					
		 		 //企业简历库数据  
		   		 PaginationSupport pagin=super.getInviteManager().paginationCompResume(compLoginName, Resumestatus, pageIndex, pageSize, desc);
		   		 List<?> list=pagin.getItems();
		   		 int totalCount=pagin.getTotalCount();
		   		 //计算总的页数tpp
		   		 int tpp=(int) Math.ceil((totalCount-1)/pageSize);
				 List<CompResume> allResume=new ArrayList<CompResume>();
				 CompResume oneResume=new CompResume();
		   		 if(list==null)
		   			allResume=null;
		   		 else{
		   		 	for(int i=0;i<list.size();i++)
		   		 		{
		   		 		oneResume=(CompResume)list.get(i);
		   		 	String time=oneResume.getCreatetime();
		   		 	time=time.substring(0,10);
		   		    oneResume.setCreatetime(time);
		   		 	String username=oneResume.getPkResume().getUser().getLoginId();
		   		 Boolean reg=false;
			  	   
					List login = (List) super.getInviteManager().findUserByName(
							username);
					UserInfo userInfo = (UserInfo) login.get(0);
					String id = userInfo.getId() + "";
					List vvv = super.getInviteManager().findPersonResumeById(id);
					Object[] ttt1 = (Object[]) vvv.get(0);
					PersonResume personResume = (PersonResume) ttt1[0];
	             String state=personResume.getState();
					if(state==null||"0".equals(state)||"1".equals(state)){
	           reg=false;
	         }else{
	     	   reg=true; 
	         }
					oneResume.setReg(reg);
		   		 		allResume.add(oneResume);
		   		 		}
		   		 	
		   		    session.setAttribute("allResume", allResume);
		   		 	session.setAttribute("pageIndex", pageIndex);
		   		 	session.removeAttribute("totalCount");
		   		 	session.setAttribute("totalCount", totalCount);
		   		 	session.removeAttribute("tpp");
		   		 	session.setAttribute("tpp", tpp);
		   		}
		   		 forward=IConstants.SUCCESS_KEY;
				
				}catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);

				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("showqueryCompResume");
			}	
					
			 /**
		     * 
		     * 描述：查询已有意向的其他页
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
		    
		    
		    
		    public ActionForward comOtherqueryPage(ActionMapping mapping, ActionForm form,
		   		 HttpServletRequest request, HttpServletResponse response) throws BaseException{
		   	 try {
						int pageSize=5;
						boolean desc=true;
						String pnum=request.getParameter("pageIndex");
						HttpSession session = request.getSession(true);
					    int ppp=(Integer)session.getAttribute("totalCount");
						String Resumestatus=(String)session.getAttribute("Resumestatus");
						String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
						int tpn=(int) Math.ceil(ppp/pageSize);
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
					PaginationSupport pagin=super.getInviteManager().paginationCompResume(compLoginName, Resumestatus, ddd, pageSize, desc);
			  		List<?> list=pagin.getItems();
					List<CompResume> allResume=new ArrayList<CompResume>();
					CompResume oneResume=new CompResume();
			   		if(list==null)
			   			allResume=null;
			   		else{
			   		 	for(int i=0;i<list.size();i++)
			   		 		{
			   		 		oneResume=(CompResume)list.get(i);
			   		 	String time=oneResume.getCreatetime();
			   		 	time=time.substring(0,10);
			   		    oneResume.setCreatetime(time);
			   		 	String username=oneResume.getPkResume().getUser().getLoginId();
			   		 Boolean reg=false;
				  	   
						List login = (List) super.getInviteManager().findUserByName(
								username);
						UserInfo userInfo = (UserInfo) login.get(0);
						String id = userInfo.getId() + "";
						List vvv = super.getInviteManager().findPersonResumeById(id);
						Object[] ttt1 = (Object[]) vvv.get(0);
						PersonResume personResume = (PersonResume) ttt1[0];
		             String state=personResume.getState();
						if(state==null||"0".equals(state)||"1".equals(state)){
		           reg=false;
		         }else{
		     	   reg=true; 
		         }
						oneResume.setReg(reg);
			   		 		allResume.add(oneResume);
			   		 		}
			   		 
				 	session.setAttribute("allResume", allResume);	
				 	session.setAttribute("pageIndex", ddd);
			   		}
			   		return mapping.findForward("showqueryCompResume");
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
		     * 描述：删除一份简历
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward delOnequeryResume(ActionMapping mapping, ActionForm form,

					HttpServletRequest request, HttpServletResponse response) throws BaseException{
				try{
					String id=request.getParameter("keyId");
					CompResume one=super.getInviteManager().findCompResumeById(id);
					super.getInviteManager().delCompResume(one);
					return mapping.findForward("OnequeryResume");
				
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
		     * 描述：显示企业人才库第一页信息 
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward showCompAbility(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws BaseException{
				String forward = IConstants.FAIL_KEY;
				try{
					HttpSession session=request.getSession(false);
					String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
					String file="1";
					int pageIndex=0;
		 		   	int pageSize=5;
		 		   	boolean desc=true;
		 		    String education = (String) request.getParameter("education");
		 		    String years= (String) request.getParameter("years");
		 		    String dkind= (String) request.getParameter("dkind");
		 		    String startdate= (String) request.getParameter("startdate");
		 		    String enddate= (String) request.getParameter("enddate");
					PersonResume resume=new PersonResume();
					resume.setLimitYear(years);
					resume.setPhone(education);
					resume.setDkind(dkind);
					resume.setLang2((startdate));
					resume.setLevel2(enddate);  
		 		 //企业人才库数据  
				PaginationSupport pagin=super.getInviteManager().queryCompResumeByFile(file, compLoginName,resume, pageIndex, pageSize, desc);
		   		 List<?> list=pagin.getItems();
		   		 int totalCount=pagin.getTotalCount();
		   		 //计算总的页数tpp
		   		 int tpp=(int) Math.ceil((totalCount-1)/pageSize);
				 List<CompResume> allResume=new ArrayList<CompResume>();
				 List bdEducate = (List) super.inviteManager.findAllBdEducate();
				 List bdPost = (List) super.inviteManager.findAllBdPost();
				 BdPost post =new BdPost();
				 CompResume oneResume=new CompResume();
		   		 if(list==null)
		   			allResume=null;
		   		 else{
		   		 	for(int i=0;i<list.size();i++)
		   		 		{
		   		 		oneResume=(CompResume)list.get(i);
		   		 	for(int j=0;j<bdPost.size();j++){
		   		 		post=(BdPost)bdPost.get(j);
				 			if((post.getId()+"").equals(oneResume.getPkResume().getDkind()))
		   		 			oneResume.getPkResume().setDkind(post.getPostName());
		   		 		}
		   		 Boolean reg=false;
	    		 	
		 			PersonResume personResume = oneResume.getPkResume();
		       String state=personResume.getState();
		 			if(state==null||"0".equals(state)||"1".equals(state)){
		     reg=false;
		   }else{
		 	   reg=true; 
		   }
		   			oneResume.setReg(reg);
		   		 		allResume.add(oneResume);
		   		 		}
		   		    session.setAttribute("allResume", allResume);
		   		    session.setAttribute("pageIndex", pageIndex);
		   		 	session.removeAttribute("totalCount");
		   		 	session.setAttribute("totalCount", totalCount);
		   		 	session.removeAttribute("tpp");
		   		 	session.setAttribute("tpp", tpp);
		   		}
				 
		   		 session.setAttribute("bdEducate", bdEducate);
				 session.setAttribute("bdPost", bdPost);
				 session.setAttribute("education",education);
				 session.setAttribute("years",years);
				 session.setAttribute("dkind",dkind);
				 session.setAttribute("startdate",startdate);
				 session.setAttribute("enddate",enddate);

		   		 forward=IConstants.SUCCESS_KEY;
				
				}catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);

				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("showCompAbility");
			}	
					
			 /**
		     * 
		     * 描述：显示人才库其他页
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
		    
		    
		    
		    public ActionForward comOtherabPage(ActionMapping mapping, ActionForm form,
		   		 HttpServletRequest request, HttpServletResponse response) throws BaseException{
		   	 try {
						int pageSize=5;
						boolean desc=true;
						String file="1";
						String pnum=request.getParameter("pageIndex");
							
						HttpSession session = request.getSession(true);
					    
						String compLoginName =(String)session.getAttribute(IConstants.COMP_USER_ID);
						
						int pn=new Integer(pnum).intValue();
							
					String education = (String) request.getParameter("education");
					String years= (String) request.getParameter("years");
					String dkind= (String) request.getParameter("dkind");
					String startdate= (String) request.getParameter("startdate");
		 		    String enddate= (String) request.getParameter("enddate");
					PersonResume resume=new PersonResume();
					resume.setLimitYear(years);
					resume.setPhone(education);
					resume.setDkind(dkind);
					resume.setLang2((startdate));
					resume.setLevel2(enddate);  

					PaginationSupport pagin=super.getInviteManager().queryCompResumeByFile(file, compLoginName,resume, pn, pageSize, desc);
			  		List<?> list=pagin.getItems();
			  		List bdEducate = (List) super.inviteManager.findAllBdEducate();
					List bdPost = (List) super.inviteManager.findAllBdPost();
					BdPost post =new BdPost();
					List<CompResume> allResume=new ArrayList<CompResume>();
					CompResume oneResume=new CompResume();
			   		if(list==null)
			   			allResume=null;
			   		else{
			   		 	for(int i=0;i<list.size();i++)
			   		 		{
			   		 		oneResume=(CompResume)list.get(i);
			   		 		for(int j=0;j<bdPost.size();j++){
			   		 		post=(BdPost)bdPost.get(j);
			   		 			if((post.getId()+"").equals(oneResume.getPkResume().getDkind()))
			   		 			oneResume.getPkResume().setDkind(post.getPostName());
			   		 		}
			   		 	 Boolean reg=false;
			    		 	
				 			PersonResume personResume = oneResume.getPkResume();
				       String state=personResume.getState();
				 			if(state==null||"0".equals(state)||"1".equals(state)){
				     reg=false;
				   }else{
				 	   reg=true; 
				   }
				   			oneResume.setReg(reg);
			   		 		allResume.add(oneResume);
			   		 		}
			   		int totalCount=pagin.getTotalCount();
			   		int tpp=(int) Math.ceil(totalCount/pageSize);
			   		
				 	session.setAttribute("allResume", allResume);	
				 	session.setAttribute("pageIndex", pn);
				 	
				 	session.setAttribute("tpp", tpp);
				 	session.setAttribute("totalCount", totalCount);
			   		}
			   		
					
			   		session.setAttribute("bdEducate", bdEducate);
			   		session.setAttribute("bdPost", bdPost);
			   		session.setAttribute("education",education);
			   		session.setAttribute("years",years);
			   		session.setAttribute("education",education);
			   		session.setAttribute("dkind",dkind);
			   		session.setAttribute("startdate",startdate);
			   		session.setAttribute("enddate",enddate);

			   		return mapping.findForward("showCompAbility");
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
		     * 描述：显示人才详细信息
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward showOneabResume(ActionMapping mapping, ActionForm form,

					HttpServletRequest request, HttpServletResponse response) throws BaseException{
				HttpSession session=request.getSession();		
				try{
							String userKeyId=request.getParameter("userKeyId");
							//String compResumekeyId=request.getParameter("compResumekeyId");
							//HttpSession session=request.getSession();
							//session.removeAttribute("compResumekeyId");
							//session.setAttribute("compResumekeyId", compResumekeyId);
							UserInfo  user=new UserInfo();
							PersonResume resume=new PersonResume();
							PersonResumeB resumeB=new PersonResumeB();
							List<PersonResumeB> LResumeB=new ArrayList<PersonResumeB>();
							List<ApplyJobInfo>  applyJob=new ArrayList<ApplyJobInfo>();
							
							user=super.getInviteManager().findUserById(userKeyId);
							String loginId=user.getLoginId();
							List<?> list1=super.getInviteManager().queryPersonResume(loginId);
							if(!list1.isEmpty()){
								Object[] o1=(Object[])list1.get(0);
								resume=(PersonResume)o1[0];
								String dkind=resume.getDkind();
								dkind=dkind.trim();
								dkind=(super.inviteManager.findPostById(dkind)).getPostName();
								resume.setDkind(dkind);
							}
							session.setAttribute("resume", resume);
							List<PersonResumeB> list2=super.getInviteManager().findPersonResumesById(loginId);
							if(!list2.isEmpty()){
								for(int j=0;j<list2.size();j++){
									resumeB=(PersonResumeB)list2.get(j);
									
									LResumeB.add(resumeB);
								}
								session.setAttribute("resumeb", LResumeB);
							}
							List<?> list3=super.getInviteManager().queryApplyJobById(loginId);
							if(!list3.isEmpty()){
								for(int i=0;i<list3.size();i++){
									Object[] o=(Object[])list3.get(i);
									ApplyJobInfo oneJob=(ApplyJobInfo)o[0];
									applyJob.add(oneJob);
								}
								session.setAttribute("applyJob", applyJob);
							}
							List educations = super.getInviteManager().findEducationsById(loginId);
							session.setAttribute("educations", educations);

							
							
							return mapping.findForward("showOneabResume");
							
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
		     * 描述：删除人才信息
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward delOneabResume(ActionMapping mapping, ActionForm form,

					HttpServletRequest request, HttpServletResponse response) throws BaseException{
				try{
					String id=request.getParameter("keyId");
					CompResume one=super.getInviteManager().findCompResumeById(id);
					if(one!=null)
					super.getInviteManager().delCompResume(one);
					return mapping.findForward("OneabResume");
				
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
		     * 描述：代理招聘的撤销
		     * @param mapping
		     * @param form
		     * @param request
		     * @param response
		     * @return ActionForward
		     * @throws BaseException 
		     */
			public ActionForward delaglient(ActionMapping mapping, ActionForm form,

					HttpServletRequest request, HttpServletResponse response) throws BaseException{
				try{
					String compid= (String) request.getParameter("apllyId");
					CompBespeak compBespeak=super.getInviteManager().findCompBespeakById(compid);
					super.getInviteManager().delCompBespeak(compBespeak);
					String loginid=compBespeak.getUserId();
					List list=super.getInviteManager().queryJobInfoById(loginid);
					for(int i=0;i<list.size();i++){
						Object[] o=(Object[])list.get(i);
						PublishJobInfo job=(PublishJobInfo)o[0];
						
						super.getInviteManager().delPublishJobInfo(job);
					}
				}catch(BusinessException be){
					logger.error(be.getMessage(),be);
					throw new BaseException(be);

				}catch(Exception ex){
					logger.error("系统异常:",ex);
					throw new BaseException(ex);
				}
				return mapping.findForward("delaglient");
			}
			public static String getFileExt(FormFile file)
			 {
			  String fileName=file.getFileName();
			  return fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();
			 }
}
