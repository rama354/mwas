<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/common/common.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/profile/profile.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/common/avataar.css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/profile.js"></script>
<title>Profile</title>
</head>
<body>
	<table id="table1">
			<tr>
				<td style="width:80%;padding:10px;">
				    <div style="height:100%">
					<table id="table2">
					  <tbody>
						<tr style="height:10%;">
							<td style="vertical-align: top">
								<%@include file="../header/header.jsp" %>
			   				</td>
			   			</tr>
						<!-- <tr style="height:20%"></tr> -->		
						<tr style="height:70%">
						  <td>
						    <div id="profile">
							  <div class="profile_1">
							  		   <div id="avataar" style="margin-left:50px;margin-top:15px">
											<%if (request.getAttribute("image")==null){%>
											<img src="${pageContext.request.contextPath}/images/empty_profile.gif">
											<%}else{%>
											<img src='<%=request.getAttribute("image")%>'>
											<%}%>
										</div>
										<table class="avataar_table">
											<tr>
												<td>
													<form method="post" action="/mywebproject/image.htm" enctype="multipart/form-data">
														<input type="file" name="image" onchange="this.form.submit();" class="imgbutton_style">
														<!--<button type="submit" name="change" id="button">Change Picture</button>  -->
													</form>
												</td>
											</tr>
										</table>
							  </div>
							  <div class="profile_2">
	   	 						<ul>
							        <li><a href="#aboutme" tabindex="1" onclick="includejsp(this);">About Me</a></li>
							        <li><a href="#education" tabindex="2" onclick="includejsp(this);">Education</a></li>
							        <li><a href="#workhistory" tabindex="3" onclick="includejsp(this);">Work History</a></li>
							        <li><a href="#hobbies" tabindex="4" onclick="includejsp(this);">Hobbies</a></li>
							        <li><a href="#contactdetails" tabindex="5" onclick="includejsp(this);">Contact Details</a></li> 
							        <li><a href="#groups" tabindex="6" onclick="includejsp(this);">Groups</a></li> 
	    						</ul>
	    						<div id="filler"></div>
	    						<div id="tab_content">
	    						</div>
	    						<div id="aboutme" class="profile_3">
	    						  <jsp:include page="aboutme.jsp"/>
	    						</div>
	    						<div id="education" class="profile_3">
	    						  <jsp:include page="education.jsp"/>
	    						</div>
	    						<div id="workhistory" class="profile_3">
	    						  <jsp:include page="workhistory.jsp"/>
	    						</div>
	    						<div id="hobbies" class="profile_3">
	    						  <jsp:include page="hobbies.jsp"/>
	    						</div>
	    						<div id="contactdetails" class="profile_3">
	    						  <jsp:include page="contactdetails.jsp"/>
	    						</div>
	    						<div id="groups" class="profile_3">
	    						  <jsp:include page="groups.jsp"/>
	    						</div>
							  </div>
							 </div>
						  </td>
						</tr>
						</tbody>
					</table>
					</div>
				</td>
				<td valign="middle"><%@include file="../menu/menu.jsp" %></td>
			</tr>
	</table>
</body>
</html>