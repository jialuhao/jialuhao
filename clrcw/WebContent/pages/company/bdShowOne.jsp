<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>显示岗位详细信息</title>
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

<table width="978" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#E5EAEE">
            <tr>
              <td height="5"></td>
            </tr>
            <tr>
              <td valign="top"><table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><img src="<%=request.getContextPath()%>/images/index_36a.jpg" width="138" height="31" alt=""><a name="top"></a></td>
                    </tr>
                </table>
                  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                    <tr>
                      <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="10"></td>
                        </tr>
                      </table>
                        
                      
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">

                          <tr>
                            <td><table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td valign="top" bgcolor="#779DCC" class="font4">
                                 		 <logic:present name="postRN">
											<bean:write name="postRN"/>如下：
												</logic:present></td>
                                  <td width="50" align="center" valign="top" bgcolor="#779DCC" class="font4"></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="10"></td>
                              </tr>
                            </table>
            	
					
                   <TABLE width="90%" border="0" align="center" cellPadding="0" cellSpacing="0" id="table">
                      <logic:present name="Blist">
						<logic:notEmpty name="Blist">
		
                              <%
                      			List<BdPost> list=(List<BdPost>)request.getAttribute("Blist");
                      		 for(int i = 0;i < list.size();i++) 
                            { 
                            if   (i==0) 
                            { 
                            %> 
                              <tr> <td width="30%"  class="font5"> <%=list.get(i).getPostName()%></td> 
                            <% 
                            } 
                            else if   (i%3==0) 
                            { 
                            %> 
                            </tr> <tr> <td width="30%"  class="font5"> 
                            <%=list.get(i).getPostName()%></td> 
                            <% 
                            } 
                           else 
                            { 
                            %> 
                        
                            <td width="30%"  class="font5"> 
                            <%=list.get(i).getPostName()%> </td> 
                            <%   
                            } 
                            if((i+1)==list.size())
                            {
                             out.print("<tr>");
                            }
                            }   
                            %> 
                          </logic:notEmpty>
                          <logic:empty name="Blist">
							<tr>
								<td colspan="3" bgcolor="#FFFFFF" class="font5" align="center">没有相关职位信息!</td>
							</tr>
						</logic:empty>
                    </logic:present>
        	        <logic:notPresent name="Blist">
						<a href="${ctx}/pages/index.jsp" class="list">数据出错，请重试！</a>
					</logic:notPresent>
                              
                            </TABLE>
                            
                            </td>
                          </tr>
                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="10"></td>
                          </tr>
                        </table>

                        
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="10"></td>
                          </tr>
                        </table>
                        
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="10"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="20"></td>
                    </tr>
                  </table></td>
            </tr>
            <tr>
              <td height="5"></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="970" border="0" align="center" cellpadding="0" cellspacing="0">
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
</html>
