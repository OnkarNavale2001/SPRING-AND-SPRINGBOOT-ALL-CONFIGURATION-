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
	<c:if test="${empty adminobj }">
    <c:redirect url="adminlogin"></c:redirect>
</c:if>
	<div class="container">
		<div class="col-md-5 offset-md-4 ">

			<div class="card border-0 shadow paint-card">
				<div class="card-body">
					<c:if test="${not empty succ}">
						<h5 class="text-center text-success">${succ}</h5>
						<c:remove var="succ" scope="session" />
					</c:if>

					<h4 class="text-center">Add Doctor Details</h4>
					<form action="adddoc" method="post">
						<div class="mt-2">
							<label for="exampleInputEmail1">Full Name*</label> <input
								name="fullName" type="text" class="form-control">
						</div>

						<div class="form-group mt-2">
							<label for="exampleInputEmail1">DOB*</label> <input name="dob"
								type="date" class="form-control">
						</div>

						<div class="form-group mt-2">
							<label for="exampleInputEmail1">Qualification</label> <input
								name="qualification" type="text" class="form-control">
						</div>

						<div class="form-group mt-2">
							<label for="exampleInputEmail1">Specialist</label> <select
								id="inputState" name="specialist" class="form-control">
								<option>---Select---</option>
								<c:forEach var="s" items="${list}">
									<option>${s.getSpecialistName()}</option>
								</c:forEach>

							</select>
						</div>
						<div class="form-group mt-2">
							<label for="exampleInputEmail1">Email</label> <input required
								name="email" type="email" class="form-control">
						</div>
						<div class="form-group mt-2">
							<label for="exampleInputEmail1">Mobile Number*</label> <input
								name="mobno" type="number" class="form-control">
						</div>
						<div class="form-group mt-2">
							<label for="exampleInputEmail1">Password</label> <input
								name="password" type="password" class="form-control">
						</div>
						<button type="submit" class="btn btn-success w-100 mt-1">Add</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	</div>
</body>
</html>