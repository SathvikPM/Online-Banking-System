<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
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

        input[type="text"], input[type="password"] {
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

        .button-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #1E90FF;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease, text-decoration 0.3s ease;
        }

        .button-link:hover {
            text-decoration: underline;
        }

        .button-link:visited, .button-link:active {
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>

        <form action="userLogin" method="post">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" class="button-link" value="Login">
        </form>
        <a href="register" class="button-link">Register</a>
    </div>
</body>
</html>
