<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Zepto - Home</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: linear-gradient(to right, #8e2de2, #4a00e0);
            font-family: Arial, sans-serif;
            color: white;
        }

        .container {
            text-align: center;
            background: white;
            color: #333;
            padding: 40px 60px;
            border-radius: 15px;
            box-shadow: 0 15px 40px rgba(0,0,0,0.3);
        }

        h2 {
            margin-bottom: 30px;
            font-size: 32px;
        }

        a {
            text-decoration: none;
            padding: 12px 30px;
            background-color: #4a00e0;
            color: white;
            font-size: 18px;
            border-radius: 8px;
            transition: 0.3s ease-in-out;
            display: inline-block;
        }

        a:hover {
            background-color: #6a11cb;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Welcome to Zepto</h2>
        <a href="showOrderPage">Create Order</a>
    </div>

</body>
</html>
