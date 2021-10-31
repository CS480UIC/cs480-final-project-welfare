<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Medical</title>
    
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
  <h1>Update Medical</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Program ID    :<input type="text" name="program_id" value="${medial.program_id }" disabled/>
	<br/>
	
	Program Name：<input type="text" name="program_name" value="${medical.program_name }" disabled />
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="program_id" value="${medical.program_id }"/>
	Program Name：<input type="text" name="program_name" value="${form.program_name }"/>
	<span style="color: red; font-weight: 900">${errors.program_name }</span>
	<br/>
	Source	：<input type="text" name="source" value="${form.source }"/>
	<span style="color: red; font-weight: 900">${errors.source }</span>
	<br/>
	Funds	：<input type="text" name="funds" value="${form.funds }"/>
	<span style="color: red; font-weight: 900">${errors.funds }</span>
	<br/>
	<input type="submit" value="Update Medical"/>
</form>

</body>
</html>
