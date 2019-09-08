<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>My View</title>
</head>
<body>
	<h1>My View</h1>
	<p>Message: <b>${msg}</b></p>
	<hr>
	<p>Page generated at <%= new java.util.Date() %></p>
	<a href="productsnotmvc">Product List Not MVC</a><br>
	<a href="products/1">Product List MVC</a><br>
	<a href="new">Add a Product</a>
</body>
</html>