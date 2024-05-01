<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital_logo.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="/allcomponents/alllinks.jsp"%>
	<%@include file="/allcomponents/navbar.jsp"%>
		<c:if test="${empty doctor}">
    <c:redirect url="doctorlogin"></c:redirect>
</c:if>
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<div class="card paint-body">
				<div class="card-body">
					<h3 class="text-center fs-4">Patient Comment</h3>



					<form action="comm" method="post" class="row">
						<div class="col-md-6">
							<label>Patient Name</label><input type="text" readonly="readonly"
								value="${ap.getFullName()}"  name="FullName" class="form-control">
								



						</div>

						<div class="col-md-6">
							<label>Age</label><input type="text" readonly
								value="${ap.getAge()}" name="age" class="form-control">
						</div>

						<div class="col-md-6">
							<br> <label class="form-label">Mobile No</label><input
								type="text" readonly name="phno" value="${ap.phno}"
								class="form-control">
						</div>

						<div class="col-md-6">
							<br> <label class="form-label">diseases</label><input
								type="text" readonly name="diseases" value="${ap.diseases}"
								class="form-control">
						</div>

						<div class="col-md-12">
							<br>
							<label>Comment</label>
							<textarea required name="status" rows="3" cols=""
								class="form-control"></textarea>
						</div>
						<input type="hidden" name="id" value="${ap.id}"> 
						<input type="hidden" name="userid" value="${ap.userid}">
						 <input type="hidden" name="gender" value="${ap.gender}"> 
						  <input type="hidden" name="email" value="${ap.email}"> 
						<input type="hidden" name="doctorid" value="${ap.doctorid}">
				        <input type="hidden" name="appoinDate" value="${ap.appoinDate}">
						
						 <input type="hidden" name="address" value="${ap.address}"> 
						<button class="mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	
</body>
</html>