<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PersonResume"%>


<style>
html,body{font-size:12px;margin:0px;height:100%;}
.mesWindow{border:#666 1px solid;background:#fff;}
.mesWindowTop{border-bottom:#eee 1px solid;margin-left:4px;padding:3px;font-weight:bold;text-align:left;font-size:12px;}
.mesWindowContent{margin:4px;font-size:12px;}
.mesWindow .close{height:15px;width:28px;border:none;cursor:pointer;text-decoration:underline;background:#fff}
</style>
<script>
var isIe=(document.all)?true:false;
//设置select的可见状态
function deletaglient(a){
if(confirm("确认要撤销该代理求职信息？")){
  document.forms[0].action="${ctx}/admin/aglientapply.do?method=deleteaglient&apllyId="+a;
	document.forms[0].submit();}
 }

function setSelectState(state)
{
var objl=document.getElementsByTagName('select');
for(var i=0;i<objl.length;i++)
{
objl[i].style.visibility=state;
}
}//欢迎来到站长特效网，我们的网址是www.zzjs.net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
function mousePosition(ev)
{
if(ev.pageX || ev.pageY)
{
return {x:ev.pageX, y:ev.pageY};
}
return {
x:ev.clientX + document.body.scrollLeft - document.body.clientLeft,y:ev.clientY + document.body.scrollTop - document.body.clientTop
};
}
//让背景渐渐变暗
function showBackground(obj,endInt)
{if(isIe)
{
obj.filters.alpha.opacity+=5;
if(obj.filters.alpha.opacity<endInt)
{
setTimeout(function(){showBackground(obj,endInt)},5);
}
}else{
var al=parseFloat(obj.style.opacity);al+=0.05;
obj.style.opacity=al;
if(al<(endInt/100))
{setTimeout(function(){showBackground(obj,endInt)},5);}
}
}
//关闭窗口
function closeWindow()
{if(document.getElementById('back')!=null)
{
document.getElementById('back').parentNode.removeChild(document.getElementById('back'));
}
if(document.getElementById('mesWindow')!=null)
{
document.getElementById('mesWindow').parentNode.removeChild(document.getElementById('mesWindow'));
}
if(isIe){
setSelectState('');}
}
</script>


<script language="JavaScript" type="text/JavaScript">
function resetss(){
	
	document.getElementById("uname").value="";
   
  
}
function change(s_id){
    document.getElementById("apppnum").value=s_id;
    document.forms[0].action="${ctx}/admin/aglientapply.do?method=nextfindapp";
	document.forms[0].submit();
}
function search(){
 	   document.forms[0].action="${ctx}/admin/aglientapply.do?method=aglientapply";
       document.forms[0].submit();
 }
function register(){
  window.open("${ctx}/admin/aglientapply.do?method=goOnRegist");
       document.forms[0].submit();

}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>代理求职列表</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
	<script src="${ctx}/public/js/calendar.js"></script>
	
</head>

<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="代理求职列表" />
</jsp:include>

<form action="" name="form1" method="POST">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
      	<tr style="height: 20px">
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				求职人姓名：
				<input type="text" id="uname" name="uname" value="<%=session.getAttribute("uname")!=null?session.getAttribute("uname"):"" %>"/></td>
			
				</tr>
           <tr style="height: 20px">
           		<td colspan="5" align="center">
		           <input type="button" style="width: 75px;border: 0px;" value="查询" onclick="search()"/>&nbsp;&nbsp;
		        <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/>&nbsp;&nbsp;
	       	 </td>
	  	 </tr>
	   </table>
  <br/>
<table width="98%" border="0" align="center" cellpa dding="3"
	cellspacing="1" bgcolor="#cccccc">
	<input type="hidden" id="apppnum" name="apppnum" value=""/>
	<tr>
        <td width="5%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="5%" align="center" bgcolor="#EEF5FD" class="font5">姓名</td>
		<td width="5%" align="center" bgcolor="#EEF5FD" class="font5">最高学历</td>
		<td width="9%" align="center" bgcolor="#EEF5FD" class="font5">联系电话</td> 
		<td width="10%" align="center" bgcolor="#EEF5FD" class="font5">操作</td>
	</tr>
	
	<%int zshu=(Integer)request.getSession().getAttribute("appzongshu");
	List list=(List)request.getSession().getAttribute("personresume");
	int pageIndex=(Integer)request.getSession().getAttribute("pageIndex");
	int pc=(Integer)request.getSession().getAttribute("pc");
	if(list!=null&&list.size()>0){
	for(int i=0;i<list.size();i++){
	PersonResume personresume=(PersonResume)list.get(i);
	
	 %>
	<tr>
	
		<td align="center" width="20%" bgcolor="#FFFFFF" class="font5"><%=pageIndex * 10 + i + 1%></td>
		<td align="center" width="20%" bgcolor="#FFFFFF" class="font5"><%=personresume.getName()%></td>
		<td align="center" width="20%" bgcolor="#FFFFFF" class="font5"><%=personresume.getEducate().getEducateName()%></td>
		<td align="center" width="20%" bgcolor="#FFFFFF" class="font5"><%=personresume.getPhone() %></td>
	
		<td align="center"  bgcolor="#FFFFFF" width="20%"><a
			href="${ctx}/admin/aglientapply.do?method=checkaglient&apllyId=<%=personresume.getUser().getId()%>" class="list"
			onClick="" target="_blank">查看</a>&nbsp;&nbsp;
			<a
			href="#" class="list"
			onClick="deletaglient('<%=personresume.getUser().getId()%>')">撤销</a>
			</td>
		
	</tr>



	<%
		}}
	%>
	<%
		if (pageIndex == pc && pc != 0) {
	%>
	<tr>
		<td height="20" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pageIndex+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pageIndex%>-1)">上一页</a></td>
	</tr>   

	<%
		} else if (pageIndex == 0 && pc != 0) {
	%>
	<tr>
		<td height="20" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pageIndex+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
		<a href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("pc") %>)">尾页&nbsp;</a></td>
	</tr>
	<%
		} else if (pageIndex == 0 && pc == 0) {
	%>
	<tr>
		<td height="20" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pageIndex+1%>/<%=pc+1 %>&nbsp;&nbsp;</td>
	</tr>
	<%
		} else {
	%>
	<tr>
		<td height="20" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pageIndex+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pageIndex%>-1)">上一页</a> <a href="#"
			class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a> <a
			href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("pc") %>)">尾页&nbsp;</a></td>
	</tr>

	<%
		}
	%>

</table>
<div align="center"><button name="button" class="input8" style="width:100px;"

						onclick="register()" id="button">
										注册用户
									</button></div>
</form>
<table width="98%" border="0" align="center" cellpadding="0"
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





			