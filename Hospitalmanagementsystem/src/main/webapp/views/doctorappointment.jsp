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
	<c:if test="${empty doctor}">
		<c:redirect url="doctorlogin"></c:redirect>
	</c:if>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<h2 class="fs-3 text-center">Patient Details</h2>
						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-danger fs-3">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<h5 class="text-center text-danger fs-3">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Email</th>
									<th scope="col">Mobile No</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
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
										<td><c:out value="${appointment.phno}" /></td>

										<c:choose>
											<c:when test="${appointment.status eq 'Pending'}">
												<td><a href="#" class="btn btn-sm btn-warning">Pending</a></td>
											</c:when>
											<c:otherwise>
												<td>${appointment.status}</td>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${appointment.status eq 'Pending'}">
												<td><a href="comment?id=${appointment.id}"
													class="btn btn-sm btn-success">comment</a></td>
											</c:when>
											<c:otherwise>
												<td><a href="#" class="btn btn-sm btn-success disabled">comment</a></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>