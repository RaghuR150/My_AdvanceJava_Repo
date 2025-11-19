<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome to Zepto</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: "Segoe UI", sans-serif;
        background: linear-gradient(135deg, #0ba360, #3cba92);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .card {
        background: white;
        width: 350px;
        padding: 30px;
        border-radius: 16px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        text-align: center;
        animation: fadeIn 0.8s ease;
    }

    h2 {
        margin: 0;
        font-size: 26px;
        color: #222;
    }

    p {
        color: #444;
        margin-top: 10px;
    }

    .btn {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background: #0ba360;
        color: white;
        font-size: 16px;
        text-decoration: none;
        border-radius: 8px;
        transition: 0.3s;
    }

    .btn:hover {
        background: #088b50;
        transform: translateY(-2px);
        box-shadow: 0 4px 10px rgba(0,0,0,0.2);
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: scale(0.95); }
        to { opacity: 1; transform: scale(1); }
    }
</style>
</head>

<body>

<div class="card">
    <h2>Welcome to Zepto</h2>
    <p>Your ultra-fast delivery partner!</p>
    <a href="login" class="btn">Login</a>
</div>

</body>
</html>