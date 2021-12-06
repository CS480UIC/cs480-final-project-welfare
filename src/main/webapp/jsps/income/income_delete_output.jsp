<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Income</title>
    
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
  <h1>Delete Income</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/IncomeServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="recipient_ID" value="${income.recipient_ID }"/>
		
		
	recipient_ID    :<input type="text" name="recipientID" value="${income.recipient_ID }" disabled/>
	<br/>
	total_gross：<input type="text" name="grossIncome" value="${income.total_gross }" disabled/>
	<br/>
	total_net	：<input type="text" name="netIncome" value="${income.total_net }" disabled/>
	<br/>
	investments	：<input type="text" name="investments" value="${income.investments }" disabled/>
	<br/>
	<input type="submit" value="Delete Income"/>
</form>

</body>
</html>
