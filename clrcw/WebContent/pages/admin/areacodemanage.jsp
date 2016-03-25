<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" language="JavaScript">
		function del(s_id){
			var b = confirm("确实要删除吗？");
			if(b){
			    document.getElementById("delId").value=s_id;
			    document.forms[0].action="${ctx}/admin/areacodemanage.do?method=del";
				document.forms[0].submit();
			}else{
				return false;
			}
	}
	
	function checkform(){ 
	areacode = document.form2.areacode.value;
	areaname = document.form2.areaname.value;
	var code= document.getElementsByName("code");
 	var name= document.getElementsByName("name");
 	for(i=0;i<code.length;i++){
	
	if($.trim(code[i].value)==$.trim(areacode)){
	
	alert("不能添加重复的区县编号");
	return false;
	}
	}
	
 	
 	for(i=0;i<name.length;i++){
	
	if($.trim(name[i].value)==$.trim(areaname)){
	
	alert("不能添加重复的区县名称");
	return false;
	}
	}
	if(areacode.length>20){
	     alert("区县编码不能大于20个字符");
	     document.getElementById("areacode").focus();
 return false;	    
}
	     
	     if(areacode.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0){ 
			alert("区县编码为空或包含非法字符"); 
		 	document.getElementById("areacode").focus();
			return false; 
		}
		
	    
	   
	if(areaname.length>20){
	     alert("区县名称不能大于20个字符");
	     document.getElementById("areaname").focus();
	    return false;
	     }
	     
	     if(areaname.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0){ 
			alert("区县名称为空或包含非法字符"); 
		 	document.getElementById("areaname").focus();
			return false; 
		}
		
	     
	  
	
}
	</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>区县管理</title>
	<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
		rel="stylesheet" type="text/css">
	
</head>

<body>
	<jsp:include page="include/contentHeader.jsp">
		<jsp:param name="contentTitle" value="区域列表" />
	</jsp:include>
	<form action="" name="form1" method="post">
		<input type="hidden" name="delId" id="delId" value="" />
		<table width="740" border="0" align="center" cellpadding="3"
			cellspacing="1" bgcolor="#cccccc">
			<tr>
				<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">
					编号
				</td>
				<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">
					区县编号
				</td>
				<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">
					区县名称
				</td>
				<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">
					操作
				</td>

			</tr>
			<logic:present name="MAreacode">
				<logic:iterate id="amcode" name="MAreacode" type="model.Areacode" indexId="index">
					 <input type="hidden" name="code" id="code" value="<bean:write name="amcode" property="areacode" />">
					 <input type="hidden" name="name" id="name" value="<bean:write name="amcode" property="areaname" />">
					<tr>
						<td width="15%" align="center" bgcolor="#FFFFFF" class="font5">
							<%=index+1%>
						</td>
						<td width="25%" align="center" bgcolor="#FFFFFF" class="font5">
							<bean:write name="amcode" property="areacode" />
						</td>
						<td width="25%" align="center" bgcolor="#FFFFFF" class="font5">
							<bean:write name="amcode" property="areaname" />
						</td>
						<td width="15%" align="center" bgcolor="#FFFFFF">
							<a href="#" class="list" onClick="del(${amcode.id})">删除</a>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
			<logic:notPresent name="MAreacode">
				<p class="font5">
					还没有信息!请添加
				</p>
			</logic:notPresent>
		</table>


	</form>
	<form action="${ctx}/admin/areacodemanage.do?method=add" name="form2" method="post" onsubmit="return checkform()">
		<table width="740" border="0" align="center" cellpadding="3"
			cellspacing="1" bgcolor="#cccccc">
			<tr>
				<!--<s:hidden name="commontype" id="commontype"></s:hidden>-->
				<!--<input type="hidden" name="delId" value="" />-->
			
				<td width="25%" align="center" bgcolor="#EEF5FD" class="font5">
					区县编号
				</td>
				<td bgcolor="#EEF5FD" width="25%">
								<input type="text" name="areacode" id=areacode value="">
				</td>
				<td width="25%" align="center" bgcolor="#EEF5FD" class="font5">
					区县名称
				</td>
				<td bgcolor="#EEF5FD" width="25%">
					<input type="text" name="areaname" id="areaname" value="">
				</td>
			</tr>
		
			</table>
			<table width="740" border="0" align="center" cellpadding="3"
				cellspacing="1">
				<td height="100%" align="center" align="center">
					<input type="submit" value="添加" Class="input4" />
					<input type="reset" value="取消" Class="input4" />
				</td>
			</table>
			</form>
	

	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
