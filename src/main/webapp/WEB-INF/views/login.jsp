<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
body 
{
	background-color:blanchedalmond;
}

</style>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<div class="container">
<br><br><br><br><br><br><br>
<h1>Sign Up</h1>

 <div class="form-group" style="margin: 0 auto;">
 
	<sf:form  action="processLogin" method="post"
		modelAttribute="activeUser">
		
	
		 <br>
		<sf:input path="username" class= "form-group" placeholder="Enter a username" />
		<sf:errors path="username" />

		
		<br>
		<sf:input type="password" class = "form-group" path="password"
			placeholder="Enter a password" />
		<sf:errors path="password" />
		<br>
		<input type="submit" class="btn btn-primary" value="Login" />
		</sf:form>
		</div>

	<c:if test="${ not empty errorMessage }">
		<p>${ errorMessage }</p>
	</c:if>
</div>

</body>
</html>
