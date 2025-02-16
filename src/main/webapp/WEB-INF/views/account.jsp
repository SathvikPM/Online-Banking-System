<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Account</title>
    <link rel="icon" type="image/x-icon" href="https://img.freepik.com/premium-vector/bank-icon-wireframe-hand-online-banking-service-application-finance-banking-global-connection_127544-3647.jpg">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-image: url('https://png.pngtree.com/thumb_back/fh260/background/20230322/pngtree-online-banking-concept-with-the-businessman-online-banking-concept-with-businessman-photo-image_2041611.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #333;
        }

        .container {
            max-width: 700px;
            padding: 40px;
            background-color: rgba(255, 255, 255, 0.9);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            border-radius: 10px;
            animation: fadeIn 1.5s ease-in-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        h2 {
            color: #1E90FF;
            margin-bottom: 30px;
            font-size: 2.5em;
            font-weight: bold;
        }

        form {
            text-align: left;
        }

        label {
            font-size: 18px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #1E90FF;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s ease, text-decoration 0.3s ease;
            text-decoration: none;
        }

        input[type="submit"]:hover {
            text-decoration: underline;
            color: white;
        }

        a:hover {
            color: #ff6347;
            text-decoration: underline;
        }

    </style>
</head>
<body>
    <div class="container">
        <h2>Create New Account</h2>
        <form action="account" method="post">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required><br>

            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" required><br>

            <label for="accountType">Account Type:</label>
            <input type="text" id="accountType" name="accountType" required><br>

            <label for="balance">Balance:</label>
            <input type="text" id="balance" name="balance" required><br>

            <input type="submit" class="button-link" value="Create Account">
        </form>
        <c:if test="${not empty message}">
            <p style="color: green;">${message}</p>
        </c:if>
    </div>
</body>
</html>
