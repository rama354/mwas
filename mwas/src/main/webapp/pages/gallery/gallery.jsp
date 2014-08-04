<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>FM Gallery</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/common/common.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/boostrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/gallery/gallery.css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/boostrap.min.js"></script>
<!--<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/gallery.js"></script> -->
</head>
<body>
	<!-- <div class="gallery"> -->
		<table id="table1">
			<tr>
				<td style="width:80%;padding:10px;">
					<table id="table2">
						<tr>
							<td>
							<div id="slides">
							 <div>
							   <a tabindex="1" href="#image1" class="thumbnail">
								<img id="image1" src="${pageContext.request.contextPath}/images/tiger.jpg"/>
							   </a>	
							 </div>
							  <div>
							   <a tabindex="2" href="#image2" class="thumbnail">
								<img id="image2" src="${pageContext.request.contextPath}/images/petronas.jpg"/>
							   </a>
							  </div>
							  <div>
							   <a tabindex="3" href="#image3" class="thumbnail">	
							   	<img id="image3" src="${pageContext.request.contextPath}/images/phuket.jpg"/>
							   </a>
							   </div>
							   <div>	
							   <a tabindex="4" href="#image4" class="thumbnail">	
								<img id="image4" src="${pageContext.request.contextPath}/images/nethra.jpg"/>						
								</a>
								</div>
								<div>
								<a tabindex="5" href="#image5" class="thumbnail">	
								 <img id="image5" src="${pageContext.request.contextPath}/images/himalaya.jpg"/>
								</a>
								</div>
								<div>
								<a tabindex="6" href="#image6" class="thumbnail">
									<img id="image6" src="${pageContext.request.contextPath}/images/louvre.jpg"/>
								</a>
								</div>
							 </div>
							<div id="imagemodal">
							<!--    <img src="#"></img> --> 
							</div> 
							</td>
						</tr>
						<tr>
							<td>
								<div id="slider">
								</div>
							</td>
						</tr>
					</table>
				</td>
				<td valign="middle"><%@include file="../menu/menu.jsp" %></td>
			</tr>
		</table>
	<!-- </div> -->
</body>
</html>
