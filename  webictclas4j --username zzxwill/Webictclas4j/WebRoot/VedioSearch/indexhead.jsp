<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.sql.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>实验室管理系统网站</title>
		
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
		
			<table width="900" border="0" align="center" cellpadding="0"
				cellspacing="0" class="tbspan">
				<tr>
					<td width="616" height="78" align="center">
						<a href='http://localhost:8080/labmanagement/jsp/index.jsp' target='_blank'> <img
								src="/labmanagement/images/title.jpg" width="680" height="72" border='0'
								alt="实验室管理系统">
						</a>
					</td>
					<td width="10" align="center">
						&nbsp;
					</td>
					<td width="112" align="center"></td>
					<td width="165" align="center">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr align="center" height="20">
								<td height="24">
									<a href="developing.jsp">网站地图</a>
								</td>
								<td>
									<a href="developing.jsp">RSS订阅</a>
								</td>
							</tr>
							<tr align="center" height="20">
								<td>
									<a href="developing.jsp">高级搜索</a>
								</td>
								<td>
									<a href='#'
										onClick="javascript:window.external.AddFavorite('http://localhost:8080/labmanagement/jsp/index.htm','实验室管理系统');">
										收藏本站</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
			
			<table width="900" border="0" align="center" cellpadding="0"
				cellspacing="0" class="tbspan">
				<tr>
					<td width="880" background="/templets/img/31bg1.gif">
						<span class="STYLE61"><a href="index.jsp">首页</a> | <a
							href="labIntro.jsp"> 实验室概况</a> | <a href="teachers.jsp">
						人员构成</a>
							| <a href="project.jsp">科研项目</a> | <a href="product.jsp">
								成果展示</a> | <a href="mailto:zzxwill@buaa.edu.cn">联系我们</a>
						</span> 
					</td>
				</tr>
			</table>
			</center>
			</body>
			</html>