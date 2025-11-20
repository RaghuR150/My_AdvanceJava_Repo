<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fancy Login Page</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #232f3e, #131921);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        .login-box {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(12px);
            padding: 35px;
            width: 350px;
            border-radius: 12px;
            box-shadow: 0px 0px 20px rgba(0,0,0,0.4);
        }

        h2 {
            text-align: center;
            color: #ff9900;
            margin-bottom: 20px;
        }

        input {
            width: 100%;
            padding: 12px;
            margin: 12px 0;
            border-radius: 8px;
            border: none;
            font-size: 16px;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 10px;
            background: #ff9900;
            border: none;
            color: black;
            font-size: 17px;
            border-radius: 8px;
            cursor: pointer;
            font-weight: bold;
        }

        button:hover {
            background: #ffac33;
        }

        .footer-link {
            text-align: center;
            margin-top: 12px;
        }

        .footer-link a {
            color: #ff9900;
            text-decoration: none;
            font-size: 14px;
        }

        .footer-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="login-box">
    <h2>Login</h2>
    <form action="login" method="post">
        <input type="text" name="username" placeholder="Enter Username">
        <input type="password" name="password" placeholder="Enter Password">
        <button type="submit">Login</button>
    </form>

    <div class="footer-link">
        <a href="#">Forgot Password?</a>
    </div>
</div>

</body>
</html>