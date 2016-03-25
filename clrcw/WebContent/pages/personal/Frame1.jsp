<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>工作/实习经历编辑</title>
	<script language="JavaScript1.2">
    function init(){
	    var id = window.dialogArguments;
	    window.open("${ctx}/showResume.do?method=showResume&id="+id ,"editFrame");
    }
	</script>
</head>

<frameset onload="init()" rows="600,*" frameborder="NO" border="0" framespacing="0">
  <frame name="editFrame" scrolling="auto">
  <frame name="edit1Frame" scrolling="auto">
</frameset>
<noframes>
  <body>
  </body>
</noframes>
</html>