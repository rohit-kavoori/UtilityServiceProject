<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>

	<h2>Registration Successful!!!</h2>
	<table border="1px">
		<tr>
			<td>First Name:</td>
			<td>${customer.getFirstName()}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${customer.getLastName()}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${customer.getEmail()}</td>
		</tr>
		<tr>
			<td>User Name:</td>
			<td>${customer.getUsername()}</td>
		</tr>
	</table>

</body>
</html>