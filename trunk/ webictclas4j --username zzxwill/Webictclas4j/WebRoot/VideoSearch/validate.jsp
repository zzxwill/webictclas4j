<%@ page language="java" contentType="text/html" %> 
<%@ page pageEncoding="gb2312"%>
<%@ include file="head.jsp"%>
<%
request.setCharacterEncoding("gb2312");
response.setContentType("text/html;charset=GB2312"); 
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
			
			//ResultSet rs;
//bytep[] bytes = rs.getBytes();
//String str = new String(bytes, "gb2312");
			
			out.println("inputText:" + inputText);
			out.println("inputText == null:"+inputText == null);

			if (inputText.equals("")) {
				response.sendRedirect("/Webictclas4j/VideoSearch/error.jsp");
				return;

			}
		
		%>
		
		<!-- jsp:useBean id="validatebean" scope="page" class="javabean.WordSegment"-->
		<jsp:useBean id="validatebean" scope="page" class="keywords.GetKeywords">
		<!-- para是index.jsp中，输入框中的变量 -->
		<jsp:setProperty name="validatebean" property="input" param="inputText" />
		</jsp:useBean>
		
		<!-- 调getKeywords类 -->
		<%
		out.print(inputText);
		validatebean.getKeywordsMain4Web();
//	validatebean.wordseg();

		 %>
	</body>
</html>
