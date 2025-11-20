<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Amazon</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #232f3e, #131921);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        .box {
            text-align: center;
            background: rgba(255, 255, 255, 0.08);
            padding: 40px;
            width: 350px;
            border-radius: 15px;
            backdrop-filter: blur(10px);
            box-shadow: 0 0 25px rgba(0,0,0,0.4);
        }

        h2 {
            color: #ff9900;
            font-size: 28px;
            margin-bottom: 20px;
        }

        a {
            display: inline-block;
            padding: 12px 28px;
            background: #ff9900;
            color: black;
            font-size: 16px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            margin-top: 20px;
            transition: 0.3s ease;
        }

        a:hover {
            background: #ffa726;
        }
    </style>
</head>

<body>

<div class="box">
    <h2>Welcome to Amazon</h2>
    <a href="login">Login</a>
</div>

</body>
</html>
