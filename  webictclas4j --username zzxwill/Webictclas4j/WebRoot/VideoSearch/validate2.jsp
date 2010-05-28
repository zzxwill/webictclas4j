<%@ page language="java" contentType="text/html" import="test.Test"%> 
<%@ page pageEncoding="gb2312"%>
<%@ include file="head.jsp"%>
<%
request.setCharacterEncoding("gb2312");
//response.setContentType("text/html;charset=GB2312"); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
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
		
		
		<%
	Test t=new Test();
	t.getKeywordsMain4Web2();

		 %>
	</body>
</html>
