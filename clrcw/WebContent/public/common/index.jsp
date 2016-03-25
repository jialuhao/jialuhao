<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重新登录</title>
</head>
<body>
<html:errors/>
<html:form action="/login.do?method=login" method="post" target="_self">
	<table>
	<tr><bean:message key="username"/></tr>
    <tr><html:text property="username"  size="15" /></tr>
    <tr><bean:message key="password"/></tr>
    <tr><html:password property="password" size="15" /></tr>
    <tr><html:submit><bean:message key="user.login"/></html:submit></tr>
    <tr><html:link href="/login.do?method=register"><bean:message key="user.register"/></html:link></tr>
 	</table>
 	
 </html:form>
</body>
<html:javascript formName="LoginForm"/>
</html:html>