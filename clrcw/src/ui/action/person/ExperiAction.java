package ui.action.person;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.opensymphony.xwork2.ActionContext;

import common.exception.BaseException;
import common.ui.BaseAction;

public class ExperiAction extends BaseAction {
	private static Logger logger = Logger.getLogger(ExperiAction.class);
	StringBuffer buf = new StringBuffer("");
	private String mes;

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	private String s_name;

	public String getS_name() {
		return s_name.trim();
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	private String dcsid;

	public String getDcsid() {
		return dcsid.trim();
	}

	public void setDcsid(String dcsid) {
		this.dcsid = dcsid;
	}
	private String rand;

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}
	/**
	 * 
	 * 描述：欲求职位的修改
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws BaseException
	 * @throws ClassNotFoundException
	 */

	public ActionForward experiCard(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException, ClassNotFoundException {
		Connection conn = null;

		HttpSession session=request.getSession();  
		String red_add=(String)request.getParameter("red_add");
		this.setRand((String) request.getParameter("rand"));
		this.setS_name((String) request.getParameter("s_name"));
		this.setDcsid((String) request.getParameter("dcsid"));
		session.setAttribute("s_name", s_name);
		  session.setAttribute("red_add", red_add);//户籍所在地
		  session.setAttribute("dcsid",dcsid );
		System.out.println(session.getAttribute("code").toString());;
		if (rand != null) {
			if (!rand.equals(session.getAttribute("code").toString())) {
				mes = "rand";
				request.setAttribute("message", "验证码不正确");
				return mapping.findForward("fail");
			
			}else{
				return mapping.findForward("success");
			}
		}
		try {
			String whereSql = "";
			Object[] paras = new Object[0];
			/*************** 查询相关 ***************/
			StringBuffer whereBuffer = new StringBuffer();
			List paraList = new ArrayList();
			boolean isFirst = true;
			if (s_name != null && !s_name.equals("")) {
				if (isFirst) {
					isFirst = false;
					whereBuffer.append(" where ");
				} else {
					whereBuffer.append(" and ");
				}
				paraList.add(s_name);
				whereBuffer.append("name=?");
			}

			if (dcsid != null && !dcsid.equals("")) {
				dcsid = dcsid.toUpperCase();

				if (isFirst) {
					isFirst = false;
					whereBuffer.append(" where ");
				} else {
					whereBuffer.append(" and ");
				}
				String dcsidmd5 = md5s(dcsid);

				System.out.println(dcsidmd5);
				paraList.add(dcsidmd5);
				whereBuffer.append("dc_s_id=?");
			}
        
			whereSql = whereBuffer.toString();
			paras = paraList.toArray();
			/*************** 查询条件生成结束 ***************/
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://10.149.56.62:3306/sjs?useUnicode=true&characterEncoding=GBK";
			String username = "root";
			String password = "taiji";
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(
					"select count(dc_s_id) from Mng_dp " + whereSql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			for (int i = 0; i < paras.length; i++) {
				pstmt.setObject(i + 1, paras[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			if (count == 1) {
				mes = "真";
			} else {
				mes = "假";
			}
			return mapping.findForward("success");
		} catch (SQLException e) {
			e.printStackTrace();
			return mapping.findForward("success");
		} finally {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public String md5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			return buf.toString();
		}

	}
	public ActionForward experiCardto(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)
			throws BaseException, ClassNotFoundException {
		
		return mapping.findForward("toexperi");
	}
}
