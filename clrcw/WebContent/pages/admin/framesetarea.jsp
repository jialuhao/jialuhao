<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>后台管理</title>
<script language="JavaScript" src="${ctx}/public/js/tree.js"></script>
</head>

<frameset rows="93,*">
	<frame src="${ctx}/admin/manaLogin.do?method=checkmessage" name="top" scrolling="no" width="100%"
		noresize marginwidth=0 marginheight=0 />
	<frameset cols="150,*" framespacing="2" frameborder="yes" border="1">
		<frame src="${ctx}/pages/admin/treearea.jsp" name="menu" scrolling="auto" />
		<frame src="${ctx}/admin/showAllBespeak.do?method=showAllBespeak"
			name="body" />
	</frameset>
	<noframes>
	<body>
	你的游览器不支持FRAMESET！
	</body>
	</noframes>
</frameset>
</html>