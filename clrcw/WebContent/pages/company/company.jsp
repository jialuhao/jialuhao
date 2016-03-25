<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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





function search2(){
    document.searchFrom2.action = "${ctx}/companySearch.do?method=showAll";
    document.searchFrom2.submit();
}

function change(s_id){
	
 document.form1.pageIndex.value = s_id;
   
    document.form1.action = "${ctx}/personShow.do?method=showOtherPage";
    
    document.form1.submit();
    
}

function checkform(){
    if (document.CompanyLoginForm.userId.value == "") {
        alert("用户名不能为空！");
        document.CompanyLoginForm.userId.focus();
        return false;
    }
    if (document.CompanyLoginForm.password.value == "") {
        alert("密码不能为空！");
        document.CompanyLoginForm.password.focus();
        return false;
    }
}

function nologin(){
    alert("请登录企业用户！");
    document.CompanyLoginForm.userId.focus();
}

</script>

<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人求职信息</title>
	<head>
		<link href="<%=request.getContextPath()%>/css/index4.css"
			rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
		<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
		<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />

		<link rel="stylesheet" type="text/css" id="ABTStyle"
			href="/clrcw/css/skin.css" />
		<script src="/clrcw/js/public.js" type="text/javascript"></script>
		<script src="/clrcw/js/menu.js" type="text/javascript"></script>

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
						求职招聘
					</h2>
					<div id="login_zc1">

						<form name="form3" id="form3" method="post"
							action="/companyLogin.do?method=login">
							<div id="form_div">
								<logic:notPresent name="compUserId">
									<div class="basic_message fn-clear">
										<div class="user f_l"
											style="height: auto; background-color: #ededed; width: 630px">
											<p style="padding: 0 0 10px 20px;">
												<input name="radio" type="radio" value="1" checked="checked" />
												个人用户&nbsp;&nbsp;
												<input name="radio" type="radio" value="2" />
												企业用户
											</p>
											<p style="padding: 0px 0 10px 20px;">
												<input name="userId" id="userId" type="text"
													style="height: 24px; margin: 0 10px 0 0;" value="用户名"
													onfocus="if (value =='用户名'){value =''}"
													onblur="if (value ==''){value='用户名'}" />
												<input name="password" id="password" type="password"
													style="height: 24px;" value="密码"
													onfocus="if (value =='密码'){value =''}"
													onblur="if (value ==''){value='密码'}" />
											</p>
											<a class="btn1 f_l" style="margin-left: 20px;"
												onclick="select()">立即登录</a>
											<br />
										</div>
										<div class="f_r" style="width: 150px; margin: 15px 10px 0 0;">
											<a href="${ctx}/pages/personal/personRegist0.jsp"><img
													src="/clrcw/img/gr_reg.jpg" /> </a>
											<a href="${ctx}/pages/company/companyRegist0.jsp"><img
													src="/clrcw/img/qy_reg.jpg" /> </a>
										</div>
									</div>
								</logic:notPresent>


								<logic:present name="compUserId">
									<div class="basic_message">
										<div class="user">
											<p class="f_l">
												<span>用户名：<bean:write name="compUserId" /> </span>
												
											</p>
											<a class="edit f_r"
												href="${ctx}/companyRegist2.do?method=companyShowInfo">企业信息</a>
											<a href="${ctx}/pages/company/modifyPassword.jsp" class="b">修改密码</a>
											<a class="edit f_r"
												href="${ctx}/companyLogin.do?method=loginOut">安全退出</a>
										</div>
									</div>


								</logic:present>
							</div>
						</form>
					</div>
					<div style="clear: both;"></div>

					<div class="formdiv">
						<div
							style="background: #fff; padding: 10px 20px; border: #ddd 1px solid; border-left: #900 2px solid;">
							<form name="searchFrom2" action="#" method="post">
								<P class="p_text">
									<LABEL for="textfield3" class="f_l">
										<strong>职位搜索：</strong>     
									</LABEL>
									<INPUT name="textfield4" title="请输入要查询的职位" id="textfield4"
										type="text" class="f_l">
									<IMG width="21" height="19" onclick="search2()" alt="搜索"
										src="<%=request.getContextPath()%>/img/index_39.jpg"
										class="f_l mgr1" style="cursor: pointer;">

									<spam>
									<!-- A
										href="${ctx}/companyShow.do?method=showAll">&nbsp;&nbsp;更多招聘信息&gt;&gt;</A-->
									</spam>
								</P>

							</form>
						</div>
						<table id="form_1" class="finktable">
							<tr>
								<th rowspan="2" class="h2th">
									个人求职信息
								</th>
								<th valign="top">
									<table class="finktable">
										<tr>
											<th
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
												姓名
											</th>
											<th
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
												期望从事行业
											</th>
											<th
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
												应聘职位
											</th>
											<th
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
												学历
											</th>
											<th
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
												求职地区
											</th>
											<th
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
												登记时间
											</th>
										</tr>


										<form action="" name="form1" method="POST">
											<logic:present name="allApplyJobInfo">
												<logic:notEmpty name="allApplyJobInfo">
													<logic:iterate name="allApplyJobInfo" id="jobInfo"
														type="model.ApplyJobInfo">

														<tr>
															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																<bean:write property="resumeCode.name" name="jobInfo" />
															</td>
															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																<bean:write property="postCode.tradeName" name="jobInfo" />

																<td width="150px" height="23" align="center">
																	<logic:present name="compUserId">
																		<a
																			href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
																			class="p" align="left"
																			style="color: #000000; font-size: 12px;"> <bean:write
																				property="jobCode.jobName" name="jobInfo" /> </a>
																	</logic:present>
																	<logic:notPresent name="compUserId">
																		<a href="#" class="p" onClick="nologinc()"
																			align="left" style="color: #000000; font-size: 12px;">
																			<bean:write property="jobCode.jobName" name="jobInfo" />
																		</a>
																	</logic:notPresent>
																</td>


																<td width="150px" align="center"
																	style="color: #000000; font-size: 12px;">
																	<bean:write property="resumeCode.educate.educateName"
																		name="jobInfo" />

																	<td width="150px" align="center"
																		style="color: #000000; font-size: 12px;">
																		<bean:write property="workYear" name="jobInfo" />
																	</td>

																	<td width="150px" align="center"
																		style="color: #000000; font-size: 12px;">
																		<bean:write property="createTime" name="jobInfo" />
																	</td>
														</tr>
													</logic:iterate>


													<input type="hidden" name="pageIndex" id="pageIndex"
														value="">
													<%
														int pageIndex = ((Integer) request
																			.getAttribute("pageIndex")).intValue();
																	int tpn = ((Integer) session.getAttribute("tpn"))
																			.intValue();
																	if (tpn == 0) {

																	} else if (pageIndex == 0) {
													%>
													<tr>
														<td height="23" colspan="6" align="right">
															<a href="#" class="list"
																onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
														</td>
													</tr>
													<%
														} else if (pageIndex == tpn) {
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
												<logic:empty name="allApplyJobInfo">
													<tr>
														<td colspan="6">
															<p class="font5">
																没有个人求职信息！
															</p>
														</td>
													</tr>
												</logic:empty>
											</logic:present>
											<logic:notPresent name="allApplyJobInfo">
												<tr>
													<td colspan="6">
														<p class="font5">
															没有个人求职信息！
														</p>
													</td>
												</tr>
											</logic:notPresent>

										</form>

									</table>
								</th>

							</tr>
							

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
</html:html>

