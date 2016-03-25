<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="../../public/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人简历详细信息</title>
<link href="<%=request.getContextPath()%>/public/cmsimges/css.css"
	rel="stylesheet" type="text/css">
</head>

<body class="body_view">
<table width="656" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td><img src="<%=request.getContextPath()%>/images/view_04.gif"
			width="656" height="48" alt="" /></td>
	</tr>
	<tr>
		<td background="<%=request.getContextPath()%>/images/view_06.gif">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="14"><a name="1" id="1"></a></td>
			</tr>
		</table>
		<table width="610" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FBE6AD">
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/images/view_09.gif">
					<tr>
						<td height="39">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="center" class="font6"><strong>基 本 情 况</strong></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr>
								<td height="5" colspan="2"></td>
							</tr>

							<tr>
								<td width="125" align="center" valign="top">
								<table width="110" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#B9C4CE">
									<tr>
										<td height="130" bgcolor="#FFFFFF"><logic:present
											name="applyJob" property="resumeCode.fkPersonImage">

											<html:img action="/showPhoto.do?method=show" paramId="id"
												paramName="applyJob"
												paramProperty="resumeCode.fkPersonImage.id" width="110"
												height="130" />
										</logic:present> <logic:notPresent name="applyJob"
											property="resumeCode.fkPersonImage">
											<img src="<%=request.getContextPath()%>/images/nophoto.gif"
												width="110" height="130" />
										</logic:notPresent></td>
									</tr>
								</table>
								</td>

								<td valign="top">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<logic:present name="applyJob">
										<bean:define id="resume" name="applyJob" property="resumeCode"
											type="model.PersonResume" />
										<tr>
											<td width="82" class="fontview">真实姓名：</td>
											<td width="175" bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="name" /></td>
											<td width="83" class="fontview">性 别：</td>
											<td width="176" bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="sex" /></td>
										</tr>
										<tr>
											<td width="82"><span class="fontview">出生日期：</span></td>
											<td width="175" bgcolor="#FFFFFF"><span class="font5"><bean:write
												name="resume" property="birthday" /></span></td>
											<td width="83"><span class="fontview">户籍所在地：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="homeplace" /></td>
										</tr>
										<tr>
											<td><span class="fontview">现在住址：</span></td>
											<td bgcolor="#FFFFFF"><span class="font5"><bean:write
												name="resume" property="address" /></span></td>
											<td><span class="fontview">邮 编：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="mailcode" /></td>
										</tr>
										<tr>
											<td><span class="fontview">联系电话：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="phone" /></td>
											<td><span class="fontview">最高学历：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="educate.educateName" /></td>
										</tr>
										<tr>
											<td><span class="fontview">工作年限：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="limitYear" /></td>
											<td><span class="fontview">计算机水平：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="compLevel" /></td>
										</tr>
										<tr>
											<td><span class="fontview">外语语种：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="lang" /></td>
											<td><span class="fontview">外语水平：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="resume" property="level1" /></td>
										</tr>
										<tr>
											<td><span class="fontview">残疾程度：</span></td>
											<td bgcolor="#FFFFFF" class="font5">
											<logic:equal name="resume" property="dkind" value="1">视力</logic:equal>
											<logic:equal name="resume" property="dkind" value="2">听力</logic:equal>
											<logic:equal name="resume" property="dkind" value="3">语言</logic:equal>
											<logic:equal name="resume" property="dkind" value="4">智力</logic:equal>
											<logic:equal name="resume" property="dkind" value="5">肢体</logic:equal>
											<logic:equal name="resume" property="dkind" value="6">精神</logic:equal>
											<logic:equal name="resume" property="dkind" value="7">综合</logic:equal>
											</td>
											<td><span class="fontview">残疾类别：</span></td>
											<td bgcolor="#FFFFFF" class="font5">
												<logic:equal name="resume" property="dlevel" value="1">一级</logic:equal>
												<logic:equal name="resume" property="dlevel" value="2">二级</logic:equal>
												<logic:equal name="resume" property="dlevel" value="3">三级</logic:equal>
												<logic:equal name="resume" property="dlevel" value="4">四级</logic:equal></td>
										</tr>
									</logic:present>
									<logic:notPresent name="applyJob">
										<p class="font5">没有简历信息！</p>
									</logic:notPresent>
								</table>
								</td>
							</tr>
							<tr>
								<td height="5" colspan="2"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
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
		<table width="610" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FBE6AD">
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/images/view_09.gif">
					<tr>
						<td height="39">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="center" class="font6"><strong>教 育 经 历</strong></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td valign="top"><logic:present name="educations">
									<tr>
						
													<td width="25%" align="center"><span class="fontview">起止时间</span></td>
													<td width="25%" align="center"><span class="fontview">毕业院校/机构</span></td>
													<td width="25%" align="center"><span class="fontview">所学专业</span></td>
													<td width="25%" align="center"><span class="fontview">学历/学位/获得证书</span></td></tr>
									
									<tr>
									<logic:iterate id="education_s" name="educations"
										type="model.PersonEducation">

								<table width="97%" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td>
												<table width="100%" border="0" align="center"
													cellpadding="0" cellspacing="0">
													<tr>
														<td width="25%" class="fontview"><bean:write
															name="education_s" property="startTime" />-<br/><bean:write
															name="education_s" property="endTime" /></td>
														<td width="25%" bgcolor="#FFFFFF" class="font5" align="center"><bean:write
															name="education_s" property="schoolname" /></td>
														<td width="25%" class="fontview" align="center"><bean:write
															name="education_s" property="profession" /></td>
														<td width="25%" class="fontview" align="center"><bean:write
															name="education_s" property="education" /></td>
													</tr>


												</table>
												</td>
											</tr>
											
											<tr>
												<td height="14">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="1" bgcolor="#CCD8E3"></td>
													</tr>
												</table>
												</td>
											</tr>
										

									</logic:iterate>
								</logic:present></td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
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
		<table width="610" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FBE6AD">
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/images/view_09.gif">
					<tr>
						<td height="39">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="center" class="font6"><strong>工 作 简 历</strong></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
													<td width="25%" align="center" class="fontview">起止时间</td>
													<td width="25%" align="center" class="fontview">工作单位</td>
													<td width="25%" align="center" class="fontview">职务/职位</td>
													<td width="25%" align="center" class="fontview">工作内容</td></tr>
							<tr>
							<tr>
								<logic:present name="ResumeB">
									<logic:iterate id="resume2" name="ResumeB"
										type="model.PersonResumeB">

										<table width="97%" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td>
												<table width="100%" border="0" align="center"
													cellpadding="0" cellspacing="0">
													<tr>
														<td width="25%" align="center" class="font5"><bean:write
															name="resume2" property="startTime" />-<br/><bean:write
															name="resume2" property="endTime" /></td>
														<td bgcolor="#FFFFFF" width="25%" align="center" class="font5"  ><bean:write
															name="resume2" property="workUnit" /></td>
														<td width="25%" align="center" class="font5"  align="center"><bean:write
															name="resume2" property="job" /></td>
													<td bgcolor="#FFFFFF"  width="25%" align="center" class="font5"><bean:write
															name="resume2" property="workContent" /></td>
													</tr>


												</table>
												</td>
											</tr>
											
											<tr>
												<td height="14">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="1" bgcolor="#CCD8E3"></td>
													</tr>
												</table>
												</td>
											</tr>
										

									</logic:iterate>
								</logic:present>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
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
		<table width="610" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FBE6AD">
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/images/view_09.gif">
					<tr>
						<td height="39">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="center" class="font6"><strong>兴 趣 特 长 </strong></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<logic:present name="applyJob">
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td valign="top" class="font5"><bean:write name="applyJob"
										property="resumeCode.interests" /></td>
								</tr>
							</logic:present>
						</table>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr></tr>
						</table>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr></tr>
							<tr>
								<td height="5"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
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
		<table width="610" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FBE6AD">
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/images/view_09.gif">
					<tr>
						<td height="39">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="center" class="font6"><strong>自 我 介 绍 </strong></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<logic:present name="applyJob">
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td valign="top" class="font5"><bean:write name="applyJob"
										property="resumeCode.introSelf" /></td>
								</tr>
							</logic:present>
						</table>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr></tr>
						</table>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr></tr>
							<tr>
								<td height="5"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
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
		<table width="610" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FBE6AD">
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/images/view_09.gif">
					<tr>
						<td height="39">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="center" class="font6"><strong>联 系 方 式</strong></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">

							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td valign="top" class="font5">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<logic:present name="applyJob">
										<tr>
											<td width="16%"><span class="fontview">现在住址：</span></td>
											<td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="resumeCode.address" /></td>
											<td width="16%"><span class="fontview">户籍所在地：</span></td>
											<td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="resumeCode.homeplace" /></td>
										</tr>
										<tr>
											<td><span class="fontview">联系电话：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="resumeCode.phone" /></td>
											<td><span class="fontview">邮 编：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="resumeCode.mailcode" /></td>
										</tr>

									</logic:present>
								</table>
								</td>
							</tr>
						</table>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr></tr>
						</table>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr></tr>
							<tr>
								<td height="5"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
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
		<table width="610" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FBE6AD">
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/images/view_09.gif">
					<tr>
						<td height="39">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="center" class="font6"><strong>求 职 信 息</strong></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
				<table width="598" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="5"
							cellspacing="0">
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td valign="top" class="font5"><logic:present
									name="applyJob">

									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="16%"><span class="fontview">期望从事行业：</span></td>
											<td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="postCode.tradeName" /></td>
											<td width="16%"><span class="fontview">欲求职位：</span></td>
											<td width="34%" bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="jobCode.jobName" /></td>
										</tr>
										<tr>
											<td><span class="fontview">期望工作地点：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="workYear" /></td>
											<td><span class="fontview">期望月薪(税前)：</span></td>
											<td bgcolor="#FFFFFF" class="font5"><bean:write
												name="applyJob" property="salary" /></td>
										</tr>
									</table>

								</logic:present> <logic:notPresent name="applyJob">
									<p class="font5">没有求职信息！</p>
								</logic:notPresent></td>
							</tr>
						</table>
						
						
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
		</table>
		</td>
	</tr>
	


		<logic:present name="isNo">
			<logic:notEqual name="isNo" value="1">

				<td height="40" align="center"><a
					href="${ctx}/admin/aglientpublish.do?method=join&ResumeId=${applyJob.personCode.id}"
					Class="d"> <span class="font10">[放入人才库]</span> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" Class="d" onClick="history.back();return false;"> <span
					class="font10">[返回]</span> </a></td>
			</logic:notEqual>
			<logic:equal name="isNo" value="1">
				<td height="40" align="center" class="font5">已经归入人才库！请 <a
					href="#" Class="d" onClick="history.back();return false;"> <span
					class="font10">[返回]</span> </a></td>
			</logic:equal>
		</logic:present>
		<logic:notPresent name="isNo">
		</logic:notPresent>

	
</table>


<map name="Map" id="Map">
	<area shape="rect" coords="603,16,644,37" href="#1" />
</map>
</body>
</html>