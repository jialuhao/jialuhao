<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查看企业信息</title>
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
					查看企业详细信息
				</h2>
				<div class="formdiv">

						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
						<logic:present name="oneBespeak">
							<logic:notEmpty name="oneBespeak">
								<tr>
									<th>
										单位名称：
									</th>
									<td colspan="3">
										<bean:write name="oneBespeak" property="compName" />
									</td>
								</tr>
								<tr>
									<th>
										<br />
										法人名称：
										<br />
									</th>
									<td >
										<bean:write name="oneBespeak" property="compAddr" />
									</td>
									<th>
										<br />
										所在区域：
										<br />
									</th>
									<td >
										<bean:write name="oneBespeak" property="comparea" />
									</td>
								</tr>
								<tr>
									<th>
										邮 编：
										<br />
									</th>
									<td>
										<bean:write name="oneBespeak" property="mailPost" />
									</td>
									<th>
										电子邮件：
										<br />
									</th>
									<td>
										<bean:write name="oneBespeak" property="mail" />
									</td>
								</tr>
								<tr>
									<th>
										联系电话：
									</th>
									<td>
										<bean:write name="oneBespeak" property="telephone" />
									</td>
									<th>
										联 系 人：
									</th>
									<td>
										<bean:write name="oneBespeak" property="linkman" />
									</td>
								</tr>

							</logic:notEmpty>
							<logic:empty name="oneBespeak">
								<tr>
									<td colspan="4">
										<font class="font3">该企业还没有基本信息！</font>
									</td>
								</tr>

							</logic:empty>
						</logic:present>

						<tr>
							<th colspan="4">
								&nbsp;
							</th>
						</tr>
						<logic:present name="compInfo">
							<logic:notEmpty name="compInfo">

								<tr>
									<th>
										经营范围：
										<br />
									</th>
									<td>
										<bean:write name="compInfo" property="workScrop" />
									</td>
									<th>
										网 址：
										<br />
									</th>
									<td>
										<bean:write name="compInfo" property="netAddress" />
									</td>
								</tr>
								<tr>
									<th>
										企业性质：
									</th>
									<td>
										<bean:write name="compInfo" property="type.compTypeName" />
									</td>
									<th>
										所属行业：
									</th>
									<td>
										<bean:write name="compInfo" property="bd.tradeName" />
									</td>
								</tr>
								<tr>
									<th>
										企业介绍：
									</th>
									<td colspan="3">
										<bean:write name="compInfo" property="compIntro" />
									</td>
								</tr>

							</logic:notEmpty>
							<logic:empty name="compInfo">
								<tr>
									<td colspan="4">
										<font class="font3">该企业还没有填写其他信息！</font>
									</td>
								</tr>
							</logic:empty>
						</logic:present>
					</table>

					
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
						<tr>
							<th colspan="6" class="th1">
								企业招聘信息如下
							</th>
						</tr>

						<tr>
							<th>
								招聘职位
							</th>
							<th>
								招聘人数
							</th>
							<th>
								学历要求
							</th>
							<th>
								发布时间
							</th>
							<th>
								截止时间
							</th>
							<th>
								操作
							</th>
						</tr>
						<logic:present name="job">
							<logic:notEmpty name="job">
								<logic:iterate id="info" name="job" type="model.PublishJobInfo">
									<tr>
										<td>
											<a
												href="${ctx}/personRegist7.do?method=personRegist7&jobKey=${info.id}&compName=${oneBespeak.compName}"
												class="p"> <bean:write property="job.jobName"
													name="info" />
											</a>
										</td>
										<td>
											<bean:write property="jobAmount" name="info" />
										</td>
										<td>
											<bean:write property="education.educateName" name="info" />
										</td>
										<td>
											<bean:write property="publishTime" name="info" />
										</td>
										<td>
											<bean:write property="closeTime" name="info" />
										</td>
										<td>
											<a href="${ctx}/personRegist7.do?method=showmessage&id=${info.id}"  class="list">查看</a>
										</td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>

							<logic:empty name="job">
								<tr>
									<td height="40" colspan="4">
										数据出错，请
										<a href="${ctx}/companyShow.do?method=showAll" class="list">重试！</a>
									</td>
								</tr>
							</logic:empty>

						</logic:present>
					</table>
                   
				</div>
			</div>
			<div align="center">
            <button name="button" class="input8"  id="button1" type="button" onClick="history.go(-1)">
										返回
									</button>
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
