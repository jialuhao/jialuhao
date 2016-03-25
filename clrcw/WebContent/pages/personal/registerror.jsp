<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>残疾人身份验证</title>

		<link href="/clrcw/css/public.css" rel="stylesheet" type="text/css">
		<link href="/clrcw/css/mainframe.css" rel="stylesheet" type="text/css">
		<link href="/clrcw/css/modelist.css" rel="stylesheet" type="text/css">
		<link id="ABTStyle" href="/clrcw/css/skin.css" rel="stylesheet"
			type="text/css">
		<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css">
		<SCRIPT src="/clrcw/js/public.js" type="text/javascript"></SCRIPT>
		<SCRIPT src="/clrcw/js/menu.js" type="text/javascript"></SCRIPT>
		<SCRIPT id="ABT" src="js/shanDong.js" type="text/javascript"></SCRIPT>
		<SCRIPT src="/clrcw/js/calendar.js" type="text/javascript"></SCRIPT>
		<script src="/clrcw/scripts/common.js" type="text/javascript"></script>

<style type="text/css">
#newtable th.h2_table {
	width: auto;
	background: #900;
	color: #fff;
	font-size: 14px;
	padding: 10px;
	font-weight: bold;

}

#newtable td input {
	width: 250px;
	
	
}


#newtable td input[type="radio"] {
	width: 25px
}
</style>

	</head>
	<body>
		<div id="container">
			<div id="header">
				<!--  iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
					frameborder="0" scrolling="no">
				</iframe-->
			</div>
			<div id="main">
				<div id="content">
					<H2>
						残疾人身份验证
					</H2>
					<DIV class="formdiv"
						style="margin-top: -31px; padding: 30px; border: 0;">
						<form name="experiForm" method="post" action="personcheck.do" align="center">
							<table class="finktable" id="newtable" width="100%" border="0"
								cellspacing="0" cellpadding="0" style="border-top: 0;">
								
								<tbody>
									<tr>
										<th colspan="2" class="h2_table" style="" align="left">
											<font size="6" style="float: left;">❶</font>&nbsp;残疾人身份验证
											<font size="2">（带*为必填项）</font>
										</th>
									</tr>
									<tr>
										<th align="center" class="black" width="150">
											<label for="username"
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
												选择户籍所在地：
											</label>
										</th>
										<td align="left">
											<input name="red_add" type="radio" value="1" checked="checked"/>
											北京
											<input name="red_add" type="radio" value="2" />
											外省市
										</td>
									</tr>
									<tr>
										<th align="center" class="black">
											<label for="password"
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
												真实姓名：
											</label>
										</th>
										<td align="left">
											<input type="text" name="s_name" id="s_name"
												title="请输入真实姓名,必须为中文" >
											<font color="#333333" style="font-size: 12px;"> *</font>
											<br>
											<font color="red"> </font>
										</td>
									</tr>
									<tr>
										<th align="center" class="black">
											<label for="text" 
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
												残疾证号：
											</label>
										</th>
										<td align="left">
											<input type="text" name="dcsid" id="dcsid" 
												title="请输入残疾证号,位数在20至25位之间">
											<font color="#333333" style="font-size: 12px;"> *</font>
										</td>
									</tr>
									<tr>
										<th align="center" class="black">
											<label for="password2"
												style="color: #6E1F00; font-weight: normal; padding: 10px; font-size: 14px;">
												验证码：
											</label>
										</th>
										<td align="left">
											<input type="text" name="rand" id="rand" title="请输入验证码" class="left"
												onfocus="esdonfocus()">
											<%String message=(String)request.getAttribute("message"); 
											if(message==null){
											message="";
											}
											%>
											
											<img id="imgid" title="点击更换"
												onclick="javascript:refresh(this);" src="../../image.jsp"
												width="64" height="22"></br>
												<font  style="font-size: 15px;" color="red"><%= message%></font>
											<input type="hidden" name="voicepath" id="voicepath" />
										</td>
									</tr>
									<tr>
										<th colspan="2"
											style="width: auto; text-align: center; padding: 20px 0; background: #ddd;">
											<a href="####" onclick="listExperi()" class="btn1">立即验证</a><a
												 onclick="javascript:history.back();" class="btn1">取消</a>
										
										</th>
									</tr>
								</tbody>
							</table>
					</div>
					</form>
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




  function search(){
    var s_name=document.getElementById("s_name").value;
   var dcsid=document.getElementById("dcsid").value;
   var rand=document.getElementById("rand").value;
   var s_name=document.getElementById("s_name").value=s_name.replace(/[ ]/g, "");
   
 if(isEmpty(s_name)){
    alert("姓名不能为空！");
    return false;
 }
 if(s_name.length>10){
 alert("姓名必须小于10个字")
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