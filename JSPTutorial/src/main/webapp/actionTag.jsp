<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- this is HTML comment -->
	<%-- This is JSP --%>
	
	<!-- Forward without parameters -->
	<%-- <jsp:forward page="actionTagSecond.jsp"></jsp:forward> --%>
	
	<!-- Forward with parameters -->
	<%-- <jsp:forward page="actionTagSecond.jsp">
	<jsp:param name="name" value="ABC">	
	</jsp:forward> --%>	
	
	<jsp:include page="index.jsp"></jsp:include>

</body>
</html>