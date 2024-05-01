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
	<div class="row mt-5">
		<div class="col-md-4 offset-md-2">
			<div class="card shadow border-0">
				<div class="card-body text-center text-warning">
					<i class="fas fa-user-md fa-5x"></i><br>
					<h3 class="fs-4 text-center">Doctor<br>100</h3>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card shadow border-0">
				<div class="card-body text-center text-primary">
					<i class="fas fa-calendar-check fa-5x"></i><br>
					<h3 class="fs-4 text-center">Total Appoinment<br>50</h3>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>