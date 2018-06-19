<%@ include file="p-header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.conduent.servlet.user.dto.GroupDto"%>
<h1>Welcome to groups</h1>

<% 
String operation = (String)request.getAttribute("operation");
String headerName = "edit".equalsIgnoreCase(operation)? "Update Group" : "Add Group";
GroupDto dto = (GroupDto)request.getAttribute("edit");
String groupname = dto != null ? dto.getGroupname() : "";
String groupdescription = dto!= null ? dto.getGroupdescription() : "";
int groupId = dto!= null ? dto.getId() : -1;
				
%>

<h3><%= headerName %></h3>
<form action="group">
	Group name: <input type="text" name="groupname"
		value="<%= groupname %>" required> 
		Group Description:<input
		type="text" name="groupdescription" value="<%= groupdescription %>"
		required> 
		<input type="hidden" name="groupId"
		value="<%= groupId %>" required>
	<button><%= headerName %></button>
	<br> <a class="btn btn-primary" href="pwelcome">Go Back</a>

</form>
<%

 String errormassage =(String)request.getAttribute("errormassage");
if(errormassage !=null){
out.println(errormassage);
}
%>

<h2>List of groups</h2>
<div class="pre-scrollable">
<% 
	List<GroupDto> alGroup =  (List<GroupDto>)request.getAttribute("groups");
		if (alGroup != null) {
			out.println(
					"<table class='table table-striped'><tr><th>id</th><th>GroupName</th><th>GroupDescription</th><th>edit</th><th>delete</th></tr>");
			for (GroupDto dto1 : alGroup) {
				int id = dto1.getId();
				String groupname2 = dto1.getGroupname();
				String groupdescription2 = dto1.getGroupdescription();
				out.println("<tr><td>" + id + "</td><td>" + groupname2 + "</td><td>" + groupdescription2
						+ "</td><td><a href='group?id=" + id
						+ "&operation=edit'>edit</a></td><td><a href='group?id=" + id
						+ "&operation=delete'>delete</a></td></tr>");
			}
			out.println("</table>");
		}
%>
</div>

<%@ include file="footer.html"%>