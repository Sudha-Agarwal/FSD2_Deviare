<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% 
String uname = request.getParameter("uname");
out.print("Welcome " + uname);

response.sendRedirect("http://www.google.co.in");

%>
</body>
</html>