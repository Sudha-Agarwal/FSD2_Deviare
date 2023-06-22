<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="x" value="11" />
<c:out value="${x}" />
<br>
<c:out value="${x%2 eq 0? 'even':'odd' }"/>

<c:forEach var="i" begin="1" end ="5">
<p>Value of i: <c:out value="${i}" /></p>
</c:forEach>

<c:if test = "${x == 10 }">
<p>X is equal to 11</p>
</c:if>

<c:choose>
	<c:when test="${x <10 }">
		<p>X is less than 10
	</c:when>
	<c:when test="${x == 10 }">
		<p>X is equal to 10
	</c:when>
	<c:otherwise>
		<p>X is greater than 10
	</c:otherwise>
</c:choose>

<c:catch var="catchTheException">
<% int x = 2/0; %>
</c:catch>

<c:if test="${catchTheException!= null}">
	<p>Exception caught: ${catchTheException.message }</p>
</c:if>

<%-- <c:redirect url = "http://google.co.in"></c:redirect> --%>



<c:url value = "/index.jsp" var="completeURL">
	<c:param name="user" value="Sudha"></c:param>
</c:url>

${completeURL }

<c:set var="y" value="10" />
<p>Before removal: <c:out value="${y}" /></p>
<c:remove var="y" />
<p>After removal: <c:out value="${y}" /></p>

</body>
</html>