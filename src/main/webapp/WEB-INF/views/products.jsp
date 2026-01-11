<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<div class="container">

<h2>Welcome to Shop</h2>

<!-- 🔍 Search -->
<form action="${pageContext.request.contextPath}/products" method="get">
    <input type="text" name="q" placeholder="Search products">
    <button>Search</button>
</form>

<hr>

<!-- 🗂️ Categories -->
<h3>Categories</h3>
<c:forEach var="c" items="${categories}">
    <a href="${pageContext.request.contextPath}/products?cat=${c.id}">
        ${c.name}
    </a> |
</c:forEach>

<hr>

<!-- 🛒 Product List -->
<c:if test="${empty products}">
    <p>No products found.</p>
</c:if>

<c:forEach var="p" items="${products}">
    <div class="card">

        <h3>${p.name}</h3>
        <p>${p.description}</p>

        <!-- 💸 Price + Discount -->
        <c:if test="${p.discount > 0}">
            <p>
                <b>₹ ${p.price}</b><br>
                <b>₹ ${p.finalPrice}</b>
                <span style="color:green;">
                    (${p.discount}% OFF)
                </span>
            </p>
        </c:if>

        <c:if test="${p.discount == 0}">
            <p><b>₹ ${p.price}</b></p>
        </c:if>

        <!-- 🛒 Add to Cart -->
        <form action="${pageContext.request.contextPath}/cart" method="post">
            <input type="hidden" name="id" value="${p.id}">
            <button>Add to Cart</button>
        </form>

    </div>
</c:forEach>

<br>
<a href="${pageContext.request.contextPath}/view-cart">View Cart</a>

</div>
</body>
</html>
