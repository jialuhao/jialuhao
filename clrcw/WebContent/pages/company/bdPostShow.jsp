<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>显示岗位信息</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">
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



<table width="740" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#94C2F1">
  <tr>
    <td bgcolor="#EEF5FD">&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/images/qiye_loginpic.gif" width="22" height="32" > &nbsp;&nbsp;<span class="font3">
    <strong>岗位详细列表</strong></span></td>
  </tr>
</table>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="15"></td>
  </tr>
</table>

<table width="300" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#cccccc">
	<tr>
		<td width="150" bgcolor="FFF7F0" class="font5" align="left">
		<logic:present name="postRN">
		<bean:write name="postRN"/>如下：
		</logic:present></td>
	
	</tr>
	<logic:present name="Blist">
		<logic:notEmpty name="Blist">
		</logic:notEmpty>
			<logic:iterate id="BP" name="Blist" type="model.BdPost">
				<tr>
					<td width="150" bgcolor="#FFFFFF" class="font5" align="center">
					<bean:write name="BP" property="postName"/>	
					</td>
					
				</tr>
			</logic:iterate>
		<logic:empty name="Blist">
		<tr>
		<td width="150" bgcolor="#FFFFFF" class="font5" align="center">没有相关信息!</td>
		</tr>
		</logic:empty>
	</logic:present>
	<logic:notPresent name="Blist">
		<a href="${ctx}/pages/index.jsp" class="list">数据出错，请重试！</a>
	</logic:notPresent>
	
</table>


</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
 
</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
</html>