<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="styles/styles.css" />
<script src="jquery/jquery-1.12.4.js"></script>
<script>
$(document).ready(function() {
    $('.fld input').keyup(function() {
        var empty = false;
        $('.fld input').each(function() {
            if ($(this).val().length == 0) {
                empty = true;
            }
        });
        if (empty) {
            $('.actions input').attr('disabled', 'disabled');
        } else {
            $('.actions input').removeAttr('disabled');
        }
    });
});

function validatePrice(event) {
    var key = window.event ? event.keyCode : event.which;

	if (event.keyCode == 8 || event.keyCode == 46
	 	|| event.keyCode == 37 || event.keyCode == 39) {
	    return true;
	}
	else if ( key < 48 || key > 57 ) {
	    return false;
	}
	else return true;
};
</script>
</head>
<body>
<h2>New Product Details</h2>
<form method="POST" action="add">
	<table class="crud">
	   <tr>
	      <td>Product ID</td>
	      <td><span class="fld"><input type="text" name="id" id="id" /></span></td>
	   </tr>
	   <tr>
	      <td>Product Name</td>
	      <td><span class="fld"><input type="text" name="name" id="name" /></span></td>
	   </tr>
	   <tr>
	      <td>Category</td>
	      <td><span class="fld"><select name="categoryid" id="categoryid">
	      	<c:forEach var="item" items="${categories}">
	      		<option value="${item.id}">${item.name}</option>
	      	</c:forEach>
	      </select></span></td>
	   </tr>
	   <tr>
	      <td>Price</td>
	      <td><span class="fld"><input type="text" name="price" id="price" onkeypress="return validatePrice(event)"/></span></td>
	   </tr>
	   <tr>
	      <td colspan="2">
	         <span class="actions"><input type="submit" disabled="disabled" value="Add Product"/></span>
	      </td>
	   </tr>
	</table>  
</form>
</body>
</html>