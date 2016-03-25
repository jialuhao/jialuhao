<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@page import="model.PersonResume"%>

<%
//  String id = (String)request.getAttribute("id"); 
//PersonResume personResume=PersonRegist3.getPersonResume(id);
  PersonResume personResume=(PersonResume)request.getAttribute("pr");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<title>企业招聘意向</title>


<link rel="stylesheet" type="text/css" href="/clrcw/styles/public.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/mainframe.css" />
<link rel="stylesheet" type="text/css" href="/clrcw/styles/modelist.css" />

<link rel="stylesheet" type="text/css" id="ABTStyle" href="/clrcw/styles/skin.css" />
<link href="/clrcw/css/index.css" rel="stylesheet" type="text/css" />
<script src="/clrcw/scripts/public.js" type="text/javascript"></script>
<script src="/clrcw/scripts/menu.js" type="text/javascript"></script>
<script type="text/javascript">
function search1(){
	document.searchFrom1.action="${ctx}/personSearch.do?method=showAll";
	document.searchFrom1.submit();
}
function change(s_id){
    document.form1.pageIndex.value=s_id;
    document.form1.action="${ctx}/personRegist9.do?method=showOtherPage";
	document.form1.submit();
}
</script>
</head>
<body>
<div id="container">
<!--<div id="header">
 <iframe id="iframe_head" src="http://211.99.136.80/headindex.html" frameborder="0" scrolling="no"
	height="150" width="960"> </iframe>
	</div>
  --><div id="main">
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="5">   </td>
  </tr>
</table>

<div id="content">
    	<h2>个人用户【${personUserId}】信息&nbsp;&nbsp; <a href="${ctx}/logout.do?method=logout"  style="color:#BD0403;">[退出]</a></h2>
		
        <div class="formdiv">

		<ul id="list1">
       	  	  <li><a href="${ctx}/personRegist3.do?method=personRegist3">1. 基本情况</a></li>
        	  <li><a href="${ctx}/personRegist4.do?method=personRegist4">2.工作/实习经历  </a></li> 
              <li><a href="${ctx}/personRegist5.do?method=personRegist5">3.自我评价 </a> </li>
              <li><a href="${ctx}/personApplyList.do?method=personApplyList"> 4.欲求职位  </a> </li>
              <li><a href="${ctx}/personRegist8.do?method=personRegist8">5.教育经历  </a></li> 
              <li><a href="${ctx}/resumeView.do?method=resumeView" target="_blank">6.个人简历预览</a></li>
              <li><a href="${ctx}/personRegist9.do?method=showAll" >7. 职位搜索</a></li>
              <li class="liH1"> <a href="${ctx}/personShowCompInfo.do?method=showCompInfo" >8. 企业招聘意向</a></li>
        </ul>
<br/>
		<form name="searchFrom1" action="#" method="post">
		<p class="p_text"><label for="textfield3">职位搜索：</label><input name="textfield3" type="text"	title="请输入要查询的职位"
				id="textfield3" />
				<img src="<%=request.getContextPath()%>/images/index_39.jpg" width="21" height="19" alt="搜索" onClick="search1()">
						</form>
        <table id="form_1" class="finktable"  >
  <tr>
    
	<th valign="top" >
	   <table class="finktable" ><tr>
	 <th  style="color:#6E1F00;
		font-weight:normal;
		font-size:12px;width:100px;">  公司名称               </th>
	   <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;width:100px;">招聘职位                                 </th>
    <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;width:100px;">  招聘人数                </th>
		 <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;width:100px;">学历</th>
	   
	 
	    <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;width:100px;">工作地点</th>
	   
	   
    <th  style="color:#6E1F00;
		font-weight:normal;
		padding:10px;font-size:12px;width:100px;">发布时间</th>
	   
	   
	   </tr>
	      
	   <form action="" name="form1" method="POST">
	   <logic:present name="CompBespeak">
												<logic:notEmpty name="CompBespeak">
													<logic:iterate name="CompBespeak" id="compbespeak"
														type="model.CompBespeak">
														<tr>
															<td width="150px" height="23" align="center"
																  ><a class="p" target="_blank" align="left" style="color:#000000;font-size:12px;" > 
																  <bean:write
																property="compName" name="compbespeak" /></a>
															</td>

															<td width="150px" align="center" style="color:#000000;font-size:12px;"   ><a class="p"> 
															<bean:write property="compAddr" name="compbespeak" /> </a></td>
<td width="150px" align="left" style="color:#000000;font-size:12px;"  ><bean:write
															property="telephone" name="compbespeak" /></td>
															<td width="150px" align="center" style="color:#000000;font-size:12px;"  ><bean:write
															property="linkman" name="compbespeak" /></td>
															<td width="150px" align="center" style="color:#000000;font-size:12px;"  ><bean:write
															property="mail" name="compbespeak" /></td>
															<td width="150px" align="center" style="color:#000000;font-size:12px;"  ><bean:write
															property="comparea" name="compbespeak" /></td>
														</tr>
													</logic:iterate>
													
												</logic:notEmpty>
												<logic:empty name="compbespeak">
													<p class="font5">没有企业关注信息!</p>
												</logic:empty>
											</logic:present>

										
										</table>
										</form>
	   
	  </table>
	
	
	</th>
    
  </tr>
  
</table>

        </div>
    </div>
    </div>

   
    <iframe src="/clrcw/public/include/footer.html" height="150" width="960" id="iframe_foot" frameborder="0" scrolling="no" title="底部脚本"></iframe>
   
 
 
</div>
<script type="text/javascript" src="/clrcw/scripts/shanDong.js" id="ABT"></script>
<script type="text/javascript" src="/clrcw/scripts/public.js"></script>

</body>
</html:html>
