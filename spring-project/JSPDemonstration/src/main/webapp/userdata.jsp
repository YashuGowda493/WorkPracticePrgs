<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userdata</title>
</head>
<body>
	<h1>Userdata</h1>
	<%
	String user = request.getParameter("user");
	String pwd=request.getParameter("pwd");
	if(user.equals("admin")&&pwd.equals("1234")){
		%>
		<jsp:forward page="success.jsp"></jsp:forward>
		
		<%
	}else{
		out.println("<font color='red'>Invalid credentials</font>");
		%>
		<jsp:include page="login.jsp"></jsp:include>
		<%
	}
	%>

</body>
</html>