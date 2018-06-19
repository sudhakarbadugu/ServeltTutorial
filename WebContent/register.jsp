<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Login</title>
</head>
<body>
<%@ page import="com.conduent.servlet.user.dto.UserDto"%>
<%@ page import="java.sql.Date" session="false" %>
<% 
String operation = (String)request.getAttribute("operation");
String headerName = "edit".equalsIgnoreCase(operation)? "Save User" : "Add User";
UserDto dto = (UserDto)request.getAttribute("edit");
String firstname = dto != null ? dto.getFirstName() : "";
String lastname = dto!= null ? dto.getLastName() : "";
String username = dto!= null ? dto.getUsername() : "";
String password = dto!= null ? dto.getPassword() : "";
int userId = dto!= null ? dto.getId() : -1;
				
%>
<h3><%= headerName %></h3>
<form  method="post" action="rlogin">
		FirstName: <input type="text" name="first_name" value ="<%=firstname%>" class="form-control" required> <br> 
		LastName: <input type="text" name="last_name" value ="<%=lastname%>" class="form-control" required> <br>
		UserName: <input type="text" name="username" value ="<%=username%>" class="form-control" required> <br> 
		Password:<input type="password" name="pass" value ="<%=password%>" class="form-control" required> <br>
	<input type="hidden" name="userId"
		value="<%= userId %>" required>
	<button><%= headerName %></button>
		<input type="submit" value="Register" >
		
	</form>
</body>
</html>