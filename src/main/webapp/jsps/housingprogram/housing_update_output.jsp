<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Housing</title>
    
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
  <h1>Update Housing</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	program_name    :<input type="text" name="program_name" value="${housing.program_name }" disabled/>
	<br/>
	program_ID：<input type="text" name="program_ID" value="${housing.program_ID }" disabled/>
	<br/>
	administrator_ID：<input type="text" name="administrator_ID" value="${housing.administrator_ID }" disabled/>
	<br/>
	housing_size	：<input type="text" name="housing_size" value="${housing.housing_size }" disabled/>
	<br/>
	funds	：<input type="text" name="funds" value="${housing.funds }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/HousingServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="program_ID" value="${form.program_ID }"/>
	program_name    :<input type="text" name="program_name" value="${form.program_name }"/>
	<span style="color: red; font-weight: 900">${errors.program_name }</span>
	<br/>
	program_ID：<input type="text" name="programID" value="${housing.program_ID }"/>
	<span style="color: red; font-weight: 900">${errors.program_ID }</span>
	<br/>
	administrator_ID：<input type="text" name="administrator_ID" value="${form.administrator_ID }"/>
	<span style="color: red; font-weight: 900">${errors.administrator_ID }</span>
	<br/>
	housing_size	：<input type="text" name="housing_size" value="${form.housing_size }"/>
	<span style="color: red; font-weight: 900">${errors.housing_size }</span>
	<br/>
	funds	：<input type="text" name="funds" value="${form.funds }"/>
	<span style="color: red; font-weight: 900">${errors.funds }</span>
	<br/>
	<input type="submit" value="Update Housing"/>
</form>

</body>
</html>
