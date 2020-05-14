<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="resources/css/main.css" type="text/css"/>
<script type="text/javascript" src="resources/js/main.js"></script>
</head>
<body>

<h3>Create a new account</h3>

	<sf:form action="processRegister" method="post"
		modelAttribute="formUser">
		<sf:input path="username" placeholder="Enter a username" />
		<sf:errors path="username" />
		<br>
				<sf:input path="email" placeholder="Enter an email" />
		<sf:errors path="email" />
		<br>
		<sf:input type="password" path="password"
			placeholder="Enter a password" />
		<sf:errors path="password" />
		<input type="submit" value="Register" />
	</sf:form>

	<c:if test="${ not empty errorMessage }">
		<p>${ errorMessage }</p>
	</c:if>
</body>
</html>