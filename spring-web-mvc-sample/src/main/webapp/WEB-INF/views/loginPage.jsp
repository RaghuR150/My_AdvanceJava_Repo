<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>

    <!-- Simple Fancy Styling -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }

        .container {
            background: white;
            padding: 25px 35px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            width: 330px;
            text-align: center;
        }

        .container h2 {
            margin-bottom: 25px;
            color: #333;
        }

        input[type="text"], input[type="password"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
            outline: none;
            font-size: 14px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #2575fc;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background: #1a5fcc;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Login Page</h2>

    <form method="post">
        <input type="text" name="username" placeholder="Enter Username"><br>
        <input type="password" name="password" placeholder="Enter Password"><br>
        <input type="submit" value="Login">
    </form>
</div>

</body>
</html>
