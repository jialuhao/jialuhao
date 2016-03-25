<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="common.constants.IConstants"%>

<script language="JavaScript" type="text/JavaScript">
function select(){
	var temp=document.getElementsByName("radio");
	 var userid=document.getElementById("userId").value;
	 var ps=document.getElementById("password").value;
	 if(userid==""||userid==null){
	 alert("用户名不能为空");
return false;
	 }
	  if(ps==""||ps==null){
	 alert("密码不能为空");
return false;
	 }
	if(temp[0].checked ){
		 document.all.form3.action="${ctx}/indexLogin.do?method=indexLogin";
	    document.all.form3.submit();
    } else {
	    document.all.form3.action="${ctx}/indextCLogin.do?method=indextCLogin";
	    document.all.form3.submit();
   }
}
function nologinp(){
	alert("请登录个人用户！");
}	
function nologinc(){
	alert("请登录企业用户！");
}	
function search1(){
	document.searchFrom1.action="${ctx}/personSearch.do?method=showAll";
	document.searchFrom1.submit();
}
function change(s_id){
    document.form1.pageIndex.value=s_id;
    document.form1.action="${ctx}/companyShow.do?method=showOtherPage";
	document.form1.submit();
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<title>企业招聘信息</title>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link href="/clrcw/css/public.css" rel="stylesheet" type="text/css" />
		<link href="/clrcw/css/index4.css" rel="stylesheet" type="text/css" />
		<link href="/clrcw/css/mainframe.css" rel="stylesheet" type="text/css" />
		<link href="/clrcw/css/modelist.css" rel="stylesheet" type="text/css" />
		<script src="/clrcw/js/menu.js" type="text/javascript"></script>
		<script id="ABT" src="/clrcw/js/shanDong.js" type="text/javascript"></script>
		<script type="text/javascript" src="/clrcw/js/public.js"></script>
	</head>
	<body>
		<div id="container">
			<div id="header">
				<iframe id="iframe_head" frameborder="0" scrolling="no" height="150"
					width="960">
				</iframe>
			</div>

			<div id="main">
				<div id="content">
					<h2>
						求职招聘
					</h2>
					<div id="login_zc1">

						<form name="form3" id="form3" method="post"
							action="/clrcw/login.do?method=login">
							<div id="form_div">
								<div class="basic_message fn-clear">
									<div class="user f_l"
										style="height: auto; background-color: #ededed; width: 630px">
										<p style="padding: 0 0 10px 20px;">
											<input name="radio" type="radio" value="1" checked="checked"/>
											个人用户&nbsp;&nbsp;
											<input name="radio" type="radio" value="2" />
											企业用户
										</p>
										<p style="padding: 0px 0 10px 20px;">
											<input name="userId" id="userId" type="text"
												style="height: 24px; margin: 0 10px 0 0;" value="用户名"
												onfocus="if (value =='用户名'){value =''}"
												onblur="if (value ==''){value='用户名'}" title="请输入用户名"/>
											<input name="password" id="password" type="password" style="height: 24px;"
												value="密码" onfocus="if (value =='密码'){value =''}"
												onblur="if (value ==''){value='密码'}" title="请输入密码"/>
										</p>
										<a class="btn1 f_l" href="###" style="margin-left: 20px;" onclick="select()">立即登录</a>
										<br />
									</div>
									<div class="f_r" style="width: 150px; margin: 15px 10px 0 0;">
										<a href="${ctx}/pages/personal/personRegist0.jsp"><img
												src="/clrcw/img/gr_reg.jpg" /> </a>
										<a href="${ctx}/pages/company/companyRegist0.jsp"><img
												src="/clrcw/img/qy_reg.jpg" /> </a>
									</div>
								</div>
							</div>
						</form>
					</div>


					<div style="clear: both;"></div>

					<div class="formdiv">
						<div
							style="background: #fff; padding: 10px 20px; border: #ddd 1px solid; border-left: #900 2px solid;">
							<form name="searchFrom1" action="#" method="post">
								<p class="p_text">
									<label for="textfield3">
										职位搜索：
									</label>
									<input name="textfield3" type="text" title="请输入要查询的职位"
										id="textfield3" >
									<img src="<%=request.getContextPath()%>/images/index_39.jpg"
										width="21" height="19" alt="搜索" onClick="search1()">
									<!-- >a href="${ctx}/companyShow.do?method=showAll"">&nbsp;
										&nbsp;更多招聘信息>></a-->
								</p>
							</form>
						</div>
						<table class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<TBODY>
								<tr>
									<th rowspan="2" class="h2th">
										企业招聘信息
									</th>
									<th valign="top">
										<table class="finktable" width="100%" border="0"
											cellspacing="0" cellpadding="0">
											<TBODY>
												<tr>
													<TH
														style="padding: 10px; width: 100px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
														公司名称
													</TH>
													<TH
														style="padding: 10px; width: 100px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
														招聘职位
													</TH>
													<TH
														style="padding: 10px; width: 100px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
														招聘人数
													</TH>
													<TH
														style="padding: 10px; width: 100px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
														学历
													</TH>
													<TH
														style="padding: 10px; width: 100px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
														工作地点
													</TH>
													<TH
														style="padding: 10px; width: 100px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
														发布时间
													</TH>


												</tr>

												<form action="" name="form1" method="POST">
													<logic:present name="allPublishJobInfo">
														<logic:notEmpty name="allPublishJobInfo">
															<logic:iterate name="allPublishJobInfo"
																id="publicJobInfo" type="model.PublishJobInfo">
																<tr>
																	<td width="150" align="center"
																		style="color: rgb(0, 0, 0); font-size: 14px;">
																		<a
																			href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${publicJobInfo.pkComp.comp.id}&loginId=${publicJobInfo.pkComp.comp.userId}"
																			class="p" target="_blank" align="center"
																			style="color: #000000; font-size: 12px;"> <bean:write
																				property="pkComp.comp.compName" name="publicJobInfo" />
																		</a>
																	</td>

																	<td width="150" align="center"
																		style="color: rgb(0, 0, 0); font-size: 14px;">
																		<a
																			href="${ctx}/personRegist7.do?method=personRegist7&jobKey=${publicJobInfo.id}&compName=${publicJobInfo.pkComp.comp.compName}"
																			class="p"> <bean:write property="job.jobName"
																				name="publicJobInfo" /> </a>
																	</td>
																	<td width="150" align="center"
																		style="color: rgb(0, 0, 0); font-size: 14px;">
																		<bean:write property="jobAmount" name="publicJobInfo" />
																	</td>
																	<td width="150" align="center"
																		style="color: rgb(0, 0, 0); font-size: 14px;">
																		<bean:write property="education.educateName"
																			name="publicJobInfo" />
																	</td>
																	<td width="150" align="center"
																		style="color: rgb(0, 0, 0); font-size: 14px;">
																		<bean:write property="address" name="publicJobInfo" />
																	</td>
																	<td width="150" align="center"
																		style="color: rgb(0, 0, 0); font-size: 14px;">
																		<bean:write property="publishTime"
																			name="publicJobInfo" />
																	</td>
																</tr>
															</logic:iterate>
															<html:hidden property="pageIndex" value="" />
															<%
																int pageIndex = ((Integer) request
																					.getAttribute("pageIndex")).intValue();
																			int tpp = ((Integer) session.getAttribute("tpp"))
																					.intValue();
																			if (tpp == 0) {

																			} else if (pageIndex == 0) {
															%>
															<tr>
																<td height="23" colspan="6" align="right">
																	<a href="#" class="list"
																		onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
																</td>
															</tr>
															<%
																} else if (pageIndex == tpp) {
															%>
															<tr>
																<td height="23" colspan="6" align="right">
																	<a href="#" class="list"
																		onClick="change(<%=pageIndex%>-1)">上一页</a>
															</tr>
															<%
																} else {
															%>
															<tr>
																<td height="23" colspan="6" align="right">
																	<a href="#" class="list"
																		onClick="change(<%=pageIndex%>-1)">上一页</a>
																	<a href="#" class="list"
																		onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
																</td>
															</tr>
															<%
																}
															%>
														</logic:notEmpty>
														<logic:empty name="allPublishJobInfo">
															<p class="font5">
																没有企业招聘信息!
															</p>
														</logic:empty>
													</logic:present>

													<logic:notPresent name="allPublishJobInfo">
														<p class="font5">
															没有企业招聘信息!
														</p>
													</logic:notPresent>
												</form>
											</TBODY>
										</table>
									</th>
								</tr>
							</TBODY>
						</table>
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
	<html:javascript formName="LoginForm" />
</html:html>
