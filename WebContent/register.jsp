<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Login</title>
</head>
<body>
	<%@ page import="com.conduent.servlet.user.dto.UserDto"%>
	<%@ page import="java.sql.Date" session="false"%>
	<% 
String operation = (String)request.getAttribute("operation");
String headerName = "edit".equalsIgnoreCase(operation)? "Save User" : "Add User";
%>

	<div class="text text-danger">${errormassage}</div>

	<h3><%= headerName %></h3>
	<form method="post" action="rlogin">
		FirstName: <input type="text" name="first_name"
			value="${userDto.getFirstName()}" class="form-control" required>
		<br> LastName: <input type="text" name="last_name"
			value="${userDto.getLastName()}" class="form-control" required>
		<br> UserName: <input type="text" name="username"
			value="${userDto.getUsername()}" class="form-control" required>
		<br> Password:<input type="password" name="pass"
			value="${userDto.getPassword()}" class="form-control" required>
		<br> <input type="hidden" name="userId"
			value="${userDto.getId()}" required>

		<div class="form-group">
			Group: <input type="checkbox"> staging <input type="checkbox">
			opgen <input type="checkbox"> implementation
		</div>
		<button><%= headerName %></button>
		<input type="submit" value="Register"> <a href="user">Back</a>

	</form>

</body>
</html>