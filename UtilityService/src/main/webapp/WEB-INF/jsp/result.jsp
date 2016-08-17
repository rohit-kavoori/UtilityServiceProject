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
	<fieldset>
		<legend>
			<h2>Registration Successful</h2>
		</legend>
		<h3>
			<label>First Name:</label> <label><b>${customer.getFirstName()}</b></label><br>
			<label>Last Name:</label> <label><b>${customer.getLastName()}</b></label><br>
			<label>Email:</label> <label><b>${customer.getEmail()}</b></label><br>
			<label>User Name:</label> <label><b>${customer.getUsername()}</b></label><br>
			<br> <label>Service Plan Details:</label><br>
			<div>
				<b>${status}</b>
			</div>
		</h3>
	</fieldset>
</body>
</html>