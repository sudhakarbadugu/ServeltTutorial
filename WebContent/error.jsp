<%@ page isErrorPage="true" session="false"%>

<%@ include file="p-header.jsp" %>
<div class="text text-danger">
Something happend at server side. Please contact admin.

<%=exception %>

</div>