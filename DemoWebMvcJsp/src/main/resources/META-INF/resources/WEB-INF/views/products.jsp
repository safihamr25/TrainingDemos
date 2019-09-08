<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="/styles/styles.css" />
</head>
<body>
<div class="content">
<h2>Products in the Northwind Database <a href="/">Home</a></h2>
<table>
	<tr>
		<th>ID</th><th>Name</th><th>Category</th><th>Price</th>
	</tr>
	<c:forEach var="item" items="${products}">
	<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.category}</td>
		<td>${item.price}</td>
	</tr>
	</c:forEach>
</table>
</div>
<p>
<c:forEach var="page" items="${pages}">
	<a href="/products/${page}" >${page}&nbsp;</a>
</c:forEach>
</p>
</body>
</html>