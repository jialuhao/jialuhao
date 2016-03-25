<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PublishJobInfo"%>
<%@ page import="model.Servicelog"%>
<%
int pagenum = (Integer) request.getSession().getAttribute("jobpagenum"); 

%>

<style>
html,body{font-size:12px;margin:0px;height:100%;}
.mesWindow{border:#666 1px solid;background:#fff;}
.mesWindowTop{border-bottom:#eee 1px solid;margin-left:4px;padding:3px;font-weight:bold;text-align:left;font-size:12px;}
.mesWindowContent{margin:4px;font-size:12px;}
.mesWindow .close{height:15px;width:28px;border:none;cursor:pointer;text-decoration:underline;background:#fff}
</style>
<script>

function addservice(){
 document.forms[0].action="${ctx}/admin/findAllpublishJob.do?method=addserviceJob";
document.forms[0].submit();
}
 function checkk(a){ 
 document.forms[0].action="${ctx}/admin/findAllpublishJob.do?method=checkoneserviceJob&serviceid="+a;
 document.forms[0].submit();
 }

 function  modify(a){ 
 document.forms[0].action="${ctx}/admin/findAllpublishJob.do?method=modifyserviceJob&serviceid="+a;
 document.forms[0].submit();
 }
 function deletee(a){
document.forms[0].action="${ctx}/admin/findAllpublishJob.do?method=deleteserviceJob&serviceid="+a;
 document.forms[0].submit();
 }
</script>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务记录</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
	<script src="${ctx}/public/js/calendar.js"></script>
	
</head>

<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="服务记录列表" />
</jsp:include>

<form action="" name="form1" method="POST">

<table width="98%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	
	<tr>
		
		<td width="16%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="20%" align="center" bgcolor="#EEF5FD" class="font5">单位名称</td>
		<td width="16%" align="center" bgcolor="#EEF5FD" class="font5">记录人</td>
		<td width="16%" align="center" bgcolor="#EEF5FD" class="font5">时间</td>
		<td width="16%" align="center" bgcolor="#EEF5FD" class="font5">人数</td>
		<td width="16%" align="center" bgcolor="#EEF5FD" class="font5">操作</td>
		
	</tr>
	<%  				List<?> list = (List<?>) request.getSession().getAttribute("servicelog");
						for (int i = 0; i < list.size(); i++) {
	                      Servicelog servicelog=(Servicelog)list.get(i); %>
	<tr>
		
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=i+1%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=servicelog.getWriteare()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=servicelog.getWritepeople()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=servicelog.getWritetime()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=servicelog.getNumber()%></td>
		
		<td align="center" bgcolor="#FFFFFF" class="font5" >
		<a href="#" onClick="checkk('<%=servicelog.getId()%>')" class="tabBtn">查看</a>&nbsp;&nbsp;
      <a href="#" onClick="modify('<%=servicelog.getId()%>')" class="tabBtn">修改</a>&nbsp;&nbsp;
		<a href="#" onClick="deletee('<%=servicelog.getId()%>')" class="tabBtn">删除</a></td>
	</tr>

	<% }%>

</table>
<div align="center">
						<input type="button" class="input8" onclick="addservice()"  value="新增 " />
									<input type="button" class="input8" onclick="history.go(-1)"  value="返回" />
</form>
<table width="98%" border="0" align="center" cellpadding="0"
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

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
