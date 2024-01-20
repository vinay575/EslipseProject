<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="DTO.UserDTO"%>
<%@ page import="DTO.AccountDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="DAO.UserDAO"%>
<%@ page import="java.sql.Connection" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Dash board</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="navbar">
        <a href="#">Home</a>
        
        <form action='logout' method="post">
            <a href="logout">Logout</a>
        </form>
    </div>


    <% UserDTO user = (UserDTO) session.getAttribute("user"); %>
    <h1 style="text-align: center">
        <%= user.getName().toUpperCase() %>'s Dashboard
    </h1>

    <div class="user-table">
        <p>User Details</p>
        <table>
            <tr>
                <td>Phone Number:</td>
                <td><%= user.getPhoneNo() %></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><%= user.getEmail() %></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><%= user.getAddress() %></td>
            </tr>
        </table>
    </div>
    
   <form action='StatementServlet' method="post">
        <% 
            Connection connection = (Connection) request.getAttribute("dbConnection");
            if (connection == null) {
                throw new RuntimeException("Connection object is null");
            }

            UserDAO dao = new UserDAO(connection);
            List<AccountDTO> acctList = dao.getAccountDetails(user.getId());
        %>

        <table class="Bank-table">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Account Number</th>
                    <th>IFSC Code</th>
                    <th>Bank Name</th>
                    <th>Account Type</th>
                    <th>Current Balance</th>
                    <th>Last Transaction Date</th>
                </tr>
            </thead>
            <tbody>
                <% for (AccountDTO acct : acctList) { %>
                    <tr>
                        <td><input type="radio" name="selectedAccount" value="<%= acct.getAccountNumber() %>"></td>
                        <td><%= acct.getAccountNumber() %></td>
                        <td><%= acct.getIfscCode() %></td>
                        <td><%= acct.getBankName() %></td>
                        <td><%= acct.getAcctType() %></td>
                        <td><%= acct.getCurrBalance() %></td>
                        <td>last_txn_date</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        <div class="Button">
            <input type="submit" value="Get Statement">
        </div>
    </form>
</body>
</html>
