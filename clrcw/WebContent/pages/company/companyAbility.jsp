<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.BdEducate"%>
<%@ page import="model.BdPost"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>企业人才库</title>

	<script language="JavaScript" type="text/JavaScript">
	function resetss(){
	
	document.getElementById("education").value="";
   document.getElementById("years").value="";
   document.getElementById("dkind").value="";
   document.getElementById("startdate").value="";
    document.getElementById("enddate").value="";
}
function del(id){
    var b = confirm("确定要删除吗！");
    if (b) {
        document.form1.keyId.value = id;
        document.form1.action = "${ctx}/companyAbility.do?method=delOneResume";
        document.form1.submit();
    }
}

function change(s_id){
    document.form1.pageIndex.value = s_id;
    document.form1.action = "${ctx}/companyAbility.do?method=comOtherPage";
    document.form1.submit();
}
function checkresume(a,b){
if(!b){
alert("该求职者的简历正在审核中请在10个工作日后查看");
}else{
window.location.href="${ctx}/companyAbility.do?method=showOneResume&userKeyId="+a;
}
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
							<a href="${ctx}/companySPerson.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li>
							<a href="${ctx}/companyQueryNotContact.do?method=showCompResume">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li class="liH1">
							<a href="${ctx}/companyAbility.do?method=showCompAbility"
								style="color: #BD0403;">&equiv;&nbsp;人才库管理</a>
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
								<td colspan="6" style="background: #ddd;">
									<TABLE class="finktable" summary="企业招聘信息" width="100%"
										border="0" cellspacing="0" cellpadding="0">
										<TBODY>
											<tr>
												<td>
													学 历
												</td>
												<td>
													<select name="education" id="education" title="请选择最高学历">
														<option value="">
															全部
														</option>
														<%
															String education=(String)request.getAttribute("education");
															List vvv = (List) request.getAttribute("bdEducate");

																if (vvv != null) {

																	for (int i = 0; i < vvv.size(); i++) {
																		BdEducate bdEducate = new BdEducate();
																		bdEducate = (BdEducate) vvv.get(i);
														%>
														<option value="<%=bdEducate.getId()%>" <%if((bdEducate.getId()+"").equals(education)){ %>selected<%} %>><%=bdEducate.getEducateName()%></option>

														<%
															}
																}
														%>
													</select>
												</td>
												<td>
													工作年限
												</td>
												<td>
													<%String years=(String)request.getAttribute("years");
													if(years==null)years="";
													%>
															
													<input type="text" name="years" title="请输入工作年限" id="years"
														value="<%=years%>" />年及以上
												</td>
												<td >
													
													<a href="#" class="list" onClick="change(0)">查询</a>
												</td>
											</tr>
											<tr>
												<td>
													残疾类别
												</td>
												<td>
													<select name="dkind" id="dkind" title="请选择残疾类别">
														<option value="">
															全部
														</option>
														<%		String dkind=(String)request.getAttribute("dkind");

															List bdPostlist = (List) request.getAttribute("bdPost");

																if (bdPostlist != null) {

																	for (int i = 0; i < bdPostlist.size(); i++) {
																		BdPost bdPost = new BdPost();
																		bdPost = (BdPost) bdPostlist.get(i);
														%>
														<option value="<%=bdPost.getId()%>" <%if((bdPost.getId()+"").equals(dkind)){ %>selected<%} %>><%=bdPost.getPostName()%></option>
														<%
															}
																}
														%>
													</select>
												</td>
												<td>
													年 龄
												</td>
												<td>
													<select name="startdate" id="startdate" title="请选择最小年龄">
														<option value="">

														</option>
														<%String startdate=(String)request.getAttribute("startdate");
														  String enddate=(String)request.getAttribute("enddate");
														%>
														<%
															for (int i = 16; i < 60; i++) {
														%>
														<option value="<%=i%>" <%if((i+"").equals(startdate)){ %>selected<%} %>><%=i%></option>

														<%
															}
														%>
													</select>
													--
													<select name="enddate" id="enddate" title="请选择最大年龄">
														<option value="">

														</option>
														<%
															for (int i = 16; i < 60; i++) {
														%>
														<option value="<%=i%>" <%if((i+"").equals(enddate)){ %>selected<%} %>><%=i%></option>

														<%
															}
														%>
													</select>
												</td>
												<td>
												<a href="#" class="list" onClick="resetss()">重置</a>
												</td>
											</tr>
										</TBODY>
									</table>
								</td>
							</tr>
							<TR>
								<TD align="left" class="th1 black"
									style="font-size: 14px; border-left: #900 3px solid;"
									colspan="6">
									<strong>已经加入人才库信息如下：</strong>
								</TD>
							</TR>
							<tr>
								<td width="123" align="center">
									姓 名
								</td>
								<td width="123" align="center">
									学 历
								</td>
								<td width="123" align="center">
									毕业学校
								</td>
								<td width="124" align="center">
									残疾类别
								</td>
								<td width="124" align="center">
									工作年限
								</td>
								<td width="124" align="center">
									操 作
								</td>
							</tr>
							<input type="hidden" name="pageIndex" value="" />

							<logic:present name="allResume">
								<logic:notEmpty name="allResume">
									<logic:iterate name="allResume" id="jobInfo"
										type="model.CompResume">
										<tr>
											<td align="center" style="color: #000000; font-size: 12px;">
												<bean:write name="jobInfo" property="pkResume.name" />
											</td>
											<td align="center" style="color: #000000; font-size: 12px;">
												<bean:write name="jobInfo"
													property="pkResume.educate.educateName" />
											</td>
											<td align="center" style="color: #000000; font-size: 12px;">
												<bean:write name="jobInfo" property="pkResume.school" />
											</td>
											<td align="center" style="color: #000000; font-size: 12px;">
												<bean:write name="jobInfo" property="pkResume.dkind" />
											</td>
											<td align="center" style="color: #000000; font-size: 12px;">
												<bean:write name="jobInfo" property="pkResume.limitYear" />
											</td>
											<td align="center" style="color: #000000; font-size: 12px;">
												<a
													href="#"
													class="list" onclick="checkresume('${jobInfo.pkResume.user.id}',<%=jobInfo.getReg()%>)"> 查看</a>&nbsp;
												<a href="#" class="list" onClick="del(${jobInfo.id})">删除</a>
											</td>
										</tr>
									</logic:iterate>
									<%
										int pageIndex = ((Integer) request
															.getAttribute("pageIndex")).intValue();
										
										int tpp = ((Integer) session.getAttribute("tpp"))
															.intValue();
										int totalCount = ((Integer) session.getAttribute("totalCount"))
										.intValue();
													if (tpp == 0) {

													} else if (pageIndex == 0) {
									%>
									<tr>
										<td height="23" colspan="6" align="right" bgcolor="FEF9F9">
										当前第<%=pageIndex+1%>页/共<%=tpp+1%>页   共    <%=totalCount %>条
											<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
										</td>
									</tr>
									<%
										} else if (pageIndex == tpp) {
									%>
									<tr>
										<td height="23" colspan="6" align="right" bgcolor="FEF9F9">
										当前第<%=pageIndex+1%>页/共<%=tpp+1%>页   共    <%=totalCount %>条
											<a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
									</tr>
									<%
										} else {
									%>
									<tr>
										<td height="23" colspan="6" align="right" bgcolor="FEF9F9">
										当前第<%=pageIndex+1%>页/共<%=tpp+1%>页   共     <%=totalCount %>条
											<a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
											<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
										</td>
									</tr>
									<%
										}
									%>
								</logic:notEmpty>
								<logic:empty name="allResume">
									<tr>
										<td height="23" colspan="6" align="center" bgcolor="FEF9F9">
											<p style="color: #BD0403;">
												没有符合此条件的人才信息！
											</p>
										</td>
									</tr>
								</logic:empty>

							</logic:present>
							<logic:notPresent name="allResume">
								<tr>
									<td height="23" colspan="6" align="center" bgcolor="FEF9F9">
										<p style="color: #BD0403;">
											还没有信息！
										</p>
									</td>
								</tr>

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
