<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Hello World JSP</p>

<% out.print("Welcome to jsp");%>
<%= "expression tag" %>

<%! int x = 10; %>
<%= x %>

<%! 
	int cube(int n){
	return n*n*n;	
	}
	%>
}

<%= cube(3) %>
<br>
<form action="welcome.jsp" method="post">
	Name:<input type="text" name="uname">
	<input type="submit" value="Submit">
</form>

</body>
</html>