<%@ page session="false" %>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<%
// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache"); 
%>
<div class="text text-primary text-center">
<h1> Welcome to Razor sight </h1>
</div>
<div style="margin-left: 500px;margin-right: 200px;width: 300;">
<form  method="post" action="hlogin">
		UserName: <input type="text" name="username" required class="form-control" placeholder="Enter user name"> <br> 
		Password:<input type="password" name="pass" required class="form-control" placeholder="Enter password"> <br>
		Group: <select name="group" class="form-control">
				  <option value="Staging">Staging</option>
				  <option value="Opgen">Opgen</option>
				  <option value="Implementation">Implementation</option>
				</select>	<br>
				<div class="alert alert-danger">
					<%
    				if(null!=request.getAttribute("Errormessage"))
    					{
       					 out.println(request.getAttribute("Errormessage"));
    					}
					%>
				</div>
	
		<input type="submit" value="Login" class="btn btn-primary">
		<a href="register.jsp" class="btn btn-success">Register here</a>
	</form>
</div>