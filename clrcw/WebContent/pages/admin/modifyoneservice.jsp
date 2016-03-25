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
<script type="text/javascript" src="/clrcw/js/jquery-1.8.2.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
 
 <%Servicelog servicelog=(Servicelog)request.getSession().getAttribute("servicelog");
 String otherwhy=servicelog.getOtherwhy();
 if(otherwhy==null){
 otherwhy="";
 }
 List aaa=(List)request.getSession().getAttribute("servicepeople");%>
 function bbb(){
 alert("aa");
if(aaa.size>0){
  document.getElementById("a").style.display="block";
  document.getElementById("b").style.display="none";
 }
 else if(servicelog.getLosewhy()!=null&&servicelog.getLosewhy()!=""){
 document.getElementById("a").style.display="none";
  document.getElementById("b").style.display="block";
 }
};
window.onload=bbb;
function aaaaa(){
	 var losewhyobj=document.getElementsByName('losewhyobj');
	if(!losewhyobj[2].checked){
		document.getElementById("otherparts").value="";
		
	}else{
	document.getElementById("otherparts").value="<%=otherwhy%>";
	}
	}
  function delectRow1(r){
		  var i=r.parentNode.parentNode.rowIndex;
		   var tab=document.getElementById("table");
		   tab.deleteRow(i);
		  } 
 
 var j=0;
 function adds(a){
 j++;
        var newTR =document.getElementById("table").insertRow(document.getElementById("table").rows.length); 
 
           newTR.className="trcolor";
            var newNameTD = newTR.insertCell(0);  
           newNameTD.innerHTML = a;  
          newNameTD.align = "center";
           var newNameTD = newTR.insertCell(1);  
           newNameTD.innerHTML = "<input type='text' id='"+j+"cardnumber' name='cardnumber2'  style='width: 170px'/> <input type='button'  value='查询' class='button' onclick='querymessage2("+j+")'/>";  
           newNameTD.align = "center";
            var newNameTD = newTR.insertCell(2);  
           newNameTD.innerHTML = "<input type='text' id='"+j+"commedname' name='commedname2'  style='width: 100px'/>";  
           newNameTD.align = "center";
           var newNameTD = newTR.insertCell(3);  
           newNameTD.innerHTML =  "<input type='text' id='"+j+"commedlevel' name='commedlevel2'  style='width: 100px'/>";  
         newNameTD.align = "center";
           var newNameTD = newTR.insertCell(4);  
           newNameTD.innerHTML = "<input type='text' id='"+j+"commedphone'  name='commedphone2'  style='width: 130px'/>";  
            newNameTD.align = "center";
            var newNameTD = newTR.insertCell(5);  
           newNameTD.innerHTML = "<input type='text' id='commedpeople2' name='commedpeople2'  style='width: 100px'/>";   
          newNameTD.align = "center";
           var newNameTD = newTR.insertCell(6);            
           newNameTD.innerHTML = "<input type='button'  value='删除' class='button' onclick='delectRow1(this)'/>";
           newNameTD.align = "center";
 }
 function querymessage2(a){
 
  var cardnumber=a+"cardnumber";
 var commedname=a+"commedname";
 var commedlevel=a+"commedlevel";
 var commedphone=a+"commedphone";
 var number=document.getElementById(cardnumber).value;
 
  $.ajax({
		    url : "${ctx}/admin/findAllpublishJob.do?method=modifyserviceJob1",
		    dataType: "text",
		    type:"GET",
		     data: "snumber="+number,
		    success: function(result) {
		    	
		  var results=result.split(",");
		  	document.getElementById(commedname).value=results[0]; 
		  	document.getElementById(commedlevel).value=results[1]; 
		  	document.getElementById(commedphone).value=results[2];    
		  	  
		  	   },
		    error: function(result) {
		  	 alert("无此信息"); 
		  	  
		    }
		  });
  }
 function querymessage(a){
 
  var cardnumber="cardnumber"+a;
 var commedname="commedname"+a;
 var commedlevel="commedlevel"+a;
 var commedphone="commedphone"+a;
 var number=document.getElementById(cardnumber).value;
 
  $.ajax({
		    url : "${ctx}/admin/findAllpublishJob.do?method=modifyserviceJob1",
		    dataType: "text",
		    type:"GET",
		     data: "snumber="+number,
		    success: function(result) {
		    	
		  var results=result.split(",");
		  	document.getElementById(commedname).value=results[0]; 
		  	document.getElementById(commedlevel).value=results[1]; 
		  	document.getElementById(commedphone).value=results[2];    
		  	  
		  	   },
		    error: function(result) {
		  	 alert("无此信息"); 
		  	  
		    }
		  });
  }
 
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>修改一条服务记录</title>
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
						<input type="hidden" name="cardnumber" id="cardnumber"/>
						<input type="hidden" name="commedpeople" id="commedpeople"/>
						<input type="hidden" name="losewhyobjs" id="losewhyobjs"/>
						<input type="hidden" name="problem1objs" id="problem1objs"/>
         <table width="100%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc" summary="企业招聘信息" >
<%
						PublishJobInfo job=(PublishJobInfo)request.getSession().getAttribute("job");
							String jobname=job.getJob().getJobName();
							 %>
							
							
							<tr><td colspan="8">
							 <%String flag=(String)request.getSession().getAttribute("flag"); %>
			 是否招到合适人员：
				<select id="validflag" name="validflag" onchange="javascript:showOrHide(this);" >
					<option value="">--请选择--</option>  
					<option value="3" <%if(aaa.size()>0){%> selected="selected"<%} %>>招聘成功</option>  
  					<option value="2" <%if(aaa.size()==0){%> selected="selected"<%} %>>招聘失败</option>
    			</select>
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
								<input type="text" id="writetime" name="writetime"  value="<%=servicelog.getWritetime()%>"/>	
								</td>
								<td align="center" >
									记录区县
								</td>
								
								<td>
									<select name="writeare" id="writeare" title="">
										<%
											List sss = (List) request.getSession().getAttribute("arealist");
												for (int i = 0; i < sss.size(); i++) {
													Areacode areacode = (Areacode) sss.get(i);
										%>
										<option <%if((servicelog.getWriteare()).equals(areacode.getAreaname())) {%> selected="selected" <%}%> value="<%=areacode.getAreacode()%>"><%=areacode.getAreaname()%></option>
										<%
											}
										%>
									</select>
									</td>
								<td align="center" >
									记录人
								</td>
								<td align="center"  colspan='2' >
										<input type="text" id="writepeople" name="writepeople" value="<%=servicelog.getWritepeople()%>" />
								</td>
							</tr>
							<tr>
							<td align="center" colspan="2">
									招聘周期
							  </td>
								
								<td align="center" >
								岗位名称
								</td>
								<td align="center" >
									<%=jobname%>
								</td>
								<td align="center" >
								人数
								</td>
								<td align="center"   colspan='3'>
									<input type="text" id="number" name="number" value="<%=servicelog.getNumber()%>"/>	
								</td>
								
							</tr>
							</table>
							<div style="width:100%;height:15px;"></div>
							 <table width="100%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc"  id="table">
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
								
								<td align="center" >
									推荐人
								</td>
								<td align="center" >
									<input type='button'  value='添加' class='button' onclick="adds('<%=jobname.replace("\n","").replace("\r","")%>')"/>
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
									<input type="text" style='width: 170px' id="cardnumber<%=i%>" name="cardnumber2" value="<%=recom.getCardnumber()%>"/>
								<input type='button'  value='查询' class='button' onclick='querymessage(<%=i%>)'/>
								</td>
								<td align="center" >
									<input type="text" style='width: 100px' id="commedname<%=i%>" name="commedname2" value="<%=recom.getName()%>"/>
								</td>
								<td align="center" id="cjlbxlk">
									<input type="text" style='width: 100px' id="commedlevel<%=i%>" name="commedlevel2" value="<%=recom.getDikind()%>"/>
								</td>
								<td align="center" >
									<input type="text" style='width: 130px' id="commedphone<%=i%>" name="commedphone2" value="<%=recom.getPhone()%>"/>
								</td>
								<td align="center" >
									<input type="text" style='width: 100px' id="commedpeople<%=i%>" name="commedpeople2" value="<%=recom.getCommdpeople()%>"/>	
								</td>
							
								<td align="center" >
									<input type='button'  value='删除' class='button' onclick='delectRow1(this)' />
								</td>
							</tr>
							<%} %>
			 </table>
			 <div <%if(aaa.size()>0){%>style="display:block"<%}else{%>style="display:none"<%}%> id="a">
	 <table border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc" id="testTable" width="100%">
						
							<tr class="trcolor" >

								<td class="tdFormInput" align="center" width="50%" colspan="7">
									<div align="center">
										<strong>招用人员花名册</strong>
									</div>
								</td>
							</tr>
							
							<tr>
								
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
								<td align="center" style='width:100px' >
								       备注
								</td>
								
								<td align="center" >
								 <input type='button'  value='添加' class='button' onclick='add()'/>
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
							
								<td align="center" >
									<input type="text"  name="sname2" value="<%=servicepeople.getSname()%>" style='width:100px'/>	
								</td>
								<td align="center" >
										<input type="text"  name="snumber2" value="<%=servicepeople.getDisnumber()%>" style='width:170px'/>
								</td>
								<td align="center" >
										<input type="text"  name="register2" value="<%=servicepeople.getRegister()%>" style='width:100px'/>
								</td>
								<td align="center" >
										<input type="text"  name="sphone2" value="<%=servicepeople.getPhone()%>" style='width:100px'/>
								</td>
								<td align="center" >
										<input type="text"  name="sjob2" value="<%=servicepeople.getJobname()%>" style='width:100px'/>
								</td>
								<td align="center" >
										<input type="text"  name="remark2" value="<%=a%>" style='width:100px'/>
								</td>
								<td align="center" >
									<input type='button'  value='删除' class='button' onclick='delectRow(this)'/>
								</td>
								
							</tr>
							<%} %>
                           </table>
                           </div>
                           <div id="b" <%if(aaa.size()>0){%>style="display:none"<%}else{%>style="display:block"<%}%>>
              <table width="100%" border="0" align="center" cellpadding="3"
	cellspacing="1" bgcolor="#cccccc">
             <tr>
								<td style="text-align: left;" colspan='7'>
									未招用原因：
									<input type="checkbox"  name="losewhyobj" id="losewhyobj1" value="1" />
									无合适人员
									
									<input type="checkbox"  name="losewhyobj" id="losewhyobj2" value="2" />
									岗位调整
									<input type="checkbox"  name="losewhyobj" onclick="aaaaa()" id="losewhyobj3" value="3" />
									其它
                                    <input type="text" title="请输入其他未招用原因" Class="input3" value="<%=otherwhy%>"
										id="otherparts" name="otherparts" maxlength="50" style="width:50%;"/>
							  </td>
							</tr>
							</table>
							</div>
	
	      <table width="100%" border="0" align="center" cellpadding="3"
	   cellspacing="1" bgcolor="#cccccc">
	    <tr>

								<td style="text-align: left;" colspan='7'>
									在招聘和雇佣残疾人过程中，需要提供哪些服务：
									<br>
									<br>
									<input type="checkbox"  name="problem1obj" id="problem1obj1" value="1" />
									健全员工基本手语培训
									<input type="checkbox"  name="problem1obj" id="problem1obj2" value="2" />
									残疾人职业适应性指导
									<br>
									<input type="checkbox"  name="problem1obj" id="problem1obj3" value="3" />
									应聘残疾人职业素质测评（由人力资源测评专业公司提供）
									<br>
									<input type="checkbox"  name="problem1obj" id="problem1obj4" value="4" />
									其他
								</td>
			  </tr>
							<tr>
								<td style="text-align: left;" colspan='7'>
									意见、建议：
									<br>
									<textarea name="opinion" title="请输入意见、建议" id="opinion"
										cols="70" rows="3" ><%=servicelog.getOpinion()%></textarea>
									
								</td>
								
							</tr>
					  </table>
							
							
                       <input type="button"  type="button"  value="保存"  onclick="javascript:baocun();" />
									<input type="button" onclick="history.go(-1)" value="返回" />
								
						
						<br />
		
                 </form>
</DIV>
               

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
function baocun(){
    
var cardnumber=document.getElementsByName("cardnumber2");
var commedpeople=document.getElementsByName("commedpeople2");
var cardnumbers="";
var commedpeoples="";
           for(i=0;i<cardnumber.length;i++){
			cardnumbers=cardnumbers+cardnumber[i].value+",";
				if (cardnumber[i].value.length<=0) {
			alert("身份证号不能为空");
			
			return false;
		}
			}
		
			for(i=0;i<commedpeople.length;i++){
			commedpeoples=commedpeoples+commedpeople[i].value+",";
			if (commedpeople[i].value.length > 10 || commedpeople[i].value.length <= 0) {
			alert("推荐人长度必须小于10个字");
			
			return false;
		}
		if (commedpeople[i].value.search(/^[\u4e00-\u9FA5]+$/) < 0) {
			alert("推荐人必须为中文");
			
			return false;
		}
			}
				document.getElementById('cardnumber').value=cardnumbers;
		
		document.getElementById('commedpeople').value=commedpeoples;
  
        var sname=document.getElementsByName('sname2');	
	   var snumber=document.getElementsByName('snumber2');	
		var register=document.getElementsByName('register2');
      var sphone=document.getElementsByName('sphone2');
      	var sjob=document.getElementsByName('sjob2');
      var remark=document.getElementsByName('remark2');
		var snames="";
		var snumbers="";
		var registers=""
		var sphones="";
		var sjobs="";
		var remarks="";
		   for(i=0;i<sname.length;i++){
			snames=snames+sname[i].value+",";
			if (sname[i].value.length > 10 || sname[i].value.length <= 0) {
			alert("姓名长度必须小于10个字");			
			
			return false;
		
		}
		if (sname[i].value.search(/^[\u4e00-\u9FA5]+$/) < 0
				&& sname[i].value!= "") {
			alert("姓名必须为中文");			
			return false;
		}
			}
				for(i=0;i<snumber.length;i++){
			snumbers=snumbers+snumber[i].value+",";
			if(snumber[i].value<=0){
    alert("残疾人证件号码不能为空！");
    return false;
 }
 

 if(snumber[i].value.length<20){
 	alert("残疾人证件号码位数不足！");
	return false;
	}
	if(snumber[i].value.length>25){
 	alert("残疾人证件号码位数超出！");
	return false;
	}
			}
				for(i=0;i<register.length;i++){
			registers=registers+register[i].value+",";
			 if(register[i].value.length>50||register[i].value<=0){
      alert("户籍长度在50以内");
     
      return false;
      }
			}
				for(i=0;i<sphone.length;i++){
			sphones=sphones+sphone[i].value+",";
			if(sphone[i].value.length<6||sphone[i].value.length>15) {
	    alert("电话长度必须在6-15位之间");
	   // document.getElementById("compAddr.value=username; 
	    
	   
	    return false;
    }
	if (sphone[i].value.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/) < 0){ 
		alert("电话格式不正确"); 
		//document.getElementById("userId.value=username; 
		
		return false; 
	}   
			}
				for(i=0;i<sjob.length;i++){
			sjobs=sjobs+sjob[i].value+",";
			 if(sjob[i].value.length>50||sjob[i].value<=0){
      alert("所在岗位名称长度在50以内");
     
      return false;
      }
			}
				for(i=0;i<remark.length;i++){
			remarks=remarks+remark[i].value+",";
			 if(remark[i].value.length>50){
      alert("备注长度在50以内");
     
      return false;
      }
			}
			
			document.getElementById('sname').value=snames;
		document.getElementById('snumber').value=snumbers;
		document.getElementById('register').value=registers;
		document.getElementById('sphone').value=sphones;
		document.getElementById('sjob').value=sjobs;
		document.getElementById('remark').value=remarks;
     var writepeople=document.getElementById("writepeople").value;
		if (writepeople.length > 10 || writepeople.length <= 0) {
			alert("记录人长度必须小于10个字");
			
			return false;
		}
		if (writepeople.search(/^[\u4e00-\u9FA5]+$/) < 0
				&& writepeople!= "") {
			alert("记录人必须为中文");
			
			return false;
		}
		var number=document.getElementById("number").value;
		
		if(number.length<=0){
		alert("人数不能为空");
		return false;
		}
		if(number.length>10){
		alert("人数必须小于10位");
		return false;
		}
		if ((number.search(/^[0-9]+$/) < 0)&&number.length>0 ){ 
		alert("人数只能为数字"); 		
		return false;
		} 
		 var losewhyobj=document.getElementsByName('losewhyobj');
		 var xuanzhong=false;
       var losewhyobjs="";
     for(i=0;i<losewhyobj.length;i++){
        
		if(losewhyobj[i].checked){
		xuanzhong=true;
		losewhyobjs=losewhyobjs+losewhyobj[i].value+",";
		}
		
      }
     var validfalg=document.getElementById("validflag").value;
     
     if(validfalg=="2"){
      document.getElementById('losewhyobjs').value=losewhyobjs;
      if(!xuanzhong){
      alert("请选择未招用原因");
     return false;
      }
      }
	 var problem1obj=document.getElementsByName('problem1obj');
		 var xuanzhongs=false;
    var problem1objs="";
     for(i=0;i<problem1obj.length;i++){
        
		if(problem1obj[i].checked){
		xuanzhongs=true;
		problem1objs=problem1objs+problem1obj[i].value+",";
		}
		
      }
      document.getElementById('problem1objs').value=problem1objs;
      if(!xuanzhongs){
      alert("请选择需要提供服务的种类");
     return false;
      }
     
      var  opinion=document.getElementById('opinion').value;
   
      if(opinion.length<=0||opinion.length>100){
      alert("请输入100字以内意见、建议");
      return false;
      }
document.myform.action="${ctx}/admin/findAllpublishJob.do?method=updateserviceJob";
document.myform.submit();
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
           newNameTD.innerHTML = "<input type='text' id='sname2' name='sname2' style='width: 100px'/>";  
          newNameTD.align = "center";
           var newNameTD = newTR.insertCell(1);  
           newNameTD.innerHTML = "<input type='text' id='snumber2' name='snumber2' style='width:170px'/ >";  
          newNameTD.align = "center";
           var newNameTD = newTR.insertCell(2);  
           newNameTD.innerHTML = "<input type='text' id='register2' name='register2' style='width: 100px'/>";  
           newNameTD.align = "center";
            var newNameTD = newTR.insertCell(3);  
           newNameTD.innerHTML = "<input type='text' id='sphone2' name='sphone2' style='width: 100px'/>";  
          newNameTD.align = "center";
           var newNameTD = newTR.insertCell(4);  
           newNameTD.innerHTML = "<input type='text' id='sjob2' name='sjob2' style='width: 100px'/>";  
            newNameTD.align = "center";
            var newNameTD = newTR.insertCell(5);  
           newNameTD.innerHTML = "<input type='text' id='remark2' name='remark2' style='width: 100px'/>";  
           newNameTD.align = "center";
           var newNameTD = newTR.insertCell(6);            
           newNameTD.innerHTML = "<input type='button'  value='删除' class='button' onclick='delectRow(this)'/>";
           newNameTD.align = "center";
 }
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
