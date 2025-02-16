<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="icon" type="image/x-icon" href="https://img.freepik.com/premium-vector/bank-icon-wireframe-hand-online-banking-service-application-finance-banking-global-connection_127544-3647.jpg"> <!-- Replace with the path to your favicon -->
    <style>
        /* Styles for the Online Banking Dashboard Page */
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
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent background for readability */
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

        p {
            font-size: 20px;
            margin-bottom: 30px;
        }

        a {
            color: #1E90FF;
            text-decoration: none;
            margin: 0 15px;
            font-size: 20px;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #ff6347;
            text-decoration: underline;
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
            transition: background-color 0.3s ease;
        }

        

        .button-link:visited, .button-link:active {
            color: white; /* Keep button text white */
        }
    </style>
</head>
<body>
 
    <div class="container">
        <h2>Welcome, ${user.name}!</h2>
        <a href="viewAccounts" class="button-link">Manage Accounts</a>  <a href="transaction" class="button-link">Manage Transactions</a>
        <br><br>
       <a href="viewAccountTransactionDetails" class="button-link">Logout</a>
      
    </div>
</body>
</html>

