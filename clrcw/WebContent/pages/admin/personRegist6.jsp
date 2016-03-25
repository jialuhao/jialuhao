<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<title>求职意向编辑</title>
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle" href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="/clrcw/js/lhgdialog.min.js"></script>
	<script type="text/javascript">
$(function(){
	$('#hangye').dialog({
	width:'600px',
	height:'420px',  
	fixed: true,
	title: '选择行业',
	lock: true ,
    content: 'url:/clrcw/showTradeall.do?method=showTradeAll'
	});
});
$(function(){

	$('#zhiye').dialog({
	width:'600px',
	height:'320px',   
	fixed: true,
	title: '选择职业',
	lock: false,
    content: 'url:/clrcw/showJoball.do?method=showJobAll'
	});
});

$(function(){

	$('#quyu').dialog({
	width:'800px',
	height:'420px',   
	fixed: true,
	title: '选择区域',
	lock: false,
	
    content: 'url:/clrcw/showQuyuall.do?method=showQuyuAll'
	});
});

</script>

	<script language="JavaScript" type="text/JavaScript">
function edit(s_id){
	var id = s_id;
	var rets = window.showModalDialog("${ctx}/pages/personal/Frame1.jsp",id,"dialogHeight:330px;dialogWidth:450px");
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
	post = document.form2.post.value;
	workyears = document.form2.workyears.value;   
	job= document.form2.job.value;
	if(post==""||post.length<=0){
	     alert("请选择期望从事行业");
	     document.form2.post.focus();
	     return false;
	}
	if (job==""||job.length<=0){ 
	
		alert("请选择期望从事职业");
		document.form2.job.focus();             
		return false; 
	}
	if (workyears==""||workyears.length<=0){ 
		alert("请选择期望工作区域");
		document.form2.workyears.focus(); 
		return false; 
	}
	
}	

</script>
</head>
<body>
	<div id="container">
		<div id="header">
	
		</div>
		<div id="main">
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
							<a href="${ctx}/admin/aglientapply.do?method=personRegist3">&equiv;&nbsp;基本情况</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist8">&equiv;&nbsp;教育培训经历
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist4">&equiv;&nbsp;工作/实习经历</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=personRegist5">&equiv;&nbsp;自我评价</a>
						</li>
						<li class="liH1">
							&equiv;&nbsp;欲求职位

						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=resumeView" target="_blank">&equiv;&nbsp;个人简历预览</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientapply.do?method=showAll">&equiv;&nbsp;职位搜索</a>
						</li>
						<!-- li>
							<a href="${ctx}/personRegist9.do?method=showAll" target="_blank">
								职位搜索</a>
						</li>
						<li>
							<a href="${ctx}/personShowCompInfo.do?method=showCompInfo">
								企业招聘意向</a>
						</li> -->
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form action="${ctx}/admin/aglientapply.do?method=delApply" name="form1" method="post">
						<TABLE class="finktable" id="jbqk" width="100%" border="0"
							cellspacing="0" cellpadding="0" style="border-top: 0;">
							<tr>
								<TH class="th1" colspan="6" bgcolor="#990000"
									style="color: #fff;">
									求职意向列表（点击编辑，可进入修改页面）

									<input type="hidden" Class="input3" id="delId" name="delId"
										value="" />
								</th>
							</tr>
							<TR>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									期望从事行业
								</TD>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									期望从事职业
								</TD>
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									期望工作区域
								</TD>
								
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									预期月薪（税前）
								</TD>
								
								<TD width="140" align="center"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: bold;"
									class="black">
									操作
								</TD>
							</TR>

								<%     
									List vvv = (List) request.getSession().getAttribute("allapply");
										for (int i = 0; i < vvv.size(); i++) {
											Object[] ttt = (Object[]) vvv.get(i);
											ApplyJobInfo applyJobInfo = (ApplyJobInfo) ttt[0];
								
				 

								%>
							
							<tr>
								<td align="center" style="color: #000000; font-size: 12px;"><%=applyJobInfo.getPostCode().getTradeName()%></td>
								<td align="center" style="color: #000000; font-size: 12px;"><%=applyJobInfo.getJobCode().getJobName()%></td>
								<td align="center" style="color: #000000; font-size: 12px;"><%=applyJobInfo.getWorkYear()%></td>
								<td align="center" style="color: #000000; font-size: 12px;"><%=applyJobInfo.getSalary()%></td>
							
						
								
								<td align="center" style="color: #000000; font-size: 12px;">
									<a
										href="${ctx}/admin/aglientapply.do?method=showOneApplyJob&apllyId=<%=applyJobInfo.getId()%>"
										 class="tabBtn">编辑</a>
									<a href="#" onClick="del(<%=applyJobInfo.getId()%>)" class="tabBtn">删除</a>
								</td>
								
							</tr>
							<%
								}
							%>

						</table>

					</form>
					<div style="width: 740px; height: 50px;"></div>
					<form name="form2"
						action="${ctx}/admin/aglientapply.do?method=personRegist6"
						method="post" onSubmit="return checkform()">
						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0"
							style="border-top: #900 1px solid;">
							<TR>
								<TH class="th1 black" colspan="5">
									填写欲求职位（点击保存，自动添加到欲求职位列表）
								</TH>
							</TR>
							<tr>
								<TD width="140"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
									class="black">
									<LABEL for="post">
										期望从事行业：
									</LABEL>
								</TD>

								<td width="270">
									<input type="text" id="hangyetext" readonly="readonly"/>
									<input type="hidden" name="post" id="post"/>
									<A href="###" id="hangye" >选择行业&nbsp;▼</A>
								</td>
								<TD width="140"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
									class="black">
									<LABEL for="job">
										期望从事职业：
									</LABEL>
								</TD>
								<td>
									<input type="text" id="zhiyetext" readonly="readonly"/>
									<input type="hidden" name="job" id="job"/>
									<A href="###" id="zhiye">选择职业&nbsp;▼</A>
								</td>
							</tr>
							<tr>
								<TD valign="top"
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
									class="black">
									<LABEL for="workyears">
										期望工作区域：
									</LABEL>
								</TD>
								<td>
									<input type="text" title=""
										id="workyears" name="workyears" readonly="readonly"/>
									<A href="###" id="quyu">选择区域&nbsp;▼</A>
								</td>
								<TD
									style="padding: 10px; color: rgb(110, 31, 0); font-size: 12px; font-weight: normal;"
									class="black">
									<LABEL for="salary">
										预期月薪（税前）：
									</LABEL>
								</TD>
								<td>
									<select name="salary" id="salary" title="请选择期望月薪">
										<%
													List salarylist = (List) request.getSession().getAttribute("salarylist");
																for (int i = 0; i < salarylist.size(); i++) {
																	BdSalary salary = (BdSalary) salarylist.get(i);
														%>
														<option value="<%=salary.getSalaryname()%>"><%=salary.getSalaryname()%></option>
														<%
															}
														%>
									</select>
								</td>
							</tr>
							<tr>
								<td height="35" align="center" colspan="5">
									<input type="submit" value="保存" class="btn1" />
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
</html>
