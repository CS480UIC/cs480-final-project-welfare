<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Administrator Create</title>
    
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
  <h1>Create an Administrator</h1>
<form action="<c:url value='/RecipientServletCreate'/>" method="post">
	first_name    :<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	last_name：<input type="text" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	title	：<input type="text" name="title" value="${form.title }"/>
	<span style="color: red; font-weight: 900">${errors.title }</span>
	<br/>
	ID	：<input type="text" name="ID" value="${form.ID }"/>
	<span style="color: red; font-weight: 900">${errors.ID }</span>
	<br/>
	<input type="submit" value="Create Administrator"/>
</form>
  </body>
</html>
