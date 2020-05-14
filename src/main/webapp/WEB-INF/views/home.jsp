<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<%@ page import="java.time.LocalTime"%>

	<%!public String getGreeting() {
		if (LocalTime.now().isBefore(LocalTime.NOON)) {
			return "Good morning";
		} else {
			return "Good afternoon";
		}
	}%>

	<c:choose>
		<c:when test="${ not empty sessionScope.activeUser }">
			<p>Welcome ${ sessionScope.activeUser.username }!</p>
		</c:when>
		<c:otherwise>
			<p>Welcome guest!</p>
		</c:otherwise>
	</c:choose>

	<a href="getBooks">View Books</a>

</body>
</html>