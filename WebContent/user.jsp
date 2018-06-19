<%@ page import="com.conduent.servlet.login.UsersServlet" session="false" isErrorPage="true" %>

<h1>Welcome to users</h1>

<h2>List of users</h2>



<a href="register.html">AddUser </a>

<%! static int count = 1; 
	static int getCount(){	
		return count++;
	}
%> 
<% String username = "Sudhakar"; 

int i = 10/0;
%>
<%= getCount() %>
<%= UsersServlet.getValue() %>

<br>
<% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %>  

<%= request.getParameter("username") 
	
%>

Init params
<%= config.getInitParameter("drivername")%><br>
<%= application.getInitParameter("dbname")%>

<form action="user1.jsp">
	<input type="text" name="name">
	<input type="submit" value="Go">
</form>

