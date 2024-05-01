<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/resources/components/alllinks.jsp" %>
<%@include file="/WEB-INF/resources/components/navbar.jsp" %>

<div class="container d-flex justify-content-center align-items-center" style="height: 90vh;">
    <div class="card text-center border-0 shadow" style="width: 20rem;">
        <form action="logindata" method="POST" class="card-body">
            <h2 class="card-title mb-4">Login</h2>
            <c:if test="${not empty mess}">
					<h6 class="text-center text-danger">${mess}</h6>
					<c:remove var="mess" />
				</c:if>
            <div class="mb-3">
                <label for="email" class="form-label visually-hidden">Email:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label visually-hidden">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Login</button>
            <div class="mt-3">
                <p>Don't have an account? <a href="reg">Sign Up</a></p>
            </div>
        </form>
    </div>
</body>
</html>