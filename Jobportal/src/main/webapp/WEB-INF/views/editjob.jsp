<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/resources/components/alllinks.jsp"%>
	<%@include file="/WEB-INF/resources/components/navbar.jsp"%>

	<div class="container p-2 mt-5 p-center">
		<form action="updatejob" method="POST">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-body">
							<div class="text-center text-success">
								<i class="fas fa-user-friends fa-2x"></i>



								<h5>Update jobs</h5>
							</div>

							<div class="form-group mb-3">
								<input type="hidden" value="${j.id}" name="id"> <label
									for="job-title">Enter Title:</label> <input type="text"
									id="job-title" name="title" value="${j.title}" required
									class="form-control">
							</div>

							<div class="form-group mb-3">
								<label for="company-name">Company Name:</label> <input
									type="text" id="company-name" name="companyname"
									value="${j.companyname}" required class="form-control">
							</div>

							<div class="form-group mb-3 d-flex justify-content-between">
								<div class="form-group me-3">
									<label for="job-location">Job Location:</label> <select
										id="job-location" class="custom-select form-control"
										name="location">
										<option value="${j.location}">${j.location}</option>
										<option value="Pune">Pune</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Hyderabad">Hyderabad</option>
										<option value="Bangalore">Bangalore</option>
									</select>
								</div>

								<div class="form-group me-3">
									<label for="job-category">Category:</label> <select
										id="job-category" class="custom-select form-control"
										name="category">
										<option value="${j.category}">${j.category}</option>

										<option value="IT">IT</option>
										<option value="Developer">Developer</option>
										<option value="Banking">Banking</option>
										<option value="Engineer">Engineer</option>
									</select>
								</div>

								<div class="form-group">
									<label for="job-status">Status:</label> <select id="job-status"
										class="custom-select form-control" name="status">
										<option value="${j.status}">${j.status}</option>

										<option value="Active">Active</option>
										<option value="Inactive">Inactive</option>
									</select>
								</div>
							</div>

							<div class="form-group mb-3">
								<label for="job-description">Job Description:</label>
								<textarea id="job-description" name="description"
									class="form-control" rows="2" required>${j.description}</textarea>
							</div>

							<div class="text-right">
								<button type="submit" class="btn btn-success mt-1 w-100">Update</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
