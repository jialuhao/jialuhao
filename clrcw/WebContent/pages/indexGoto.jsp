<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../public/common/taglibs.jsp"%>
<%@ page import="common.constants.IConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PersonResume"%>
<%@ page import="model.PersonResumeB"%>
<%@ page import="model.ApplyJobInfo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="JavaScript" type="text/JavaScript">
function search1(){
	var tp=document.getElementById("infotype").value;
	if(tp=="1"){
	
	document.searchFrom1.action="${ctx}/personSearch.do?method=showAll";
	
	}else{
		document.searchFrom1.action="${ctx}/companySearch.do?method=showAll";
	}
	document.searchFrom1.submit();
}
function search2(){
	document.searchFrom2.action="${ctx}/companySearch.do?method=showAll";
	document.searchFrom2.submit();
}

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
</script>


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
	<title>北京市残疾人联合会</title>

</head>
<body>
	<div id="container">
		<!--<div id="header">

			<iframe src="http://211.99.136.80/headindex.html" id="iframe_head"
				frameborder="0" scrolling="no" title="头部脚本"></iframe>

		</div>
		--><div id="main">


			<% String pid=(String)request.getSession().getAttribute(IConstants.PERSON_USER_ID);
			   String cid=(String)request.getSession().getAttribute(IConstants.COMP_USER_ID );
			   String reg=(String)request.getSession().getAttribute("reg"); 
			    List publishjob=(List)request.getSession().getAttribute("publishjob");
			   
			   %>
           
			<div id="content">
				<h2>
					求职招聘
				</h2>

				<div id="login_zc1">

					<form action="" name="form3" method="post">
						<div id="form_div">
							<%if(pid==null&&cid==null){ %>
							<div class="basic_message fn-clear">
								<div class="user f_l"
									style="height: auto; background-color: #ededed; width: 630px">
									<p style="padding: 0 0 10px 20px;">
										<input name="radio" type="radio" value="1" checked="checked" />
										个人用户&nbsp;&nbsp;
										<input name="radio" type="radio" value="2" />
										企业用户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><html:errors property="noUser" /></font>
									
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
							<%}else if(pid==null&&cid!=null){%>
							<div class="basic_message">
								<div class="user">
									<p class="f_l">
										<span><bean:message key="username" /> ：<%=cid %> </span>
										
									</p>
									
									 <input type="hidden" id="qyshzt" value="aaa" />
									<a class="edit f_r"
										href="${ctx}/companyLogin.do?method=loginOut">安全退出</a>
									<a class="edit f_r"
										href="${ctx}/pages/company/modifyPassword.jsp" class="b">修改密码</a>|

									<a class="edit f_r"
										href="${ctx}/companyRegist2.do?method=companyShowInfo">企业信息</a>
								</div>
							</div>
							<% }else{ %>
							<div class="basic_message">
								<div class="user">
									<p class="f_l">
										<span><bean:message key="username" /> ：<%=pid %> </span>
										
									</p>
                                   <% if(reg!=null&&reg!=""){%>
									 <input type="hidden" id="grshzt" value="<%=reg%>" /><%} %>
									<a class="edit f_r"
										href="${ctx}/companyLogin.do?method=loginOut">安全退出</a>
									<a class="edit f_r"
										href="${ctx}/pages/personal/modifyPassword.jsp" class="b">修改密码</a>
									<a class="edit f_r"
										href="${ctx}/personRegist3.do?method=personRegist3">个人简历</a>
								</div>
							</div>


							<% } %>

						</div>
					</form>
				</div>


				<div style="clear: both;"></div>

				<div class="formdiv">
					<div
						style="background: #fff; padding: 10px 20px; border: #ddd 1px solid; border-left: #900 2px solid;">

						<form name="searchFrom1" action="#" method="post">

							<P class="p_text">
								<LABEL for="textfield3" class="f_l">
									<strong>职位搜索：</strong>
								</LABEL>
								<select name="infotype" id="infotype" class="f_l mgr1">
									<option value="1">
										企业招聘信息
									</option>
									<option value="2">
										个人求职信息
									</option>
								</select>
								<INPUT name="textfield3" title="请输入要查询的职位" id="textfield3"
									type="text" class="f_l">
								<IMG width="21" height="19" onclick="search1()" alt="搜索"
									src="/clrcw/img/index_39.jpg" class="f_l mgr1"
									style="cursor: pointer;">

								<spam>
								<!-- >A
									href="${ctx}/companyShow.do?method=showAll">&nbsp;&nbsp;更多招聘信息&gt;&gt;</A-->
								</spam>
							</P>
               
						</form>   
					</div>
					<table id="form_1" class="finktable" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<th rowspan="2" class="h2th">
								企业招聘信息
							</th>
							<th valign="top">
								<TABLE class="finktable" width="100%" border="0" cellspacing="0"
									cellpadding="0">
									<TBODY>
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


										<logic:present name="publishjobinfo">
											<logic:iterate name="publishjobinfo" id="JobInfo"
												type="model.PublishJobInfo">

												<tr>
												<td width="150px" height="23" align="center">
													
													<%if(pid!=null){ %>
														<a style="color: #000000; font-size: 12px;"
															href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${JobInfo.pkComp.comp.id}&loginId=${JobInfo.pkComp.comp.userId}"
															class="p" > <bean:write
																property="pkComp.comp.compName" name="JobInfo" /> </a>
													<%}else{ %>
                                              	<a href="#" class="p" onClick="nologinp()" align="center"
																	style="color: #000000; font-size: 12px;"> <bean:write
																		property="pkComp.comp.compName" name="JobInfo" /> </a>
															<%}%>
															</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<p>
															<bean:write property="job.jobName" name="JobInfo" />
														</p>
													</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="jobAmount" name="JobInfo" />
													</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="education.educateName"
															name="JobInfo" />
													</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="address" name="JobInfo" />
													</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="publishTime" name="JobInfo" />
													</td>

												</tr>
											</logic:iterate>
										</logic:present>
										<logic:notPresent name="publishjobinfo">
											<tr>
												<td colspan="3">
													<p class="font5">
														没有企业招聘信息!
													</p>
												</td>
											</tr>
										</logic:notPresent>
									</TBODY>
								</table>


							</th>

						</tr>

					</table>

					<table id="form_1" class="finktable">
						<tr>
							<th rowspan="2" class="h2th">
								个人求职信息
							</th>

							<th valign="top">

								<table class="finktable">
									<TR>
										<TH
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
											姓名
										</TH>
										<TH
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
											期望从事行业
										</TH>
										<TH
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
											应聘职位
										</TH>
										<TH
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
											学历
										</TH>
										<TH
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
											求职地区
										</TH>
										<TH
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 14px; font-weight: bold;">
											登记时间
										</TH>
									</TR>

									<logic:present name="applyJobInfo">
										<logic:notEmpty name="applyJobInfo">

											<logic:iterate name="applyJobInfo" id="jobInfo"
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
														<td width="150px" height="23" align="center" style="color: #000000; font-size: 12px;">
													
															<bean:write
																		property="jobCode.jobName" name="jobInfo" />
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
										</logic:notEmpty>
										<logic:empty name="applyJobInfo">
											<tr>
												<th colspan="3">
													<p class="font5">
														没有个人求职信息！
													</p>
												</th>
											</tr>
										</logic:empty>
									</logic:present>
									<logic:notPresent name="applyJobInfo">
										<tr>
											<th colspan="3">
												<p class="font5">
													没有个人求职信息！
												</p>
											</th>
										</tr>
									</logic:notPresent>




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
	<%List publish=(List)request.getSession().getAttribute("publishjob");
	  String size="";
	  if(publish!=null)
	  size="1";
	 %>
	<script type="text/javascript">
if(document.getElementById("grshzt")){
alert(document.getElementById("grshzt").value);
}
else if(document.getElementById("qyshzt")){
if('<%=size%>'!=''){
window.open("${ctx}/pages/company/companyloginmessage.jsp","_blank");}

}
</script>




</body>

</html>
