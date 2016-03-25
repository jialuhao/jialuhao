<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.BdEducate"%>
<%@ page import="model.Areacode"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>人才搜索</title>

	<script language="JavaScript" type="text/JavaScript">
	function resetss(){
	
	document.getElementById("zhiwei").value="";
   document.getElementById("workarea").value="";
   document.getElementById("area").value="";
   document.getElementById("workstate").value="";
   
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
    document.form1.action = "${ctx}/admin/aglientpublish.do?method=showOtherPage";
    document.form1.submit();
}
function search2(){
	document.form1.action = "${ctx}/companySPerson.do?method=showAll";
	document.form1.submit();
}
</script>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
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
						
						<li  class="liH1">
							<a href="${ctx}/admin/aglientpublish.do?method=showAll" style="color: #BD0403;">&equiv;&nbsp;人才搜索</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showCompResume">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showCompAbility"
								>&equiv;&nbsp;人才库管理</a>
						</li>
					</ul>
					<div style="clear: both;"></div>
				</DIV>
    
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<table class="finktable">
						<tr>
							<td colspan="6" style="background: #ddd;">
								<form name="form1" action="#" method="post">
									<input type="hidden" name="pageIndex" id="pageIndex" value="">
									<input type="hidden" name="totalCount" id="totalCount" value="<%=session.getAttribute("personTotalCount") %>">
									<TABLE class="finktable" summary="人才搜索" width="100%"
										border="0" cellspacing="0" cellpadding="0">
										<%
											String search = (String) request.getSession().getAttribute("search");
												search = search == null ? "" : search;
												String area = (String) request.getSession().getAttribute("area");
												String workarea = (String) request.getSession().getAttribute("workarea");
												String workstate = (String) request.getSession().getAttribute("workstate");
										%>
										<TBODY>
											<tr>
												<td>
													应聘职位
												</td>
												<td>
													<input type="text" name="zhiwei" title="请输入职位" id="zhiwei"
														value="<%=search%>" />
												</td>
												<td>
													求职地区
												</td>
												<td>
													<select name="workarea" id="workarea" title="请选择求职地区">
														<option value="" selected>
															全部
														</option>

														<%
															List sss = (List) request.getSession().getAttribute("arealist");
																for (int i = 0; i < sss.size(); i++) {
																	Areacode areacode = (Areacode) sss.get(i);
														%>
														<option value="<%=areacode.getAreaname()%>" <%if (areacode.getAreaname().equals(workarea)) {%> selected
															<%}%> ><%=areacode.getAreaname()%></option>
														<%
															}
														%>
													</select>
												</td>
												<td >
													<a href="#" class="list" onClick="change(0)">查询</a>
												</td>
											</tr>
											<tr>
												<td>
													户 籍
												</td>
												<td>
													<select name="area" id="area" title="请选择目前状态">
														<option value="" selected>
															全部
														</option>
														<option value="1" <%if ("1".equals(area)) {%> selected
															<%}%>>
															北京
														</option>
														<option value="2" <%if ("2".equals(area)) {%> selected
															<%}%>>
															外阜
														</option>
													</select>
												</td>
												<td>
													目前状态
												</td>
												<td>
													<select name="workstate" id="workstate" title="请选择目前状态">
														<option value="" selected>
															全部
														</option>
														<option value="1" <%if ("1".equals(workstate)) {%> selected
															<%}%>>
															应届毕业生
														</option>
														<option value="2" <%if ("2".equals(workstate)) {%> selected
															<%}%>>
															目前离职(或失业)
														</option>
														<option value="3" <%if ("3".equals(workstate)) {%> selected
															<%}%>>
															目前在职
														</option>
													</select>
												</td>
												<td>
												<a href="#" class="list" onClick="resetss()">重置</a>
												</td>
											</tr>
										</TBODY>
									</table>
								</form>
							</td>
						</tr>
						<TR>
							<TD align="left" class="th1 black"
								style="font-size: 14px; border-left: #900 3px solid;"
								colspan="6">
								<strong>人才信息如下：</strong>
							</TD>
						</TR>
						<tr>

							<th valign="top">
								<table class="finktable">
									<tr>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											姓名
										</th>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											期望从事行业
										</th>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											应聘职位
										</th>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											学历
										</th>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											求职地区
										</th>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											登记时间
										</th>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											加入人才库状态
										</th>
										<th
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
											操作
										</th>
									</tr>



									<logic:present name="allApplyJobInfo">
										<logic:notEmpty name="allApplyJobInfo">
											<logic:iterate name="allApplyJobInfo" id="jobInfo"
												type="model.ApplyJobInfo">

												<tr>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="resumeCode.name" name="jobInfo" />
													</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="postCode.tradeName" name="jobInfo" />
													</td>
													<td width="150px" height="23" align="center">
														
													<bean:write property="jobCode.jobName" name="jobInfo" />
													</td>


													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="resumeCode.educate.educateName"
															name="jobInfo" />
													</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="workYear" name="jobInfo" />
													</td>

													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="createTime" name="jobInfo" />
													</td>
													
			                                        <td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<bean:write property="isNo" name="jobInfo" />
													</td>
													<td width="150px" align="center"
														style="color: #000000; font-size: 12px;">
														<logic:present name="compUserId">
															<a
																href="${ctx}/admin/aglientpublish.do?method=showPersonInfo&applyKeyId=${jobInfo.id}"
																class="p" align="center"
																style="color: #000000; font-size: 12px;"> 查看</a>
														</logic:present>
														<logic:notPresent name="compUserId">
															<a href="#" class="p" onClick="nologinc()" align="center"
																style="color: #000000; font-size: 12px;"> 查看</a>
														</logic:notPresent>
														
													</td>
												</tr>
											</logic:iterate>




											<%
												int pageIndex = ((Integer) request
																	.getSession().getAttribute("pageIndex")).intValue();
															int totalCount = ((Integer) session
																	.getAttribute("personTotalCount")).intValue();
															int tpn = ((Integer) session.getAttribute("tpn"))
																	.intValue();
															if (tpn == 0) {

															} else if (pageIndex == 0) {
											%>
											<tr>
												<td height="23" colspan="8" align="right">
													当前第<%=pageIndex + 1%>页/共<%=tpn%>页 共
													<%=totalCount%>条
													<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
												</td>
											</tr>
											<%
												} else if (pageIndex == tpn) {
											%>
											<tr>
												<td height="23" colspan="8" align="right">
													当前第<%=pageIndex + 1%>页/共<%=tpn%>页 共
													<%=totalCount%>条
													<a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
											</tr>
											<%
												} else {
											%>
											<tr>
												<td height="23" colspan="8" align="right">
													当前第<%=pageIndex + 1%>页/共<%=tpn%>页 共
													<%=totalCount%>条
													<a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
													<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
												</td>
											</tr>
											<%
												}
											%>
										</logic:notEmpty>
										<logic:empty name="allApplyJobInfo">
											<tr>
												<td colspan="6" width="850px">
													<p class="font5">
														没有符合此条件的求职信息！
													</p>
												</td>
											</tr>
										</logic:empty>
									</logic:present>
									<logic:notPresent name="allApplyJobInfo">
										<tr>
											<td colspan="6" width="850px">
												<p class="font5">
													没有个人求职信息！
												</p>
											</td>
										</tr>
									</logic:notPresent>



								</table>
							</th>

						</tr>

					</table>
				</div>


			</div>




			<iframe src="/clrcw/public/include/footer.html" height="550"
				width="960" id="iframe_foot" frameborder="0" scrolling="no"
				title="底部脚本"></iframe>
		</div>
	</div>
	<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
</html:html>
