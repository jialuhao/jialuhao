<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--
Object o=(Object)request.getAttribute("paginationData");

out.print(o.getClass().getName());

--%>

    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="6D96C7">
            
        
           <logic:present name="paginationData">
               <logic:iterate name="paginationData" id="userInfoId" type="model.ApplyJobInfo">
                     <tr>
                       <td width="20%" height="23" align="center" bgcolor="FEF9F9">
                       <%--bean:define id="jobinfo" name="paginationData" property="personCode" type="model.UserInfo"/ --%>  
                       <a href="#" class="d"><!--
                       jialuhao
                        <bean:write property="datatime" name="userInfoId"/>-->
                        <%--=userInfoId.getJobCode().getJobName()--%>
                        </a>
                        </td>
                          
                        <td width="20%" align="center" bgcolor="FEF9F9"><a href="#" class="d">
                      	<!--jialuaho<bean:write property="datatime" name="userInfoId"/>--></a></td>
                            
                        <td width="20%" align="center" bgcolor="FEF9F9" class="font5">
                        <bean:write property="version" name="userInfoId"/></td>
                            		
                         <td width="20%" align="center" bgcolor="FEF9F9" class="font5">
                          <bean:write property="dr" name="userInfoId"/></td>
                     </tr>
                </logic:iterate>
			</logic:present>
            <logic:notPresent name="paginationData">
                        the pagintionData is null!
             </logic:notPresent>
      </table>

</body>
</html>