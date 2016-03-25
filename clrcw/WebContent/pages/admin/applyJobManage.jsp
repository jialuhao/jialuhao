<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PersonResume"%>
<%@ page import="model.BdPost"%>
<%int pagenum = (Integer) request.getSession().getAttribute("apppagenum"); %>

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
//弹出方法
function showMessageBox(wTitle,content,pos,wWidth)
{
closeWindow();
var bWidth=parseInt(document.documentElement.scrollWidth);
var bHeight=parseInt(document.documentElement.scrollHeight);
if(isIe){

setSelectState('hidden');}
var back=document.createElement("div");
back.id="back";
var styleStr="top:0px;left:0px;position:absolute;background:#666;width:"+bWidth+"px;height:"+bHeight+"px;";
styleStr+=(isIe)?"filter:alpha(opacity=0);":"opacity:0;";
back.style.cssText=styleStr;
document.body.appendChild(back);
showBackground(back,50);
var mesW=document.createElement("div");
mesW.id="mesWindow";
mesW.className="mesWindow";
mesW.innerHTML="<div class='mesWindowTop'><table width='100%' height='100%'><tr><td>"+wTitle+"</td><td style='width:1px;'><input type='button' onclick='closeWindow();' title='关闭窗口' class='close' value='关闭' /></td></tr></table></div><div class='mesWindowContent' id='mesWindowContent'>"+content+"</div><div class='mesWindowBottom'></div>";
var v_top=(document.body.clientHeight-mesW.clientHeight)/2;
v_top+=document.documentElement.scrollTop;
styleStr="top:"+(v_top-180)+"px;left:"+(document.body.clientWidth/2-mesW.clientWidth/2)+"px;position:absolute;width:600px;margin-left:-300px;left:50%;z-index:9999;";
mesW.style.cssText=styleStr;
document.body.appendChild(mesW);
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
//测试弹出
function testMessageBox(ev,messContent,title)
{

var objPos = mousePosition(ev);

showMessageBox(title,messContent,objPos,350);
}
</script>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
	<script src="${ctx}/public/js/calendar.js"></script>

<script language="JavaScript" type="text/JavaScript"><!--
function resetss(){
	
	document.getElementById("uname").value="";
   document.getElementById("postId").value="";
  document.getElementById("education").value="";
   document.getElementById("workyear").value="";
   document.getElementById("sta").value="";
  
}
function search(){
 	   document.forms[0].action="${ctx}/admin/findAllapplyJob.do?method=findApplyJob";
       document.forms[0].submit();
 }



function change(s_id){
    document.getElementById("apppnum").value=s_id;
    document.forms[0].action="${ctx}/admin/findAllapplyJob.do?method=nextfindapp";
	document.forms[0].submit();
}


function del(s_id,pn){
	var b = confirm("确定要审核该信息？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.getElementById("apppnum").value=pn;
	    document.forms[0].action="${ctx}/admin/SHApplyJob.do?method=updateAJob";

		document.forms[0].submit();
	
	}else{
		return false;
	}
}

function del1(s_id,pn){
	var b = confirm("确定要撤销该信息？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.getElementById("shapp").value="0";
	    document.getElementById("apppnum").value=pn;
	    document.forms[0].action="${ctx}/admin/SHApplyJob.do?method=updateAJob";

		document.forms[0].submit();
	
	}else{
		return false;
	}
}
function cx(){
    if(hasSelect()){
       if(confirm ("是否审核不通过？")){
       	  document.getElementById("apppnum").value="<%=pagenum%>";
       	  document.getElementById("shapp").value="1";
          document.forms[0].action="${ctx}/admin/SHApplyJob.do?method=updateperson";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要审核不通过的选项");
	  }
  }
  function sh(){
    if(hasSelect()){
    
    
       if(confirm ("是否真要审核？")){
       	  document.getElementById("apppnum").value="<%=pagenum%>";
       	   document.getElementById("shapp").value="2";
       	 
          document.forms[0].action="${ctx}/admin/SHApplyJob.do?method=updateperson";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要审核的选项");
	  }
  }
function batch_del(){
    if(hasSelect()){
       if(confirm ("是否真要删除？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
          document.forms[0].action="${ctx}/admin/findAllapplyJob.do?method=bathDelApplyJob";
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
--></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>求职信息审核</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
</head>

<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="求职信息列表" />
</jsp:include>

<form action="" name="form1" method="POST">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
      	<tr style="height: 20px">
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				求职人姓名：
				<input type="text" id="uname" name="uname" value="<%=session.getAttribute("uname")!=null?session.getAttribute("uname"):"" %>"/></td>
			
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				残疾类别：
				 <select name="postId" id="postId">
				<option value="">--请选择--</option>
					<%		String dkind=(String)request.getSession().getAttribute("postId");

															List bdPostlist = (List) request.getSession().getAttribute("bdPost");

																if (bdPostlist != null) {

																	for (int i = 0; i < bdPostlist.size(); i++) {
																		BdPost bdPost = new BdPost();
																		bdPost = (BdPost) bdPostlist.get(i);
														%>
														<option value="<%=bdPost.getId()%>" <%if((bdPost.getId()+"").equals(dkind)){ %>selected<%} %>><%=bdPost.getPostName()%></option>
														<%
															}
																}
														%>
				</select>	</td>
			
			
		
		
		<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				学历要求：
				<select name="education" id="education">
					<option value="">--请选择--</option>
					
					<option value="5" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("5")){%>selected="selected"<%} %>>小学</option>
					<option value="6" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("6")){%>selected="selected"<%} %>>初中</option>
					<option value="7" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("7")){%>selected="selected"<%} %>>高中</option>
					<option value="8" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("8")){%>selected="selected"<%} %>>技工学校</option>
					<option value="9" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("9")){%>selected="selected"<%} %>>中专或中技</option>
					<option value="10" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("10")){%>selected="selected"<%} %>>大学专科和专科学校</option> 
					<option value="11" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("11")){%>selected="selected"<%} %>>大学本科</option>
					<option value="12" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("12")){%>selected="selected"<%} %>>研究生</option>
				</select></td>
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;" >
				审核状态：
				<select name="sta" id="sta">
				    <option value="">--请选择--</option>
					<option value="0" <%if(session.getAttribute("sta")!=null&&session.getAttribute("sta").equals("0")){%>selected="selected"<%} %>>待审核</option>   
				    <option value="1" <%if(session.getAttribute("sta")!=null&&session.getAttribute("sta").equals("1")){%>selected="selected"<%} %>>审核未通过</option> 
				    <option value="2" <%if(session.getAttribute("sta")!=null&&session.getAttribute("sta").equals("2")){%>selected="selected"<%} %>>审核通过</option> 
				</select></td>
				<%String areacode=(String)request.getSession().getAttribute("areacode"); 
		if(!areacode.equals("")){
		%>
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				区县：<br/>
				<select name="workyear" id="workyear">
				    <option value="">--请选择--</option>
					<option value="东城区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("东城区")){%>selected="selected"<%} %>>东城区</option>   
				    <option value="西城区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("西城区")){%>selected="selected"<%} %>>西城区</option> 
			        <option value="朝阳区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("朝阳区")){%>selected="selected"<%} %>>朝阳区</option>   
				    <option value="丰台区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("丰台区")){%>selected="selected"<%} %>>丰台区</option> 
				    <option value="石景山区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("石景山区")){%>selected="selected"<%} %>>石景山区</option>   
				    <option value="海淀区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("海淀区")){%>selected="selected"<%} %>>海淀区</option> 
				    <option value="门头沟区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("门头沟区")){%>selected="selected"<%} %>>门头沟区</option>   
				    <option value="燕山区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("燕山区")){%>selected="selected"<%} %>>燕山区</option> 
				    <option value="房山区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("房山区")){%>selected="selected"<%} %>>房山区</option>   
				    <option value="通州区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("通州区")){%>selected="selected"<%} %>>通州区</option> 
				    <option value="顺义区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("顺义区")){%>selected="selected"<%} %>>顺义区</option>   
				    <option value="昌平区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("昌平区")){%>selected="selected"<%} %>>昌平区</option> 
				     <option value="大兴区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("大兴区")){%>selected="selected"<%} %>>大兴区</option>   
				    <option value="怀柔区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("怀柔区")){%>selected="selected"<%} %>>怀柔区</option> 
				    <option value="平谷区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("平谷区")){%>selected="selected"<%} %>>平谷区</option>   
				     <option value="外埠" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("外埠")){%>selected="selected"<%} %>>外埠</option> 
				</select></td>
				<% }%>
				
				</tr>
           <tr style="height: 20px">
           		<td colspan="4" align="center">
		           <input type="button" style="width: 75px;border: 0px;" value="查询" onclick="search()"/>&nbsp;&nbsp;
		           <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/><!--&nbsp;&nbsp;
		          <input type="button" style="width: 75px;border: 0px;" value="审核通过" onclick="sh()"/>&nbsp;&nbsp;
		          <input type="button" style="width: 75px;border: 0px;" value="审核不通过" onclick="cx()"/>&nbsp;&nbsp;
		         --><!-- >input type="button" style="width: 75px;border: 0px;" value="删除" onclick="batch_del()"/-->
	       	 </td>
	  	 </tr>
	   </table><br/>
<table width="99%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">       
	
	<input type="hidden" id="apppnum" name="apppnum" value=""/>
	<input type="hidden" id="pnum" name="pnum" value=""/>
	<input type="hidden" id="delId" name="delId" value=""/>
	<input type="hidden" id="shapp" name="shapp" value=""/>
	
	<tr>
		<!--<td width="5%" align="center" bgcolor="#EEF5FD" class="font5"><a href="javascript:selectAll()" id="selectBox">全选</a></td>
		--><td width="5%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">求职人姓名</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">残疾类别</td>
		<td width="10%" align="center" bgcolor="#EEF5FD" class="font5">户籍所在地</td>
		<td width="8%" align="center" bgcolor="#EEF5FD" class="font5">联系电话</td>
		<td width="8%" align="center" bgcolor="#EEF5FD" class="font5">审核状态</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">操作</td>
	</tr>
	<%
		List list = (List) request.getSession().getAttribute("personresume");
		int zshu=(Integer)request.getSession().getAttribute("appzongshu");
		int pc = (Integer) request.getSession().getAttribute("apptotleCount");
        String reg="";
      
		for (int i = 0; i < list.size(); i++) {
			PersonResume userInfo = (PersonResume) list.get(i);
			String state=userInfo.getState();
			if("0".equals(state)){
			reg="待审核";
			}
			if("1".equals(state)){
			reg="审核未通过";
			}
			if("2".equals(state)){
			reg="审核通过";
			}
			
		//String jobname=	userInfo.getJobCode().getJobName();
		//jobname=jobname.replace("\n","");
		//jobname=jobname.replace("\r","");
   // String html="<table class= finktable><tr><td width= 200px>姓名：</td><td width= 270 >"+userInfo.getResumeCode().getName()+"</td>" +"<td>性别：</td><td>"+userInfo.getResumeCode().getSex()+"</td></tr>" + "<tr><td> 出生日期 ：</td><td> "+userInfo.getResumeCode().getBirthday()+"</td>"+"<td>户籍所在地 ：</td><td>"+userInfo.getResumeCode().getHomeplace()+"</td></tr>" +"<tr><td> 联系电话 :</td><td> "+userInfo.getResumeCode().getPhone()+"</td>"+"<td>现在住址：</td><td>"+userInfo.getResumeCode().getAddress()+"</td></tr>" +"<tr><td>外语语种 ：</td><td> "+userInfo.getResumeCode().getLang()+"</td>"+"<td> 外语水平 ：</td><td>"+userInfo.getResumeCode().getLevel1()+"</td></tr>"+ "<tr><td>  残疾类别  ：</td><td> "+dkind+"</td>"+"<td>残疾程度 ：</td><td>"+userInfo.getResumeCode().getDlevel()+"</td></tr>"+"<tr><td colspan=4 class=font5></td></tr><tr></tr><tr></tr>" +"<tr><td  width= 200px  >期望从事行业：</td><td width= 270> "+userInfo.getPostCode().getTradeName()+"</td><td width= 150>欲求职位：</td><td width= 270>"+jobname+"</td></tr><tr><td>期望工作区域：</td><td  >"+userInfo.getWorkYear()+"</td><td  >发布时间：</td><td>"+(userInfo.getCreateTime()==null?"":userInfo.getCreateTime())+ "</td></tr><tr><td><span >预期月薪：</span></td><td  colspan= 3>"+userInfo.getSalary()+"</td></tr></table>";
   
         
          %>
	<tr>
	<!--<td align="center" bgcolor="#FFFFFF" class="font5"><input style="width: 45px;border: 0px;" name="ids" type="checkbox" value="<%=userInfo.getUser().getLoginId()%>"/></td>
		--><td align="center" bgcolor="#FFFFFF" class="font5"><%=pagenum * 10 + i + 1%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getName()  %></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getDkind()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getHomeplace()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getPhone()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=reg%></td>



		<td align="center" bgcolor="#FFFFFF"><a href="${ctx}/admin/findAllapplyJob.do?method=resumeView&userId=<%=userInfo.getUser().getLoginId()%>" class="list" onClick="">查看</a>&nbsp;
		<a href="#" class="list" onClick="del('<%=userInfo.getUser().getLoginId() %>','<%=pagenum%>')">确认审核</a>&nbsp;
			
	</tr>

	<%
		}
	%>
	<%
		if (pagenum == pc && pc != 0) {
	%>
	<tr>
		<td height="23" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a></td>
	</tr>

	<%
		} else if (pagenum == 0 && pc != 0) {
	%>
	<tr>
		<td height="23" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a>
		<a href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("apptotleCount") %>)">尾页&nbsp;</a></td>
	</tr>
	<%
		} else if (pagenum == 0 && pc == 0) {
	%>
	<tr>
		<td height="23" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;</td>
	</tr>
	<%
		} else {
	%>
	<tr>
		<td height="23" colspan="10" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a> <a
			href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("apptotleCount") %>)">尾页&nbsp;</a></td>
	</tr>

<%
		}
	%>

</table>
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
