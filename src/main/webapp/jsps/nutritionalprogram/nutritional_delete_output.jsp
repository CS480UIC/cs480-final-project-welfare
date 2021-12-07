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
  <h1>Delete Nutritional</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/NutritionalServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="program_ID" value="${nutritional.program_ID }"/>
	program_name    :<input type="text" name="program_name" value="${nutritional.program_name }" disabled/>
	<span style="color: red; font-weight: 900">${errors.program_name }</span>
	<br/>
	program_ID：<input type="text" name="program_ID" value="${nutritional.program_ID }" disabled/>
	<span style="color: red; font-weight: 900">${errors.program_ID }</span>
	<br/>
	administrator_ID	：<input type="text" name="administrator_ID" value="${nutritional.administrator_ID }" disabled/>
	<span style="color: red; font-weight: 900">${errors.administrator_ID }</span>
	<br/>
	funds	：<input type="text" name="funds" value="${nutritional.funds }" disabled/>
	<span style="color: red; font-weight: 900">${errors.funds }</span>
	<br/>
	<input type="submit" value="Delete Entity1"/>
</form>

</body>
</html>
