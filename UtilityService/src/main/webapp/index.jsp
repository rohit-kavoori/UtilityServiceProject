<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<fieldset>
		<legend>
			<h2>Registration Form</h2>
		</legend>
		<h3>
			<form method="post" action="addCustomer">
				<div>
					<label>First Name</label>
				</div>

				<div>
					<input type="text" name="firstName" />
				</div>

				<div>
					<label>Last Name</label>
				</div>

				<div>
					<input type="text" name="lastName" />
				</div>

				<div>
					<label>Email</label>
				</div>

				<div>
					<input type="email" name="email" />
				</div>

				<div>
					<label>User Name</label>
				</div>

				<div>
					<input type="text" name="username" />
				</div>

				<div>
					<label>Password</label>
				</div>

				<div>
					<input type="password" name="password" />
				</div>
				<br>
				<div>
					<input type="submit" value="Submit" />
				</div>
			</form>
		</h3>
	</fieldset>
</body>
</html>