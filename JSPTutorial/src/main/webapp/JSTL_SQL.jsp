<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" 
	url="jdbc:mysql://localhost/simplilearn" user="root" password="root"/>
	
<sql:query dataSource="${db}" var="rs">
select * from employee;
</sql:query>

<table width="100%" border="1">
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Edit</th></tr>

<c:forEach var="data" items="${rs.rows}">
<tr><td><c:out value="${data.id }" /></td>
<td><c:out value="${data.first_name}" /></td>
<td><c:out value="${data.last_name }" /></td>
<td><a href="edit_JSTL_SQL.jsp?id=${data.id}">Edit</a>
</tr>
</c:forEach>
</table>
</body>
</html>