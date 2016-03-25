<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>企业简历库</title>

	<script language="JavaScript" type="text/JavaScript">
function del(id){
    var b = confirm("确实要删除吗！");
    if (b) {
        document.form1.keyId.value = id;
        document.form1.action = "${ctx}/admin/aglientpublish.do?method=delOneResume";
        document.form1.submit();
    }
}

function change(s_id){
    document.form1.pageIndex.value = s_id;
    document.form1.action = "${ctx}/admin/aglientpublish.do?method=comOtherPage";
    document.form1.submit();
}
function checkresume(a,b,c){
if(c){
window.location.href="${ctx}/admin/aglientpublish.do?method=showOneResume&userKeyId="+a+"&compResumekeyId="+b}
else{
alert("该求职者的简历正在审核中，请在10个工作日以后查看");
}
}
</script>
	<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
	<link rel="stylesheet" type="text/css"
		href="/clrcw/styles/mainframe.css" />
	<link rel="stylesheet" type="text/css"
		href="/clrcw/styles/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/styles/skin.css" />
	<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
	<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>

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
				<%String compname=(String)request.getSession().getAttribute("compname"); %>
				<h2>
					企业[<%=compname %>]招聘 &nbsp;&nbsp;
					
				</h2>
				<DIV class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=companyShowInfo">&equiv;&nbsp;企业基本情况</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showPubJob">&equiv;&nbsp;企业招聘信息
							</a>
						</li>
						
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li class="liH1">
							<a href="${ctx}/admin/aglientpublish.do?method=showCompResume" style="color: #BD0403;">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showCompAbility"
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
								<td height="40" colspan="7">
									<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="25%" class="font3">
												意向简历如下:
											</td>
											<td width="25%"></td>
											<td width="25%" class="font5" align="right">
												查询:
											</td>
											<td width="25%">
												
												<a
													href=""
													class="d" style="color: #BD0403;">未读简历</a>&nbsp;&nbsp;&nbsp;&nbsp;
												<a
													href="${ctx}/admin/aglientpublish.do?method=showqueryCompResume"
													class="d">已读简历 </a>
												
											</td>

										</tr>
									</table>

								</td>
							</tr>
							<tr>
								<td width="123" align="center">
									姓 名
								</td>
								<td width="123" align="center">
									欲求职位
								</td>
								<td width="123" align="center">
									学 历
								</td>
								<td width="123" align="center">
									工作年限
								</td>
								<td width="124" align="center">
									投递时间
								</td>
								<td width="123" align="center">
									状态
								</td>
								<td width="124" align="center">
									操 作
								</td>
							</tr>

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
												<bean:write name="jobInfo" property="pkResume.limitYear" />
											</td>
											<td align="center">
												<bean:write name="jobInfo" property="createtime" />
											</td>
											<td align="center">
												<logic:equal value="1" name="jobInfo" property="status">已读</logic:equal>
												<logic:equal value="0" name="jobInfo" property="status">未读</logic:equal>
												
											</td>
											<td align="center">
												<a
														href="#"
												onclick="checkresume('${jobInfo.pkResume.user.id}','${jobInfo.id}',${jobInfo.reg})"	
													class="list"> 查看</a>&nbsp;
												<a href="#" class="list" onClick="del(${jobInfo.id})">删除</a>
											</td>
										</tr>
									</logic:iterate>
									<html:hidden property="pageIndex" value="" />
									<%
									int totalCount = ((Integer) session.getAttribute("totalCount"));
										int pageIndex = ((Integer) request.getSession()
															.getAttribute("pageIndex")).intValue();
													int tpp = ((Integer) session.getAttribute("tpp"))
															.intValue();
													if (tpp == 0) {

													} else if (pageIndex == 0) {
									%>
									<tr>
										<td height="23" colspan="7" align="right" bgcolor="FEF9F9">
										当前第<%=pageIndex+1%>页/共<%=tpp+1%>页   共    <%=totalCount %>条
											<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
										</td>
									</tr>
									<%
										} else if (pageIndex == tpp) {
									%>
									<tr>
										<td height="23" colspan="7" align="right" bgcolor="FEF9F9">
										当前第<%=pageIndex+1%>页/共<%=tpp+1%>页   共    <%=totalCount %>条
											<a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
									</tr>
									<%
										} else {
									%>
									<tr>
										<td height="23" colspan="7" align="right" bgcolor="FEF9F9">
										当前第<%=pageIndex+1%>页/共<%=tpp+1%>页   共    <%=totalCount %>条
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
										没有意向简历信息！
									</p>
								</logic:empty>
							</logic:present>

							<logic:notPresent name="allResume">
								<p style="color: #BD0403;">
									没有意向简历信息！
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
