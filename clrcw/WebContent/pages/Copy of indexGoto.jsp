<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../public/common/taglibs.jsp" %>
<%@ page import="common.constants.IConstants"%>
<%@ page import="java.util.*" %>
<%@ page import="model.PersonResume" %>
<%@ page import="model.PersonResumeB" %>
<%@ page import="model.ApplyJobInfo" %>

<script language="JavaScript" type="text/JavaScript">
function search1(){
	document.searchFrom1.action="${ctx}/personSearch.do?method=showAll";
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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/css/index4.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/mainframe.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/modelist.css" />


<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
<title>北京市残疾人联合会</title>

</head>
<body>
<div id="container">
	<div id="header">
	
    <iframe src="http://211.99.136.80/headindex.html" id="iframe_head" frameborder="0" scrolling="no" title="头部脚本"></iframe>
    
  </div>
  <div id="main">


<% String pid=(String)request.getSession().getAttribute(IConstants.PERSON_USER_ID);
String cid=(String)request.getSession().getAttribute(IConstants.COMP_USER_ID ); %>


 
  <div id="content">
    	 	<h2>求职招聘</h2>
 
      <div id="login_zc1">
      	<div id="form_div">
		 <form action="" name="form3" method="POST">
		      <table cellpadding="0" cellspacing="0" >
  <tr   >
    <td  
					 width="40%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr align="center">
					
						<% if(pid==null&&cid!=null){ %>

						<td align="center">
						
						<p>
						  <input name="radio" type="radio" class="input7"
							id="radio" value="radio"> 
						  <strong>个人用户</strong>
						  </p>
						  <p>
						    <input name="radio" type="radio"
							class="input7" id="radio2" value="radio" checked> 
						    <strong>企业用户</strong></p>
					   </td>

						<% }else {%>
						
						<td align="center"><p><input name="radio" type="radio" class="input7"
							id="radio" value="radio" checked> <strong>个人用户</strong>
						  
						  <p>
						    <input name="radio" type="radio"
							class="input7" id="radio2" value="radio"> 
						    <strong>企业用户</strong></p></td>
						<% } %>
					</tr>
				</table>
			</td>
    <td width="550" valign="top">
	
	<table width="552" border="1">
	<tr>
						<!-- 设置错误信息 -->
						<!--  显示权限控制信息-->
						<td width="100"  rowspan="3" align="center"><font color="red">
						  <html:errors
							property="noUser" /> <html:errors property="loginfirst" /> <logic:present
							name="reLogin">
							<bean:write name="reLogin" />
				  </logic:present> </font></td>
				</tr>
				
				<% 
					if(pid==null&&cid==null){ %>
				
  <tr>
   <td width="79" height="26" align="right"><label for="userId">用户名：</label></td>
				  <td width="187" align="left"><input type="text" name="userId" id="userId" title="请输入用户名" style="width:150px; height:23px;"/></td>
    <td width="67" rowspan="2"><button class="input4" onClick="select()">登录</button></td>
	<td width="153" rowspan="2"><p><a
							href="${ctx}/pages/personal/personRegist1.jsp" class="d">个人注册</a><br />
	</p>
	<br />
	  <p>	    <a href="${ctx}/pages/company/companyRegist1.jsp" class="d">企业注册</a></p></td>
  </tr>
  <tr>
    <td height="25" align="right"><label for="password">密　码：</label></td>
						<td align="left" width="187"><input type="password" name="password"
							id="password" style="width:150px; height:23px;"  tite="请输入密码"/></td>
    </tr>
	
	
	<% }else if(pid==null&&cid!=null){%>
	
	 <tr>
  <td height="35" align="center" colspan="2"><bean:message
							key="username" />：<%=cid %></td>
    <td width="67" rowspan="2"><a
							href="${ctx}/companyRegist2.do?method=companyShowInfo" class="b">企业信息</a></td>
	<td width="153" rowspan="2"><p>|<a href="${ctx}/companyLogin.do?method=loginOut" class="d">安全退出</a>
	</p>
	</td>
  </tr>
  <tr>
    <td height="25" align="right"></td>
						<td align="left"> </td>
    </tr>
	
	
		<% }else{ %>
		
		
	 <tr>
  <td height="35" align="center" colspan="2"><bean:message
							key="username" />：<%=pid %></td>
    <td width="67" rowspan="2"><a
							href="${ctx}/personRegist3.do?method=personRegist3" class="b">个人简历</a></td>
	<td width="153" rowspan="2"><p>|<a href="${ctx}/logout.do?method=logout">安全退出</a>
	</p>
	</td>
  </tr>
  <tr>
    <td height="25" align="right"></td>
						<td align="left"> </td>
    </tr>
			<% } %>
		
		
</table>
</td>
  </tr>
</table>
		

		</form>

		
          </div>
         
       </div>

      <div class="formdiv">
		<form name="searchFrom1" action="#" method="post"><p class="p_text"><label for="textfield3">职位搜索：</label><input name="textfield3" type="text"						id="textfield3" title="请输入要查询的职位"><img
											src="<%=request.getContextPath()%>/images/index_39.jpg"
											width="21" height="19" alt="搜索" onClick="search1()">
		  <!-- >a href="${ctx}/companyShow.do?method=showAll">&nbsp; &nbsp;更多招聘信息>></a--></p>
		</form>
        <table id="form_1" class="finktable"  >
  <tr>
    <th rowspan="2" class="h2th">企业招聘信息</th>
	<th valign="top" >
	   <table class="finktable" ><tr >
	   <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;">企业名称                               </th>
    <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;">  招聘职位                 </th>
    <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;">工作地点</th>
	   
	   </tr>
	   
	<logic:present name="publishjobinfo">
												<logic:iterate name="publishjobinfo" id="JobInfo"
													type="model.PublishJobInfo">

													<tr>
														<td width="40%" height="23" align="left"
															><a style="color:#000000;font-size:12px;" 
															href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${JobInfo.pkComp.comp.id}&loginId=${JobInfo.pkComp.comp.userId}"
															class="p" target="_blank"> <bean:write
															property="pkComp.comp.compName" name="JobInfo" /></a></td>

														<td width="40%" align="left" style="color:#000000;font-size:12px;" ><p><bean:write property="job.jobName"
															name="JobInfo" /></p></td>

														<td width="20%" align="left" style="color:#000000;font-size:12px;"  ><bean:write
															property="address" name="JobInfo" /></td>
													</tr>
												</logic:iterate>
											</logic:present>
											<logic:notPresent name="publishjobinfo">
												<tr><td colspan="3" ><p class="font5">没有企业招聘信息!</p></td></tr>
											</logic:notPresent>  
	   
	   </table>
	
	
	</th>
    
  </tr>
  
</table>

       <form name="searchFrom2" action="#" method="post"> <p class="p_text"><label for="textfield4">职位搜索：</label><input name="textfield4" type="text" class="input2" id="textfield4" title="请输入要查询的职位"> <img
											src="<%=request.getContextPath()%>/images/index_39.jpg"
											width="21" height="19" alt="搜索" onClick="search2()">&nbsp; &nbsp;<spam><a href="${ctx}/personShow.do?method=showAll">更多求职信息>></a></p>
	   </form>				
	 <table id="form_1" class="finktable" >
  <tr>
    <th rowspan="2" class="h2th">个人求职信息</th>
	
	<th valign="top">
	
	 <table  class="finktable" >
	 <tr> <th style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;">应聘职位                              </th>
    <th style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;">求职地区                 </th>
    <th style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;">残疾类别</th></tr>
	
	<logic:present name="applyJobInfo">
												<logic:notEmpty name="applyJobInfo">

													<logic:iterate name="applyJobInfo" id="jobInfo"
														type="model.ApplyJobInfo">

														<tr>
															<td width="40%" height="23" align="left"
																><logic:present name="compUserId">
																<a
																	href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
																	class="p" align="left" style="color:#000000;font-size:12px;" > <bean:write
																property="jobCode.jobName" name="jobInfo" /></a>
															</logic:present> <logic:notPresent name="compUserId">
																<a href="#" class="p" onClick="nologinc()" align="left" style="color:#000000;font-size:12px;" > <bean:write
																property="jobCode.jobName" name="jobInfo" /></a>
															</logic:notPresent></td>

															<td width="40%" align="left" style="color:#000000;font-size:12px;"  ><bean:write
																property="resumeCode.qzdq" name="jobInfo" /></td>

															<td width="20%" align="left" style="color:#000000;font-size:12px;" > <bean:write
																	property="postCode.postName" name="jobInfo" />
				   
    </td>
														</tr>
													</logic:iterate>
												</logic:notEmpty>
												<logic:empty name="applyJobInfo">
													<tr><th colspan="3" ><p class="font5">没有个人求职信息！</p></th></tr>
												</logic:empty>
											</logic:present>
											<logic:notPresent name="applyJobInfo">
												<tr><th colspan="3" ><p class="font5">没有个人求职信息！</p> </th></tr>
											</logic:notPresent>
	
	
	
	
	</table>
	</th>
   
  </tr>
  
</table>


        </div>
    </div>
  
</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
 </div>
 




</body>

</html:html>
