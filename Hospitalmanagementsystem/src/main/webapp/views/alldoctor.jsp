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
	<div class="col-md-12">
    <div class="card shadow">
        <div class="card-body">
           <c:if test="${not empty succ}">
                <h5 class="text-center text-success">${succ}</h5>
                <c:remove var="succ" scope="session"/>
            </c:if>
           
            <h4 class="fs-3 text-center">Doctor Details</h4>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Full Name</th>
                        <th scope="col">DOB</th>
                        <th scope="col">Qualification</th>
                        <th scope="col">Specialist</th>
                        <th scope="col">Email</th>
                        <th scope="col">Mob no</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                  
                    <c:forEach var="d" items="${list11}">
                        <tr>
                            <td>${d.fullName}</td>
                            <td>${d.dob}</td>
                            <td>${d.qualification}</td>
                            <td>${d.specialist}</td>
                            <td>${d.email}</td>
                            <td>${d.mobno}</td>
            	<td>
				<a href="editdoctor?id=${d.id}" class="btn btn-sm btn-primary">Edit</a>
				<a href="deletedoctor?id=${d.id}" class="btn btn-sm btn-danger">Delete</a>
				</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>