<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<script language="JavaScript" type="text/JavaScript">
	function aaaaa(){
	 var losewhyobj=document.getElementsByName('losewhyobjs');
	if(losewhyobj[2].checked){
		document.getElementById("c").style.display="block";
			}else{
		document.getElementById("c").style.display="none";
			}
	}
	function chekmessage(){
	 var workname=document.getElementsByName('workname2');
	var house=document.getElementsByName('house2');
	var sname=document.getElementsByName('name2');	
	   var disnumber=document.getElementsByName('disnumber2');	
		var phone=document.getElementsByName('phone2');
      var validflag=document.getElementById('validflag');
      var remark=document.getElementsByName('remark2');
       var losewhyobj=document.getElementsByName('losewhyobjs');
    var losewhyobjs="";
     if(validflag.value=="3"){
      for(i=0;i<sname.length;i++){
      if(sname[i].value.length>10||sname[i].value<=0){
      alert("真实姓名长度必须小于10个字");
     
      return false;
      }
      if(sname[i].value.search(/^[\u4e00-\u9FA5]+$/) < 0){
     alert("真实姓名必须为中文");
			
			return false;}
      }
       for(i=0;i<disnumber.length;i++){
    if(disnumber[i].value.search(/^[0-9]+$/) < 0){
      alert("残疾证号必须为数字");
      return false;
      }
      if(disnumber[i].value.length<20||disnumber[i].value.length>25){
      alert("残疾号必须在20-25位之间");
      return false;
      }
      } 
        for(i=0;i<house.length;i++){
      if(house[i].value.length>50||house[i].value<=0){
      alert("户籍长度在50以内");
     
      return false;
      }
     
      }
       for(i=0;i<phone.length;i++){
      
      if(phone[i].value.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/) < 0){
      alert("电话格式不正确");
      return false;
      }
      }
     for(i=0;i<workname.length;i++){
      if(workname[i].value.length>20||workname[i].value<=0){
      alert("所在岗位名称在20字以内");
     
      return false;
      }     
      }
       for(i=0;i<remark.length;i++){
      if(remark[i].value.length>50){
      alert("备注在50字以内");
     
      return false;
      }     
      }
     checkform();
      }else{
      var xuanzhong=false;
     for(i=0;i<losewhyobj.length;i++){
        
		if(losewhyobj[i].checked){
		xuanzhong=true;
		
		}
		
      }
      if(xuanzhong){
      checkform();
      }
      else{
      alert("请选择未招用原因");
      return false;
      }
      
	}
	}
	function checkform() {	
        
		var sname=document.getElementsByName('name2');	
		
	   var disnumber=document.getElementsByName('disnumber2');	
		var phone=document.getElementsByName('phone2');
		var house=document.getElementsByName('house2');	
	   var workname=document.getElementsByName('workname2');	
		var remark=document.getElementsByName('remark2');
      var losewhyobj=document.getElementsByName('losewhyobjs');
		var snames="";
		var disnumbers="";
		var phones="";
		var houses="";
		var worknames="";
		var remarks="";
		var losewhyobjs="";
		for(i=0;i<losewhyobj.length;i++){
		if(losewhyobj[i].checked){
		losewhyobjs=losewhyobjs+losewhyobj[i].value+",";
		
		}
		
		
		}
		for(i=0;i<sname.length;i++){
			snames=snames+sname[i].value+",";
			disnumbers=disnumbers+disnumber[i].value+",";
			phones=phones+phone[i].value+",";
			houses=houses+house[i].value+",";
			worknames=worknames+workname[i].value+",";
			remarks=remarks+remark[i].value+",";
			}
			document.getElementById('sname').value=snames;
		document.getElementById('disnumber').value=disnumbers;
		document.getElementById('phone').value=phones;
		document.getElementById('house').value=houses;
		document.getElementById('workname').value=worknames;
		document.getElementById('remark').value=remarks;
      document.getElementById('losewhyobj').value=losewhyobjs;
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
            newNameTD.innerHTML = "<input type='text' id='house2' name='house2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(3);  
           newNameTD.innerHTML = "<input type='text' id='phone2' name='phone2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(4); 
            newNameTD.innerHTML = "<input type='text' id='workname2' name='workname2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(5);
             newNameTD.innerHTML = "<input type='text' id='remark2' name='remark2' style='width: 100px'/>";  
           var newNameTD = newTR.insertCell(6);     
           newNameTD.innerHTML = "<input type='button'  value='删除' class='button' onclick='delectRow(this)'/>";
           newNameTD.align = "center";
 }
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>招用人员填写</title>
	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
<style>
	  #main{width:945px;}
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




			<div id="content">
				<h2>
					企业[${compUserId}]招聘 &nbsp;&nbsp;
					<a href="${ctx}/companyLogin.do?method=loginOut"
						style="color: #BD0403;">[退出]</a>
				</h2>
				<div class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li>
							<a href="${ctx}/companyRegist2.do?method=companyShowInfo">&equiv;&nbsp;企业基本情况</a>
						</li>
						
						<li class="liH1">
							<a href="${ctx}/companyPubJob.do?method=showPubJob"
								style="color: #BD0403;">&equiv;&nbsp;企业招聘信息 </a>
						</li>

						<li>
							<a href="${ctx}/companySPerson.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li>
							<a href="${ctx}/companyQueryNotContact.do?method=showCompResume">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li>
							<a href="${ctx}/companyAbility.do?method=showCompAbility">&equiv;&nbsp;人才库管理</a>
						</li>
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%; clear:both;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form action="${ctx}/companyServicelog.do?method=saveServicelog" 
						method="post" name="myform" id="myform">
						<input type="hidden" name="sname" id="sname"/>
						<input type="hidden" name="disnumber" id="disnumber"/>					
						<input type="hidden" name="phone" id="phone"/>
						<input type="hidden" name="house" id="house"/>
						<input type="hidden" name="workname" id="workname"/>					
						<input type="hidden" name="remark" id="remark"/>
						<input type="hidden" name="losewhyobj" id="losewhyobj"/>
			是否招到合适人员：
				<select id="validflag" name="validflag" onchange="javascript:showOrHide(this);" >
					<option value="">--请选择--</option>  
					<option value="3" selected="selected">招聘成功</option>  
  					<option value="2" >招聘失败</option>
    			</select>
			<div id="a" style="display:block">
						<table class="finktable" id="testTable" summary="企业招聘信息" align="center"
							width="85%">
							
    			<tr class="trcolor">

								<td class="tdFormInput" align="center" width="50%" colspan="7">
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
								<td align="center" >
									操作
								</td>
							</tr>
							<tr>
								<td class="tdFormInput" >
									<input type="text" id="name2" name="name2"  style="width: 100px"/>
								</td>
							<td class="tdFormInput" >
									<input type="text" id="disnumber2" name="disnumber2"  style="width: 100px"/>
								</td>
							<td class="tdFormInput" >
									<input type="text" id="house2" name="house2"  style="width: 100px"/>
								</td>
								
								<td class="tdFormInput" >
									<input type="text" id="phone2" name="phone2" style="width: 100px"
										 />
								</td>
								<td class="tdFormInput" >
									<input type="text" id="workname2" name="workname2" style="width: 100px"
										 />
								</td>
								<td class="tdFormInput" >
									<input type="text" id="remark2" name="remark2" style="width: 100px"
										 />
								</td>
								<td class="tdFormInput"  align="center"><input type='button'  value='添加' class='button' onclick='add()'/></td>
							</tr>
						</table>
     </div>
                 	<div id="b" style="display:none">
						<table class="finktable" id="grzpjl" summary="企业招聘信息"
							align="center" width="85%">


							<tr>
								<td width="100" style="text-align: left;">
									未招用原因：
									<input type="checkbox" name="losewhyobjs" id="losewhyobj1" value="1" />
									无合适人员
									
									<input type="checkbox" name="losewhyobjs" id="losewhyobj2" value="2" />
									岗位调整
									<input type="checkbox" onclick="aaaaa()"  name="losewhyobjs" id="losewhyobj3" value="3" />
									其它
                                   
                                   <div id="c" style="display:none">
                                    <input type="text" title="请输入其他未招用原因" Class="input3"
										id="otherparts" name="otherparts" maxlength="50" style="width:50%;"/>
								</div>
								</td>
							</tr>

							</table>
            </div>
									<input type="button" value="提交"  onclick="javascript:chekmessage()"/>
									<input type="button" onclick="history.go(-1)" value="返回" />
								
						
						<br />
						</form>
				</div>
			</div>
		</div>


		<iframe src="/clrcw/public/include/footer.html" height="150"
			width="960" id="iframe_foot" frameborder="0" scrolling="no"
			title="底部脚本"></iframe>



	</div>
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
