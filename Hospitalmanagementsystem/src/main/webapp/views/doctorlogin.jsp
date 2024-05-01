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
						<h3 class="fs-4 text-center">Doctor Login</h3>
				
						<c:if test="${not empty mess}">
						<h5 class="text-center text-danger fs-3">${mess}</h5>
					<c:remove var="mess" scope="session"/>
					</c:if>
						<form action="doctorlog" method="post">
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input required
									name="email" type="email" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>
							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>