<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.CompBespeak"%>
<%int pagenum = (Integer) request.getSession().getAttribute("pagenum"); %>
<script language="JavaScript" type="text/JavaScript">
function resetss(){
	
	document.getElementById("qname").value="";
  
   
  
}
 function delteaglient(a){
 if(confirm("确认要撤销该代理招聘信息？")){
  document.forms[0].action="${ctx}/admin/aglientpublish.do?method=delaglient&apllyId="+a;
	document.forms[0].submit();}
 }
function change(s_id){
    document.getElementById("pnum").value=s_id;
    document.forms[0].action="${ctx}/admin/aglientpublish.do?method=nextfindaglient";
	document.forms[0].submit();
}
function search(){
 	   document.forms[0].action="${ctx}/admin/aglientpublish.do?method=aglientpublish";
       document.forms[0].submit();
 }
function register(){
  window.open("${ctx}/admin/aglientpublish.do?method=companyjsp");
       document.forms[0].submit();

}

function hasSelect(){
    var cbs = document.getElementsByName("ids");
     for(i=0;i<cbs.length;i++){
       if(cbs[i].checked==true)
         return true;
     }
     return false;
  }

</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>代理招聘企业页面</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet" type="text/css">
</head>
<script language="JavaScript" src="${ctx}/public/js/tree.js"></script>
<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="待理招聘列表"/>
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
           <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/>
      	 </td>
      	 
 	 </tr>
  </table>
<input type="hidden" name="id" value="">
<input type="hidden" id="pnum" name="pnum" value="">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
 
  <tr>
      <td width="15%" align="center" bgcolor="#FFF7F0" class="font5">编号</td>
    <td width="20%" align="center" bgcolor="#FFF7F0" class="font5">企业名称</td>
    <td width="15%" align="center" bgcolor="#FFF7F0" class="font5">法人</td>
    <td width="15%" align="center" bgcolor="#FFF7F0" class="font5">联系人</td>
    <td width="20%" align="center" bgcolor="#FFF7F0" class="font5">联系电话</td>
    <td width="15%" align="center" bgcolor="#FFF7F0" class="font5">操　作</td>
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
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=i+1%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getCompName()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getCompAddr()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getLinkman()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getTelephone()%></td>

		<td align="center" bgcolor="#FFFFFF">
			<a href="${ctx}/admin/aglientpublish.do?method=checkaglient&apllyId=<%=bespeak.getId()%>" target="_blank" class="list" >查看</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#"  onclick="delteaglient('<%=bespeak.getId()%>')"  class="list" >撤销</a>
		</td>
	</tr>

	<%
		}}else{
		%><font class="font3"> 没有代理招聘企业信息!</font><%
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
<div align="center"><button name="button" class="input8" 
						onclick="register()" id="button" style="width:100px;"
						>
										注册用户
									</button></div>
</form>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40">&nbsp; </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
