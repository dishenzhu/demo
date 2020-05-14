<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
<h3>All Products</h3>

	<c:forEach items="${ sessionScope.allBooks }" var="book">
		<p>Name: ${ product.name }</p>
		<p>Price: $${ product.price }</p>
	</c:forEach>
</body>
</html>