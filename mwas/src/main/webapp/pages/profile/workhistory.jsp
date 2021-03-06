<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mwas.entities.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>WorkHistory</title>
</head>
<body>
 <table id="workhistory">
	 <c:if test="${not empty wharray}">
   	   <c:forEach items="${wharray}" var="workhistory">
   		 <tr> 
   		 	<td><c:out value="${workhistory.company}"/></td>
   		 	<td><c:out value="${workhistory.division}"/></td> 	
   		 	<td><c:out value="${workhistory.destination}"/></td>
   		 	<td><c:out value="${workhistory.startDate}"/></td>
   		 	<td><c:out value="${workhistory.endDate}" /></td>
   		 </tr>
   		  <c:forEach items="${workhistory.projects}" var="project">
   		  	<tr>
   		 		<td><c:out value="${project}"/></td>
   			</tr>
   		  </c:forEach>
   		  <c:forEach items="${workhistory.awards}" var="award">
   		   	<tr>
   		 		<td><c:out value="${award}"/></td>
   		  	</tr>
   		  </c:forEach>
    	  <tr><td><c:out value="${workhistory.remarks}" /></td></tr>
   	    </c:forEach>
   	   </c:if>
   	</table>
</body>
</html>