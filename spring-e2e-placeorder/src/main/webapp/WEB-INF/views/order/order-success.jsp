<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>
<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(to right, #00b09b, #96c93d);
        font-family: Arial, sans-serif;
    }

    .success-card {
        background: white;
        padding: 40px 50px;
        border-radius: 16px;
        text-align: center;
        box-shadow: 0 15px 40px rgba(0,0,0,0.25);
        animation: fadeIn 0.7s ease-in-out;
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    .success-icon {
        font-size: 50px;
        margin-bottom: 15px;
        color: #00b09b;
    }

    .success-title {
        font-size: 26px;
        font-weight: bold;
        margin-bottom: 10px;
        color: #333;
    }

    .success-text {
        font-size: 16px;
        margin-bottom: 20px;
        color: #555;
    }

    .order-id {
        font-size: 20px;
        font-weight: bold;
        color: #4a00e0;
        margin-bottom: 25px;
    }

    .btn-home {
        text-decoration: none;
        padding: 12px 30px;
        background: #4a00e0;
        color: white;
        font-size: 16px;
        border-radius: 8px;
        transition: 0.3s ease;
        display: inline-block;
    }

    .btn-home:hover {
        background: #6a11cb;
        transform: scale(1.05);
    }
</style>
</head>
<body>

<div class="success-card">
    <div class="success-icon">✅</div>
    <div class="success-title">Order Placed Successfully!</div>
    <div class="success-text">Thank you for shopping with Zepto.</div>

    <div class="order-id">
        Your Order ID: ${orderId}
    </div>

    <a href="showOrderPage" class="btn-home">Place Another Order</a>
</div>

</body>
</html>
