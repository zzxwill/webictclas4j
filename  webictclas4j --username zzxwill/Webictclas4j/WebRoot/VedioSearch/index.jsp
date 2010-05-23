<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ include file="head.jsp"%>
<!-- %
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%-->

<%@ page import="java.sql.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>面向视频场景内容检索的文本解析工具设计与实现</title>

		<style type="text/css">
.relatedLinks h3 {
	padding: 10px 0px 2px 0px;
}

.STYLE14 {
	color: #000099;
	font-size: 14px;
	font-family: "微软雅黑";
	font-weight: bold;
}

h3 {
	font-size: 100%;
	color: #334d55;
}

h3 {
	font-family: Arial, sans-serif;
	margin: 0px;
	padding: 0px;
}

.STYLE26 {
	font-family: "微软雅黑";
	font-weight: bold;
	background-color: #FFFF99;
}

.STYLE61 {
	font-family: "微软雅黑";
	font-size: 18px;
	color: #006699;
}
</style>
	</head>

	<body leftmargin="0" topmargin="0">
		<center>















			<!--Split-->

			<table width="900" border="0" align="center" cellpadding="0"
				cellspacing="0" style="margin-top: 3px; margin-bottom: 6px;">
				<tr align="center">
					<td bgcolor="#F5F5F5" align='right' style="height: 28px">
						<table width="896" border=0 bgcolor="#ffffff" cellspacing=1
							cellpadding=1 height="45">
							<tr bgcolor='#FFFFFF' height='20'>


								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>

			<!--Split-->

			<table width="900" border="0" align="center" cellpadding="0"
				cellspacing="0" style="margin-top: 3px; margin-bottom: 6px;">
				<tr align="center">
					<td bgcolor="#F5F5F5" align='right' style="height: 28px">
						<table width="896" border=0 bgcolor="#ffffff" cellspacing=1
							cellpadding=1 height="45">
							<tr bgcolor='#FFFFFF' height='20'>


								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>

			<!--Split-->

			<table width="900" border="0" align="center" cellpadding="0"
				cellspacing="0" style="margin-top: 3px; margin-bottom: 6px;">
				<tr align="center">
					<td bgcolor="#F5F5F5" align='right' style="height: 28px">
						<table width="896" border=0 bgcolor="#ffffff" cellspacing=1
							cellpadding=1 height="45">
							<tr bgcolor='#FFFFFF' height='20'>


								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Split-->
			<!--Split-->


			<table width="900" border="0" align="center" cellpadding="0"
				cellspacing="0" style="margin-top: 3px; margin-bottom: 6px;">
				<tr align="center">
					<td bgcolor="#F5F5F5" align='right' style="height: 50px">
						<table width="896" border=0 bgcolor="#ffffff" cellspacing=1
							cellpadding=1 height="50">
							<tr bgcolor='#FFFFFF' height='20'>



								<td width="200">
									<form action='/labmanagement/servlet/Login' method='post'>
										<table width="886" border=0 cellspacing=0 cellpadding=0 style="width: 886px; height: 51px;" height="51">
											<tr>
												<td align="center" height="50">
													<div align+=="center"> 
														<strong><font size="3">VRLab视频</font></strong> <input type="text" name="stuNO" maxlength="150" size="50"> 
														<font size="5"><input type="submit" value="搜索视频"></font> 
													</div>

													<%
														//										out.print("<table width=100% border=0 cellspacing=0 cellpadding=0>");
														//										out.print("<form action='/labmanagement/servlet/Login' method='post'>");
														//											out.print("VRlab视频<input type=text name=stuNO>");

														//											out.print("<input type=submit value=搜索视频> ");

														//											out.print("</form>");
														//										out.print("</table>");
													%>

												</td>
											</tr>
										</table>
								</td>
							</tr>
						</table>


						<!--让下面的网站信息放在最下面-->

						<table width="900" border="0" align="center" cellpadding="0"
							cellspacing="0" style="margin-top: 3px; margin-bottom: 6px;">
							<tr align="center">
								<td bgcolor="#F5F5F5" align='right' style="height: 28px">
									<table width="896" border=0 bgcolor="#ffffff" cellspacing=1
										cellpadding=1 height="350">
										<tr bgcolor='#FFFFFF' height='20'>


											</td>

										</tr>
									</table>
								</td>
							</tr>
						</table>

						<table width="900" border="0" align="center" cellpadding="0"
							cellspacing="0" class="tbspan" style="margin-top: 3px">
							<tr>


								<td background="/templets/img/31bg5.gif" align="center">
									Copyright &copy; 2010&nbsp;&nbsp;北京航空航天大学计算机学院 蒋恺 周正喜
									<br>
									地址：北京市海淀区学院路37号院 邮编：100191
									<br>
									建设维护:蒋恺 周正喜&nbsp;&nbsp;&nbsp;电话：8610-82310488
									<br>
									电子邮箱:zzxwill@buaa.edu.cn
								</td>


							</tr>
						</table>

						<table width="900" border="0" align="center" cellpadding="0"
							cellspacing="0" class="tbspan">
							<tr>
								<td height="6"></td>
							</tr>
						</table>





						</center>
	</body>
</html>

