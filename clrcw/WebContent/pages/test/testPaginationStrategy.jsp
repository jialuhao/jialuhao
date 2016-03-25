<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test paginationStrategy()</title>
</head>
<body>

<html:form action="/testPaginationStrategyAction.do?method=show" method="post">
<%--/testPaginationStrategyAction.do?method=show --%>
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td height="25">输入要查询的页码数：
                <html:text property="pageIndex"  size="15" /></td>
            </tr>
            
            <tr>
              <td height="25">输入每页显示的条数：
                <html:text property="pageSize" size="15" /></td>
            </tr>
            <tr>
            	<td height="25">选择排序的方法：
            	<html:radio property="order" value="true"/>降序
            	<html:radio property="order" value="false"/>升序
            	
            </tr>
            
            <tr>
            <td>
             <html:submit property="submit" value="查询"/>
            
            </td>
            </tr>
          </table>
	
	</html:form>
	
	


</body>
</html>