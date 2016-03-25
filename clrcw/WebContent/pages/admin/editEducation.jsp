<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.PersonEducation"%>
<%@ page import="model.PersonResume"%>
<script language="JavaScript" type="text/JavaScript">

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
	if (profession.search(/^[0-9a-zA-Z\u4e00-\u9FA5 ()（）；，。;,.、]+$/) < 0&&profession!=""){ 
		alert("所学专业包含非法字符"); 
		document.form2.profession.focus();
		return false; 
	}
	if (profession.length<=0){ 
		alert("所学专业不能为空"); 
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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>教育培训经历编辑</title>
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

			<table width="730" border="0" align="center" cellpadding="0"
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
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%; clear:both;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">

					<form name="form2"
						action="${ctx}/admin/aglientapply.do?method=editPersonEducation"
						method="post" onSubmit="return checkform()">
						<%
							PersonEducation personEducation = (PersonEducation) request.getSession()
										.getAttribute("education");
						%>

						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0" style="border-top: 0;">
							<tr>

								<TH class="th1" colspan="5" bgcolor="#990000"
									style="color: #fff;">
									修改工作记录（点击保存，自动更新到工作/实习经历列表）
								</th>
							</tr>
							<tr>
								<td>
									<label for="stime">
										起止时间：
									</label>
									<input type="hidden" Class="input3" id="rbid" name="rbid"
										value="<%=personEducation.getId()%>" />
								</td>

								<td>
									自
									<input type="text" title="请选择开始时间" class="input6" id="stime"
										name="stime" onClick="calendar.show(this);"
										readonly="readonly"
										value="<%=personEducation.getStartTime()%>" />
									至
									<input type="text" Class="input6" id="etime" title="请选择结束时间"
										name="etime" onClick="calendar.show(this);"
										readonly="readonly" value="<%=personEducation.getEndTime()%>" />
								</td>
							</tr>
							
							<tr>
								<td valign="top">
									<label for="schoolname">
										毕业院校/机构名称：
									</label>
								</td>
								<td colspan="3">
									<input type="text" class="w1" title="请输入毕业院校/机构，长度必须为1-25位字符"
										id="schoolname" name="schoolname"
										value="<%=personEducation.getSchoolname()%>" />*
								</td>
							</tr>
							<tr>

								<td width="100" valign="top">
									<label for="profession">
										所学专业：
									</label>
								</td>
								<td colspan="3">
									<input type="text" class="w1" name="profession" title="请输入所学专业，长度必须小于50位字符"
										id="profession" value="<%=personEducation.getProfession()%>" />*
								</td>

							</tr>
							<tr>
								<td width="90">
									<label for="education">
										学历/学位/获得证书：
									</label>
								</td>
								<td>
									<input type="text" class="w1"  title="请输入学历/学位/获得证书，长度必须为1-50个字"
										id="education" name="education"
										value="<%=personEducation.getEducation()%>" maxlength="50" />*
								</td>
							</tr>
							<tr>
								<td height="35" align="center" colspan="3">
									<input type="submit" value="保存" Class="input4" />
									<input type="button" value="返回" onClick="history.go(-1)"
										Class="input4" />

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
