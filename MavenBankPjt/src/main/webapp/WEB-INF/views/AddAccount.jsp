<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false" %>
<%@ page import="com.entity.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account Form</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<script type="text/javascript" src="Script.js"></script>
</head>
<body>
	<header>
		<div class="container">
			<img src="company-logo.png" alt="Company Logo">
			<h1>MyDigiPurse</h1>
		</div>
	</header>

	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("Login");
	} else {
	%>
	<div class="container">
		<div class="form-box">
			<h2>Bank Account Form</h2>

			<form action="addaccount" method="post">

				<h2>${error}</h2>

				<h3>Welcome, ${user.username}</h3>

				<input type="hidden" name="userId" value="${user.user_id }">

				<div class="form-group">
					<label for="accountNumber">Account Number:</label> <input
						type="text" class="form-control" id="accountNumber"
						name="accountNumber" required>
				</div>

				<div class="form-group">
					<label for="bankName">Bank Name:</label> <input type="text"
						class="form-control" id="bankName" name="bankName" required>
				</div>

				<div class="form-group">
					<label for="ifscCode">IFSC Code:</label> <input type="text"
						class="form-control" id="ifscCode" name="ifscCode" required>
				</div>

				<div class="form-group">
					<label for="accountType">Account Type:</label> <select
						class="form-control" id="accountType" name="accountType" required>
						<option value="savings">Savings</option>
						<option value="current">Current</option>
						<!-- Add more options if needed -->
					</select>
				</div>

				<div class="form-group">
					<label for="initialBalance">Initial Balance:</label> <input
						type="number" class="form-control" id="initialBalance"
						name="initialBalance" required>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form>

		</div>
	</div>
	<%
	}
	%>
	<div class="container">
		<button style="width: 10%" class="btn btn-danger logout"
			onclick="
requestlogout()">Logout</button>

	</div>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>