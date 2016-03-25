
<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.BdEducate"%>
<%@ page import="model.PersonResume"%>
<%@ page import="model.BdPost"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="JavaScript" type="text/JavaScript">
	function aa(){
	document.forms[0].action="${ctx}/admin/aglientapply.do?method=personRegist2";
	document.forms[0].submit();
	}
	
	function checkform() {
		
		truename = document.AglientapplyForm.truename.value;
		
		
		years = document.AglientapplyForm.years.value;
		otherparts = document.AglientapplyForm.otherparts.value;
		skill= document.AglientapplyForm.skill.value;
		level = document.AglientapplyForm.level.value;
		language = document.AglientapplyForm.language.value;
		languagelevel = document.AglientapplyForm.languagelevel.value;
		language2 = document.AglientapplyForm.language2.value;
		languagelevel2 = document.AglientapplyForm.languagelevel2.value;
		language3 = document.AglientapplyForm.language3.value;
		languagelevel3 = document.AglientapplyForm.languagelevel3.value;
		cardnumber= document.AglientapplyForm.cardnumber.value;
		parts = document.getElementsByName("partss");
		partvalues = "";
		for (i = 0; i < parts.length; i++) {
			if (parts[i].checked == true)
				partvalues = partvalues + parts[i].value;
		}
		document.AglientapplyForm.parts.value = partvalues;
		if (truename.length > 10 || truename.length <= 0) {
			alert("真实姓名长度必须小于10个字");
			document.AglientapplyForm.truename.focus();
			return false;
		}
		if (truename.search(/^[\u4e00-\u9FA5]+$/) < 0
				&& truename != "") {
			alert("真实姓名必须为中文");
			document.AglientapplyForm.truename.focus();
			return false;
		}
		if (cardnumber.length<=0) {
			alert("身份证不能为空");
			document.AglientapplyForm.cardnumber.focus();
			return false;
		}
		if (cardnumber.search(/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}(\d|x|X)$/) < 0
				&& cardnumber!= "") {
			alert("身份证格式不正确");
			document.AglientapplyForm.cardnumber.focus();
			return false;
		}
		if (years.length > 3) {
			alert("工作年限长度必须不能超过三位数字");
			document.AglientapplyForm.years.focus();
			return false;
		}
		if (years.search(/^[0-9]+$/) < 0 && years != "") {
			alert("工作年限只能输入数字");
			document.AglientapplyForm.years.focus();
			return false;
		}
		
		if(otherparts>40){
		alert("其他残疾情况长度小于40");
			document.PersonRegist2Form.years.focus();
			return false;
		}
		if (level.length > 40) {
			alert("计算机水平长度必须小于40个字");
			document.AglientapplyForm.level.focus();
			return false;
		}
		
		if (language.length > 40) {
			alert("外语语种长度必须小于40个字");
			document.AglientapplyForm.language.focus();
			return false;
		}
		
		if (language.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
				&& language != "") {
			alert("外语语种包含非法字符");
			document.AglientapplyForm.language.focus();
			return false;
		}
		if (language2.length > 40) {
			alert("外语语种长度必须小于40个字");
			document.AglientapplyForm.language2.focus();
			return false;
		}
		if (language2.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
				&& language2 != "") {
			alert("外语语种包含非法字符");
			document.AglientapplyForm.language2.focus();
			return false;
		}
		if (language3.length > 40) {
			alert("外语语种长度必须小于40个字");
			document.AglientapplyForm.language3.focus();
			return false;
		}
		if (language3.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
				&& language3 != "") {
			alert("外语语种包含非法字符");
			document.AglientapplyForm.language3.focus();
			return false;
		}
		if(language != ""&&languagelevel==""){
		     alert("外语水平不能为空");
			document.AglientapplyForm.languagelevel.focus();
			return false;
		}
		if(language2 != ""&&languagelevel2==""){
		     alert("外语水平不能为空");
			document.AglientapplyForm.languagelevel2.focus();
			return false;
		}
		if(language3 != ""&&languagelevel3==""){
		     alert("外语水平不能为空");
			document.AglientapplyForm.languagelevel3.focus();
			return false;
		}
		if (languagelevel.length > 40) {
			alert("外语水平长度必须小于40个字");
			document.AglientapplyForm.languagelevel.focus();
			return false;
		}
		if (languagelevel2.length > 40) {
			alert("外语水平长度必须小于40个字");
			document.AglientapplyForm.languagelevel2.focus();
			return false;
		}
		if (languagelevel3.length > 40) {
			alert("外语水平长度必须小于40个字");
			document.AglientapplyForm.languagelevel3.focus();
			return false;
		}
		
		if (languagelevel.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
				&& languagelevel != "") {
			alert("外语水平包含非法字符");
			document.AglientapplyForm.languagelevel.focus();
			return false;
		}
		if (languagelevel2.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
				&& languagelevel2 != "") {
			alert("外语水平包含非法字符");
			document.AglientapplyForm.languagelevel2.focus();
			return false;
		}
		if (languagelevel3.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0
				&& languagelevel3 != "") {
			alert("外语水平包含非法字符");
			document.AglientapplyForm.languagelevel3.focus();
			return false;
		}
		if (skill.length <=0||skill.length>200) {
			alert("职业技能请输入1-200个字");
			document.AglientapplyForm.skill.focus();
			return false;
		}
		nowadd = document.AglientapplyForm.nowadd.value;
		postcode = document.AglientapplyForm.postcode.value;
		telnum = document.AglientapplyForm.telnum.value;

		if (nowadd.length > 50 || nowadd.length <= 0) {
			alert("地址长度为0-50个字");
			document.AglientapplyForm.nowadd.focus();
			return false;
		}
		if (nowadd.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0 && nowadd != "") {
			alert("地址包含非法字符");
			document.AglientapplyForm.nowadd.focus();
			return false;
		}
		if (postcode.length != 6) {
			alert("邮编长度为6位数字");
			document.AglientapplyForm.postcode.focus();
			return false;
		}
		if (postcode.search(/^[0-9]+$/) < 0 && postcode != "") {
			alert("邮编只能为数字");
			document.AglientapplyForm.postcode.focus();
			return false;
		}

		if (telnum.length<6||telnum.length>15) {
			alert("联系电话长度必须在6位到15位之间");
			// document.form1.compAddr.value=username; 
			document.AglientapplyForm.telnum.focus();
			return false;
		}
		if (telnum.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/) < 0) {
			alert("联系电话格式不正确");
			//document.form1.userId.value=username; 
			document.AglientapplyForm.telnum.focus();
			return false;
		}
		getsize();

	}

	var img = null;
	function getsize() {
		var local = document.AglientapplyForm.uploadphoto.value;

		var point = local.lastIndexOf(".");

		var type = local.substr(point).toUpperCase();

		if (local == "") {
			document.AglientapplyForm.submit();
			return true;
		}
		if (type == "") {
			return true;
		} else if (type == ".JPEG" || type == ".JPG" || type == ".GIF"|| type == ".PNG") {
			img = document.createElement("img");
			img.src = local;
			document.AglientapplyForm.submit();
		} else {
			alert("图片格式不正确");
			return false;
		}
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
</script>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Cache-Control" content="no-store" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<title>个人基本情况页面</title>
		<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
		<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
		<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />

		<link rel="stylesheet" type="text/css" id="ABTStyle"
			href="/clrcw/css/skin.css" />
		<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
		<script src="/clrcw/js/public.js" type="text/javascript"></script>
		<script src="/clrcw/js/menu.js" type="text/javascript"></script>
		<script src="/clrcw/public/js/calendar.js" type="text/javascript"></script>
	</head>
	<body>
		<div id="container">
			<div id="header">
				<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
					frameborder="0" scrolling="no" height="150" width="960">
				</iframe>
			</div>
			<div id="main">
				<div id="content">
					<h2>
						用户信息&nbsp;&nbsp;
						
					</h2>

					<div class="formdiv">
						<form name="AglientapplyForm" action="${ctx}/admin/aglientapply.do?method=personRegist2" method="post" enctype="multipart/form-data" >
		
						<table class="finktable" id="jbqk" summary="个人招聘信息" width="100%" >
								<tr>
									<td height="40" colspan="3">
										创建个人简历：填写个人基本情况(*标注为必填项)
									</td>
									<td>
										是否允许用人单位查看简历:是
									</td>
								</tr>
								<tr>
									<td width="17%">
										<label for="truename">
											真实姓名 :
										</label>
									</td>
									<td width="33%">
										<input type="text" Class="input3" id="truename" 
											name="truename" title="请输入真实姓名,长度必须小于10个字" />
											<br>
										<font color="#333333" style="font-size:12px;"> *长度必须小于10个字</font>
									</td>
									<td width="17%" rowspan="5">
										个人照片:
									</td>
									<td width="33%" rowspan="5">
										<%
											PersonResume personResume = (PersonResume) request
														.getAttribute("pr");
										%>
										<%
											if (personResume != null
														&& personResume.getFkPersonImage() != null) {
										%>

										<html:img action="photo.do?method=photo" width="200" height="200" />
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
									<td>
										<select name="sex" id="sex" title="请选择性别">
											<option>
												男
											</option>
											<option>
												女
											</option>
										</select>
									</td>
								</tr>
								<tr>
								<td>
										<label for="birthday">
											身份证号：
										</label>
									</td>
									<td>
										<input type="text" Class="input3" id="cardnumber" 
											name="cardnumber" title="请输入身份证号" />
									<%String  aaa="";
									if(request.getSession().getAttribute("shenfenzheng")!=null){
									aaa=(String)request.getSession().getAttribute("shenfenzheng");
									} %>
										<font color="red"><%=aaa%></font>
										<br>
										<font color="#333333" style="font-size:12px;"> *长度必须为18位</font>
									</td>
									</tr>
									<tr>
									<td>
										<label for="birthday">
											出生日期：
										</label>
									</td>
									<td>
										<input type="text" Class="input3" title="请选择出生日期"
											id="birthday" name="birthday" onclick="calendar.show(this);"
								readonly="readonly"
											value="<%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())%>" />
									</td>
								</tr>
								<tr>
									<td>
										<label for="province">
											户籍所在地：
										</label>
									</td>
									<td>
										<select name="province" id="province" title="请选择所在地">

											<option>
												外埠
											</option>
											<option value="东城区">东城区</option>
										
											<option value="西城区">西城区</option>
										
											<option value="朝阳区">朝阳区</option>
										
											<option value="丰台区">丰台区</option>
										
											<option value="石景山区">石景山区</option>
										
											<option value="海淀区">海淀区</option>
										
											<option value="门头沟区">门头沟区</option>
										
											<option value="燕山区">燕山区</option>
										
											<option value="房山区">房山区</option>
										
											<option value="通州区">通州区</option>
										
											<option value="顺义区">顺义区</option>
										
											<option value="昌平区">昌平区</option>
										
											<option value="大兴区">大兴区</option>
										
											<option value="怀柔区">怀柔区</option>
										
											<option value="平谷区">平谷区</option>
										</select>
									</td>
								</tr>
								<tr>
									<td >
										<label for="province" >
											工作地区：
										</label>
									</td>
									<td colspan="3">
										<select name="servicearea" id="servicearea" title="请选择工作地区">

											
											<option value="110101">东城区</option>
										
											<option value="110102">西城区</option>
										
											<option value="110105">朝阳区</option>
										
											<option value="110106">丰台区</option>
										
											<option value="110107">石景山区</option>
										
											<option value="110108">海淀区</option>
										
											<option value="110109">门头沟区</option>
										
											<option value="110110">燕山区</option>
										
											<option value="110111">房山区</option>
										
											<option value="110112">通州区</option>
										
											<option value="110113">顺义区</option>
										
											<option value="110114">昌平区</option>
										
											<option value="110115">大兴区</option>
										
											<option value="110116">怀柔区</option>
										
											<option value="110117">平谷区</option>
										</select>
									</td>
								</tr>
								
								<tr>
								<td>
										<label for="language2">
											政治面貌：
										</label>
									</td>
									<td>
										<select name="political" id="political" title="请选择政治面貌">
											<option value="1">
												群众
											</option>
											<option value="2">
												中共党员
											</option>
											<option value="3">
												共青团员
											</option>
											<option value="4">
												其它
											</option>
										</select>
									</td>
									<td>
										<label for="languagelevel2">
											婚姻状况：
										</label>
									</td>
									<td>
										<select name="marriage" id="marriage" title="请选择婚姻状况">
											<option value="1">
												已婚
											</option>
											<option value="2">
												未婚
											</option>
											<option value="3">
												离异
											</option>
											<option value="4">
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
									<td>
										<select name="dkind" id="dkind" title="请选择残疾类别">
											<%
												List ccc = (List) request.getSession().getAttribute("bdPost");
													for (int i = 0; i < ccc.size(); i++) {
														BdPost bdPost = (BdPost) ccc.get(i);
											%>
											<option value="<%=bdPost.getId()%>"><%=bdPost.getPostName()%></option>
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
									<td>
										<select name="dlevel" id="dlevel" title="请选择残疾程度">
											<option value="1">
												一级
											</option>
											<option value="2">
												二级
											</option>
											<option value="3">
												三级
											</option>
											<option value="4">
												四级
											</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>
										<label for="language2">
											残疾部位：
										</label>
									</td>
									<td colspan="3">
										<input type="checkbox" name="partss" value="1" />
										左上肢
										<input type="checkbox" name="partss" value="2" />
										左下肢
										<input type="checkbox" name="partss" value="3" />
										右上肢
										<input type="checkbox" name="partss" value="4" />
										右下肢
										<input type="checkbox" name="partss" value="5" />
										脊柱
										<input type="checkbox" name="partss" value="6" />
										身体矮小
										<br />
										<input type="checkbox" name="partss" value="7" />
										使用助听器可以交流
										<input type="checkbox" name="partss" value="8" />
										手语交流
										<input type="checkbox" name="partss" value="9" />
										低视力 其他
										<input type="text" title="请输入其他残疾部位" Class="input3"
											id="otherparts" name="otherparts" />
										<input type="hidden" name="parts" id="parts" />
										<br/>
										是否使用辅助用具：
										<input type="radio" name="tool" value="1" title="点击选择使用辅具"/>
										是
										<input type="radio" name="tool" value="0" title="点击选择不使用辅具" checked />
										否
									</td>
									</tr>
								<tr>
								<td>
										<label for="education">
											最高学历：
										</label>
									</td>
									<td>
										<select name="education" id="education" title="请选择最高学历">
											<%
												List vvv = (List) request.getSession().getAttribute("bdEducate");

													if (vvv != null) {

														for (int i = 0; i < vvv.size(); i++) {
															BdEducate bdEducate = new BdEducate();
															bdEducate = (BdEducate) vvv.get(i);
											%>
											<option value="<%=bdEducate.getId()%>"><%=bdEducate.getEducateName()%></option>

											<%
												}
													}
											%>
										</select>
									</td>
									<td>
										<label for="level">
											计算机水平：
										</label>
									</td>
									<td>
										<input type="text" title="请输入计算机水平,长度必须小于40个字" Class="input3" id="level"
											name="level" />
										<br>
										<font color="#333333" style="font-size: 12px;"> 长度必须小于40个字 </font>
									</td>
								</tr>
								<tr>
									<td>
										<label for="years">
											工作年限：
										</label>
									</td>
									<td>
										<input type="text" Class="input3" id="years" name="years"
											title="请输入工作年限,长度不能超过三位数字" />
										年
										<br>
										<font color="#333333" style="font-size: 12px;">
											长度不能超过三位数字 </font>
									</td>
									<td>
										<label for="languagelevel2">
											目前工作状态：
										</label>
									</td>
									<td>
										<select name="workstate" id="workstate" title="请选择目前工作状态">
											<option value="1">
												应届毕业生
											</option>
											<option value="2">
												目前离职(或失业)
											</option>
											<option value="3">
												目前在职
											</option>
										</select>
									</td>
								</tr>
								
								<tr>
									<td>
										<label for="language">
											外语语种：
										</label>
									</td>
									<td>
										<input type="text" title="请输入外语语种,长度必须小于40个字" Class="input3"
											id="language" name="language" />
										<br>
										<font color="#333333" style="font-size: 12px;">
											长度必须小于40个字 </font>
									</td>
									<td>
										<label for="languagelevel">
											外语水平：
										</label>
									</td>
									<td>
										<input type="text" Class="input3" id="languagelevel"
											name="languagelevel" title="请输入外语水平" /> <div id="showlang" onclick="showlanguage();" style="width: 30px;float:right;padding-right: 80px">更多</div>
										<br>
										<font color="#333333" style="font-size: 12px;">
											长度必须小于40个字 </font>
									</td>
								</tr>
								<tr id="lang2" style="display: none;">
									
										<td>
											<label for="language2">
												外语语种2：
											</label>
										</td>
										<td>
											<input type="text" title="请输入外语语种" Class="input3"
												id="language2" name="language2" />

											<font color="#333333" style="font-size: 12px;">
												长度必须小于40个字 </font>
										</td>
										<td>
											<label for="languagelevel2">
												外语水平2：
											</label>
										</td>
										<td>
											<input type="text" Class="input3" id="languagelevel2"
												name="languagelevel2" title="请输入外语水平" />

											<font color="#333333" style="font-size: 12px;">
												长度必须小于40个字 </font>
										</td>
										
									</tr>
									<tr id="lang3" style="display: none;">
										<td>
											<label for="language3">
												外语语种3：
											</label>
										</td>
										<td>
											<input type="text" title="请输入外语语种" Class="input3"
												id="language3" name="language3" />

											<font color="#333333" style="font-size: 12px;">
												长度必须小于40个字 </font>
										</td>
										<td>
											<label for="languagelevel3">
												外语水平3：
											</label>
										</td>
										<td>
											<input type="text" Class="input3" id="languagelevel3"
												name="languagelevel3" title="请输入外语水平" />
											<font color="#333333" style="font-size: 12px;">
												长度必须小于40个字 </font>
										</td>
									</tr>
									<tr>
										<td>
											<label for="qzdq">
												职业技能：
											</label>
										</td>
										<td colspan="3">
											<textarea rows="4" cols="70" name="skill" id="skill" title="职业技能请输入1-200个字"></textarea>
											<br/><font color="#333333" style="font-size: 12px;">*职业技能请输入1-200个字</font>
										</td>
									</tr>
								<!--tr>
    <td ><label for="language2">外语语种2：</label></td>
    <td  ><input type="text" title="请输入外语语种" Class="input3" id="language2" name="language2" /></br><font color="#333333" style="font-size:12px;"> 长度必须小于40个字 </font></td>
    <td ><label for="languagelevel2">外语水平2：</label></td>
    <td ><input type="text" Class="input3" id="languagelevel2" name="languagelevel2" title="请输入外语水平" />  </br><font color="#333333" style="font-size:12px;"> 长度必须小于40个字 </font>  </td>
  </tr-->
								
									<tr>
										<td>
											现在地址：
										</td>
										<td colspan="3">
											<input title="请输入现在地址,长度为0-50个字" type="text" style="width: 500px" id="nowadd"
												name="nowadd" />
											<font color="#333333" style="font-size: 12px;">*现在地址长度为0-50个字
											</font>
										</td>
									</tr>
									<tr>
										<td>
											联系电话：
										</td>
										<td>
											<input type="text" title="请输入联系电话,长度必须在6-15位之间" Class="input3" id="telnum"
												name="telnum" />
											<br>
											<font color="#333333" style="font-size: 12px;">*联系电话长度必须在6位到15位之间</font>
										</td>
										<td>
											邮 编：
										</td>
										<td>
											<input type="text" title="请输入邮编,长度为6位数字" Class="input3" id="postcode"
												name="postcode" />
											<br>
											<font color="#333333" style="font-size: 12px;">*邮编长度为6位数字
											</font>
										</td>  
									</tr>
									<tr>
										<td colspan="4" align="center">
											<label for="uploadphoto">
												请选择照片：
											</label>
											<input type="file" name="uploadphoto" size="35" value=""
												id="uploadphoto" title="请选择照片">
										</td>
									</tr>
									<tr>    
										<td colspan="4" align="center">
											<logic:present name="image">
												<font color="red"></font>
											</logic:present>
											<logic:notPresent name="image">
  支持JPEG,JPG,GIF,PNG格式 </logic:notPresent>
										</td>
									</tr>
									<tr>
										<td colspan="4" align="center">
											<input name="button" type="button" class="input4"
												onClick="return checkform();" value="保存" />
										</td>
									</tr>
							</table>

						</form>


					</div>
				</div>
			</div>




			


		</div>
	
	</body>

</html>
