<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Created - MakeMyTrip</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #0f4c75, #3282b8);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #333;
    }

    .card {
        background: white;
        width: 420px;
        padding: 30px 35px;
        border-radius: 18px;
        box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        text-align: center;
        animation: popIn 0.7s ease-in-out;
    }

    @keyframes popIn {
        from { transform: scale(0.9); opacity: 0; }
        to { transform: scale(1); opacity: 1; }
    }

    .check {
        font-size: 60px;
        color: #00b894;
        margin-bottom: 10px;
    }

    h2 {
        color: #0f4c75;
        margin-bottom: 10px;
    }

    p {
        color: #555;
        margin: 5px 0;
    }

    .userid-box {
        margin: 20px 0;
        padding: 12px;
        background: #f1f5f9;
        border-radius: 12px;
        font-size: 18px;
        font-weight: bold;
        letter-spacing: 2px;
        color: #333;
    }

    .btn {
        display: block;
        margin-top: 10px;
        padding: 12px;
        width: 100%;
        text-decoration: none;
        background: #0f4c75;
        color: white;
        border-radius: 12px;
        font-size: 16px;
        font-weight: bold;
        transition: 0.3s;
    }

    .btn:hover {
        background: #3282b8;
        transform: translateY(-2px);
    }
</style>
</head>

<body>

<div class="card">
    <div class="check">✅</div>
    <h2>Profile Created Successfully!</h2>
    <p>Welcome to MakeMyTrip Clone</p>

    <div class="userid-box">
        Your User ID: ${userId}
    </div>

    <a href="index.jsp" class="btn">Go to Home Page</a>
</div>

</body>
</html>
