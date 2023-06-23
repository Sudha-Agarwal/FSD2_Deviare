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
	<h3>List of Users</h3>
	<a href="<%=request.getContextPath()%>/list">Users</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/new">Add New User </a>
	
	<table>
	<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Country</th>
						<th>Actions</th>
					</tr>
				</thead>
	<tbody>
		<c:forEach var="user" items="${listUser}">
		<tr>
			<td><c:out value="${user.id}" /></td>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.country}" /></td>
			<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
			</tr>	
	</c:forEach>	
	</tbody>	
	</table>	
</body>
</html>