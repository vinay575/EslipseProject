<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="DTO.StatementDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="DAO.UserDAO"%>
<%@ page import="java.sql.Connection" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Account Statement</title>
     <link rel="stylesheet" type="text/css" href="style.css">
    
</head>
<body>
     <div class="navbar">
        <a href="#" onclick="goBack()">Home</a>
        
        <form action='logout' method="post">
            <a href="logout">Logout</a>
        </form>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>

    <% 
             Connection connection = (Connection) request.getAttribute("dbConnection");
              if (connection == null) {
               throw new RuntimeException("Connection object is null");
     }
        UserDAO dao = new UserDAO(connection);
        // Get the selected bank account number from the request parameter
        String selectedAccountNumber = request.getParameter("selectedAccount");
        //method to get account details by account number   
        StatementDTO statement = dao.getStatementForAccount(selectedAccountNumber);
    %>

    <h1 style="text-align: center">Bank Account Statement for Account Number: <%= selectedAccountNumber %></h1>

    <table class="Statement-table">
        <thead>
            <tr>
                <th>Statement ID</th>
                <th>Transaction Type</th>
                <th>Amount</th>
                <th>Transaction Date</th>
            </tr>
        </thead>
        <tbody>
            <% if (statement != null) { %>
                <tr>
                    <td><%= statement.getStatementId() %></td>
                    <td><%= statement.getTransactionType() %></td>
                    <td><%= statement.getAmount() %></td>
                    <td><%= statement.getTransactionDate() %></td>
                </tr>
            <% } else { %>
                <tr>
                    <td colspan="4">No statements available for the selected account.</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
