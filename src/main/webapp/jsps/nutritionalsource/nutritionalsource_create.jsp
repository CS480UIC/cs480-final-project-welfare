<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>NutritionalSource Create</title>
    
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
  <h1>NutritionalSource Create</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	Program ID    :<input type="text" name="program_ID" value="${form.program_ID }"/>
	<span style="color: red; font-weight: 900">${errors.program_ID }</span>
	<br/>
	NutritionalSource ID：<input type="text" name="nutritionalsource_ID" value="${form.nutritionalsource_ID }"/>
	<span style="color: red; font-weight: 900">${errors.nutritionalsource_ID }</span>
	<br/>
	Source	：<input type="text" name="source" value="${form.source }"/>
	<span style="color: red; font-weight: 900">${errors.source }</span>
	<br/>
	<input type="submit" value="Create NutritionalSource"/>
</form>
  </body>
</html>