<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Address</title>
    
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
  <h1>Delete Address</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/AddressServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="recipient_ID" value="${address.recipient_ID }"/>
	recipient_ID    :<input type="text" name="recipientID" value="${address.recipient_ID }" disabled/>
	<br/>
	city    ：<input type="text" name="city" value="${address.city }" disabled/>
	<br/>
	state	：<input type="text" name="state" value="${address.state }" disabled/>
	<br/>
	street	：<input type="text" name="street" value="${address.street }" disabled/>
	<br/>
	<input type="submit" value="Delete Address"/>
</form>

</body>
</html>
