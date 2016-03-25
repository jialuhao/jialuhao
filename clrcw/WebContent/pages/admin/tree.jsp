<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp" %>
<html>
<head>
<%@include file="../../public/common/meta.jsp" %>
<script language="JavaScript" src="${ctx}/public/js/tree.js"></script>
<link href="${ctx}/public/cmsimges/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="TreeMenu"></div>
<script language="javascript" defer="defer">
var xmlDoc;
xmlDoc=CreateXMLDoc("${ctx}/public/xml/menu.xml");
var rootNode=xmlDoc.lastChild;
var d=document.getElementById("TreeMenu");
if(typeof(d)!="undefined")
d.innerHTML=BuilderTree(rootNode);
</script>
</body>
</html>

