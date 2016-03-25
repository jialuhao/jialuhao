<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PersonEducation"%>
<%@ page import="model.PersonResume"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<title>教育培训经历编辑</title>

	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />

	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script src="/clrcw/public/js/calendar.js" type="text/javascript"></script>


	<script language="JavaScript" type="text/JavaScript">
function edit(s_id){

window.location.href="${ctx}/admin/aglientapply.do?method=toUpdateEducation&id="+s_id;	
}
function del(s_id){

	var b = confirm("确实要删除吗？");
	if(b){
	    document.form1.delId.value=s_id;
		document.form1.submit();
	}else{
		return false;
	}
	}
	

function checkform(){ 

	stime = document.form2.stime.value;
	etime = document.form2.etime.value;
	schoolname = document.form2.schoolname.value;
	education = document.form2.education.value;
	profession = document.form2.profession.value;
	str11=new Date(stime.replace("-",",")).getTime() 
	str22=new Date(etime.replace("-",",")).getTime() 
	if(etime.length<=0){
	 alert("结束时间不能为空");
	     return false;
	}
	if(str11>=str22){
	     alert("结束时间必须大于开始时间");
	     return false;
	}
	if(schoolname.length>25||schoolname<=0){
	     alert("毕业院校/机构长度必须为1-25位字符");
	     document.form2.schoolname.focus();
	     return false;
	}
	if (schoolname.search(/^[0-9a-zA-Z\u4e00-\u9FA5()（）]+$/) < 0){ 
	alert("毕业院校/机构包含非法字符"); 
	document.form2.schoolname.focus();
	return false; 
	}
	if(profession.length>50){
	     alert("所学专业长度必须小于50位字符");
	     document.form2.profession.focus();
	     return false;
	}
	if (profession.length<=0){ 
		alert("所学专业不能为空"); 
		document.form2.profession.focus();
		return false; 
	}
	if (profession.search(/^[0-9a-zA-Z\u4e00-\u9FA5 ()（）；，。;,.、]+$/) < 0&&profession!=""){ 
		alert("所学专业包含非法字符"); 
		document.form2.profession.focus();
		return false; 
	}
	 if(education.length>50||education.length<=0)
	   {
	     alert("学历/学位长度必须为1-50个字");
	     document.form2.education.focus();
	     return false;
	   }
	   
	if (education.search(/^[0-9a-zA-Z\u4e00-\u9FA5 ()（）；，。;,.、]+$/) < 0){ 
	alert("学历/学位为空或包含非法字符"); 
	   document.form2.education.focus();
	return false; 
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

			<table width="730" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="5">
					</td>
				</tr>
			</table>

			<div id="content">
<%
	
	PersonResume personResume = (PersonResume) request.getSession()
			.getAttribute("pr");
%>
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
						<li class="liH1">
							&equiv;&nbsp;教育培训经历
							
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
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=showAll">&equiv;&nbsp;
								职位搜索</a>
						</li>
						<!-- li>
							<a href="${ctx}/personShowCompInfo.do?method=showCompInfo">&equiv;&nbsp;
								企业招聘意向</a>
						</li-->
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form action="${ctx}/admin/aglientapply.do?method=delPersonEducation" name="form1"
						method="POST">
						<table class="finktable" id="jbqk" summary="个人招聘信息">
  
							<tr>
								<html:hidden property="delId" value="" />
								<TH class="th1" colspan="5" bgcolor="#990000"
									style="color: #fff;">
									教育培训经历列表（点击编辑可进入编辑页面修改）
								</TH>
							</TR>

							<tr>
								<TD width="200" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									起止时间
								</td>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									毕业院校/机构
								</td>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									所学专业
								</td>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									学历/学位/获得证书
								</td>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									操 作
								</td>
							</tr>

							<%
							
								List list = (List) request.getSession().getAttribute("education");
									for (int i = 0; i < list.size(); i++) {
										PersonEducation personEducation = (PersonEducation) list
												.get(i);
										String content = "";
										if (personEducation.getProfession().length() > 8) {
											content = personEducation.getProfession().substring(0,
													8)
													+ "....";
										} else {
											content = personEducation.getProfession();
										}
							%>
							<tr>
								<td width="148" nowrap="nowrap"
									style="color: #000000; font-size: 12px;" align="center"><%=personEducation.getStartTime() + ""%>至<%=personEducation.getEndTime() + ""%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center"
									title="<%=personEducation.getSchoolname() + ""%>"><%=personEducation.getSchoolname()%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center"
									title="<%=personEducation.getProfession() + ""%>"><%=content%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center"    
									title="<%=personEducation.getEducation()%>"><%=personEducation.getEducation()%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center">
									<a   href="#"  onclick="edit('<%=personEducation.getId()%>')"
										
										class="tabBtn">编辑</a>
									<a href="#" onClick="del('<%=personEducation.getId()%>')"
										class="tabBtn">删除</a>
								</td>
							</tr>

							<%
								}
							%>
						</table>

					</form>

					<div style="height: 30px;"></div>
                                

					<form name="form2"
						action="${ctx}/admin/aglientapply.do?method=personRegist8_1"
						
						method="post" onSubmit="return checkform()">
						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0" style="border-top: 0;">
							<tr>

								<TH class="th1" colspan="5" bgcolor="#990000"
									style="color: #fff;">
									填写教育培训经历（点击保存，自动添加到教育培训经历列表）
								</TH>
							</TR>

							<tr>
								<TD class="black">
									<LABEL for="stime">
										起止时间：
									</LABEL>
								</TD>


								<td>
									自
									<input type="text" title="请选择开始时间" id="stime" name="stime"
										onClick="calendar.show(this);" readonly="readonly"
										value="<%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar
						.getInstance().getTime())%>"
										width="80px" />
									<label for="etime">
										至
									</label>
									<input type="text" title="请选择结束时间" id="etime" name="etime"
										onClick="calendar.show(this);" readonly="readonly"
										value="<%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar
						.getInstance().getTime())%>" />
								</td>
							</tr>
							<tr>
								<TD valign="top" class="black">
									<LABEL for="schoolname">
										毕业院校/机构：
									</LABEL>
								</TD>

								<td colspan="3">
									<input type="text" title="请输入毕业院校/机构，长度必须为1-25位字符" class="w1"
										id="schoolname" name="schoolname" />*
								</td>
							</tr>
							<tr>
								<TD width="100" valign="top" class="black">
									<LABEL for="education">
										所学专业：
									</LABEL>
								</TD>

								<td colspan="3">
									<input type="text" name="profession" class="w1" title="请输入所学专业，长度必须小于50位字符"
										id="profession" />*
								</td>
							</tr>
							<tr>
								<TD width="140" class="black">
									<LABEL for="education">
										学历/学位/获得证书：
									</LABEL>
								</TD>

								<td>
									<input type="text" title="请输入学历/学位/获得证书，长度必须为1-50个字" class="w1"
										id="education" name="education" maxlength="50"/>*
								</td>
							</tr>
							
							<tr>
								<td height="35" align="center" colspan="3">
									<input type="submit" value="添加" class="btn1" />

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
