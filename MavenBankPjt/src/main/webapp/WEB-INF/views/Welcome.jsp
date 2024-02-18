<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.entity.UserDTO"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
    <script>
    function requestlogout() {
    	window.location.href = "logout.jsp";
    }
    function validateAndRedirect(action) {
                var selectedAccount = document.querySelector('input[name="selectedAccount"]:checked');
                if (!selectedAccount) {
                    alert("Please select an account before proceeding.");
                    return false;
                }
                // Add logic to set the action parameter and submit the form
                document.getElementById('selectedAction').value = action;
                document.getElementById('accountForm').submit();
                return true;
            
      }</script>
</head>
<body>
    <form id="accountForm" action="Process" method="post">
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
                <p>Phone Number: ${user.phoneNo}</p>
                <p>Email: ${user.email }</p>
                <p>Address: ${user.address }</p>
            </div>

            <div class="accountsList mt-5">
                <a href="AddAccount" class="btn btn-primary float-right">Add
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
                <button type="button" class="btn btn-primary" onclick="validateAndRedirect('Statement')">Statement</button>
                <button type="button" class="btn btn-primary" onclick="validateAndRedirect('AddMoney')">Add Money</button>
                <button type="button" class="btn btn-primary" onclick="validateAndRedirect('SendMoney')">Send Money</button>
            </div>
            

        </div>
        <%
        }
        %>
    </form>
    <div class="container mt-3">
        <a href="logout.jsp" class="btn btn-danger">Logout</a>
    </div>
</body>
</html>
