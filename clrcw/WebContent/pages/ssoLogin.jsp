<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../public/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>选择类型</title>
<link href="${ctx}/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">

</head>
<body>
<table width="978" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="189"><img
			src="${ctx}/images/index_02.jpg" width="189"
			height="93" alt="" /></td>
		<td width="789"><img
			src="${ctx}/images/index_03.jpg" width="789"
			height="93" alt="" /></td>
	</tr>
</table>

<table width="978" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="30">&nbsp;</td>
	</tr>
</table>

<form name="form" method="post" action="${ctx}/ssoLogin.do?method=login">
	<table width="400" border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td align="left">请选择登录类型：</td>
		</tr>
		<tr>
			<td align="center">
				<input type="radio" name="type" value="1"  class="input7" checked>个人用户&nbsp;&nbsp;&nbsp;
				<input type="radio" name="type" value="2" class="input7">企业用户
				<input type="hidden" name="token" value="<%=request.getParameter("token")%>">
			</td>
		</tr>
		<tr>
		<td height="1">&nbsp;</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="确定" class="input4">
				<input type="button" value="返回" class="input4" onclick=" history.go(-1)">
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../public/include/footer.jsp"></jsp:include>
</body>
</html:html>