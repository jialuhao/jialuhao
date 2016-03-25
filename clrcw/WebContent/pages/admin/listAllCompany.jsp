<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.CompBespeak"%>
<%int pagenum = (Integer) request.getSession().getAttribute("pagenum");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>已审核企业页面</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
function resetss(){
	
	document.getElementById("qname").value="";
   
  
}
function batch_del(){
    if(hasSelect()){
       if(confirm ("是否真要禁用？")){
       	  document.getElementById("pnum").value="<%=pagenum%>";
          document.forms[0].action="${ctx}/admin/showAllCompany.do?method=batchUpdateCompany";
          document.forms[0].submit();
        }
	  }else{
	 	 alert("您还没有选择要禁用的选项");
	  }
  }
function change(s_id){
    document.getElementById("pnum").value=s_id;
    document.forms[0].action="${ctx}/admin/listAllCompany.do?method=nextShowAllCompany";
	document.forms[0].submit();
}
function search(){
 	   document.forms[0].action="${ctx}/admin/listAllCompany.do?method=showAllCompany";
       document.forms[0].submit();
 }
function showbespeak(s_id){
	document.form1.userId.value=s_id;
	document.form1.action="${ctx}/admin/listAllCompany.do?method=showOneCompany";
	document.form1.submit();
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
<body>
<jsp:include page="include/contentHeader.jsp">
<jsp:param name="contentTitle" value="企业信息统计"/>
</jsp:include>
<form action="" name="form1" method="post">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
      	<tr style="height: 20px">
			<td align="left" bgcolor="#FFFFFF" class="font5" style="padding-left: 30px;">
				企业名称：
				<input type="text" id="qname" name="qname" value="<%=session.getAttribute("qname")!=null?session.getAttribute("qname"):"" %>"/></td>
		<%String areacode=(String)request.getSession().getAttribute("areacode1"); 
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
				    
				</select></td>
				<%} %>
		</tr>
		</tr>
         <tr style="height: 20px">
         		<td align="center" colspan="2">
          <input type="button" style="width: 75px;border: 0px;" value="查询" onclick="search()"/>&nbsp;&nbsp;
           <input type="button" style="width: 75px;border: 0px;" value="重置" onclick="resetss()"/>&nbsp;&nbsp;
      	 </td>
 	 </tr>
  </table>
<input type="hidden" id="pnum" name="pnum" value="">
<input type="hidden" id="userId" name="userId" value="">
<table width="99%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cccccc">
 
  <tr>
    <td width="5%" align="center" bgcolor="#EEF5FD" class="font5"><a href="javascript:selectAll()" id="selectBox">全选</a></td>
    <td width="20%" align="center" bgcolor="#FFF7F0" class="font5">企业名称</td>
    <td width="20%" align="center" bgcolor="#FFF7F0" class="font5">法人</td>
    <td width="20%" align="center" bgcolor="#FFF7F0" class="font5">法人</td>
    <td width="13%" align="center" bgcolor="#FFF7F0" class="font5">代理人</td>
    <td width="12%" align="center" bgcolor="#FFF7F0" class="font5">联系电话</td>
    <td width="10%" align="center" bgcolor="#FFF7F0" class="font5">查     	看</td>
  </tr>
   <%
		List list = (List) request.getSession().getAttribute("bespeak");
         
		int zshu=(Integer)request.getSession().getAttribute("zongshu");
		int pc = (Integer) request.getSession().getAttribute("totleCount");
		if(list!=null&&list.size()>0){
		for (int i = 0; i < list.size(); i++) {
			CompBespeak bespeak = (CompBespeak) list.get(i);
			String aglient=bespeak.getAglientcode();
			if(aglient==null){
			aglient="无";
			}
	%>
  <tr style="height: 20px">
		<td align="center" bgcolor="#FFFFFF" class="font5"><input style="width: 45px;border: 0px;" name="ids" type="checkbox" value="<%=bespeak.getId()%>"/></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getCompName()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getCompAddr()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getLinkman()%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=aglient%></td>
		<td align="center" bgcolor="#FFFFFF" class="font5"><%=bespeak.getTelephone()%></td>

		<td align="center" bgcolor="#FFFFFF">
			<a href="#" class="list" onClick="showbespeak('<%=bespeak.getId()%>')">进入</a>
		</td>
	</tr>

	<%
		}}else{
		%><font class="font3"> 没有企业信息!</font><%
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
			onClick="change(<%=request.getSession().getAttribute("totleCount") %>)">尾页&nbsp;</a></td>
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
			onClick="change(<%=request.getSession().getAttribute("totleCount") %>)">尾页&nbsp;</a></td>
	</tr>

	<%
		}
	%>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40">&nbsp;
    </td>
  </tr>
</table>
</form>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
