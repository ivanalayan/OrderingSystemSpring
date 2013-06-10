<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<h2>Customer Registration</h2>
	<div style="color: red;">
		<div>${message}</div>
	</div>
	<div>
		<form:form method="POST" commandName="customer" action="registration">
				  <div>First Name: <form:input path="firstName"/></div>
				  <div>Last Name: <form:input path="lastName"/></div>
				  <div>Username: <form:input path="username"/></div>
				  <div>Password: <form:password path="password"/></div>
				  <div>Address: <form:input path="address"/></div>
			<div>	
				  <input type="submit" value="register">
				  <input type="reset" value="clear"> 
			</div>
		</form:form>
	</div>
</body>
</html>