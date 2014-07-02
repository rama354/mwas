<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*,javax.servlet.jsp.*"%>
<%@page import="java.io.PrintWriter,java.io.StringWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Error</title>
</head>
<body bgcolor="white">
	Message:
	<%=exception.getMessage()%>
	<br>
	<br> StackTrace:
	<% StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter =  new PrintWriter(stringWriter);
	  exception.printStackTrace(printWriter);
	  printWriter.close();
	  stringWriter.close();
	  %>
</body>
</html>