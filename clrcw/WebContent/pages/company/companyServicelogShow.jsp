<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Servicepeople"%>
<script language="JavaScript" type="text/JavaScript">
	function chekmessage(){
	var sname=document.getElementsByName('name2');	
	   var disnumber=document.getElementsByName('disnumber2');	
		var phone=document.getElementsByName('phone2');
      var validflag=document.getElementById('validflag');
      if(validflag.value=""){
      alert("请选择招聘成功或失败");
      return false;
      }
      for(i=0;i<sname[i].value.length;i++){
      if(sname[i].value=""){
      alert("名字为空");
      return false;
      }
      }
       for(i=0;i<disnumber[i].value.length;i++){
      if(disnumber[i].value=""){
      alert("残疾号为空");
      return false;
      }
      }
       for(i=0;i<phone[i].value.length;i++){
      if(phone[i].value=""){
      alert("电话为空");
      return false;
      }
      }
      return true;
	}
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
           newNameTD.innerHTML = "<input type='text' id='name2' name='name2' style='width: 100px' />";  
            var newNameTD = newTR.insertCell(1);  
           newNameTD.innerHTML = "<input type='text' id='disnumber2' name='disnumber2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(2);  
           newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(3);  
            newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(4);  
            newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px' />";  
           var newNameTD = newTR.insertCell(5);  
           newNameTD.innerHTML = "<input type='button'  value='删除' class='button' onclick='delectRow(this)'/>";
           newNameTD.align = "center";
 }
  function add1(){
        var newTR =document.getElementById("person").insertRow(document.getElementById("person").rows.length);  
           newTR.className="trcolor";
            var newNameTD = newTR.insertCell(0);  
           newNameTD.innerHTML = "<input type='text' id='name2' name='name2' style='width: 100px' />";  
            var newNameTD = newTR.insertCell(1);  
           newNameTD.innerHTML = "<input type='text' id='disnumber2' name='disnumber2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(2);  
           newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(3);  
            newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(4);  
            newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px' />";  
                    var newNameTD = newTR.insertCell(5);  
            newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(6);  
            newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px' />"; 
           var newNameTD = newTR.insertCell(7);  
           newNameTD.innerHTML = "<input type='button'  value='删除' class='button' onclick='delectRow(this)'/>";
           newNameTD.align = "center";
 }
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>企业基本情况填写</title>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
<style>
	  #main{width:898px;}
	  ul#list1 li{margin-right:7px;}
	  ul#list1 {
	/* float: left; */
	/* padding:10px 0 0 0; */
}
	</style>
</head>
<body>
	




			<div id="content">
				
					<div style="height: 1px; background: #ededed; width: 100%; clear:both;"></div>
				</DIV>
<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form action="${ctx}/companyServicelog.do?method=saveServicelog" 
						method="post" name="myform" id="myform">
			
		


         <table width="115%" align="center" class="finktable" id="testTable" summary="企业招聘信息" >

							<tr class="trcolor">

								<td class="tdFormInput" align="center" colspan="8">
									<div align="center">
										<strong>单位 基本情况</strong>
									</div>
								</td>
							</tr>
							<tr >
							<td width="8%" align="left" >
									单位名称							  </td>
								<td width="13%" align="center">									
									<input type="text" id="comname" name="comname"  />					
							  </td>
								<td width="15%" align="center" >
									证照类型								</td>
								<td width="15%" align="center" >
									<input type="text" id="cardtype" name="cardtype"  />
							  </td>
								<td width="15%" align="center"  >
									证照代码								</td>
								<td align="center" colspan='3'>
									<input type="text" id="cardnumber," name="cardtype"  />
								</td>
							</tr>
								<tr>
							<td align="center" >
									联系人
								</td>
								<td align="center" >
									<input type="text" id="contacts" name="contacts" />
								</td>
								<td align="center" >
									联系电话
								</td>
								<td align="center" >
									<input type="text" id="phone" name="cardtype" />
								</td>
								<td align="center" >
									公司地址
								</td>
								<td width="15%" align="center" >
									<input type="text" id="adress" name="adress" />
								</td>
								<td width="4%" align="center" >
									邮编								</td>
								<td width="15%" align="center" >
									<input type="text" id="postcode" name="postcode" />
								</td>
							</tr>
							<tr>
							<td align="center" colspan='2'>
									服务记录
							  </td>
							<td align="center" >
									记录时间
							  </td>
								<td align="center" >
									<input type="text" id="writetime" name="writetime" />
								</td>
								<td align="center" >
									记录区县
								</td>
								<td align="center" >
										<input type="text" id="writeare" name="writeare" />
								</td>
								<td align="center" >
									记录人
								</td>
								<td align="center"  colspan='2' >
										<input type="text" id="writepeople" name="writepeople" />
								</td>
							</tr>
							<tr>
							<td align="center" >
									招聘周期
							  </td>
								<td align="center" >
										<input type="text" id="seasonal" name="seasonal" />
								</td>
								<td align="center" >
								岗位名称
								</td>
								<td align="center" >
										<input type="text" id="jobname" name="jobname" />
								</td>
								<td align="center" >
								人数
								</td>
								<td align="center"   colspan='3'>
										<input type="text" id="number" name="number" />
								</td>
								
							</tr>
							
							<tr >

								<td class="tdFormInput" align="center" colspan="8">
									<div align="center">
										<strong>推荐记录</strong>
									</div>
							  </td>
							</tr>
								<tr>
							
							<td align="center" colspan='2'>
									推荐岗位
								</td>
								
								<td align="center" >
									推荐人姓名
								</td>
								
								<td align="center" >
									残疾类别
								</td>
								
								<td align="center" >
									电话
								</td>
								
								<td align="center" colspan='2'>
									推荐人
								</td>
								<td align="center" >
									操作
								</td>
							</tr>
							<tr  >
							<td align="center"  colspan="2" >
										<input type="text" id="commedjob" name="commedjob" />
							  </td>
								<td align="center" >
									<input type="text" id="commedname" name="commedname" />
								</td>
								<td align="center" >
										<input type="text" id="commedlevel" name="commedlevel" />
								</td>
								<td align="center" >
										<input type="text" id="commedphone" name="commedphone" />
								</td>
								<td align="center" colspan="2">
										<input type="text" id="commedpeople" name="commedpeople" />
								</td>
								<td class="tdFormInput"  align="center">
								<input type='button'  value='添加' class='button' onclick='add()'/></td>
								
							</tr>
			  </table>
							<table width="104" id="person">
							<tr class="trcolor" >

								<td class="tdFormInput" align="center" width="50%" colspan="8">
									<div align="center">
										<strong>招用人员花名册</strong>
									</div>
								</td>
							</tr>
							
							<tr>
								<td align="center" >
									序号
								</td>
								<td align="center" >
									姓名
								</td>
								<td align="center" >
									残疾人证件号码
								</td>
								<td align="center" >
									户籍
								</td>
								<td align="center">
									电话
								</td>
								<td align="center" >
								          所在岗位名称
								</td>
								<td align="center" >
								       备注
								</td>
								<td align="center" >
									操作
								</td>
							</tr>
							<%
								List<Servicepeople> list= (List<Servicepeople>)request.getAttribute("allServicepeople");
								
									if(list!=null&&list.size()>0){
									for (int i = 0; i < list.size(); i++) {
										Servicepeople servicepeople = (Servicepeople) list.get(i);
										
							%>
							<tr>
							<td align="center"   >
										<input type="text" id="sequence" name="sequence" value="i+1" />
							  </td>
								<td align="center" >
										<input type="text" id="sname" name="sname" value="<%=servicepeople.getSname()%>"/>
								</td>
								<td align="center" >
										<input type="text" id="snumber" name="snumber" value="<%=servicepeople.getDisnumber()%>"/>
								</td>
								<td align="center" >
										<input type="text" id="register" name="register" value="<%=servicepeople.getPhone()%>"/>
								</td>
								<td align="center" >
										<input type="text" id="sphone" name="sphone" />
								</td>
								<td align="center" >
										<input type="text" id="sjob" name="sjob" />
								</td>
								<td align="center" >
										<input type="text" id="remark" name="remark" />
								</td>
								<td class="tdFormInput"  align="center">
								<input type='button'  value='添加' class='button' onclick='add1()'/></td>
								
							</tr>
							<% }
							}
							%>
              </table>
                         <table width="1251">
							<tr>
								<td width="1066" style="text-align: left;">
									未招用原因：
									<input type="checkbox" name="losewhyobj" id="losewhyobj" value="1" />
									无合适人员
									
									<input type="checkbox" name="losewhyobj" id="losewhyobj" value="2" />
									岗位调整
									<input type="checkbox" name="losewhyobj" id="losewhyobj" value="3" />
									其它

							  </td>
							</tr>
	<tr>



								<td style="text-align: left;">
									在招聘和雇佣残疾人过程中，需要提供哪些服务：
									<br>
									<br>
									<input type="checkbox" name="problem1obj" id="problem1obj1" value="1" />
									健全员工基本手语培训
									<input type="checkbox" name="problem1obj" id="problem1obj2" value="2" />
									残疾人职业适应性指导
									<br>
									<input type="checkbox" name="problem1obj" id="problem1obj3" value="3" />
									应聘残疾人职业素质测评（由人力资源测评专业公司提供）
									<br>
									<input type="checkbox" name="problem1obj" id="problem1obj4" value="4" />
									其他
								</td>
			  </tr>
							<tr>
								<td style="text-align: left;">
									意见、建议：
									<br>
									<textarea name="opinion" title="请输入意见、建议" id="opinion"
										cols="70" rows="3"></textarea>
									
								</td>
								
							</tr>
					  </table>
							
							
                         <input type="button" value="提交"  onclick="javascript:checkform()"/>
									<input type="button" value="返回" />
								
						
						<br />
		
                 </form>

                <jsp:include page="../admin/include/footer.jsp"></jsp:include>

				<script type="text/javascript" src="/clrcw/scripts/shanDong.js"
		id="ABT"></script>
	<script type="text/javascript" src="/clrcw/scripts/public.js"></script>
</body>
<script type="text/javascript">
function showOrHide(obj){
 if(obj.value=="3"){
  document.getElementById("a").style.display="block";
  document.getElementById("b").style.display="none";
 }
 else if(obj.value=="2"){
 document.getElementById("a").style.display="none";
  document.getElementById("b").style.display="block";
 }
}
</script>
</html:html>
