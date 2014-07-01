<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/profile/aboutme.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/profile.js"></script>
<title>About Me</title>
</head>
<body>
	<form action="/aboutme.htm" method="post" id="aboutme_form">
			<textarea id="aboutme_text" name="aboutme" rows="5" cols="100" readonly="readonly">
	   			I am Alive.Alive is awesome!!!!
	   		</textarea>
			<table>
			   <tr>
			    <td><button onclick="return editAboutMe();">Edit</button></td>
			    <td><button name="submit" value="save">Save</button></td>
			   </tr>
		   </table> 
	</form>	   
</body>
</html>