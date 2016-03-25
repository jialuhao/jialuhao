<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>简历管理</title>

	<script language="JavaScript" type="text/JavaScript">
function del(id){
    var b = confirm("确实要删除吗！");
    if (b) {
        document.form1.keyId.value = id;
        document.form1.action = "${ctx}/companyResume.do?method=delOneResume";
        document.form1.submit();
    }
}
function change(s_id){
    document.form1.pageIndex.value = s_id;
    document.form1.action = "${ctx}/companyResume.do?method=comOtherPage";
    document.form1.submit();
}
</script>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		<div id="main">

			<div id="content">
				<h2>
					企业[${compUserId}]招聘 &nbsp;&nbsp;
					<a href="${ctx}/companyLogin.do?method=loginOut"
						style="color: #BD0403;">[退出]</a>
				</h2>
				<DIV class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li>
							<a href="${ctx}/companyRegist2.do?method=companyShowInfo">&equiv;&nbsp;企业基本情况</a>
						</li>
						<li>
							<a href="${ctx}/companyPubJob.do?method=showPubJob">&equiv;&nbsp;企业招聘信息
							</a>
						</li>
						<li>
							<a href="${ctx}/companyPubJob.do?method=showPubJob"
								>&equiv;&nbsp;企业招聘信息 </a>
						</li>
						
						<li >
							<a href="${ctx}/companySPerson.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li  class="liH1">
							<a href="${ctx}/companyQueryNotContact.do?method=showCompResume" style="color: #BD0403;">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li>
							<a href="${ctx}/companyAbility.do?method=showCompAbility"
								>&equiv;&nbsp;人才库管理</a>
						</li>

					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form action="" name="form1" method="POST">
						<input type="hidden" name="keyId">
						<table class="finktable" summary="企业招聘信息">

							<tr>
								<td height="40" colspan="6" style="padding: 0; border: 0;">
									<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
										<TBODY>
											<tr>
												<td width="25%" class="font3">
													所有收到的简历如下:
												</td>
												<td width="25%" class="font5" align="right">
													查询:
												</td>
												<td width="25%">
													&nbsp;&nbsp;&nbsp;&nbsp;
													<a
														href="${ctx}/companyQueryNotContact.do?method=showCompResume"
														class="d">已收简历</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a
														href="${ctx}/companyQueryContact.do?method=showCompResume"
														class="d">已读简历</a>
												</td>
											</tr>
										</TBODY>
									</table>

								</td>
							</tr>
							<TR>
								<TD width="123" align="center"
									style="background: #900; color: #fff; font-weight: bold;">
									姓 名
								</TD>
								<TD width="123" align="center"
									style="background: #900; color: #fff; font-weight: bold;">
									欲求职位
								</TD>
								<TD width="123" align="center"
									style="background: #900; color: #fff; font-weight: bold;">
									学 历
								</TD>
								<TD width="124" align="center"
									style="background: #900; color: #fff; font-weight: bold;">
									所学专业
								</TD>
								<TD width="124" align="center"
									style="background: #900; color: #fff; font-weight: bold;">
									工作年限
								</TD>
								<TD width="124" align="center"
									style="background: #900; color: #fff; font-weight: bold;">
									操 作
								</TD>
							</TR>

							<logic:present name="allResume">
								<logic:notEmpty name="allResume">
									<logic:iterate name="allResume" id="jobInfo"
										type="model.CompResume">

										<tr>
											<td align="center">
												<bean:write name="jobInfo" property="pkResume.name" />
											</td>
											<td align="center">
												<bean:write name="jobInfo" property="compPost.job.jobName" />
											</td>
											<td align="center">
												<bean:write name="jobInfo"
													property="pkResume.educate.educateName" />
											</td>
											<td align="center">
												<bean:write name="jobInfo" property="pkResume.specialty" />
											</td>
											<td align="center">
												<bean:write name="jobInfo" property="pkResume.limitYear" />
											</td>
											<td align="center">
												<a
													href="${ctx}/companyResume.do?method=showOneResume&userKeyId=${jobInfo.pkResume.user.id}&compResumekeyId=${jobInfo.id}&sta=${jobInfo.status}"
													class="list"> 查看</a>&nbsp;
												<a href="#" class="list" onClick="del(${jobInfo.id})">删除</a>
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
										<td height="23" colspan="6" align="right" bgcolor="FEF9F9">
											<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
										</td>
									</tr>
									<%
										} else if (pageIndex == tpp) {
									%>
									<tr>
										<td height="23" colspan="6" align="right" bgcolor="FEF9F9">
											<a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
									</tr>
									<%
										} else {
									%>
									<tr>
										<td height="23" colspan="6" align="right" bgcolor="FEF9F9">
											<a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
											<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
										</td>
									</tr>
									<%
										}
									%>
								</logic:notEmpty>
								<logic:empty name="allResume">
									<p style="color: #BD0403;">
										还没收到求职信息！
									</p>
								</logic:empty>
							</logic:present>

							<logic:notPresent name="allResume">
								<p style="color: #BD0403;">
									还没收到求职信息！
								</p>
							</logic:notPresent>


						</table>
					</form>



				</div>
			</div>
		</div>




		<iframe src="/clrcw/public/include/footer.html" height="550"
			width="960" id="iframe_foot" frameborder="0" scrolling="no"
			title="底部脚本"></iframe>


	</div>
	<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
</html:html>
