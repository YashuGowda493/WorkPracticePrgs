<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<!-- declaration tag -->
<%!
int r=3;
int y=9;
public int add(){
	return r+y;
}
%>

<!-- Expression tag -->

<%= add()%>
<br>
<%= new Date() %>

<br>

<!-- scriplet tag -->
<%
out.println("scripl".toUpperCase());
%>
</body>
</html>