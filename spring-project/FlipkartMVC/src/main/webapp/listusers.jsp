<%@page import="java.util.List"%>
<%@page import="com.test.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserList</title>
</head>
<body>
	<h1>List of Users</h1>
	
	<table border="1" width="50%" align="center">
		<tr>
			<th>Id</th>
			<th>FullName</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Action</th>
		</tr>
		<tbody>
		<c:forEach var="obj" items="${info}">
			<tr>
				<td>${obj.getId()}</td>
				<td>${obj.getFname() }</td>
				<td>${obj.getUsername() }</td>
				<td>${obj.getPassword() }</td>
				<td>Delete &nbsp;&nbsp; Edit</td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	



</body>
</html>