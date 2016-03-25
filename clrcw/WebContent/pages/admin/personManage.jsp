<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.UserInfo"%>
<%@ page import="model.PersonResume"%>
<%
int pagenum = (Integer) request.getSession()
				.getAttribute("pagenum");
 %>
<script language="JavaScript" type="text/JavaScript">
function resetss(){
	
	document.getElementById("qname").value="";
   document.getElementById("qmail").value="";
  
}
function change(s_id){

    document.getElementById("pnum").value=s_id;
    document.forms[0].action="${ctx}/admin/nextfindAllUserId.do?method=nextfindAllUserId";
	document.forms[0].submit();
}
function del(s_id,password,pn){
	var b = confirm("确实要删除吗？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.getElementById("password").value=password;
	    document.getElementById("pnum").value=pn;
	    document.forms[0].action="${ctx}/admin/delUser.do?method=delUser";

		document.forms[0].submit();
	
	}else{
		return false;
	}
}
function modify(s_id,password,pn){
	var b = confirm("确实要修改密码吗？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.getElementById("password").value=password;
	    document.getElementById("pnum").value=pn;
	    document.forms[0].action="${ctx}/admin/delUser.do?method=modifyUser";

		document.forms[0].submit();
	
	}else{
		return false;
	}
}
function search(){
 	   document.forms[0].action="${ctx}/admin/findAllUserId.do?method=findAllUserId";
       document.forms[0].submit();
 }
function batch_del(){
    if(hasSelect()){
       if(confirm ("是否真要删除？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
          document.forms[0].action="${ctx}/admin/delUser.do?method=bathDelUser";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要删除的选项");
	  }
  }
   function hasSelect(){
    var cbs = document.getElementsByName("ids");
     for(i=0;i<cbs.length;i++){
       if(cbs[i].checked==true)
         return true;
     }
     return false;
  }
function selectAll(){
    var cbs = document.getElementsByName("ids");
     for(i=0;i<cbs.length;i++){
       cbs[i].checked=true;
     }
    selectBox.href="javascript:unSelectAll()";
    selectBox.innerText="不选";
  }
  function unSelectAll(){
    var cbs = document.getElementsByName("ids");
     for(i=0;i<cbs.length;i++){
       cbs[i].checked=false;
     }
    selectBox.href="javascript:selectAll()";
    selectBox.innerText="全选";
  }
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人用户目录管理</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
</head>

<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="个人用户信息列表" />
</jsp:include>
<form action="" name="form1" method="POST">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
      	<tr style="height: 20px">
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				求职人姓名：
				<input type="text" id="qname" name="qname" value="<%=session.getAttribute("qname")!=null?session.getAttribute("qname"):"" %>"/></td>
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				邮件地址：
				<input type="text" id="qmail" name="qmail" value="<%=session.getAttribute("qmail")!=null?session.getAttribute("qmail"):"" %>"/></td>
		
		</tr>
           <tr style="height: 20px">
           		<td colspan="2" align="center">
		          <input type="button" style="width: 75px;border: 0px;" value="查询" onclick="search()"/>&nbsp;&nbsp;
		       <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/>&nbsp;&nbsp;
		          <input type="button" style="width: 75px;border: 0px;" value="删除" onclick="batch_del()"/>
	       	 </td>
	  	 </tr>
	   </table>
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
	<input type="hidden" id="pnum" name="pnum"  />
	<input type="hidden" id="password" name="password"  />
	<input type="hidden" id="delId"" name="delId"  />
	
	
	<tr style="height: 20px">
		<td width="5%" align="center" bgcolor="#EEF5FD" class="font5"><a href="javascript:selectAll()" id="selectBox">全选</a></td>
		<td width="5%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="20%" align="center" bgcolor="#EEF5FD" class="font5">用户登录名</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">姓名</td>
		<td width="20%" align="center" bgcolor="#EEF5FD" class="font5">联系电话</td>
		<td width="20%" align="center" bgcolor="#EEF5FD" class="font5">邮件地址</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">操作</td>
	</tr>
	<%
		List list = (List) request.getSession().getAttribute("userInfo");
		int zshu=(Integer)request.getSession().getAttribute("zongshu");
		int pc = (Integer) request.getSession().getAttribute("totleCount");

		for (int i = 0; i < list.size(); i++) {
			PersonResume userInfo = (PersonResume) list.get(i);
	%>
	<tr style="height: 20px">
		<td align="center" bgcolor="#FFFFFF" class="font5"><input style="width: 45px;border: 0px;" name="ids" type="checkbox" value="<%=userInfo.getUser().getLoginId()%>"/></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=pagenum * 10 + i + 1%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getUser().getLoginId()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getName()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getPhone()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getUser().getMailAddr()%></td>

		<td align="center" bgcolor="#FFFFFF"><!--<a href="#" class="list" onClick="edit('<%=userInfo.getUser().getLoginId()%>','<%=userInfo.getUser().getPassword()%>')">查看</a>　--><a
			href="#" class="list"
			onClick="del('<%=userInfo.getUser().getLoginId() %>','<%=userInfo.getUser().getPassword()%>',<%=pagenum%>)">删除</a>
			<a href="${ctx}/companyAbility.do?method=showOneResume&userKeyId=<%=userInfo.getUser().getId()%>" class="list" >查看</a>
			<a
			href="#" class="list"
			onClick="modify('<%=userInfo.getUser().getLoginId() %>','<%=userInfo.getUser().getPassword()%>',<%=pagenum%>)">修改密码</a></td>
	</tr>

	<%
		}
	%>
	<%
		if (pagenum == pc && pc != 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a></td>
	</tr>

	<%
		} else if (pagenum == 0 && pc != 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a>
		<a href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("totleCount") %>)">尾页&nbsp;</a></td>
	</tr>
	<%
		} else if (pagenum == 0 && pc == 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9"></td>
	</tr>
	<%
		} else {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a> <a
			href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("totleCount") %>)">尾页&nbsp;</a></td>
	</tr>

	<%
		}
	%>

</table>
</form>
<table width="100%" border="0" align="center" cellpadding="0"
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
