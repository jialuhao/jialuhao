<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>注册成功页面</title>
		<link href="<%=request.getContextPath()%>/css/index3.css"
			rel="stylesheet" type="text/css">
		<link href="/clrcw/styles/bsfw.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
		<link rel="stylesheet" type="text/css"
			href="/clrcw/styles/mainframe.css" />
		<link rel="stylesheet" type="text/css"
			href="/clrcw/styles/modelist.css" />

		<link rel="stylesheet" type="text/css" id="ABTStyle"
			href="/clrcw/styles/skin.css" />
		<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
		<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>
		<script src="/clrcw/scripts/common.js" type="text/javascript"></script>

	</head>
	<body>
		<div id="container">
			<!--<div id="header">
				<iframe id="iframe_head" src="http://211.99.136.80/headindex.html" frameborder="0" scrolling="no"> </iframe>
			</div>
			--><div id="main">



				<div id="content">
					<h2>
						新用户注册成功
					</h2>




					<div class="formdiv" id="ser_content1">

						<table class="finktable" id="newtable">
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
							<form
								action="${ctx}/goOnRegist.do?method=goOnRegist&username=${personUserId}&area=2"
								method="post" >
								<table align="center">
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
										<td colspan="2">
										</td>
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
		<script language="javascript" type="text/javascript">
	function showCard(cardid, infoid, clsName) {
		var cardList = cardid.parentNode.getElementsByTagName("li");
		for (i = 0; i < cardList.length; i++) {
			if (cardid == cardList[i]) {
				cardList[i].className = clsName + "_on";
				document.getElementById(infoid + i).style.display = "block";
			} else {
				cardList[i].className = clsName + "_off";
				document.getElementById(infoid + i).style.display = "none";
			}
		}
	}
	
</script>
		<script>



function search1(){
    var s_name=document.getElementById("s_name").value;
   var dcsid=document.getElementById("dcsid").value;
 if(isEmpty(s_name)){
   
    return false;
 }
if(!isChinese(s_name)){
   
    return false;
 }
 if(isEmpty(dcsid)){
   
    return false;
 }
 
 if(dcsid.length<20){
 	
	return false;
	}
	if(dcsid.length>25){
 	
	return false;
	}
	if("<%=session.getAttribute("mes")%>"=="rand"){
  	alert("请重新输入验证码！");
  	document.getElementById("rand").value="";
  	
  	return false;
  }
	return true;
  }
  
if(search1()){

var mes="<%=session.getAttribute("mes")%>";
if(!mes==""&&mes=="真"){
alert("残疾证信息无误！");
window.open("${ctx}/goOnRegist.do?method=goOnRegist&username=${personUserId}&area=2");
}else if(mes=="假"){
	alert("未查询到此残疾证信息");
var s_name=document.getElementById("s_name").value="";
   var dcsid=document.getElementById("dcsid").value="";
}

}
  function search(){
    var s_name=document.getElementById("s_name").value;
   var dcsid=document.getElementById("dcsid").value;
   var rand=document.getElementById("rand").value;
   var s_name=document.getElementById("s_name").value=s_name.replace(/[ ]/g, "");
   
 if(isEmpty(s_name)){
    alert("姓名不能为空！");
    return false;
 }
if(!isChinese(s_name)){
    alert("姓名必须为中文！");
    return false;
 }
 if(isEmpty(dcsid)){
    alert("残疾证号不能为空！");
    return false;
 }
 

 if(dcsid.length<20){
 	alert("残疾证号位数不足！");
	return false;
	}
	if(dcsid.length>25){
 	alert("残疾证号位数超出！");
	return false;
	}
	if(isEmpty(rand)){
    alert("验证码不能为空！");
    return false;
 }
	return true;
  }
  function listExperi(){
  if(search()){
    experiForm.action="personcheck.do?method=experiCard";
    experiForm.submit();
    }
  }
  document.getElementById("imgid").src="image.jsp";
  
  if(<%=session.getAttribute("code")%>==null||'<%=session.getAttribute("code")%>'==''||'<%=session.getAttribute("code")%>'=='null'){
  		document.getElementById("imgid").src = "image.jsp?"+Math.random();
  }
  
 function refresh(imgobj) {
	 imgobj.src = "image.jsp?"+Math.random();
    }
 

</script>
	</body>
</html>