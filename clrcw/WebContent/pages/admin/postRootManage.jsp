<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="model.BdPostRoot" %>

<script language="JavaScript" type="text/JavaScript">
function edit(s_id){
	var id = s_id;
	var rets = window.showModalDialog("${ctx}/pages/personal/Frame1.jsp",id,"dialogHeight:330px;dialogWidth:450px");
}

function del(s_id){
	var b = confirm("确实要删除吗？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.forms[0].action="${ctx}/admin/delPost.do?method=delPost";
		document.forms[0].submit();
	
	}else{
		return false;
	}
	}
	
function checkform(){ 
	postRootname = document.form2.postRootname.value;
	if(postRootname.length>10){
	    alert("岗位名称长度必须为1-10位字符");
	    document.form2.postRootname.focus();
	    return false;
	}
	if (postRootname.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0){ 
		alert("岗位名称为空或包含非法字符"); 
		document.form2.postRootname.focus();
		return false; 
	}
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>残疾大类别目录管理</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">

</head>

<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="残疾大类别列表"/>
</jsp:include>
<form action="" name = "form1" method="POST">
<table width="500" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
<html:hidden property="delId" value=""/>
  <tr>
    <td width="15%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
    <td width="85%" align="center" bgcolor="#EEF5FD" class="font5">残疾大类别名称</td><!--
    <td width="148" align="center" bgcolor="#EEF5FD" class="font5">操　作</td>
  --></tr>
  <% List list=(List)request.getSession().getAttribute("bdPostRoot");
	for(int i=0;i<list.size();i++){
		BdPostRoot bdPostRoot=(BdPostRoot)list.get(i); %>
		  <tr>
		    <td width="15%"align="center" bgcolor="#FFFFFF" class="font5"><%=i+1 %></td>
		    <td width="85%" align="center" bgcolor="#FFFFFF" class="font5"><%=bdPostRoot.getPostName() %></td>
		    <!--
		    <td align="center" bgcolor="#FFFFFF"><a href="#" class="list" onClick="edit(<%=bdPostRoot.getId()%>)">编辑</a>　<a href="#" class="list" onClick="del(<%=bdPostRoot.getId()%>)">删除</a></td>
		  --></tr>
		
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
<form name="form2" action="${ctx}/admin/addPostRoot.do?method=addPostRoot" method="post" onsubmit="return checkform()">
<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td valign="top" bgcolor="#EEF5FD"><span class="font5">　残疾大类别名称：</span></td>
    <td colspan="3" bgcolor="#FFFFFF"><span class="font5">
    <input type="text"  Class="input3" id="postRootname" name="postRootname"/>
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
