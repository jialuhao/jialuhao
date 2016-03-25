<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="model.*"%>

<SCRIPT language="JavaScript" type="text/JavaScript">
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
    str11 = new Date(sTime.replace("-", ","));
    str22 = new Date(eTime.replace("-", ","));
    var time= str22.getTime() - str11.getTime(); 
    var days = parseInt(time / (1000 * 60 * 60 * 24));
    if (str11 >= str22) {
        alert("截止时间必须大于发布时间");
        return false;
    }
   
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
}

</SCRIPT>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>修改企业招聘信息</title>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script src="/clrcw/public/js/calendar.js"></script>
	<style>
	  #main{width:945px;_width:960px;}
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
					<td height="15">
					</td>
				</tr>
			</table>
			<div id="content">
				<h2>
				<%String compname=(String)request.getSession().getAttribute("compname"); %>
					企业[<%=compname %>]招聘 &nbsp;&nbsp;
					
				</h2>
				<DIV class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=companyShowInfo">&equiv;&nbsp;企业基本情况</a>
						</li>
						<li class="liH1">
							<a href="${ctx}/admin/aglientpublish.do?method=showPubJob"
								style="color: #BD0403;">&equiv;&nbsp;企业招聘信息 </a>
						</li>
						<li >
							<a href="${ctx}/admin/aglientpublish.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showCompResume">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li >
							<a href="${ctx}/admin/aglientpublish.do?method=showCompAbility"
								>&equiv;&nbsp;人才库管理</a>
						</li>
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;  clear:both;" >
					<form action="${ctx}/admin/aglientpublish.do?method=savePubJob"
						method="post" onsubmit="return checkform()" name="CompanyPubJobForm">
						<table class="finktable" summary="企业招聘信息">
							<tr>
								<TD align="left" class="th1 black"
									style="font-size: 14px; border-left: #900 3px solid;"
									colspan="4">
									修改招聘信息：
								</td>

							</tr>
							<%PublishJobInfo oneJob=(PublishJobInfo)request.getSession().getAttribute("oneJob"); %>
							<tr>
								<td width="200px" class="black">
									招聘职位：
								</td>
								<td width="270" class="font5" title="请选择招聘职位">
									<select name="jobId" id="jobId" >
										<%
											List aaa = (List) request.getSession().getAttribute("bdJob");
												for (int i = 0; i < aaa.size(); i++) {
													BdJob bdJob = (BdJob)aaa.get(i);
										%>
										<option value="<%=bdJob.getId()%>" <%if((oneJob.getJob().getId()+"").equals(bdJob.getId()+"")) {%>selected="selected"<% }%>><%=bdJob.getJobName()%></option>
										<%
											}
										%>
										</select>
								</td>
								<td width="150" class="font5 black">
									<label for="age">
										年龄限制：
									</label>
								</td>
								<td width="270" class="font5" title="请选择年龄限制">
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
									(<%=oneJob.getAgeLimit() %>)
									<input type="hidden" name="age" id="age" title="">
								</td>
							</tr>
							<tr>
								<td class="black">
									<span class="font5"><label for="sTime">
											发布时间：
										</label> </span>
								</td>
								<td>
									<span class="font5"><input type="text" title="请选择发布时间"
											id="sTime" name="sTime" value="<%=new SimpleDateFormat("yyyy-MM-dd")
							.format(Calendar.getInstance().getTime())%>"
											 readonly="readonly"
											class="input3"> </span>
								</td>
								<td class="black">
									<span class="font5"><label for="eTime">
											截止时间：
										</label> </span>
								</td>
								<td>
									<span class="font5"> <input type="text" id="eTime"
											title="请选择截止时间" name="eTime" value="${oneJob.closeTime}"
											onclick="calendar.show(this);" readonly="readonly"
											class="input3"> </span>
								</td>
							</tr>

							<tr>
								<td class="black">
									<span class="font5">应届生/往届生：</span>
								</td>
								<td title="请选择应届生/往届生">
									<html:select property="grading" value="${oneJob.grading}">
										<html:option value="0">应届生</html:option>
										<html:option value="1">往届生</html:option>
										<html:option value="2">不限</html:option>
									</html:select>
								</td>
								<td class="black">
									<span class="font5">学历要求：</span>
								</td>
								<td title="请选择学历要求">

									<select name="education" id="education" >
										<%
											List bbb = (List) request.getSession().getAttribute("bdEducate");
												for (int i = 0; i < bbb.size(); i++) {
													BdEducate bdEducate = (BdEducate)bbb.get(i);
										%>
										<option value="<%=bdEducate.getId()%>" <%if((oneJob.getEducation().getId()+"").equals(bdEducate.getId()+"")) {%>selected="selected"<% }%>><%=bdEducate.getEducateName()%></option>
										<%
											}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<td width="100" class="font5 black" >
									<label for="num">
										招聘人数：
									</label>
								</td>
								<td class="font5">
									<input type="text" name="num" title="请输入招聘人数" id="num"
										value="${oneJob.jobAmount}" class="input3">*
									*
								</td>
								<td class="black">
									<span class="font5"><label for="money">
											月 薪：
										</label> </span>
								</td>
								<td>
									<span class="font5">
									<select name="money" id="money" title="请选择月薪">
									<%
													List salarylist = (List) request.getSession().getAttribute("salarylist");
																for (int i = 0; i < salarylist.size(); i++) {
																	BdSalary salary = (BdSalary) salarylist.get(i);
														%>
														<option value="<%=salary.getSalaryname()%>" <%if((oneJob.getSalary()).equals(salary.getSalaryname())) {%>selected="selected"<% }%>><%=salary.getSalaryname()%></option>
														<%
															}
														%>
										
									</select>
									
									</span>
								</td>
							</tr>
							<tr>
								<td class="black">
									<span class="font5"><label for="experience">
											工作经验年限：
										</label> </span>
								</td>
								<td>
									<span class="font5"> <input type="text" id="experience"
											name="experience" title="请输入工作经验年限" style=""
											value="${oneJob.workYear}" />
											*</span>
								</td>
								<td class="black">
									<label for="money">
										工作性质：
									</label>
						
								</td>
								<td title="请输入工作性质">
									<html:select property="nature" value="${oneJob.nature}">
										<html:option value="1">全职</html:option>
										<html:option value="2">兼职</html:option>
										<html:option value="3">临时工</html:option>
										<html:option value="4">小时工</html:option>
										<html:option value="5">不限</html:option>
									</html:select>
							</tr>
							<tr>
								<td class="black">
									<span class="font5"><label for="experience">
											工作区域：
										</label> </span>
								</td>
								<td>
									<span class="font5"> 
								<select id="workarea"
											title="请选择工作区域" name="workarea">
									<%
															List sss = (List) request.getSession().getAttribute("arealist");
																for (int i = 0; i < sss.size(); i++) {
																	Areacode areacode = (Areacode) sss.get(i);
														%>
														<option value="<%=areacode.getAreaname()%>" <%if((oneJob.getWorkarea()).equals(areacode.getAreaname())) {%>selected="selected"<% }%>><%=areacode.getAreaname()%></option>
														<%
															}
														%>
											
											
											</select>
											</span>
								</td>

								<td class="black">
									<span class="font5"><label for="address">
											工作地点：
										</label> </span>
								</td>
								<td>
									<span class="font5"> <input type="text" id="address"
											name="address" title="请输入工作地点" style=""
											value="${oneJob.address}" />
											* </span>
								</td>
							</tr>
							<tr>
							<td class="black">
									<label for="dkind">
										残疾类别：
									</label>
								</td>
								<td>
								
										<select name="postId" id="postId" title="请选择残疾类别" >
											<%
												List ccc = (List) request.getSession().getAttribute("bdPost");  
													for (int i = 0; i < ccc.size(); i++) {
														BdPost bdPost = (BdPost)ccc.get(i);
											%>
											<option value="<%=bdPost.getId()%>" <%if((oneJob.getPost().getId()+"").equals(bdPost.getId()+"")) {%>selected="selected"<% }%>><%=bdPost.getPostName()%></option>
											<%
												}
											%>
										</select>
									</td>
									
								</tr>
							<tr>
								<td width="100" valign="top" class="black">
									<span class="font5"><label for="intro">
											职位说明：
										</label> </span>
								</td>
								<td colspan="3">

									<textarea name="intro" cols="50" id="intro" title="请输入职位说明"
										rows="4" class="input5">${oneJob.jobDesc}</textarea>*
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
										rows="4" class="input5">${oneJob.welfare}</textarea>
								</td>
							</tr>
						</table>
						<div
							style="text-align: center; padding: 20px 0; margin: -1px 0 0 0; border: #ddd 1px solid; background: #ededed;">

							<html:hidden property="infoKeyId" value="${oneJob.id}" />
							<html:hidden property="userName" value="${oneJob.compLoginId}" />
							<html:submit property="submit" value="保存" styleClass="btn1" />
							<input type="button" name="btn1" value="返回"
								onClick="history.go(-1)" class="btn1" >
						</div>
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

