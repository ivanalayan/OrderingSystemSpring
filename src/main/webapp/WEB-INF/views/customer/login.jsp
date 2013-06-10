<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<c:if test="${not empty account}">
	<c:redirect url="menu"></c:redirect>
</c:if>
	<div style="color: red;">
		<div>${errorMessages}</div>
	</div>
	<div>
		<h3>Customer Login</h3>
		
		<form:form method="POST" commandName="customer" action="welcome">
			<div style="color:red">${errorMessage}</div>
			<div>Username: <form:input path="username"/></div>
			<div>Password:  <form:password path="password"/></div>
			<div> <input type="submit" />  </div>
		</form:form>
			<div>Click <a href="register">Here</a> to register.</div>
	</div>
</body>
</html>