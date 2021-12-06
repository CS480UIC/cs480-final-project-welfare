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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	first_name    :<input type="text" name="first_name" value="${administrator.first_name }"disabled/>
	<br/>
	last_name：<input type="text" name="last_name" value="${administrator.last_name }"disabled/>
	<br/>
	title	：<input type="text" name="title" value="${administrator.title }"disabled/>
	<br/>
	ID	：<input type="text" name="ID" value="${administrator.ID }"disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/AdministratorServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="ID" value="${administrator.ID }"/>
	first_name    :<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	last_name：<input type="text" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	title	：<input type="text" name="title" value="${form.title }"/>
	<span style="color: red; font-weight: 900">${errors.title }</span>
	<br/>
	ID	：<input type="text" name="ID" value="${administrator.ID }"disabled/>
	<input type="submit" value="Update Administrator"/>
</form>

</body>
</html>
