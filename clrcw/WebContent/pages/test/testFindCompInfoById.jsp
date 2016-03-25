<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>testFindCompInfoById</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>输入id查询企业信息</h2>

<html:form action="/testFindCompInfoByIdAction.do?method=show">
<%--testFindCompInfoById.jsp-->
<%--/testFindCompInfoById.do?method=show --%>
  
 请输入用户id:<input type="text" name="userId" >
 请输入简历id<input type="text" name="resumeId">
 <p>
 <input type="submit" value="查询">
 <input type="reset" value="重置">
 </html:form>
	
	


</body>
</html>