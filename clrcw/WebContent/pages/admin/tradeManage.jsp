<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
<script language="JavaScript" type="text/JavaScript">

function del(s_id){
	var b=confirm("确实要删除行业信息吗");
	if(b){
		document.getElementById("id").value=s_id;
		document.forms[0].action="${ctx}/admin/compTradeManage.do?method=del";
		document.forms[0].submit();
	}
	else
		return false;
}
		 
function checkform(){ 
	tradeName = document.form2.tradeName.value;
	var name= document.getElementsByName("trade");
	
	for(i=0;i<name.length;i++){
	
	if($.trim(name[i].value)==$.trim(tradeName)){
	alert("不能添加重复的行业名称");
	return false;
	}
	}
	if(tradeName.length>10){
	     alert("行业名称不能大于10个字符");
	     document.getElementById("tradeName").focus();
	     return false;
	}
	if(tradeName.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0){ 
		alert("行业名称为空或包含非法字符"); 
	 	document.getElementById("tradeName").focus();
		return false; 
	}
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行业分类目录管理</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">

</head>

<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="行业目录列表"/>
</jsp:include>

<form action="" name="form1" method="post">
<input type="hidden" name="id" id="id"/>
<table width="740" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<tr>
		<td width="15%"  align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="70%" align="center" bgcolor="#EEF5FD" class="font5">行业名称</td>
		<td width="15%"  align="center" bgcolor="#EEF5FD" class="font5">操作</td>
	</tr>

	<logic:present name="MTrade">
		<logic:notEmpty name="MTrade">
			<logic:iterate id="trade" name="MTrade" type="model.BdTrade" indexId="index">
			<input type="hidden" name="trade" id="trade" value="<bean:write
						name="trade" property="tradeName" />">
				<tr>
					<td  width="15%"  align="center" bgcolor="#FFFFFF" class="font5"><%=index+1%></td>
					<td  width="70%"  align="center" bgcolor="#FFFFFF" class="font5"><bean:write
						name="trade" property="tradeName" /></td>
					<td  width="15%"  align="center" bgcolor="#FFFFFF">
					<a href="#" class="list" onClick="del(${trade.id})">删除</a>	
						</td>
				</tr>
			</logic:iterate>
		</logic:notEmpty>
		<logic:empty name="MTrade">
			<p class="font5">还没有行业信息!请添加</p>
		</logic:empty>
	</logic:present>
	<logic:notPresent name="MTrade">
		<p class="font5">还没有行业信息!请添加</p>
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
<form action="${ctx}/admin/compTradeManage.do?method=add"  name="form2" method="post" onsubmit="return checkform()">
<table width="740" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	<tr>
		<td valign="top" bgcolor="#EEF5FD"><span class="font5">
		行业名称：</span></td>
		<td colspan="3" bgcolor="#FFFFFF"><span class="font5"> <input
			type="text" Class="input3" id="tradeName" name="tradeName" /> </span></td>
	</tr>
</table>
<table width="740" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="35" align="center"><input type="submit" value="添加"
			Class="input4" /> <input type="reset" value="取消" Class="input4"
			onclick="window.close()" /></td>
	</tr>
</table>
</form>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
