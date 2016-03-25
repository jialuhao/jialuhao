<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<script language="JavaScript" type="text/JavaScript">
function checkform(a){ 
	intro = document.form1.intro.value;
	if(intro.length>500){
	     alert("自我评价长度必须小于500位字符");
	     return false;
	}
	if (intro.search(/^[0-9a-zA-Z\u4e00-\u9FA5.:/：!！;；:，。., ?？/、\r\n]+$/) < 0&&intro!=""){ 
		alert("自我评价包含非法字符"); 
		return false; 
	}
	interests = document.form1.interests.value;
	if(interests.length>500){
	     alert("兴趣特长长度必须小于500位字符");
	     return false;
	}
	if (interests.search(/^[0-9a-zA-Z\u4e00-\u9FA5.:/：!！;；:，。., ?？/、\r\n]+$/) < 0&&interests!=""){ 
		alert("兴趣特长包含非法字符"); 
		return false; 
	}
	if(a!='notapply'){
    var b = confirm("修改后您的简历信息将进入待审核状态"); 
    return b;
    }  
	alert("保存成功");
}	
</script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>自我评价填写</title>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />

	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script src="/clrcw/public/js/calendar.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>

</head>
<body>
	<div id="container">
		<!--<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		--><div id="main">
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
						<li class="liH1">
							&equiv;&nbsp;自我评价
						</li>
						<li>
							<a href="${ctx}/personApplyList.do?method=personApplyList">&equiv;&nbsp;欲求职位
							</a>
						</li>
						<li>
							<a href="${ctx}/resumeView.do?method=resumeView" target="_blank">&equiv;&nbsp;个人简历预览</a>
						</li>
						<li>
							<a href="${ctx}/personRegist9.do?method=showAll">&equiv;&nbsp;职位搜索</a>
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
				<%String notapply=(String)request.getAttribute("notapply"); %>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form name="form1" action="${ctx}/saveIntro.do?method=saveIntro"
						method="post" onSubmit="return checkform('${notapply}')">
						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0">


							<%
								String interests = request.getAttribute("interests") + "";
							%>
							<tr>
								<td width="146" valign="top" class="black">
									<label for="intro">
										兴趣特长：
									</label>
								</td>
								<td width="600" colspan="3" >
									<textarea name="interests" cols="50" rows="5" class="input5"
										id="interests" title="请输入兴趣特长"><%=interests.trim()%></textarea>
								</td>
							</tr>
							<tr>
								<%
									String ttt = request.getAttribute("intro") + "";
								%>
								<td width="146" valign="top" class="black">
									<label for="intro">
										自我评价：
									</label>
								</td>
								<td width="600" colspan="3" >
									<textarea name="intro" cols="50" rows="5" class="input5"
										id="intro" title="请输入自我评价"><%=ttt.trim()%></textarea>
								</td>
							</tr>
							<tr>
								<td height="35" colspan="4" align="center">
									<input type="submit" value="保存" />
							</tr>

						</table>
					</form>
				</div>
			</div>











		</div>




		<iframe src="/clrcw/public/include/footer.html" height="250"
			width="960" id="iframe_foot" frameborder="0" scrolling="no"
			title="底部脚本"></iframe>



	</div>
	<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
</html:html>
