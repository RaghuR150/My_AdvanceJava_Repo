<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MakeMyTrip Clone</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #0f4c75, #3282b8);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
    }

    .container {
        background: white;
        color: #333;
        padding: 40px;
        border-radius: 16px;
        width: 420px;
        text-align: center;
        box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        animation: zoomIn 0.7s ease-in-out;
    }

    @keyframes zoomIn {
        from { transform: scale(0.9); opacity: 0; }
        to { transform: scale(1); opacity: 1; }
    }

    h2 {
        margin-bottom: 10px;
        color: #0f4c75;
        font-size: 26px;
    }

    p {
        color: #555;
        font-size: 15px;
    }

    .btn {
        display: inline-block;
        margin-top: 20px;
        padding: 12px 30px;
        background: #0f4c75;
        color: white;
        text-decoration: none;
        border-radius: 10px;
        font-weight: bold;
        transition: 0.3s ease;
    }

    .btn:hover {
        background: #3282b8;
        transform: translateY(-2px);
    }
</style>
</head>
<body>

<div class="container">
    <h2>Welcome to MakeMyTrip Clone ✈️</h2>
    <p>Book flights, hotels and holiday packages easily</p>

    <a href="showProfilePage" class="btn">Create Profile</a>
</div>

</body>
</html>
