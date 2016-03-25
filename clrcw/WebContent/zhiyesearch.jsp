<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.BdJob"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript">
	//checkbox交互
	$(function() {
		$("#weekday label input[type='radio']").click(function() {
			var hasDayoff = $(this).parent().hasClass('fileon');
//		$(this).parent()[hasDayoff ? "removeClass" : "addClass"]('fileon');
		});
	});

	var api = frameElement.api, W = api.opener;
	function returnhangye() {
		var objs = document.getElementsByName("fe");  
		for (i = 0; i < objs.length; i++) { 
			if (objs[i].checked == true) {				
				W.document.getElementById("jobname").value = objs[i].title;
			}
		}
		api.close();
	}

	function hangyeclose() {
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
						List list = (List) request.getSession().getAttribute("bdjob");
						for (int i = 0; i < list.size(); i++) {
							BdJob bdjob = (BdJob) list.get(i);
						if(i==0){
					%>
					<li>
						<label>
							<input name="fe" type="radio" id="feb" value="<%=bdjob.getId()%>"
								title="<%=bdjob.getJobName()%>" checked="checked" class="mg-l" />
							<span><%=bdjob.getJobName()%></span>
						</label>
					</li>
					<%
						}else{
					%>
					<li>
						<label>
							<input name="fe" type="radio" id="feb" value="<%=bdjob.getId()%>"
								title="<%=bdjob.getJobName()%>"  class="mg-l" />
							<span><%=bdjob.getJobName()%></span>
						</label>
					</li>
					<%	
						}}
					%>
				</ul>
			</div>
		</div>
		<div style="text-align: center; margin: 30px 0 0 0;">
			<a href="###" class="btn1" onclick=returnhangye();
>确认</a><a href="###" class="btn1" onclick=hangyeclose();>取消</a>
		</div>

	</body>
</html>
