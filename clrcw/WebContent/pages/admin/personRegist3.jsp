<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@page import="model.PersonResume"%>

<%
	
	PersonResume personResume = (PersonResume) request.getSession()
			.getAttribute("pr");
%>
<script language="JavaScript" type="text/JavaScript">
function modify(){

 document.forms[0].action="${ctx}/admin/aglientapply.do?method=personRegist4";
	document.forms[0].submit();
 }
 
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<title>个人情况预览页面</title>
	<link href="/clrcw/css/public.css" rel="stylesheet" type="text/css">
	<link href="/clrcw/css/mainframe.css" rel="stylesheet" type="text/css">
	<link href="/clrcw/css/modelist.css" rel="stylesheet" type="text/css">
	<link id="ABTStyle" href="/clrcw/css/skin.css" rel="stylesheet"
		type="text/css">
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css">
	<SCRIPT src="/clrcw/js/public.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="/clrcw/js/menu.js" type="text/javascript"></SCRIPT>
	<SCRIPT id="ABT" src="/clrcw/js/shanDong.js" type="text/javascript"></SCRIPT>
	<style>
	  #main{width:945px;_width:898px;}
	  ul#list1 li{margin-right:7px;}
	  ul#list1 {
	/* float: left; */
	/* padding:10px 0 0 0; */
}
	</style>
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
             
			<div id="content">
				<h2>
				
						个人用户【<%=personResume.getName()%>】信息&nbsp;&nbsp;
						<!--<a href="${ctx}/admin/aglientapply.do?method=aglientapply" style="color: #BD0403;">[退出]</a>
					--></h2>


				<div class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">

					<ul id="list1">
						<li class="liH1">
							&equiv;&nbsp;基本情况
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist8">&equiv;&nbsp;教育培训经历
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist4">&equiv;&nbsp;工作/实习经历
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist5">&equiv;&nbsp;自我评价
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personApplyList">&equiv;&nbsp;求职意向
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=resumeView" target="_blank">&equiv;&nbsp;个人简历预览</a>
						</li>
						<li> <a href="${ctx}/admin/aglientapply.do?method=showAll" >&equiv;&nbsp;职位搜索</a></li>
              <!-- li> <a href="${ctx}/personShowCompInfo.do?method=showCompInfo" >8. 企业招聘意向</a></li-->
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%; clear:both"></div>
				</div>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">

					<html:form action="/resume.do?method=resume" method="post"
						onsubmit="return validatePersonResumeForm(this);">
						<table class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							<TBODY>
								<tr>
									<td width="17%">
										真实姓名 :
									</td>
									<td width="33%" class="black"><%=personResume.getName()%>
									</td>
									<td width="17%" rowspan="5">
										个人照片:
									</td>
								<td width="33%" rowspan="5" class="black" align="center">
										<%
											if (request.getSession().getAttribute("version").equals("true")) {
										%>
										<html:img action="/photo.do?method=photo" width="200" height="200"/>
										<%
											} else {
										%>
										<img src="<%=request.getContextPath()%>/images/nophoto.gif"
											width="200" height="200" />
										<%
											}
										%>
									</td>
								</tr>
								<tr>
									<td>
										性 别：
									</td>
									<td class="black"><%=personResume.getSex()%>
									</td>
								</tr>
								<tr>
									<td>
										身份证号：
									</td>
									<td class="black"><%=personResume.getUser().getLoginId()%>
									</td>
								</tr>
								<tr>
									<td>
										出生日期：
									</td>
									<td class="black"><%=personResume.getBirthday()%>
									</td>
								</tr>
								<tr>
									<td>
										户籍所在地：
									</td>
									<td class="black">
									<%=personResume.getHomeplace() %>
											
									</td>
								</tr>
								<tr>
									<td>
										工作地区：
									</td>
									<td class="black" colspan="3">
									 <%if ("110101".equals(personResume.getServicearea())) {%> 东城区
											<%}%>
										
											<%if ("110102".equals(personResume.getServicearea())) {%> 西城区
											<%}%>
										
											<%if ("110105".equals(personResume.getServicearea())) {%> 朝阳区
											<%}%>
										
											 <%if ("110106".equals(personResume.getServicearea())) {%> 丰台区
											<%}%>
										
											 <%if ("110107".equals(personResume.getServicearea())) {%> 石景山区
											<%}%>
										
											 <%if ("110108".equals(personResume.getServicearea())) {%> 海淀区
											<%}%>
										
											 <%if ("110109".equals(personResume.getServicearea())) {%> 门头沟区
											<%}%>
										
											 <%if ("110110".equals(personResume.getServicearea())) {%> 燕山区
											<%}%>
										
											 <%if ("110111".equals(personResume.getServicearea())) {%> 房山区
											<%}%>
										
											 <%if ("110112".equals(personResume.getServicearea())) {%> 通州区
											<%}%>
										
											 <%if ("110113".equals(personResume.getServicearea())) {%> 顺义区
											<%}%>
										
											 <%if ("110114".equals(personResume.getServicearea())) {%> 昌平区
											<%}%>
										
											 <%if ("110115".equals(personResume.getServicearea())) {%> 大兴区
											<%}%>
										
											 <%if ("110116".equals(personResume.getServicearea())) {%> 怀柔区
											<%}%>
										
											 <%if ("110117".equals(personResume.getServicearea())) {%> 平谷区
											<%}%>
																		
										
											
									</td>
								</tr>
								<tr>
								<td>
										<label for="language2">
											政治面貌：
										</label>
									</td>
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
									<td>
										<label for="languagelevel2">
											婚姻状况：
										</label>
									</td>
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
									<td>
										<label for="dkind">
											残疾类别：
										</label>
									</td>
									<td class="black">
										<%=personResume.getDkind()%>
										
									</td>
									<td>
										<label for="dlevel">
											残疾程度：
										</label>
									</td>
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
									<td>
										<label for="language2">
											残疾情况：
										</label>
									</td>
									<td colspan="3" class="black">
										<%
											if (personResume.getParts() != null) {
														for (int i = 0; i < personResume.getParts().length(); i++) {
															System.out.println(personResume.getParts()
																	.charAt(i));

															if ("1".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>左上肢<%
											}
										%>
										<%
											if ("2".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>左下肢<%
											}
										%>
										<%
											if ("3".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>右上肢<%
											}
										%>
										<%
											if ("4".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>右下肢<%
											}
										%>
										<%
											if ("5".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>脊柱<%
											}
										%>
										<%
											if ("6".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>身体矮小<%
											}
										%>
										<%
											if ("7".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>使用助听器可以交流<%
											}
										%>
										<%
											if ("8".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>手语交流<%
											}
										%>
										<%
											if ("9".equals(personResume.getParts().charAt(i)
																	+ "")) {
										%>低视力<%
											}
														}
													}
										%>
										<%
											if (personResume.getOtherparts() != null) {
										%>其他：<%=personResume.getOtherparts()%>
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
									
								</tr>
								<tr>
									<td>
										最高学历：
									</td>
									<td class="black"><%=personResume.getEducate().getEducateName()%></td>
									<td>
										计算机水平：
									</td>
									<td class="black"><%=personResume.getCompLevel()%></td>
								</tr>
								<tr>
									<td>
										外语语种：
									</td>
									<td class="black"><%=personResume.getLang()%></td>
									<td>
										外语水平：
									</td>
									<td class="black"><%=personResume.getLevel1()%></td>
								</tr>
								<tr <%if(personResume.getLang2()==null||"".equals(personResume.getLang2())){%>
									style="display: none;"
								<%} %>>
									<td>
										外语语种2：
									</td>
									<td class="black"><%=personResume.getLang2()%></td>
									<td>
										外语水平2：
									</td>
									<td class="black"><%=personResume.getLevel2()%></td>
								</tr>
								<tr <%if(personResume.getLang3()==null||"".equals(personResume.getLang3())){%>
									style="display: none;"
								<%} %>>
									<td>
										外语语种3：
									</td>
									<td class="black"><%=personResume.getLang3()%></td>
									<td>
										外语水平3：
									</td>
									<td class="black"><%=personResume.getLevel3()%></td>
								</tr>
							  <tr>
									<TD>
										<LABEL for="qzdq">
											职业技能：
										</LABEL>
									</TD>
									<TD colspan="3" class="black">
										<textarea name="" cols="" rows="" readonly="readonly"><%=personResume.getSkill()%></textarea>
									</TD>
								</tr>
								<tr>
									<td>
										工作年限：
									</td>
									<td class="black"><%=personResume.getLimitYear()%></td>
									<td>
										<label for="languagelevel2">
											目前状态：
										</label>
									</td>
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
									
									<td>
										现在地址：
									</td>
									<td class="black" colspan="3"><%=personResume.getAddress()%></td>
								</tr>
								<tr>
									<td>
										联系电话：
									</td>
									<td class="black"><%=personResume.getPhone()%></td>
									<td>
										邮 编：
									</td>
									<td class="black"><%=personResume.getMailcode()%></td>
								</tr>
								<%
											 String notapply=(String)request.getAttribute("notapply");
										%>
								<tr>
									<td colspan="4" align="center">
										<a href="${ctx}/pages/admin/editResume.jsp"   ><img src="/clrcw/image/change.gif"
											alt="修改" /></a>
										<a href="${ctx}/admin/aglientapply.do?method=personRegist8"><img
												alt="下一步" src="/clrcw/image/change1.gif" /> </a>
									</td>
								</tr>
							</TBODY>
						</table>
					</html:form>
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
