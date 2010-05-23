<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ include file="head.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

	</head>

	<body>

		zzx Error!
		
		<%
		String str;
	%>

		<%
			String inputText = request.getParameter("/Webictclas4j/ViinputText");
			out.println("inputText:" + inputText);

			if (inputText == null) {
				response.sendRedirect("error.jsp");
				return;

			}
		%>
	</body>
</html>
