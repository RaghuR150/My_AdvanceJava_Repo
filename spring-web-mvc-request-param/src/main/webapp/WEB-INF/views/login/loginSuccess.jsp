<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #43cea2, #185a9d);
    }

    .success-box {
        background: #ffffff;
        padding: 40px 60px;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        text-align: center;
    }

    h2 {
        color: #2e7d32;
        margin-bottom: 10px;
    }

    p {
        color: #555;
        font-size: 16px;
        margin-bottom: 20px;
    }

    .btn {
        text-decoration: none;
        padding: 10px 25px;
        background: #185a9d;
        color: white;
        border-radius: 25px;
        font-weight: bold;
        transition: 0.3s ease;
        display: inline-block;
    }

    .btn:hover {
        background: #43cea2;
        transform: scale(1.05);
    }
</style>
</head>
<body>

<div class="success-box">
    <h2>✅ Login Successful!</h2>
    <p>You have successfully logged in.</p>
    <a href="login" class="btn">Logout</a>
</div>

</body>
</html>
