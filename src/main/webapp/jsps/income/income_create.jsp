<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Income Create</title>
    
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
  <h1>Create a Income</h1>
<form action="<c:url value='/IncomeServletCreate'/>" method="post">
	recipient_ID    :<input type="text" name="recipientID" value="${form.recipientID }"/>
	<span style="color: red; font-weight: 900">${errors.recipientID }</span>
	<br/>
	total_gross：<input type="text" name="grossIncome" value="${form.grossIncome }"/>
	<span style="color: red; font-weight: 900">${errors.grossIncome }</span>
	<br/>
	total_net	：<input type="text" name="netIncome" value="${form.netIncome }"/>
	<span style="color: red; font-weight: 900">${errors.netIncome }</span>
	<br/>
	investments	：<input type="text" name="investments" value="${form.investments }"/>
	<span style="color: red; font-weight: 900">${errors.investments }</span>
	<br/>
	<input type="submit" value="Create Income"/>
</form>
  </body>
</html>
