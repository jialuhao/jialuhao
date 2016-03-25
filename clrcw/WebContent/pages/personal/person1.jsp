<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="common.constants.IConstants"%>

<script language="JavaScript" type="text/JavaScript">
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
<title><bean:message key="personPage" /></title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/mainframe.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/modelist.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/qzlb.css" />
<link rel="stylesheet" type="text/css" id="ABTStyle" href="/clrcw/styles/skin.css" />
<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>

</head>
<body>
<div id="container">
<!--<div id="header">
 <iframe id="iframe_head" src="http://211.99.136.80/headindex.html" frameborder="0" scrolling="no"
	height="150" width="960"> </iframe>
	</div>
  --><div id="main">



<table width="950" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<html:form action="/login.do?method=login" method="post"
			onsubmit="return validateLoginForm(this);">

			<td width="272" valign="top">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20"><img
						src="<%=request.getContextPath()%>/images/index_16.jpg" width="20"
						height="139" alt=""></td>
					<td valign="top"
						background="<%=request.getContextPath()%>/images/index_17.jpg">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align="center"><a href="#" class="b">个人用户登录</a></td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<!--  显示权限控制信息-->
						<tr>
							<td colspan="2"><font color="red"> <html:errors
								property="noUser" /> <logic:present name="reLogin">
								<bean:write name="reLogin" />
							</logic:present> </font></td>
						</tr>
						<%
							String vvv = (String) request.getSession().getAttribute(
									IConstants.PERSON_USER_ID);
							if (vvv == null) {
						%>

						<tr>
							<td height="25" align="right"><bean:message key="username" />：</td>
							<td align="left"><html:text property="userId" size="15" /></td>
						</tr>

						<tr>
							<td height="25" align="right">密　码：</td>
							<td align="left"><html:password property="password"
								size="15" /></td>
						</tr>
						<tr>
							<td height="25" colspan="2" align="center"><!--<a href="#" class="d">忘记密码</a>&nbsp;
							| &nbsp;--><a href="${ctx}/pages/personal/personRegist1.jsp"
								class="d">个人用户注册</a> &nbsp;
							<button class="input4" type="submit">登录</button>
							</td>
						</tr>
						<%
							} else {
						%>
						<tr>
							<td colspan="2" height="35" align="center"><bean:message
								key="username" />：<%=vvv%></td>
						</tr>

						<tr>
							<td height="25" align="center" colspan="2">
							<a href="${ctx}/pages/personal/modifyPassword.jsp" class="b">修改密码</a>|
							<a
								href="${ctx}/personRegist3.do?method=personRegist3" class="b">个人简历</a>
							| &nbsp;<a href="${ctx}/logout.do?method=logout" class="b">安全退出</a>
							</td>
						</tr>
						<%
							}
						%>

						<tr>
							<td></td>
							<td></td>
						</tr>
					</table>

					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="8" bgcolor="#FFFFFF"></td>
				</tr>
			</table>
			</td>
		</html:form>
		<td width="10">&nbsp;</td>
		<td valign="top">
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					bgcolor="#E5EAEE">
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td>

						<form name="searchFrom1" action="#" method="post">
						<table width="95%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="300"><img
									src="<%=request.getContextPath()%>/images/index_36.jpg"
									width="138" height="29" alt=""></td>
								<td align="right">
								<table width="205" border="0" cellspacing="0" cellpadding="0">
									<tr>

										<td width="60" class="font3">职位搜索</td>
										<td><input name="textfield3" type="text" class="input2"
											id="textfield3"></td>
										<td width="25"><img
											src="<%=request.getContextPath()%>/images/index_39.jpg"
											width="21" height="19" alt="搜索" onClick="search1()"></td>

									</tr>
								</table>
								</td>
							</tr>
						</table>
						</form>
						<table width="95%" border="0" align="center" cellpadding="1"
							cellspacing="1" bgcolor="9DB4EC">
							<tr>
								<td bgcolor="#E5EAEE">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="1"
											bgcolor="#FFFFFF">
											<tr>
												<td width="40%" height="23" align="center"
													background="<%=request.getContextPath()%>/images/index_48.jpg"
													class="font4">企业名称</td>
												<td width="40%" align="center"
													background="<%=request.getContextPath()%>/images/index_48.jpg"><span
													class="font4">招聘职位</span></td>
												<td width="20%" align="center"
													background="<%=request.getContextPath()%>/images/index_48.jpg"
													class="font4">企业性质</td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td>
										<form action="" name="form1" method="POST">
										<table width="100%" border="0" cellpadding="0" cellspacing="1"
											bgcolor="6D96C7">
											<%--显示企业招聘信息--%>
											<logic:present name="allPublishJobInfo">
												<logic:notEmpty name="allPublishJobInfo">
													<logic:iterate name="allPublishJobInfo" id="publicJobInfo"
														type="model.PublishJobInfo">
														<tr>
															<td width="40%" height="23" align="center"
																bgcolor="FEF9F9"><a
																href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${publicJobInfo.pkComp.comp.id}&loginId=${publicJobInfo.pkComp.comp.userId}"
																class="p" target="_blank"> <bean:write
																property="pkComp.comp.compName" name="publicJobInfo" /></a>
															</td>

															<td width="40%" align="center" bgcolor="FEF9F9"><a
																href="${ctx}/personRegist7.do?method=personRegist7&jobKey=${publicJobInfo.id}&compName=${publicJobInfo.pkComp.comp.compName}"
																class="p"> <bean:write property="job.jobName"
																name="publicJobInfo" /> </a></td>

															<td width="20%" align="center" bgcolor="FEF9F9"
																class="font5"> <bean:write
																property="pkComp.type.compTypeName" name="publicJobInfo" /></td>
														</tr>
													</logic:iterate>
													<html:hidden property="pageIndex" value="" />
													<%
														int pageIndex = ((Integer) request.getAttribute("pageIndex"))
																.intValue();
														int tpp = ((Integer) session.getAttribute("tpp")).intValue();
														if (tpp == 0) {

														} else if (pageIndex == 0) {
													%>
													<tr>
														<td height="23" colspan="3" align="right" bgcolor="FEF9F9">
														<a href="#" class="list"
															onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a></td>
													</tr>
													<%
														} else if (pageIndex == tpp) {
													%>
													<tr>
														<td height="23" colspan="3" align="right" bgcolor="FEF9F9">
														<a href="#" class="list"
															onClick="change(<%=pageIndex%>-1)">上一页</a>
													</tr>
													<%
														} else {
													%>
													<tr>
														<td height="23" colspan="3" align="right" bgcolor="FEF9F9">
														<a href="#" class="list"
															onClick="change(<%=pageIndex%>-1)">上一页</a> <a href="#"
															class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a></td>
													</tr>
													<%
														}
													%>
												</logic:notEmpty>
												<logic:empty name="allPublishJobInfo">
													<p class="font5">没有企业招聘信息!</p>
												</logic:empty>
											</logic:present>

											<logic:notPresent name="allPublishJobInfo">
												<p class="font5">没有企业招聘信息!</p>
											</logic:notPresent>
										</table>
										</form>
										</td>
									</tr>
								</table>

								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
  
 
</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>




</body>
<html:javascript formName="LoginForm" />
</html:html>
