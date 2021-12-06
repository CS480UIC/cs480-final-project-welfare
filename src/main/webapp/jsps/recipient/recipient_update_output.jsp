<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Recipient</title>
    
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
  <h1>Update Recipient</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	first_name    :<input type="text" name="first_name" value="${recipient.first_name }"disabled />
	<br/>
	last_name：<input type="text" name="last_name" value="${recipient.last_name }"disabled />
	<br/>
	birthdate：<input type="text" name="birthdate" value="${recipient.birthdate }"disabled/>
	<br/>
	ID	：<input type="text" name="ID" value="${recipient.ID }" disabled/>
	<br/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/RecipientServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="ID" value="${recipient.ID }"/>
	first_name    :<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	last_name：<input type="text" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	birthdate：<input type="text" name="birthdate" value="${form.birthdate }"/>
	<span style="color: red; font-weight: 900">${errors.birthdate }</span>
	<br/>
	<input type="submit" value="Update Recipient"/>
</form>

</body>
</html>
