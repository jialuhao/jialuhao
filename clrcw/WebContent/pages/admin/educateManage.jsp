<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
function del(s_id){
	var b = confirm("确实要删除吗？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.forms[0].action="${ctx}/admin/educateManage.do?method=del";
		document.forms[0].submit();
	}else{
		return false;
	}
}
function checkform(){ 
	eduName = document.form2.eduName.value;
	var name= document.getElementsByName("educate");
	for(i=0;i<name.length;i++){
	
	if($.trim(name[i].value)==$.trim(eduName)){
	alert("不能添加重复的学历名称");
	return false;
	}
	}
	if(eduName.length>10){
	     alert("学历名称不能大于10个字符");
	     document.getElementById("eduName").focus();
	     return false;
	   }
	if(eduName.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0){ 
		alert("学历名称为空或包含非法字符"); 
	 	document.getElementById("eduName").focus();
		return false; 
	}
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学历分类目录管理</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">

</head>

<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="学历列表"/>
</jsp:include>

<form action="" name="form1" method="post">
<input type="hidden" name="delId" id="delId">
<table width="740" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<tr>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="70%"align="center" bgcolor="#EEF5FD" class="font5">学历名称</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">操
		作</td>
	</tr>
	<logic:present name="MEducate">
		<logic:iterate id="ed" name="MEducate" type="model.BdEducate" indexId="index">
			 <input type="hidden" name="educate" id="educate" value="<bean:write
					name="ed" property="educateName" />">
			<tr>
				<td width="15%" align="center" bgcolor="#FFFFFF" class="font5"><%=index+1 %></td>
				<td  width="70%" align="center" bgcolor="#FFFFFF" class="font5"><bean:write
					name="ed" property="educateName" /></td>
				<td width="15%" align="center" bgcolor="#FFFFFF">
				<a href="#" class="list" onClick="del(${ed.id})">删除</a>	
					</td>
					
			</tr>
		</logic:iterate>
	</logic:present>
	<logic:notPresent name="MEducate">
		<p class="font5">还没有学历信息!请添加</p>
	</logic:notPresent>

</table>
</form>
<table width="780" border="0" align="center" cellpadding="0"
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
<form action="${ctx}/admin/educateManage.do?method=add" name="form2" method="post" onsubmit="return checkform()">
<table width="740" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5">
		学历名称：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="font5"> <input
			type="text" Class="input3" id="eduName" name="eduName" /> </span></td>
	</tr>
</table>
<table width="740" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="35" align="center"><input type="submit" value="添加"
			Class="input4" /> <input type="reset" value="取消" Class="input4"/></td>
	</tr>
</table>
</form>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
