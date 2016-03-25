<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%
  String id = (String)request.getAttribute("id"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td height="40" colspan="4" bgcolor="#FFFFFF" class="font3">企业基本情况</td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0" class="font5">　单位名称：</td>
    <td colspan="3" bgcolor="#FFFFFF" class="font5"><%= request.getAttribute("truename") %></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">　法人名称：</span></td>
    <td colspan="3" bgcolor="#FFFFFF"><span class="font5"><%= request.getAttribute("truename") %></span></td>
  </tr>
  <tr>
    <td width="100" bgcolor="FFF7F0"><span class="font5">　邮　　编：</span></td>
    <td width="270" bgcolor="#FFFFFF"><span class="font5"><%= request.getAttribute("truename") %></span></td>
    <td width="100" bgcolor="#FFF7F0"><span class="font5">　电子邮件：</span></td>
    <td bgcolor="#FFFFFF"><a href="mailto:saa@yahoo.com.cn" class="f"><%= request.getAttribute("truename") %></a></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">　联系电话：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= request.getAttribute("truename") %></span></td>
    <td bgcolor="#FFF7F0"><span class="font5">　联 &nbsp;系&nbsp; 人：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= request.getAttribute("truename") %></span></td>
  </tr>
</table>
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="1" bgcolor="94C2F1"></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td bgcolor="FFF7F0" class="font5">　经营范围：</td>
    <td colspan="3" bgcolor="#FFFFFF" class="font5">asdfasdf</td>
  </tr>
  <tr>
    <td width="100" bgcolor="FFF7F0"><span class="font5">　企业性质：</span></td>
    <td width="270" bgcolor="#FFFFFF"><span class="font5">asdfasdf</span></td>
    <td width="100" bgcolor="#FFF7F0"><span class="font5">　网　　址：</span></td>
    <td bgcolor="#FFFFFF"><a href="mailto:saa@yahoo.com.cn" class="f">asdfasd</a></td>
  </tr>
  <tr>
    <td bgcolor="FFF7F0"><span class="font5">　企业介绍：</span></td>
    <td colspan="3" bgcolor="#FFFFFF"><span class="font5"><%= request.getAttribute("truename") %></span></td>
  </tr>
</table>
</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
 

</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
</html:html>
