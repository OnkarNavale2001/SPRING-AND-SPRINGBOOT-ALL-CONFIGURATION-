<%@ include file="/WEB-INF/resources/components/alllinks.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Job Portal</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active" href="index">Home</a></li>
				<c:if test="${userobj == 'Admin'}">
					<li class="nav-item"><a class="nav-link" href="addjobs"><i
							class="fas fa-plus-circle"></i> Post Job</a></li>
					<li class="nav-item"><a class="nav-link" href="viewjobs"><i
							class="fas fa-eye"></i> View Job</a></li>
				</c:if>
				<c:if test="${userobj ne 'Admin' && not empty userobj}">
					<li class="nav-item"><a class="nav-link" href="viewalljobs"><i
							class="fas fa-eye"></i> View Job</a></li>
				</c:if>
			</ul>

			<%-- Display login or logout button based on user login status --%>

			<c:if test="${userobj == 'Admin'}">

				<form class="d-flex">
					<a href="logout" class="btn btn-success me-1">Logout</a> <a
						href="index" class="btn btn-success">${userobj}</a>
				</form>
			</c:if>
			<c:if test="${not empty userobj && userobj != 'Admin'}">

				<form class="d-flex">
					<a href="logout" class="btn btn-success me-1">Logout</a> <a
						href="index" class="btn btn-success">${userobj.name}</a>
				</form>

			</c:if>
			<c:if test="${empty userobj}">
				<form class="d-flex">
					<a href="login" class="btn btn-success me-1">Login</a> <a
						href="reg" class="btn btn-success">Register</a>
				</form>
			</c:if>

		</div>
	</div>
</nav>
