<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
<title><bean:message key="personPage"/></title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="978" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="189"><img src="<%=request.getContextPath()%>/images/index_02.jpg" width="189" height="93" alt="" /></td>
    <td width="789"><img src="<%=request.getContextPath()%>/images/index_03.jpg" width="789" height="93" alt="" /></td>
  </tr>
</table>
<table width="978" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="25"><img src="<%=request.getContextPath()%>/images/index_05.jpg" width="25" height="37" alt="" /></td>
    <td valign="top" background="<%=request.getContextPath()%>/images/index_06.jpg"><table width="98%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="28" align="center"><a href="#" class="b">个人求职</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">企业招聘</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">政策法规</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">职业指导</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">区域工资</a></td>
        <td width="4" align="center"><img src="<%=request.getContextPath()%>/images/index_10.jpg" width="4" height="22" alt="" /></td>
        <td align="center"><a href="#">资讯中心</a></td>
      </tr>
    </table></td>
    <td width="7"><img src="<%=request.getContextPath()%>/images/index_08.jpg" width="7" height="37" alt="" /></td>
  </tr>
</table>
<table width="978" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="272" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="20"><img src="<%=request.getContextPath()%>/images/index_16.jpg" width="20" height="139" alt=""></td>
     <td valign="top" background="<%=request.getContextPath()%>/images/index_17.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center"> <a href="#" class="b">个人用户</a></td>
            <td width="137"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
              <tr>
                <td align="center" bgcolor="#6B739A"><a href="#" class="c">企业用户</a></td>
              </tr>
            </table></td>
          </tr>
        </table>
          <html:form action="/login.do?method=login" method="post" onsubmit="return validateLoginForm(this);">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td height="25"><bean:message key="username"/>：
                <html:text property="username"  size="15" /></td>
            </tr>
            
            <tr>
              <td height="25">密 &nbsp;&nbsp;码：
                <html:password property="password" size="15" /></td>
            </tr>
            <tr>
              <td height="25" align="center"><a href="#" class="d">忘记密码</a>&nbsp; | &nbsp;<a href="#" class="d">新用户注册</a>
             
              </td>
            </tr>
            <tr>
            <td>
             <html:submit property="submit" value="登录"/>
            
            </td>
            </tr>
          </table>
          </html:form>
          </td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="8" bgcolor="#FFFFFF"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="848484">
        <tr>
          <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="29" bgcolor="549ADE"><table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td><img src="<%=request.getContextPath()%>/images/icon.gif" width="10" height="10"> <span class="font4"><strong> 热点文章</strong></span></td>
                    </tr>
                </table></td>
              </tr>
            </table>
              <table width="89%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="10" colspan="2"></td>
                </tr>
                <tr>
                  <td colspan="2" class="font5">· <a href="#" class="d">猎头看简历</a> <br>
                    · <a href="#" class="d">猎头看简历</a>：好... <br>
                    · <a href="#" class="d">猎头看简历</a>？ <br>
                    · <a href="#" class="d">猎头看简历</a> <br>
                    · <a href="#" class="d">变身职场金刚—求职小文.. </a><br>
                    · <a href="#" class="d">告诫：毕业生简历管理切..</a><br>
                    · <a href="#" class="d">猎头看简历</a> <br>
· <a href="#" class="d">猎头看简历</a>：好... <br>
· <a href="#" class="d">猎头看简历</a>？ <br>
· <a href="#" class="d">猎头看简历</a> <br></td>
                </tr>
                
                <tr>
                  <td height="10" colspan="2"></td>
                </tr>
            </table></td>
        </tr>
      </table></td>
    <td width="10">&nbsp;</td>
    <td valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#E5EAEE">
            <tr>
              <td height="5"></td>
            </tr>
            <tr>
              <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="300"><img src="<%=request.getContextPath()%>/images/index_55.jpg" width="138" height="29" alt=""></td>
                  <td align="right"><table width="205" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="60" class="font3">职位搜索</td>
                      <td><input name="textfield3" type="text" class="input2" id="textfield3"></td>
                      <td width="25"><img src="<%=request.getContextPath()%>/images/index_39.jpg" width="21" height="19" alt=""></td>
                    </tr>
                  </table></td>
                </tr>
              </table>
                <table width="95%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="9DB4EC">
                  <tr>
                    <td bgcolor="#E5EAEE"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                          <tr>
                            <td width="40%" height="23" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg" class="font4">姓 名</td>
                            <td width="40%" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg"><span class="font4">应聘职位</span></td>
                            <td width="20%" align="center" background="<%=request.getContextPath()%>/images/index_48.jpg" class="font4">公司</td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td>
             <%--显示个人求职信息include showAllApplyJobInfo.jsp<jsp:include page="/showAllApplyJobInfo.jsp"/> --%>
                        <jsp:forward page="/login.do?method=showAll"/>
                        
                        </td>
                      </tr>
                    </table></td>
                  </tr>
                </table>                </td>
            </tr>
            <tr>
              <td height="5"></td>
            </tr>
          </table>
            </td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="970" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="8" bgcolor="#FFFFFF"></td>
  </tr>
</table>
<table width="970" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="153"><table width="153" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_58.jpg" width="153" height="58" alt=""></td>
      </tr>
    </table></td>
    <td width="153"><table width="153" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_60.jpg" width="153" height="58" alt=""></td>
      </tr>
    </table></td>
    <td width="153"><table width="153" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_62.jpg" width="153" height="58" alt=""></td>
      </tr>
    </table></td>
    <td width="153"><table width="153" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_64.jpg" width="153" height="58" alt=""></td>
      </tr>
    </table></td>
    <td width="153"><table width="153" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_68.jpg" width="153" height="58" alt=""></td>
      </tr>
    </table></td>
    <td width="153"><table width="153" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_58.jpg" width="153" height="58" alt=""></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="970" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="8" bgcolor="#FFFFFF"></td>
  </tr>
</table>
<table width="970" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="315" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_76.jpg" width="315" height="58" alt=""></td>
      </tr>
    </table></td>
    <td><table width="315" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_78.jpg" width="315" height="58" alt=""></td>
      </tr>
    </table></td>
    <td><table width="315" border="0" cellpadding="0" cellspacing="1" bgcolor="E08282">
      <tr>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/index_80.jpg" width="315" height="58" alt=""></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="978" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">&nbsp;</td>
  </tr>
</table>
<table width="978" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3" bgcolor="7D8193"></td>
  </tr>
  <tr>
    <td height="100" align="center"><span class="font5"><a href="#" class="d">关于我们</a>&nbsp;  &nbsp;|&nbsp;&nbsp;  <a href="#" class="d">联系我们</a>&nbsp;&nbsp;  |&nbsp;&nbsp;  <a href="#" class="d">版权声明</a>&nbsp;&nbsp;  |&nbsp;&nbsp; <a href="#" class="d">网站地图</a> </span><span class="font2"><br>
  copyright?2002 中华人民共和国国防科学技术工业委员会信息中心 版权所有 </span><br>
      <span class="font5">通讯地址：北京8184信箱　　邮编100081</span></td>
  </tr>
</table>
</body>
<html:javascript formName="LoginForm"/>
</html:html>
