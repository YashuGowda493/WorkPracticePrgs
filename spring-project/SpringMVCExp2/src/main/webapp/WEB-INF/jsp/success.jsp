<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success</title>
</head>
<body align="center">
<h1>Registration Successful</h1>
<p>Your data are</p>
<p>
Name: ${data.getC_name()}<br>
UserName: ${data.getUsername() }<br>
Password : ${data.getPassword() }<br>
<h3><a href="home">HOME</a></h3>

</p>
</body>
</html>