<%@ page isErrorPage="true" session="false"%>

<jsp:include page="header.jsp" />
<div class="text text-danger">
Something happend at server side. Please contact admin.

<%=exception %>

</div>

<%@ include file="footer.html" %>