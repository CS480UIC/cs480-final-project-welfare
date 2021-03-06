<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #86D78B; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">Welfare</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp; 
			<a href="<c:url value='/jsps/initialize/initialize.jsp'/>" target="_parent">Initialize Database</a> |&nbsp; 
	
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/recipient/recipientmenu.jsp'/>" target="_parent">CRUD Recipient</a> |&nbsp; 
			<a href="<c:url value='/jsps/administrator/administratormenu.jsp'/>" target="_parent">CRUD Administrator</a> |&nbsp;
			<a href="<c:url value='/jsps/income/income_menu.jsp'/>" target="_parent">CRUD Income</a> |&nbsp; 
			<a href="<c:url value='/jsps/address/address_menu.jsp'/>" target="_parent">CRUD Address</a> |&nbsp;
			<a href="<c:url value='/jsps/nutritionalprogram/nutritionalmenu.jsp'/>" target="_parent">CRUD Nutritional</a> |&nbsp; 
			<a href="<c:url value='/jsps/housingprogram/housingmenu.jsp'/>" target="_parent">CRUD Housing</a> |&nbsp;
			<a href="<c:url value='/jsps/eligibility/menu.jsp'/>" target="_parent">CRUD Eligibility</a> |&nbsp; 
			<a href="<c:url value='/jsps/medical/menu.jsp'/>" target="_parent">CRUD Medical</a> |&nbsp;  
			<a href="<c:url value='/jsps/medicalfacility/medicalfacility_menu.jsp'/>" target="_parent">CRUD MedicalFacility</a> |&nbsp;
			<a href="<c:url value='/jsps/nutritionalsource/nutritionalsource_menu.jsp'/>" target="_parent">CRUD NutritionalSource</a> |&nbsp;
		
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

