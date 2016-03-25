<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.PublishJobInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>企业招聘详细信息</title>
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />

	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
<script>
function postresume(){
alert("投递成功");
}
</script>
	<%
		String name = (String) request.getParameter("compName");
			System.out.println(name);

			String names = new String(request.getAttribute("compName")
					.toString().trim().getBytes("ISO8859_1"), "utf-8");
	%>
</head>
<body>
	<div id="container">
		<!--<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		--><div id="main">

			<table width="740" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="15">
					</td>
				</tr>
			</table>
			<div id="content">
				<h2>
					个人用户【${personUserId}】&nbsp;&nbsp;
					<a href="${ctx}/logout.do?method=logout" style="color: #BD0403;">[退出]</a>
				</h2>
				<div class="formdiv">
					<form action="${ctx}/postResume.do?method=postResume" method="post" >
						<table class="finktable" id="newtable" width="100%" border="0"
							cellspacing="0" cellpadding="0" style="border-top: 0;">

							<tr>
								<%
									PublishJobInfo pubJobInfo = (PublishJobInfo) request
													.getSession().getAttribute("jobinfo");
											String grad = "";
											if (pubJobInfo.getGrading().equals(0)) {
												grad = "应届生";
											} else {
												grad = "往届生";
											}
								String compName=(String)request.getAttribute("compName");
								String nature=pubJobInfo.getNature();
								 if("1".equals(nature)){
			 nature="全职";}else if("2".equals(nature)){
			 nature="兼职";}else if("3".equals(nature)){
			 nature="临时工";}else if("4".equals(nature)){
			 nature="小时工";}else if("5".equals(nature)){
			 nature="不限";}
								%>
								<input type="hidden" id="jobinfo" name="jobinfo"
									value="<%=pubJobInfo.getId()%>" />
								<td height="40" colspan="4" class="th1" style="font-size: 14px;">
									【<%=compName %>】招聘信息
								</td>
							</tr>
							<tr>
								<td>
									招聘职位：
								</td>
								<td width="270" style="color: #000000; font-size: 12px;" colspan="3"><%=pubJobInfo.getJob().getJobName()%></td>
							</tr>
							<tr>
								<td width="100">
									招聘人数：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getJobAmount()%>人
								</td>
								<td width="100" valign="top">
									职位说明：
								</td>
								<td width="270" style="color: #000000; font-size: 12px;"><%=pubJobInfo.getJobDesc()%></td>
							</tr>
							<tr>
								<td>
									发布时间：
								</td>
								<td width="270" style="color: #000000; font-size: 12px;"><%=pubJobInfo.getPublishTime()%></td>
								<td>
									截止时间：
								</td>
								<td width="270" style="color: #000000; font-size: 12px;"><%=pubJobInfo.getCloseTime()%></td>
							</tr>
							<tr>
								<td>
									工作性质：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=nature%></td>
								<td>
									年龄限制：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getAgeLimit()%></td>
							</tr>
							<tr>
								<td>
									应届生/往届生：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=grad%></td>
								<td>
									学历要求：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getEducation().getEducateName()%></td>
							</tr>
							<tr>
								<td>
									工作经验年限：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getWorkYear()%>年</td>
								<td>
									月 薪：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getSalary()%></td>
							</tr>
							<tr>
								<td>
									工作地区：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getWorkarea()%></td>
								<td>
									工作地点：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getAddress()%></td>
							</tr>
							<tr>
								<td>
									残疾类别：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getPost().getPostName()%></td>
								<td>
									职位说明：
								</td>
								<td style="color: #000000; font-size: 12px;"><%=pubJobInfo.getJobDesc()%></td>
							</tr>
							<tr>
								<td>
									福利待遇：
								</td>
								<td style="color: #000000; font-size: 12px;" colspan="3"><%=pubJobInfo.getWelfare()%></td>
								</tr>
						</table>
						<br />
						<table class="finktable" id="newtable" width="100%" border="0"
							cellspacing="0" cellpadding="0" style="border-top: 0;">
							<tr>
								<td height="40" align="center">
									<button name="button" class="input8" onClick="postresume()" type="submit" id="button" title="投递您的个人简历，申请该职位">
										投递简历
									</button>
									&nbsp;&nbsp;
									<button name="button" class="input8"  id="button1" type="button" onClick="history.go(-1)">
										返回
									</button>
								</td>
							</tr>

   
						</table>
					</form>

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
