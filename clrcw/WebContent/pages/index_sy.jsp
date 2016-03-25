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


<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/mainframe.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/index.css" />
<link rel="stylesheet" type="text/css" id="abtstyle" href="/clrcw/styles/skin.css" />

<title>北京市残疾人联合会</title>
</head>
<body>



<% String pid=(String)request.getSession().getAttribute(IConstants.PERSON_USER_ID);
String cid=(String)request.getSession().getAttribute(IConstants.COMP_USER_ID ); %>


<div id="container">
  
  <div id="main">
     <div id="zpqzxxbox">
      <div class="zpxxcss">
        <h3><a href="${ctx}/companyShow.do?method=showAll" title="招聘信息">招聘信息</a></h3>
        <a href="${ctx}/companyShow.do?method=showAll" title="我要招聘"><span class="zpinto">我要招聘</span></a>
        <ul>
		
			<logic:present name="publishjobinfo">
												<logic:iterate name="publishjobinfo" id="JobInfo"
													type="model.PublishJobInfo">
          <li><span><a
															href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${JobInfo.pkComp.comp.id}&loginId=${JobInfo.pkComp.comp.userId}"
															class="p" target="_blank"> <bean:write
															property="pkComp.comp.compName" name="JobInfo" /></a></span>
															<span class="job"><bean:write property="job.jobName"
															name="JobInfo" /></span><span><bean:write
															property="pkComp.type.compTypeName" name="JobInfo" /></span></li>
															
															</logic:iterate>
											</logic:present>
											<logic:notPresent name="publishjobinfo">
												<li> <span >没有企业招聘信息!</span></li>
											</logic:notPresent>
      
        </ul>
        <span class="zpmore"><!-- >a href="${ctx}/companyShow.do?method=showAll" title="更多招聘信息">更多</a--></span> </div>
      <div class="zpxxcss">
        <h3><a href="${ctx}/personShow.do?method=showAll" title="求职信息">求职信息</a></h3>
        <span class="zpinto"><a href="${ctx}/personShow.do?method=showAll" title="我要求职">我要求职</a></span>
        <ul>
		
											<logic:present name="applyJobInfo">
												<logic:notEmpty name="applyJobInfo">

													<logic:iterate name="applyJobInfo" id="jobInfo"
														type="model.ApplyJobInfo">
          <li><span><logic:present name="compUserId">
																<a
																	href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
																	class="p"> <bean:write property="resumeCode.name"
																	name="jobInfo" /></a>
															</logic:present> <logic:notPresent name="compUserId">
																<a href="#" class="p" onClick="nologinc()"> <bean:write
																	property="resumeCode.name" name="jobInfo" /></a>
															</logic:notPresent></span><span><bean:write
																property="jobCode.jobName" name="jobInfo" /></span><span><bean:write
																property="resumeCode.educate.educateName" name="jobInfo" /></span></li>
      </logic:iterate>
												</logic:notEmpty>
												<logic:empty name="applyJobInfo">
													 <li><span>没有个人求职信息！ </span></li>
												</logic:empty>
											</logic:present>
											<logic:notPresent name="applyJobInfo">
												 <li><span>没有个人求职信息！ </span></li>											</logic:notPresent>
        
        </ul>
        <span class="zpmore"><a href="${ctx}/personShow.do?method=showAll" title="更多求职信息">更多</a></span> </div>
    </div>
  </div>
    </div>
   
   
 
</div>



 <div id="jyjybox">
	
	<ul class="right">
		<li class="block" id="o3">
			<a href="#" title="求职" id="a5">求 &nbsp;&nbsp;职</a>
			<ol>
				<li><a href="#" title="肢体">[11肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li class="more"><a href="#">更多</a></li>
			</ol>
		</li>
		<li>
			<a href="#" title="职业培训" id="a6">招 &nbsp;&nbsp;聘</a>
			<ol>
				<li><a href="#" title="肢体">[22肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li><a href="#" title="肢体">[肢体][朝阳区][不限] 珍珠产品制作元</a></li>
				<li class="more"><a href="#">更多</a></li>
			</ol>
		</li>
	</ul>
</div>


</body>

</html:html>
