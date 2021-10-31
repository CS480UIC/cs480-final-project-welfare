<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Address Create</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Create a Address</h1>
<form action="<c:url value='/RecipientServletCreate'/>" method="post">
	recipient_ID    :<input type="text" name="recipientID" value="${form.recipientID }"/>
	<span style="color: red; font-weight: 900">${errors.recipientID }</span>
	<br/>
	city：<input type="text" name="city" value="${form.city }"/>
	<span style="color: red; font-weight: 900">${errors.city }</span>
	<br/>
	state	：<input type="text" name="state" value="${form.state }"/>
	<span style="color: red; font-weight: 900">${errors.state }</span>
	<br/>
	street	：<input type="text" name="street" value="${form.street }"/>
	<span style="color: red; font-weight: 900">${errors.street }</span>
	<br/>
	<input type="submit" value="Create Address"/>
</form>
  </body>
</html>
