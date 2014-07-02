<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/themes/menu/menu.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/datatable.js"></script>
<title>Menu</title>
</head>
<body>
    <div id="menu">
	<ul class="menulist">
		 <li>
			   	  <form method="get" action="/mywebproject/home.htm">
			   	    <button class="menubutton" id="homeicon" title="Home">
			   	    	<img src="${pageContext.request.contextPath}/images/homealt_green_48.png"/>
			   	    </button>
			      	<!--<button type="submit" name="submit" value="home">Home</button> -->
			        <input type="hidden" name="submit" value="home"/>
			   	 </form>
		</li>
		<li>
			<div id="menuitem">
				<form method="get" action="/mywebproject/profile.htm" onsubmit="return singleSelect();">
				   <button id="profileicon" title="Profile">
					 <img src="${pageContext.request.contextPath}/images/customer_male_light_48.png"/>
					</button>
				  <input type="hidden" name="submit" value="profile"/>
				</form>
			</div>	
		</li>
		<li>
			<div>
				<form method="get" action="/mywebproject/gallery.htm" onsubmit="return singleSelect();">
					<button id="galleryicon" title="Gallery">
					  <img src="${pageContext.request.contextPath}/images/galleryalt_green_48.png"/>
					</button>
					<input type="hidden" name="submit" value="gallery"/>
				</form>
			</div>
		</li>
		<li><div>
				<form method="get" action="/mywebproject/awards.htm" onsubmit="return singleSelect();">
					<button id="awards" title="Awards">
					  <img src="${pageContext.request.contextPath}/images/award_48.png"/>
					</button>
					<input type="hidden" name="submit" value="awards"/>
				</form>
			</div>
		</li>
		<li>
			<div>
				<form method="get" action="/mywebproject/journal.htm" onsubmit="return singleSelect();">
					<button id="journal" title="Journal">
					  <img src="${pageContext.request.contextPath}/images/journal1-icon_48.png"/>
					</button>
					<input type="hidden" name="submit" value="journal"/>
				</form>
			</div>
		</li>
		<li>
			<div>
				<form method="get" action="/mywebproject/contacts.htm" onsubmit="return singleSelect();">
					<button id="contacts" title="Contacts">
					 <img src="${pageContext.request.contextPath}/images/contacts_green_48.png"/>
					 </button>
					 <input type="hidden" name="submit" value="contacts"/>
				</form>
			</div>
		</li>
		<li>
			<div>
			   <form method="get" action="/mywebproject/settings.htm">
			    <button id="settings" title="Settings">
			   		 <img src="${pageContext.request.contextPath}/images/settings_48.png"/>
				 </button>
				  <input type="hidden" name="submit" value="settings"/>
			   </form>
			</div>
		</li>
	 </ul>
	</div>
</body>
</html>