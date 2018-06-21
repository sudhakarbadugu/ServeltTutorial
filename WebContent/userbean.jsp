<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="groupDto" class="com.conduent.servlet.user.dto.GroupDto"></jsp:useBean>
<jsp:setProperty property="id" name="groupDto" value="1"/>
<jsp:setProperty property="groupname" name="groupDto" value="Suma"/>

<jsp:getProperty property="groupname" name="groupDto"/>

  ${groupDto.groupname}