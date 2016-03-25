<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人简历详细信息</title>
		<link href="/clrcw/css/index3.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="container">
			<div id="header">
			</div>
			<div id="main">

				<div id="content">
					<h2>
						查看个人简历
					</h2>
					<div class="formdiv">

						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<logic:present name="resume">
								<tr>
									<th class="h2th" rowspan="8">
										基本情况
									</th>
									<th>
										真实姓名：
									</th>
									<td>
										<bean:write name="resume" property="name" />
									</td>
									<th>
										性 别：
									</th>
									<td>
										<bean:write name="resume" property="sex" />
									</td>
								</tr>
								<tr>
									<th>
										出生日期：
									</th>
									<td>
										<bean:write name="resume" property="birthday" />
									</td>
									<th>
										户籍所在地：
									</th>
									<td>
										<bean:write name="resume" property="homeplace" />
									</td>
								</tr>
								<tr>
									<th>
										现在住址：
									</th>
									<td>
										<bean:write name="resume" property="address" />
										</span>
									</td>
									<th>
										邮 编：
									</th>
									<td>
										<bean:write name="resume" property="mailcode" />
									</td>
								</tr>
								<tr>
									<th>
										联系电话：
									</th>
									<td>
										<bean:write name="resume" property="phone" />
									</td>
									<th>
										最高学历：
									</th>
									<td>
										<bean:write name="resume" property="educate.educateName" />
									</td>
								</tr>
								
								<tr>
									<th>
										工作年限：
									</th>
									<td>
										<bean:write name="resume" property="limitYear" />
									</td>
									<th>
										计算机水平：
									</th>
									<td>
										<bean:write name="resume" property="compLevel" />
									</td>
								</tr>
								<tr>
									<th>
										外语语种1：
									</th>
									<td>
										<bean:write name="resume" property="lang" />
									</td>
									<th>
										外语水平1：
									</th>
									<td>
										<bean:write name="resume" property="level1" />
									</td>
								</tr>
								<tr>
									<th>
										残疾程度：
									</th>
									<td>
										<bean:write name="resume" property="lang2" />
									</td>
									<th>
										残疾类别：
									</th>
									<td>
										<bean:write name="resume" property="level2" />
									</td>
								</tr>
							</logic:present>
							<logic:notPresent name="resume">

							</logic:notPresent>

						</table>

						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<th class="h2th">
									工作/实习经历
								</th>
								<td valign="top">
									<table style="width: 100%" class="finktable" summary="工作/实习经历"
										cellpadding="0" cellspacing="0">


										<tr>
											<th>
												时 间：
											</th>
											<th>
												工作单位：
											</th>
											<th>
												职 位：
											</th>
										</tr>

										<logic:present name="resumeB">
											<logic:iterate id="resume2" name="resumeB"
												type="model.PersonResumeB">
												<tr>
													<td>
														<bean:write name="resume2" property="startTime" />
														<bean:write name="resume2" property="endTime" />
													</td>
													<td>
														<bean:write name="resume2" property="workUnit" />
													</td>
													<td>
														<bean:write name="resume2" property="job" />
													</td>
												</tr>

											</logic:iterate>
										</logic:present>
										<logic:notPresent name="resumeB">

										</logic:notPresent>

									</table>
								</td>
							</tr>


						</table>
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<th class="h2th">
									自我评价
								</th>
								<td>
									<logic:present name="resume">
										<bean:write name="resume" property="introSelf" />
									</logic:present>
								</td>
							</tr>
						</table>
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<logic:present name="resume">
								<tr>
									<th class="h2th" rowspan="2">
										联系方式
									</th>
									<th>
										现在住址：
									</th>
									<td>
										<bean:write name="resume" property="address" />
									</td>
									<th>
										户籍所在地：
									</th>
									<td>
										<bean:write name="resume" property="homeplace" />
									</td>

								</tr>
								<tr>
									<th>
										联系电话：
									</th>
									<td>
										<bean:write name="resume" property="phone" />
									</td>
									<th>
										邮 编：
									</th>
									<td>
										<bean:write name="resume" property="mailcode" />
									</td>

								</tr>
							</logic:present>
						</table>


						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">





							<tr>
								<th class="h2th">
									求职信息
								</th>

								<td valign="top">
									<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">


										<tr>
											<th>
												残疾类别：
											</th>
											<th>
												欲从事职位：
											</th>

											<th>
												曾从事本职位(年)：
											</th>

											<th>
												期望月薪(税前)：
											</th>

										</tr>
										<logic:present name="applyJob">
											<logic:iterate id="job" name="applyJob"
												type="model.ApplyJobInfo">
												<tr>
													<th>
														<bean:write name="job" property="postCode.tradeName" />
													</th>
													<th>
														<bean:write name="job" property="jobCode.jobName" />
													</th>
													<th>
														<bean:write name="job" property="workYear" />
													</th>
													<th>
														<bean:write name="job" property="salary" />
													</th>

												</tr>
											</logic:iterate>
										</logic:present>
										<logic:notPresent name="applyJob">

										</logic:notPresent>

									</table>
								</td>
							</tr>




						</table>

						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr align="center">
								<logic:present name="sta">
									<logic:equal name="sta" value="0">
										<th height="40" align="center">
											<html:link href="${ctx}/companyResume.do?method=contact"
												styleClass="d">
												<span class="font10">[放入已读简历]</span>
											</html:link>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="#" Class="d" onClick=history.back();return false;
>
												<span class="font10">[返回]</span>
											</a>
											</td>
									</logic:equal>
									<logic:notEqual name="sta" value="0">
										<td height="40" align="center">
											<a href="#" Class="d" onClick=history.back();return false;
>
												<span class="font10">[返回]</span>
											</a>
										</td>
									</logic:notEqual>
								</logic:present>
								<logic:notPresent name="sta">
								</logic:notPresent>


							</tr>
						</table>

						<br />
					</div>
				</div>
			</div>
			<div id="footer">
			</div>
		</div>
	</body>
</html>
