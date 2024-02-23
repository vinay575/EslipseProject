<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Send Money</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Send Money</h2>
    <form action="ProcessSendMoney" method="post">
        <div class="form-group">
            <label for="fromAccount">From Account</label>
            <select class="form-control" id="fromAccount" name="fromAccount">
                <c:forEach items="${banklist}" var="bank">
                    <option value="${bank.accountID}">${bank.bankAccountNo} (${bank.bankName})</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="toAccount">To Account Number</label>
            <input type="text" class="form-control" id="toAccount" name="toAccount">
        </div>
        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="text" class="form-control" id="amount" name="amount">
        </div>
        <button type="submit" class="btn btn-primary">Send Money</button>
    </form>
</div>
</body>
</html>
