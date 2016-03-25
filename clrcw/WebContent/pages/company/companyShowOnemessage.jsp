<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@page import="model.*" %>
<%@ page import="java.text.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查看企业招聘信息</title>
	<link href="<%=request.getContextPath()%>/css/index3.css"
		rel="stylesheet" type="text/css">

	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />

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
					查看企业招聘信息
				</h2>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<html:form action="/companyPubJob.do?method=savePubJob"
						method="post" onsubmit="return checkform()">
						<table class="finktable" summary="企业招聘信息">
							<tr>
								<TD align="left" class="th1 black"
									style="font-size: 14px; border-left: #900 3px solid;"
									colspan="4">
									查看招聘信息：
								</td>

							</tr>
							<tr>
								<td width="200px" class="black">
									招聘职位：
								</td>
								<td width="270" class="font5" >
									
									<bean:define id="aJob" name="bdJob" type="java.util.List" />
									<html:select property="jobId" value="${oneJob.job.id}" disabled="true">
										<html:options collection="aJob" property="id" 
											labelProperty="jobName" />
									</html:select>
								</td>
								<td width="150" class="font5 black">
									<label for="age">
										年龄限制：
									</label>
								</td>
								<td width="270" class="font5" >
									
									${oneJob.ageLimit}
									
								</td>
							</tr>
							<tr>
								<td class="black">
									<span class="font5"><label for="sTime">
											发布时间：
										</label> </span>
								</td>
								<td>
									<%=new SimpleDateFormat("yyyy-MM-dd")
							.format(Calendar.getInstance().getTime())%>
											
								</td>
								<td class="black">
									<span class="font5"><label for="eTime">
											截止时间：
										</label> </span>
								</td>
								<td>
								${oneJob.closeTime}
											
								</td>
							</tr>

							<tr>
								<td class="black">
									<span class="font5">应届生/往届生：</span>
								</td>
								<td >
									<html:select property="grading" value="${oneJob.grading}" disabled="true">
										<html:option value="0">应届生</html:option>
										<html:option value="1">往届生</html:option>
										<html:option value="2">不限</html:option>
									</html:select>
								</td>
								<td class="black">
									<span class="font5">学历要求：</span>
								</td>
								<td title="请选择学历要求">

									<bean:define id="aEducate" name="bdEducate"
										type="java.util.List" />
									<html:select property="education"
										value="${oneJob.education.id}" disabled="true">
										<html:options collection="aEducate" property="id"
											labelProperty="educateName" />
									</html:select>
								</td>
							</tr>
							<tr>
								<td width="100" class="font5 black" >
									<label for="num">
										招聘人数：
									</label>
								</td>
								<td class="font5">
									${oneJob.jobAmount}
									
								</td>
								<td class="black">
									<span class="font5"><label for="money">
											月 薪：
										</label> </span>
								</td>
								<td>
									${oneJob.salary}
										
								</td>
							</tr>
							<tr>
								<td class="black">
									<span class="font5"><label for="experience">
											工作经验年限：
										</label> </span>
								</td>
								<td>
									${oneJob.workYear}
								</td>
								<td class="black">
									<label for="money">
										工作性质：
									</label>
						
								</td>
								<td title="请输入工作性质">
									<html:select property="nature" value="${oneJob.nature}" disabled="true">
										<html:option value="1">全职</html:option>
										<html:option value="2">兼职</html:option>
										<html:option value="3">临时工</html:option>
										<html:option value="4">小时工</html:option>
										<html:option value="5">不限</html:option>
									</html:select>
							</tr>
							<tr>
								<td class="black">
									<span class="font5"><label for="experience">
											工作区域：
										</label> </span>
								</td>
								<td>${oneJob.workarea}
								</td>

								<td class="black">
									<span class="font5"><label for="address">
											工作地点：
										</label> </span>
								</td>
								<td>
									${oneJob.address}
								</td>
							</tr>
							<tr>
							<td class="black">
									<label for="dkind">
										残疾类别：
									</label>
								</td>
								<td>
								<%PublishJobInfo oneJob=(PublishJobInfo)request.getAttribute("oneJob"); %>
										<select name="postId" id="postId" title="请选择残疾类别" disabled="true">
											<%
												List ccc = (List) request.getAttribute("bdPost");  
													for (int i = 0; i < ccc.size(); i++) {
														BdPost bdPost = (BdPost)ccc.get(i);
											%>
											<option value="<%=bdPost.getId()%>" <%if((oneJob.getPost().getId()+"").equals(bdPost.getId()+"")) {%>selected="selected"<% }%>><%=bdPost.getPostName()%></option>
											<%
												}
											%>
										</select>
									</td>
									
								</tr>
							<tr>
								<td width="100" valign="top" class="black">
									<span class="font5"><label for="intro">
											职位说明：
										</label> </span>
								</td>
								<td colspan="3">

									${oneJob.jobDesc}
								</td>
							</tr>
							<tr>
								<td valign="top" class="black">
									<label for="intro">
										福利待遇：
									</label>
								</td>
								<td colspan="3">
									${oneJob.welfare}
								</td>
							</tr>
						</table>
						<div
							style="text-align: center; padding: 20px 0; margin: -1px 0 0 0; border: #ddd 1px solid; background: #ededed;">

							<html:hidden property="infoKeyId" value="${oneJob.id}" />
							<html:hidden property="userName" value="${oneJob.compLoginId}" />
							
							<input type="button" name="btn1" value="返回"
								onClick="history.go(-1)" class="btn1" >
						</div>
					</html:form>
				</div>
			</div>
			<div align="center">
            
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
