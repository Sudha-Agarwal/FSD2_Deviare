<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${user != null }">
		<form action="update" method="post">
	</c:if>
	
	<c:if test="${user == null }">
		<form action="insert" method="post">
	</c:if>
	
	<h2>
		<c:if test = "${user!= null}">Edit User</c:if>
		<c:if test = "${user== null}">New User</c:if>
	</h2>
	
	<c:if test="${user != null }">
		<input type="text" name="id" value="<c:out value='${user.id}' />" />	
	</c:if>
	
	UserName: <input type="text" value="<c:out value='${user.name}' />"  name="name"/>
	Email: <input type="text" value="<c:out value='${user.email}' />"  name="email"/>
	Country: <input type="text" value="<c:out value='${user.country}' />"  name="country"/>
	
	<input type="submit" value="Save">



</body>
</html>