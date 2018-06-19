<!DOCTYPE html>
<%@ include file="p-header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.conduent.servlet.user.dto.UserDto" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
    <form action="user">
<h1>Welcome to uers</h1>
<h2>List of Users</h2>
<%
List<UserDto> alUser = (List<UserDto>)request.getAttribute("users");
		out.println(
				"<table class='table table-striped'><tr><th>id</th><th>firstName</th><th>lastName</th><th>username</th><th>password</th><th>creationdate</th><th>edit</th><th>delete</th></tr>");
		for (UserDto dto1 : alUser) {
			int id = dto1.getId();
			String firstName = dto1.getFirstName();
			String lastName = dto1.getLastName();
			String username = dto1.getUsername();
			String password = dto1.getPassword();
			Date creationdate = dto1.getCreationdate();
			out.println("<tr><td>" + id + "</td><td>" + firstName + "</td><td>" + lastName + "</td><td>" + username
					+ "</td><td>" + password + "</td><td>" + creationdate
					+ "</td><td><a href='user?id=" + id + "&operation=edit'>edit</a></td><td><a href='user?id=" + id
					+ "&operation=delete'>delete</a></td></tr>");

		}
		out.println("</table>");
%>

<button class="btn btn-primary">AllUsers</button>
<a href="register.jsp">AddUser</a>
<a href="pwelcome">Back</a>
</form>
</body>
</html>
<%@ include file="footer.html" %>