<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>重新登录页面</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
<script language="JavaScript" type="text/JavaScript">
function formCheck(){ 
	if (document.form.account.value == ""){ 
	alert("管理员名不能为空！"); 
	document.form.account.focus();
	return false; 
	} 
	if (document.form.password.value == ""){ 
	alert("密码不能为空！"); 
	document.form.password.focus();
	return false; 
	} 
	document.form.submit(); 
} 
</script>
</head>
<body>
<form action="${ctx}/admin/manaLogin.do?method=login" method="post"
	name="form" onSubmit="return formCheck();" target="_parent">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td><font color="red"><html:errors property="nou" /><html:errors
			property="nop" /> <html:errors property="out" /> <logic:present
			name="reLogin">
			<bean:write name="reLogin" />
		</logic:present> <!--  显示权限控制信息--> </font></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td><font color="red"> <logic:present name="reLogin">
			<bean:write name="reLogin" />
		</logic:present></font></td>
	</tr>
	<tr>
		<td height="25" align="right" width="40%">
		管理员：</td>
		<td height="25" align="left" width="60%"><input type="text"
			name="account" size="15"></td>
	</tr>
	<tr>
		<td height="25" align="right" width="40%">
		密　码：</td>
		<td height="25" align="left" width="60%"><input type="password"
			size="15" name="password"></td>
	</tr>
	<tr align="center">
		<td height="15" colspan="2"></td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="submit" value="登 录"
			class="input4">&nbsp;&nbsp;<input type="reset" value="重 置"
			class="input4"></td>
	</tr>
</table>
</form>
</body>
</html>