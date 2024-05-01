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
<h3 class="text-center fs-3">Admin DashBoard</h3>



<div class="container p-5 mt-5">
    <div class="row">
        <div class="col-md-4">
            <div class="card  shadow text-center text-white" style="height: 220px;">
                <div class="card-body">
                    <i class="fas fa-user-md text-success fa-5x"></i><br>
                    <h3 class="fs-4 text-success">Doctor</h3>
                    <h4 class="fs-4 text-success">${list11}</h4>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card  shadow text-center text-white" style="height: 220px;">
                <div class="card-body">
                    <i class="fas fa-calendar-check text-primary fa-5x"></i><br>
                    <h3 class="fs-4 text-primary">Total Appointment</h3>
                    <h4 class="fs-4 text-primary" >${applist}</h4>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card  shadow text-center text-white " style="height: 220px;">
                <div class="card-body ">
                    <i class="fas  fa-user-circle text-danger fa-5x"></i><br>
                    <h3 class="fs-4 text-danger">Total User</h3>
                    <h4 class="fs-4 text-danger">${uslist}</h4>
                </div>
            </div>
        </div>
        <div class="col-md-4 mt-2">
            <div class="card  text-center shadow text-white" style="height: 220px;" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <div class="card-body" >
                    <i class="fas fa-calendar-check text-warning fa-5x"></i><br>
                    <h3 class="fs-4 text-warning">Total Specialist Available</h3>
                    <h4 class="fs-4 text-warning">${spsize}</h4>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Specialist</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="addspe" method="post">
                    <div class="form-group">
                        <label for="specName">Enter Specialist Name</label>
                        <input type="text" name="specialistName" id="specName" class="form-control">
                    </div>
                    <div class="text-center mt-4">
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>