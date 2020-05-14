<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>Log in</h3>

	<div id="container">
		<div class="logo">
			<a href="#"><img src="logo.png" alt="" /></a>
		</div>
		<div id="box">
			<form action="dologin.jsp" method="post">
			<p class="main">
				<label>username: </label>
				<input name="username" value="" /> 
				<br>
				<label>password: </label>
				<input type="password" name="password" value="">	
			</p>
			<p class="space">
				<input type="submit" value="login" class="login" style="cursor: pointer;"/>
			</p>
			</form>
		</div>
	</div>
</body>
</html>