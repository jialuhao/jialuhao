<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.ManaUser"%>
<%@ page import="model.Areacode"%>

<script language="JavaScript" type="text/JavaScript">
function edit(s_id){
	var id = s_id;
	var rets = window.showModalDialog("${ctx}/pages/personal/Frame1.jsp",id,"dialogHeight:330px;dialogWidth:450px");
}

function del(ln,ps){
		var b = confirm("确实要删除吗？");
		if(b){
		    document.getElementById("loginName").value=ln;
			document.getElementById("pass").value=ps;
			document.getElementById("form1").submit();
		}else{
			return false;
		}
	}
function checkform(){ 	
	adminName = document.form2.adminName.value;
	if(adminName.length<6||adminName.length>20){
     alert("帐号名称长度必须在6位到20位之间");
     document.form2.adminName.focus();
     return false;
   }
	if (adminName.search(/^[0-9a-zA-Z]+$/) < 0){ 
	alert("帐号名称只能为数字或字母"); 
    document.form2.adminName.focus();
	return false; 
	}    
	password = document.form2.password.value;
  	if(password.length<6||password.length>10){
     	alert("密码长度必须在6位到10位之间");
      	document.form2.password.focus();
     	return false;
	}
	if (password.search(/^[0-9a-zA-Z]+$/) < 0){ 
		alert("密码只能为数字或字母"); 
	 	document.form2.password.focus();
		return false; 
	} 
	area = document.form2.areacode.value;    
	if(area!="110100"){
		document.form2.areacode.value=document.form2.areacode1.value;
	}
}
function checkarea(){ 	
	area ="";
	var radios = document.getElementsByName("area");
    for (var i = 0; i < radios.length; i++) {
        var radio = radios[i];
        if (radio.checked) {           //判断是否选中
        	area=radio.value;
        }
    }
	if(area=="110100"){
		document.form2.areacode1.disabled=true;
		document.form2.areacode.value="110100";
		
   }else{
	   	document.form2.areacode.value="";
	    document.form2.areacode1.disabled=false;
	}
	
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员帐号管理</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="管理员帐号列表" />
</jsp:include>

<form action="${ctx}/admin/delAdmin.do?method=delAdmin" id="form1" name="form1"
	method="POST">
<table width="740" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<input type="hidden" id="loginName" name="loginName"/>
	<input type="hidden" id="pass" name="pass"/>
	
	<tr>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="35%" align="center" bgcolor="#EEF5FD" class="font5">帐号</td>
		<td width="35%" align="center" bgcolor="#EEF5FD" class="font5">密码</td>
		<td width="35%" align="center" bgcolor="#EEF5FD" class="font5">区域</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">操作</td>
	</tr>
	<%
		List list = (List) request.getSession().getAttribute("allManaUser");
		List ccc=(List)request.getSession().getAttribute("arealist"); 
		for (int i = 0; i < list.size(); i++) {
			ManaUser manaUser = (ManaUser) list.get(i);
	%>
	<tr>
		<td width="15%" align="center" bgcolor="#FFFFFF" class="font5"><%=manaUser.getId()%></td>
		<td width="35%" align="center" bgcolor="#FFFFFF" class="font5"><%=manaUser.getAccount()%></td>
		<td width="35%" align="center" bgcolor="#FFFFFF" class="font5"><%=manaUser.getPassword()%></td>
		<%if("110100".equals(manaUser.getAreacode())){%>
			<td width="35%" align="center" bgcolor="#FFFFFF" class="font5">北京市</td>
		<%
			
		}else{
		for(int j=0;j<ccc.size();j++){
			Areacode areacode=(Areacode)ccc.get(j);
			if(areacode.getAreacode().equals(manaUser.getAreacode())){%>
				<td width="35%" align="center" bgcolor="#FFFFFF" class="font5"><%=areacode.getAreaname()%></td>
			<%}
		}} %>
		
		<td width="15%" align="center" bgcolor="#FFFFFF"><!--<a href="#" class="list" onClick="edit('<%=manaUser.getAccount()%>','<%=manaUser.getPassword()%>')">编辑</a>　-->
		<a href="#" class="list" onClick="del('<%=manaUser.getAccount()%>','<%=manaUser.getPassword()%>')">删除</a></td>
	</tr>
	<%
		}
	%>
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
<form name="form2" action="${ctx}/admin/addAdmin.do?method=addAdmin"
	method="post" onsubmit="return checkform()">
<table width="740" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<tr align="center">
		<td><font color="red"> <logic:messagesPresent
			message="true">
			<html:messages id="error" name="user" message="true">
				<bean:write name="error" />
			</html:messages>
		</logic:messagesPresent> <logic:present name="reLogin">
			<bean:write name="reLogin" />
		</logic:present> <!--  显示权限控制信息--> </font></td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5">
		帐号名称：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="font5"> <input
			type="text" Class="input3" id="adminName" name="adminName" /> </span></td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5"> 密
		码：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="font5"> <input
			type="text" Class="input3" id="password" name="password" /> </span></td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5">区域：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="areacode">
		<input type="radio" id="area" name="area" value="110100" checked="checked" onclick="checkarea()"/>北京市
		<input type="radio" id="area" name="area" value="110" onclick="checkarea()" />
		<input type="hidden" name="areacode"/>
		<select name="areacode1" title="请选择残疾类别名称" id="areacode1" disabled="disabled">
    <% 
    	for(int i=0;i<ccc.size();i++){
    		Areacode areacode=(Areacode)ccc.get(i);%>
    		    <option value="<%=areacode.getAreacode()%>"><%=areacode.getAreaname()%></option> 
    <% }%>	
      
</select>
		</td>
	</tr>
</table>
<table width="740" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="35" align="center"><input type="submit" value="添加"
			Class="input4" /> <input type="reset" value="取消" Class="input4" /></td>
	</tr>
</table>
</form>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
