<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<%@ page import="java.util.*"%>
<%@page import="model.PersonMailInfo"%>
<%@page import="model.PublishJobInfo"%>
<%@page import="model.PersonResume"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<title>职位搜索</title>


	<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
	<link rel="stylesheet" type="text/css"
		href="/clrcw/styles/mainframe.css" />
	<link rel="stylesheet" type="text/css"
		href="/clrcw/styles/modelist.css" />

	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/styles/skin.css" />
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
	<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
	<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>
	<script src="/clrcw/public/js/calendar.js" type="text/javascript"></script>
	<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="/clrcw/js/lhgdialog.min.js"></script>
	<script type="text/javascript">
	function resetss(){
	
	document.getElementById("jobname").value="";
   document.getElementById("address").value="";
   document.getElementById("compname").value="";
   document.getElementById("starttime").value="";
   document.getElementById("endtime").value="";
}
function search1(){
	document.searchFrom1.action="${ctx}/admin/aglientapply.do?method=showAll";
	document.searchFrom1.submit();
}
function change(s_id){
    document.searchFrom1.pageIndex.value=s_id;
    document.searchFrom1.action="${ctx}/admin/aglientapply.do?method=showOtherPage";
	document.searchFrom1.submit();
}
$(function(){

	$('#zhiye').dialog({
	width:'800px',
	height:'420px',   
	fixed: true,
	title: '选择职业',
	lock: true,
    content: 'url:/clrcw/showJoball.do?method=showJobSearch'
	});
});

function postResume(a,b,e){
if(!e){
alert("没有简历，不能投递");
}else{
window.location.href="${ctx}/admin/aglientapply.do?method=personRegist7&jobKey="+a+"&compName="+b;
}




}



</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		<div id="main">
			<table width="740" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="5">
					</td>
				</tr>
			</table>
	<%
	
	PersonResume personResume = (PersonResume) request.getSession()
			.getAttribute("pr");
%>
			<div id="content">
				<h2>
					个人用户【<%=personResume.getName()%>】信息&nbsp;&nbsp;
					
				</h2>

				<DIV class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">

					<ul id="list1">
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist3">
								&equiv;&nbsp;基本情况</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist3"> 教育培训经历
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist4">&equiv;&nbsp;工作/实习经历</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist5">&equiv;&nbsp;自我评价
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personApplyList">&equiv;&nbsp;欲求职位
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=resumeView" target="_blank">&equiv;&nbsp;个人简历预览</a>
						</li>
						<li class="liH1">
							&equiv;&nbsp;职位搜索
						</li>

					</ul>
					<br />
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<table class="finktable">
						<tr>
							<td colspan="6" style="background: #ddd;">
								<form name="searchFrom1" action="#" method="post">
								
									<html:hidden property="pageIndex" value="" />
									<input type="hidden" name='pageSize' id="pageSize" />
									<TABLE class="finktable" summary="企业招聘信息" width="100%"
										border="0" cellspacing="0" cellpadding="0">
										<TBODY>
											<tr>
											<%Boolean e=(Boolean)request.getSession().getAttribute("e");
											int totalCount = ((Integer) session
													.getAttribute("totalCount")).intValue();
											String jobname=(String)request.getSession().getAttribute("jobname");
											String address=(String)request.getSession().getAttribute("address");
											String compname=(String)request.getSession().getAttribute("compname");
											String starttime=(String)request.getSession().getAttribute("starttime");
											String endtime=(String)request.getSession().getAttribute("endtime");
											jobname = jobname!=null?jobname:"";
											address = address!=null?address:"";
											compname= compname!=null?compname:"";
											starttime= starttime!=null?starttime:"";
											endtime= endtime!=null?endtime:"";
											%>
											<input type="hidden" id="totalCount" name="totalCount" value="<%=totalCount %>" />
											
												<td>
													职位搜索
												</td>
												<td>
													<input type="text" name="jobname" title="请输入职位"
														id="jobname" value="<%=jobname %>" /><A href="###" id="zhiye" >选择职位&nbsp;▼</A>
												</td>
												<td>
													求职地区
												</td>
												<td>
													<input name="address" type="text" title="请输入要查询的工作地点"
														id="address"  value="<%=address %>" />

												</td>
												<td >
													<a href="#" class="list" onClick="change(0)">查询</a>
												</td>
											</tr>
											<tr>
												<td>
													单位名称
												</td>
												<td>
													<input name="compname" type="text" title="请输入要查询的工作地点"
														id="compname"  value="<%=compname %>"/>
												</td>
												<td>
													发布时间
												</td>
												<td>
													<input name="starttime" style="width: 70px" type="text" title="请输入要查询的发布时间"
														id="starttime" onClick="calendar.show(this);"
														readonly="readonly"  value="<%=starttime%>"/>至
													<input name="endtime" style="width: 70px" type="text" title="请输入要查询的发布时间"
														id="endtime" onClick="calendar.show(this);"
														readonly="readonly"  value="<%=endtime%>"/>
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
						<tr>

							<th valign="top">
								<table class="finktable">
									<tr>
										<th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											单位名称
										</th>
										<th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											招聘职位
										</th>
										<th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											招聘人数
										</th>
										<th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											学历
										</th>


										<th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											工作地点
										</th>


										<th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											发布时间
										</th>
										 <th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											状态
										</th>
    
                                   <th width="140" align="center"
											style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
											class="black">
											操作
										</th>
    
									</tr>

									<form action="" name="form1" method="POST">
										<logic:present name="allPublishJobInfo">
											<logic:notEmpty name="allPublishJobInfo">
												<logic:iterate name="allPublishJobInfo" id="publicJobInfo"
													type="model.PublishJobInfo">
													<tr>
														
														<td width="150px" align="center"
															style="color: #000000; font-size: 12px;">
															<bean:write property="pkComp.comp.compName" name="publicJobInfo" />
														</td>
														<td width="150px" align="center"
															style="color: #000000; font-size: 12px;">
															<bean:write property="job.jobName" name="publicJobInfo" />
														</td>
					
														<td width="150px" align="center"
															style="color: #000000; font-size: 12px;">
															<bean:write property="jobAmount" name="publicJobInfo" />
														</td>
														<td width="150px" align="center"
															style="color: #000000; font-size: 12px;">
															<bean:write property="education.educateName"
																name="publicJobInfo" />
														</td>
														<td width="150px" align="center"
															style="color: #000000; font-size: 12px;">
															<bean:write property="address" name="publicJobInfo" />
														</td>
														<td width="150px" align="center"
															style="color: #000000; font-size: 12px;">
															<bean:write property="publishTime" name="publicJobInfo" />
														</td>							 		 
	                                                         <td width="150px" align="center"
															style="color: #000000; font-size: 12px;">
														${publicJobInfo.zp_flag}
														</td>
														
													 <td width="150" style="color: #000000; font-size: 12px;" nowrap="nowrap" align="center">
									<a
										href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${publicJobInfo.pkComp.comp.id}&loginId=${publicJobInfo.pkComp.comp.userId}"
										class="tabBtn">查看企业信息</a><br/>
                            <c:choose>
                            <c:when test="${publicJobInfo.zp_flag=='未投递'}">
									<a href="#" onClick="postResume('${publicJobInfo.id}','${publicJobInfo.pkComp.comp.compName}',${e})"
									
										class="tabBtn">投递简历</a><br/>
										</c:when>
							
										</c:choose>
								
								</td>
													</tr>
												</logic:iterate>

												<%
													int pageIndex = ((Integer) request.getSession()
																		.getAttribute("pageIndex")).intValue();
												
																int tpp = ((Integer) session.getAttribute("tpp"))
																		.intValue();
																if (tpp == 0) {

																} else if (pageIndex == 0) {
												%>
												<tr>
													<td height="23" colspan="8" align="right">
													当前第<%=pageIndex + 1%>页/共<%=tpp+1 %>页 共
													<%=totalCount%>条
														<a href="#" class="list"
															onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
															
													</td>
												</tr>
												<%
													} else if (pageIndex == tpp) {
												%>
												<tr>
													<td height="23" colspan="8" align="right">
													当前第<%=pageIndex + 1%>页/共<%=tpp+1%>页 共
													<%=totalCount%>条
														<a href="#" class="list"
															onClick="change(<%=pageIndex%>-1)">上一页</a>
												</tr>
												<%
													} else {
												%>
												<tr>
													<td height="23" colspan="8" align="right">
													当前第<%=pageIndex + 1%>页/共<%=tpp +1%>页 共
													<%=totalCount%>条
														<a href="#" class="list"
															onClick="change(<%=pageIndex%>-1)">上一页</a>
														<a href="#" class="list"
															onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a>
													</td>
												</tr>
												<%
													}
												%>
											</logic:notEmpty>
											<logic:empty name="allPublishJobInfo">
												<p class="font5">
													没有企业招聘信息!
												</p>
											</logic:empty>
										</logic:present>

										<logic:notPresent name="allPublishJobInfo">
											<p class="font5">
												没有企业招聘信息!
											</p>
										</logic:notPresent>
								</table>
								</form>
					</table>


					</th>

					</tr>

					</table>

				</div>
			</div>
		</div>


		<iframe src="/clrcw/public/include/footer.html" height="150"
			width="960" id="iframe_foot" frameborder="0" scrolling="no"
			title="底部脚本"></iframe>



	</div>
	<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>

</body>
</html:html>
