<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete nutritionalsource</title>
    
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
  <h1>Delete nutritionalsource</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/NutritionalSourceServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="program_ID" value="${nutritionalsource.program_ID }"/>
	program_ID    :<input type="text" name="program_ID)" value="${nutritionalsource.program_ID }" disabled/>
	<br/>
	
	nutritionalsource_ID：<input type="text" name="nutritionalsource_ID" value="${nutritionalsource.nutritionalsource_ID }" disabled/>
	<br/>
	source	：<input type="text" name="text" value="${nutritionalsource.source }" disabled/>
	<br/>
	<input type="submit" value="Delete nutritionalsource"/>
</form>

</body>
</html>
