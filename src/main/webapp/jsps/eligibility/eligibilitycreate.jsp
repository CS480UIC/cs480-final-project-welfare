<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Eligibility Create</title>
    
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
  <h1>Eligibility Create</h1>
<form action="<c:url value='/EligibilityServletCreate'/>" method="post">
	Recipient ID    :<input type="text" name="recipient_id" value="${form.recipient_id }"/>
	<span style="color: red; font-weight: 900">${errors.recipient_id }</span>
	<br/>
	Citizenship：<input type="text" name="citizenship" value="${form.citizenship }"/>
	<span style="color: red; font-weight: 900">${errors.citizienship }</span>
	<br/>
	Residency	：<input type="text" name="residency" value="${form.residency }"/>
	<span style="color: red; font-weight: 900">${errors.residency }</span>
	<br/>
	Family	：<input type="text" name="family" value="${form.family }"/>
	<span style="color: red; font-weight: 900">${errors.family }</span>
	<br/>
	<input type="submit" value="Create Eligibility"/>
</form>
  </body>
</html>
