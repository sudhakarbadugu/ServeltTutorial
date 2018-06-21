<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

Param: ${param.name} <br>
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

<!-- 
<jsp:forward page="user2.jsp"></jsp:forward>
 -->
 
 <jsp:include page="user2.jsp">
 <jsp:param value="1" name="id"/>
 </jsp:include>
 
 
 