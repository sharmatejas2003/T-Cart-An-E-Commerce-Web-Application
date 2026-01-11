<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<div class="container">

<h2>Your Cart</h2>

<!-- 🛑 Empty cart check -->
<c:if test="${empty cart}">
    <p>Cart is Empty</p>
</c:if>

<!-- 🛒 Cart Items -->
<c:forEach var="item" items="${cart}">
    <div class="card">
        <p><b>Product:</b> ${item.value.product.name}</p>
        <p><b>Price:</b> ₹ ${item.value.product.price}</p>
        <p><b>Quantity:</b> ${item.value.quantity}</p>
        <p>
            <b>Total:</b>
            ₹ ${item.value.product.price * item.value.quantity}
        </p>
    </div>
</c:forEach>

<!-- 🧾 Place Order -->
<c:if test="${not empty cart}">
    <form action="${pageContext.request.contextPath}/order" method="post">
        <button>Place Order</button>
    </form>
</c:if>

</div>
</body>
</html>
