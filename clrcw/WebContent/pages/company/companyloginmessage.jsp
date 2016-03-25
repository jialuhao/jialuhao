<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@page import="model.*" %>
<%@ page import="java.text.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查看企业招聘信息</title>
	<link href="<%=request.getContextPath()%>/css/index3.css"
		rel="stylesheet" type="text/css">

	<link rel="stylesheet" type="text/css" href="/clrcw/css/public.css" />
	<link rel="stylesheet" type="text/css" href="/clrcw/css/mainframe.css" />

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
			<div id="content">
				<h2>
					
				</h2>
				<DIV class="formdiv"
					style="margin-top: -31px; padding: 30px; background: #fff; border-bottom: 0;">
					<html:form action="/companyPubJob.do?method=savePubJob"
						method="post" onsubmit="return checkform()">
						
						<table class="finktable" summary="企业招聘信息" width="100%">
							<TR>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									招聘职位
								</TD>
								
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									审核状态
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									审核意见
								</TD>
								<TD align="center"
									style="padding: 10px; color: #fff; font-size: 12px; font-weight: normal; background: #900;">
									是否需要延期
								</TD>
								</TR>
								<%List publishjob=(List)request.getSession().getAttribute("publishjob"); 
								  for(int i=0;i<publishjob.size();i++) {
								  Object[] ttt = (Object[])publishjob.get(i);
						PublishJobInfo publishJobInfo = (PublishJobInfo) ttt[0];
						String states=publishJobInfo.getStatus();
						if("0".equals(states.trim())){states="待审核";
						}else if("1".equals(states.trim())){states="审核未通过";
						}else if("2".equals(states.trim())){states="审核通过";
						}
						String opinion=publishJobInfo.getOpinion();
						if(opinion==null){
						opinion="";
						}
						String rrr="不需要延期";
						String closetime=publishJobInfo.getCloseTime();
						SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
						Date close=sd.parse(closetime);
						Date now=new Date();
						long time=(close.getTime()-now.getTime())/(24*60*60*1000);
						if(time<10){
						rrr="需要延期";
						}
						%>
								<TR>
								<td><%=publishJobInfo.getJob().getJobName()%></td>
								<td><%=states%></td>
								<td><%=opinion%></td>
								<td><%=rrr%></td>
								</TR>
								<%} %>
						</table>
						<div
							style="text-align: center; padding: 20px 0; margin: -1px 0 0 0; border: #ddd 1px solid; background: #ededed;">

							
							
							
						</div>
					</html:form>
				</div>
			</div>
			<div align="center">
            
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
