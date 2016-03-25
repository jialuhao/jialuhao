<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<style>
html,body{font-size:12px;margin:0px;height:100%;}
.mesWindow{border:#666 1px solid;background:#fff;}
.mesWindowTop{border-bottom:#eee 1px solid;margin-left:4px;padding:3px;font-weight:bold;text-align:left;font-size:12px;}
.mesWindowContent{margin:4px;font-size:12px;}
.mesWindow .close{height:15px;width:28px;border:none;cursor:pointer;text-decoration:underline;background:#fff}
</style>
<script language="JavaScript" type="text/JavaScript">

 }
 
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>显示一条服务记录</title>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>

</head>
<body>
	




			<div id="content">
				
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
                    <DIV class="formdiv"
					style="margin-top: 0px; padding: 30px; background: #fff; border-bottom: 50; margin-right:0px;">
					<form action="" method="post" name="myform" id="myform">
			
		
	                  <input type="hidden" name="sname" id="sname"/>
						<input type="hidden" name="snumber" id="snumber"/>					
						<input type="hidden" name="register" id="register"/>
                        <input type="hidden" name="sphone" id="sphone"/>
						<input type="hidden" name="sjob" id="sjob"/>					
						<input type="hidden" name="remark" id="remark"/>
         <table width="80%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc" summary="企业招聘信息" >
<%Servicelog servicelog=(Servicelog)request.getSession().getAttribute("servicelog");
		PublishJobInfo job=(PublishJobInfo)request.getSession().getAttribute("job");
							String jobname=job.getJob().getJobName();
							 %>				
							
							
							<tr>
							<td align="center" >
									服务记录
							  </td>
							<td align="center" >
									记录时间
							  </td>
								<td align="center" >
									<%=servicelog.getWritetime() %>
								</td>
								<td align="center" >
									记录区县
								</td>
								<td align="center" >
										<%=servicelog.getWriteare() %>
								</td>
								<td align="center" >
									记录人
								</td>
								<td align="center"  colspan='2' >
										<%=servicelog.getWritepeople()%>
								</td>
							</tr>
							<tr>
							<td align="center" >
									招聘周期
							  </td>
								
								<td align="center" >
								岗位名称
								</td>
								<td align="center" >
										<%=jobname %>
								</td>
								<td align="center" >
								人数
								</td>
								<td align="center"   colspan='3'>
										<%=servicelog.getNumber() %>
								</td>
								
							</tr>
							
							<tr >

								<td class="tdFormInput" align="center" colspan="7">
									<div align="center">
										<strong>推荐记录</strong>
									</div>
							  </td>
							</tr>
								<tr>
							
							<td align="center">
									推荐岗位
								</td>
								
								<td align="center" >
									残疾人身份证号
								</td>
								<td align="center" >
									残疾人姓名
								</td>
								<td align="center" >
									残疾类别
								</td>
								
								<td align="center" >
									推荐残疾人电话
								</td>
								
								<td align="center" colspan="2">
									推荐人
								</td>
							</tr>
							<%List listr=(List)request.getSession().getAttribute("recommends");
							for(int i=0;i<listr.size();i++){							
							 Recommends recom=(Recommends)listr.get(i);
							     
							%>
							<tr  >
							<td align="center"   >
										<%=jobname%>
							  </td>
								<td align="center" >
									<%=recom.getCardnumber()%>
								</td>
								<td align="center" >
									<%=recom.getName()%>
								</td>
								<td align="center" >
										<%=recom.getDikind()%>
								</td>
								<td align="center" >
									<%=recom.getPhone()%>
								</td>
								<td align="center" colspan="2">
										<%=recom.getCommdpeople()%>
								</td>
							
								
							</tr>
							<%} %>
			 </table>
							
							 <table width="80%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc" id="testTable">
						<%List aaa=(List)request.getSession().getAttribute("servicepeople"); 
							if(aaa.size()>0){
							 %>
							<tr class="trcolor" >

								<td class="tdFormInput" align="center" width="50%" colspan="8">
									<div align="center">
										<strong>招用人员花名册</strong>
									</div>
								</td>
							</tr>
							
							<tr>
								<td align="center" style='width:100px'>
									序号
								</td>
								<td align="center" style='width:100px'>
									姓名
								</td>
								<td align="center" style='width:100px'>
									残疾人证件号码
								</td>
								<td align="center" style='width:100px'>
									户籍
								</td>
								<td align="center" style='width:100px'>
									电话
								</td>
								<td align="center" style='width:100px'>
								          所在岗位名称
								</td>
								<td align="center" style='width:100px' colspan="2">
								       备注
								</td>
								
							</tr>
							<%
							for(int i=0;i<aaa.size();i++){
							Servicepeople servicepeople=(Servicepeople)aaa.get(i);
							String a="";
							if(servicepeople.getRemark()!=null){
							a=servicepeople.getRemark();
							}
							%>
							<tr>
							<td align="center"   >
										<%=i+1 %>
							  </td>
								<td align="center" >
										<%=servicepeople.getSname()%>
								</td>
								<td align="center" >
										<%=servicepeople.getDisnumber()%>
								</td>
								<td align="center" >
										<%=servicepeople.getRegister()%>
								</td>
								<td align="center" >
										<%=servicepeople.getPhone()%>
								</td>
								<td align="center" >
										<%=servicepeople.getJobname()%>
								</td>
								<td align="center" colspan="2">
										<%=a%>
								</td>
								
								
							</tr>
							<%} }%>
             
             <%if(servicelog.getLosewhy()!=null&&!(servicelog.getLosewhy()).equals("")){
             String otherwhy=servicelog.getOtherwhy();
             if(otherwhy==null){
             otherwhy="";
             }
             %>              
             <tr>
								<td style="text-align: left;" colspan='7'>
									未招用原因：
									<input type="checkbox" disabled="true" name="losewhyobj" id="losewhyobj1" value="1" />
									无合适人员
									
									<input type="checkbox" disabled="true" name="losewhyobj" id="losewhyobj2" value="2" />
									岗位调整
									<input type="checkbox" disabled="true" name="losewhyobj" id="losewhyobj3" value="3" />
									其它:
									<%=otherwhy %>
                                    
							  </td>
							</tr>
							<% }%>
	<tr>



								<td style="text-align: left;" colspan='7'>
									在招聘和雇佣残疾人过程中，需要提供哪些服务：
									<br>
									<br>
									<input type="checkbox" disabled="true" name="problem1obj" id="problem1obj1" value="1" />
									健全员工基本手语培训
									<input type="checkbox" disabled="true" name="problem1obj" id="problem1obj2" value="2" />
									残疾人职业适应性指导
									<br>
									<input type="checkbox" disabled="true" name="problem1obj" id="problem1obj3" value="3" />
									应聘残疾人职业素质测评（由人力资源测评专业公司提供）
									<br>
									<input type="checkbox" disabled="true" name="problem1obj" id="problem1obj4" value="4" />
									其他
								</td>
			  </tr>
							<tr>
								<td style="text-align: left;" colspan='7'>
									意见、建议：
									<br>
									<%=servicelog.getOpinion()%>
									
								</td>
								
							</tr>
					  </table>
							
							
                       
									<input type="button" onclick="history.go(-1)" value="返回" />
								
						
						<br />
		
                 </form>
</DIV>
               

				<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
<script type="text/javascript">
checkeds('<%=servicelog.getServiceneed()%>','problem1obj');
	checkeds('<%=servicelog.getLosewhy()%>','losewhyobj');
	
	function checkeds(val,column) {

		var vals1=val.split(',');
		for(i=0;i<vals1.length&&vals1[i]!='';i++){
			document.getElementById(column+vals1[i]).checked=true;
		}
		}
</script>
</html:html>
