<%@ page language="java" contentType="text/html" %> 
<%@ page pageEncoding="gb2312"%>
<%@ include file="head.jsp"%>
<%
request.setCharacterEncoding("gb2312");
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
			String inputText = request.getParameter("inputText");
			out.println("inputText:" + inputText);
			out.println("inputText == null:"+inputText == null);

			if (inputText.equals("")) {
				response.sendRedirect("/Webictclas4j/VideoSearch/error.jsp");
				return;

			}
			else{
			out.print(inputText);
			}
		%>
		
		<jsp:useBean id="validatebean" scope="page" class="javabean.WordSegment">
		<jsp:setProperty name="validatebean" property="inputText" />
		</jsp:useBean>
		
		<!-- 调用GetKeywords类 -->
		<%
		validatebean.wordseg();
		 %>
	</body>
</html>
