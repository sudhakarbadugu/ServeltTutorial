<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page import="java.util.*" %>

<h2>Functional tags</h2>
<c:set var="name" value="Sudhakar"/>  
  
<c:if test="${fn:contains(name, 'Sudha')}">  
   <p>Found name<p>  
</c:if> 

<hr>

<h2>Formatting tags</h2>
<c:set var="amount" value="786.970" />  
  
<fmt:parseNumber var="j" type="number" integerOnly="true" value="${amount}" />  
<p><i>Amount is:</i>  <c:out value="${j}" /></p>  

<fmt:parseNumber var="j" integerOnly="true" type="number" value="${Amount}" />  
    <p><i>Amount is:</i>  <c:out value="${j}" /></p>  
  
  
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
<forTokens items="" delims=""></forTokens>
<redirect></redirect>
<url></url>
-->

<hr>
<h3>Import core tag</h3>
<c:import var="loginContent" url="login.html"></c:import>
${loginContent}

<hr>
<h3>Catch tag</h3>
<c:catch var="exception">
<% int a = 10/0; %>
</c:catch>

<c:if test="${exception != null}">
Exception occured and handled. ${exception}
</c:if>

<hr>
<h3>for tokens</h3>
<c:forTokens items="A,b,c,c,dfdfd,d" delims=","  var="value">
${value}
</c:forTokens>

//if u want test then change the variable to exception.
<c:if test="${exception1 != null}">
	<c:redirect url="error.jsp"></c:redirect>
</c:if>


<c:url value="group" var="groupURL">
<c:param name="id" value="1"></c:param>
<c:param name="operation" value="edit"></c:param>
</c:url>
${groupURL}

