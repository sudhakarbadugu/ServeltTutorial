<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
((HttpServlet)page).destroy();

String name = (String)request.getParameter("name");

pageContext.setAttribute("name", name, PageContext.PAGE_SCOPE);
pageContext.setAttribute("name1", name, PageContext.REQUEST_SCOPE);
pageContext.setAttribute("name2", name, PageContext.SESSION_SCOPE);
pageContext.setAttribute("name3", name, PageContext.APPLICATION_SCOPE);

%>

<%=pageContext.getAttribute("name") %>
<a href="user2.jsp">second jsp page</a>  

