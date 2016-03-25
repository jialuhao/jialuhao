<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="model.BdCompkind"%>
<%@ page import="java.util.*"%>
<%@ page import="model.BdTrade"%>
<script language="JavaScript" type="text/JavaScript">

function checkform(){
    String.prototype.trim = function(){ //定义trim()函数
        var reExtraSpace = /^\s*(.*?)\s+$/;
        return this.replace(reExtraSpace, "$1");
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
        compcount
    }
     compcount = document.getElementById("compcount").value;
     if (compcount.trim() == "") {
        alert("单位规模不能为空");
        document.getElementById("compcount").focus();
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
				<div class="formdiv" style="margin-top: 0; padding-bottom: 0; border-bottom: 0;">
					<ul id="list1">
						<li class="liH1">
							&equiv;&nbsp;企业基本情况
						</li>
						<li>
							<a href="#"
								onclick="redirect('${ctx}/admin/aglientpublish.do?method=showPubJob')">&equiv;&nbsp;
								企业招聘信息 </a>
						</li>
						
						
						<li >
							<a href="${ctx}/admin/aglientpublish.do?method=showAll">&equiv;&nbsp;人才搜索</a>
						</li>
						<li >
							<a href="${ctx}/admin/aglientpublish.do?method=showCompResume">&equiv;&nbsp;
								简历管理 </a>
						</li>
						<li>
							<a href="${ctx}/admin/aglientpublish.do?method=showCompAbility"
								>&equiv;&nbsp;人才库管理</a>
						</li>
					</ul>
					<div style="height: 1px; background: #ededed; width: 100%;"></div>
					</DIV>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<form action="${ctx}/admin/aglientpublish.do?method=companyRegist2"
						method="post" onsubmit="return checkform()">
						<table  class="finktable" id="grzpjl" summary="企业招聘信息">

							<tr>
								<td>
									单位名称：
								</td>
								<td colspan="3" align=left style="width: 600px;">
									<bean:write name="compBespeakInfo" property="compName" />
								</td>
							</tr>
							<tr>
								<td>
									公司法人：
								</td>
								<td colspan="3" align=left style="width: 600px;">
									<bean:write name="compBespeakInfo" property="compAddr" />
								</td>
							</tr>
							<tr>
								<td width="100">
									邮 编：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="mailPost" />
								</td>
								<td width="100">
									电子邮件：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="mail" />
								</td>
							</tr>
							<tr>
								<td>
									联系电话：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="telephone" />
								</td>
								<td>
									联系人：
								</td>
								<td>
									<bean:write name="compBespeakInfo" property="linkman" />
								</td>
							</tr>
							<tr>
								<td width="100">
									<label for="workScope">
										经营范围：
									</label>
								</td>
								<td>
									<input type="text" id="workScrope" title="请输入经营范围"
										name="workScrope" value="" class="input3">
									*
								</td>
								<td width="100">
									<label for="netAddress">
										单位规模：
									</label>
								</td>
								<td>
									<input type="text" title="请输入单位规模" name="compcount"
										id="compcount" styleClass="input3"
										value="${compInfo.compcount}" />
									人*
								</td>
							</tr>
							<tr>
								<td width="100">
									<label for="123">
										企业性质：
									</label>
								</td>
								<td>
								<select name="type" id="type" title="">
										<%
											List sss = (List) request.getSession().getAttribute("bdCompkind");
												for (int i = 0; i < sss.size(); i++) {
													BdCompkind bdCompkind = (BdCompkind) sss.get(i);
										%>
										<option value="<%=bdCompkind.getId()%>"><%=bdCompkind.getCompTypeName()%></option>
										<%
											}
										%>
									</select>

								</td>

								<td width="100">
									<label for="1234">
										所属行业：
									</label>
								</td>
								<td>
								<select name="bd" id="bd" title="">
										<%
											List aaa = (List) request.getSession().getAttribute("bdTrade");
												for (int i = 0; i < aaa.size(); i++) {
													BdTrade bdTrade = (BdTrade)aaa.get(i);
										%>
										<option value="<%=bdTrade.getId()%>"><%=bdTrade.getTradeName()%></option>
										<%
											}
										%>
									</select>

								</td>
							</tr>
							<tr>
							<td width="100">
								<label for="workScope">
									传真：
								</label>
							</td>
							<td>
								<input type="text" title="请输入传真" name="fax" id="fax"
									styleClass="input3" value="${compInfo.fax}" />
							</td>

							<td width="100">
								<label for="netAddress">
									网 址：
								</label>
							</td>
							<td>
								<input type="text" name="netAddress" id="netAddress"
									title="请输入网址" value="" class="input3">
							</td>
							</tr>
							<tr>
								<td>
									<label for="compIntro">
										企业介绍：
									</label>
								</td>
								<td colspan="3">
									<textarea name="compIntro" title="请输入企业介绍" id="compIntro"
										cols="70" rows="3"></textarea>
									*
								</td>
								<font color="red"><html:errors />
								</font>
							</tr>


							<tr>
								<td align="center" colspan="4">
									<input type="submit" value="提交" />
									<input type="reset" value="重置" />
									</td>
							</tr>
						</table>
						<br/>
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
