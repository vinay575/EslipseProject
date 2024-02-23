<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.UserDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Money</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/styles/styles.css"/>">
</head>
<script>
        function goBack() {
            window.history.back();
        }
    </script>
<body>
    <header class="navbar navbar-dark bg-dark">
			<div class="container">
				<div class="navbar-nav">
					<a href="#" class="btn btn-outline-light mr-3" onclick="goBack()">Home</a> 					
				</div>
				<h1 class="text-white">My_Money</h1>
				<a href="logout" class="btn btn-danger">Logout</a>
			</div>
		</header>

    <%
    UserDTO user = (UserDTO) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
    } else {
    %>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h2 class="text-center">Send Money</h2>
                    </div>
                    <div class="card-body">
                        <h3 class="text-center">Welcome ${user.name}</h3>
                        <form action="sendmoney" method="post">
                            <input type="hidden" name="accountID" value="${accountID}">
                            <div class="form-group">
                                <label for="recipientAccount">Recipient's Account Number:</label>
                                <input type="text" id="recipientAccount" name="recipientAccount" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="amount">Amount to Send:</label>
                                <input type="number" id="amount" name="amount" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Send Money</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%
    }
    %>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Your custom JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/scripts/Script.js"/>" ></script>
</body>
</html>
