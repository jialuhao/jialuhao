<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.CompBespeak"%>
<%int pagenum = (Integer) request.getSession().getAttribute("pagenum"); %>
<script language="JavaScript" type="text/JavaScript">
function resetss(){
	
	document.getElementById("qname").value="";
   
  
}
function del(s_id){
	var b = confirm("确实要删除吗" );
	if(b){
	    document.form1.id.value=s_id;
	    document.form1.action="${ctx}/admin/showAllBespeak.do?method=delBespeak";
		document.form1.submit();
	}else{
		return false;
	}
}

function modifypassword(s_id){
	var b = confirm("确实要修改密码吗" );
	if(b){
	    document.form1.id.value=s_id;
	    document.form1.action="${ctx}/admin/showAllBespeak.do?method=modifypassword";
		document.form1.submit();
	}else{
		return false;
	}
}
function batch_del(){
    if(hasSelect()){
       if(confirm ("是否真要删除？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
          document.forms[0].action="${ctx}/admin/showAllBespeak.do?method=bathDelBespeak";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要删除的选项");
	  }
  }
  function batchqy(){
    if(hasSelect()){
       if(confirm ("是否真要审核通过？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
          document.forms[0].action="${ctx}/admin/showAllBespeak.do?method=bathQYBespeak";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要审核通过的选项");
	  }
  }
  
function change(s_id){
    document.getElementById("pnum").value=s_id;
    document.forms[0].action="${ctx}/admin/nextShowAllBespeak.do?method=nextShowAllBespeak";
	document.forms[0].submit();
}
function search(){
 	   document.forms[0].action="${ctx}/admin/showAllBespeak.do?method=showAllBespeak";
       document.forms[0].submit();
 }
function showbespeak(s_id){
	document.form1.id.value=s_id;
	document.form1.action="${ctx}/admin/showAllBespeak.do?method=manaBespeak";
	document.form1.submit();
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
<title>待审核企业页面</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet" type="text/css">
</head>
<script language="JavaScript" src="${ctx}/public/js/tree.js"></script>
<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="待审核企业管理"/>
</jsp:include>
<form action="" name="form1" method="post">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
      	<tr style="height: 20px">
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				企业名称：
				<input type="text" id="qname" name="qname" value="<%=session.getAttribute("qname")!=null?session.getAttribute("qname"):"" %>"/></td>
		
		</tr>
         <tr style="height: 20px">
         		<td align="center">
          <input type="button" style="width: 75px;border: 0px;" value="查询" onclick="search()"/>&nbsp;&nbsp;
           <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/>&nbsp;&nbsp;
          <!--<input type="button" style="width: 75px;border: 0px;" value="审核通过" onclick="batchqy()"/>&nbsp;&nbsp;
          --><input type="button" style="width: 75px;border: 0px;" value="删除" onclick="batch_del()"/>
      	 </td>
 	 </tr>
  </table>
<input type="hidden" name="id" value="">
<input type="hidden" id="pnum" name="pnum" value="">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td height="30px" colspan="6" bgcolor="#FFFFFF" class="font5">&nbsp;<a href="#">· </a>
	<a href="${ctx}/admin/showAllBespeak.do?method=showAllBespeak" class="f2">待审核企业</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${ctx}/admin/showAllCompany.do?method=showAllCompany" >· 已审核企业</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
  </tr>
  <tr><!--
    <td width="5%" align="center" bgcolor="#EEF5FD" class="font5"><a href="javascript:selectAll()" id="selectBox">全选</a></td>
    --><td width="20%" align="center" bgcolor="#FFF7F0" class="font5">企业名称</td>
    <td width="20%" align="center" bgcolor="#FFF7F0" class="font5">法人</td>
    <td width="13%" align="center" bgcolor="#FFF7F0" class="font5">联系人</td>
    <td width="12%" align="center" bgcolor="#FFF7F0" class="font5">联系电话</td>
    <td width="20%" align="center" bgcolor="#FFF7F0" class="font5">操　作</td>
  </tr>
  
  <%
		List list = (List) request.getSession().getAttribute("bespeak");
		int zshu=(Integer)request.getSession().getAttribute("zongshu");
		int pc = (Integer) request.getSession().getAttribute("totleCount");
		if(list!=null&&list.size()>0){
		for (int i = 0; i < list.size(); i++) {
			CompBespeak bespeak = (CompBespeak) list.get(i);
	%>
  <tr style="height: 20px">
		<!--<td align="center" bgcolor="#FFFFFF" class="font5"><input style="width: 45px;border: 0px;" name="ids" type="checkbox" value="<%=bespeak.getId()%>"/></td>
		--><td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getCompName()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getCompAddr()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getLinkman()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getTelephone()%></td>

		<td align="center" bgcolor="#FFFFFF">
			<a href="#" class="list" onClick="showbespeak('<%=bespeak.getId()%>')">进入</a>
			<a href="#" class="list" onClick="del('<%=bespeak.getId()%>')">删除</a>
			<a href="#" class="list" onClick="modifypassword('<%=bespeak.getId()%>')">修改密码</a>
		</td>
	</tr>

	<%
		}}else{
		%><font class="font3"> 没有待审核企业信息!</font><%
		}
	%>
	<%
		if (pagenum == pc && pc != 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="6" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a></td>
	</tr>

	<%
		} else if (pagenum == 0 && pc != 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="6" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a>
		<a href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("totleCount") %>)">尾页&nbsp;</a></td>
	</tr>
	<%
		} else if (pagenum == 0 && pc == 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="6" align="right" bgcolor="FEF9F9"></td>
	</tr>
	<%
		} else {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="6" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
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
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40">&nbsp; </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
