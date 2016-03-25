// JavaScript Document
if(window.attachEvent){
window.attachEvent("onload",ss);
}else{
window.addEventListener('load',ss,false);
}
function ss(){
	var aa = document.getElementById('aa'),
		b = document.body;
	aa.onclick=function(e){
		e = e || window.event;
		if(aa.title=="开启辅助工具条"){
			aa.firstChild.nodeValue="关闭辅助工具条";
			aa.title = "关闭辅助工具条";
			toolbar.Function.show.mainMethod();	
			document.body.className = 'wlBj_on';
		}else{
			aa.firstChild.nodeValue="开启辅助工具条";
			aa.title = "开启辅助工具条";
			toolbar.Function.show.mainMethod();
			document.body.className = 'wlBj_off';
		}
		ADS.preventDefault(e);
	}
}
document.writeln('  	<div id="bg"><div><span class="span">欢迎访问北京市残疾人联合会网站</span>');
document.writeln("    <ul class=\"top\">");
document.writeln('    	<li class="gjt"><a href="#" id = "aa" title="开启辅助工具条">开启辅助工具条</a></li>');
document.writeln("        <li class=\"sm\"><a href=\"#\" title=\"无障碍声明\">无障碍声明</a></li>");
document.writeln("        <li class=\"dt\"><a href=\"#\" title=\"网站地图\">网站地图</a></li>");
document.writeln("        <li class=\"dt\"><a href=\"#\" title=\"快速通道\">快速通道</a></li>");
document.writeln("    </ul></div></div>");
document.writeln("    <div class=\"banner\"><img src=\"/clrcw/images/top_banner.jpg\" width=\"960\" height=\"121\"  title=\"北京市残疾人联合会图片\" alt=\"北京市残疾人联合会图片\"/></div>");
document.writeln("    <div id=\"dh\">");
document.writeln("    	<h2 class=\"home\"><a href=\"#\" title=\"首页\"><img src=\"/clrcw/images/home.jpg\" width=\"90\" height=\"47\" title=\"首页\" alt=\"首页\"/></a></h2>");
document.writeln("        <h2 class=\"lm\"><a href=\"#\" title=\"政务频道\"><img src=\"/clrcw/images/zwpd.jpg\" width=\"46\" height=\"47\" title=\"政务频道\" alt=\"政务频道\"/></a></h2>");
document.writeln("        <ul class=\"xbt\">");
document.writeln("        	<li><a href=\"#\" title=\"政务公开\">政务公开</a></li>");
document.writeln("            <li><a href=\"#\" title=\"通知公告\">通知公告</a></li>");
document.writeln("            <li><a href=\"#\" title=\"办事指南\">办事指南</a></li>");
document.writeln("            <li><a href=\"#\" title=\"表格下载\">表格下载</a></li>");
document.writeln("            <li><a href=\"#\" title=\"党建工作\">党建工作</a></li>");
document.writeln("            <li><a href=\"#\" title=\"政策法规\">政策法规</a></li>");
document.writeln("            <li><a href=\"#\" title=\"理论研究\">理论研究</a></li>");
document.writeln("            <li><a href=\"#\" title=\"互动参与\">互动参与</a></li>");
document.writeln("        </ul>");
document.writeln("        <h2 class=\"lm\"><a href=\"#\" title=\"资讯频道\"><img src=\"/clrcw/images/zxpd.jpg\" width=\"46\" height=\"47\" title=\"资讯频道\" alt=\"资讯频道\"/></a></h2>");
document.writeln("        <ul class=\"xbt\">");
document.writeln("        	<li><a href=\"#\" title=\"工作动态\">工作动态</a></li>");
document.writeln("            <li><a href=\"#\" title=\"区县信息\">区县信息</a></li>");
document.writeln("            <li><a href=\"#\" title=\"残联政务\">残联政务</a></li>");
document.writeln("            <li><a href=\"#\" title=\"专题专栏\">专题专栏</a></li>");
document.writeln("            <li><a href=\"#\" title=\"视听专区\">视听专区</a></li>");
document.writeln("            <li><a href=\"#\" title=\"自强之声\">自强之声</a></li>");
document.writeln("            <li><a href=\"#\" title=\"挚友杂志\">挚友杂志</a></li>");
document.writeln("            <li><a href=\"#\" title=\"相关知识\">相关知识</a></li>");
document.writeln("        </ul>");
document.writeln("        <h2 class=\"lm\"><a href=\"#\" title=\"业务频道\"><img src=\"/clrcw/images/ywpd.jpg\" width=\"46\" height=\"47\" title=\"业务频道\" alt=\"业务频道\"/></a></h2>");
document.writeln("        <ul class=\"xbt xbt1\">");
document.writeln("        	<li><a href=\"#\" title=\"康复服务\">康复服务</a></li>");
document.writeln("            <li><a href=\"#\" title=\"教育就业\">教育就业</a></li>");
document.writeln("            <li><a href=\"#\" title=\"文化体育\">文化体育</a></li>");
document.writeln("            <li><a href=\"#\" title=\"法律维权\">法律维权</a></li>");
document.writeln("            <li><a href=\"#\" title=\"辅具器具\">辅具器具</a></li>");
document.writeln("            <li><a href=\"#\" title=\"爱心助残\">爱心助残</a></li>");
document.writeln("        </ul>");
document.writeln("    </div>");
document.writeln("    <div id=\"yhdl\">");
document.writeln("    	<form action=\"\" name=\"form\" method=\"post\" id=\"dl\">");
document.writeln("        	<label>用户名：</label>");
document.writeln("            <input type=\"text\" name=\"\" class=\"yhm\" onfocus=\"clearInput(this)\" onblur=\"returnInput(this)\" title=\"填写用户名\" value=\"填写用户名\"/>");
document.writeln("            <label>密码：</label>");
document.writeln("            <input type=\"password\" name=\"\" class=\"yhm\" title=\"请输入密码\"/>");
document.writeln("            <input type=\"submit\" value=\"登录\" class=\"dl\" title=\"登录按钮\"/>");
document.writeln("            <input type=\"submit\" value=\"注册\" class=\"dl\" title=\"注册按钮\"/>");
document.writeln("            <span><a href=\"#\" title=\"忘记密码\">忘记密码</a>|<a href=\"#\" title=\"注册说明\">注册说明</a></span>");
document.writeln("        </form>");
        
document.writeln("        <form action=\"\" name=\"form\" method=\"post\" id=\"search\">");
document.writeln("        	<label>站内搜索：</label>");
document.writeln("            <input type=\"text\" name=\"\" class=\"nr\" onfocus=\"clearInput(this)\" onblur=\"returnInput(this)\" title=\"请输入搜索内容\" value=\"请输入搜索内容\"/>");
document.writeln("            <input type=\"submit\" value=\"搜索\" class=\"ss\" title=\"搜索按钮\"/>");
document.writeln("        </form>");
document.writeln("    </div>");