<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/themes/header/header.css" />
<title>Header</title>
</head>
<body>
	<div id="header">
	   <table>
	  	<tbody>
	  		<tr>
	  		  <td>
	  		   <div class="icon">
	  		     <a class="mailicon" href="email" title="Email">
	  		     <div class="shine"></div>
	  		     <img src="${pageContext.request.contextPath}/images/email_32.png"/>     
	  		    </a>
	  		   </div>
	  		  </td>
	  		  <td>
	  		   <div class="icon">
	  		     <a class="chaticon" href="chat" title="Chat">
	  		     <div class="shine"></div>
	  		     <img src="${pageContext.request.contextPath}/images/chat_32.png"/>     
	  		    </a>
	  		   </div>
	  		  </td>
	  		  <td style="width:70%">
	  		  </td>
	  		  <td>
	  		   <div class="icon">
	  		     <a class="helpicon" href="help" title="Help">
	  		     <div class="shine"></div>
	  		     <img src="${pageContext.request.contextPath}/images/help_32.png"/>     
	  		    </a>
	  		   </div>
	  		  </td>
	  		  <td>
	  		   <div class="icon">
	  		    <form id="signoutform" method="post" action="/mywebproject/home.htm">
	  		    	<a class="signouticon" href="javascript: document.getElementById('signoutform').submit();" title="Signout"> 
	  		     	<!-- <div class="shine"></div> -->
	  		     	   	<img src="${pageContext.request.contextPath}/images/log_out_32.png"/>     
	  		    	</a>
	  		    	<input type="hidden" name="submit" value="signout"/>
	  		    </form>
	  		   </div>
	  		  </td>
	  		  <td>
	  		   <div class="icon">
	  		    <form id="aboutmeform" method="get" action="/mywebproject/home.htm">
	  		    	<a class="aboutmeicon" href="javascript: document.getElementById(this.form).submit();" title="About Me"> 
	  		     	<!-- <div class="shine"></div> -->
	  		     	   	<img src="${pageContext.request.contextPath}/images/aboutme_32.png"/>     
	  		    	</a>
	  		    	<input type="hidden" name="submit" value="aboutme"/>
	  		    </form>
	  		   </div>
	  		  </td>
	  	    </tr> 
	  	</tbody>
	  </table>
	</div>
</body>
</html>