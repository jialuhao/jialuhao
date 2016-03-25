<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.UserInfo"%>
<%@ page import="model.PersonResume"%>
<%@ page import="model.BdPost"%>
<%
int pagenum = (Integer) request.getSession()
				.getAttribute("apppagenum");
 %>
<script language="JavaScript" type="text/JavaScript">
function resetss(){
	
	document.getElementById("qname").value="";
   document.getElementById("qmail").value="";
  
}
function change(s_id){
    document.getElementById("pnum").value=s_id;
    document.forms[0].action="${ctx}/admin/nextfindAllUserId.do?method=nextfindAllUserIdbymanage";
	document.forms[0].submit();
}
function del(s_id,password,pn){
	var b = confirm("确实要删除吗？");
	if(b){
	    document.getElementById("delId").value=s_id;
	    document.getElementById("password").value=password;
	    document.getElementById("pnum").value=pn;
	    document.forms[0].action="${ctx}/admin/delUser.do?method=delUser";

		document.forms[0].submit();
	
	}else{
		return false;
	}
}
function search(){
 	   document.forms[0].action="${ctx}/admin/findAllUserId.do?method=findAllUserIdbymanage";
       document.forms[0].submit();
 }
function batch_del(){
    if(hasSelect()){
       if(confirm ("是否真要删除？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
          document.forms[0].action="${ctx}/admin/delUser.do?method=bathDelUser";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要删除的选项");
	  }
  }
   function hasSelect(){
    var cbs = document.getElementsByName("ids");
     for(i=0;i<cbs.length;i++){
       if(cbs[i].checked==true)
         return true;
     }
     return false;
  }
function selectAll(){
    var cbs = document.getElementsByName("ids");
     for(i=0;i<cbs.length;i++){
       cbs[i].checked=true;
     }
    selectBox.href="javascript:unSelectAll()";
    selectBox.innerText="不选";
  }
  function unSelectAll(){
    var cbs = document.getElementsByName("ids");
     for(i=0;i<cbs.length;i++){
       cbs[i].checked=false;
     }
    selectBox.href="javascript:selectAll()";
    selectBox.innerText="全选";
  }
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人用户目录管理</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
</head>

<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="个人用户信息列表" />
</jsp:include>
<form action="" name="form1" method="POST">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
      	<tr style="height: 20px">
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				求职人姓名：
				<input type="text" id="uname" name="uname" value="<%=session.getAttribute("uname")!=null?session.getAttribute("uname"):"" %>"/></td>
			
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				残疾类别：
				 <select name="postId" id="postId">
					<option value="">--请选择--</option>
				 	
						<%		String dkind=(String)request.getSession().getAttribute("postId");

															List bdPostlist = (List) request.getSession().getAttribute("bdPost");

																if (bdPostlist != null) {

																	for (int i = 0; i < bdPostlist.size(); i++) {
																		BdPost bdPost = new BdPost();
																		bdPost = (BdPost) bdPostlist.get(i);
														%>
														<option value="<%=bdPost.getId()%>" <%if((bdPost.getId()+"").equals(dkind)){ %>selected<%} %>><%=bdPost.getPostName()%></option>
														<%
															}
																}
														%>
				</select>	</td>
			
			
		
		
		<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				最高学历：
				<select name="education" id="education">
					<option value="">--请选择--</option>
					
					<option value="5" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("5")){%>selected="selected"<%} %>>小学</option>
					<option value="6" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("6")){%>selected="selected"<%} %>>初中</option>
					<option value="7" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("7")){%>selected="selected"<%} %>>高中</option>
					<option value="8" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("8")){%>selected="selected"<%} %>>技工学校</option>
					<option value="9" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("9")){%>selected="selected"<%} %>>中专或中技</option>
					<option value="10" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("10")){%>selected="selected"<%} %>>大学专科和专科学校</option> 
					<option value="11" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("11")){%>selected="selected"<%} %>>大学本科</option>
					<option value="12" <%if(session.getAttribute("education")!=null&&session.getAttribute("education").equals("12")){%>selected="selected"<%} %>>研究生</option>
				</select></td>
				
				<%String areacode=(String)request.getSession().getAttribute("areacode"); 
		if(!areacode.equals("")){
		%>
				<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				区县：<br/>
				<select name="workyear" id="workyear">
				    <option value="">--请选择--</option>
					<option value="东城区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("东城区")){%>selected="selected"<%} %>>东城区</option>   
				    <option value="西城区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("西城区")){%>selected="selected"<%} %>>西城区</option> 
			        <option value="朝阳区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("朝阳区")){%>selected="selected"<%} %>>朝阳区</option>   
				    <option value="丰台区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("丰台区")){%>selected="selected"<%} %>>丰台区</option> 
				    <option value="石景山区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("石景山区")){%>selected="selected"<%} %>>石景山区</option>   
				    <option value="海淀区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("海淀区")){%>selected="selected"<%} %>>海淀区</option> 
				    <option value="门头沟区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("门头沟区")){%>selected="selected"<%} %>>门头沟区</option>   
				    <option value="燕山区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("燕山区")){%>selected="selected"<%} %>>燕山区</option> 
				    <option value="房山区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("房山区")){%>selected="selected"<%} %>>房山区</option>   
				    <option value="通州区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("通州区")){%>selected="selected"<%} %>>通州区</option> 
				    <option value="顺义区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("顺义区")){%>selected="selected"<%} %>>顺义区</option>   
				    <option value="昌平区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("昌平区")){%>selected="selected"<%} %>>昌平区</option> 
				     <option value="大兴区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("大兴区")){%>selected="selected"<%} %>>大兴区</option>   
				    <option value="怀柔区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("怀柔区")){%>selected="selected"<%} %>>怀柔区</option> 
				    <option value="平谷区" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("平谷区")){%>selected="selected"<%} %>>平谷区</option>   
				     <option value="外埠" <%if(session.getAttribute("workyear")!=null&&session.getAttribute("workyear").equals("外埠")){%>selected="selected"<%} %>>外埠</option> 
				</select></td>
				<% }%>
				
				</tr>
           <tr style="height: 20px">
           		<td colspan="4" align="center">
		          <input type="button" style="width: 75px;border: 0px;" value="查询" onclick="search()"/>&nbsp;&nbsp;
		           <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/>&nbsp;&nbsp;
	       	 </td>
	  	 </tr>
	   </table>
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
	<input type="hidden" id="pnum" name="pnum"  />
	<html:hidden property="delId" value="" />
	<html:hidden property="password" value="" />
	<tr style="height: 20px">
		
		<td width="5%" align="center" bgcolor="#EEF5FD" class="font5">编号</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">求职人姓名</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">残疾类别</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">户籍所在地</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">联系电话</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">代理人</td>
		<td width="15%" align="center" bgcolor="#EEF5FD" class="font5">操作</td>
		
	</tr>
	<%
		List list = (List) request.getSession().getAttribute("personresume");
		int zshu=(Integer)request.getSession().getAttribute("appzongshu");
		int pc = (Integer) request.getSession().getAttribute("apptotleCount");
        
      
		for (int i = 0; i < list.size(); i++) {
			PersonResume userInfo = (PersonResume) list.get(i);
			String aglient=userInfo.getAglientcode();
        if(aglient==null||aglient==""){
        aglient="无";
        }
			
	%>
	<tr style="height: 20px">
		
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=pagenum * 10 + i + 1%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getName()  %></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getDkind()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getHomeplace()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=userInfo.getPhone()%></td>
      <td align="center" bgcolor="#FFFFFF" class="font5"><%=aglient%></td>
		<td align="center" bgcolor="#FFFFFF"><a href="${ctx}/companyAbility.do?method=showOneResumes&userKeyId=<%=userInfo.getUser().getId()%>" class="list" >查看</a>
		</tr>

	<%
		}
	%>
	<%
		if (pagenum == pc && pc != 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a></td>
	</tr>

	<%
		} else if (pagenum == 0 && pc != 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a>
		<a href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("apptotleCount") %>)">尾页&nbsp;</a></td>
	</tr>
	<%
		} else if (pagenum == 0 && pc == 0) {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9"></td>
	</tr>
	<%
		} else {
	%>
	<tr style="height: 20px">
		<td height="23" colspan="7" align="right" bgcolor="FEF9F9">总数：<%=(zshu+"  ") %>&nbsp;&nbsp;<%=pagenum+1%>/<%=pc+1 %>&nbsp;&nbsp;<a
			href="#" class="list" onClick="change(0)">首页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>-1)">上一页</a> <a href="#"
			class="list" onClick="change(<%=pagenum%>+1)">下一页&nbsp;</a> <a
			href="#" class="list"
			onClick="change(<%=request.getSession().getAttribute("apptotleCount") %>)">尾页&nbsp;</a></td>
	</tr>

	<%
		}
	%>

</table>
</form>
<table width="100%" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="40">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="1" bgcolor="94C2F1"></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>
