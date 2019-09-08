<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.example.demo.dao.*,com.example.demo.business.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<h2>Product List</h2>
<% 
	MySQLJDBC data = new MySQLJDBC();
	List<Product> products = data.listProducts();
	for(Product p: products){
		out.println(p + "<br>");
	}
%>
</body>
</html>