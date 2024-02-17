<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.entity.UserDTO"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/styles/styles.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/scripts/Script.js"/>"></script>
</head>
<body>
	<form id="accountForm" action="" method="post">
		<input type="hidden" id="selectedPage" name="selectedPage">
		<header class="navbar navbar-dark bg-dark">
			<div class="container">
				<img src="" alt="Company Logo">
				<h1 class="text-white">My_Money</h1>
			</div>
		</header>

		<%
		UserDTO user = (UserDTO) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("Login");
		} else {
		%>
		<div class="container">
			<div class="userDetails mt-5">
				<h2>Welcome, ${user.name}</h2>
				<p>Phone Number: ${user.address}</p>
				<p>Email: ${user.email }</p>
				<p>Address: ${user.address }</p>
			</div>

			<div class="accountsList mt-5">
				<a href="addaccount" class="btn btn-primary float-right">Add
					Account</a>
				<h2>Accounts</h2>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>Select</th>
							<th>Account Number</th>
							<th>Bank Name</th>
							<th>IFSC code</th>
							<th>Account type</th>
							<th>Current Balance</th>
							<th>Last transaction</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${banklist}" var="bank">
							<tr>
								<td><input type="radio" name="selectedAccount"
									value="${bank.bankAccountNo}"></td>
								<td>${bank.bankAccountNo}</td>
								<td>${bank.bankName}</td>
								<td>${bank.ifscCode}</td>
								<td>${bank.accountType}</td>
								<td>${bank.currentBalance}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			
			<div class="transactions mt-5">
				<input type="hidden" id="selectedAction" name="selectedAction">
				<a href="statement.jsp" class="btn btn-primary">Statement</a> 
				<a href="Addmoney.jsp" class="btn btn-primary">Add Money</a> 
				<a href="sendmoney.jsp" class="btn btn-primary">Send Money</a> 
			</div>

		</div>
		<%
		}
		%>
	</form>
	<div class="container mt-3">
		<button class="btn btn-danger" onclick="requestlogout()">Logout</button>
	</div>
</body>
</html>
