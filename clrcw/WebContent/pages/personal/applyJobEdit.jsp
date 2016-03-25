<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.ApplyJobInfo"%>
<%@ page import="model.BdJob"%>
<%@ page import="model.BdPost"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>欲求职位编辑</title>


</head>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css"
		href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css"
		href="/clrcw/css/modelist.css" />

	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="/clrcw/js/lhgdialog.min.js"></script>
	
<script language="JavaScript" type="text/JavaScript">
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
  var b = confirm("修改后您的简历信息将进入待审核状态"); 
 if(!b){
    return false;
    }
 
}
</script>
<script type="text/javascript">
$(function(){
	$('#hangye').dialog({
	width:'600px',
	height:'420px',  
	fixed: true,
	title: '选择行业',
	lock: true ,
    content: 'url:/clrcw/showTradeall.do?method=showTradeAll&postid='+$("#post").val()
	});
});
$(function(){

	$('#zhiye').dialog({
	width:'800px',
	height:'420px',   
	fixed: true,
	title: '选择职业',
	lock: true,
    content: 'url:showJoball.do?method=showJobAll&jobid='+$("#job").val()
	});
});

$(function(){

	$('#quyu').dialog({
	width:'800px',
	height:'420px',   
	fixed: true,
	title: '选择区域',
	lock: true,
    content: 'url:showQuyuall.do?method=showQuyuAll&quyu='+$("#workyears").val()
	});
});

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


			<table width="740" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="15">
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
						<li>
							<a href="${ctx}/personRegist4.do?method=personRegist4">&equiv;&nbsp;工作/实习经历</a>
						</li>
						<li>
							<a href="${ctx}/personRegist5.do?method=personRegist5">&equiv;&nbsp;自我评价</a>
						</li>
						<li class="liH1">
							&equiv;&nbsp;欲求职位

						</li>
						<li>
							<a href="${ctx}/resumeView.do?method=resumeView" target="_blank">&equiv;&nbsp;个人简历预览</a>
						</li>
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form name="form2"
						action="${ctx}/applyJobEdit.do?method=applyJobEdit" method="post"
						onSubmit="return checkform()">
						<TABLE class="finktable" id="jbqk" width="100%" border="0"
							cellspacing="0" cellpadding="0" style="border-top: 0;">
							<tr>
								<TH class="th1" colspan="5" bgcolor="#990000"
									style="color: #fff;">
									修改欲求职位（点击保存，自动更新到欲求职位列表）
								</th>
							</tr>
							<%
								ApplyJobInfo applyJobInfo = (ApplyJobInfo) request
											.getAttribute("apply");
							%>
							<tr>
								<td width="152" valign="top"
									style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
									<label for="post">
										期望从事行业：
									</label>
								</td>
								<td width="270" class="font5">
									<input type="text" id="hangyetext" readonly="readonly" value="<%=applyJobInfo.getPostCode().getTradeName()%>"/>
									<input type="hidden" name="post" id="post"  value="<%=applyJobInfo.getPostCode().getId()%>"/>
									<A href="###" id="hangye" >选择行业&nbsp;▼</A>
								</td>
								<td width="100" valign="top"
									style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
									<label for="job">
										期望从事职业：
									</label>
								</td>
								<td class="font5">
									<input type="text" id="zhiyetext" readonly="readonly" value="<%=applyJobInfo.getJobCode().getJobName()%>"/>
									<input type="hidden" name="job" id="job" value="<%=applyJobInfo.getJobCode().getId()%>"/>
									<A href="###" id="zhiye">选择职业&nbsp;▼</A>
								</td>
							</tr>
							<tr>
								<td valign="top"
									style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
									<label for="workyears">
										期望工作区域：
									</label>
								</td>
								<td>
									<input type="text" Class="input6"
										id="workyears" name="workyears"
										value="<%=applyJobInfo.getWorkYear()%>" readonly="readonly"/>
									<A href="###" id="quyu">选择区域&nbsp;▼</A>
								</td>
								<td valign="top"
									style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 12px;">
									<label for="salary">
										期望月薪（税前）：
									</label>
								</td>
								<td>
									<bean:define id="salarys" name="salarylist" type="java.util.List" />
									<html:select property="salary" value="<%=applyJobInfo.getSalary()%>">
										<html:options collection="salarys" property="salaryname" 
											labelProperty="salaryname" />
									</html:select>
										
									
								</td>
							</tr>
							<tr>
								<td height="35" align="center" colspan="5">
									<input type="submit" value="保存" Class="input4" />
								<input type="button" onclick="history.go(-1)" Class="input4" value="返回" />
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
