<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Jsp</title>
<link rel = "stylesheet" href = "css/style.css">
</head>
<body>
<c:if test="${empty admin}"><!-- Check kia kahin admin to nhi hai to admin page pe redirect kro vrna wapas login page par -->
<c:redirect url = "login.jsp"/>
</c:if>

<div class = "container">
<h2>Admin Dashboard</h2>
<p>Welcome Admin</p>
</div>
</body>
</html>