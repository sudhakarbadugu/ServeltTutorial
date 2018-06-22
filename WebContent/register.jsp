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
	<%@ page import="com.conduent.servlet.user.dto.GroupDto"%>
	<%@ page import="java.util.List"%>
	<%@ page import="java.sql.Date" session="false"%>
	<%@ page import="com.conduent.servlet.service.GroupService"%>
	<%@ page import="com.conduent.servlet.service.impl.GroupServiceImpl"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	
<c:set property="headerName" value="${operation == 'edit' ? 'Save User' : 'Add User'}" scope="page" var="headerName"></c:set>

	<div class="text text-danger">${errormassage}</div>

	<h3>${headerName}</h3>
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

			<% 
				List<GroupDto> groups = (List<GroupDto>) request.getAttribute("groups");
				if(groups==null){
					GroupService groupService1 = new GroupServiceImpl();
					groups = groupService1.getAlGroup();
					pageContext.setAttribute("groups", groups);
				}
			%>
		<div class="form-group">
			Group: 
			<c:forEach items="${groups}" var="group">
				<input type="checkbox" name="groups" value="${group.getGroupname()}">${group.getGroupname()}
			</c:forEach>
		</div>
		<button>${headerName}</button>
		<input type="submit" value="Register"> <a href="user">Back</a>

	</form>

</body>
</html>