<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap Form</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h2 class="text-center mb-4">Registration Form</h2>
				<form action="send" method="post">
					<div class="mb-3">
						<label for="name" class="form-label">Name</label> <input
							type="text" class="form-control" name="name"
							placeholder="Enter your name">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" name="email"
							placeholder="Enter your email">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" name="password"
							placeholder="Enter your password">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>

	<table class="table">
    <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">name</th>
            <th scope="col">email</th>
            <th scope="col">password</th>
             <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="d" items="${list}">
            <tr>
                <td>${d.id}</td>
                <td>${d.name}</td>
                <td>${d.email}</td>
                <td>${d.password}</td>
                <td><a href="delete?id=${d.id}" class="btn btn-danger">delete</a></td>
                <td><a href="edit?id=${d.id}" class="btn btn-danger">edit</a></td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>
	

</body>
</html>
