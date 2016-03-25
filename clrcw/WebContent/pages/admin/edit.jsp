<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.PersonResumeB"%>
<%@ page import="model.PersonResume"%>
<script language="JavaScript" type="text/JavaScript">

function checkform(){
     
    stime = document.form2.stime.value;
    etime = document.form2.etime.value;
    post = document.form2.post.value;
    company = document.form2.company.value;
    work = document.form2.work.value;
    str11 = new Date(stime.replace("-", ",")).getTime()
    str22 = new Date(etime.replace("-", ",")).getTime()
    if(str11>=str22){
	     alert("结束时间必须大于开始时间");
	     return false;
	}
	 if(post.length>25||post.length<=0)
	   {
	     alert("职务/职位长度必须为1-25个字");
	     document.form2.post.focus();
	     return false;
	   }
	if (post.search(/^[0-9a-zA-Z\u4e00-\u9FA5()（）；，。;,.、]+$/) < 0){ 
	alert("职务/职位为空或包含非法字符"); 
	   document.form2.post.focus();
	return false; 
	}
	if(company.length>25||company.length<=0){
	     alert("工作单位长度必须为1-25位字符");
	     document.form2.company.focus();
	     return false;
	}
	if (company.search(/^[0-9a-zA-Z\u4e00-\u9FA5()（）；，。;,.、]+$/) < 0){ 
	alert("工作单位包含非法字符"); 
	document.form2.company.focus();
	return false; 
	}
	if(work.length>100||work.length<=0){
	     alert("工作内容长度必须为1-100位字符");
	     document.form2.work.focus();
	     return false;
	}
	if (work.search(/^[0-9a-zA-Z\u4e00-\u9FA5（） (),.:""，、。：“”@!?\r\n]+$/) < 0&&work!=""){ 
		alert("工作内容包含非法字符"); 
		document.form2.work.focus();
		return false;    
	}
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>工作/实习经历编辑</title>
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
							<a href="${ctx}/admin/aglientapply.do?method=personRegist3">&equiv;&nbsp;基本情况</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist8">&equiv;&nbsp;教育培训经历
							</a>
						</li>
						<li class="liH1">
							&equiv;&nbsp;工作/实习经历

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
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0; clear:both;">


					<form name="form2" action="${ctx}/admin/aglientapply.do?method=editResume"
						method="post" onSubmit="return checkform()">
						<%
							PersonResumeB personResumeB = (PersonResumeB) request.getSession()
										.getAttribute("resumeb");
						%>

						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0"
							style="border-top: #900 1px solid;">
							<tr>

								<TH class="th1" colspan="5" bgcolor="#990000"
										style="color: #fff;">
									填写新工作记录（点击保存，自动添加到工作/实习经历列表）
								</th>
							</tr>
							<tr>
								<td width="140"
										style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
									<label for="stime">
										起止时间：
									</label>
									<input type="hidden" Class="input3" id="rbid" name="rbid"
										value="<%=personResumeB.getId()%>" />
								</td>

								<td>
									自
									<input type="text" title="请选择开始时间" Class="input6" id="stime"
										name="stime" onClick="calendar.show(this);"
										readonly="readonly" value="<%=personResumeB.getStartTime()%>" />
									至
									<input type="text" Class="input6" id="etime" title="请选择结束时间"
										name="etime" onClick="calendar.show(this);"
										readonly="readonly" value="<%=personResumeB.getEndTime()%>" />
								</td>
							</tr>
							<tr>
								<td valign="top"
										style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
									<label for="company">
										工作单位：
									</label>
								</td>
								<td colspan="3">
									<input type="text" Class="w1" title="请输入工作单位,长度必须为1-25位字符" id="company"
										name="company" value="<%=personResumeB.getWorkUnit()%>" maxlength="25"/>
								</td>
							</tr>
							<tr>
								<td style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
									<label for="post">
										职务/职位：
									</label>
								</td>
								<td>
									<input type="text" Class="w1" title="请输入职务/职位,长度必须为1-25个字符" id="post"
										name="post" value="<%=personResumeB.getJob()%>" maxlength="25" />
								</td>
							</tr>
							
							<tr>
								<td valign="top"
										style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
									<label for="work">
										工作内容：
									</label>
								</td>  
								<td colspan="3">
									<textarea name="work" cols="45" title="请输入工作内容,长度必须为1-100位字符" rows="5"
										class="input5" id="work"><%=personResumeB.getWorkContent()%></textarea>
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
