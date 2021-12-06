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
  <h1>Update Income</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	recipient_ID    :<input type="text" name="recipientID" value="${income.recipient_ID }" disabled/>
	<br/>
	total_gross：<input type="text" name="grossIncome" value="${income.total_gross }" disabled/>
	<br/>
	total_net	：<input type="text" name="netIncome" value="${income.total_net }" disabled/>
	<br/>
	investments	：<input type="text" name="investments" value="${income.investments }" disabled/>
	<br/>
</form>
<h1>Update Income values below</h1>
<form action="<c:url value='/IncomeServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="recipient_ID" value="${form.recipient_ID }"/>
				
	recipient_ID    :<input type="text" name="recipientID" value="${income.recipient_ID }"/>
	<span style="color: red; font-weight: 900">${errors.total_gross }</span>
	<br/>
	total_gross：<input type="text" name="grossIncome" value="${form.total_gross }" />
	<span style="color: red; font-weight: 900">${errors.total_gross }</span>
	<br/>
	total_net	：<input type="text" name="netIncome" value="${form.total_net }" />
	<span style="color: red; font-weight: 900">${errors.total_net }</span>
	<br/>
	investments	：<input type="text" name="investments" value="${form.investments }" />
	<span style="color: red; font-weight: 900">${errors.investments }</span>
	<br/>
	
	
	<input type="submit" value="Update Entity1"/>
</form>

</body>
</html>
