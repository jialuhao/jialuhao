<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../public/common/taglibs.jsp"%>
<%@ page import="common.constants.IConstants"%>
<%@ page import="model.PublishJobInfo"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
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
			<%List list=(List)request.getAttribute("publishjobinfo");
			for(int i=0;i<list.size();i++){
			PublishJobInfo publishjob=(PublishJobInfo)list.get(i);
			String names = "";
			String jobname=publishjob.getJob().getJobName();
			
			if (jobname.length() > 4) {
											names = jobname.substring(0,
													4)
													;
										}else{
										names = jobname;
										}
			String adr="";
			String adress=publishjob.getAddress();
			if (adress.length() > 3) {
											adr= adress.substring(0,
													3)
													;
										}else{
										adr = adress;
										}
			 %>
			
					<tr>
						<td class="qzzptd">
							<a
								href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${JobInfo.pkComp.comp.id}&loginId=${JobInfo.pkComp.comp.userId}"
								target="_blank"
								title="<%=jobname%>">
									<%=names%>
							</a>
						</td>
						<td class="qzzptd" title="<%=adress %>">
						<%=adr%>	
						</td>
						<td class="qzzptd">
						<%=publishjob.getPublishTime()%>	
						</td>
					</tr>
			<%} %>

		</table>


	</div>
</body>

</html:html>
