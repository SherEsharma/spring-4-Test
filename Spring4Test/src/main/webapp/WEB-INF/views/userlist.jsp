<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>user record</title>


</head>


<body>
	<h2>List of User</h2>	
	<table>
		<tr>
			<td>Id</td><td>First Name</td><td>Last Name</td><td></td>
		</tr>
		<c:forEach items="${user}" var="user">
				
			<tr>
			<td><c:out value="${user.adminId}"/></td>
			
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			<td><a href="<c:url value='/edit-${user.adminId}-user' />"> Edit</a></td>
			<td><a href="<c:url value='/delete-${user.adminId}-user'  />">delete</a></td> 
			
			
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="adminlogin.html">Admin Login</a>
</body>
</html>