<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="DTO.UserDTO"%>
<%@ page import="DAO.BankDAO"%>
<%@ page import="DTO.AccountDTO "%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Dash-board</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
    
</head>
<body>
<div  class="navbar">
        <a href="#">Home_page</a>
        <form action='logout' method="post">
            <a href="logout">Logout</a>
        </form>
    </div>


    <%UserDTO user = (UserDTO) session.getAttribute("user"); %>
	<h1 style="text-align: center">
		<% out.print(user.getName().toUpperCase()); %>'s Dash-board
	</h1>
	
	
	<div class="user-table">
	<p >User Details</p>
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
	
	
     
 
</body>

</html>
