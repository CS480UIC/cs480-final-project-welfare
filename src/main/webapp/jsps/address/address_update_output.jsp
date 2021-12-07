<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Address</title>
    
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
  <h1>Update Address</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	recipient_ID    :<input type="text" name="recipientID" value="${address.recipient_ID }" disabled/>
	<br/>
	city    ：<input type="text" name="city" value="${address.city }" disabled/>
	<br/>
	state	：<input type="text" name="state" value="${address.state }" disabled/>
	<br/>
	street	：<input type="text" name="street" value="${address.street }" disabled/>
	<br/>
</form>
<h1>Update Address values below</h1>
<form action="<c:url value='/AddressServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="recipient_ID" value="${form.recipient_ID }"/>
	
	recipient_ID    :<input type="text" name="recipientID" value="${address.recipient_ID }" />
	<span style="color: red; font-weight: 900">${errors.recipient_ID }</span>
	<br/>
	city    ：<input type="text" name="city" value="${form.city }" />
	<span style="color: red; font-weight: 900">${errors.city }</span>
	<br/>
	state	：<input type="text" name="state" value="${form.state }" />
	<span style="color: red; font-weight: 900">${errors.state }</span>
	<br/>
	street	：<input type="text" name="street" value="${form.street }" />
	<span style="color: red; font-weight: 900">${errors.street }</span>
	<br/>
	<input type="submit" value="Update Address"/>
</form>

</body>
</html>
