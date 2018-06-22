<!DOCTYPE html>
<%@ include file="p-header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.conduent.servlet.user.dto.UserDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<form action="user">
		<h1>Welcome to uers</h1>
		<h2>List of Users</h2>
		<div>
			<table class='table table-striped'>
				<tr>
					<th>id</th>
					<th>firstName</th>
					<th>lastName</th>
					<th>username</th>
					<th>password</th>
					<th>creationdate</th>
					<th>edit</th>
					<th>delete</th>
				</tr>

				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.creationdate}</td>
						<td><a href='user?id=${user.id}&operation=edit'>edit</a></td>
						<td><a href='user?id=${user.id}&operation=delete'>delete</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>

		<button class="btn btn-primary">AllUsers</button>
		<a href="register.jsp">AddUser</a> <a href="pwelcome">Back</a>
	</form>
</body>
</html>
<%@ include file="footer.html"%>