<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mwas.entities.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Education</title>
</head>
<body>
	<table id="education">
	  <c:if test="${not empty earray}">
   	  <c:forEach items="${earray}" var="education">
   		 <tr> 
   		 	<td><c:out value="${education.university}"/></td>
   		 	<td><c:out value="${education.college}"/></td> 	
   		 	<td><c:out value="${education.startDate}"/></td>
   		 	<td><c:out value="${education.endDate}"/></td>
   		 </tr>
   		 <tr>
   		 	<td><c:out value="${education.degree}"/></td>
   		 	<td><c:out value="${education.major}"/></td>
   		 	<td><c:out value="${education.percentile}"/></td>
   		 </tr>
   		 <tr><td><c:out value="${education.remarks}"/></td></tr>
   	  </c:forEach>
   	  </c:if>
   	</table>
</body>
</html>