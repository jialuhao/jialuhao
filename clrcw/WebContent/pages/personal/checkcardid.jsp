<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>注册成功页面</title>
		<link href="<%=request.getContextPath()%>/css/index3.css"
			rel="stylesheet" type="text/css">

		<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
		<link rel="stylesheet" type="text/css"
			href="/clrcw/styles/mainframe.css" />
		<link rel="stylesheet" type="text/css"
			href="/clrcw/styles/modelist.css" />

		<link rel="stylesheet" type="text/css" id="ABTStyle"
			href="/clrcw/styles/skin.css" />
		<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
		<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>

	</head>
	<body>
		<div id="container">
			<!--<div id="header">
				<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
					frameborder="0" scrolling="no">
				</iframe>
			</div>
			--><div id="main">



				<div id="content">
					<h2>
						新用户注册成功
					</h2>




					<div class="formdiv" align="center">
					<form action="${ctx}/goOnRegist.do?method=goOnRegist"
								method="post">
						<table class="finktable" id="newtable" align="center">
							<style type="text/css">
#newtable th.h2_table {
	width: 400px;
	color: #BD0403;
	font-size: 14px;
	padding: 10px;
	font-weight: bold;
}

#newtable td input {
	width: 300px
}
</style>
							
						
									<tr>
										<th colspan="2" class="h2_table" style="">
											[${personUserId}]您好！
										</th>
									</tr>
									<tr>
										<th colspan="2" style="width: 400px;">
											欢迎您成为北京市残疾人联合会求职招聘系统用户！
										</th>

									</tr>
									<tr>
										<th colspan="2" style="width: 400px;">
											您可以进入个人服务专区创建个人简历和求职信息。
										</th>
									</tr>
									<tr>
										<th colspan="2">
											<input name="button" type="submit" class="button" id="button"
												value="点击进入">
										</th>
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