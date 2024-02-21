<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.entity.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Money</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <header class="navbar navbar-dark bg-dark">
        <div class="container">
            <h1 class="text-white">My_Money</h1>
        </div>
    </header>
    
      <%
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("Login");
        } else {
        %>

    <div class="container mt-5">
        <div class="row justify-content-center"> <!-- Center the content -->
            <div class="col-md-6"> <!-- Specify column width for medium-sized screens -->
                <div class="card">
                    <div class="card-header">
                        <h2 class="text-center">Add Money</h2>          
                    </div>
                   
                    <div class="card-body">
                        <h3 class="text-center">Welcome</h3>
                        <form id="addMoneyForm" action="AddMoney" method="post">
                            <div class="form-group">
                                <label for="accountNumber">Bank Account Number:</label>
                                <input type="text" id="accountNumber" name="accountNumber" value="${accountID}" class="form-control" readonly>
                            </div>
                            <div class="form-group">
                                <label for="accountName">Account Holder Name:</label>
                                <input type="text" id="accountName" name="accountName" value="${user.name}" class="form-control" readonly>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="accountID" value="${accountID}">
                                <label for="amount">Amount to Add:</label>                              
                                <input type="number" id="amount" name="amount" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Add Money</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
       <%
        }
        %>
    <div class="mt-3">
        <a href="http://localhost:8082/MyDigiPurse/logout" class="btn btn-danger btn-sm">Logout</a>
    </div>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Your custom JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/scripts/Script.js"/>" ></script>
</body>
</html>
