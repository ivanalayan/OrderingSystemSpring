<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome ${account.firstName} ${account.lastName}</title>
</head>
<body>
	<c:if test="${not empty account}">
		<h3>Welcome ${account.firstName} ${account.lastName}</h3>
		<a href="logout">Logout</a>
	</c:if>

	<h3>Cart List</h3>
	<table border="1">
		<tr>
			<th>Product Name</th>
			<th>Qty ordered</th>
			<th>Total Price</th>
			<th>Action</th>
			<c:forEach items="${cartItems}" var="cartItem">
				<form method="POST" action="removeToCart">
					<input type="hidden" name="orderLineId" value="${cartItem.id}">
					<tr>
						<td>${cartItem.product.name}</td>
						<td>${cartItem.qty}</td>
						<td>${cartItem.product.price*cartItem.qty}</td>
						<td><input type="submit" value="Remove to Cart" /></td>
					</tr>
				</form>
			</c:forEach>
		</tr>
		<form action="checkOut" method="POST">
		<tr>
			<input type="Submit" value="Check Out" />
		</tr>
		</form>
	</table>

	<h3>Food List</h3>
	<table border="1">
		<tr>
			<th>Product Name</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Quantity</th>
			<th>Action</th>
			<c:forEach items="${foods}" var="food">
				<tr>
					<form method="POST" action="addToCart">
						<input type="hidden" name="productId" value="${food.id}" />
						<td>${food.name}</td>
						<td>${food.price}</td>
						<td>${food.qty}</td>
						<td><input type="number" name="qtyOrdered" value="1" /></td>
						<td><input type="submit" value="Add to Cart" /></td>
					</form>
				</tr>
			</c:forEach>

		</tr>

	</table>

</body>
</html>