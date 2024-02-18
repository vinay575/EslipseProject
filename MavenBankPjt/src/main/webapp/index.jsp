<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false" %>
<%@ page import="com.entity.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>	
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("Login");
	} else {}
	%>
</body>
</html>