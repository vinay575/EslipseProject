<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.entity.StatementDTO"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Statement</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
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
                <a href="#" class="btn btn-outline-light mr-3"
                    onclick="goBack()">Home</a>
            </div>
            <h1 class="text-white">My_Money</h1>
            <a href="logout" class="btn btn-danger">Logout</a>
        </div>
    </header>
    <div class="container">
        <h2 class="mt-5">Statement</h2>
        <table class="table table-bordered mt-3">
            <thead class="thead-dark">
                <tr>
                    <th>Transaction ID</th>
                    <th>From Account Number</th>
                    <th>To Account Number</th>
                    <th>Amount</th>
                    <th>Transaction Type</th>
                    <th>Transaction Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${statementList}" var="statement">
                    <tr>
                        <td>${statement.transactionId}</td>
                        <td>${statement.fromAccountNumber}</td>
                        <td>${statement.toAccountNumber}</td>
                        <td>${statement.amount}</td>
                        <td>${statement.transactionType}</td>
                        <td>${statement.transactionDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
