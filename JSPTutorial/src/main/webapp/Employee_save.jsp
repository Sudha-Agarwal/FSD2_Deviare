<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="emp" class="bean.Employee" scope="request">
	<%-- 
		<jsp:setproperty property="id" name="emp" value="1"/>
	<jsp:setproperty property="firstName" name="emp" value="Sudha"/>	
	--%>
	
	<jsp:setProperty property="*" name="emp" />
	</jsp:useBean> 
	
	<p>Employee Details</p>
	<p>EmpId: <jsp:getProperty property="id" name="emp" /></p>
	<p>First Name: <jsp:getProperty property="firstName" name="emp" /></p>
	<p>Last Name: <jsp:getProperty property="lastName" name="emp" /></p>
	
	
	
	
	
	
	
</body>
</html>