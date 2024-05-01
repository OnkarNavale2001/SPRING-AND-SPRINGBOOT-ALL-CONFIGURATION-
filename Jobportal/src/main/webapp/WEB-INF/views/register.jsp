<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration</title>
</head>
<body>

	<%@include file="/WEB-INF/resources/components/alllinks.jsp"%>
	<%@include file="/WEB-INF/resources/components/navbar.jsp"%>

	<div class="container d-flex justify-content-center align-items-center"
		style="height: 90vh;">
		<div class="card" style="width: 35%;">
			<div class="card-body">
				<h5 class="card-title text-center">Registration</h5>
				<c:if test="${not empty succ}">
					<h4 class="text-center text-success">${succ}</h4>
					<c:remove var="succ" />
				</c:if>
				<form action="adddata" method="post">
					<div class="mb-3">
						<label for="name" class="form-label">Name:</label> <input
							type="text" class="form-control" id="name"
							placeholder="Enter your name" name="name">
					</div>
					<div class="mb-3">
						<label for="qualification" class="form-label">Qualification:</label>
						<input type="text" class="form-control" id="qualification"
							placeholder="Enter your qualification" name="qualification">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email:</label> <input
							type="email" class="form-control" id="email"
							placeholder="Enter your email" name="email">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password:</label> <input
							type="password" class="form-control" id="password"
							placeholder="Enter your password" name="password"> <input
							type="hidden" class="form-control" value="user"
							placeholder="Enter your password" name="role">

					</div>
					<button type="submit" class="btn btn-primary w-100">Sign
						Up</button>
					<p class="login-link text-center mt-2">
						Already have an account? <a href="login">Login</a>
					</p>
				</form>
			</div>
		</div>
	</div>

</body>
</html>

