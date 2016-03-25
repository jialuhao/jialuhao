<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>


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
		href="/clrcw/css/skin.css" />
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
							&equiv;&nbsp; 企业基本情况
						</li>
						
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
				</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<table class="finktable" summary="企业招聘信息" width="100%" border="0"
						cellspacing="0" cellpadding="0">
                         
						<logic:present name="compBespeakInfo">
							<tr>
								<td class="black">
									审核状态：
								</td>
								<td colspan="3">
									未通过审核
								</td>
								</tr>
								<tr>
								<td class="black">
									审核意见：
								</td>
								<td colspan="3">
									<bean:write name="compBespeakInfo" property="opinion" />
								</td>
							</tr>
							<tr>
								<td class="black">
									企业名称：
								</td>
								<td >
									<bean:write name="compBespeakInfo" property="compName" />
								</td>
								<td class="black">
									公司法人：
								</td>
								<td colspan="3">
									<bean:write name="compBespeakInfo" property="compAddr" />
								</td>
							</tr>
							<tr>
								<td class="black">
									营业执照编码：
								</td>
								<td colspan="1">
									<bean:write name="compBespeakInfo" property="compnum" />
								</td>

							

							
								
							</tr>
							<tr>
								<td colspan="4"  class="black" style="background:#900; color:#fff;">
									<span class="font5">企业详细信息如下：</span>
								</td>
							</tr>
							<%String areaname=(String)request.getSession().getAttribute("areaname"); %>
							<tr>
								<td class="black">
									企业注册区域：
								</td>
								<td>
									<%= areaname%>
								</td>
								
                                   <td width="100" class="black">
									办公地点：
								</td>
								<td >
									<bean:write name="compBespeakInfo" property="companyplace" />
								</td>

							</tr>
							<tr>
								<td class="black">
									联 &nbsp;系&nbsp; 人：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="linkman" />
								</td>
								<td class="black">
									身份证号：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="cardnum" />
								</td>

							</tr>
							<tr>
								<td class="black">
									联系电话：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="telephone" />
								</td>
								<td class="black">
									电子邮件：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="mail" />
								</td>
							</tr>
						</logic:present>
						<logic:present name="compInfo">
							
							<tr>
								<td width="100" class="black">
									经营范围：
								</td>
								<td width="270" >
									<bean:write name="compInfo" property="workScrop" />
								</td>
								<td width="100" class="black">
									单位规模：
								</td>
								<td width="270">
									<bean:write name="compInfo" property="compcount" />
								</td>
							</tr>
							<tr>
								<td width="100" class="black">
									企业性质：
								</td>
								<td width="270">
									<bean:write name="compInfo" property="type.compTypeName" />
								</td>
								<td width="100" class="black">
									所属行业：
								</td>
								<td>
									<bean:write name="compInfo" property="bd.tradeName" />
								</td>
							</tr>
							<tr>
								<td width="100" class="black">
									传真：
								</td>
								<td width="270">
									<bean:write name="compInfo" property="fax" />
								</td>

								<td width="100" class="black">
									公司主页：
								</td>
								<td>
									<bean:write name="compInfo" property="netAddress" />
								</td>
							</tr>
							<tr>
							<td class="black">
									邮 &nbsp;&nbsp;编：
								</td>
								<td colspan="3">
									<bean:write name="compBespeakInfo" property="mailPost" />
								</td>
							</tr>
							<tr>
								<td class="black">
									企业介绍：
								</td>
								<td colspan="3" style="width: 550px; text-align: left;">
									<textarea name="compIntro" title="企业介绍" id="compIntro"
										cols="70" rows="3" readonly="readonly"><bean:write name="compInfo" property="compIntro" /></textarea>
								</td>

							</tr>
					</table>
					<div
						style="text-align: center; padding: 20px 0; margin: -1px 0 0 0; border: #ddd 1px solid; background: #ededed;">
						<form action="${ctx}/pages/company/compUpInfos.jsp" method="post">
							<input type="submit" value="修改" class="input4" />
						</form>
					</div>
					</logic:present>



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
