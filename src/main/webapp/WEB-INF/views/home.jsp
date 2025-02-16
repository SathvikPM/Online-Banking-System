<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="icon" type="image/x-icon" href="https://www.shutterstock.com/image-photo/human-use-smartphone-online-banking-260nw-2306202875.jpg">
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
	    align-items: center; /* Corrected */
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
	
	p {
	    font-size: 20px;
	    margin-bottom: 30px;
	}
	
	a, .button-link {
	    color: white; /* Updated to white */
	    text-decoration: none;
	    margin: 0 15px;
	    font-size: 20px;
	    transition: color 0.3s ease;
	}
	
	a:hover, .button-link:hover {
	    color: #ff6347;
	    text-decoration: underline;
	}
	
	a:visited, a:active, .button-link:visited, .button-link:active {
	    color: white; /* Updated to white */
	}
	
	.button-link {
	    display: inline-block;
	    padding: 10px 20px;
	    border-radius: 5px;
	    background-color: #1E90FF; /* Ensure this is visible against the background */
	    color: white;
	    text-transform: uppercase;
	    transition: background-color 0.3s ease;
	}
       
</style>
</head>
<body>
    <div class="container">
        <h2>Welcome to Online Banking!</h2>
        <p>This is the online banking system homepage.</p>
        <a class="button-link" href="login">Login</a>  
        <a class="button-link" href="register">Register</a>
        <c:if test="${not empty user}">
            <br><br>
            <a class="button-link" href="login">Manage Accounts</a>  
            <a class="button-link" href="login">Manage Transactions</a>
        </c:if>
    </div>
</body>
</html>
            