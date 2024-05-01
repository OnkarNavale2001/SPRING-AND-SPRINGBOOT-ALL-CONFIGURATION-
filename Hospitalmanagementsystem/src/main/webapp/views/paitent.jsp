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
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card border-0 shadow">
					<div class="card-body">
						<h2 class="fs-3 text-center">Patient Details</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">Full Name</th>
										<th scope="col">Gender</th>
										<th scope="col">Age</th>
										<th scope="col">Appointment Date</th>
										<th scope="col">Diseases</th>
										<th scope="col">Email</th>
										<th scope="col">Doctor Name</th>
										<th scope="col">Address</th>
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
											<td><c:out value="${appointment.email}" /></td>
											<td><c:out
													value="${doctorMap[appointment.doctorid].fullName}" /></td>
											<td><c:out value="${appointment.address}" /></td>
											<td><c:out value="${appointment.status}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>