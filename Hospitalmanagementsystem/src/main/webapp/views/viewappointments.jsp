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
	<div class="container-fluid backImg">
		<h5 class="text-center fs-2 text-white"></h5>
	</div>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-8 ">
				<div class="card paint-card">
					<div class="card-body">
						<h5 class="fs-4 fw-bold text-center text-success">Appointment
							List</h5>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>
								</tr>

							</thead>
							<tbody>
								<c:forEach var="appointment" items="${appointments}">
									<tr>
										<td><c:out value="${appointment.fullName}" /></td>
										<td><c:out value="${appointment.gender}" /></td>
										<td><c:out value="${appointment.age}" /></td>
										<td><c:out value="${appointment.appoinDate}" /></td>
										<td><c:out value="${appointment.diseases}" /></td>
										<td><c:out
												value="${doctorMap[appointment.doctorid].fullName}" /></td>

										<c:choose>
											<c:when test="${appointment.status eq 'Pending'}">
												<td><a href="#" class="btn btn-sm btn-warning">Pending</a></td>
											</c:when>
											<c:otherwise>
												<td>${appointment.status}</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>


							</tbody>
						</table>
					</div>

				</div>
			</div>
			<div class="col-md-3 p-3">
				<img alt="" width="400px" height="450px" src="img/docto2.png">
			</div>
		</div>
	</div>
</body>
</html>