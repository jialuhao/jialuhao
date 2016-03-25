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
	    document.all.form3.action="${ctx}/companyLogin.do?method=login";
	    document.all.form3.submit();
   }
}





function search2(){
    document.searchFrom2.action = "${ctx}/companySearch.do?method=showAll";
    document.searchFrom2.submit();
}

function change(s_id){
    document.form1.pageIndex.value = s_id;
    document.form1.action = "${ctx}/companySearch.do?method=showOtherPage";
    
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

function nologinc(){
	alert("请登录企业用户！");
}	

</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人求职信息列表</title>
	<head>
		<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index4.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script type="text/javascript" src="/clrcw/js/shanDong.js" id="ABT"></script>
	<script type="text/javascript" src="/clrcw/js/public.js"></script>

	</head>
	<body>
		<div id="container">
			<div id="header">
				<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
					frameborder="0" scrolling="no" height="150" width="960">
				</iframe>
			</div>
			<div id="main">

				<%
					String pid = (String) request.getSession().getAttribute(
								IConstants.PERSON_USER_ID);
						String cid = (String) request.getSession().getAttribute(
								IConstants.COMP_USER_ID);
				%>


				<div id="content">
					<h2>
						求职招聘
					</h2>




					<div id="login_zc1">

						<form action="" name="form3" method="POST">
							<div id="form_div">
								<%
									if (pid == null && cid == null) {
								%>
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
												onblur="if (value ==''){value='用户名'}" title="请输入用户名"/>
											<input name="password" id="password" type="password" style="height: 24px;"
												value="密码" onfocus="if (value =='密码'){value =''}"
												onblur="if (value ==''){value='密码'}" title="请输入密码"/>
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
								<%
									} else if (pid == null && cid != null) {
								%>
								<div class="basic_message">
									<div class="user">
										<p class="f_l">
												<span>用户名：<bean:write name="compUserId" /> </span>
												
											</p>
										<a class="edit f_r"
											href="${ctx}/companyLogin.do?method=loginOut">安全退出</a>
										<a class="edit f_r"
											href="${ctx}/pages/company/modifyPassword.jsp" class="b">修改密码</a>

										<a class="edit f_r"
											href="${ctx}/companyRegist2.do?method=companyShowInfo">企业信息</a>
									</div>
								</div>
								<%
									} else {
								%>
								<div class="basic_message">
									<div class="user">
										<p class="f_l">
											<span><bean:message key="username" /> ：<%=pid%> </span>
											
										</p>
										<a class="edit f_r"
											href="${ctx}/companyLogin.do?method=loginOut">安全退出</a>
										<a class="edit f_r"
											href="${ctx}/pages/personal/modifyPassword.jsp" class="b">修改密码</a>
										<a class="edit f_r"
											href="${ctx}/personRegist3.do?method=personRegist3">个人简历</a>
									</div>
								</div>


								<%
									}
								%>

							</div>
						</form>
					</div>

					<div style="clear: both;"></div>

					<div class="formdiv">
					<div
							style="background: #fff; padding: 10px 20px; border: #ddd 1px solid; border-left: #900 2px solid;">						
						<form name="searchFrom2" action="#" method="post">
							<p class="p_text">
								<label for="textfield4">
									职位搜索：
								</label>
								<%String search=(String)session.getAttribute("search"); 
								  search=search==null?"":search;
								%>
								<input name="textfield3" type="text" title="请输入职位搜索"
									class="input2" id="textfield4" value="<%=search%>">
								<img src="<%=request.getContextPath()%>/images/index_39.jpg"
									width="21" height="19" alt="搜索" onClick="search2()">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</p>
						</form>
						</div>
						<table class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
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
																<logic:present name="compUserId">
																<a
																	href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
																	class="p" align="center"
																	style="color: #000000; font-size: 12px;"> <bean:write property="resumeCode.name" name="jobInfo" /></a>
															</logic:present>
															<logic:notPresent name="compUserId">
																<a href="#" class="p" onClick="nologinc()" align="center"
																	style="color: #000000; font-size: 12px;"> <bean:write property="resumeCode.name" name="jobInfo" /> </a>
															</logic:notPresent>
															</td>
															<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="postCode.tradeName" name="jobInfo" />
                                                </td>
															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																
																			<bean:write property="jobCode.jobName" name="jobInfo" />
																	
																</td>


																<td width="150px" align="center"
																	style="color: #000000; font-size: 12px;">
																	<bean:write property="resumeCode.educate.educateName"
																		name="jobInfo" />
                                                               </td>
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


													<html:hidden property="pageIndex" value="" />
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
															当前第<%=pageIndex+1%>页/共<%=tpn+1%>页  
															
		
			 <a
			href="#" class="list"
			onClick="change(<%=tpn+1%>)">尾页&nbsp;</a>
															<a href="#" class="list"
																onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
														</td>
													</tr>
													<%
														} else if (pageIndex == tpn) {
													%>
													<tr>
														<td height="23" colspan="6" align="right">
														当前第<%=pageIndex+1%>页/共<%=tpn+1%>页  
															<a href="#" class="list" onClick="change(0)">首页</a>
			
															<a href="#" class="list"
																onClick="change(<%=pageIndex%>-1)">上一页</a>
													</tr>
													<%
														} else {
													%>
													<tr>
														<td height="23" colspan="6" align="right">
														当前第<%=pageIndex+1%>页/共<%=tpn+1%>页  
															<a href="#" class="list" onClick="change(0)">首页</a>
			 <a
			href="#" class="list"
			onClick="change(<%=tpn+1%>)">尾页&nbsp;</a>
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
														<td rowspan="2" colspan="6" width="850" align="center" >
															<p class="font5">
																没有个人求职信息！
															</p>
														</td>
													</tr>
												</logic:empty>
											</logic:present>
											<logic:notPresent name="allApplyJobInfo">
												<tr>
													<td rowspan="2" colspan="6" width="850" align="center" >
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
							<tr>
                            <th style="width: auto; text-align: center;">
										
										
										<a class="btn1" style="margin-left: 20px;"
										onclick="javascript:history.back();">返回</a>
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

