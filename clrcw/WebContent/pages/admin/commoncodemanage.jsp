<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@page import="model.Commoncode" %>
<%
	Commoncode tes = (Commoncode)request.getAttribute("comcode");

	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>类型管理</title>
	<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
		rel="stylesheet" type="text/css">
	<script language="JavaScript" type="text/JavaScript">
function del(s_id){
	var b = confirm("确实要删除吗？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.forms[0].action="${ctx}/admin/commoncodemanage.do?method=del";
		document.forms[0].submit();
	}else{
		return false;
		}
	}
	
function checkform(){ 
	commonvalues = document.form2.commonvalues.value;
	code = document.form2.code.value;
	if(commonvalues.length>20){
	     alert("commonvalues不能大于20个字符");
	     document.getElementById("commonvalues").focus();
	     if(commonvalues.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0){ 
			alert("commonvalues为空或包含非法字符"); 
		 	document.getElementById("commonvalues").focus();
			return false; 
		}
		
	     return false;
	   }
	
	
}
	</script>
</head>

<body>
	<jsp:include page="include/contentHeader.jsp">
		<jsp:param name="contentTitle" value="类型管理" />
	</jsp:include>
	<form action="" name="form1" method="post">
		<input type="hidden" name="delId" value="" />
		<s:hidden name="commontype" id="commontype"></s:hidden>
		<table width="740" border="0" align="center" cellpadding="3"
			cellspacing="1" bgcolor="#cccccc">
			<tr>
				<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">
					编号
				</td>
				<td width="20%" align="center" bgcolor="#EEF5FD" class="font5">
					类型
				</td>
				
				<td width="20%" align="center" bgcolor="#EEF5FD" class="font5">
					缺省值
				</td>
				

			</tr>
			<logic:present name="MCommoncode">
			
				<logic:iterate id="cmcode" name="MCommoncode"
					type="model.Commoncode">
					<%if("days                                              ".equals(cmcode.getCommontype())){%>
					<tr>
						<td width="15%" align="center" bgcolor="#FFFFFF" class="font5">
							<bean:write name="cmcode" property="id" />
						</td>
						<td width="35%" align="center" bgcolor="#FFFFFF" class="font5">
							<bean:write name="cmcode" property="code" />
						</td>
						
						<td width="35%" align="center" bgcolor="#FFFFFF" class="font5">
							<bean:write name="cmcode" property="commonvalues" />
						</td>
						
					</tr><%} %>
				</logic:iterate>
			</logic:present>
			<logic:notPresent name="MCommoncode">
				<p class="font5">
					还没有信息!请添加
				</p>
			</logic:notPresent>
		</table>
	</form>
	<form action="${ctx}/admin/commoncodemanage.do?method=update" name="form2"
		method="post" onsubmit="return checkform()">
		<table width="740" border="0" align="center" cellpadding="3"
			cellspacing="1" bgcolor="#cccccc">
			<tr>
				<s:hidden name="commontype" id="commontype"></s:hidden>
				<input type="hidden" name="delId" value="" />
			
				<td width="25%" align="center" bgcolor="#EEF5FD" class="font5">
					类型
				</td>
				<td bgcolor="#EEF5FD" width="25%">
					<select name="code" id="code">
						<option value="1">
							个人
						</option>
						<option value="2">
							公司
						</option>
					</select>
				</td>
				<td width="25%" align="center" bgcolor="#EEF5FD" class="font5">
					缺省值
				</td>
				<td bgcolor="#EEF5FD" width="25%">
					<input type="text" name="commonvalues" id="commonvalues" value="">
				</td>
			</tr>
		
			</table>
			<table width="740" border="0" align="center" cellpadding="3"
				cellspacing="1">
				<td height="100%" align="center" align="center">
					<input type="submit" value="保存" Class="input4" />
					<input type="reset" value="取消" Class="input4" />
				</td>
			</table>
			</form>
			<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
