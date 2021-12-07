<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br>
    <h2>Simple Queries</h2>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/NutritionalFunds'/>" target="body">Please list all the nutritional funds over 500000 or under 250000</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/RecipientIncomes'/>" target="body">Please list all the recipient incomes between 10000 or under 30000</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/RecipientGrossIncomes'/>" target="body">Please list all the recipient ID's with total gross incomes greater 10000 and have investments over 0</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/Managers'/>" target="body">Please list all the managers' first and last names</a>&nbsp;&nbsp;
    <br>
    
    <br>
    <h2>Complex Queries</h2>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list the first and last names of the recipients with their net incomes</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list the recipients' id who are eligible for all medical programs </a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/RecipientInvestments'/>" target="body">Please list all the recipients' ID who have made money from investments</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the nutritional program names and their source of funding</a>&nbsp;&nbsp;
    <br>
    
    <br>
    <h2>Aggregate Queries</h2>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please show the average of the funds for the nutritional programs</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please find the amount of letter for the longest first and last names </a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please find the oldest year of all recipient birthdates</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all recipients' ID that have a gross income of over 50000</a>&nbsp;&nbsp;
    <br>
    
  </body>
</html>
