<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP Config Object Example</h2>
	
	<p>Servlet Configuration:</p>
	<ul>
		<li>Servlet Name: <%= config.getServletName() %>
		<li>Init Parameter 1: <%= config.getInitParameter("param1") %>
		<li>Init Parameter 2: <%= config.getInitParameter("param2") %>
	</ul>
	
	<h2>JSP Application Object Example</h2>
	
	<p>DataBase Configuration:</p>
	<ul>
		<li>Driver: <%= application.getInitParameter("dbDriver") %></li>
		<li>URL: <%= application.getInitParameter("dbUrl") %></li>		
	</ul>
	
	<% session.setAttribute("user", "Sudha"); %>
	
	<a href="second.jsp">Second jsp page</a>

</body>
</html>