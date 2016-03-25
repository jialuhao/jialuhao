<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../public/common/taglibs.jsp" %>
<%@ page import="common.constants.IConstants"%>

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


<link rel="stylesheet" type="text/css" href="/clrcw/styles/public1.css" />

<link rel="stylesheet" type="text/css" href="/clrcw/styles/jyjy1.css" />

<title>北京市残疾人联合会</title>
<style type="text/css">
.qzzptd {
	color:#666;
	text-align:left;
	font-size:12px;
}
.qzzpth {
	border-bottom:1px solid #ccc;
	color:#f43500;
	text-align:center;
	font-size:12px;
	font-weight:bold;
}
.qzzptd a{
	color:#666;
	text-align:left;
	display:inline;
	line-height:22px;
	text-decoration:none;
	}
#jyjybox ol  {
	display:block;
	width:210px;
	margin:0;
	padding:0;
}

#jyjybox  ol li {
	background:none;
	padding:0;
	height:21px;
	overflow:hidden;
	margin:0;
}


 #jyjybox ol li a {
	background:none;
	font-size:12px;
	font-weight:normal;
	color:#666666;
	text-align:left;
	display:inline;
	line-height:22px;
	text-decoration:none;
}


#jyjybox ol li a:hover {
	color:#BE0403;
}

</style>
</head>
<body>



<% String pid=(String)request.getSession().getAttribute(IConstants.PERSON_USER_ID);
String cid=(String)request.getSession().getAttribute(IConstants.COMP_USER_ID ); %>



 
    <div id="zpqzxxbox">
      <div class="zpxxcss zpxx_add">
        <h3 align="left"><a href="${ctx}/companyShow.do?method=showAll" title="招聘信息"  target="_blank">招聘信息</a></h3>
       <span class="zpinto"> <a href="${ctx}/companyShow.do?method=showAll" title="我要招聘"  target="_blank">我要招聘</a></span>
        <ul>
		<li class="qzzpth"><span  class="job">招聘岗位</span><span  class="job">文化程度</span><span  class="job">工作地点</span><span  class="job">残疾类别</span><span  class="job">发布时间</span></li>
		
			<logic:present name="publishjobinfo">
												<logic:iterate name="publishjobinfo" id="JobInfo"
													type="model.PublishJobInfo">
          <li><span class="job"><a
															href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${JobInfo.pkComp.comp.id}&loginId=${JobInfo.pkComp.comp.userId}"
															 target="_blank" title="<bean:write property="job.jobName"
															name="JobInfo" />"><bean:write property="job.jobName"
															name="JobInfo" /></a></span>
															<span class="job"><bean:write
															property="education.educateName" name="JobInfo" /></span>
															<span class="job"><bean:write
															property="address" name="JobInfo" /></span>
															<span class="job"> <bean:write
															property="post.postName" name="JobInfo" /></span><span class="job"> <bean:write
															property="publishTime" name="JobInfo" /></span>
															</li>
															
															</logic:iterate>
											</logic:present>
											<logic:notPresent name="publishjobinfo">
												<li> <span >没有企业招聘信息!</span></li>
											</logic:notPresent>
      
    
	    </ul>
        <span class="zpmore"><!-- >a href="${ctx}/companyShow.do?method=showAll" title="更多招聘信息"  target="_blank">更多</a--></span> </div>
      <div class="zpxxcss zpxx_add">
        <h3 align="left"><a href="${ctx}/personShow.do?method=showAll" title="求职信息"  target="_blank">求职信息</a></h3>
        <span class="zpinto"><a href="${ctx}/personShow.do?method=showAll" title="我要求职"  target="_blank">我要求职</a></span>
   
        
        <ul>
		<li class="qzzpth"><span class="job">求职岗位</span><span  class="job">文化程度</span><span class="job">求职地区</span><span  class="job">残疾类别</span><span  class="job">登记时间</span></li>
											<logic:present name="applyJobInfo">
												<logic:notEmpty name="applyJobInfo">

													<logic:iterate name="applyJobInfo" id="jobInfo"
														type="model.ApplyJobInfo">
          <li><span  class="job"><logic:present name="compUserId">
																<a
																	href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
																	class="p" title="<bean:write
																property="jobCode.jobName" name="jobInfo" />"> <bean:write
																property="jobCode.jobName" name="jobInfo" /></a>
															</logic:present> <logic:notPresent name="compUserId">
																<a href="#" class="p" onClick="nologinc()" title="<bean:write
																property="jobCode.jobName" name="jobInfo" />"> <bean:write
																property="jobCode.jobName" name="jobInfo" /></a>
															</logic:notPresent></span>
															<span class="job" ><bean:write
																property="resumeCode.educate.educateName" name="jobInfo" /></span>
															<span  class="job"><bean:write
																	property="resumeCode.qzdq" name="jobInfo" /></span><span class="job"><bean:write
																	property="postCode.postName" name="jobInfo" /></span><span class="job"><bean:write
																	property="createTime" name="jobInfo" /></span></li>
      </logic:iterate>
												</logic:notEmpty>
												<logic:empty name="applyJobInfo">
													 <li><span>没有个人求职信息！ </span></li>
												</logic:empty>
											</logic:present>
											<logic:notPresent name="applyJobInfo">
												 <li><span>没有个人求职信息！ </span></li>											</logic:notPresent>
        
        </ul>
        <span class="zpmore"><a href="${ctx}/personShow.do?method=showAll" title="更多求职信息"  target="_blank">更多</a></span> </div>
  
   </div>

</body>

</html:html>
