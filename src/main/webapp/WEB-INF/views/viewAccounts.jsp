<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Accounts</title>
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
            max-width: 900px;
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

        p {
            font-size: 20px;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #1E90FF;
            color: white;
            font-size: 18px;
        }

        td {
            font-size: 16px;
        }

        a {
            color: #1E90FF;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #ff6347;
            text-decoration: underline;
        }

        a:visited, a:active {
            color: #1E90FF;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Your Accounts</h2>
        <c:if test="${not empty accounts}">
            <p>Accounts found: ${fn:length(accounts)}</p>
            <table>
                <tr>
                    <th>Account ID</th>
                    <th>Account Number</th>
                    <th>Account Type</th>
                    <th>Balance</th>
                    <th>View Transactions</th>
                </tr>
                <c:forEach var="account" items="${accounts}">
                    <tr>
                        <td>${account.accountId}</td>
                        <td>${account.accountNumber}</td>
                        <td>${account.accountType}</td>
                        <td>${account.balance}</td>
                        <td><a href="viewAccountTransactions?accountId=${account.accountId}">View Transactions</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="BankAccount" class="button-link">Create Bank Account</a>
        </c:if>
        <c:if test="${empty accounts}">
            <p>No accounts found.</p>
            <a href="BankAccount" class="button-link">Create Bank Account</a>
        </c:if>
    </div>
</body>
</html>
