<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="model.PersonResume"%>


<style>
html,body{font-size:12px;margin:0px;height:100%;}
.mesWindow{border:#666 1px solid;background:#fff;}
.mesWindowTop{border-bottom:#eee 1px solid;margin-left:4px;padding:3px;font-weight:bold;text-align:left;font-size:12px;}
.mesWindowContent{margin:4px;font-size:12px;}
.mesWindow .close{height:15px;width:28px;border:none;cursor:pointer;text-decoration:underline;background:#fff}
</style>
<script>
function checkform(){

      var state=document.getElementById('status').value;	
	   var opinion=document.getElementById('opinion').value;	
   
     if(state.length<=0){
      alert("请选择审核状态");
      return false;
      }
      if(opinion.length > 100||opinion.length<=0){
      alert("审核意见必须小于100个字");
      return false;
      }
    parent.location.reload();
    document.myform.submit();  
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>求职信息审核</title>
<link href="${ctx}/public/cmsimges/css.css" rel="stylesheet"
	type="text/css">
</head>

<body>
<jsp:include page="include/contentHeader.jsp">
	<jsp:param name="contentTitle" value="审核意见填写" />
</jsp:include>

<form action="${ctx}/admin/showAllBespeak.do?method=modifyBespeak" 
						method="post" name="myform" id="myform">
						
						
				<table align="center" width="85%">	
				<tr>
				<td  style="text-align: center;">
			审核状态：</td>
			<td>
				<select id="status" name="status"  onchange="setdefaultOpinion(this);">
					<option value="">--请选择--</option>  
					<option value="2" >审核通过</option>  
  					<option value="1" >审核未通过</option>
  					
    			</select>
    			</td>
    			</tr>
    			<script type="text/javascript">
    			function setdefaultOpinion(obj){
    			if(obj.value=="2"){document.getElementById("opinion").value="同意";}
    			else{
    			document.getElementById("opinion").value="";
    			}
    			
    			
    			}
    			
    			</script>
    			<tr>
    			<td style="text-align: center;">
									审核意见：
									</td>
			<td>
									<textarea name="opinion" title="请输入意见、建议（最多100字）" id="opinion"
										cols="70" rows="5"></textarea>
									
								</td>
								</tr>
								<tr>
								<td colspan='2' align="center" class="black">
								<input type="button" class="input8" onclick="checkform()" value="提交" />
									
									<input type="button" class="input8" onclick="history.go(-1)" value="返回" />
								</td>
								
								</tr>
    			</table>
			
									
								
							
						<br />
						</form>
<table width="98%" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="40">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="1" bgcolor="94C2F1"></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html:html>

