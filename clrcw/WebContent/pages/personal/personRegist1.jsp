<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" language="javascript"
		src="/clrcw/scripts/jquery-1.7.1.js"></script>
	<script language="JavaScript" type="text/JavaScript">
function logout(){
 document.form1.action="${ctx}/logout.do?method=logout";
 document.form1.submit();
}
function checkform(){ 
	username = document.form1.username.value;//这里的username是一个page的对像,作用来取得文本框page的值

	if(username.length<6||username.length>20) {
	    alert("用户名长度必须在6位到20位之间");
	    document.form1.username.value=username; 
	    document.form1.username.focus();
	    return false;
    }
	if (username.search(/^[0-9a-zA-Z]+$/) < 0){ 
		alert("用户名只能为数字或字母"); 
		document.form1.username.value=username; 
		document.form1.username.focus();
		return false; 
	}   
	password = document.form1.password.value;
	if(password.length<6||password.length>10) {
		alert("密码长度必须在6位到10位之间");
		document.form1.password.focus();
		return false;
	}
	if (password.search(/^[0-9a-zA-Z]+$/) < 0){ 
		alert("密码只能为数字或字母"); 
		document.form1.password.focus();
		return false; 
	} 

	password2=document.form1.password2.value;
	if(password!=password2) {
		alert("密码不匹配");
	    document.form1.password.focus();
	    return false;
   	}
 	var email = document.form1.email.value;

    var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    flag=pattern.test(email);
    if (flag) {
		//document.form1.submit();
    	return true;
    }else{
        alert('请输入30位字符以内的有效邮箱地址！');
        return false;
    }  
return true;
	
} 

function eduti(){

	 document.form1.username.focus();
}
</script>

	<link href="/clrcw/css/public.css" rel="stylesheet" type="text/css">
	<link href="/clrcw/css/mainframe.css" rel="stylesheet" type="text/css">
	<link href="/clrcw/css/modelist.css" rel="stylesheet" type="text/css">
	<link id="ABTStyle" href="/clrcw/css/skin.css" rel="stylesheet"
		type="text/css">
	<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css">
	<SCRIPT src="/clrcw/js/public.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="/clrcw/js/menu.js" type="text/javascript"></SCRIPT>
	<SCRIPT id="ABT" src="/clrcw/js/shanDong.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="/clrcw/js/calendar.js" type="text/javascript"></SCRIPT>
	<title>个人用户注册</title>
</head>

<body onload="eduti()">
	<div id="container">
		<!--<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		--><div id="main">
			<div id="content">
				<h2>
					个人用户注册
				</h2>
				<div class="formdiv"
					style="margin-top: -31px; padding: 30px; border: 0;">
					<form name="form1"
						action="${ctx}/personRegist1.do?method=personRegist1"
						method="post">
						<table class="finktable" id="newtable" width="100%" border="0"
							cellspacing="0" cellpadding="0" style="border-top: 0;">
							<style type="text/css">
#newtable th.h2_table {
	width: auto;
	color: #BD0403;
	font-size: 14px;
	padding: 10px;
	font-weight: bold;
}

#newtable td input {
	width: 250px
}
</style>
							<tbody>
								<tr>
									<th colspan="2" class="h2_table" style="" align="left">
										<font size="6" style="float: left;">❷</font>&nbsp;个人用户注册
										<font size="2">（带*为必填项）</font>
									</th>
								</tr>
								<tr>
									<th align="center" class="black" width="150">
										<label for="username"
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
											用户登录名：
										</label>
									</th>
									<td>
										<input type="text" title="请输入用户名,6-20位字母、数字或组合" name="username"
											id="username" />
										<font color="#333333" style="font-size: 12px;">
											*6-20位字母、数字或组合。</font>
											<br>
										<font color="red"><html:errors property="user" /></font>
									</td>
								</tr>
								<tr>
									<th align="center">
										<label for="password"
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
											用户密码：
										</label>
									</th>
									<td>
										<input type="password" name="password" id="password"
											title="请输入密码,密码为数字或字母,并且密码长度6位到10位之间" />
										<font color="#333333" style="font-size: 12px;">
											*密码为数字或字母,并且密码长度6位到10位之间。</font>
										
									</td>
								</tr>
								<tr>
									<th align="center">
										<label for="password2"
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
											确认密码：
										</label>
									</th>
									<td>
										<input type="password" name="password2" id="password2"
											title="请确认密码" />
										<font color="#333333" style="font-size: 12px;">
											*确保密码输入正确。</font>
									</td>
								</tr>
								<tr>
									<th align="center">
										<label for="email"
											style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
											电子邮件：
										</label>
									</th>
									<td>
										<input type="text" name="email" id="email" maxlength="30"
											title="请输入电子邮件地址,30位字符以内的有效邮箱地址" />
										<font color="#333333" style="font-size: 12px;">
											*请输入30位字符以内的有效邮箱地址。</font>
									</td>
								</tr>
								<tr>
									
									<th colspan="2" style="width: auto; text-align: center;">
									
									<input name="" type="image" style="padding: 10px;"
											src="/clrcw/image/new_zc.gif" onClick="return checkform();" />
										
										<input name="" type="image" style="padding: 10px;"
											src="/clrcw/image/new_tc.gif" onClick="return logout();" />	
										
												
									</th>
									
								</tr>
							</tbody>
						</table>
					</form>


				</div>
			</div>
		</div>

	</div>


	<iframe src="/clrcw/public/include/footer.html" height="150"
		width="960" id="iframe_foot" frameborder="0" scrolling="no"
		title="底部脚本"></iframe>



</body>
</html:html>