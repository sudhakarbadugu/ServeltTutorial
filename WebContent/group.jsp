<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
<%@ page import="java.util.List"%>
<%@ page import="com.conduent.servlet.user.dto.GroupDto"%>
<h1>Welcome to groups</h1>

<c:set property="headerName" value="${operation == 'edit' ? 'Update Group' : 'Add Group'}" scope="page" var="headerName"></c:set>

<h3>${headerName}</h3>
<form action="group">
	Group name: <input type="text" name="groupname"
		value="${groupDto.getGroupname()}" required> Group
	Description:<input type="text" name="groupdescription"
		value="${groupDto.getGroupdescription()}" required> <input
		type="hidden" name="groupId" value="${groupDto.getId()}" required>
	<button>${headerName}</button>
	<br> <a class="btn btn-primary" href="pwelcome">Go Back</a>

</form>
<div class="text text-danger">${errormassage}</div>
<h2>List of groups</h2>
<div>
	<table class='table table-striped'>
		<tr>
			<th>id</th>
			<th>GroupName</th>
			<th>GroupDescription</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
		<c:forEach items="${groups}" var="group">
			<c:url value="group" var="groupEditURL">
        		<c:param name="id" value="${group.id}"></c:param>
        		<c:param name="operation" value="edit"></c:param>
        	</c:url>
			<tr>
				<td>${group.id}</td>
				<td>${group.groupname}</td>
				<td>${group.groupdescription}</td>
				<td><a href='${groupEditURL}'>edit</a></td>
				<td><a href='group?id=${group.id}&operation=delete'>delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="footer.html"%>