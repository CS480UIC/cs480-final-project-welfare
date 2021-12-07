<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Recipient ID and their Gross Incomes </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Recipient ID</th>
		<th>Gross Income</th>
	</tr>
<c:forEach items="${IncomeList}" var="income">
	<tr>
		<td>${income.recipient_ID}</td>
		<td>${income.total_gross}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
