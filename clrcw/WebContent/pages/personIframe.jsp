<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../public/common/taglibs.jsp"%>
<SCRIPT language="javascript"
	src="<%=request.getContextPath()%>/public/js/calendar.js"></SCRIPT>
<script language="JavaScript" type="text/JavaScript">

function change2(s_id){
    document.form2.comPage.value=s_id;
    document.form2.action="${ctx}/index.do?method=perOtherPage";
	document.form2.submit();
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>iframe</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">
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
 <div id="header">
<iframe src="http://211.99.136.80/headindex.html" id="iframe_head" frameborder="0" scrolling="no" title="头部脚本"></iframe>
  </div>
  <div id="main">
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
							class="font4">姓 名</td>
						<td width="40%" align="center"
							background="<%=request.getContextPath()%>/images/index_48.jpg"><span
							class="font4">应聘职位</span></td>
						<td width="20%" align="center"
							background="<%=request.getContextPath()%>/images/index_48.jpg"
							class="font4">学 历</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td><%--显示个人求职信息--%>
				<form action="" name="form2" method="POST">
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
					bgcolor="6D96C7">


					<logic:present name="applyJobInfo">

						<logic:iterate name="applyJobInfo" id="jobInfo"
							type="model.ApplyJobInfo">

							<tr>
								<td width="40%" height="23" align="center" bgcolor="FEF9F9">
								<html:link
									href="${ctx}/showPersonResume.do?method=showPersonResume"
									paramId="user" paramName="jobInfo"
									paramProperty="resumeCode.user.id" styleClass="d"
									target="_blank">
									<bean:write property="resumeCode.name" name="jobInfo" />
								</html:link></td>

								<td width="40%" align="center" bgcolor="FEF9F9" class="font5">
								<bean:write property="jobCode.jobName" name="jobInfo" /></td>

								<td width="20%" align="center" bgcolor="FEF9F9" class="font5">
								<bean:write property="resumeCode.educate.educateName"
									name="jobInfo" /></td>
							</tr>
						</logic:iterate>
						<html:hidden property="comPage" value="" />
						<%
							int comPage = ((Integer) request.getAttribute("comPage"))
									.intValue();
							int tpn = ((Integer) session.getAttribute("tpn")).intValue();
							if (comPage == 0) {
						%>
						<tr>
							<td height="23" colspan="3" align="right" bgcolor="FEF9F9">
							<a href="#" class="list" onClick="change2(<%=comPage%>+1)">下一页&nbsp;</a></td>
						</tr>
						<%
							} else if (comPage == tpn) {
						%>
						<tr>
							<td height="23" colspan="3" align="right" bgcolor="FEF9F9">
							<a href="#" class="list" onClick="change2(<%=comPage%>-1)">上一页</a>
						</tr>
						<%
							} else {
						%>
						<tr>
							<td height="23" colspan="3" align="right" bgcolor="FEF9F9">
							<a href="#" class="list" onClick="change2(<%=comPage%>-1)">上一页</a>
							<a href="#" class="list" onClick="change2(<%=comPage%>+1)">下一页&nbsp;</a></td>
						</tr>
						<%
							}
						%>

					</logic:present>
					<logic:notPresent name="applyJobInfo">
                          			没有个人求职信息！
                          		</logic:notPresent>


				</table>
				</form>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>

</html:html>