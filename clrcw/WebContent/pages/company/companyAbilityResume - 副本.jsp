<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人简历详细信息</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css" rel="stylesheet" type="text/css">

</head>

<body class="body_view">
<table width="656" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="<%=request.getContextPath()%>/images/view_04.gif" width="656" height="48" alt="" /></td>
  </tr>
  <tr>
    <td background="<%=request.getContextPath()%>/images/view_06.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="14"><a name="1" id="1"></a></td>
      </tr>
    </table>
      <table width="610" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FBE6AD">
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/images/view_09.gif">
            <tr>
              <td height="39"><table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td align="center" class="font6"><strong>基 本 情 况</strong></td>
                </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
            <tr>
              <td><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                <tr>
                  <td height="5" colspan="2"></td>
                  </tr>
                  
                <tr>
                    <td width="125" align="center" valign="top"><table width="110" border="0" cellpadding="0" cellspacing="1" bgcolor="#B9C4CE">
                    <tr>
                      <td height="130" bgcolor="#FFFFFF">
                      
                     <logic:present name="resume" property="fkPersonImage">
                      <html:img  action="/showPhoto.do?method=show" paramId="id" paramName="resume" paramProperty="fkPersonImage.id" width="110" height="130"/>
                      </logic:present>
                      <logic:notPresent name="resume" property="fkPersonImage">
                      <img src="<%=request.getContextPath()%>/images/nophoto.gif" width="110" height="130" />
                      </logic:notPresent>
                      
                      </td>
                    </tr>
                  </table></td>
                
                  <td  valign="top">
                  <!-- 显示个人简历信息 -->
                  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
   		<logic:present name="resume">
			<tr>
                      <td width="82" class="fontview">真实姓名：</td>
                      <td width="175" bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="name"/></td>
                      <td width="83" class="fontview">性　　别：</td>
                      <td width="176" bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="sex"/></td>
                    </tr>
                    <tr>
                      <td width="82"><span class="fontview">出生日期：</span></td>
                      <td width="175" bgcolor="#FFFFFF"><span class="font5"><bean:write name="resume" property="birthday"/></span></td>
                      <td width="83"><span class="fontview">户籍所在地：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="homeplace"/></td>
                    </tr>
                    <tr>
                      <td><span class="fontview">现在住址：</span></td>
                      <td bgcolor="#FFFFFF"><span class="font5"><bean:write name="resume" property="address"/></span></td>
                      <td><span class="fontview">邮　　编：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="mailcode"/></td>
                    </tr>
                    <tr>
                      <td><span class="fontview">联系电话：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="phone"/></td>
                      <td><span class="fontview">最高学历：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="educate.educateName"/></td>
                    </tr>
                    <tr>
                      <td><span class="fontview">毕业学校：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="school"/></td>
                      <td><span class="fontview">所学专业：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="specialty"/></td>
                    </tr>
                    <tr>
                      <td><span class="fontview">工作年限：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="limitYear"/></td>
                      <td><span class="fontview">计算机水平：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="compLevel"/></td>
                    </tr>
                    <tr>
                      <td><span class="fontview">外语语种1：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="lang"/></td>
                      <td><span class="fontview">外语水平1：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="level1"/></td>
                    </tr>
                    <tr>
                      <td><span class="fontview">残疾程度：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="lang2"/></td>
                      <td><span class="fontview">残疾类别：</span></td>
                      <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="level2"/></td>
                    </tr>
   	</logic:present>
	<logic:notPresent name="resume">
		<p class="font5">没有简历信息！</p>
	</logic:notPresent>
                  </table>
                  </td>
                </tr>
                <tr>
                  <td height="5" colspan="2"></td>
                  </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="14"></td>
        </tr>
      </table>
      <table width="610" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FBE6AD">
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/images/view_09.gif">
              <tr>
                <td height="39"><table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td align="center" class="font6"><strong>工 作 简 历</strong></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
              <tr>
                <td>
                <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                    <tr>
                      <td height="5"></td>
                    </tr>
                    <tr>
                      <td valign="top">
      <logic:present name="resumeb">
	<logic:iterate id="resume2" name="resumeb" type="model.PersonResumeB">             
                      
                      <table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="120" class="fontview"><bean:write name="resume2" property="startTime"/>-<bean:write name="resume2" property="endTime"/></td>
                              <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume2" property="workUnit"/></td>
                              <td width="150" class="fontview"><bean:write name="resume2" property="job"/></td>
                            </tr>

                            
                          </table></td>
                        </tr>
                        <tr>
                          <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                            <tr>
                              <td width="120">&nbsp;</td>
                              <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume2" property="workContent"/></td>
                            </tr>
                           </table></td>
                        </tr>
                        <tr>
                          <td height="14"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td height="1" bgcolor="#CCD8E3"></td>
                            </tr>
                          </table></td>
                        </tr>
                      </table>
                      
     	</logic:iterate>
     </logic:present> 
      <logic:notPresent name="resumeb">
		<p class="font5">没有工作/实习经历！</p>
	</logic:notPresent>                

					</td>
                    </tr>
                    <tr>
                      <td height="5"></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="14"></td>
        </tr>
      </table>
      <table width="610" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FBE6AD">
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/images/view_09.gif">
              <tr>
                <td height="39"><table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td align="center" class="font6"><strong>自 我 介 绍 </strong></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
              <tr>
                <td><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                <logic:present name="resume">
                    <tr>
                      <td height="5"></td>
                    </tr>
                    <tr>
                      <td valign="top" class="font5"><bean:write name="resume" property="introSelf"/></td>
                    </tr>
                </logic:present>
                    </table>
                  <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0"><tr></tr></table>
                  <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0"><tr></tr>
                    <tr>
                      <td height="5"></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="14"></td>
        </tr>
      </table>
      <table width="610" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FBE6AD">
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/images/view_09.gif">
              <tr>
                <td height="39"><table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td align="center" class="font6"><strong>联 系 方 式</strong></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
              <tr>
                <td><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                
                    <tr>
                      <td height="5"></td>
                    </tr>
                    <tr>
                      <td valign="top" class="font5"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<logic:present name="resume">
                        <tr>
                          <td width="16%"><span class="fontview">现在住址：</span></td>
                          <td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="address"/></td>
                          <td width="16%"><span class="fontview">户籍所在地：</span></td>
                          <td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="homeplace"/></td>
                        </tr>
                        <tr>
                          <td><span class="fontview">联系电话：</span></td>
                          <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="phone"/></td>
                          <td><span class="fontview">邮　　编：</span></td>
                          <td bgcolor="#FFFFFF" class="font5"><bean:write name="resume" property="mailcode"/></td>
                        </tr>

					</logic:present>
                      </table></td>
                    </tr>
                </table>
                    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                      <tr></tr>
                    </table>
                  <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                    <tr></tr>
                      <tr>
                        <td height="5"></td>
                      </tr>
                  </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="14"></td>
        </tr>
      </table>
      <table width="610" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FBE6AD">
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/images/view_09.gif">
              <tr>
                <td height="39"><table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td align="center" class="font6"><strong>求 职 信 息</strong></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
        <tr>
          <td><table width="598" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
              <tr>
                <td><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                    <tr>
                      <td height="5"></td>
                    </tr>
                    <tr>
                      <td valign="top" class="font5">
                      
                      
                      
        <logic:present name="applyJob">
             <logic:iterate id="job" name="applyJob" type="model.ApplyJobInfo">   
                      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="16%"><span class="fontview">欲求专业：</span></td>
                            <td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write name="job" property="postCode.postName"/></td>
                            <td width="16%"><span class="fontview">欲从事职位：</span></td>
                            <td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write name="job" property="jobCode.jobName"/></td>
                          </tr>
                          <tr>
                            <td><span class="fontview">曾从事本职位：</span></td>
                            <td bgcolor="#FFFFFF" class="font5"><bean:write name="job" property="workYear"/>年</td>
                            <td><span class="fontview">期望月薪(税前)：</span></td>
                            <td bgcolor="#FFFFFF" class="font5"><bean:write name="job" property="salary"/></td>
                          </tr>
                           <tr>
                          <td height="14" colspan="4"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td   height="1" bgcolor="#CCD8E3"></td>
                            </tr>
                          </table></td>
                        </tr>

                      </table>
             </logic:iterate>         
         </logic:present>
         <logic:notPresent name="applyJob">
			<p class="font5">没有求职信息！</p>
		</logic:notPresent>             
                      
                      
                      </td>
                    </tr>
                  </table>
                    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                      <tr>
                      
                      </tr>
                    </table>
                  <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                      <tr></tr>
                      <tr>
                        <td height="5"></td>
                      </tr>
                  </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="7"></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td><img src="<%=request.getContextPath()%>/images/view_12.gif" alt="" width="656" height="70" border="0" usemap="#Map" /></td>
  </tr>
  <tr>
    <td height="8"></td>
  </tr>
  <tr>
  
 	<td height="40" align="center">
		<a href="#" Class="d" onClick="history.back();return false;" >
			<span class="font10">[返回]</span>
		</a>
	</td>
  
  </tr>
</table>


<map name="Map" id="Map"><area shape="rect" coords="603,16,644,37" href="#1" />
</map></body>
</html>