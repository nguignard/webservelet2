<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%--   <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>

<body>
 <jsp:include page="../template/header.jsp"/>
 
 SHOW USER LIST
 ${users}

 <ul>
	 <c:forEach items="${users}" var = "user">
		 <li>
		 ${user.firtsName}
		 <a href="?action=detail&id=${user.firtsName}">${user.firtsName}</a>
		 </li>
	 </c:forEach>
 
 </ul>
<a href="?action=add">Add User</a>
 
 
</body>
</html>