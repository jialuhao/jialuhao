<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../public/common/taglibs.jsp"%>
<%@ page import="common.constants.IConstants"%>
<script type="text/javascript" src="/clrcw/scripts/jquery-1.7.1.js"></script>
<script language="JavaScript" type="text/JavaScript">
	function search1() {
		document.searchFrom1.action = "${ctx}/personSearch.do?method=showAll";
		document.searchFrom1.submit();
	}
	function search2() {
		document.searchFrom2.action = "${ctx}/companySearch.do?method=showAll";
		document.searchFrom2.submit();
	}

	function select() {
		var temp = document.getElementsByName("radio");
		if (temp[0].checked) {
			document.all.form3.action = "${ctx}/indexLogin.do?method=indexLogin";
			document.all.form3.submit();
		} else {
			document.all.form3.action = "${ctx}/indextCLogin.do?method=indextCLogin";
			document.all.form3.submit();
		}
	}

	function nologinp() {
		alert("请登录个人用户！");
	}
	function nologinc() {
		alert("请登录企业用户！");
	}
		$(document).ready(function(){ 
		$(".aaa").each(function(i){
		
		var aa=$(this).html();
		
$(this).html(aa.substring(0,2));});
}); 

</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />




	<title>北京市残疾人联合会</title>




</head>
<body>


	<style type="text/css">
.qzzpth {
	border-bottom: 1px solid #ccc;
	color: #f43500;
	text-align: center;
	font-size: 12px;
	font-weight: bold;
}

.qzzptd {
	color: #666;
	text-align: center;
	font-size: 12px;
}

.qzzptd a {
	color: #666;
	text-align: left;
	display: inline;
	line-height: 22px;
	text-decoration: none;
}

#jyjybox ol {
	display: block;
	width: 210px;
	margin: 0;
	padding: 0;
}

#jyjybox  ol li {
	background: none;
	padding: 0;
	height: 21px;
	overflow: hidden;
	margin: 0;
}

#jyjybox ol li a {
	background: none;
	font-size: 12px;
	font-weight: normal;
	color: #666666;
	text-align: left;
	display: inline;
	line-height: 22px;
	text-decoration: none;
}

#jyjybox ol li a:hover {
	color: #BE0403;
}
</style>

	<%
		String pid = (String) request.getSession().getAttribute(
					IConstants.PERSON_USER_ID);
			String cid = (String) request.getSession().getAttribute(
					IConstants.COMP_USER_ID);
	%>
	<div id="jyjybox">


		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="33%" align="center" class="qzzpth">
					招聘岗位
				</td>
				<td width="33%" align="center" class="qzzpth">
					工作地点
				</td>
				<td width="34%" align="center" class="qzzpth">
					发布时间
				</td>
			</tr>
			<logic:present name="publishjobinfo">
				<logic:iterate name="publishjobinfo" id="JobInfo"
					type="model.PublishJobInfo">
					<tbody>
					<tr>
						<td class="qzzptd">
							<a
								href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${JobInfo.pkComp.comp.id}&loginId=${JobInfo.pkComp.comp.userId}"
								target="_blank"
								title="<bean:write property="job.jobName" name="JobInfo" />">
									<bean:write property="jobDesc" name="JobInfo" />
							</a>
						</td>
						<td class="qzzptd aaa"  title="<bean:write property="address" name="JobInfo" />">
							<bean:write property="grading" name="JobInfo" />
						</td>
						<td class="qzzptd">
							<bean:write property="publishTime" name="JobInfo" />
						</td>
					</tr>
					</tbody>
				</logic:iterate>
			</logic:present>

		</table>


	</div>
</body>

</html:html>
