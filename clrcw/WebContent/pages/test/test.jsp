<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="common.constants.IConstants"%>
<SCRIPT language="javascript" src="<%=request.getContextPath()%>/public/js/calendar.js"></SCRIPT>
<script language="JavaScript" type="text/JavaScript">
function search1(){
	document.searchFrom1.action="${ctx}/personSearch.do?method=showAll";
	document.searchFrom1.submit();
}
function search2(){
	document.searchFrom2.action="${ctx}/companySearch.do?method=showAll";
	document.searchFrom2.submit();
}


function select(){

var temp=document.getElementsByName("radio");
	
			if(temp[0].checked ){
			 document.all.form3.action="${ctx}/indexLogin.do?method=indexLogin";
		    document.all.form3.submit();
			

		    }
		    
		    else {
		    document.all.form3.action="${ctx}/indextCLogin.do?method=indextCLogin";
		    document.all.form3.submit();
//		    document.all.form3.action="${ctx}/login.do?method=login";
		    }

	}
	function nologinp(){
alert("请登录个人用户！");

}	
function nologinc(){
alert("请登录企业用户！");

}	

</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">
</head>

<body>


<% String pid=(String)request.getSession().getAttribute(IConstants.PERSON_USER_ID);
String cid=(String)request.getSession().getAttribute(IConstants.COMP_USER_ID ); %>
<table width="978" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>

		<td width="272" valign="top" bgcolor="#D9E0E6">
			<form action="" name="form3" method="POST">

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="20"><img
					src="<%=request.getContextPath()%>/images/index_16.jpg" width="20"
					height="139" alt=""></td>
				<td valign="top" background="<%=request.getContextPath()%>/images/index_17.jpg">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="11" colspan="2"></td>
					</tr>
					<tr>
					<% if(pid==null&&cid!=null){ %>

						<td><input name="radio" type="radio" class="input7"
							id="radio" value="radio"  > <strong>个人用户</strong></td>
						<td width="137"><input name="radio" type="radio"
							class="input7" id="radio2" value="radio" checked > <strong>企业用户</strong></td>
							
						<% }else {%>
						<td><input name="radio" type="radio" class="input7"
							id="radio" value="radio" checked > <strong>个人用户</strong></td>
						<td width="137"><input name="radio" type="radio"
							class="input7" id="radio2" value="radio" > <strong>企业用户</strong></td>
						<% } %>	
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
						<td></td>
					</tr>
					<% 
					if(pid==null&&cid==null){ %>
						<tr>
						<td height="25" align="right">用户名：</td>
						 <td align="left"><input type="text" name="userId" id="userId"></td>
					</tr>
					<tr>
						<td height="25" align="right">密　码：</td>
						<td align="left"> <input type="password"
							name="password" id="password"></td>
					</tr>
					<tr>
						<td height="25" align="center" colspan="2"><a href="${ctx}/pages/personal/personRegist1.jsp"
							class="d">个人注册</a>&nbsp;|&nbsp;
							<a href="${ctx}/pages/company/companyRegist1.jsp"
							class="d">企业注册</a>
					<button class="input4"  onclick="select()">登录</button>
						</td>
				  </tr>
					<% }else if(pid==null&&cid!=null){%>

					<tr>
							<td height="35" align="center" colspan="2"><bean:message key="username" />：<%=cid %></td>
						</tr>

						<tr>
							<td height="25" align="center" colspan="2"><a
								href="${ctx}/companyRegist2.do?method=companyShowInfo" class="b">企业信息</a>
							| &nbsp;<a href="${ctx}/companyLogin.do?method=loginOut" class="d">安全退出</a></td>
						</tr>
						<% }else{ %>
						<tr>
							<td height="35" align="center" colspan="2"><bean:message key="username" />：<%=pid %></td>
						</tr>

						<tr>
							<td height="25" align="center" colspan="2"><a
								href="${ctx}/personRegist3.do?method=personRegist3" class="b">个人简历</a>
							| &nbsp;<a href="${ctx}/logout.do?method=logout" class="d">安全退出</a></td>
						</tr>
						<% } %>
					

				</table>
			  </td>
			</tr>
		</table>
		
	</form>	
		
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="8" bgcolor="#FFFFFF"></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<table width="248" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td height="6" bgcolor="#D9E0E6"></td>
					</tr>
					<tr>
						<td>
						<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td valign="top" bgcolor="#767676">
								<p class="font4">公 &nbsp;告&nbsp;|&nbsp;通
								&nbsp;知&nbsp;|&nbsp;动 &nbsp;态</p>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td>
						<table width="90%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="8"></td>
							</tr>
							<tr>
								<td class="font2">· <a href="#" class="list">盘点2007年职场大事
								</a><br>
								· <a href="#" class="list">中华英才网首届大学生职业生</a>...<br>
								· <a href="#" class="list">职业讲习所首创“团体职业咨询”</a><br>
								· <a href="#" class="list">ChinaHR与GCDF、CCDM结成战..<br>
								· 盘点2007年职场大事 </a><br>
								· <a href="#" class="list">中华英才网首届大学生职业生</a>...<br>
								· <a href="#" class="list">中华英才网首届大学生职业生</a>...</td>
							</tr>
							<tr>
								<td height="7"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<table width="248" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td height="6" bgcolor="#D9E0E6"></td>
					</tr>
					<tr>
						<td>
						<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td valign="top" bgcolor="#767676" class="font4">
								政策法规&nbsp;｜职业指导&nbsp;｜区域工资</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td>
						<table width="90%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="8"></td>
							</tr>
							<tr>
								<td class="font2">· <a href="#" class="list">盘点2007年职场大事
								</a><br>
								· <a href="#" class="list">中华英才网首届大学生职业生</a>...<br>
								· <a href="#" class="list">职业讲习所首创“团体职业咨询”</a><br>
								· <a href="#" class="list">ChinaHR与GCDF、CCDM结成战..<br>
								· 盘点2007年职场大事 </a><br>
								· <a href="#" class="list">中华英才网首届大学生职业生</a>...<br>
								· <a href="#" class="list">中华英才网首届大学生职业生</a>...<br>
								</td>
							</tr>
							<tr>
								<td height="3"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="8"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>

		<td width="10">&nbsp;</td>
		<td valign="top">
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="5" cellspacing="1"
					bgcolor="E08282">
					<tr>
						<td align="center" bgcolor="#FFFFFF">
						<table width="321" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="125" background="images/">
								
								<img src="<%=request.getContextPath()%>/images/index_22.jpg" width="321" height="125" border="0" usemap="#Map">
								
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
				<td width="10">&nbsp;</td>
				<td>
				<table width="100%" border="0" cellpadding="5" cellspacing="1"
					bgcolor="E08282">
					<tr>
						<td align="center" bgcolor="#FFFFFF">
						<table width="321" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="125">
								
								<img src="<%=request.getContextPath()%>/images/index_24.jpg" width="314" height="125" border="0" usemap="#Map2">
								
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>

			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="8" bgcolor="#FFFFFF"></td>
			</tr>
		</table>
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					bgcolor="#E5EAEE">
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td>
						
						
	<form name="searchFrom1" action="#" method="post">
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="300"><img src="<%=request.getContextPath()%>/images/index_36.jpg" width="138" height="31" alt=""></td>
                  <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="60" class="font3">职位搜索</td>
                      <td><input name="textfield3" type="text" class="input2" id="textfield3"></td>
                      <td width="25"><img src="<%=request.getContextPath()%>/images/index_39.jpg" width="21" height="19" alt="搜索" onClick="search1()"></td>
                    </tr>
                  </table>
				  </td>
                </tr>
              </table>
       </form>
              
                <table width="95%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="9DB4EC">
                  <tr>
                    <td bgcolor="#E5EAEE"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                          <tr>
                            <td width="40%" height="23" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg" class="font4">企业名称</td>
                            <td width="40%" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg"><span class="font4">招聘职位</span></td>
                            <td width="20%" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg" class="font4">企业性质</td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="6D96C7">
                         
                         
                       
                   		<%--显示企业招聘信息--%>
                         
                          
                          <logic:present name="publishjobinfo">
                        		<logic:iterate name="publishjobinfo" id="JobInfo" type="model.PublishJobInfo">
                        
                          		<tr>
                            		<td width="40%" height="23" align="center" bgcolor="FEF9F9">
                            		<a href="${ctx}/companyShowOneInfo.do?method=showOneCompany&userId=${JobInfo.pkComp.comp.id}&loginId=${JobInfo.pkComp.comp.userId}" class="p" target="_blank">
                          			<bean:write property="pkComp.comp.compName" name="JobInfo"/></a></td>
                          
                            		<td width="40%" align="center" bgcolor="FEF9F9" class="font5">
                            		<bean:write property="job.jobName" name="JobInfo"/></td>
                            
                            		<td width="20%" align="center" bgcolor="FEF9F9" class="font5">
                            		<bean:write property="pkComp.type.compTypeName" name="JobInfo"/></td>
                          		</tr>
                          		</logic:iterate>
							</logic:present>
                          		<logic:notPresent name="publishjobinfo">
                          			<p class="font5">没有企业招聘信息!</p>
                          		</logic:notPresent>
                          		
                          		
                          	<tr>
                            <td height="23" colspan="3" align="right" bgcolor="FEF9F9">
                            <a href="${ctx}/companyShow.do?method=showAll" class="list">更多&gt;&gt;</a></td>
                            </tr>
                          
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                </table>
                </td>
            </tr>
            <tr>
              <td height="5"></td>
            </tr>
          </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="8" bgcolor="#FFFFFF"></td>
              </tr>
            </table>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#E5EAEE">
              <tr>
                <td height="5"></td>
              </tr>
              <tr>
                <td>
                <form name="searchFrom2" action="#" method="post">
                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="300"><img src="<%=request.getContextPath()%>/images/index_55.jpg" width="138" height="29" alt=""></td>
                      <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="60" class="font3">职位搜索</td>
                            <td><input name="textfield4" type="text" class="input2" id="textfield4"></td>
                            <td width="25"><img src="<%=request.getContextPath()%>/images/index_39.jpg" width="21" height="19" alt="搜索" onClick="search2()"></td>
                          </tr>
                      </table>
                      </td>
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
                              <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="6D96C7">
                   
                  			
                        		<logic:present name="applyJobInfo">
                        		<logic:notEmpty name="applyJobInfo">
                        	
                        		<logic:iterate name="applyJobInfo" id="jobInfo" type="model.ApplyJobInfo">
                        
                          		<tr>
                            		<td width="40%" height="23" align="center" bgcolor="FEF9F9">
                            		<logic:present name="compUserId">
                          			<a href="${ctx}/compShowPersonInfo.do?method=showPersonInfo&applyKeyId=${jobInfo.id}" class="p">
                          			<bean:write property="resumeCode.name" name="jobInfo"/></a>
                          			</logic:present>
                          			<logic:notPresent name="compUserId">
                          			<a href="#" class="p" onClick="nologinc()">
                          			<bean:write property="resumeCode.name" name="jobInfo"/></a>
                          			</logic:notPresent>
                          			</td>
                          
                            		<td width="40%" align="center" bgcolor="FEF9F9" class="font5">
                            		<bean:write property="jobCode.jobName" name="jobInfo"/></td>
                            
                            		<td width="20%" align="center" bgcolor="FEF9F9" class="font5">
                            		<bean:write property="resumeCode.educate.educateName" name="jobInfo"/></td>
                          		</tr>
                          		</logic:iterate>
                          		</logic:notEmpty>
                          		<logic:empty name="applyJobInfo">
                          		<p class="font5">没有个人求职信息！</p>
                          		</logic:empty>
							</logic:present>
                          		<logic:notPresent name="applyJobInfo">
                          		<p class="font5">没有个人求职信息！</p>
                          		</logic:notPresent>
                          	<tr>
                            <td height="23" colspan="3" align="right" bgcolor="FEF9F9"><a href="${ctx}/personShow.do?method=showAll" class="list">更多&gt;&gt;</a></td>
                            </tr>
                          
                        </table></td>
                            </tr>
                        </table></td>
                      </tr>
                  </table></td>
              </tr>
              <tr>
                <td height="5"></td>
              </tr>
            </table></td>
          <td width="5">&nbsp;</td>
          <td width="153" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#E08282">
            <tr>
              <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="29" bgcolor="838797"><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td><img src="<%=request.getContextPath()%>/images/index_41.jpg" width="105" height="19" alt=""></td>
                    </tr>
                  </table></td>
                </tr>
              </table>

						
						
						
			<!-- 职位分类目录 -->
					<table width="93%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="10" colspan="2"></td>
							</tr>
					<logic:present name="postRoot">
						<logic:notEmpty name="postRoot">
							<logic:iterate  id="pRoot" name="postRoot" type="model.BdPostRoot">
								<tr>
									<td width="20" height="28">
										<img src="<%=request.getContextPath()%>/images/index_51.jpg"
										width="14" height="14" alt=""></td>
									<td>
										<html:link href="${ctx}/bdPostShow.do?method=showOne" paramId="keyId" paramName="pRoot" paramProperty="id" styleClass="d" target="_blank">
										<bean:write name="pRoot" property="postName"/></html:link>
									</td>
								</tr>
							</logic:iterate>
								
								
							<tr>
								<td height="28">&nbsp;</td>
								<td align="right"><html:link href="${ctx}/bdPostShow.do?method=showAll" styleClass="list" target="_blank">
								更多&gt;&gt;</html:link>
								</td>
							</tr>
						</logic:notEmpty>
						<logic:empty name="postRoot">
							<p class="font5">还没有添加信息！</p>
						</logic:empty>
					</logic:present>
					<logic:notPresent name="postRoot">
						<a href="${ctx}/pages/index.jsp" class="list">没有数据，请重试！</a>
					</logic:notPresent>
							
							<tr>
								<td height="10" colspan="2"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td><!--
		
	</tr>
	
--></table>
<table width="970" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="153">
		<table width="153" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_58.jpg" width="153"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
		<td width="153">
		<table width="153" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_60.jpg" width="153"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
		<td width="153">
		<table width="153" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_62.jpg" width="153"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
		<td width="153">
		<table width="153" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_64.jpg" width="153"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
		<td width="153">
		<table width="153" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_68.jpg" width="153"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
		<td width="153">
		<table width="153" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_58.jpg" width="153"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<table width="970" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="8" bgcolor="#FFFFFF"></td>
	</tr>
</table>
<table width="970" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td>
		<table width="315" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_76.jpg" width="315"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
		<td>
		<table width="315" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_78.jpg" width="315"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
		<td>
		<table width="315" border="0" cellpadding="0" cellspacing="1"
			bgcolor="E08282">
			<tr>
				<td bgcolor="#FFFFFF"><img
					src="<%=request.getContextPath()%>/images/index_80.jpg" width="315"
					height="58" alt=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<table width="978" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="30">&nbsp;</td>
	</tr>
</table>
<table width="978" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3" bgcolor="7D8193"></td>
	</tr>


	<tr>


	</tr>
	<tr>
		<td height="100" align="center"><span class="font5"><a
			href="#" class="d">关于我们</a>&nbsp; &nbsp;|&nbsp;&nbsp; <a href="#"
			class="d">联系我们</a>&nbsp;&nbsp; |&nbsp;&nbsp; <a href="#" class="d">版权声明</a>&nbsp;&nbsp;
		|&nbsp;&nbsp; <a href="#" class="d">网站地图</a> </span><span class="font2"><br>
		copyright©2008 中华人民共和国国防科学技术工业委员会信息中心 版权所有 </span><br>
		<span class="font5">通讯地址：北京8184信箱 邮编100081</span></td>
	</tr>
</table>

<map name="Map">

		<area shape="rect" coords="205,100,299,123"
		 <% if(request.getSession().getAttribute(IConstants.PERSON_USER_ID)!=null){%>
		href="${ctx}/personRegist3.do?method=personRegist3"<% }else{%>
			href="#" onClick="nologinp()"<%}%>>
  


</map>
<map name="Map2">
	<area shape="rect" coords="201,102,295,125" 
		 <% if(request.getSession().getAttribute(IConstants.COMP_USER_ID)!=null){%>
		href="${ctx}/companyRegist2.do?method=companyShowInfo"<% }else{%>
			href="#" onClick="nologinc()"<%}%>>
</map>
</body>

</html:html>
