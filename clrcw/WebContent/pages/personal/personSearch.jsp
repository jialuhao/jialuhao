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

function search1(){
	document.searchFrom1.action="${ctx}/personSearch.do?method=showAll";
	document.searchFrom1.submit();
}
function change(s_id){
    document.form1.pageIndex.value=s_id;
    document.form1.action="${ctx}/companyShow.do?method=showOtherPage";
	document.form1.submit();
}
function nologinp(){
	alert("请登录个人用户！");
}	
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
	<title>企业招聘信息</title>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
			<!--<div id="header">
				<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
					frameborder="0" scrolling="no" height="150" width="960">
				</iframe>
			</div>
			--><div id="main">


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
										<span><bean:message key="username" /> ：<%=cid %> </span>
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




					<!--  
 
      <div id="login_zc1">
      	<div id="form_div">
			<html:form action="/login.do?method=login" method="post"
			onsubmit="return validateLoginForm(this);">
		      <table cellpadding="0" cellspacing="0" >
  <tr   >
    <td  
					 width="40%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr><td align="center"><a href="#" class="b">个人用户登录</a></td>
					</tr>
				</table>
			</td>
    <td width="570" valign="top">
	
	<table width="570" border="1">
	<tr>
						
						<td width="110"  rowspan="3" align="left"><font color="red"> <html:errors
								property="noUser" /> <logic:present name="reLogin">
								<bean:write name="reLogin" />
							</logic:present> </font> </font></td>
				</tr>
				
				
  <tr>
   <td width="79" height="26" align="right"><bean:message key="username" />：</td>
				  <td width="187" align="left"><input type="text" name="userId" id="userId" title="请输入用户名" style="width:150px; height:23px;"/></td>
    <td width="67" rowspan="2"><button class="input4" type="submit">登录</button></td>
	<td width="153" rowspan="2"><p><a
							href="${ctx}/pages/personal/personRegist1.jsp" class="d">个人用户注册</a></br>
	</p>
	</td>
  </tr>
  <tr>
    <td height="25" align="right">密　码：</td>
						<td align="left"><input type="password" name="password"
							id="password" style="width:150px; height:23px;"  tite="请输入密码"/></td>
    </tr>
	
	
		
		
		
	 <tr>
  <td height="35" align="center" colspan="2"><bean:message
								key="username" />：</td>
    <td width="67" rowspan="2"><a href="${ctx}/companyLogin.do?method=loginOut" class="d">安全退出</a></td>
	<td width="153" rowspan="2"><p><a href="${ctx}/pages/personal/modifyPassword.jsp" class="b">修改密码</a></p></br><p><a
							href="${ctx}/personRegist3.do?method=personRegist3" class="b">个人简历</a></p>
	</p>
	</td>
  </tr>
  <tr>
    <td height="25" align="right"></td>
						<td align="left"> </td>
    </tr>
		
		
</table>
</td>
  </tr>
</table>
		

			</html:form>

		
          </div>
         
       </div>
	   
	-->

					<div style="clear: both;"></div>
					<div class="formdiv">
					<div
							style="background: #fff; padding: 10px 20px; border: #ddd 1px solid; border-left: #900 2px solid;">
					
						<form name="searchFrom1" action="#" method="post">
							<p class="p_text">
								<label for="textfield3">
									职位搜索： 
								</label>
								<%String search=(String)session.getAttribute("search2"); 
								  search=search==null?"":search;
								%>    
								<input name="textfield3" type="text" title="请输入要查询的职位"
									id="textfield3" value="<%=search%>" />
								<img src="<%=request.getContextPath()%>/images/index_39.jpg"
									width="21" height="19" alt="搜索" onClick="search1()">
								<!-- >a href="${ctx}/companyShow.do?method=showAll"">&nbsp;
									&nbsp;更多招聘信息>></a-->
							</p>
						</form>
						</div>
						<table id="form_1" class="finktable" width="100%" border="0"
						cellspacing="0" cellpadding="0">
							<tr>
								<th  class="h2th">
									企业招聘信息
								</th>
								<th valign="top">
									<TABLE class="finktable" width="100%" border="0" cellspacing="0"
									cellpadding="0">
										<TR>
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
										</TR>

										<form action="" name="form1" method="POST">
											<logic:present name="allPublishJobInfo">
												<logic:notEmpty name="allPublishJobInfo">
													<logic:iterate name="allPublishJobInfo" id="publicJobInfo"
														type="model.PublishJobInfo">
														<tr>
															<td width="150px" height="23" align="center">
																<%if(pid!=null){ %>
																<a
																	href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${publicJobInfo.pkComp.comp.id}&loginId=${publicJobInfo.pkComp.comp.userId}"
																	class="p" target="_blank" align="center"
																	style="color: #000000; font-size: 12px;"> <bean:write
																		property="pkComp.comp.compName" name="publicJobInfo" />
																</a>
																	<%}else{ %>
                                              	<a href="#" class="p" onClick="nologinp()" align="center"
																	style="color: #000000; font-size: 12px;"> <bean:write
																		property="pkComp.comp.compName" name="publicJobInfo" /> </a>
															<%}%>
																
															</td>

															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																<a
																	href="${ctx}/personRegist7.do?method=personRegist7&jobKey=${publicJobInfo.id}&compName=${publicJobInfo.pkComp.comp.compName}"
																	class="p"> <bean:write property="job.jobName"
																		name="publicJobInfo" /> </a>
															</td>
															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																<bean:write property="jobAmount" name="publicJobInfo" />
															</td>
															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																<bean:write property="education.educateName"
																	name="publicJobInfo" />
															</td>
															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																<bean:write property="address" name="publicJobInfo" />
															</td>
															<td width="150px" align="center"
																style="color: #000000; font-size: 12px;">
																<bean:write property="publishTime" name="publicJobInfo" />
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
															当前第<%=pageIndex+1%>页/共<%=tpp+1%>页  
																
			 <a href="#" class="list" onClick="change(<%=tpp+1%>)">尾页&nbsp;</a>
															<a href="#" class="list"
																onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
														</td>
													</tr>
													<%
														} else if (pageIndex == tpp) {
													%>
													<tr>
														<td height="23" colspan="6" align="right">
																当前第<%=pageIndex+1%>页/共<%=tpp+1%>页  
															<a href="#" class="list" onClick="change(0)">首页</a>
			
															<a href="#" class="list"
																onClick="change(<%=pageIndex%>-1)">上一页</a>
													</tr>
													<%
														} else {
													%>
													<tr>
														<td height="23" colspan="6" align="right">
																当前第<%=pageIndex+1%>页/共<%=tpp+1%>页  
															<a href="#" class="list" onClick="change(0)">首页</a>
															<a href="#" class="list" onClick="change(<%=tpp+1%>)">尾页&nbsp;</a>
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
									
									<tr>
                           
									</tr>
									</table>
									</form>
					
						<tr>
									<th colspan="6" style="width: auto; text-align: center;">
										
										
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
	<html:javascript formName="LoginForm" />
</html:html>
