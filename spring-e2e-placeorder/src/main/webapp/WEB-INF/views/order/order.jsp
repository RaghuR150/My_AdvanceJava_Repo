<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Place Order</title>
<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(to right, #4a00e0, #8e2de2);
        font-family: Arial, sans-serif;
    }

    .form-container {
        background: #ffffff;
        padding: 40px 50px;
        border-radius: 15px;
        width: 350px;
        box-shadow: 0 15px 40px rgba(0,0,0,0.25);
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
    }

    .input-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
        color: #555;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px 12px;
        border-radius: 8px;
        border: 1px solid #ccc;
        font-size: 14px;
        transition: 0.3s;
    }

    input[type="text"]:focus {
        border-color: #6a11cb;
        outline: none;
        box-shadow: 0 0 5px rgba(106,17,203,0.3);
    }

    .submit-btn {
        width: 100%;
        margin-top: 10px;
        padding: 12px;
        border: none;
        border-radius: 8px;
        background: #4a00e0;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    .submit-btn:hover {
        background: #6a11cb;
        transform: scale(1.02);
    }
</style>
</head>
<body>

<div class="form-container">
    <h2>Place Your Order</h2>

    <form action="placeOrder" method="post">
        <div class="input-group">
            <label>Item Name</label>
            <input type="text" name="itemName" required/>
        </div>

        <div class="input-group">
            <label>Quantity</label>
            <input type="text" name="qty" required/>
        </div>

        <div class="input-group">
            <label>Price</label>
            <input type="text" name="price" required/>
        </div>

        <div class="input-group">
            <label>Delivery Address</label>
            <input type="text" name="address" required/>
        </div>

        <button type="submit" class="submit-btn">Place Order</button>
    </form>
</div>

</body>
</html>
