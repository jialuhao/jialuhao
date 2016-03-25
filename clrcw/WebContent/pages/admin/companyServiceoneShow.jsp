<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.CompService"%>
<script language="JavaScript" type="text/JavaScript">
	
	function checkform() {	

		var sname=document.getElementsByName('name2');	
	   var disnumber=document.getElementsByName('disnumber2');	
		var phone=document.getElementsByName('phone2');
      var losewhyobj=document.getElementsByName('losewhyobj');
		var snames="";
		var disnumbers="";
		var phones="";
		for(i=0;i<sname.length;i++){
			snames=snames+sname[i].value+",";
			disnumbers=disnumbers+disnumber[i].value+",";
			phones=phones+phone[i].value+",";
			}
			document.getElementById('sname').value=snames;
		document.getElementById('disnumber').value=disnumbers;
		document.getElementById('phone').value=phones;
    
		document.getElementById('myform').submit();
			
		
	}
	  function delectRow(r){
		  var i=r.parentNode.parentNode.rowIndex;
		   var tab=document.getElementById("testTable");
		   tab.deleteRow(i);
		  }   
	function add(){
        var newTR =document.getElementById("testTable").insertRow(document.getElementById("testTable").rows.length);  
           newTR.className="trcolor";
            var newNameTD = newTR.insertCell(0);  
           newNameTD.innerHTML = "<input type='text' id='name2' name='name2' style='width: 100px'/>";  
            var newNameTD = newTR.insertCell(1);  
           newNameTD.innerHTML = "<input type='text' id='disnumber2' name='disnumber2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(2);  
           newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(3);  
           newNameTD.innerHTML = "<input type='button'  value='删除' class='button' onclick='delectRow(this)'/>";
           newNameTD.align = "center";
 }
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查看招用名单</title>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<style>
	  #main{width:945px;_width:960px;}
	  ul#list1 li{margin-right:7px;}
	  ul#list1 {
	/* float: left; */
	/* padding:10px 0 0 0; */
}
	</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<iframe id="iframe_head" src="http://211.99.136.80/headindex.html"
				frameborder="0" scrolling="no" height="150" width="960">
			</iframe>
		</div>
		<div id="main">


<%String compname=(String)request.getSession().getAttribute("compname"); %>

			<div id="content">
				<h2>
					企业[<%=compname %>]招聘 &nbsp;&nbsp;
					
				</h2>
				<div class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=companyShowInfo">&equiv;&nbsp;企业基本情况</a>
						</li>
						
						<li class="liH1">
							<a href="${ctx}/admin/aglientpublish.do?method=showPubJob"
								style="color: #BD0403;">&equiv;&nbsp;企业招聘信息 </a>
						</li>

						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showCompResume">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showCompAbility">&equiv;&nbsp;人才库管理</a>
						</li>
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0; clear:both;">
					<form action="${ctx}/companyServicelog.do?method=saveServicelog" 
						method="post" name="myform" id="myform">
						<input type="hidden" name="sname" id="sname"/>
						<input type="hidden" name="disnumber" id="disnumber"/>					
						<input type="hidden" name="phone" id="phone"/>
						
						
			招聘成功/招聘失败：
				<select id="validflag" name="validflag" disabled="true" >
				 
					<option  <%if(request.getSession().getAttribute("flag")!=null&&request.getSession().getAttribute("flag").equals("3")){%>selected="selected"<%} %>>招聘成功</option>  
  					<option  <%if(request.getSession().getAttribute("flag")!=null&&request.getSession().getAttribute("flag").equals("2")){%>selected="selected"<%} %> >招聘失败</option>
    			</select>
    			<% if(request.getSession().getAttribute("flag")!=null&&request.getSession().getAttribute("flag").equals("3")){%> 
			<div id="a" style="display:block">
						<table class="finktable" id="testTable" summary="企业招聘信息" align="center"
							width="85%">
							
    			<tr class="trcolor">
                          
								<td class="tdFormInput" align="center" width="50%" colspan="6">
									<div align="center">
										<strong>录用名单</strong>
									</div>
								</td>
							</tr>
							<tr>
								<td align="center" >
									姓名
								</td>
								<td align="center" >
									残疾证号
								</td>
								<td align="center" >
									户籍
								</td>
								<td align="center" >
									电话
								</td>
								<td align="center" >
									所在岗位名称
								</td>
								<td align="center" >
									备注
								</td>
								
							
							</tr>
							 <%List list=(List)request.getSession().getAttribute("list");
             
              for(int i=0;i<list.size();i++){
              CompService compservice=(CompService)list.get(i);
               %>
							<tr>
								<td class="tdFormInput" >
									<%=compservice.getName() %>
								</td>
							<td class="tdFormInput" >
									<%=compservice.getNumber() %>
								</td>
							<td class="tdFormInput" >
									<%=compservice.getHouse() %>
								</td>
								
								<td class="tdFormInput" >
										<%=compservice.getPhone() %>
								</td>
                                  <td class="tdFormInput" >
										<%=compservice.getWorkname() %>
								</td>
								<td class="tdFormInput" >
										<%=compservice.getRemark() %>
								</td>

							</tr>
							<% }%>
						</table>
     </div>
     <%} %>
     <%if(request.getSession().getAttribute("flag")!=null&&request.getSession().getAttribute("flag").equals("2")){
      List list=(List)request.getSession().getAttribute("list");
             
              
              CompService compservice=(CompService)list.get(0);
             String otherwhy=compservice.getOtherwhy();
             if(otherwhy==null){
             otherwhy="";
             }%>
                 	<div id="b" style="display:block">
						<table class="finktable" id="grzpjl" summary="企业招聘信息"
							align="center" width="85%">


							<tr>
								<td width="100" style="text-align: left;">
									未招用原因：
									<input type="checkbox" name="losewhyobj" disabled="true" id="losewhyobj1" value="1" />
									无合适人员
									
									<input type="checkbox" name="losewhyobj" disabled="true" id="losewhyobj2" value="2" />
									岗位调整
									<input type="checkbox" name="losewhyobj" disabled="true" id="losewhyobj3" value="3" />
									其它: <%= otherwhy%>

								</td>
							</tr>

							</table>
            </div>
            <%} %>
									
									<input type="button" onclick="history.go(-1)" value="返回" />
								
						
						<br />
						</form>
				</div>
			</div>
		</div>


		<iframe src="/clrcw/public/include/footer.html" height="150"
			width="960" id="iframe_foot" frameborder="0" scrolling="no"
			title="底部脚本"></iframe>


<% List list=(List)request.getSession().getAttribute("list");
             
              
              CompService compservice=(CompService)list.get(0);%>
	</div>
	<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
<script type="text/javascript">

	checkeds('<%=compservice.getLosewhy() %>','losewhyobj');
	
	function checkeds(val,column) {

		var vals1=val.split(',');
		for(i=0;i<vals1.length&&vals1[i]!='';i++){
			document.getElementById(column+vals1[i]).checked=true;
		}
		}
</script>
</html:html>
