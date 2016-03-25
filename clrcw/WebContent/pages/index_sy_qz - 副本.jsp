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

<link rel="stylesheet" type="text/css" href="/clrcw/styles/jyjy.css" />
<link rel="stylesheet" type="text/css" id="ABTStyle" href="/clrcw/styles/skin.css" />

<title>北京市残疾人联合会</title>
</head>
<body>



<% String pid=(String)request.getSession().getAttribute(IConstants.PERSON_USER_ID);
String cid=(String)request.getSession().getAttribute(IConstants.COMP_USER_ID ); %>


<div >
        
		
											<logic:present name="applyJobInfo">
												<logic:notEmpty name="applyJobInfo">

													<logic:iterate name="applyJobInfo" id="jobInfo"
														type="model.ApplyJobInfo">
<span><logic:present name="compUserId">
																<a
																	href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
																	class="p"> <bean:write property="resumeCode.name"
																	name="jobInfo" /></a>
															</logic:present> <logic:notPresent name="compUserId">
																<a href="#" class="p" onClick="nologinc()"> <bean:write
																	property="resumeCode.name" name="jobInfo" /></a>
															</logic:notPresent></span><span><bean:write
																property="jobCode.jobName" name="jobInfo" /></span><span><bean:write
																property="resumeCode.educate.educateName" name="jobInfo" /></span>
      </logic:iterate>
												</logic:notEmpty>
												<logic:empty name="applyJobInfo">
													<span>没有个人求职信息！ </span>
												</logic:empty>
											</logic:present>
											<logic:notPresent name="applyJobInfo">
												 <span>没有个人求职信息！ </span>										</logic:notPresent>
        

        </div>
   
</body>

</html:html>
