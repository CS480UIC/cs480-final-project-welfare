<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read MedicalFacility Output</title>
    
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
  <h1>Read MedicalFacility Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Program ID    :<input type="text" name="program_ID" value="${medicalfacility.program_ID }" disabled/>
	<br/>
	Medical Facility ID：<input type="text" name="medicalfacility_ID" value="${medicalfacility.medicalfacility_ID }" disabled/>
	<br/>
	Facility	：<input type="text" name="facility" value="${medicalfacility.facility }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
