
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    
    
    <title>My JSP 'top.jsp' starting page</title>
    <script language="JavaScript" type="text/JavaScript">
    function search1(){
    parent.frames["body"].location="/clrcw/admin/findAllapplyJob.do?method=findApplyJob&sta=0";
    }
    function search2(){
    parent.frames["body"].location="/clrcw/admin/showAllBespeak.do?method=showAllBespeak";
    }
     function search3(){
    parent.frames["body"].location="/clrcw/admin/findAllpublishJob.do?method=findAllpublishJob&sta=0";
    }
</script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<body  style="margin: 0px;">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <%Integer number1=(Integer)request.getSession().getAttribute("number1");
    Integer number2=(Integer)request.getSession().getAttribute("number2");
    Integer number3=(Integer)request.getSession().getAttribute("number3");
     %>
    <td  rowspan="4"><img src="/clrcw/images/top_banner.jpg" width="789" /></td>
     <td >
  <button   onclick="search1()">待审核求职信息<%=number1 %>条</button></br>
  <button   onclick="search2()">待审核资质信息<%=number2%>条</button></br>
 <button   onclick="search3()">待审核招聘信息<%=number3%>条</button>
  </td>
   
    </tr>
  
</table>
</body>

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
