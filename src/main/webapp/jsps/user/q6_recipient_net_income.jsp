<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> First and Last Names and Net Income </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Net Income</th>
	</tr>
<c:forEach items="${RecipientList}" var="recipient">
	<tr>
		<td>${recipient.first_name}</td>
		<td>${recipient.last_name}</td>
		<td>${recipient.total_net}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
