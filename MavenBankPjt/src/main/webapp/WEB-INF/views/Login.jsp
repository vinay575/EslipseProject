<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="conatiner p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center">
						<h3>Login Page</h3>

					</div>
					<div class="card-body">
						<form action="Login" method="post">

							<div class="mb-3">
								<label>Enter User Name</label> <input type="text"
									name="username" class="form-control">
							</div>


							<div class="mb-3">
								<label>Enter Password</label> <input type="text" name="password"
									class="form-control">
							</div>

							<button class="btn btn-primary col-md-12">Login</button>
						</form>
						<form action="Registration">

							<h5>New user Register Here</h5>
							<button class="btn btn-primary col-md-12">Register</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>