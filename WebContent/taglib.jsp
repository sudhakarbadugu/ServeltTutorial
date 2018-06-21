<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
//set value in the scope
<c:set property="name" value="Sudhakar" scope="page" var="name"></c:set>

Print using  out tag:
<c:out value="${name }"></c:out>

<c:if test="${name == 'Sudhakar'}">
Welcome to jstl ${name}
</c:if>

<br>
<h3>Else if cases or switch cases</h3>
<c:choose>
	<c:when test="${name == 'Sudhakar1'}">
		Welcome ${name}
	</c:when>
	<c:when test="${name == 'Sudhakar'}">
		Welcome ${name}
	</c:when>
	<c:otherwise>
		Welcome to Suma
	</c:otherwise>
</c:choose>



<h3>remove variable from score</h3>
<c:remove var="name"/>

<%
	List<String> list = Arrays.asList("Abc", "def", "xyx");
	pageContext.setAttribute("list", list);
%>
<br>
<h3>Iterate over the collections Print list values: </h3>
<c:forEach items="${list}" var="obj" >
	<c:out value="${obj}"></c:out><br>
</c:forEach>

<c:forEach begin="1" end="10" step="1" var="i">
${i} <br>
</c:forEach>

<br>
<h3>Pending things</h3>
<!--  
<catch></catch>
<forTokens items="" delims=""></forTokens>
<import url=""></import>
<redirect></redirect>
<url></url>
-->