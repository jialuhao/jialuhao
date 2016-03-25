<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../public/common/taglibs.jsp"%>
<%@ page import="common.constants.IConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PersonResume"%>
<%@ page import="model.PersonResumeB"%>
<%@ page import="model.ApplyJobInfo"%>

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
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


	<title>北京市残疾人联合会</title>
</head>
<body>


	<%
		String pid = (String) request.getSession().getAttribute(
					IConstants.PERSON_USER_ID);
			String cid = (String) request.getSession().getAttribute(
					IConstants.COMP_USER_ID);
	%>

	<div id="jyjybox">


		<table class="qz_txt">
			<tr>
				<th>
					求职岗位
				</th>
				<th>
					求职地区
				</th>
				<th>
					残疾类型
				</th>
			</tr>
			<logic:present name="applyJobInfo">
				<logic:notEmpty name="applyJobInfo">
					<logic:iterate name="applyJobInfo" id="jobInfo"
						type="model.ApplyJobInfo">


						<tr>
							<td class="qzzptd">
								<logic:present name="compUserId">
									<a
										href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
										title="<bean:write
																property="jobCode.jobName" name="jobInfo" />"
										target="_blank"><bean:write property="salary"
											name="jobInfo" />
									</a>
								</logic:present>
								<logic:notPresent name="compUserId">
									<a
										href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
										title="<bean:write
																property="jobCode.jobName" name="jobInfo" />"
										target="_blank"><bean:write property="salary"
											name="jobInfo" />
									</a>

								</logic:notPresent>
							</td>
							<td class="qzzptd" title="<bean:write property="resumeCode.qzdq" name="jobInfo" />">
								<bean:write property="workYear" name="jobInfo" />
							</td>
							<td class="qzzptd">
								<bean:write property="postCode.postName" name="jobInfo" />
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
			</logic:present>




		</table>



	</div>

</body>

</html:html>
