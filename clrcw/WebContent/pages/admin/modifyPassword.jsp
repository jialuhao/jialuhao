<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" charset="utf-8" src="${ctx}/public/js/asop/util.js"></script>	
<script type="text/javascript" charset="utf-8" src="${ctx}/public/js/asop/password.js"></script>
</head>
<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="修改密码" />
</jsp:include>

<table width="780" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="40">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="1" bgcolor="94C2F1"></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<form name="form2" action="${ctx}/admin/modifyPassword.do"
	method="post" onsubmit="return checkform(this);">
<table width="740" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<tr align="center">
		<td><font color="red"> 
		<logic:messagesPresent
			message="true">
			<html:messages id="error" name="user" message="true">
				<bean:write name="error" />
			</html:messages>
		</logic:messagesPresent> 
		<logic:present name="reLogin">
			<bean:write name="reLogin" />
		</logic:present> 
		<html:errors property="noUser"/>
		</font></td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5">
		原密码：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="font5"> <input
			type="password" Class="input3" id="password" name="password" /> </span></td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5"> 新密码：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="font5"> <input
			type="password" Class="input3" id="newPassword" name="newPassword" /> </span></td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5"> 新密码确认：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="font5"> <input
			type="password" Class="input3" id="newPassword2" name="newPassword2" /> </span></td>
	</tr>
</table>
<table width="740" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="35" align="center"><input type="submit" value="保存"
			Class="input4" /></td>
	</tr>
</table>
</form>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
