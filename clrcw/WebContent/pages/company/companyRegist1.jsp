<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>企业用户注册</title>
	<link href="<%=request.getContextPath()%>/css/index3.css"
		rel="stylesheet" type="text/css">

	
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />

	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/css/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
	<script language="JavaScript" type="text/JavaScript"><!--
function checkform(){ 

	username = document.getElementById("userId").value;//这里的username是一个page的对像,作用来取得文本框page的值,
	if(username.length<6||username.length>20) {
	    alert("用户名长度必须在6位到20位之间");
	    document.getElementById("userId").value=username; 
	    document.getElementById("userId").focus();
	    return false;
    }
	if (username.search(/^[0-9a-zA-Z]+$/) < 0){ 
		alert("用户名只能为数字或字母"); 
		document.getElementById("userId").value=username; 
		document.getElementById("userId").focus();
		return false; 
	}       
	password = document.getElementById("password").value;
	if(password.length<6||password.length>20) {
		alert("密码长度必须在6位到20位之间");
		document.getElementById("password").focus();
		return false;
	}
	if (password.search(/^[0-9a-zA-Z]+$/) < 0){ 
		alert("密码只能为数字或字母"); 
		document.getElementById("password").focus();
		return false; 
	} 

	password2=document.getElementById("rePassword").value;
	if(password!=password2) {
		alert("密码不匹配");
	    document.getElementById("password").focus();
	    return false;
   	}

	compName = document.getElementById("compName").value ;
	if(compName.length<3||compName.length>40) {
	    alert("企业名称长度必须在3-40个字之间");
	   // document.getElementById("compName.value=username; 
	    document.getElementById("compName").focus();
	   
	    return false;
    }
	 

	compAddr = document.getElementById("compAddr").value ;
	if(compAddr.length<2||compAddr.length>20) {
	    alert("法人姓名长度必须在2-20个字之间");
	   // document.getElementById("compAddr.value=username; 
	    document.getElementById("compAddr").focus();
	   
	    return false;
    }
	if (compAddr.search(/^[\u4e00-\u9FA5]+$/) < 0
				&& compAddr != "") {
			alert("法人姓名必须为中文");
			document.getElementById("compAddr").focus();
			return false;
		}
	compnum = document.getElementById("compnum").value ;
	if(compnum.length<10||compnum.length>20) {
	    alert("营业执照编码长度(组织机构代码)必须为10-20位之间");
	   // document.getElementById("compAddr.value=username; 
	    document.getElementById("compnum").focus();
	    return false;
    }
	
	
	telephone = document.getElementById("telephone").value ;
	if(telephone.length<6||telephone.length>15) {
	    alert("联系电话长度必须在6-15位之间");
	   // document.getElementById("compAddr.value=username; 
	    document.getElementById("telephone").focus();
	   
	    return false;
    }
	if (telephone.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/) < 0){ 
		alert("联系电话格式不正确"); 
		//document.getElementById("userId.value=username; 
		document.getElementById("telephone").focus();
		return false; 
	}   


	linkman= document.getElementById("linkman").value ;
	if(linkman.length<2||linkman.length>20) {
	    alert("经办人长度必须在2-20个字之间");
	   // document.getElementById("compAddr.value=username; 
	    document.getElementById("linkman").focus();
	    return false;
    }
if (linkman.search(/^[\u4e00-\u9FA5]+$/) < 0
				&& linkman != "") {
			alert("经办人姓名必须为中文");
			document.getElementById("linkman").focus();
			return false;
		}
	
	cardnum= document.getElementById("cardnum").value ;
	if (cardnum.search(/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}(\d|x|X)$/) < 0
				) {
			alert("身份证格式不正确");
			document.getElementById("cardnum").focus();
			return false;
		}
	var mailPost= document.getElementById("mailPost").value ;
	if(mailPost.length!=6 ) {
	    alert("邮编长度为6位");
	   // document.getElementById("compAddr.value=username; 
	    document.getElementById("mailPost").focus();
	   
	    return false;
    }

	if ((mailPost.search(/^[0-9]+$/) < 0)&&mailPost.length>0 ){ 
		alert("邮编只能为数字"); 
		document.getElementById("mailPost").focus();
		return false; 
	} 
	   companyplace= document.getElementById("companyplace").value ; 
	   if(companyplace.length>50||companyplace.length<=0) {
	    alert("办公地点必须小于50字"); 
	    document.getElementById("companyplace").focus();
	    return false;
    }
     workScope = document.getElementById("workScrope").value;
    if (workScope.length > 25) {
        alert("经营范围长度过长");
        document.getElementById("workScrope").focus();
        return false;
    }
    if (workScope.search(/^[0-9a-zA-Z\u4e00-\u9FA5：;；:，。., ]+$/) < 0) {
        alert("经营范围为空或包含非法字符");
        document.getElementById("workScrope").focus();
        return false;
    }
    netAddress = document.getElementById("netAddress").value;
    if (netAddress.length > 30) {
        alert("网址长度过长");
        document.getElementById("netAddress").focus();
        return false;
    }
    if (netAddress.search(/^[0-9a-zA-Z.:/：;；:，。., ]+$/) < 0 && netAddress != "") {
        alert("网址包含非法字符");
        document.getElementById("netAddress").focus();
        return false;
    }
    compIntro = document.getElementById("compIntro").value;
    if (compIntro.length > 500) {
        alert("企业介绍长度过长");
        document.getElementById("compIntro").focus();
        return false;
    }
    if (compIntro.trim() == "") {
        alert("企业介绍不能为空");
        document.getElementById("compIntro").focus();
        return false;
    }


  compcount = document.getElementById("compcount").value;
    if ((compcount.search(/^[0-9]+$/) < 0)&&compcount.length>0) {
        alert("单位规模必须为数字");
        document.getElementById("compcount").focus();
        return false;
    }
    if (compcount.length>10) {
        alert("单位规模长度必须小于10");
        document.getElementById("compcount").focus();
        return false;
    }
    

fax = document.getElementById("fax").value;
    if(fax.length>0){
	if(fax.length<6||fax.length>15) {
	    alert("传真长度必须在6-15位之间");
	   // document.CompanyRegist2Form.compAddr.value=username; 
	    document.getElementById("fax").focus();
	   
	    return false;
    }
	}
    if ((fax.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/)<0)&&fax.length>0) {
        alert("传真格式不正确");
        document.getElementById("fax").focus();
        return false;
    }
 
var local = document.CompanyRegist1Form.uploadphoto1.value;
      
		var point = local.lastIndexOf(".");

		var type = local.substr(point).toUpperCase();

		
		if (type == "") {
			
		} else if (type == ".JPEG" || type == ".JPG" || type == ".GIF"|| type == ".PNG") {
			
			
		} else {
			alert("营业执照照片格式不正确");
			return false;
		}
var local2 = document.CompanyRegist1Form.uploadphoto2.value;
      
		var point2 = local2.lastIndexOf(".");

		var type2 = local2.substr(point2).toUpperCase();

		if (local2 == "") {
			
		
		}
		if (type2 == "") {
			
		} else if (type2== ".JPEG" || type2 == ".JPG" || type2 == ".GIF"|| type2== ".PNG") {
		
		} else {
			alert("法人/经办人身份证照片片格式不正确");
			return false;
		}
 	var email = document.getElementById("mail").value;
    var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z_-])+/;
    flag=pattern.test(email);
    if (flag) {
        
    	document.CompanyRegist1Form.submit();
		
    	return true;
    }else{
        alert('请输入30位字符以内的有效邮箱地址！');
        document.getElementById("mail").focus();
        return false;
    }  

	
} 

	  
function eduti(){

	 document.getElementById("userId").focus();
}
--></script>

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
					企业用户注册
				</h2>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff;">
					<html:form 
						action="/companyRegist1.do?method=companyRegist1"
						method="post" enctype="multipart/form-data">

						<style type="text/css">
#newtable th.h2_table {
	width: auto;
	color: #BD0403;
	font-size: 14px;
	padding: 10px;
	font-weight: bold;
}

#newtable td input {
	width: 300px
}
</style>



						<style type="text/css">
<!--
.button1 {
	font-size: 20px;
	cursor: hand;
	width: 60px;
	height: 21px;
	background-color: #ffffff;
	background-image: url(/clrcw/image/new_zc.gif);
	background-repeat: repeat;
	background-attachment: scroll;
	background-position: center;
	border: 0 solid #000000;
	text-align: center;
	padding-top: 3px;
}

.button2 {
	font-size: 20px;
	cursor: hand;
	width: 60px;
	height: 21px;
	background-color: #ffffff;
	background-image: url(/clrcw/image/new_tc.gif);
	background-repeat: repeat;
	background-attachment: scroll;
	background-position: center;
	border: 0 solid #000000;
	text-align: center;
	padding-top: 3px;
}
-->
</style>

						<TABLE class="finktable" id="newtable" width="100%" border="0"
							cellspacing="0" cellpadding="0">

							<tr>
								<TH align="center" class="h2_table" colspan="2"
									style="background: #900; color: #fff;">
									企业用户登记注册（带*为必填项）
								</TH>
							</TR>
							<tr>
								<TH class="black1" width="150">
									<LABEL for="userId">
										用户登录名：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="userId" title="请输入用户登录名" id="userId" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*6-20位字母、数字组合。</FONT>
									<br>
									<%String  aaa="";
									if(request.getSession().getAttribute("cunzai")!=null){
									aaa=(String)request.getSession().getAttribute("cunzai");
									} %>
										<font color="red"><%=aaa%></font>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="password">
										用户密码：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="password" title="请输入用户密码" id="password"
										type="password">
									<FONT color="#333333" style="font-size: 12px;">
										*密码为数字或字母,并且密码长度必须在6位到20位之间。</FONT>
									<BR>
									<FONT color="red"></FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="rePassword">
										确认密码：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="rePassword" title="请输入确认密码" id="rePassword"
										type="password">
									<FONT color="#333333" style="font-size: 12px;">
										*确保密码输入正确。</FONT>
									<BR>
									<FONT color="red"></FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="compName">
										企业名称：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="compName" title="请输入企业名称" id="compName"
										type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*企业名称长度必须在3-40个字之间。</FONT>
								</TD>
							</TR>
							<TR>
						 		<TH class="black1">
									<LABEL for="compnum">
										营业执照编码：<br/>(组织机构代码)
									</LABEL>
								</TH>
								<TD>
									<INPUT name="compnum" title="请输入营业执照编码" id="compnum"
										type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*营业执照编码(组织机构代码)长度必须10-20个字之间。</FONT>
										<%String  bbb="";
									if(request.getSession().getAttribute("yingye")!=null){
									bbb=(String)request.getSession().getAttribute("yingye");
									} %>
										<font color="red"><%=bbb%></font>
								</TD>
							</TR>
							<tr>
								<th class="black1">
									<label for="comparea" >
										企业注册区域：
									</label>
								</th>
								<td>
									<select name="comparea" id="comparea" title="">
										<%
											List sss = (List) request.getSession().getAttribute("arealist");
												for (int i = 0; i < sss.size(); i++) {
													Areacode areacode = (Areacode) sss.get(i);
										%>
										<option value="<%=areacode.getAreacode()%>"><%=areacode.getAreaname()%></option>
										<%
											}
										%>
									</select>
							</tr>
							<TR>
								<TH class="black1">
									<LABEL for="companyplace">
										办公地点：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="companyplace" title="请输入办公地点" id="companyplace" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*办公地点在50字以内</FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="mailPost">
										邮编：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="mailPost" title="请输入邮编" id="mailPost" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*邮编必须为6位数字。</FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="compAddr">
										法人：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="compAddr" title="请输入企业地址" id="compAddr"
										type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*法人长度必须在2-20个字之间。</FONT>
								</TD>
							</TR>
							
							<TR>
								<TH class="black1">
									<LABEL for="linkman">
										经办人：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="linkman" title="请输入经办人" id="linkman" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*经办人长度必须在2-20个字之间。</FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="cardnum">
										身份证号：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="cardnum" title="请输入身份证号" id="cardnum" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*身份证号必须为18位数字。</FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="telephone">
										联系电话：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="telephone" title="请输入联系电话" id="telephone"
										type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*联系电话长度必须在6-15位之间。</FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="mail">
										电子邮件：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="mail" title="请输入电子邮件" id="mail" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*请输入30长度以内的有效邮箱地址。</FONT>
								</TD>
							</TR>
                           <TR>
								<TH class="black1">
									<LABEL for="workScrope">
										经营范围：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="workScrope" title="请输入25字以内经营范围" id="workScrope" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*请输入25字以内经营范围。</FONT>
								</TD>
							</TR><TR>
								<TH class="black1">
									<LABEL for="compcount">
										单位规模：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="compcount" title="请输入单位规模" id="compcount" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										人。</FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="type">
										企业性质：
									</LABEL>
								</TH>
								<td  id="123" title="请选择企业性质">

											<select name="type" id="type" title="">
										<%
											List compkind = (List) request.getSession().getAttribute("bdCompkind");
												for (int i = 0; i < compkind.size(); i++) {
													BdCompkind comp = (BdCompkind) compkind.get(i);
										%>
										<option value="<%=comp.getId()%>"><%=comp.getCompTypeName()%></option>
										<%
											}
										%>
									</select>
									
								</td>
                                 </TR>
                                 <TR>
								<TH class="black1">
									<LABEL for="bd">
										所属行业：
									</LABEL>
								</TH>
								<td id="1234" title="请选择所属行业">
									
									<select name="bd" id="bd" title="">
										<%
											List trades = (List) request.getSession().getAttribute("bdTrade");
												for (int i = 0; i < trades.size(); i++) {
													BdTrade bdtrade = (BdTrade) trades.get(i);
										%>
										<option value="<%=bdtrade.getId()%>"><%=bdtrade.getTradeName()%></option>
										<%
											}
										%>
									</select>
								</td>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="fax">
										传真：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="fax" title="请输入传真" id="fax" type="text">
									
								</TD>
							</TR><TR>
								<TH class="black1">
									<LABEL for="netAddress">
										网址：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="netAddress" title="请输入长度30以内的网址" id="netAddress" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										请输入长度30以内的网址。</FONT>
								</TD>
							</TR><TR>
								<TH class="black1">
									<LABEL for="compIntro">
										企业介绍：
									</LABEL>
								</TH>
								<TD>
									<INPUT name="compIntro" title="请输入500字以内企业介绍" id="compIntro" type="text">
									<FONT color="#333333" style="font-size: 12px;">
										*请输入500字以内企业介绍。</FONT>
								</TD>
							</TR>
							<TR>
								<TH class="black1">
									<LABEL for="mail">
										营业执照：
									</LABEL>
								</TH>
								<TD align="left">
									<LABEL for="uploadphoto">
										请选择照片(营业执照)：
									</LABEL>
									<INPUT name="uploadphoto1" title="请选择照片" id="uploadphoto1"
										type="file" size="35">
									<p style="color: #F30; font-size: 12px;">
										(支持JPEG,JPG,GIF,PNG格式 )
									</p>
								</TD>
							</TR>

							<TR>
								<TH class="black1">
									<LABEL for="mail">
										法人/经办人身份证：
									</LABEL>
								</TH>
								<TD align="left">
									<LABEL for="uploadphoto">
										请选择照片(法人/经办人身份证)：
									</LABEL>
									<INPUT name="uploadphoto2" title="请选择照片" id="uploadphoto2"
										type="file" size="35">
									<p style="color: #F30; font-size: 12px;">
										(支持JPEG,JPG,GIF,PNG格式 )
									</p>
								</TD>
							</TR>	
							<tr>
								<th colspan="2" style="width: auto; text-align: center;">
									照片上传也可传真至各级<a style="color: red" href="http://www.bdpf.org.cn/zhyy/jgdhfw/jyzd/index.html">残疾人</a>就业服务机构						
								</th>
							</tr>	
							<tr>
								<th colspan="2" style="width: auto; text-align: center;">
									
									<a class="btn1" style="margin-left: 20px;" href="##" onclick="checkform()">注册</a>
									<a class="btn1" style="margin-left: 20px;"
										onclick="javascript:history.back();">返回</a>
								</th>
							</tr>
						</table>

					</html:form>

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
</html:html>
