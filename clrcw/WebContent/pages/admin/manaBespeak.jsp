<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.CompBespeak" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>待审核企业管理页面</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="待审核企业管理页面"/>
</jsp:include>
<!-- 显示待审核企业详细信息 -->
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
<tr>
    <td bgcolor="FFF7F0" class="font5">单位名称：</td>
    <td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write name="oneComp" property="compName"/></td>
    <td bgcolor="FFF7F0" class="font5">企业注册区域：</td>
    <td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write name="oneComp" property="comparea"/></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0" class="font5">法人名称：</td>
    <td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write name="oneComp" property="compAddr"/></td>
  <td bgcolor="FFF7F0" class="font5">营业执照编码：</td>
		<td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write
			name="oneComp" property="compnum" /></td>
  </tr>
    <tr>
    <td bgcolor="FFF7F0" class="font5">邮编：</td>
    <td width="270" bgcolor="#FFFFFF" class="font5"><bean:write name="oneComp" property="mailPost"/></td>
    <td  bgcolor="#FFF7F0" class="font5">电子邮件：</td>
    <td bgcolor="#FFFFFF" class="font5"><bean:write name="oneComp" property="mail"/></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">联系电话：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5">
     <bean:write name="oneComp" property="telephone"/>
    </span></td>
    <td bgcolor="#FFF7F0"><span class="font5">联系人:</span></td>
    <td bgcolor="#FFFFFF"><span class="font5">
     <bean:write name="oneComp" property="linkman"/>
    </span></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">身份证号：</span></td>
    <td bgcolor="#FFFFFF" ><span class="font5">
     <bean:write name="oneComp" property="cardnum"/>
    </span></td>
     <td bgcolor="FFF7F0"><span class="font5">登录名：</span></td>
    <td bgcolor="#FFFFFF" ><span class="font5">
     <bean:write name="oneComp" property="userId"/>
    </span></td>
  </tr>
  <tr>
	<td colspan="4" align="center">
	<% CompBespeak personResume = (CompBespeak)request.getSession().getAttribute("oneComp");%>
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
			<td width="270" bgcolor="#FFFFFF" class="font5" ><bean:write
				name="oneComp" property="companyplace" /></td>
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
		<td class="font5">会员帐号管理：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${ctx}/admin/showAllBespeak.do?method=updateBespeak"
			class="font10"><span class="font10">确认审核 </span></a>&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td align="center"><input type="button" name="btn1" value="返回"
			onClick=" history.go(-1)" class="input4"></td>
	</tr>
</table>

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
