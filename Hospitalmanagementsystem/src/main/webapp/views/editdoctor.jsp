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
	<div class="container-fluid p-3">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card border-0 shadow">
                    <div class="card-body">
                        <h4 class="text-center mb-2">Edit Doctor</h4>
                        <form action="updatedoctor" method="post">
                            <input type="hidden" name="id" value="${d.id}">
                            <div class="mb-2">
                                <label for="fullName" class="form-label">Full Name*</label>
                                <input name="fullName" type="text" class="form-control" id="fullName" value="${d.fullName}">
                            </div>

                            <div class="mb-2">
                                <label for="dob" class="form-label">DOB*</label>
                                <input name="dob" type="date" class="form-control" id="dob" value="${d.dob}">
                            </div>

                            <div class="mb-2">
                                <label for="qualification" class="form-label">Qualification</label>
                                <input name="qualification" type="text" class="form-control" id="qualification" value="${d.qualification}">
                            </div>

                            <div class="mb-2">
                                <label for="specialist" class="form-label">Specialist</label>
                                <select id="specialist" name="specialist" class="form-select">
                                    <option selected >${d.specialist}</option>
                                    <c:forEach var="s" items="${list}">
                                        <option><c:out value="${s.specialistName}" /></option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="mb-2">
                                <label for="email" class="form-label">Email*</label>
                                <input required name="email" type="email" class="form-control" id="email" value="${d.email}">
                            </div>

                            <div class="mb-2">
                                <label for="mobno" class="form-label">Mobno*</label>
                                <input name="mobno" type="number" class="form-control" id="mobno" value="${d.mobno}">
                            </div>

                            <div class="mb-2">
                                <label for="password" class="form-label">Password</label>
                                <input name="password" type="password" class="form-control" id="password" value="${d.password}">
                            </div>

                            <button type="submit" class="btn btn-success w-100 mt-1">Update</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>