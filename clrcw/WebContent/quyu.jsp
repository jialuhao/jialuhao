<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Areacode"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript">
	//checkbox交互
		$(function() {
		$("#weekday label input[type='checkbox']").click(function() {

			var checkbox = document.getElementsByName("fe");
			var j = 0; // 用户选中的选项个数
				for ( var i = 0; i < checkbox.length; i++) {
					if (checkbox[i].checked) {
						j++;
					}
				}
				if (j > 3) {
					alert('最多只能选择3个区县！');
					return false;
				} else {
					var hasDayoff = $(this).parent().hasClass('fileon');
					$(this).parent()[hasDayoff ? "removeClass" : "addClass"]
							('fileon');
				}

			});
	});

	var api = frameElement.api, W = api.opener;

	function returnquyu() {
	var chars ='';
		var objs = document.getElementsByName("fe");
		for ( var i = 0; i < objs.length; i++) {
			if (objs[i].checked) {
				chars += objs[i].value+",";
			}
		}
		W.document.getElementById("workyears").value = chars;
		api.close();
	}

	function quyuclose() {
		api.close();
	}
</script>
		<style type="text/css">
<!--
.add_yy {
	padding: 15px 0 0 0;
}

.fileon {
	display: block;
	background: #ede6ff;
	border: 1px dashed #d6cfe6;
	width: 225px;
	color: #000;
	height: 32px;
	line-height: 32px;
	float: left;
}

.add_yy li {
	display: block;
	background: #fff;
	width: 225px;
	border: 1px solid #ddd;
	margin: 0 10px 10px 0;
	font-size: 14px;
	height: 32px;
	line-height: 32px;
	float: left;
	color: #666;
}

.add_yy span {
	padding: 0 10px;
}

a.btn1 { /*管理按钮*/
	padding: 2px 16px;
	background: #900;
	color: #fff;
	border: 1px solid #900;
	margin: 0 0 0 5px;
	text-decoration: none;
}

a.btn1:hover {
	background: #fff;
	color: #900;
	text-decoration: none;
}

/* 清理浮动 */
.fn-clear:after {
	visibility: hidden;
	display: block;
	font-size: 0;
	content: " ";
	clear: both;
	height: 0;
}

.fn-clear {
	zoom: 1; /* for IE6 IE7 */
}
-->
</style>
	</head>

	<body>

		<div id="weekday">
			<div class="add_yy fn-clear">
				<ul>
					<%
					    String[] quyus=(String[])request.getSession().getAttribute("quyus");
						List list = (List) request.getSession().getAttribute("quyulist");
						for (int i = 0; i < list.size(); i++) {
							Areacode  areacode= (Areacode) list.get(i);
						Boolean  aaa=false;
						if(quyus!=null){
						for(int j=0;j<quyus.length;j++){
						if(areacode.getAreaname().equals(quyus[j])){
						aaa=true;
						}
						}
						}
						if(aaa){
					%>
					<li>
						<label class="fileon">
							<input name="fe" type="checkbox" id="feb" value="<%=areacode.getAreaname()%>"
								title="<%=areacode.getAreaname()%>" checked="checked"  class="mg-l" />
							<span><%=areacode.getAreaname()%></span>
						</label>
					</li>
					<%
						}else{
					%>
				<li>
						<label >
							<input name="fe" type="checkbox" id="feb" value="<%=areacode.getAreaname()%>"
								title="<%=areacode.getAreaname()%>"   class="mg-l" />
							<span><%=areacode.getAreaname()%></span>
						</label>
					</li>
					<%}} %>
				</ul>
			</div>
		</div>
		<div style="text-align: center; margin: 30px 0 0 0;">
			<a href="###" class="btn1" onclick="returnquyu()"
>确认</a><a href="###" class="btn1" onclick="quyuclose()">取消</a>
		</div>

	</body>
</html>
