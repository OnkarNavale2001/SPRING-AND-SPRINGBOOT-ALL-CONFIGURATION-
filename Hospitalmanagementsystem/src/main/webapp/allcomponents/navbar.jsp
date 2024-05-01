<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="/"><i
			class="fas fa-house-chimney-medical"></i> RD Hospital</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${not empty adminobj}">

						<li class="nav-item"><a class="nav-link active"
							href="admindash"><i class="fa-solid fa-house-user"></i>Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="adddoctor"><i class="fa-solid fa-user-plus"></i>Add
								Doctor</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="alldoctor"><i class="fa-solid fa-user-doctor"></i>View
								Doctor</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="paitent"><i class="fa-solid fa-hospital-user"></i>Patient</a>
						</li>
						<li class="nav-item"><a class="nav-link active" href=""><i
								class="fa-solid fa-user-tie"></i>Admin</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="adminlogout">Logout</a></li>
					</c:when>
					<c:when test="${not empty doctor}">
						<li class="nav-item"><a class="nav-link active"
							href="doctorhome">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="doctorappointment">View Patient</a></li>
						<li class="nav-item active"><a class="nav-link active"
							href="#"> <i class="fa-solid fa-circle-user"></i>${doctor.fullName}</a>
						</li>
						<li class="nav-item"><a href="doclogout"
							class="nav-link active"><i
								class="fa-solid fa-right-to-bracket "></i>Logout</a></li>

					</c:when>

					<c:when test="${not empty userobj}">
						<li class="nav-item active"><a class="nav-link active"
							href="app">Appointment</a></li>
						<li class="nav-item active"><a class="nav-link active"
							href="viewapp"><i class="fa-regular fa-address-card"></i>View
								Appointment</a></li>
						<li class="nav-item active"><a class="nav-link active"
							href="#"> <i class="fa-solid fa-circle-user"></i>${userobj.name }</a>
						</li>
						<li class="nav-item active"><a class="nav-link active"
							href="userlogout">Logout</a></li>

					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link active"
							href="adminlogin"><i class="fas fa-sign-in-alt"></i> Admin</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="doctorlogin">Doctor</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="userlogin">User</a></li>

					</c:otherwise>



				</c:choose>
			</ul>
		</div>
	</div>
</nav>
