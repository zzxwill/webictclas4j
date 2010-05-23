<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
   
	<%
	String name=request.getParameter("name");
	 out.println("zzx name==null:"+name==null);
	 out.println("2:"+(request.getParameter("name"))==null);
	 %>
  </body>
</html>
