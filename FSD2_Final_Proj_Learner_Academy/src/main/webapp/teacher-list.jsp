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
	<h3>List of teachers</h3>
	<a href="TeacherServlet?action=list">List Teachers</a>&nbsp;&nbsp;
	<a href="TeacherServlet?action=new">Add New Teacher </a>
	
	<table>
	<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Actions</th>
					</tr>
				</thead>
	<tbody>
		<c:forEach var="teacher" items="${listTeacher}">
		<tr>
			<td><c:out value="${teacher.teacherId}" /></td>
			<td><c:out value="${teacher.teacherName}" /></td>
			<td><a href="edit?id=<c:out value='${teacher.id}' />">Edit</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="delete?id=<c:out value='${teacher.id}' />">Delete</a></td>
			</tr>	
	</c:forEach>	
	</tbody>	
	</table>	
</body>
</html>