<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Delete Administrator</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/AdministratorServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="ID" value="${administrator.ID }"/>
	first_name    :<input type="text" name="first_name" value="${administrator.first_name }"disabled/>
	<br/>
	last_name：<input type="text" name="last_name" value="${administrator.last_name }"disabled/>
	<br/>
	title	：<input type="text" name="title" value="${administrator.title }"disabled/>
	<br/>
	ID	：<input type="text" name="ID" value="${administrator.ID }"disabled/>
	<br/>
	<input type="submit" value="Delete Administrator"/>
</form>

</body>
</html>
