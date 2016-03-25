<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业用户修改密码</title>
<link href="${ctx}/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" charset="utf-8" src="${ctx}/public/js/asop/util.js"></script>	
<script type="text/javascript" charset="utf-8" src="${ctx}/public/js/asop/password.js"></script>

<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/mainframe.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/modelist.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
<link rel="stylesheet" type="text/css" id="ABTStyle" href="/clrcw/styles/skin.css" />
<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>

</head>
<body>
<div id="container">
<div id="header">
 <iframe id="iframe_head" src="http://211.99.136.80/headindex.html" frameborder="0" scrolling="no"
	height="150" width="960"> </iframe>
	</div>
  <div id="main">


<div id="content">
    	<h2>企业[${compUserId}]招聘    &nbsp;&nbsp;<a href="javascript:history.back();" style="color:#BD0403;">[返回]</a><a href="${ctx}/companyLogin.do?method=loginOut" style="color:#BD0403;">[退出]</a></h2>
        <div class="formdiv"  align="center">

						<table class="finktable"  summary="企业招聘信息"  align="center">
							<tr>
								<td height="15" colspan="2"><font color="red"><html:errors property="noUser"/></font></td>
							</tr>
						

						<html:form
							action="/companyModifyPassword.do" method="post"
							onsubmit="return checkform(this);">
							
								<tr>
									<td width="230" align="left"><label for="password">&nbsp;&nbsp;&nbsp;原密码：</label></td>
									<td ><input type="password" name="password"  id="password" value="" class="input3"> <font color="red">*</font></td>
								</tr>
								<tr>
									<td width="230"  align="left"><label for="newPassword">&nbsp;&nbsp;&nbsp;新密码：</label></td>
									<td ><input type="password" name="newPassword" id="newPassword" class="input3"/> <font color="red">*</font></td>
								</tr>
								<tr>
									<td width="230" align="left"><label for="newPassword2">&nbsp;&nbsp;&nbsp;新密码确认：</td>
									<td >
									<input type="password" name="newPassword2" id="newPassword2" class="input3"/>	 <font color="red">*</font></td>
								</tr>
								<tr>
									<td colspan="2" align="center" ><html:submit
										property="submit" value="保存" styleClass="input4" /> <html:reset
										property="reset" value="重置" styleClass="input4" /></td>
								</tr>
							</table>
						</html:form></td>
					</tr>
					
				</table>
				
	


</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
  

</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>


</body>
</html:html>
