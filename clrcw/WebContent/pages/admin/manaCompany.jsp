<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.CompBespeak" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看企业详细信息</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
</head>
<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="查看企业详细信息"/>
</jsp:include>

<!-- 显示企业的详细信息 -->
<bean:define id="bes" name="oneBespeak" />

<table width="99%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<tr>
		<td bgcolor="FFF7F0" class="font5" width="100">单位名称：</td>
		<td  bgcolor="#FFFFFF" class="font5" ><bean:write
			name="bes" property="compName" /></td>
<td bgcolor="FFF7F0" class="font5">企业注册区域：</td>
    <td  bgcolor="#FFFFFF" class="font5" ><bean:write name="bes" property="comparea"/></td>
	</tr>
	<tr>
		<td bgcolor="FFF7F0" class="font5" width="100">法人名称：</td>
		<td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write
			name="bes" property="compAddr" /></td>
       <td bgcolor="FFF7F0" class="font5" width="100">营业执照编码：</td>
		<td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write
			name="bes" property="compnum" /></td>
	</tr>
	<tr>
		<td bgcolor="FFF7F0" class="font5" width="100">邮编：</td>
		<td width="270" bgcolor="#FFFFFF" class="font5"><bean:write
			name="bes" property="mailPost" /></td>
		<td bgcolor="#FFF7F0" class="font5" width="100">电子邮件：</td>
		<td bgcolor="#FFFFFF" width="270" class="font5"><bean:write
			name="bes" property="mail" /></td>
	</tr>
	<tr>
		<td bgcolor="FFF7F0" width="100"><span class="font5">联系电话：</span></td>
		<td bgcolor="#FFFFFF"><span class="font5"> <bean:write
			name="bes" property="telephone" /> </span></td>
		<td bgcolor="#FFF7F0" width="100"><span class="font5">联系人:</span></td>
		<td bgcolor="#FFFFFF"><span class="font5"> <bean:write
			name="bes" property="linkman" /> </span></td>
	</tr>
	<tr>
    <td bgcolor="FFF7F0"><span class="font5">身份证号：</span></td>
    <td bgcolor="#FFFFFF" ><span class="font5">
     <bean:write name="bes" property="cardnum"/>
    </span></td>
    <td bgcolor="FFF7F0"><span class="font5">登录名：</span></td>
    <td bgcolor="#FFFFFF" ><span class="font5">
     <bean:write name="bes" property="userId"/>
    </span></td>
  </tr>
	<tr>
	<td colspan="4" align="center">
	<% CompBespeak personResume = (CompBespeak)request.getSession().getAttribute("oneBespeak");%>
	<% 
	if(personResume!=null && personResume.getFkcompanyimage()!=null ){
		String[] imageids=personResume.getFkcompanyimage().split(",");
		for(int i=0;i<imageids.length;i++){
		if(imageids[i].length()>0){%>			   
			<img src="../../companyphoto.do?method=companyphoto&imageid=<%=imageids[i]%>" height="230" width="200"/> 
         <% }}}else{ %>
         	未上传图片！
         <%} %>
         </td>
         </tr>
</table>
<br>
<logic:notEmpty name="compInfo">
	<table width="99%" border="0" align="center" cellpadding="3"
		cellspacing="1" bgcolor="#cccccc">
		<tr>
			<td bgcolor="FFF7F0" class="font5" width="100">经营范围：</td>
			<td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write
				name="compInfo" property="workScrop" /></td>
		<td bgcolor="FFF7F0" class="font5" width="100">办公地点：</td>
			<td width="270" bgcolor="#FFFFFF" class="font5"><bean:write
				name="bes" property="companyplace" /></td>
		</tr>
		<tr>
			
			<td width="100" bgcolor="FFF7F0">单位规模：</td>
			<td width="270" cellpadding="3" bgcolor="#FFFFFF"> <bean:write
				name="compInfo" property="compcount" /></td>
				<td width="100" bgcolor="FFF7F0">传真：</td>
			<td width="270" cellpadding="3" bgcolor="#FFFFFF"> <bean:write
				name="compInfo" property="fax" /></td>
		</tr>
		<tr>
			<td bgcolor="FFF7F0" class="font5" width="100">企业性质：</td>
			<td width="270" bgcolor="#FFFFFF" class="font5"><bean:write
				name="compInfo" property="type.compTypeName" /></td>
			<td width="100" bgcolor="#FFF7F0" width="100" class="font5">网址：</td>
			<td bgcolor="#FFFFFF" width="270" class="font5"><bean:write
				name="compInfo" property="netAddress" /></td>
		</tr>
		<tr>
		<td width="100" >所属行业：</td>
			<td width="270"  class="font5"><bean:write
				name="compInfo" property="bd.tradeName" /></td>
		</tr>		
		<tr>
			<td bgcolor="FFF7F0" class="font5">企业介绍：</td>
			<td width="640" height="60" bgcolor="#FFFFFF" class="font5"
				colspan="3"><bean:write name="compInfo" property="compIntro" /></td>
		</tr>
	</table>
</logic:notEmpty>
<table width="99%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#FFFFFF">
	
	<tr>
		<td align="center"><input type="button" name="btn1" value="返回"
			onClick=" history.go(-1)" class="input4"></td>
	</tr>
</table>
<logic:empty name="compInfo">
	<table width="99%" border="0" align="center" cellspacing="0"
		cellpadding="0">
		<tr>
			<td height="30"><font class="font3">该企业还没有填写其他信息！</font></td>
		</tr>
	</table>
</logic:empty>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
