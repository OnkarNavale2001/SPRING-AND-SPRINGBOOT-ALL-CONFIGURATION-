<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/allcomponents/alllinks.jsp"%>
	<%@include file="/allcomponents/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Sign Up</p>
						<c:if test="${not empty mssg}">
							<h4 class="text-center text-success">${mssg}</h4>
							<c:remove var="mess" />
						</c:if>
						<form action="add" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input required
									name="name" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input required
									name="email" type="email" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>
							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>