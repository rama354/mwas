<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true" %>
<%@page
	import="org.apache.poi.ss.usermodel.*,java.io.*,java.util.ArrayList,com.mwas.authentication.SPACESessionImpl,com.mwas.entities.Profile"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/themes/common/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/themes/datatable.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/themes/tablestyle.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/themes/common/avataar.css" />
<title>FutureMakers</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/datatable.js"></script>
</head>
<body>

	<!-- <div id="header"> -->
	<!-- use jstl below ????????-->
	<c:if test="${userSession.homepagehit == 1}">
			<a id="session_popup" href="#usersession"></a>
			<div id="usersession" class="sessionModal">
				<div>
				<a href="#close" title="Close" class="close">X</a>
				<h2 align="center">HAL-9000</h2>
				<p>Welcome Root. I have missed you.</p>
				<p>You have no new messages.Would you like to edit your profile?</p>
				</div>
			</div>
	</c:if>
	<table id="table1">
		<tbody>
		    <tr>
			<td style="width:80%;padding:10px;">
			<div style="height:100%;">
			<table id="table2">
				<tbody>
				<tr style="height:10%;">
				<td style="vertical-align: top">
					<%@include file="./header/header.jsp" %>
			   	</td>
				</tr>
			    <tr style="height:10%;">
				<td style="vertical-align: middle">
				<div id="uploadgrid">
						<form class="form-inline" method="post" action="./datagrid.htm" onsubmit="return verifyextn( );" enctype="multipart/form-data">
							<div class="form-group">
								<label>FutureMaker: </label><input type="text" name="name" placeholder="Enter UserName">		
							</div>
							<div class="form-group">					
								<label class="sr-only" for="datafile">File location:</label><input type="file" id="datafile" name="datafile">
							</div>
							<button type="submit" value="upload">UpLoad</button>
						</form>
				</div>
			   </td>
			   </tr>
				<tr style="height:40%;">
				<td style="vertical-align: top">
				 <!-- <div id="headergrid">
				    <table id="employeeheader">
				  			<thead>
								<tr>
								    <th style="padding: 5px;"></th>
									<th align="center" style="padding: 10px;">FirstName</th>
									<th align="center" style="padding: 20px;">HRID</th>
									<th align="center" style="padding: 20px;">LastName</th>
									<th align="center" style="padding: 20px;">UserName</th>
									<th align="center" style="padding-left: 115px;padding-right: 115px;">Profile Picture</th>
								</tr>
						 </thead>
					</table>
				  </div> -->
				  <div id="datagrid" class="table-responsive">
					<!-- <table class="employeedata" style="table-layout: fixed;"> -->
					   <table class="table table-striped header-fixed">
					   		<thead>
								<tr>
								    <th style="padding: 5px;"></th>
									<th style="text-align:center">FirstName</th>
									<th style="text-align:center">HRID</th>
									<th style="text-align:center">LastName</th>
									<th style="text-align:center">UserName</th>
									<th style="text-align:center">Profile Picture</th>
								</tr>
						 	</thead>
							<tbody>
							<% 
							    if (session.getAttribute("Employees")!= null)
							    {
							       ArrayList<?> employees = (ArrayList<?>)session.getAttribute("Employees");
								   for (int i=0;i<employees.size();i++) 
								   { 
								     if (employees.get(i) instanceof Profile){
								     		Profile employee = (Profile)employees.get(i);
		      				%>
								<tr>
								    <td>
								      <!-- <div class="checkbox"> -->
								       <input type="checkbox" name="profileSelect"/>
								       <!-- </div>-->
								    </td>
									<td align="center">
									 <!-- <div style="width: 79px;"> -->
									 <%=employee.getFirstName()%>
									 <!-- </div> -->
									 </td>
									<td align="center">
									<!-- <div style="width: 52px;"> -->
									<%=employee.getSPACE_ID()%>
									<!-- </div> -->
									</td>
									<td align="center">
									<!-- <div style="width: 78px;"> -->
									<%=employee.getLastName()%>
									<!-- </div> -->
									</td>
									<td align="center">
									<!-- <div style="width: 52px;"> -->
									<%=employee.getUserName()%>
									<!-- </div> -->
									</td>
									<td align="center">
										<div id="avataar">
											<%if (request.getAttribute("image")==null){%>
											 	<img src="${pageContext.request.contextPath}/images/user.png">
											<%}else{%>
											<img src='<%=request.getAttribute("image")%>'>
											<%}%>
										</div>
									</td> 
								</tr>
								<% } } }%>
							</tbody>
						</table>
					</div>
				</td>
			</tr>
		
			<tr style="height:15%;">
				<td style="vertical-align: bottom">
				  <%@include file="./footer/footer.jsp"%>
				</td>
			</tr>
			</tbody>
			</table>
			</div>
				<td style="vertical-align: middle">
					<%@include file="./menu/menu.jsp"%>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>