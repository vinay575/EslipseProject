<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom CSS for changing colors */
        /* Change the background color of the form */
        body {
            background-color: #f8f9fa; /* Light gray */
        }

        /* Change the color of the card header */
        .card-header {
            background-color: #007bff; /* Blue */
            color: #ffffff; /* White */
        }

        /* Change the color of the primary button */
        .btn-primary {
            background-color: #007bff; /* Blue */
            border-color: #007bff; /* Blue */
        }

        /* Change the color of the form labels */
        label {
            color: #007bff; /* Blue */
        }

        /* Change the color of the form input fields */
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            border-color: #007bff; /* Blue */
        }

        /* Change the color of the form input fields when focused */
        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="password"]:focus {
            border-color: #0056b3; /* Darker blue */
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25); /* Lighter blue */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h2 class="text-center">Registration</h2>
                    </div>
                    <div class="card-body">
                        <form action="register" method="post">
                            <div class="form-group">
                                <label for="name">Name</label> <input type="text"
                                    class="form-control" id="name" name="name" required>
                            </div>
                            <div class="form-group">
                                <label for="phoneNo">Phone Number</label> <input type="text"
                                    class="form-control" id="phoneNo" name="phoneNo" required>
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label> <input type="text"
                                    class="form-control" id="address" name="address" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label> <input type="email"
                                    class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label> <input type="password"
                                    class="form-control" id="password" name="password" required>
                            </div>
                            <div class="form-group">
                                <label for="confirmPass">Confirm Password</label> <input
                                    type="password" class="form-control" id="confirmPass"
                                    name="confirmPass" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
