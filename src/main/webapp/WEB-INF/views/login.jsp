<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<div class = "container">
<h1>Welcome to T-cart</h1>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post"><!-- Absolute path -->
Email <input type = "text" name = "email"><br><br>
Password <input type = "password" name = "password"><br><br>
<button>Login</button>
</form>
</div>
</body>
</html>