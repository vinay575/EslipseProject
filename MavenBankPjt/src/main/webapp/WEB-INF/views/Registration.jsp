<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
                   
                        <form action="Registration" method="post">
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
