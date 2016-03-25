<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业基本情况</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/mainframe.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/modelist.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/qzlb.css" />
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
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="15">   </td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#94C2F1">
  <tr>
    <td bgcolor="#EEF5FD">&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/images/qiye_loginpic.gif" width="22" height="32" > &nbsp;&nbsp;<span class="font3"><strong>企业用户注册</strong></span></td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="15"></td>
  </tr>
</table>

<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td height="40" colspan="4" bgcolor="#FFFFFF" class="font5"><span class="font3">· </span>
    <a href="#" class="f2">企业基本情况</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <html:link href="${ctx}/companyRegist3.do?method=companyRegist3">· 企业招聘信息</html:link> &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${ctx}/companyRegist4.do?method=companyRegist4">· 简历库</a></td>
  </tr>
  
</table>
</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   


</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
</html:html>
