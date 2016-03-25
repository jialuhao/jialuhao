<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<script language="JavaScript" type="text/JavaScript">
function search2(){
    document.searchFrom2.action = "${ctx}/companySearch.do?method=showAll";
    document.searchFrom2.submit();
}

function change(s_id){
    document.form1.pageIndex.value = s_id;
    document.form1.action = "${ctx}/personShow.do?method=showOtherPage";
    
    document.form1.submit();
    
}

function checkform(){
    if (document.CompanyLoginForm.userId.value == "") {
        alert("用户名不能为空！");
        document.CompanyLoginForm.userId.focus();
        return false;
    }
    if (document.CompanyLoginForm.password.value == "") {
        alert("密码不能为空！");
        document.CompanyLoginForm.password.focus();
        return false;
    }
}

function nologin(){
    alert("请登录企业用户！");
    document.CompanyLoginForm.userId.focus();
}

</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业招聘信息</title>
<head>
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
 <iframe id="iframe_head" src="/clrcw/pages/header.html" frameborder="0" scrolling="no"
	height="150" width="960"> </iframe>
	</div>
  <div id="main">


<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <html:form action="/companyLogin.do?method=login" method="post" onsubmit="return checkform()">
    <td width="272" valign="top">
    
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="20"><img src="<%=request.getContextPath()%>/images/index_16.jpg" width="20" height="139" alt=""></td>
        <td valign="top" background="<%=request.getContextPath()%>/images/index_17.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center"><a href="#" class="b">企业用户登录</a></td>
            <td width="10"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
            </table></td>
          </tr>
        </table>
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
            <!-- 设置错误信息 -->
            <!--  显示权限控制信息-->
              <td colspan="2" align="center"><font color="red"><html:errors property="noUser"/>
              <html:errors property="loginfirst"/>
              <logic:present name="reLogin">
              <bean:write name="reLogin"/>
              </logic:present>
              </font></td>
            </tr>
            <!-- 设置登录状态-->
            <logic:notPresent name="compUserId">
            <tr>
              <td height="25" align="right">用户名：</td>
                <td align="left"><html:text property="userId"  size="15" /></td>
            </tr>
            <tr>
              <td height="25" align="right">密　码：</td>
                <td align="left"><html:password property="password" size="15" /></td>
            </tr>
            <tr>
              <td colspan="2" height="25" align="center"><!--<a href="#" class="d">忘记密码</a>&nbsp; | &nbsp;-->
              <a href="${ctx}/pages/company/companyRegist1.jsp" class="d">企业用户注册</a>
              &nbsp;<button class="input4"  type="submit">登录</button>
              
         	  </td>
            </tr>
            
            
            </logic:notPresent>
            <logic:present name="compUserId">
             <tr>
              <td colspan="2" height="35" align="center" >欢迎你：
              <bean:write name="compUserId"/></td>
            </tr>
			<tr>
              <td colspan="2" height="25" align="center"><a href="${ctx}/pages/company/modifyPassword.jsp" class="b">修改密码</a>|
              <a href="${ctx}/companyRegist2.do?method=companyShowInfo" class="b">企业信息</a> |<a href="${ctx}/companyLogin.do?method=loginOut" class="b">安全退出</a>
              </td>
            </tr>    
            </logic:present>
            
          </table>
          </td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="8" bgcolor="#FFFFFF"></td>
        </tr>
      </table>
      
      
 
      </td>
      
        </html:form>
    <td width="10">&nbsp;</td>
    <td valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#E5EAEE">
            <tr>
              <td height="5"></td>
            </tr>
            <tr>
              <td>
              
               <form name="searchFrom2" action="#" method="post">
              <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="300"><img src="<%=request.getContextPath()%>/images/index_55.jpg" width="138" height="31" alt=""></td>
                  <td align="right"><table width="205" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                    
                      <td width="60" class="font3">职位搜索</td>
                      <td><input name="textfield4" type="text" class="input2" id="textfield4"></td>
                      <td width="25"><img src="<%=request.getContextPath()%>/images/index_39.jpg" width="21" height="19" alt="搜索" onClick="search2()"></td>
                   
                    </tr>
                  </table></td>
                </tr>
              </table>
              </form>
                <table width="95%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="9DB4EC">
                  <tr>
                    <td bgcolor="#E5EAEE"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                          <tr>
                            <td width="40%" height="23" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg" class="font4">姓 名</td>
                            <td width="40%" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg"><span class="font4">应聘职位</span></td>
                            <td width="20%" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg" class="font4">学 历</td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td>
                        
                         <%--显示个人求职信息--%>      
 		<form action="" name="form1" method="POST">               
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="6D96C7">
                        	
                     
                        	<logic:present name="allApplyJobInfo">
                        		<logic:notEmpty name="allApplyJobInfo">
                        		<logic:iterate name="allApplyJobInfo" id="jobInfo" type="model.ApplyJobInfo">
                        
                          		<tr>
                          		<td width="40%" height="23" align="center" bgcolor="FEF9F9">
                            		
                            		<logic:present name="compUserId">
                          			<a href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}" class="p">
                          			<bean:write property="resumeCode.name" name="jobInfo"/></a>
                          			</logic:present>
                          			<logic:notPresent name="compUserId">
                          			<a href="#" class="p" onClick="nologin()">
                          			<bean:write property="resumeCode.name" name="jobInfo"/></a>
                          			</logic:notPresent>
                          			</td>
                            		
                          
                            		<td width="40%" align="center" bgcolor="FEF9F9" class="font5">
                            		<bean:write property="jobCode.jobName" name="jobInfo"/></td>
                            
                            		<td width="20%" align="center" bgcolor="FEF9F9" class="font5">
                            		<bean:write property="resumeCode.educate.educateName" name="jobInfo"/></td>
                          		</tr>
                          		</logic:iterate>
							
                          		  	<html:hidden property="pageIndex" value=""/>     
               	<%
               	int pageIndex=((Integer)request.getAttribute("pageIndex")).intValue();
                int tpn=((Integer)session.getAttribute("tpn")).intValue();
				if(tpn==0){
            		
				}
				else if(pageIndex==0)
               	{
               		%>
               	<tr>
                     <td height="23" colspan="3" align="right" bgcolor="FEF9F9">
                   	<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a></td>
                 </tr>
                 <%
               	}
               	else if(pageIndex==tpn){
                 %>
                 <tr>
                     <td height="23" colspan="3" align="right" bgcolor="FEF9F9">
                    <a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
                   
                 </tr>
                 <%
               }
               	else{
                 %>
                 <tr>
                     <td height="23" colspan="3" align="right" bgcolor="FEF9F9">
                    <a href="#" class="list" onClick="change(<%=pageIndex%>-1)">上一页</a>
                   	<a href="#" class="list" onClick="change(<%=pageIndex%>+1)">下一页&nbsp;</a></td>
                 </tr>
                 <%
                 }
            
                 %>
                 </logic:notEmpty>
                 <logic:empty name="allApplyJobInfo">
                 <p class="font5">没有个人求职信息！</p>
                 </logic:empty>
                 </logic:present>
                          		<logic:notPresent name="allApplyJobInfo">
                          			<p class="font5">没有个人求职信息！</p>
                          		</logic:notPresent>
                  </table>                 
                        </form>      
                        </td>
                      </tr>
                    </table></td>
                  </tr>
                </table>                </td>
            </tr>
            <tr>
              <td height="5"></td>
            </tr>
          </table>
            </td>
        </tr>
      </table></td>
    
  </tr>
</table>
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="8" bgcolor="#FFFFFF"></td>
  </tr>
</table>


</div>



   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   

 
</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
</html:html>

