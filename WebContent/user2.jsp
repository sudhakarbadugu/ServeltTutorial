<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%=pageContext.getAttribute("name2", PageContext.SESSION_SCOPE) %><br/>
<%=session.getAttribute("name2") %>
<%pageContext.removeAttribute("name2", PageContext.SESSION_SCOPE); %>