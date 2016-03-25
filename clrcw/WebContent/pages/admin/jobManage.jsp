<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="model.BdJob" %>
<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
function edit(s_id){
	var id = s_id;
	var rets = window.showModalDialog("${ctx}/pages/personal/Frame1.jsp",id,"dialogHeight:330px;dialogWidth:450px");
}
function del(s_id){
		var b = confirm("确实要删除吗？");
		if(b){
		
		    document.getElementById("delId").value=s_id;
			document.form1.submit();
		}else{
			return false;
		}
	}
	
function checkform(){ 
	jobname = document.form2.jobname.value;
	var name= document.getElementsByName("job");
 
 	for(i=0;i<name.length;i++){
	
	if($.trim(name[i].value)==$.trim(jobname)){
	
	alert("不能添加重复的职位名称");
	return false;
	}
	}
 	if(jobname.length<1||jobname.length>10) {
     alert("职位名称长度必须为1-10位字符");
     document.form2.jobname.focus();
     return false;
   }
	if (jobname.search(/^[0-9a-zA-Z\/u4e00-\u9FA5]+$/) < 0){ 
	alert("职位名称为空或包含非法字符"); 
   	document.form2.jobname.focus();
	return false; 
	}
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位分类目录管理</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">

</head>

<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="职位目录列表"/>
</jsp:include>

<form action="${ctx}/admin/delJob.do?method=delJob" name = "form1" method="POST">
<input type="hidden" name="delId" id="delId">
<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">

													
  <tr>
    <td width="15%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
    <td width="70%" align="center" bgcolor="#EEF5FD" class="font5">职位名称</td>
    <td width="15%" align="center" bgcolor="#EEF5FD" class="font5">操　作</td>
  </tr>
  <% List list=(List)request.getSession().getAttribute("bdjob");
	for(int i=0;i<list.size();i++){
		BdJob bdjob=(BdJob)list.get(i); %>
		  <input type="hidden" name="job" id="job"  value="<%=bdjob.getJobName()%>"/>
		  <tr>
		    <td width="15%" align="center" bgcolor="#FFFFFF" class="font5"><%=i+1%></td>
		    <td width="70%" align="center" bgcolor="#FFFFFF" class="font5"><%=bdjob.getJobName() %></td>
		    <td width="15%" align="center" bgcolor="#FFFFFF"><!--<a href="#" class="list" onClick="edit(<%=bdjob.getId()%>)">编辑</a>　--><a href="#" class="list" onClick="del(<%=bdjob.getId()%>)">删除</a></td>
		  </tr>
	<% }%> 
</table>
</form>
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="1" bgcolor="94C2F1"></td>
      </tr>
    </table></td>
  </tr>
</table>
<form name="form2" action="${ctx}/admin/addJob.do?method=addJob" method="post" onsubmit="return checkform()">
<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td valign="top" bgcolor="#EEF5FD"><span class="font5">职位名称：</span></td>
    <td colspan="3" bgcolor="#FFFFFF"><span class="font5">
      <input type="text"  Class="input3" id="jobname" name="jobname"/>
    </span></td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="35" align="center">
    <input type="submit"  value="添加" Class="input4"/>
 	<input type="reset"  value="取消" Class="input4"/>
    </td>
  </tr>
</table>
</form>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
