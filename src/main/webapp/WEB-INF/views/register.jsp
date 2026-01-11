<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<h1>Welcome to the T-Cart</h1><br>
<h2>New User Registration</h2>

<form action="${pageContext.request.contextPath}/register" method="post">
    Email:<input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <button>Register</button>
</form>

<p>Already have an account ?
<a href="${pageContext.request.contextPath}/login-page">Login</a>
</p>

</body>
</html>