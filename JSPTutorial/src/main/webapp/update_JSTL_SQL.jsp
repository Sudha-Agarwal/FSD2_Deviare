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
	
	<c:set var="id" value="${param.id}" />
	<c:set var="first_name" value="${param.first_name}" />
	<c:set var="last_name" value="${param.last_name}" />
	
	
<sql:update dataSource="${db}" var="rs">
update employee set first_name = ?, last_name = ? where id = ?

<sql:param value="${first_name}" />
<sql:param value="${last_name}" />
<sql:param value="${id}" />
</sql:update>
<%= "Record Updated" %>

<jsp:include page ="JSTL_SQL.jsp" />

</body>
</html>