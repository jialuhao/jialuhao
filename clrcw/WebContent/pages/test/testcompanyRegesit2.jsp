<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%
  String id = (String)request.getAttribute("id"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业基本情况填写</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">

</head>


<body>
<table width="978" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="189"><img src="<%=request.getContextPath()%>/images/index_02.jpg" width="189" height="93" alt="" /></td>
    <td width="789"><img src="<%=request.getContextPath()%>/images/index_03.jpg" width="789" height="93" alt="" /></td>
  </tr>
</table>
<table width="978" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="25"><img src="<%=request.getContextPath()%>/images/index_05.jpg" width="25" height="37" alt="" /></td>
    <td valign="top" background="<%=request.getContextPath()%>/images/index_06.jpg"><table width="98%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="28" align="center"><a href="#">个人求职</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#" class="b">企业招聘</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /> </td>
        <td align="center"><a href="#">政策法规</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">职业指导</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">区域工资</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">资讯中心</a></td>
      </tr>
    </table></td>
    <td width="7"><img src="<%=request.getContextPath()%>/images/index_08.jpg" width="7" height="37" alt="" /></td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="15">   </td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#94C2F1">
  <tr>
    <td bgcolor="#EEF5FD">&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/images/qiye_loginpic.gif" width="22" height="32" > &nbsp;&nbsp;<span class="font3"><strong>企业用户注册</strong></span></td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="15"></td>
  </tr>
</table>
<html:form action="/companyRegist2.do?method=companyRegist2" method="post" onsubmit="return validateCompanyRegist2Form(this);">
<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td height="40" colspan="4" bgcolor="#FFFFFF" class="font5"><span class="font3">· </span>
    <html:link href="${ctx}/pages/company/companyRegist2.jsp">企业基本情况</html:link>&nbsp;&nbsp;&nbsp;&nbsp;
    <html:link href="${ctx}/companyPubJob.do?method=showPubJob">· 企业招聘信息</html:link> &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${ctx}/companyRegist4.do?method=companyRegist4">· 简历库</a></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0" class="font5">　单位名称：</td>
    <td colspan="3" bgcolor="#FFFFFF" class="font5"><bean:write name="compBespeakInfo" property="compName"/></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">　单位地址：</span></td>
    <td colspan="3" bgcolor="#FFFFFF"><span class="font5"><bean:write name="compBespeakInfo" property="compAddr"/></span></td>
  </tr>
  <tr>
    <td width="100" bgcolor="FFF7F0"><span class="font5">　邮　　编：</span></td>
    <td width="270" bgcolor="#FFFFFF"><span class="font5"><bean:write name="compBespeakInfo" property="mailPost"/></span></td>
    <td width="100" bgcolor="#FFF7F0"><span class="font5">　电子邮件：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><bean:write name="compBespeakInfo" property="mail"/></span></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">　联系电话：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><bean:write name="compBespeakInfo" property="telephone"/></span></td>
    <td bgcolor="#FFF7F0"><span class="font5">　联 &nbsp;系&nbsp; 人：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><bean:write name="compBespeakInfo" property="linkman"/></span></td>
  </tr>
</table>
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="1" bgcolor="94C2F1"></td>
      </tr>
    </table></td>
  </tr>
</table>

<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" 

bgcolor="#cccccc">
	<tr><td colspan="4" bgcolor="#FFFFFF"><span class="font5">请填写公司详细信息:</span></td></tr>
     <tr>
    <td width="100" bgcolor="FFF7F0"><span class="font5">　经营范围：</span></td>
    <td width="270" bgcolor="#FFFFFF"><span class="font5"><html:text property="workScope"  styleClass="input3"/></span></td>
    
    <td width="100" bgcolor="#FFF7F0"><span class="font5">　网　　址：</span></td>
    <td bgcolor="#FFFFFF"><html:text property="netAddress"  styleClass="input3"/></td>
  </tr>
  <tr>
    <td width="100" bgcolor="FFF7F0"><span class="font5">　企业性质：</span></td>
    <td width="270" bgcolor="#FFFFFF"><span class="font5">
    <html:select property="type">
    	<html:option value="11">国有企业</html:option>
    	<html:option value="22">私人企业</html:option>
    	<html:option value="33">外国企业</html:option>
    	<html:option value="44">合资企业</html:option>
    </html:select></span>
    </td>
    
    <td width="100" bgcolor="#FFF7F0"><span class="font5">　所属行业：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5">
    <html:select property="bd">
    	<html:option value="11">工业</html:option>
    	<html:option value="22">农业</html:option>
    	<html:option value="33">第三产业</html:option>
   	</html:select></span>
    </td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">　企业介绍：</span></td>
    <td colspan="3" bgcolor="#FFFFFF"><span class="font5"><html:text property="compIntro" styleClass="input3"/></span></td>
    <font color="red"><html:errors/></font>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40" align="center"> <html:submit property="submit" value="提交" styleClass="input4"/>
        <html:reset property="reset" value="重置" styleClass="input4"/></td>
  </tr>
</table>
</html:form>
<table width="978" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">&nbsp;</td>
  </tr>
</table>
<table width="978" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3" bgcolor="7D8193"></td>
  </tr>
  <tr>
    <td height="100" align="center"><span class="font5"><a href="#" class="d">关于我们</a>&nbsp;  &nbsp;|&nbsp;&nbsp;  <a href="#" class="d">联系我们</a>&nbsp;&nbsp;  |&nbsp;&nbsp;  <a href="#" class="d">版权声明</a>&nbsp;&nbsp;  |&nbsp;&nbsp; <a href="#" class="d">网站地图</a> </span><span class="font2"><br>
  copyright©2002 中华人民共和国国防科学技术工业委员会信息中心 版权所有 </span><br>
      <span class="font5">通讯地址：北京8184信箱　　邮编100081</span></td>
  </tr>
</table>
</body>
</html:html>
