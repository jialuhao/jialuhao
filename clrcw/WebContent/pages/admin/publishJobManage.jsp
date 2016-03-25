<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%
int pagenum = (Integer) request.getSession().getAttribute("jobpagenum"); 

%>

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


<script language="JavaScript" type="text/JavaScript">
function resetss(){
	
	document.getElementById("qy").value="";
   document.getElementById("qjobid").value="";
   document.getElementById("education").value="";
   document.getElementById("grading").value="";
   document.getElementById("workyear").value="";
   document.getElementById("postId").value="";
   document.getElementById("sex").value="";
   document.getElementById("sta").value="";
   document.getElementById("sTime").value="";
   document.getElementById("eTime").value="";
   
  
}
function search(){
 	   document.forms[0].action="${ctx}/admin/findAllpublishJob.do?method=findAllpublishJob";
       document.forms[0].submit();
 }


function change(s_id){
    document.getElementById("jobpnum").value=s_id;
    document.forms[0].action="${ctx}/admin/nextfindpublish.do?method=nextfindpublish";
	document.forms[0].submit();
}

function del(s_id,pn){
	var b = confirm("确定要审核该信息？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    
	    document.getElementById("jobpnum").value=pn;
	    document.forms[0].action="${ctx}/admin/SHPublishJob.do?method=updatePJob";

		document.forms[0].submit();
	
	}else{
		return false;
	}
}
function del1(s_id,pn){
	var b = confirm("确定撤销该信息？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.getElementById("shjob").value="0";
	    document.getElementById("jobpnum").value=pn;
	    document.forms[0].action="${ctx}/admin/SHPublishJob.do?method=updatePJob";

		document.forms[0].submit();
	
	}else{
		return false;
	}
}
function cx(){
    if(hasSelect()){
       if(confirm ("是否审核不通过？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
       	  document.getElementById("shjob").value="1";
          document.forms[0].action="${ctx}/admin/SHPublishJob.do?method=bathUpdatePJob";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要撤销的选项");
	  }
  }
  function sh(){
    if(hasSelect()){
       if(confirm ("是否真要审核通过？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
       	  document.getElementById("shjob").value="2";
          document.forms[0].action="${ctx}/admin/SHPublishJob.do?method=bathUpdatePJob";
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
          document.forms[0].action="${ctx}/admin/findAllpublishJob.do?method=bathDelJob";
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
<title>招聘信息审核</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
	<script src="${ctx}/public/js/calendar.js"></script>
	
</head>

<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="招聘信息列表" />
</jsp:include>

<form action="" name="form1" method="POST">
<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
      	<tr style="height: 20px">
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				招聘单位：
				<input type="text" id="qy" name="qy" value="<%=session.getAttribute("qy")!=null?session.getAttribute("qy"):"" %>"/></td>
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				招聘职位：
				<select name="qjobid" id="qjobid">
					<option value="">--请选择--</option>
					<option value="10" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("10")){%>selected="selected"<%} %>>会计</option>
					<option value="11" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("11")){%>selected="selected"<%} %>>出纳</option>
					<option value="14" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("14")){%>selected="selected"<%} %>>计算机操作员</option>
					<option value="16" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("16")){%>selected="selected"<%} %>>厨师</option>
					<option value="18" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("18")){%>selected="selected"<%} %>>行政</option>
					<option value="19" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("19")){%>selected="selected"<%} %>>平面设计</option>
					<option value="26" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("26")){%>selected="selected"<%} %>>保洁员</option>
					<option value="30" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("30")){%>selected="selected"<%} %>>印刷后期工</option>
					<option value="32" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("32")){%>selected="selected"<%} %>>网络管理</option>
					<option value="33" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("33")){%>selected="selected"<%} %>>英语</option>
					<option value="38" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("38")){%>selected="selected"<%} %>>文员</option>
					<option value="40" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("40")){%>selected="selected"<%} %>>CAD制图</option>
					<option value="42" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("42")){%>selected="selected"<%} %>>机械设计</option>
					<option value="43" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("43")){%>selected="selected"<%} %>>客服助理</option>
					<option value="44" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("44")){%>selected="selected"<%} %>>软件测试工程师</option>
					<option value="45" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("45")){%>selected="selected"<%} %>>普工</option>
					<option value="46" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("46")){%>selected="selected"<%} %>>维修工</option>
					<option value="47" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("47")){%>selected="selected"<%} %>>网页设计</option>
					<option value="48" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("48")){%>selected="selected"<%} %>>电子商务</option>
					<option value="53" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("53")){%>selected="selected"<%} %>>编辑</option>
					<option value="54" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("54")){%>selected="selected"<%} %>>电话销售</option>
					<option value="55" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("55")){%>selected="selected"<%} %>>美工</option>
					<option value="57" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("57")){%>selected="selected"<%} %>>教师</option>
					<option value="59" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("59")){%>selected="selected"<%} %>>动漫设计</option>
					<option value="61" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("61")){%>selected="selected"<%} %>>商场导购员</option>
					<option value="65" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("65")){%>selected="selected"<%} %>>网络维护</option>
					<option value="67" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("67")){%>selected="selected"<%} %>>市场和销售管理</option>
					<option value="68" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("68")){%>selected="selected"<%} %>>维修工程师</option>
					<option value="70" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("70")){%>selected="selected"<%} %>>干洗工</option>
					<option value="71" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("71")){%>selected="selected"<%} %>>项目助理</option>
					<option value="72" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("72")){%>selected="selected"<%} %>>录音整理</option>
					<option value="73" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("73")){%>selected="selected"<%} %>>方正书版排版师</option>
					<option value="34" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("34")){%>selected="selected"<%} %>>网站编辑</option>
					<option value="36" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("36")){%>selected="selected"<%} %>>办公室助理</option>
					<option value="37" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("37")){%>selected="selected"<%} %>>策划主管</option>
					<option value="52" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("52")){%>selected="selected"<%} %>>库房管理</option>
					<option value="49" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("49")){%>selected="selected"<%} %>>美工</option>
					<option value="56" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("56")){%>selected="selected"<%} %>>网络营销</option>
					<option value="63" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("63")){%>selected="selected"<%} %>>人力资源管理</option>
					<option value="64" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("64")){%>selected="selected"<%} %>>车管员</option>
					<option value="62" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("62")){%>selected="selected"<%} %>>工商管理</option>
					<option value="69" <%if(session.getAttribute("qjobid")!=null&&session.getAttribute("qjobid").equals("69")){%>selected="selected"<%} %>>前台文员</option>
				</select>		
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				学历要求：
				<select name="education" id="education">
					<option value="">--请选择--</option>
					<option value="1" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("1")){%>selected="selected"<%} %>>不限</option>
					<option value="5" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("5")){%>selected="selected"<%} %>>小学</option>
					<option value="6" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("6")){%>selected="selected"<%} %>>初中</option>
					<option value="7" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("7")){%>selected="selected"<%} %>>高中</option>
					<option value="8" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("8")){%>selected="selected"<%} %>>技工学校</option>
					<option value="9" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("9")){%>selected="selected"<%} %>>中专或中技</option>
					<option value="10" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("10")){%>selected="selected"<%} %>>大学专科和专科学校</option> 
					<option value="11" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("11")){%>selected="selected"<%} %>>大学本科</option>
					<option value="12" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("12")){%>selected="selected"<%} %>>研究生</option>
				</select>
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				应届生/往届生：
				<select id="grading" name="grading">
					<option value="">--请选择--</option>  
					<option value="0" <%if(session.getAttribute("grading")!=null&&session.getAttribute("grading").equals("0")){%>selected="selected"<%} %>>应届生</option>  
  					<option value="1" <%if(session.getAttribute("grading")!=null&&session.getAttribute("grading").equals("1")){%>selected="selected"<%} %>>往届生</option>
    			</select>
			</td>
		
		</tr>
		<tr style="height: 20px">
		
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
				</select>	
			<!--</td>
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				招聘人员性别：
				<select name="sex" id="sex">
				    <option value="">--请选择--</option>
				    <option value="无限制" <%if(session.getAttribute("sex")!=null&&session.getAttribute("sex").equals("无限制")){%>selected="selected"<%} %>>无限制</option>
					<option value="男" <%if(session.getAttribute("sex")!=null&&session.getAttribute("sex").equals("男")){%>selected="selected"<%} %>>男</option>   
				    <option value="女" <%if(session.getAttribute("sex")!=null&&session.getAttribute("sex").equals("女")){%>selected="selected"<%} %>>女</option> 
				</select>
				</td>
				
				--><td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				审核状态：
				<select name="sta" id="sta">
				    <option value="">--请选择--</option>
					<option value="2" <%if(session.getAttribute("sta")!=null&&session.getAttribute("sta").equals("2")){%>selected="selected"<%} %>>审核通过</option>
					<option value="1" <%if(session.getAttribute("sta")!=null&&session.getAttribute("sta").equals("1")){%>selected="selected"<%} %>>审核未通过</option>      
				    <option value="0" <%if(session.getAttribute("sta")!=null&&session.getAttribute("sta").equals("0")){%>selected="selected"<%} %>>待审核</option> 
				</select></td>
				
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;" >
				招聘时间&nbsp;从：<input type="text" name="sTime" title="请选择开始时间" id="sTime" value="<%=session.getAttribute("sTime")!=null?session.getAttribute("sTime"):"" %>" onclick="calendar.show(this);" readonly="readonly" style="width: 80px;">&nbsp;至：
					<input type="text" name="eTime" title="请选择截止时间" id="eTime" value="<%=session.getAttribute("eTime")!=null?session.getAttribute("eTime"):"" %>" onclick="calendar.show(this);" readonly="readonly" style="width: 80px;"></td>
		<%String areacode=(String)request.getSession().getAttribute("areacode1"); 
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
				    
				</select></td>
				<%}else{%>
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;"></td>
				<%} %>
		</tr>
		<tr>
		</tr>
         <tr style="height: 20px">
         		<td align="center" colspan="5">
		          <input type="button" style="width: 75px;border: 0px;" value="查询" onclick="search()"/>&nbsp;&nbsp;
		           <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/><!--&nbsp;&nbsp;
		          <input type="button" style="width: 75px;border: 0px;" value="审核通过" onclick="sh()"/>&nbsp;&nbsp;
		          <input type="button" style="width: 75px;border: 0px;" value="审核不通过" onclick="cx()"/>&nbsp;&nbsp;
		          --><!-- input type="button" style="width: 75px;border: 0px;" value="删除" onclick="batch_del()"/-->
	      	    </td>
 	 </tr>
  </table>  
  <br/>
<table width="98%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
	
	<input type="hidden" id="jobpnum" name="jobpnum" value=""/>
	<input type="hidden" id="pnum" name="pnum" value=""/>
	<input type="hidden" id="delId" name="delId" value=""/>
	<input type="hidden" id="shjob" name="shjob" value=""/>
	
	<tr>
		<!--<td width="4%" align="center" bgcolor="#EEF5FD" class="font5"><a href="javascript:selectAll()" id="selectBox">全选</a></td>
		--><td width="5%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="10%" align="center" bgcolor="#EEF5FD" class="font5">用户登录名</td>
		<td width="10%" align="center" bgcolor="#EEF5FD" class="font5">招聘单位</td>
		<td width="20%" align="center" bgcolor="#EEF5FD" class="font5">招聘职位</td>
		<td width="5%" align="center" bgcolor="#EEF5FD" class="font5">招聘人数</td>
		<td width="9%" align="center" bgcolor="#EEF5FD" class="font5">学历要求</td>
		<td width="9%" align="center" bgcolor="#EEF5FD" class="font5">发布时间</td>
		<td width="4%" align="center" bgcolor="#EEF5FD" class="font5">浏览量</td>    
		<td width="6%" align="center" bgcolor="#EEF5FD" class="font5">审核状态</td>
		<td width="10%" align="center" bgcolor="#EEF5FD" class="font5">操作</td>
	</tr>
	<%
		List list = (List) request.getSession().getAttribute("jobInfo");
         List arealist=(List) request.getSession().getAttribute("arealist");
		int zshu=(Integer)request.getSession().getAttribute("jobzongshu");
		int pc = (Integer) request.getSession().getAttribute("jobtotleCount");
        String reg="";
		for (int i = 0; i < list.size(); i++) {
			PublishJobInfo userInfo = (PublishJobInfo) list.get(i);
			
			String state=null;
			if(userInfo.getStatus()!=null){
				state=userInfo.getStatus().trim();
			}
			
			if(state==null||"0".equals(state)){
				 reg="待审核";
			 }else if("1".equals(state)){
				 reg="审核未通过";
				 
			 }else if("2".equals(state)){
				 reg="审核通过";
			 }
			 String gaing=userInfo.getGrading();
			 if("0".equals(gaing)){
			 gaing="应届生";}else if("1".equals(gaing)){
			 gaing="往届生";}else if("2".equals(gaing)){
			 gaing="不限";}
			 String nature=userInfo.getNature();
			 if("1".equals(nature)){
			 nature="全职";}else if("2".equals(nature)){
			 nature="兼职";}else if("3".equals(nature)){
			 nature="临时工";}else if("4".equals(nature)){
			 nature="小时工";}else if("5".equals(nature)){
			 nature="不限";}
			 String copmarea=userInfo.getPkComp().getComp().getComparea();
			for(int j=0;j<arealist.size();j++){
			Areacode areacod=(Areacode)arealist.get(j);
			if(copmarea.equals(areacod.getAreacode())){
			copmarea=areacod.getAreaname();
			}
			}
			
         String html="<table class= finktable>"+
         "<tr><td  width= 200px  >企业名称：</td><td width= 270 > "+userInfo.getPkComp().getComp().getCompName()+"</td><td  ><span  >年龄限制：</label></span></td><td  ><span  >"+userInfo.getAgeLimit()+"</span></td></tr>"
	       
	        		+"<tr><td> 联系人 ：</td><td> "+userInfo.getPkComp().getComp().getLinkman()+"</td>"
	        +"<td>联系电话：</td><td>"+userInfo.getPkComp().getComp().getTelephone()+"</td></tr>" +
	        		"<tr><td> 电子邮件 ：</td><td> "+userInfo.getPkComp().getComp().getMail()+"</td>"
	        +"<td>邮编：</td><td>"+userInfo.getPkComp().getComp().getMailPost()+"</td></tr>" +
	        		"<tr><td colspan=4 class=font5></td></tr><tr></tr><tr></tr>"
         +"<tr><td  width= 200px  >招聘职位：</td><td width= 270      > "+userInfo.getJob().getJobName() 	+
         "</td> 	<td width= 150     >残疾类别：</td><td width= 270      >"+userInfo.getPost().getPostName()+
         "</td></tr><tr><td  >工作性质：</td><td  >"+nature+"</td><td  >工作区域：</td><td  >"+userInfo.getWorkarea()+
         "</td></tr><tr><td  >发布时间：</td><td  >"+userInfo.getPublishTime()+"</td><td  >截止时间：</td><td  >"+userInfo.getCloseTime()+
        
         "</td></tr><tr></tr><tr><td  ><span  >应届生/往届生：</span></td><td  >"+gaing+" </td><td  ><span  >学历要求：</span></td><td  >"+userInfo.getEducation().getEducateName()+"</td></tr><tr><td width= 100     ><label >招聘人数：</label></td><td    >"+userInfo.getJobAmount()+"</td><td  ><span  ><label >月　　薪：</label></span></td><td  ><span  >"+userInfo.getSalary()+"</span></td></tr><tr><td   ><span  ><label >工作经验年限：</label></span></td><td   ><span  >"+userInfo.getWorkYear()
         +"</span></td><td   ><span  ><label >工作地点：</label></span></td><td><span  >"+userInfo.getAddress()+"</span></td></tr><tr><td width= 100  valign= top   ><span  ><label for= intro >职位说明：</label></span></td><td   >"+userInfo.getJobDesc()+
         "</td><td width= 100  valign= top   ><span  ><label for= intro >企业注册区域：</label></span></td><td >"+copmarea+"</td></tr><tr><td width= 100  valign= top   ><span  ><label for= intro >福利待遇：</label></span></td><td colspan= 3   >"+userInfo.getWelfare()+"</td></tr></table>";
          html=html.replace("\n","");
          html=html.replace("\r","");
          
          %>
	<tr>
	<!--<td align="center" bgcolor="#FFFFFF" class="font5"><input style="width: 45px;border: 0px;" name="ids" type="checkbox" value="<%=userInfo.getId()%>"/></td>
		--><td align="center" bgcolor="#FFFFFF" class="font5"><%=pagenum * 10 + i + 1%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getPkComp().getComp().getUserId() %></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getPkComp().getComp().getCompName() %></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getJob().getJobName()   %></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getJobAmount()   %></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getEducation().getEducateName()  %></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getPublishTime()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getPkComp().getComp().getPv()%></td>
<td align="center" bgcolor="#FFFFFF" class="font5"><%=reg  %></td>
		<td align="center"  bgcolor="#FFFFFF"><a href="#" class="list" onClick="testMessageBox(event,'<%=html %>','<%=userInfo.getPkComp().getComp().getCompName() %>');">查看</a><%="   " %><a
			href="#" class="list"
			onClick="del('<%=userInfo.getId() %>','<%=pagenum%>')">确认审核</a>
		
			</td>
	</tr>

	<%
		}
	%>
	<%
		if (pagenum == pc && pc != 0) {
	%>
	<tr>
		<td height="20" colspan="11" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a></td>
	</tr>   

	<%
		} else if (pagenum == 0 && pc != 0) {
	%>
	<tr>
		<td height="20" colspan="11" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a>
		<a href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("jobtotleCount") %>)">尾页&nbsp;</a></td>
	</tr>
	<%
		} else if (pagenum == 0 && pc == 0) {
	%>
	<tr>
		<td height="20" colspan="11" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;</td>
	</tr>
	<%
		} else {
	%>
	<tr>
		<td height="20" colspan="11" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a> <a
			href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("jobtotleCount") %>)">尾页&nbsp;</a></td>
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
