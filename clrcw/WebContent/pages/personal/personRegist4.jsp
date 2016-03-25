<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PersonResumeB"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<title>工作/实习经历</title>

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
function edit(s_id,e){
if(e!='notapply'){
var b=confirm("确定要修改吗？修改后您的简历信息将进入待审核状态");
if(b){
window.location.href="${ctx}/showResume.do?method=showResume&id="+s_id;
}
}else{
window.location.href="${ctx}/showResume.do?method=showResume&id="+s_id;
}
		
}
function del(s_id,e){
if(e=='notapply'){
	var b = confirm("确实要删除吗？");
	if(b){
	    document.form1.delId.value=s_id;
		document.form1.submit();
	}else{
		return false;
	}
	}else{
	var b = confirm("确实要删除吗？,删除后简历信息进入待审核状态");
	if(b){
	    document.form1.delId.value=s_id;
		document.form1.submit();
	}else{
		return false;
	}
	}
}
function checkform(a){ 
	stime = document.form2.stime.value;
	etime = document.form2.etime.value;
	post = document.form2.post.value;
	company = document.form2.company.value;
	work = document.form2.work.value;
	str11=new Date(stime.replace("-",",")).getTime() 
	str22=new Date(etime.replace("-",",")).getTime() 
	if(str11>=str22){
	     alert("结束时间必须大于开始时间");
	     return false;
	}
	 if(post.length>25||post.length<=0)
	   {
	     alert("职务/职位长度必须为1-25个字符");
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
	if(a!='notapply'){
    var b = confirm("修改后您的简历信息将进入待审核状态"); 
    return b;
    }  
}	
</script>


</head>
<body>
	<div id="container">
		<!--<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		--><div id="main">

			<table width="730" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="5">
					</td>
				</tr>
			</table>

			<div id="content">

				<h2>
					个人用户【${personUserId}】信息&nbsp;&nbsp;
					<a href="${ctx}/logout.do?method=logout" style="color: #BD0403;">[退出]</a>
				</h2>
				<DIV class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li>
							<a href="${ctx}/personRegist3.do?method=personRegist3">&equiv;&nbsp;基本情况</a>
						</li>
						<li>
							<a href="${ctx}/personRegist8.do?method=personRegist8">&equiv;&nbsp;教育培训经历
							</a>
						</li>
						<li class="liH1">
							&equiv;&nbsp;工作/实习经历

						</li>
						<li>
							<a href="${ctx}/personRegist5.do?method=personRegist5">&equiv;&nbsp;自我评价
							</a>
						</li>
						<li>
							<a href="${ctx}/personApplyList.do?method=personApplyList">&equiv;&nbsp;求职意向
							</a>
						</li>
						<li>
							<a href="${ctx}/resumeView.do?method=resumeView" target="_blank">&equiv;&nbsp;个人简历预览</a>
						</li>
						<li>
							<a href="${ctx}/personRegist9.do?method=showAll">&equiv;&nbsp;职位搜索</a>
						</li>
						<!-- li> <a href="${ctx}/personRegist9.do?method=showAll" >7. 职位搜索</a></li>
              <li> <a href="${ctx}/personShowCompInfo.do?method=showCompInfo" >8. 企业招聘意向</a></li-->
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form action="${ctx}/delResume.do?method=delResume" name="form1"
						method="POST">
						<table class="finktable" id="jbqk" summary="个人招聘信息">

							<tr>
								<html:hidden property="delId" value="" />
								<TH class="th1" colspan="5" bgcolor="#990000"
									style="color: #fff;">
									工作/实习经历列表（点击编辑可进入编辑页面修改）
								</th>
							</tr>
							<TR>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									起止时间
								</TD>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									工作单位
								</TD>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									职务/职位
								</TD>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									工作内容
								</TD>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									操 作
								</TD>
							</TR>
							<%  String notapply=(String)request.getAttribute("notapply");
								List<?> list = (List<?>) request.getAttribute("resumeb");
									for (int i = 0; i < list.size(); i++) {
										PersonResumeB personResumeB = (PersonResumeB) list.get(i);
										String content = "";
										if (personResumeB.getWorkContent() != null
												&& personResumeB.getWorkContent().length() > 8) {
											content = personResumeB.getWorkContent()
													.substring(0, 8)
													+ "....";
										} else {
											content = personResumeB.getWorkContent();
										}

										String gzdw = "";
										if (personResumeB.getWorkUnit() != null
												&& (personResumeB.getWorkUnit() + "").length() > 8) {
											gzdw = (personResumeB.getWorkUnit() + "").substring(0,
													8)
													+ "....";
										} else {
											gzdw = personResumeB.getWorkUnit() + "";
										}

										String job = "";
										if (personResumeB.getJob() != null
												&& (personResumeB.getJob() + "").length() > 8) {
											job = (personResumeB.getJob() + "").substring(0, 8)
													+ "....";
										} else {
											job = personResumeB.getJob() + "";
										}
							%>
							<tr>
								<td width="148" nowrap="nowrap"
									style="color: #000000; font-size: 12px;" align="center"><%=personResumeB.getStartTime() + ""%>至<%=personResumeB.getEndTime() + ""%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center"
									title="<%=personResumeB.getWorkUnit() + ""%>"><%=gzdw%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center"
									title="<%=personResumeB.getJob() + ""%>"><%=job%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center"
									title="<%=personResumeB.getWorkContent()%>"><%=content%></td>
								<td width="148" style="color: #000000; font-size: 12px;"
									nowrap="nowrap" align="center">
									<a href="#" onClick="edit('<%=personResumeB.getId()%>','${notapply}')"
										
										class="tabBtn">编辑</a>
									<a href="#" onClick="del('<%=personResumeB.getId()%>','${notapply}')"
										class="tabBtn">删除</a>
								</td>
							</tr>

							<%
								}
							%>
						</table>

					</form>

					<div style="width: 740px; height: 50px;"></div>

					<form name="form2"
						action="${ctx}/personRegist4_1.do?method=personRegist4_1"
						method="post" onSubmit="return checkform('${notapply}')">
						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0"
							style="border-top: #900 1px solid;">
							<TBODY>
								<tr>

									<TH class="th1" colspan="5" bgcolor="#990000"
										style="color: #fff;">
										填写新工作记录（点击保存，自动添加到工作/实习经历列表）
									</TH>
								</tr>
								<tr>
									<TD width="140"
										style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
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
									<TD valign="top"
										style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
										<LABEL for="company">
											工作单位：
										</LABEL>
									</TD>
									<td colspan="3">
										<input type="text" title="请输入工作单位,长度必须为1-25位字符" class="w1" id="company"
											name="company" />*
									</td>
								</tr>
								<tr>
									<TD
										style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
										<LABEL for="post">
											职务/职位：
										</LABEL>
									</TD>

									<td>
										<input type="text" title="请输入职务/职位,长度必须为1-25个字符" class="w1" id="post"
											name="post" />*
									</td>
								</tr>

								<tr>
									<TD valign="top"
										style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
										class="black">
										<LABEL for="work">
											工作内容：
										</LABEL>
									</TD>
									<td colspan="3">
										<textarea name="work" title="请输入工作内容,长度必须为1-100位字符" cols="45" rows="5"
											id="work"></textarea>*
									</td>
								</tr>
								<tr>
									<td height="35" align="center" colspan="3">
										<input type="submit" value="保存" Class="input4" />

									</td>
								</tr>
							</TBODY>
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
