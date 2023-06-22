<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="String" value="Welcome to Simplilearn" />

<c:if test="${fn:contains(String, 'Simplilearn')}">
	<p>Found Simplilearn String</p>
</c:if>

<c:if test="${fn:containsIgnoreCase(String, 'SIMPLILEARN') }">
	<p>Found Simplilearn String</p>
</c:if>

<c:set var="message" value="Hello World" />
<p>Upper Case: ${fn:toUpperCase(message) }</p>
<p>Lower Case: ${fn:toLowerCase(message) }</p>
<p>Substring: ${fn:substring(message, 0,5) }</p>
<p>Length: ${fn:length(message) }</p>
</body>
</html>