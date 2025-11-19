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
            font-family: "Segoe UI", Arial, sans-serif;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        .container {
            text-align: center;
            background: rgba(255, 255, 255, 0.12);
            padding: 40px 60px;
            border-radius: 20px;
            backdrop-filter: blur(10px);
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.3);
        }

        h2 {
            font-size: 32px;
            margin-bottom: 20px;
        }

        a.button {
            text-decoration: none;
            background: #ffdd57;
            color: #333;
            padding: 12px 28px;
            border-radius: 30px;
            font-size: 18px;
            font-weight: bold;
            transition: 0.3s ease;
        }

        a.button:hover {
            background: #ffe990;
            transform: scale(1.05);
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>Welcome to Zepto</h2>
        <a href="login" class="button">Login</a>
    </div>
</body>
</html>

