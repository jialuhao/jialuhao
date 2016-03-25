<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>管理员登录页面</title>
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
function init(){
	document.form.account.focus();
}
</script>
</head>
<body onload="init();">
<table width="960" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		
		<td width="950"><img
			src="${ctx}/images/top_banner.jpg" width="950"
			height="123" alt="" /></td>
	</tr>
</table>
<p align="center">
<font color="red"> 
<html:errors property="nou" /><html:errors property="nop" /> 
<logic:present name="reLogin">
	<bean:write name="reLogin" />
</logic:present> 
<!--  显示权限控制信息--> 
</font>
</p>
<form action="${ctx}/admin/manaLogin.do?method=login" method="post"
	name="form" onSubmit="return formCheck();">
<table width="50%" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr align="center">
		<td height="15" colspan="2"></td>
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
	<tr align="center">
		<td height="125" colspan="2"></td>
	</tr>
</table>
</form>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>