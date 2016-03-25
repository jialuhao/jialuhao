package ui.action.person;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.validator.DynaValidatorForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.upload.FormFile;
import model.BdEducate;
import model.PersonImage;
import model.PersonResume;
import model.UserInfo;
import java.io.Serializable;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.orm.hibernate3.support.BlobByteArrayType;
import common.constants.IConstants;
import common.exception.BaseException;
import common.exception.BusinessException;
import common.ui.BaseAction;

public class PhotoAction extends BaseAction {
	private static Logger logger = Logger.getLogger(PhotoAction.class);
	/**
     * 
     * 描述：根据个人Id显示相应的图片
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws BaseException 
     */
	public ActionForward photo(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws BaseException{
		try{
			HttpSession session = request.getSession(true);
			String user = (String) session
					.getAttribute(IConstants.PERSON_USER_ID);
			response.reset();
            response.setContentType("image/jpeg");
			PersonResume Lresume=new PersonResume();
			List<?> list=super.getInviteManager().queryPersonResume(user);
			PersonImage image=null;
			if(list!=null && list.size()!=0){

				Object[] o1=(Object[])list.get(0);
				Lresume=(PersonResume)o1[0];
				String imageid=Lresume.getFkPersonImage().getId().toString();
				
				 image=super.getInviteManager().findPersonImageById(imageid);

			}
			byte[] bPhoto=image.getPersonImage();
			ServletOutputStream sOut = response.getOutputStream(); 
			if(bPhoto!=null && bPhoto.length>0){
            InputStream inStream = new ByteArrayInputStream(bPhoto);
            int blobsize = (int)bPhoto.length;
            byte[] blobbytes = new byte[blobsize];
            int bytesRead = 0;
            while ((bytesRead = inStream.read(blobbytes)) != -1) {
            	sOut.write(blobbytes, 0, bytesRead); 
            }
            inStream.close();
			}
            sOut.flush(); 
            return null;
         }catch(BusinessException be){
		logger.error(be.getMessage(),be);
		throw new BaseException(be);

		}catch(Exception ex){
		logger.error("系统异常:",ex);
		throw new BaseException(ex);
	}
		
	}
}
