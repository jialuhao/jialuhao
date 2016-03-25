<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Insert title here</title>
</head>
<body>
查询的userId是：<%=request.getAttribute("userId")%>
查询的resumeId是：<%=request.getAttribute("resumeId")%>
<p>以下是详细信息：
<table width="978" border="1" align="center" cellpadding="0" cellspacing="0">
<logic:present name="a">
	<logic:notEmpty name="a">
	
		 
		  	<tr>
			<td><bean:write name="a" property="dr"/></td>
			<td><bean:write name="p" property="name"/></td>
			<td><bean:write name="p" property="address"/></td>
			<td><bean:write name="p" property="school"/></td>
			<td><bean:write name="p" property="compLevel"/></td>
			<td><bean:write name="p" property="version"/></td>
			
			</tr>
	
		
	</logic:notEmpty>
	<logic:empty name="a">
		没有企业信息！
	</logic:empty>
</logic:present>
<logic:notPresent  name="a">
	error:no attributeinfo
</logic:notPresent>

</table>

</body>
</html>