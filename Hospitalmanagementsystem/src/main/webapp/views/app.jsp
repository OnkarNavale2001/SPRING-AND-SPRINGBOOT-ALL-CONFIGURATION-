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
<c:if test="${empty userobj }">
    <c:redirect url="userlogin"></c:redirect>
</c:if>
	<div class="container-fluid backImg p-5">
		<h5 class="text-center fs-2 text-white"></h5>
	</div>

    	<%----  <c:if test="${not empty errorMsg}">
                        <h5 class="text-center text-danger fs-3">${errorMsg}</h5>
                        <c:remove var="errorMsg" scope="session"/>
                     <c:if test="${not empty succMsg}">
                        <h5 class="text-center text-danger fs-3">${succMsg}</h5>
                        <c:remove var="succMsg" scope="session"/>
                    </c:if>
                   
                    </c:if> --%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img alt="" src="img/docter.png">
			</div>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<h4 class="text-center fs-3">User Appointment</h4>




						<form class="row " action="addapoint" method="post">
							<input type="hidden" name="userid" value="${userobj.id }">

							<div class="col-md-6">
								<label class="form-label">Full Name</label> <input required
									name="FullName" type="text" class="form-control">
							</div>
							<div class="col-md-6">
								<label class="form-label">Gender</label> <select
									class="form-control" name="gender" required>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>
							<div class="col-md-6">
								<label class="form-label">Age</label> <input required name="age"
									type="number" class="form-control">
							</div>
							<div class="col-md-6">
								<label class="form-label">Appointment Date</label> <input
									required name="appoinDate" type="date" class="form-control">
							</div>
							<div class="col-md-6">
								<label class="form-label">Email</label> <input required
									name="email" type="email" class="form-control">
							</div>
							<div class="col-md-6">
								<label class="form-label">Phone No</label> <input required
									maxlength="10" name="phno" type="number" class="form-control">
							</div>
							<div class="col-md-6">
								<label class="form-label">Diseases</label> <input required
									name="diseases" type="text" class="form-control">
							</div>
							<div class="col-md-6">
								<label class="form-label">Doctor</label> <select
									class="form-control" name="doctorid" required>
									<option value="">--select--</option>
									<c:forEach var="doctor" items="${doctorList}">
										<option value="${doctor.id}">${doctor.fullName}
											(${doctor.specialist})</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-12">
								<label class="form-label">Full Address</label>
								<textarea required name="address" class="form-control" rows="3"
									cols="4"></textarea>
							</div>


							<button class="col-md-6 offset-md-3 mt-4 btn btn-success">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>