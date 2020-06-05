<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <jsp:include page="../../template/header.jsp"/>
 
</body>
ADD LOGIN


<!-- 

<ul>
	<li>pageScope = ${pageScope.postUserUrl}</li>
	<li>requestScope : ${requestScope.postUserUrl}</li>
	<li>sessionScope : ${sessionScope.postUserUrl}</li>
	<li>applicationScope : ${applicationScope.postUserUrl}</li>
</ul>
-->


<!-- <c:url var="postUserUrl" value="/login"/>  -->
 <form action="/login"  method ="post">
 Your name ?<br>
	 <input type="text" name ="firstname">
	 <input type="text" name ="lastname">
	 <input type="submit">
 </form> 
 
<%-- <c:if test=${aValue >9}">
Above 9
</c:if>
<c:if test=${aValue <9}">
under 9
</c:if>
 --%>




</body>
</html>