<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title> </title>
</head>
<body>

 UserDetails
 ${user.firstName} 
 <p><c:out value="${user.firstName}"></c:out></p>
  <p><c:out value="${user.lastName}"></c:out></p>
   <p><c:out value="${user.salary}"></c:out></p>
 
</body>
</html>