<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Eligibility</title>
    
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
  <h1>Update Eligibility</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Recipient ID    :<input type="text" name="recipient_ID" value="${eligibility.recipient_ID }" disabled/>
	<br/>
	Citizenship：<input type="text" name="citizenship" value="${eligibility.citizenship }" disabled/>
	<br/>
	Residency	：<input type="text" name="residency" value="${eligibility.residency }" disabled/>
	<br/>
	Family	：<input type="text" name="family" value="${eligibility.family }" disabled/>
	<br/>
	
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/EligibilityServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="recipient_ID" value="${form.recipient_ID }"/>
				
	Recipient ID    :<input type="text" name="recipientID" value="${eligibility.recipient_ID }"/>
	<br/>
	Citizenship：<input type="text" name="citizenship" value="${form.citizenship }"/>
	<span style="color: red; font-weight: 900">${errors.citizenship }</span>
	<br/>
	Residency	：<input type="text" name="residency" value="${form.residency }"/>
	<span style="color: red; font-weight: 900">${errors.citizenship }</span>
	<br/>
	Family	：<input type="text" name="family" value="${form.family }"/>
	<span style="color: red; font-weight: 900">${errors.family }</span>
	<br/>
	<input type="submit" value="Update Eligibility"/>
</form>

</body>
</html>
