<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<script language="JavaScript" type="text/JavaScript">
function checkform(){
   
    String.prototype.trim = function(){ //定义trim()函数
        var reExtraSpace = /^\s*(.*?)\s+$/;
        return this.replace(reExtraSpace, "$1");
    }
     companyplace= document.getElementById("companyplace").value ; 
	   if(companyplace.length>50||companyplace.length<=0) {
	    alert("办公地点必须小于50字"); 
	    document.getElementById("companyplace").focus();
	    return false;
    }
    linkman= document.getElementById("linkman").value ;
	if(linkman.length<2||linkman.length>20) {
	    alert("联系人长度必须在2-20个字之间");
	   // document.getElementById("compAddr.value=username; 
	    document.getElementById("linkman").focus();
	    return false;
    }
if (linkman.search(/^[\u4e00-\u9FA5]+$/) < 0
				&& linkman != "") {
			alert("联系人姓名必须为中文");
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
	var email = document.getElementById("mail").value;
    var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z_-])+/;
    flag=pattern.test(email);
    if (!flag) {
        
    	 alert('请输入30位字符以内的有效邮箱地址！');
        document.getElementById("mail").focus();
        return false;
    } 
    workScope = document.CompanyRegist2Form.workScrope.value;
    if (workScope.length > 25||workScope.length <=0) {
        alert("经营范围长度为1-25字符之间");
        document.CompanyRegist2Form.workScrope.focus();
        return false;
    }
    if (workScope.search(/^[0-9a-zA-Z\u4e00-\u9FA5 ：;；:，。., ]+$/) < 0) {
        alert("经营范围为空或包含非法字符");
        document.CompanyRegist2Form.workScrope.focus();
        return false;
    }
    compcount = document.CompanyRegist2Form.compcount.value;
    if (compcount.length > 10||compcount.length <=0) {
        alert("单位规模长度为1-10字符之间");
        document.CompanyRegist2Form.compcount.focus();
        return false;
    }
    if ((compcount.search(/^[0-9]+$/) < 0)&&compcount.length>0 ){ 
		alert("单位规模只能为数字"); 
		document.CompanyRegist2Form.compcount.focus();
		return false; 
	} 
    fax = document.CompanyRegist2Form.fax.value ;
	if(fax.length>0){
	if(fax.length<6||fax.length>15) {
	    alert("传真长度必须在6-15位之间");
	   // document.CompanyRegist2Form.compAddr.value=username; 
	    document.CompanyRegist2Form.fax.focus();
	   
	    return false;
    }
	}
	if (fax.search(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(^0{0,1}15[0-9]{9}$)|(^0{0,1}18[0-9]{9}$)/) < 0&&fax.length>0){ 
		alert("传真格式不正确"); 
		//document.CompanyRegist2Form.userId.value=username; 
	    document.CompanyRegist2Form.fax.focus();
		return false; 
	} 
  

	
    netAddress = document.CompanyRegist2Form.netAddress.value;
    if (netAddress.length > 30) {
        alert("网址长度过长,长度应在30个字符之内");
        document.CompanyRegist2Form.netAddress.focus();
        return false;
    }
    if (netAddress.search(/^[0-9a-zA-Z./.:]+$/) < 0 && netAddress != "") {
        alert("网址包含非法字符");
        document.CompanyRegist2Form.netAddress.focus();
        return false;
    }
    compIntro = document.CompanyRegist2Form.compIntro.value;
    if (compIntro.length > 500) {
        alert("企业介绍长度过长，长度应在500个字符之内");
        document.CompanyRegist2Form.compIntro.focus();
        return false;
    }
    if (compIntro.trim() == "") {
        alert("企业介绍不能为空");
        document.CompanyRegist2Form.compIntro.focus();
        return false;
    }
      var mailPost= document.CompanyRegist2Form.mailPost.value ;
	if(mailPost.length!=6 ) {
	    alert("邮编长度为6位");
	   // document.getElementById("compAddr.value=username; 
	    document.CompanyRegist2Form.mailPost.focus();
	   
	    return false;
    }

	if ((mailPost.search(/^[0-9]+$/) < 0)&&mailPost.length>0 ){ 
		alert("邮编只能为数字"); 
		document.CompanyRegist2Form.mailPost.focus();
		return false; 
	} 
    if(confirm("修改后企业信息将进入审核状态")){
    document.CompanyRegist2Form.submit();}
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>显示企业信息</title>

	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/modelist.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/index.css" />
	<link rel="stylesheet" type="text/css" id="ABTStyle"
		href="/clrcw/styles/skin.css" />
	<script src="/clrcw/js/public.js" type="text/javascript"></script>
	<script src="/clrcw/js/menu.js" type="text/javascript"></script>
<style>
	  #main{width:945px;_width:898px;}
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
				<DIV class="formdiv"
					style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li class="liH1">
							<a href="${ctx}/companyRegist2.do?method=companyShowInfo"
								style="color: #BD0403;">&equiv;&nbsp;企业基本情况</a>
						</li>
						<li>
							<a href="#"
								onclick="redirect('${ctx}/companyPubJob.do?method=showPubJob')">&equiv;&nbsp;企业招聘信息
							</a>
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
					<html:form action="/companyRegist2.do?method=update" method="post"
						onsubmit="return checkform()">

						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0"
							style="border-top: #900 1px solid;">

							<tr>
								<TH class="th1" colspan="4" bgcolor="#990000"
									style="color: #fff;">
									公司详细信息如下,修改后保存：
								</th>
							</tr>
							
							<tr>
								<td class="black">
									企业注册区域：
								</td>
								<td>
								
								<bean:define id="Areacode" name="areacode"
										type="java.util.List" />
									<html:select property="comparea" value="${compBespeakInfo.comparea}">
										<html:options collection="Areacode" property="areacode"
											labelProperty="areaname" />
									</html:select>
									
								</td>
								
                             <td  class="black">
									办公地点：
								</td>
								
                        <td>
								
								<input type="text"  name="companyplace" title="办公地点必须在50字以内"
										id="companyplace" class="input3" value="${compBespeakInfo.companyplace}" />
									*
								</td>
							</tr>
							<tr>
								<td class="black">
									联 &nbsp;系&nbsp; 人：
								</td>
								<td>
								<input type="text"  name="linkman" title="联系人长度必须在2-20个字之间。"
										id="linkman" class="input3" value="${compBespeakInfo.linkman}" />
									
								</td>
								<td class="black">
									身份证号：
								</td>
								<td>
								<input type="text"  name="cardnum" title="身份证号必须为18位数字。"
										id="cardnum" class="input3" value="${compBespeakInfo.cardnum}" />
									
								</td>

							</tr>
							<tr>
								<td class="black">
									联系电话：
								</td>
								<td>
								<input type="text"  name="telephone" title="联系电话长度必须在6-15位之间"
										id="telephone" class="input3" value="${compBespeakInfo.telephone}" />
									
								</td>
								<td class="black">
									电子邮件：
								</td>
								<td>
								<input type="text"  name="mail" title="请输入30位字符以内的有效邮箱地址"
										id="mail" class="input3" value="${compBespeakInfo.mail}" />
									
								</td>
							</tr>
							<tr>
								<td width="100" class="black">
									<label for="workScrope">
										经营范围：
									</label>
								</td>
								<td width="270">
									<input type="text" title="请输入经营范围,长度为1-25字符之间" name="workScrope"
										id="workScrop" class="input3" value="${compInfo.workScrop}" />
									*
								</td>
								<td width="100" class="black">
									<label for="netAddress">
										单位规模：
									</label>
								</td>
								<td>
									<input type="text" title="请输入单位规模,长度为1-10字符之间" name="compcount"
										id="compcount" styleClass="input3"
										value="${compInfo.compcount}" maxlength="10"/>
									人*
								</td>
							</tr>
							<tr>
								<td width="100" class="black">
									<label for="bdCompkind">
										企业性质：
									</label>
								</td>
								<td width="270" title="请选择企业性质">
									<bean:define id="Compkind" name="bdCompkind"
										type="java.util.List" />
									<html:select property="type" value="${compInfo.type.id}">
										<html:options collection="Compkind" property="id"
											labelProperty="compTypeName" />
									</html:select>
									<!--  (
									<bean:write name="compInfo" property="type.compTypeName" />
									)-->

								</td>

								<td width="100" class="black">
									<label for="bd">
										所属行业：
									</label>
								</td>
								<td title="请选择所属行业">
									<bean:define id="trade" name="bdTrade" type="java.util.List" />
									<html:select property="bd" value="${compInfo.bd.id}">
										<html:options collection="trade" property="id"
											labelProperty="tradeName" />

									</html:select>
									<br />
									<!-- (
									<bean:write name="compInfo" property="bd.tradeName" />
									)-->

								</td>

							</tr>
							<tr>
								<td width="100" class="black">
									<label for="workScope">
										传真：
									</label>
								</td>
								<td>
									<input type="text" title="请输入传真,长度必须在6-15位之间" name="fax" id="fax"
										styleClass="input3" value="${compInfo.fax}" />
								</td>

								<td width="100" class="black">
									<label for="netAddress">
										网 址：
									</label>
								</td>
								<td>
									<input type="text" title="请输入网址" name="netAddress"
										id="netAddress" styleClass="input3"
										value="${compInfo.netAddress}" />
								</td>
							</tr>
                          <tr>
                           <td class="black">
									邮 &nbsp;&nbsp;编：
								</td>
								<td>
								<input type="text"  name="mailPost" title="邮编必须为6位数字。"
										id="mailPost" class="input3" value="${compBespeakInfo.mailPost}" />
									
								</td>
								</tr>
							<tr>
								<td class="black">
									<label for="compIntro">
										企业介绍：
									</label>
								</td>
								<td colspan="3" height="40">
									<textarea name="compIntro" title="请输入企业介绍,长度应在500个字符之内" id="compIntro"
										cols="70" rows="3">${compInfo.compIntro}</textarea>
									*
								</td>
							</tr>
						</table>
						<TABLE class="finktable" id="jbqk" summary="个人招聘信息" width="100%"
							border="0" cellspacing="0" cellpadding="0"
							>
							<tr>
								<td height="40" align="center">
									<input type="hidden" name="keyId" value="${compInfo.id}">
									<input type="button" name="btn1" value="保存"
										onClick="checkform()" class="btn1">
									<input type="button" name="btn1" value="返回"
										onClick=" history.go(-1)" class="btn1">
								</td>
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
	<script>
function redirect(url){
	flag=true;
	<c:if test="${empty compInfo.workScrop}">flag=false;</c:if>
	if(flag){
		window.location.href=url;
	}else{
		alert("请先完善企业信息后再进行其他操作！");
		}
} 

</script>
</body>
</html:html>
