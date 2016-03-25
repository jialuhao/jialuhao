<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.*"%>

<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人简历详细信息</title>
		<link href="/clrcw/css/index3.css" rel="stylesheet" type="text/css" />
	</head>
<%
			PersonResume personResume = (PersonResume) request
					.getAttribute("resume");

			String address = personResume.getAddress();
			String phone = personResume.getPhone();
			String mailcode = personResume.getMailcode();
			if (phone == null) {
				phone = "";
			}
			if (address == null) {
				address = "";
			}
			if (mailcode == null) {
				mailcode = "";
			}
			String sss = personResume.getIntroSelf();
			if (sss == null)
				sss = "";
			String interests = personResume.getInterests();
			if (interests == null)
				interests = "";
			String skill = personResume.getSkill();
			if (skill == null)
				skill = "";
		%>
	<body>
		<div id="container">
			<div id="main">
				<div id="content">
					<h2>
						查看个人简历
					</h2>
					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0">
						<tr>
						<%List rocommend=(List) request.getAttribute("recommends"); %>
								<th class="h2th" rowspan="<%=rocommend.size()%>">
									推荐记录
								</th>
								<%
								if(rocommend!=null&&rocommend.size()>0){
									for (int i = 0; i < rocommend.size(); i++) {
										Recommends recommends = (Recommends) rocommend
												.get(i);
										
								%>
								<th style="width: 80px;">
									推荐人：
								</th>
								<td class="black" style="width: 200px;">
									<%=recommends.getCommdpeople()%>
								</td>
								<th style="width: 120px;">
									推荐公司：
								</th>
								<td class="black" style="width: 140px;">
									<%=recommends.getCompany()%>
								</td>
								<th style="width: 80px;">
									推荐职位：
								</th>
								<td class="black">
									<%=recommends.getJob()%>
								</td>
									</tr>
								<%}}else{ %>
								<th> 推荐人：</th> <td></td>
								<th>推荐公司： </th> <td></td>
								<th> 推荐职位：</th> <td></td>
								</tr>
								<%} %>
						
							
						</TABLE>
						</DIV>
					<div class="formdiv">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							
								<tr>
								<th class="h2th" rowspan="11">
									基本情况
								</th>
								<th style="width: 140px;">
									真实姓名：
								</th>
								<td class="black" style="width: 240px;">
									<%=personResume.getName()%>
								</td>
								<th style="width: 140px;">
									性 别：
								</th>
								<td class="black">
									<%=personResume.getSex()%>
								</td>
							</tr>
							<tr>
								<th>
									出生日期：
								</th>
								<td class="black">
									<%=personResume.getBirthday()%>
								</td>
								<th>
									户籍所在地：
								</th>
								<td class="black">
									<%=personResume.getHomeplace()%>
								</td>
							</tr>
							<tr>
							<th>
									<label for="language2">
										政治面貌：
									</label>
								</th>
								<td class="black">
									<%if ("1".equals(personResume.getPolitical())) {
									%>群众<%
										}
									%> 
									<%
										if ("2".equals(personResume.getPolitical())) {
									%>中共党员<%
										}
									%>
									<%
										if ("3".equals(personResume.getPolitical())) {
									%>共青团员<%
										}
									%>
									<%
										if ("4".equals(personResume.getPolitical())) {
									%>其它<%
										}
									%>
								</td>
								<th>
									<label for="languagelevel2">
										婚姻状况：
									</label>
								</th>
								<td class="black">
									<%
										if ("1".equals(personResume.getMarriage())) {
									%>已婚<%
										}
									%>
									<%
										if ("2".equals(personResume.getMarriage())) {
									%>未婚<%
										}
									%>
									<%
										if ("3".equals(personResume.getMarriage())) {
									%>离异<%
										}
									%>
									<%
										if ("4".equals(personResume.getMarriage())) {
									%>丧偶<%
										}
									%>
								</td>
								
							</tr>
							<tr>
								<th>
									残疾类别：
								</th>
								<td class="black">
									<%=personResume.getDkind()%>
								</td>
								<th>
									残疾程度：
								</th>
								<td class="black">
									<%
										if ("1".equals(personResume.getDlevel())) {
									%>一级<%
										}
									%>
									<%
										if ("2".equals(personResume.getDlevel())) {
									%>二级<%
										}
									%>
									<%
										if ("3".equals(personResume.getDlevel())) {
									%>三级<%
										}
									%>
									<%
										if ("4".equals(personResume.getDlevel())) {
									%>四级<%
										}
									%>
								</td>
							</tr>
							<tr>
								<th>
									<label for="language2">
										残疾部位：
									</label>
								</th>
								<td colspan="3" class="black">
									<%
										if (personResume.getParts() != null) {
											for (int i = 0; i < personResume.getParts().length(); i++) {
												if ("1".equals(personResume.getParts().charAt(i) + "")) {
									%>左上肢<%
										}
									%>
									<%
										if ("2".equals(personResume.getParts().charAt(i) + "")) {
									%>左下肢<%
										}
									%>
									<%
										if ("3".equals(personResume.getParts().charAt(i) + "")) {
									%>右上肢<%
										}
									%>
									<%
										if ("4".equals(personResume.getParts().charAt(i) + "")) {
									%>右下肢<%
										}
									%>
									<%
										if ("5".equals(personResume.getParts().charAt(i) + "")) {
									%>脊柱<%
										}
									%>
									<%
										if ("6".equals(personResume.getParts().charAt(i) + "")) {
									%>身体矮小<%
										}
									%>
									<%
										if ("7".equals(personResume.getParts().charAt(i) + "")) {
									%>使用助听器可以交流<%
										}
									%>
									<%
										if ("8".equals(personResume.getParts().charAt(i) + "")) {
									%>手语交流<%
										}
									%>
									<%
										if ("9".equals(personResume.getParts().charAt(i) + "")) {
									%>低视力<%
										}
											}
										}
									
											if (personResume.getOtherparts() != null) {
										%><%=personResume.getOtherparts()%>
										<%
											}
										%>
										<%
											if ("1".equals(personResume.getTool())) {
										%>（使用辅具）<%
											}
										%>
										<%
											if ("0".equals(personResume.getTool())) {
										%>（不使用辅具）<%
											}
										%>
								</td>
							</tr>
							<tr>
								
								<th>
									最高学历：
								</th>
								<td class="black">
									<%=personResume.getEducate().getEducateName()%>
								</td>
								<th>
									计算机水平：
								</th>
								<td class="black">
									<%=personResume.getCompLevel()%>
								</td>
							</tr>
							<tr>
								<th>
									工作年限：
								</th>
								<td class="black">
									<%=personResume.getLimitYear()%>
								</td>
								<th>
									<label for="languagelevel2">
										目前状态：
									</label>
								</th>
								<td class="black">
									<%
										if ("1".equals(personResume.getWorkstate())) {
									%>应届毕业生<%
										}
									%>
									<%
										if ("2".equals(personResume.getWorkstate())) {
									%>目前离职(或失业)<%
										}
									%>
									<%
										if ("3".equals(personResume.getWorkstate())) {
									%>目前在职<%
										}
									%>
								</td>
							</tr>
							<tr>
								<th>
									外语语种1：
								</th>
								<td class="black">
									<%=personResume.getLang()%>
								</td>
								<th>
									外语水平1：
								</th>
								<td class="black">
									<%=personResume.getLevel1()%>
								</td>
							</tr>
							<tr>
								<th>
									职业技能：
								</th>
								<td class="black" colspan="3">
									<%=skill%>
								</td>
								
							</tr>
						</table>
					</DIV>
					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<%
								List educationslist = (List) request.getAttribute("educations");
							%>
							<tr>
								<th class="h2th" rowspan="<%=educationslist.size()%>">
									教育培训经历
								</th>
								<%if(educationslist.size()>0){
									for (int i = 0; i < educationslist.size(); i++) {
										PersonEducation personEducation = (PersonEducation) educationslist
												.get(i);
										if (i == 0) {
								%>
								<th style="width: 80px;">
									时 间：
								</th>
								<td class="black" style="width: 200px;">
									<%=personEducation.getStartTime()%>至<%=personEducation.getEndTime()%>
								</td>
								<th style="width: 120px;">
									毕业院校/机构：
								</th>
								<td class="black" style="width: 140px;">
									<%=personEducation.getSchoolname()%>
								</td>
								<th style="width: 80px;">
									学历/学位：
								</th>
								<td class="black">
									<%=personEducation.getEducation()%>
								</td>
							</tr>
							<%
								} else {
							%>
							<tr>
								<th style="width: 80px;">
									时 间：
								</th>
								<td class="black">
									<%=personEducation.getStartTime()%>至<%=personEducation.getEndTime()%>
								</td>
								<th>
									毕业院校/机构：
								</th>
								<td class="black" style="width: 140px;">
									<%=personEducation.getSchoolname()%>
								</td>
								<th style="width: 80px;">
									学历/学位：
								</th>
								<td class="black">
									<%=personEducation.getEducation()%>
								</td>
							</tr>

							<%}
								}
								}else{
							%>
							
								<th style="width: 80px;">
									时 间：
								</th>
								<td class="black">
									
								</td>
								<th>
									毕业院校/机构：
								</th>
								<td class="black" style="width: 140px;">
									
								</td>
								<th style="width: 80px;">
									学历/学位：
								</th>
								<td class="black">
									
								</td>
							</tr>
							<%} %>
						</table>
					</div>
					<DIV class="formdiv" style="margin-top: -20px;">
						<table class="finktable" id="form_1" width="100%" border="0"
							cellpadding="0" cellspacing="0" summary="工作/实习经历">
							<tr>
								<th class="h2th">
									工作/实习经历
								</th>
								<td valign="top">
									<table style="width: 100%" class="finktable" summary="工作/实习经历"
										class="finktable" id="form_1" width="100%" border="0"
										cellpadding="0" cellspacing="0">
										<tr>
											<TH style="width: 80px;">
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
											<tr>
												<td>
												</td>
												<td>
												</td>
												<td>
												</td>
											</tr>
										</logic:notPresent>
										</td>
										</tr>
									</table>
							</tr>
						</table>

					</div>
					<DIV class="formdiv" style="margin-top: -20px;">

						<table summary="自我评价" class="finktable" id="form_1" width="100%"
							border="0" cellpadding="0" cellspacing="0">
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
					</div>
					<DIV class="formdiv" style="margin-top: -20px;">

						<table summary="兴趣特长" class="finktable" id="form_1" width="100%"
							border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th class="h2th">
									兴趣特长
								</th>
								<td>
									<logic:present name="resume">
										<bean:write name="resume" property="interests" />
									</logic:present>
								</td>
							</tr>
						</table>
					</div>
					<DIV class="formdiv" style="margin-top: -20px;">
						<table class="finktable" summary="联系方式及求职信息" class="finktable"
							id="form_1" width="100%" border="0" cellpadding="0"
							cellspacing="0">
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
					</div>
					<DIV class="formdiv" style="margin-top: -20px;">

						<table class="finktable" summary="工作/实习经历" class="finktable"
							id="form_1" width="100%" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<th class="h2th">
									求职信息
								</th>

								<td valign="top">
									<table style="width: 100%" class="finktable" summary="工作/实习经历"
										class="finktable" id="form_1" width="100%" border="0"
										cellpadding="0" cellspacing="0">


										<tr>
											<th>
												期望从事行业：
											</th>
											<th>
												欲从事职位：
											</th>

											<th>
												期望工作区域：
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
					</div>
					<div
						style="text-align: center; padding: 20px 0; margin: -1px 0 0 0; border: #ddd 1px solid; background: #ededed;">


	
							
							<input type="button" onclick="history.go(-1)" value="返回" />
							


						<br />
					</div>
				</div>
			</div>
			<div id="footer">
			</div>
		</div>
	</body>
</html>

<map name="Map" id="Map">
	<area shape="rect" coords="603,16,644,37" href="#1" />
</map>
</body>
</html>