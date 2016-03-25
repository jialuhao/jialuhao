<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.PersonResume"%>

<script language="JavaScript" type="text/JavaScript">
function checkform(){
    nowadd = document.form1.nowadd.value;
    postcode = document.form1.postcode.value;
    telnum = document.form1.telnum.value;
    
    if (nowadd.length > 20||nowadd.length<=0) {
        alert("地址长度为0-20个字");
        document.form1.nowadd.focus();
        return false;
    }
    if (nowadd.search(/^[0-9a-zA-Z\u4e00-\u9FA5]+$/) < 0 && nowadd != "") {
        alert("地址包含非法字符");
        document.form1.nowadd.focus();
        return false;
    }
    if (postcode.length != 6) {
        alert("邮编为6位数字");
        document.form1.postcode.focus();
        return false;
    }
    if (postcode.search(/^[0-9]+$/) < 0 && postcode != "") {
        alert("邮编只能为数字");
        document.form1.postcode.focus();
        return false;
    }
   

    if(telnum.length<6||telnum.length>15) {
	    alert("联系电话长度必须在6位到15位之间");
	   // document.form1.compAddr.value=username; 
	    document.form1.telnum.focus();
	   
	    return false;
    }
	if (telnum.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/) < 0){ 
		alert("联系电话格式不正确"); 
		//document.form1.userId.value=username; 
		document.form1.telnum.focus();
		return false; 
	}   

    
	alert("保存成功");
}

</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作/实习经历编辑</title>
<html:html>
<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/mainframe.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/modelist.css" />
<link rel="stylesheet" type="text/css" id="ABTStyle" href="/clrcw/styles/skin.css" />
<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>
<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
<!--<div id="header">
 <iframe id="iframe_head" src="http://211.99.136.80/headindex.html" frameborder="0" scrolling="no"
	height="150" width="960"> </iframe>
	</div>
  --><div id="main">
<table width="740" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="5"></td>
	</tr>
</table>
<div id="content">
    	<h2>个人用户【${personUserId}】信息&nbsp;&nbsp; <a href="${ctx}/logout.do?method=logout"  style="color:#BD0403;">[退出]</a></h2>
        <div class="formdiv">
		<ul id="list1">
       	  <li ><a href="${ctx}/personRegist3.do?method=personRegist3">1. 基本情况</a></li>
        	  <li><a href="${ctx}/personRegist4.do?method=personRegist4">2.工作/实习经历  </a></li> 
              <li> <a href="${ctx}/personRegist5.do?method=personRegist5">3.自我评价 </a> </li>
              <li> <a href="${ctx}/personApplyList.do?method=personApplyList"> 4.欲求职位  </a> </li>
              <li class="liH1">5.联系方式   </li>
              <li> <a href="${ctx}/resumeView.do?method=resumeView" target="_blank">6.个人简历预览</a></li>
        </ul>

<form name="form1"
	action="${ctx}/saveContactWay.do?method=saveContactWay" method="post"
	>
          <table class="finktable" id="jbqk"  summary="个人联系方式">
  <%
		PersonResume personResume = (PersonResume) request
				.getAttribute("pr");
		String address = personResume.getAddress();
		String phone = personResume.getPhone();
		String mailcode = personResume.getMailcode();
		if (phone == null) {
			phone = "";
		}
		if (address == null) {
			address = "";
		}
		if (mailcode == null) {
			mailcode = "";
		}
	%>
  <tr>
		<th colspan="5" class="th1" style="font-size:12px;">请填写您的联系方式：</th>
	</tr>
	<tr>
		<td style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;"><label for="nowadd">现在地址：</label></td>
		<td colspan="3" ><input title="请输入现在地址"
			type="text" Class="input3" id="nowadd" name="nowadd"
			value="<%=address %>" /></br><font color="#333333" style="font-size:12px;">联系地址长度为0-20个字  </font></td>
	</tr>
	<tr>
		<td style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;"><label for="telnum">联系电话：</label></td>
		<td ><input type="text" title="请输入联系电话"
			Class="input3" id="telnum" name="telnum" value="<%=phone %>" /></br><font color="#333333" style="font-size:12px;">联系电话长度为0-20个字</font></td>
		<td style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;"><label for="postcode">邮 编：</label></td>
		<td ><input type="text" title="请输入邮编"
			Class="input3" id="postcode" name="postcode" value="<%=mailcode %>" /></br><font color="#333333" style="font-size:12px;">邮编长度为0-10个数字 </font></td>
	</tr>
</table>
<table width="740" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="35" align="center"><input type="submit" value="保存"
			Class="input4" onclick="return checkform();"/> <input type="button" value="返回"
			onClick="history.go(-1)" Class="input4" /></td>
	</tr>
</table>
 




</form>
        </div>
    </div>


</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
 
 
</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>


</body>
</html:html>
