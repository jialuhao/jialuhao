<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.BdEducate"%>
<%@page import="model.PersonResume"%>
<%@ page import="model.BdPost"%>
<script language="JavaScript" type="text/JavaScript">

function bb(){

document.forms[0].action="${ctx}/admin/aglientapply.do?method=personRegist3";
	document.forms[0].submit();
}
function checkform(){
	truename = document.UpdateResumeForm.truename.value;
	years = document.UpdateResumeForm.years.value;
	otherparts = document.UpdateResumeForm.otherparts.value;
	skill= document.UpdateResumeForm.skill.value;
	level = document.UpdateResumeForm.level.value;   
	language = document.UpdateResumeForm.language.value;
	languagelevel = document.UpdateResumeForm.languagelevel.value;
	language2 = document.UpdateResumeForm.language2.value;
	languagelevel2 = document.UpdateResumeForm.languagelevel2.value;
	language3 = document.UpdateResumeForm.language3.value;
	languagelevel3 = document.UpdateResumeForm.languagelevel3.value;
	birthday=document.UpdateResumeForm.birthday.value;
	parts = document.getElementsByName("partss");
	partvalues = "";
	str11=new Date(birthday.replace("-",",")).getTime();
	str12=new Date().getTime();
	if(str11>=str12){
	     alert("出生日期必须小于当前时间");
	     return false;
	}
	
	for (i = 0; i < parts.length; i++) {
		if (parts[i].checked == true)
			partvalues = partvalues + parts[i].value;
	}
	document.UpdateResumeForm.parts.value = partvalues;
	if (truename.length > 10 || truename.length <= 0) {
		alert("真实姓名长度必须小于10个字");
		document.UpdateResumeForm.truename.focus();
		return false;
	}
	if (truename.search(/^[\u4e00-\u9FA5]+$/) < 0
			&& truename != "") {
		alert("真实姓名必须为中文");
		document.UpdateResumeForm.truename.focus();
		return false;
	}
	if (years.length > 3) {
		alert("工作年限长度必须不能超过三位数字");
		document.UpdateResumeForm.years.focus();
		return false;
	}
	if (years.search(/^[0-9]+$/) < 0 && years != "") {
		alert("工作年限只能输入数字");
		document.UpdateResumeForm.years.focus();
		return false;
	}
	if(otherparts>40){
		alert("其他残疾情况长度小于40");
			document.PersonRegist2Form.years.focus();
			return false;
		}
	if (level.length > 40) {
		alert("计算机水平长度必须小于40个字");
		document.UpdateResumeForm.level.focus();
		return false;
	}
	
	if (language.length > 40) {
		alert("外语语种长度必须小于40个字");
		document.UpdateResumeForm.language.focus();
		return false;
	}
	if (language.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
			&& language != "") {
		alert("外语语种包含非法字符");
		document.UpdateResumeForm.language.focus();
		return false;
	}
	if (language2.length > 40) {
		alert("外语语种长度必须小于40个字");
		document.UpdateResumeForm.language2.focus();
		return false;
	}
	if (language2.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
			&& language2 != "") {
		alert("外语语种包含非法字符");
		document.UpdateResumeForm.language2.focus();
		return false;
	}
	if (language3.length > 40) {
		alert("外语语种长度必须小于40个字");
		document.UpdateResumeForm.language3.focus();
		return false;
	}
	if (language3.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
			&& language3 != "") {
		alert("外语语种包含非法字符");
		document.UpdateResumeForm.language3.focus();
		return false;
	}
	if (languagelevel.length > 40) {
		alert("外语水平长度必须小于40个字");
		document.UpdateResumeForm.languagelevel.focus();
		return false;
	}
	if (languagelevel2.length > 40) {
		alert("外语水平长度必须小于40个字");
		document.UpdateResumeForm.languagelevel2.focus();
		return false;
	}
	if (languagelevel3.length > 40) {
		alert("外语水平长度必须小于40个字");
		document.UpdateResumeForm.languagelevel3.focus();
		return false;
	}
	
	if (languagelevel.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
			&& languagelevel != "") {
		alert("外语水平包含非法字符");
		document.UpdateResumeForm.languagelevel.focus();
		return false;
	}
	if (languagelevel2.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
			&& languagelevel2 != "") {
		alert("外语水平包含非法字符");
		document.UpdateResumeForm.languagelevel2.focus();
		return false;
	}
	if (languagelevel3.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
			&& languagelevel3 != "") {
		alert("外语水平包含非法字符");
		document.UpdateResumeForm.languagelevel3.focus();
		return false;
	}
	if (skill.length <=0||skill.length>200) {
		alert("职业技能请输入1-200个字");
		document.UpdateResumeForm.skill.focus();
		return false;
	}
	nowadd = document.UpdateResumeForm.nowadd.value;
	postcode = document.UpdateResumeForm.postcode.value;
	telnum = document.UpdateResumeForm.telnum.value;

	if (nowadd.length > 50 || nowadd.length <= 0) {
		alert("地址长度为0-50个字");
		document.UpdateResumeForm.nowadd.focus();
		return false;
	}
	if (nowadd.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0 && nowadd != "") {
		alert("地址包含非法字符");
		document.UpdateResumeForm.nowadd.focus();
		return false;
	}
	if (postcode.length != 6) {
		alert("邮编长度为6位数字");
		document.UpdateResumeForm.postcode.focus();
		return false;
	}
	if (postcode.search(/^[0-9]+$/) < 0 && postcode != "") {
		alert("邮编只能为数字");
		document.UpdateResumeForm.postcode.focus();
		return false;
	}

	if (telnum.length<6||telnum.length>15) {
		alert("联系电话长度必须在6位到15位之间");
		// document.form1.compAddr.value=username; 
		document.UpdateResumeForm.telnum.focus();
		return false;
	}
	if (telnum.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/) < 0) {
		alert("联系电话格式不正确");
		//document.form1.userId.value=username; 
		document.UpdateResumeForm.telnum.focus();
		return false;
	}
	getsize();
   
}
function showlanguage(){
	var showed=document.getElementById("showlang").innerHTML;
	if(showed=="更多"){
		document.getElementById("lang2").style.display="";
		document.getElementById("lang3").style.display="";
		document.getElementById("showlang").innerHTML="隐藏";
	}else{
		document.getElementById("lang2").style.display="none";
		document.getElementById("lang3").style.display="none";
		document.getElementById("showlang").innerHTML="更多";
		}
	}

var img = null;
function getsize(){

    var local = document.UpdateResumeForm.uploadphoto.value;
    var point = local.lastIndexOf(".");
    var type = local.substr(point).toUpperCase();
    if (local == "") {
        document.UpdateResumeForm.submit();
        return true;
    }
    if (type == "") {
        return true;
    }
    else 
        if (type == ".JPEG" || type == ".JPG" || type == ".GIF"|| type == ".PNG") {
        
            img = document.createElement("img");
            img.src = local;
            document.UpdateResumeForm.submit();
        }
        else {
            alert("图片格式不正确");
            return false;
        }
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<title>个人用户注册信息修改</title>
	<link href="/clrcw/css/public.css" rel="stylesheet" type="text/css">
	<link href="/clrcw/css/mainframe.css" rel="stylesheet" type="text/css">
	<link href="/clrcw/css/modelist.css" rel="stylesheet" type="text/css">
	<link id="ABTStyle" href="/clrcw/css/skin.css" rel="stylesheet"
		type="text/css">
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css">
	<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
	<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>
	<script src="/clrcw/public/js/calendar.js" type="text/javascript"></script>
<style>
	  #main{width:945px;_width:898px;}
	  ul#list1 li{margin-right:7px;}
	  ul#list1 {
	/* float: left; */
	/* padding:10px 0 0 0; */
}
	</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		<div id="main">
			<table width="740" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="5">
					</td>
				</tr>
			</table>
			<div id="content">
				<%
								PersonResume personResume = (PersonResume) request.getSession()
												.getAttribute("pr");
										String uuu = personResume.getId() + "";
							%>
				<h2>
					个人用户【<%=personResume.getName()%>】信息&nbsp;&nbsp;
					
				</h2>

				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">

					<form action="${ctx}/admin/aglientapply.do?method=updateResume" name="UpdateResumeForm"
						method="post" enctype="multipart/form-data">
						<input type="hidden" name="parts" id="parts" />
						<table class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							

							<tr>
								<TH class="th1" colspan="4" bgcolor="#990000"
									style="color: #fff;">
									个人用户资料修改：
									<html:hidden property="id" value="<%=uuu%>" />
								</th>
							</tr>


							<tr>
								<td width="17%">
									<label for="truename">
										真实姓名 :
									</label>
								</td>
								<td width="33%" class="black">
									<input type="text" Class="input3" id="truename" name="truename"
										value="<%=personResume.getName()%>" title="请输入真实姓名,长度必须小10个字" />
										<br>
										<font color="#333333" style="font-size:12px;"> *长度必须小10个字</font>
								</td>
								<td width="17%" rowspan="5">
									<label for="">
										个人照片:
									</label>
								</td>
								<td width="33%" rowspan="5" class="black" align="center">
									<%
										if (request.getSession().getAttribute("version").equals("true")) {
									%>
									<html:img action="photo.do?method=photo" width="200" height="200"	 />
									<%
										} else {
									%>

									<img src="<%=request.getContextPath()%>/images/nophoto.gif"
										width="200" height="200" />
									<%
										}
									%>
								</td>
							</tr>
							<tr>
								<td>
									<label for="sex">
										性 别：
									</label>
								</td>
								<td class="black">
									<select name="sex" id="sex" title="请选择性别">

										<option <%if (personResume.getSex().equals("男")) {%> selected
											<%}%>>
											男
										</option>
										<option <%if (personResume.getSex().equals("女")) {%> selected
											<%}%>>
											女
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<label for="birthday">
										出生日期：
									</label>
								</td>
								<td class="black">
									<input type="text" Class="input3" id="birthday" title="请选择出生日期"
										name="birthday" onclick="calendar.show(this);"
										readonly="readonly" value="<%=personResume.getBirthday()%>" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="province">
										户籍所在地：
									</label>
								</td>
								<td class="black">
									<select name="province" id="province" title="请选择户籍所在地">
										<option value="东城区" <%if ("东城区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>东城区</option>
										
											<option value="东城区" <%if ("东城区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>东城区</option>
										
											<option value="朝阳区" <%if ("朝阳区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>朝阳区</option>
										
											<option value="丰台区" <%if ("丰台区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>丰台区</option>
										
											<option value="石景山区" <%if ("石景山区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>石景山区</option>
										
											<option value="海淀区" <%if ("海淀区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>海淀区</option>
										
											<option value="门头沟区" <%if ("门头沟区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>门头沟区</option>
										
											<option value="燕山区" <%if ("燕山区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>燕山区</option>
										
											<option value="房山区" <%if ("房山区<".equals(personResume.getHomeplace())) {%> selected
											<%}%>>房山区</option>
										
											<option value="通州区" <%if ("通州区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>通州区</option>
										
											<option value="顺义区" <%if ("顺义区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>顺义区</option>
										
											<option value="昌平区" <%if ("昌平区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>昌平区</option>
										
											<option value="大兴区" <%if ("大兴区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>大兴区</option>
										
											<option value="怀柔区" <%if ("怀柔区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>怀柔区</option>
										
											<option value="平谷区" <%if ("平谷区".equals(personResume.getHomeplace())) {%> selected
											<%}%>>平谷区</option>
																		
										<option <%if (personResume.getHomeplace().equals("外埠")) {%>
											selected <%}%>>
											外埠
										</option>
										
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<label for="servicearea">
										工作地区：
									</label>
								</td>
								<td class="black">
									<select name="servicearea" id="servicearea" title="请选择工作地区">
										<option value="110101" <%if ("110101".equals(personResume.getServicearea())) {%> selected
											<%}%>>东城区</option>
										
											<option value="110102" <%if ("110102".equals(personResume.getServicearea())) {%> selected
											<%}%>>西城区</option>
										
											<option value="110105" <%if ("110105".equals(personResume.getServicearea())) {%> selected
											<%}%>>朝阳区</option>
										
											<option value="110106" <%if ("110106".equals(personResume.getServicearea())) {%> selected
											<%}%>>丰台区</option>
										
											<option value="110107" <%if ("110107".equals(personResume.getServicearea())) {%> selected
											<%}%>>石景山区</option>
										
											<option value="110108" <%if ("110108".equals(personResume.getServicearea())) {%> selected
											<%}%>>海淀区</option>
										
											<option value="110109" <%if ("110109".equals(personResume.getServicearea())) {%> selected
											<%}%>>门头沟区</option>
										
											<option value="110110" <%if ("110110".equals(personResume.getServicearea())) {%> selected
											<%}%>>燕山区</option>
										
											<option value="110111" <%if ("110111".equals(personResume.getServicearea())) {%> selected
											<%}%>>房山区</option>
										
											<option value="110112" <%if ("110112".equals(personResume.getServicearea())) {%> selected
											<%}%>>通州区</option>
										
											<option value="110113" <%if ("110113".equals(personResume.getServicearea())) {%> selected
											<%}%>>顺义区</option>
										
											<option value="110114" <%if ("110114".equals(personResume.getServicearea())) {%> selected
											<%}%>>昌平区</option>
										
											<option value="110115" <%if ("110115".equals(personResume.getServicearea())) {%> selected
											<%}%>>大兴区</option>
										
											<option value="110116" <%if ("110116".equals(personResume.getServicearea())) {%> selected
											<%}%>>怀柔区</option>
										
											<option value="110117" <%if ("110117".equals(personResume.getServicearea())) {%> selected
											<%}%>>平谷区</option>
																												
									</select>
								</td>
							</tr>
							<tr>
								
								<td>
									<label for="language2">
										政治面貌：
									</label>
								</td>
								<td class="black">
									<select name="political" id="political" title="请选择政治面貌">
										<option value="1"
											<%if ("1".equals(personResume.getPolitical())) {%> selected
											<%}%>>
											群众
										</option>
										<option value="2"
											<%if ("2".equals(personResume.getPolitical())) {%> selected
											<%}%>>
											中共党员
										</option>
										<option value="3"
											<%if ("3".equals(personResume.getPolitical())) {%> selected
											<%}%>>
											共青团员
										</option>
										<option value="4"
											<%if ("4".equals(personResume.getPolitical())) {%> selected
											<%}%>>
											其它
										</option>
									</select>
								</td>
								<td>
									<label for="languagelevel2">
										婚姻状况：
									</label>
								</td>
								<td class="black">
									<select name="marriage" id="marriage" title="请选择婚姻状况">
										<option value="1"
											<%if ("1".equals(personResume.getMarriage())) {%> selected
											<%}%>>
											已婚
										</option>
										<option value="2"
											<%if ("2".equals(personResume.getMarriage())) {%> selected
											<%}%>>
											未婚
										</option>
										<option value="3"
											<%if ("3".equals(personResume.getMarriage())) {%> selected
											<%}%>>
											离异
										</option>
										<option value="4"
											<%if ("4".equals(personResume.getMarriage())) {%> selected
											<%}%>>
											丧偶
										</option>
									</select>
								</td>
								
							</tr>
<tr>
								<td>
									<label for="dkind">
										残疾类别：
										</label>
								</td>
								<td class="black">
									<select name="dkind" id="dkind" title="请选择残疾类别">
										<%
											List ccc = (List) request.getSession().getAttribute("bdPost");
													for (int i = 0; i < ccc.size(); i++) {
														BdPost bdPost = (BdPost) ccc.get(i);
										%>
										<option value="<%=bdPost.getId()%>" 
											<%if ((bdPost.getId().toString()).equals(personResume.getDkind())) {%>
											selected <%}%>><%=bdPost.getPostName()%></option>
										<%
											}
										%>
									</select>
								</td>
								<td>
									<label for="dlevel">
										残疾程度：
									</label>
								</td>
								<td class="black">
									<select name="dlevel" id="dlevel" title="请选择残疾程度">
										<option value="1"
											<%if ("1".equals(personResume.getDlevel())) {%> selected <%}%>>
											一级
										</option>
										<option value="2"
											<%if ("2".equals(personResume.getDlevel())) {%> selected <%}%>>
											二级
										</option>
										<option value="3"
											<%if ("3".equals(personResume.getDlevel())) {%> selected <%}%>>
											三级
										</option>
										<option value="4"
											<%if ("4".equals(personResume.getDlevel())) {%> selected <%}%>>
											四级
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<label for="language2">
										残疾情况：
									</label>
								</td>
								<td colspan="3" class="black">
									<input type="checkbox" name="partss" value="1"
										<%if ("1".equals(personResume.getParts())) {%> checked <%}%> />
									左上肢
									<input type="checkbox" name="partss" value="2"
										<%if ("2".equals(personResume.getParts())) {%> checked <%}%> />
									左下肢
									<input type="checkbox" name="partss" value="3"
										<%if ("3".equals(personResume.getParts())) {%> checked <%}%> />
									右上肢
									<input type="checkbox" name="partss" value="4"
										<%if ("4".equals(personResume.getParts())) {%> checked <%}%> />
									右下肢
									<input type="checkbox" name="partss" value="5"
										<%if ("5".equals(personResume.getParts())) {%> checked <%}%> />
									脊柱
									<input type="checkbox" name="partss" value="6"
										<%if ("6".equals(personResume.getParts())) {%> checked <%}%> />
									身体矮小
									<br />
									<br />
									<input type="checkbox" name="partss" value="7"
										<%if ("7".equals(personResume.getParts())) {%> checked <%}%> />
									使用助听器可以交流
									<input type="checkbox" name="partss" value="8"
										<%if ("8".equals(personResume.getParts())) {%> checked <%}%> />
									手语交流
									<input type="checkbox" name="partss" value="9"
										<%if ("9".equals(personResume.getParts())) {%> checked <%}%> />
									低视力 其他
									<input type="text" title="请输入其他残疾部位" Class="input3"
										id="otherparts" name="otherparts" maxlength="40"
										value="<%=personResume.getOtherparts() == null? "": personResume.getOtherparts()%>" />
										<br/>
										<br />
									是否使用辅助用具：
									<input type="radio" name="tool" value="1" title="点击选择使用辅具"
										<%if ("1".equals(personResume.getTool())) {%> checked <%}%> />
									是
									<input type="radio" name="tool" value="0" title="点击选择不使用辅具"
										<%if ("0".equals(personResume.getTool())) {%> checked <%}%> />
									否
								</td>
							</tr>
							<tr>
								<td>
									<label for="education">
										最高学历：
									</label>
								</td>
								<td class="black">
									<select name="education" id="education" title="请选择最高学历">

										<%
											List vvv = (List) request.getSession().getAttribute("bdEducate");

													for (int i = 0; i < vvv.size(); i++) {
														BdEducate bdEducate = new BdEducate();
														bdEducate = (BdEducate) vvv.get(i);
										%>
										<option value="<%=bdEducate.getId()%>"
											<%if (bdEducate.getEducateName().equals(
								personResume.getEducate().getEducateName())) {%>
											selected <%}%>><%=bdEducate.getEducateName()%></option>
										<%
											}
										%>
									</select>
								</td>
								<td>
									<label for="level">
										计算机水平：
									</label>
								</td>
								<td class="black">
									<input title="请输入计算机水平" type="text" Class="input3" id="level"  title="请输入计算机水平,长度必须小于40个字"
										name="level" value="<%=personResume.getCompLevel()%>" />
										<br>
										<font color="#333333" style="font-size: 12px;"> 长度必须小于40个字 </font>
								</td>
							</tr>
						<tr>
								<td>
									<label for="language">
										外语语种：
									</label>
								</td>
								<td class="black">
									<input type="text" Class="input3" title="请输入外语语种" id="language"
										name="language" value="<%=personResume.getLang()%>" />
								</td>
								<td>
									<label for="languageleve1">
										外语水平：
									</label>
								</td>
								<td class="black">
									<input title="请输入外语水平" type="text" Class="input3"
										id="languagelevel" name="languagelevel"
										value="<%=personResume.getLevel1()%>" /><div id="showlang" onclick="showlanguage();" style="width: 40px;float:right;padding-right: 60px">隐藏</div>
								</td>
							</tr>
							<tr id="lang2">
								<td>
									<label for="language">
										外语语种2：
									</label>
								</td>
								<td class="black">
									<input type="text" Class="input3" title="请输入外语语种" id="language2"
										name="language2" value="<%=personResume.getLang2()%>" />
								</td>
								<td>
									<label for="languageleve1">
										外语水平2：
									</label>
								</td>
								<td class="black">
									<input title="请输入外语水平" type="text" Class="input3"
										id="languagelevel2" name="languagelevel2"
										value="<%=personResume.getLevel2()%>" />
								</td>
							</tr>
							<tr id="lang3">
								<td>
									<label for="language">
										外语语种3：
									</label>
								</td>
								<td class="black">
									<input type="text" Class="input3" title="请输入外语语种" id="language3"
										name="language3" value="<%=personResume.getLang3()%>" />
								</td>
								<td>
									<label for="languageleve1">
										外语水平3：
									</label>
								</td>
								<td class="black">
									<input title="请输入外语水平" type="text" Class="input3"
										id="languagelevel3" name="languagelevel3"
										value="<%=personResume.getLevel3()%>" />
								</td>
							</tr>
							<tr>
									<td>
										<label for="skill">
											职业技能：
										</label>
									</td>
									<td class="black" colspan="3">
										<textarea rows="4" cols="50" name="skill" id="skill" title="职业技能请输入1-200个字"><%=personResume.getSkill()%></textarea>
									<br/><font color="#333333" style="font-size: 12px;">*职业技能请输入1-200个字</font>
									</td>
								</tr>
							<tr>
								<td>
									<label for="years">
										工作年限：
									</label>
								</td>
								<td class="black">
									<input type="text" Class="input3" title="请输入工作年限" id="years"
										name="years" value="<%=personResume.getLimitYear()%>" />
										<br>
										<font color="#333333" style="font-size: 12px;">
											长度不能超过三位数字 </font>
								</td>
								<td>
									<label for="languagelevel2">
										目前状态：
									</label>
								</td>
								<td class="black">
									<select name="workstate" id="workstate" title="请选择目前状态">
										<option value="1"
											<%if ("1".equals(personResume.getWorkstate())) {%> selected
											<%}%>>
											应届毕业生
										</option>
										<option value="2"
											<%if ("2".equals(personResume.getWorkstate())) {%> selected
											<%}%>>
											目前离职(或失业)
										</option>
										<option value="3"
											<%if ("3".equals(personResume.getWorkstate())) {%> selected
											<%}%>>
											目前在职
										</option>
									</select>
								</td>
							</tr>
							
							
							
							<tr>
									<td>
										<label for="nowadd">
											现在地址：
										</label>
									</td>
									<td colspan="3" class="black">
										<input title="请输入现在地址,长度为0-50个字" type="text" Class="input3"  style="width: 500px" 
											id="nowadd" name="nowadd"
											value="<%=personResume.getAddress()%>" /><font color="#333333" style="font-size: 12px;">*现在地址长度为0-50个字
											</font>
									</td>

								</tr>
								<tr>
									<td>
										<label for="telnum">
											联系电话：
										</label>
									</td>
									<td class="black">
										<input type="text" title="请输入联系电话,长度为0-20个字" Class="input3"
											id="telnum" name="telnum"
											value="<%=personResume.getPhone()%>" /><br>
											<font color="#333333" style="font-size: 12px;">*联系电话长度必须在6位到15位之间</font>
									</td>
									<td>
										<label for="postcode">
											邮 编：
										</label>
									</td>
									<td class="black">
										<input type="text" title="请输入邮编,长度为6位数字" Class="input3"
											id="postcode" name="postcode"
											value="<%=personResume.getMailcode()%>" /><br>
											<font color="#333333" style="font-size: 12px;">*邮编长度为6位数字
											</font>
									</td>
								</tr>
								
								<tr>
									<td colspan="4" align="center">
										<label for="files">
											请选择照片：
										</label>
										<input type="file" title="请选择照片" name="uploadphoto" size="35"
											value="" id="files">
									
										<logic:present name="image">
									<p style="color: #F30;  font-size: 12px;">
										
									</p>
										</logic:present>
										<logic:notPresent name="image">
 									<p style="font-size: 12px;">
										(支持JPEG,JPG,GIF,PNG格式 )
									</p>
  </logic:notPresent>
									</td>
								</tr>
								<tr>
								<td colspan="4" align="center">
									是否公开您的个人资料:
								
									<input type="radio" name="dr" value="0"
										<%if ("0".equals(personResume.getDr())) {%> checked <%}%> />
									是
									<input type="radio" name="dr" value="1"
										title="如果选择否用人单位将无法查询到您的简历信息！"
										<%if ("1".equals(personResume.getDr())) {%> checked <%}%> />
									否
								</td></tr>

								<tr>

									<td colspan="4" height="35" align="center">
										<input type="button" value="保存" Class="input4"
											onClick="return checkform()" />
										<input type="button" name="btn1" value="返回"
											onClick="return bb()"
											class="input4">
									</td>
								</tr>
						</table>
						<script type="text/javascript">
	var boxObj = document.getElementsByName("partss"); //获取所有的复选框
	var pay = '<%=personResume.getParts()%>'; 
	var index = 0;
	for (i = 0; i < boxObj.length; i++) {
		for (j = 0; j < pay.length; j++) {
			if (boxObj[i].value == pay.charAt(j)) //如果值与修改前的值相等
			{
				boxObj[i].checked = true;
				break;
			}
		}
	}

</script>
					</form>


				</div>


			</div>
		</div>

		<iframe src="/clrcw/public/include/footer.html" height="150"
			width="960" id="iframe_foot" frameborder="0" scrolling="no"
			title="底部脚本"></iframe>



	</div>
	<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>


</body>

</html:html>
