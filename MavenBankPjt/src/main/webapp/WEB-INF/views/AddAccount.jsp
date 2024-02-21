<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>
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
	<header class="navbar navbar-dark bg-dark">
		<div class="container">
			<img src="" alt="Company Logo">
			<h1 class="text-white">My_Money</h1>
		</div>
	</header>

	<%
	UserDTO user = (UserDTO) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login");
	} else {
	%>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="text-center">Bank Account Form</h2>
            <div class="form-border border border-dark border-3 shadow-sm">
                <div class="form-box">
                    <form action="AddAccount" method="post">
                        <h2>${error}</h2>

                <input type="hidden" name="userId" value="${user.user_id }">
                <table  class="table table-bordered table-secondary ">
                    <tbody>
                        <tr>
                            <td><label for="accountNumber">Account Number:</label></td>
                            <td><input type="text" class="form-control" id="accountNumber" name="accountNumber" required></td>
                        </tr>
                        <tr>
                            <td><label for="bankName">Bank Name:</label></td>
                            <td><input type="text" class="form-control" id="bankName" name="bankName" required></td>
                        </tr>
                        <tr>
                            <td><label for="ifscCode">IFSC Code:</label></td>
                            <td><input type="text" class="form-control" id="ifscCode" name="ifscCode" required></td>
                        </tr>
                        <tr>
                            <td><label for="accountType">Account Type:</label></td>
                            <td>
                                <select class="form-control" id="accountType" name="accountType" required>
                                    <option value="savings">Savings</option>
                                    <option value="current">Current</option>
                                    <!-- Add more options if needed -->
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="initialBalance">Initial Balance:</label></td>
                            <td><input type="number" class="form-control" id="initialBalance" name="initialBalance" required></td>
                        </tr>
                        <tr>
            <td class="border border-3" colspan="2">
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary col-4">Submit</button>
                </div>
            </td>
        </tr>
                    </tbody>
                </table>         
           </form>
                </div>
            </div>
        </div>
    </div>
    
</div>
	

	<%
	}
	%>
	
	
</body>
</html>