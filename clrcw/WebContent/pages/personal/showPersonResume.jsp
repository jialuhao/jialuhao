<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@page import="model.PersonResume"%>

<%
//  String id = (String)request.getAttribute("id"); 
//PersonResume personResume=PersonRegist3.getPersonResume(id);
  PersonResume personResume=(PersonResume)request.getAttribute("pr");
  personResume.getEducate();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人基本情况</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<!--<div id="header">
 <iframe id="iframe_head" src="http://211.99.136.80/headindex.html" frameborder="0" scrolling="no"
	height="150" width="960"> </iframe>
	</div>
  --><div id="main">
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="15">   </td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#FFD2AA">
  <tr>
    <td bgcolor="#FFF7F0">&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/images/geren_loginpic.gif" width="30" height="30" > &nbsp;<span class="font3"><strong>个人用户信息</strong></span></td>
    
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="15"></td>
  </tr>
</table>
<html:form action="/resume.do?method=resume" method="post" onsubmit="return validatePersonResumeForm(this);">
<table width="740" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td height="40" colspan="4" bgcolor="#FFFFFF" class="font5"><span class="font3">&nbsp;· </span>
    <html:link href="#" styleClass="f2">基本情况 </html:link>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>

  <tr>
    <td bgcolor="#EEF5FD" class="font5">　真实姓名：</td>
    <td bgcolor="#FFFFFF" class="font5"><%= personResume.getName() %></td>
    <td bgcolor="#EEF5FD" class="font5">　性　　别：</td>
    <td bgcolor="#FFFFFF" class="font5"><%= personResume.getSex() %></td>
  </tr>
  <tr>
    <td width="100" bgcolor="#EEF5FD"><span class="font5">　出生日期：</span></td>
    <td width="270" bgcolor="#FFFFFF"><span class="font5"><%= personResume.getBirthday() %></span></td>
    <td width="100" bgcolor="#EEF5FD"><span class="font5">户籍所在地：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getHomeplace() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#EEF5FD"><span class="font5">　现在住址：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getAddress()%></span></td>
    <td bgcolor="#EEF5FD"><span class="font5">　邮　　编：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getMailcode() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#EEF5FD"><span class="font5">　联系电话：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getPhone() %></span></td>
    <td bgcolor="#EEF5FD"><span class="font5">　最高学历：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getEducate().getEducateName() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#EEF5FD"><span class="font5">　毕业学校：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getSchool() %></span></td>
    <td bgcolor="#EEF5FD"><span class="font5">　所学专业：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getSpecialty() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#EEF5FD"><span class="font5">　工作年限：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getLimitYear() %></span></td>
    <td bgcolor="#EEF5FD"><span class="font5">　计算机水平：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getCompLevel() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#EEF5FD"><span class="font5">　外语语种1：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getLang() %></span></td>
    <td bgcolor="#EEF5FD"><span class="font5">　外语水平1：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getLevel1() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#EEF5FD"><span class="font5">　残疾程度：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getLang2() %></span></td>
    <td bgcolor="#EEF5FD"><span class="font5">　残疾类别：</span></td>
    <td bgcolor="#FFFFFF"><span class="font5"><%= personResume.getLevel2() %></span></td>
  </tr>
  </table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="35" align="center"><!--  
      
    <html:submit  property="submit" value="修改" styleClass="input4" />
    <html:submit property="submit2" value="保存继续" styleClass="	input4"/></td>

  </tr>-->
</table>
</html:form>
</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
 
 
</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>

</body>
</html:html>
