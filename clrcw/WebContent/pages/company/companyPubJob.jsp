<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="model.*"%>

<SCRIPT language="JavaScript" type="text/JavaScript">
function del(s_id){
    var d = confirm("确实要删除吗！");
    if (d) {
        document.form1.id.value = s_id;
        document.form1.action = "${ctx}/companyPubJob.do?method=delPubJob";
        document.form1.submit();
    }
}
function endflag(s_id,validflag,c){
if(c!=null){
var c=c.replace(/(^\s*)|(\s*$)/g, "");}
if(c=="0"||c=="1"){
alert("此条招聘信息待审核或未通过审核")
}
 else if(validflag=='2'||validflag=='3'){
 alert("此条招聘信息已经结束招聘");
 
       
        }else{
    var d = confirm("确实要结束招聘吗！");
    if (d) {
        document.form1.id.value = s_id;
        document.form1.action = "${ctx}/companyPubJob.do?method=savePubJobflag";
        document.form1.submit();
   }
    }
    
    }

function postpone1(validtime,id){

    var nowtime = new Date();
             var strSeparator = "-"; //日期分隔符
             if(validtime!=null&&validtime!=""){
    var oDate2= validtime.substring(0,10).split(strSeparator);
    var strDateE = new Date(oDate2[0], oDate2[1]-1, oDate2[2]);
    
    var i = parseInt((  strDateE- nowtime) / 1000 / 60 / 60 /24);
   
    if(i>10){
    alert("距有效期超过十天不能延期");
     
   }else{
    window.location.href="${ctx}/companyPubJob.do?method=postponeJob&id="+id;
    alert("延期成功");
   }
   }
   }
function checkform(){
   
    num = document.CompanyPubJobForm.num.value;
    if (num.length > 5) {
        alert("招聘人数超出范围");
        document.CompanyPubJobForm.num.focus();
        return false;
    }
    if (num.search(/^[0-9]+$/) < 0) {
        alert("招聘人数为空或包含非法字符");
        document.CompanyPubJobForm.num.focus();
        return false;
    }
    
    sTime = document.CompanyPubJobForm.sTime.value;
    eTime = document.CompanyPubJobForm.eTime.value;
    str11 = new Date(sTime.replace("-", ",")).getTime()
    str22 = new Date(eTime.replace("-", ",")).getTime()
    var days = str22 - str11;
    var time = parseInt(days / (1000 * 60 * 60 * 24));
    
    if (str11 >= str22) {
        alert("截止时间必须大于发布时间");
        return false;    
    }
   // if (time>180) {
     //   alert("截止时间与发布时间间隔不得大于180天！");
      //  return false;    
    //}
    
    experience = document.CompanyPubJobForm.experience.value;
    if (experience.length > 4) {
        alert("工作经验年限超出范围");
        document.CompanyPubJobForm.experience.focus();
        return false;
    }
    if (experience.search(/^[0-9./.]+$/) < 0 && experience != "") {
        alert("工作经验包含非法字符");
        document.CompanyPubJobForm.experience.focus();
        return false;
    }
if (experience.length<=0) {
        alert("工作经验不能为空");
        document.getElementById("experience").focus();
        return false;
    }
    address= document.CompanyPubJobForm.address.value;
    if(address.length<=0){

    	alert("工作地点不能为空");
    	document.CompanyPubJobForm.address.focus();
        return false;
        }
if(address.length>100){

    	alert("工作地点必须小于100字");
    	document.CompanyPubJobForm.address.focus();
        return false;
        }
    
    intro = document.CompanyPubJobForm.intro.value;
    if (intro.length > 200||intro.length<=0) {
    	alert("职位说明在1-200字符之间");
        document.CompanyPubJobForm.intro.focus();
        return false;
    }
    welfare = document.CompanyPubJobForm.welfare.value;
    if (welfare.length > 200) {
    	alert("福利待遇不得超出200字符");
        document.CompanyPubJobForm.welfare.focus();
        return false;
    }
    sage = document.CompanyPubJobForm.stratage.value;
    eage = document.CompanyPubJobForm.endage.value;
    document.CompanyPubJobForm.age.value=sage+"--"+eage;
var a=confirm("添加后此条招聘信息将进入待审核状态");
    if(!a){
    return false;
    }
}

</SCRIPT>
<script>
function checkdate(){
	sTime = document.CompanyPubJobForm.sTime.value;
	var d1 = new Date();
    str11 = new Date(sTime.replace("-", ","));
    d1.setDate(str11.getDate()+180);
    var nowStr = d1.format("yyyy-MM-dd"); 
    document.CompanyPubJobForm.eTime.value=nowStr;
    
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>企业招聘信息编辑</title>

	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script src="/clrcw/public/js/calendar.js"></script>
	<SCRIPT id="ABT" src="/clrcw/js/shanDong.js" type="text/javascript"></SCRIPT>
<<style>
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

			<div id="content">
				<h2>
					企业[${compUserId}]招聘 &nbsp;&nbsp;
					<a href="${ctx}/companyLogin.do?method=loginOut"
						style="color: #BD0403;">[退出]</a>
				</h2>
				<DIV class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li>
							<a href="${ctx}/companyRegist2.do?method=companyShowInfo">&equiv;&nbsp;企业基本情况</a>
						</li>
						<li class="liH1">
							<a href="${ctx}/companyPubJob.do?method=showPubJob"
								style="color: #BD0403;">&equiv;&nbsp;企业招聘信息 </a>
						</li>
						<li>
							<a href="${ctx}/companySPerson.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li>
							<a href="${ctx}/companyQueryNotContact.do?method=showCompResume">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li>            
							<a href="${ctx}/companyAbility.do?method=showCompAbility"
								>&equiv;&nbsp;人才库管理</a>
						</li>
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%; clear:both;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">

					<form name="form1" method="post" action="">
						<input type="hidden" name="id" value="">
						<input type="hidden" name="flag" value="">

						<TABLE class="finktable" summary="企业招聘信息" width="100%" border="0"
							cellspacing="0" cellpadding="0">

							<tr>
								<TD align="left" class="th1 black"
									style="font-size: 14px; border-left: #900 3px solid;"
									colspan="7">
									<strong>招聘职位列表（点击编辑，进入招聘职位修改页面）：</strong>
								</TD>
							</TR>
							<TR>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									招聘职位
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									招聘人数
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									学历要求
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									发布时间
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									有效期
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									审核状态
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									操 作
								</TD>
							</TR>
							<logic:present name="job">
								<logic:notEmpty name="job">
									<logic:iterate id="info" name="job" type="model.PublishJobInfo">

										<tr>
											<td align="center"
												style="color: rgb(0, 0, 0); font-size: 12px;">
												<bean:write property="job.jobName" name="info" />
											</td>
											<td align="center"
												style="color: rgb(0, 0, 0); font-size: 12px;">
												<bean:write property="jobAmount" name="info" />
											</td>
											<td align="center"
												style="color: rgb(0, 0, 0); font-size: 12px;">
												<bean:write property="education.educateName" name="info" />
											</td>
											<td align="center"
												style="color: rgb(0, 0, 0); font-size: 12px;">
												<bean:write property="publishTime" name="info" />
											</td>
		
											
											<td align="center"
												style="color: rgb(0, 0, 0); font-size: 12px;">
												<bean:write property="closeTime" name="info" />
											</td>
											
											<td align="center"
												style="color: rgb(0, 0, 0); font-size: 12px;">
									 <c:if test="${fn:trim(info.status)=='0'}">待审核</c:if>
												<c:if test="${fn:trim(info.status)=='1'}">审核未通过</c:if>
												<c:if test="${fn:trim(info.status)=='2'}">审核通过</c:if>
											</td>
											<td align="center"
												style="color: rgb(0, 0, 0); font-size: 12px;">
												<c:if test="${info.validflag=='1'}">
												<a class="tabBtn" href="${ctx}/companyPubJob.do?method=updatePubJob&id=${info.id}">编辑</a>
												</c:if>
												<c:if test="${info.validflag=='3'||info.validflag=='2'}">
												<a class="tabBtn" href="${ctx}/companyServicelog.do?method=showOneServicelog&jobid=${info.id}">查看</a>
												
												</c:if>
											
												<c:if test="${info.validflag=='1'}">
												
												<a href="#" class="tabBtn" onClick="endflag('${info.id}','${info.validflag}','${info.status}')">招聘结束</a>
												</c:if>
												<c:if test="${info.validflag=='2'}">
												
												<a href="#" class="tabBtn" onClick="endflag('${info.id}','${info.validflag}')">招聘失败</a>
												</c:if>
												<c:if test="${info.validflag=='3'}">
												
												<a href="#" class="tabBtn" onClick="endflag('${info.id}','${info.validflag}')">招聘成功</a>
												</c:if>
                                   
											   <a href="#" class="tabBtn" onClick="postpone1('${info.closeTime}','${info.id}')"> 延期</a>
											 <a href="#" class="tabBtn" onClick="del('${info.id}')"> 删除</a>
											</td>
										</tr>
									</logic:iterate>
								</logic:notEmpty>
								<logic:empty name="job">
									<p style="color: #BD0403;">
										您还没有添加招聘信息，请在下面添加！
									</p>
								</logic:empty>

							</logic:present>

						</table>
					</form>
					</br>
					<html:form action="/companyPubJob.do?method=addPubJob"
						method="post" onsubmit="return checkform()">
						<TABLE class="finktable" summary="企业招聘信息" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<TD align="left" colspan="4"
									style="border-top: #900 2px solid; background: #ddd;">
									<strong>添加招聘信息：</strong>
								</TD>
							</TR>
							<tr>
								<td class="black">
									<label for="jobId">
										招聘职位：
									</label>
								</td>
								<td title="请选择职位">
									<bean:define id="aJob" name="bdJob" type="java.util.List" />
									<html:select property="jobId">
										<html:options collection="aJob" property="id"
											labelProperty="jobName" />
									</html:select>
								</td>

								<td class="black">
									<label for="age">
										年龄限制：
									</label>
								</td>
								<td title="请输入年龄限制">
									<select name="stratage" id="sage">
										<%
											for (int i = 16; i < 60; i++) {
										%>
										<option><%=i%></option>
										<%
											}
										%>
									</select>
									--
									<select name="endage" id="eage">
										<%
											for (int i = 59; i > 16; i--) {
										%>
										<option><%=i%></option>
										<%
											}
										%>
									</select>
									<input type="hidden" name="age" id="age" />

								</td>
							</tr>
							<tr>
								<td class="black">
									<label for="sTime">
										发布时间：
									</label>
								</td>
								<td><%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())%>
									<input type="hidden" id="sTime" name="sTime"
										value="<%=new SimpleDateFormat("yyyy-MM-dd")
							.format(Calendar.getInstance().getTime())%>"
										>
								</td>
								<td class="black">
									<label for="eTime">
										截止时间：
									</label>
								</td>
								<td>
									<input type="text" name="eTime" title="请选择截止时间" id="eTime"
										value="<%=new SimpleDateFormat("yyyy-MM-dd")
							.format(Calendar.getInstance().getTime())%>"
										onclick="calendar.show(this);" readonly="readonly"
										class="input3">
								</td>
							</tr>
							<tr>
								<td class="black">
									<label for="grading">
										应届生/往届生：
									</label>
								</td>
								<td title="请选择应届生/往届生">
									<select id="grading" name="grading">
										<option value="0">
											应届生
										</option>
										<option value="1">
											往届生
										</option>
										<option value="2">
											不限
										</option>
									</select>
								</td>
								<td class="black">
									<label for="aEducate">
										学历要求：
									</label>
								</td>
								<td title="请选择学历要求">
									<bean:define id="aEducate" name="bdEducate"
										type="java.util.List" />
									<html:select property="education">
										<html:options collection="aEducate" property="id"
											labelProperty="educateName" />
									</html:select>
									(含以上)
								</td>
							</tr>
							<tr>
								<td class="black">
									<label for="num">
										招聘人数：
									</label>
								</td>
								<td title="请输入招聘人数">
									<input id="num" type="text" name="num" value="" class="input3">
									*
								</td>
								<td class="black">
									<label for="money">
										月 薪：
									</label>
								</td>
								<td title="请选择月薪">
									<select name="money" id="money" title="请选择月薪">
									<%
													List salarylist = (List) request.getAttribute("salarylist");
																for (int i = 0; i < salarylist.size(); i++) {
																	BdSalary salary = (BdSalary) salarylist.get(i);
														%>
														<option value="<%=salary.getSalaryname()%>"><%=salary.getSalaryname()%></option>
														<%
															}
														%>
										
									</select>	
									（不低于北京市最低标准）
								</td>
							</tr>
							<tr>
								<td class="black">
									<label for="experience">
										工作经验年限：
									</label>
								</td>
								<td>
									<span class="font5"> <input type="text" id="experience"
											title="请输入工作经验年限" name="experience" value="" class="input3">
											*(含以上)
									</span>
								</td>
								<td class="black">
									<label for="money">
										工作性质：
									</label>
								</td>
								<td title="请输入工作性质" class="black">
									<select id="nature" name="nature">
										<option value="1">
											全职
										</option>
										<option value="2">
											兼职
										</option>
										<option value="3">
											临时工
										</option>
										<option value="4">
											小时工
										</option>
										<option value="5">
											不限
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="black">
									<label for="workarea">
										工作区域：
									</label>
								</td>
								<td>
									<span class="font5">
											<select id="workarea"
											title="请选择工作区域" name="workarea"
											>
									<%
															List sss = (List) request.getAttribute("arealist");
																for (int i = 0; i < sss.size(); i++) {
																	Areacode areacode = (Areacode) sss.get(i);
														%>
														<option value="<%=areacode.getAreaname()%>"><%=areacode.getAreaname()%></option>
														<%
															}
														%>
									</select>
									</span>
								</td>
								<td class="black">
									<label for="address">
										工作地点：
									</label>
								</td>
								<td title="请输入工作地点">
									<input type="text" id="address" name="address" value=""
										class="input3">
										*
								</td>
							</tr>
							<tr>
							<td class="black">
									<label for="dkind">
										残疾类别：
									</label>
								</td>
								<td>
										<select name="postId" id="postId" title="请选择残疾类别">
											<%
												List ccc = (List) request.getAttribute("bdPost");
													for (int i = 0; i < ccc.size(); i++) {
														BdPost bdPost = (BdPost) ccc.get(i);
											%>
											<option value="<%=bdPost.getId()%>"><%=bdPost.getPostName()%></option>
											<%
												}
											%>
										</select>
									</td>
								</tr>
							<tr>
								<td valign="top" class="black">
									<label for="intro">
										职位说明：
									</label>
								</td>
								<td colspan="3">
									<textarea name="intro" id="intro" title="请输入职位说明" cols="50"
										rows="4" class="input5"></textarea>
										*
								</td>
							</tr>
							<tr>
								<td valign="top" class="black">
									<label for="intro">
										福利待遇：
									</label>
								</td>
								<td colspan="3">
									<textarea name="welfare" id="welfare" title="请输入福利待遇" cols="50"
										rows="4" class="input5"></textarea>
								</td>
							</tr>
						</table>
						<div
							style="text-align: center; padding: 20px 0; margin: -1px 0 0 0; border: #ddd 1px solid; background: #ededed;">

							<html:submit property="submit" value="添加" styleClass="input4" />
							<html:reset property="reset" value="重置" styleClass="input4" />
						</div>
					
					</html:form>
				</div>
			</div>
		</div>




		<iframe src="/clrcw/public/include/footer.html" height="150"
			width="960" id="iframe_foot" frameborder="0" scrolling="no"
			title="底部脚本"></iframe>



	</div>

	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>

</body>
</html:html>
