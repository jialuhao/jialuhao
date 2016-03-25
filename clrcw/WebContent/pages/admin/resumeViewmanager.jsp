<%@ page language="java" contentType="text/html; charset=utf-8"%><%@include
	file="../../public/common/taglibs.jsp"%><%@ page import="java.util.*"%><%@ page
	import="model.PersonResume"%><%@ page import="model.PersonResumeB"%><%@ page
	import="model.ApplyJobInfo"%><%@ page import="model.PersonEducation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人简历预览</title>
		<link href="/clrcw/css/index3.css" rel="stylesheet" type="text/css" />
		<script>

</script>
	</head>

	<body>
		<%
			PersonResume personResume = (PersonResume) request.getSession()
					.getAttribute("pr");

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
		%>
		<div id="container">
			<div id="main">
				<div id="content">
					<h2>
						查看个人简历
					</h2>
					<%
									List vvv = (List) request.getSession().getAttribute("allapply");
								
                                          if(vvv!=null&&vvv.size()>0){
										Object[] tttt = (Object[]) vvv.get(0);
										ApplyJobInfo applyJob = (ApplyJobInfo) tttt[0];
								
								%>
					
				
							<%} %>
	<div class="formdiv">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							
							<tr>
								<th class="h2th" rowspan="11">
									基本情况
								</th>
								<th style="width:140px;">
									真实姓名：
								</th>
								<td class="black">
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
								<%=personResume.getHomeplace() %>
								<!--
									 <%if ("110101".equals(personResume.getHomeplace())) {%> 东城区
											<%}%>
										
											<%if ("110102".equals(personResume.getHomeplace())) {%> 西城区
											<%}%>
										
											<%if ("110105".equals(personResume.getHomeplace())) {%> 朝阳区
											<%}%>
										
											 <%if ("110106".equals(personResume.getHomeplace())) {%> 丰台区
											<%}%>
										
											 <%if ("110107".equals(personResume.getHomeplace())) {%> 石景山区
											<%}%>
										
											 <%if ("110108".equals(personResume.getHomeplace())) {%> 海淀区
											<%}%>
										
											 <%if ("110109".equals(personResume.getHomeplace())) {%> 门头沟区
											<%}%>
										
											 <%if ("110110".equals(personResume.getHomeplace())) {%> 燕山区
											<%}%>
										
											 <%if ("110111".equals(personResume.getHomeplace())) {%> 房山区
											<%}%>
										
											 <%if ("110112".equals(personResume.getHomeplace())) {%> 通州区
											<%}%>
										
											 <%if ("110113".equals(personResume.getHomeplace())) {%> 顺义区
											<%}%>
										
											 <%if ("110114".equals(personResume.getHomeplace())) {%> 昌平区
											<%}%>
										
											 <%if ("110115".equals(personResume.getHomeplace())) {%> 大兴区
											<%}%>
										
											 <%if ("110116".equals(personResume.getHomeplace())) {%> 怀柔区
											<%}%>
										
											 <%if ("110117".equals(personResume.getHomeplace())) {%> 平谷区
											<%}%>
																		
										<%if (personResume.getHomeplace().equals("外埠")) {%>
											外埠 <%}%>
								--></td>
							</tr>
							<tr>
							<th>
									<label for="language2">
										政治面貌：
									</label>
								</th>
								<td class="black">
									<%
										if ("1".equals(personResume.getPolitical())) {
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
										%>|（使用辅具）<%
											}
										%>
										<%
											if ("0".equals(personResume.getTool())) {
										%>|（不使用辅具）<%
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
							<tr <%if(personResume.getLang2()==null||"".equals(personResume.getLang2())){%>
									style="display: none;"
								<%} %>>
									<th>
										外语语种2：
									</th>
									<td class="black"><%=personResume.getLang2()%></td>
									<th>
										外语水平2：
									</th>
									<td class="black"><%=personResume.getLevel2()%></td>
								</tr>
								<tr <%if(personResume.getLang3()==null||"".equals(personResume.getLang3())){%>
									style="display: none;"
								<%} %>>
									<th>
										外语语种3：
									</th>
									<td class="black"><%=personResume.getLang3()%></td>
									<th>
										外语水平3：
									</th>
									<td class="black"><%=personResume.getLevel3()%></td>
								</tr>
							<tr>
								<th>
									职业技能：
								</th>
								<td class="black" colspan="3" >
									<%=personResume.getSkill()%>
								</td>
								
							</tr>
							
						
							
						</table>
					</div>
					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<%
								List educationslist = (List) request.getSession().getAttribute("educations");
							%>
							<tr>
								<th class="h2th" rowspan="<%=educationslist.size()%>">
									教育培训经历
								</th>
								<%
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
								<td class="black" >
									<%=personEducation.getEducation()%>
								</td>
							</tr>

							<%
								}
								}
							%>
						</table>
					</div>
					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<%
								List list = (List) request.getSession().getAttribute("resumeb");
							%>
							<tr>
								<th class="h2th" rowspan="<%=list.size()+list.size()%>">
									工作/实习经历
								</th>
								<%
									for (int i = 0; i < list.size(); i++) {

										PersonResumeB personResumeB = (PersonResumeB) list.get(i);

										if (i == 0) {
								%>
								<th style="width: 120px;">
									时 间：
								</th>
								<td class="black" style="width: 170px;">
									<%=personResumeB.getStartTime()%>至<%=personResumeB.getEndTime()%>
								</td>
								<th style="width: 120px;">
									工作单位：
								</th>
								<td class="black" style="width: 140px;">
									<%=personResumeB.getWorkUnit()%>
								</td>
								<th style="width: 80px;">
									职 位：
								</th>
								<td class="black">
									<%=personResumeB.getJob()%>
								</td>
							</tr>
							<tr>
							<th style="width: 120px;">
									工作内容：
								</th>
								
								<td colspan="5">
									<%=personResumeB.getWorkContent()%>
								
								</td></tr>
							<%
								} else {
							%>
							<tr>
								<th style="width: 120px;">
									时 间：
								</th>
								<td class="black">
									<%=personResumeB.getStartTime()%>至<%=personResumeB.getEndTime()%>
								</td>
								<th style="width: 120px;">
									工作单位：
								</th>
								<td class="black" style="width: 140px;">
									<%=personResumeB.getWorkUnit()%>
								</td>
								<th style="width: 80px;">
									职 位：
								</th>
								<td class="black">
									<%=personResumeB.getJob()%>
								</td>
							</tr>
							<tr>
							<th style="width: 80px;">
									工作内容：
								</th>
								
								<td colspan="5">
								<%=personResumeB.getWorkContent()%>
								
								</td></tr>
							<%
								}
								}
							%>
						</table>
					</div>
					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">

							<tr>
								<th class="h2th">
									自我评价
								</th>
								<td class="black">
									<%=sss.trim()%>
								</td>
							</tr>
						</table>
					</DIV>

					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">

							<tr>
								<th class="h2th">
									兴趣特长
								</th>
								<td class="black">
									<%=interests.trim()%>
								</td>
							</tr>
						</table>
					</DIV>

					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<th class="h2th" rowspan="2">
									联系方式
								</th>
								<th style="width: 140px;">
									现在住址：
								</th>
								<td class="black">
									<%=address%>
								</td>
								<th style="width: 140px;">
									户籍所在地：
								</th>
								<td class="black">
								<%=personResume.getHomeplace() %><!--
									 <%if ("110101".equals(personResume.getHomeplace())) {%> 东城区
											<%}%>
										
											<%if ("110102".equals(personResume.getHomeplace())) {%> 西城区
											<%}%>
										
											<%if ("110105".equals(personResume.getHomeplace())) {%> 朝阳区
											<%}%>
										
											 <%if ("110106".equals(personResume.getHomeplace())) {%> 丰台区
											<%}%>
										
											 <%if ("110107".equals(personResume.getHomeplace())) {%> 石景山区
											<%}%>
										
											 <%if ("110108".equals(personResume.getHomeplace())) {%> 海淀区
											<%}%>
										
											 <%if ("110109".equals(personResume.getHomeplace())) {%> 门头沟区
											<%}%>
										
											 <%if ("110110".equals(personResume.getHomeplace())) {%> 燕山区
											<%}%>
										
											 <%if ("110111".equals(personResume.getHomeplace())) {%> 房山区
											<%}%>
										
											 <%if ("110112".equals(personResume.getHomeplace())) {%> 通州区
											<%}%>
										
											 <%if ("110113".equals(personResume.getHomeplace())) {%> 顺义区
											<%}%>
										
											 <%if ("110114".equals(personResume.getHomeplace())) {%> 昌平区
											<%}%>
										
											 <%if ("110115".equals(personResume.getHomeplace())) {%> 大兴区
											<%}%>
										
											 <%if ("110116".equals(personResume.getHomeplace())) {%> 怀柔区
											<%}%>
										
											 <%if ("110117".equals(personResume.getHomeplace())) {%> 平谷区
											<%}%>
																		
										<%if (personResume.getHomeplace().equals("外埠")) {%>
											外埠 <%}%>
								--></td>
							</tr>
							<tr>
								<th>
									联系电话：
								</th>
								<td class="black">
									<%=phone%>
								</td>
								<th>
									邮 编：
								</th>
								<td class="black">
									<%=mailcode%>
								</td>
							</tr>
						</table>
					</DIV>
					<DIV class="formdiv" style="margin-top: -20px;">
						<TABLE class="finktable" id="form_1" width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								
							</tr>   
							<tr>
								<th class="h2th" rowspan="<%=vvv.size()%>">
									求职信息
								</th>
								<%
									for (int i = 0; i < vvv.size(); i++) {

										Object[] ttt = (Object[]) vvv.get(i);
										ApplyJobInfo applyJobInfo = (ApplyJobInfo) ttt[0];

										if (i == 0) {
								%>
								<th style="width: 80px;">
									期望行业：
								</th>
								<td class="black">
									<%=applyJobInfo.getPostCode().getTradeName()%>
								</td>
								<th style="width: 100px;">
									期望职业：
								</th>
								<td class="black">
									<%=applyJobInfo.getJobCode().getJobName()%>
								</td>
								<th style="width: 100px;">
									期望工作区域：
								</th>
								<td class="black">
									<%=applyJobInfo.getWorkYear()%>
								</td>
								<th style="width: 120px;">
									期望月薪(税前)：
								</th>
								<td class="font5" class="black">
									<%=applyJobInfo.getSalary()%>
								</td>
							</tr>
							<%
								} else {
							%>
							<tr>

								<th style="width: 80px;">
									期望行业：
								</th>
								<td class="black">
									<%=applyJobInfo.getPostCode().getTradeName()%>
								</td>
								<th style="width: 100px;">
									期望职位：
								</th>
								<td class="black">
									<%=applyJobInfo.getJobCode().getJobName()%>
								</td>
								<th style="width: 100px;">
									期望工作区域：
								</th>
								<td class="black">
									<%=applyJobInfo.getWorkYear()%>
								</td>
								<th style="width: 120px;">
									期望月薪(税前)：
								</th>
								<td class="font5" class="black">
									<%=applyJobInfo.getSalary()%>
								</td>
							</tr>
							<%
								}
								}
								if (vvv.size() == 0) {
							%>
							<tr>
								<td></td>
							</tr>
							<%
								}
							%>
							<tr>
							<td align="center" colspan="9">
						<input type="button" onclick="history.go(-1)" value="返回" /></td></tr>
						</table>
						
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
