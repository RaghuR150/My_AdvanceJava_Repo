<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Profile - MakeMyTrip</title>

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
        background: #ffffff;
        width: 420px;
        padding: 30px 35px;
        border-radius: 18px;
        box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        animation: slideIn 0.7s ease-in-out;
    }

    @keyframes slideIn {
        from { transform: translateY(30px); opacity: 0; }
        to { transform: translateY(0); opacity: 1; }
    }

    h2 {
        text-align: center;
        color: #0f4c75;
        margin-bottom: 20px;
        font-size: 24px;
    }

    label {
        font-weight: 600;
        margin-bottom: 6px;
        display: block;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 16px;
        border: 1px solid #ddd;
        border-radius: 10px;
        font-size: 14px;
        outline: none;
        transition: border 0.3s;
    }

    input[type="text"]:focus {
        border-color: #0f4c75;
    }

    input[type="submit"] {
        width: 100%;
        margin-top: 10px;
        background: #0f4c75;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 12px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s ease;
    }

    input[type="submit"]:hover {
        background: #3282b8;
        transform: translateY(-2px);
    }

    .back-link {
        text-align: center;
        margin-top: 15px;
    }

    .back-link a {
        text-decoration: none;
        color: #0f4c75;
        font-weight: 600;
    }

    .back-link a:hover {
        text-decoration: underline;
    }
</style>
</head>

<body>

<div class="card">
    <h2>Create Your Profile</h2>

    <form action="createProfile" method="post">
        <label>First Name</label>
        <input type="text" name="firstName" placeholder="Enter your first name" required />

        <label>Last Name</label>
        <input type="text" name="lastName" placeholder="Enter your last name" required />

        <label>Email</label>
        <input type="text" name="email" placeholder="Enter your email" required />

        <label>Mobile</label>
        <input type="text" name="mobile" placeholder="Enter your mobile number" required />

        <input type="submit" value="Create Profile" />
    </form>

    <div class="back-link">
        <a href="index.jsp">⬅ Back to Home</a>
    </div>
</div>

</body>
</html>