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
	 <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h5 class="text-center text-primary">All Jobs</h5>
                <c:forEach items="${list1}" var="j">
                    <div class="card mt-2">
                        <div class="card-body border ml-3">
                            <div class="text-center text-primary">
                                <i class="far fa-clipboard display-4"></i>
                            </div>
                            <h6>Job Title: ${j.title}</h6>
                            <p class="mt-1">${j.description}</p>
                            <div class="row">
                                <div class="col-md-3">
                                    <input type="text" value="${j.companyname}" class="form-control" readonly>
                                </div>
                                <div class="col-md-3">
                                    <input type="text" value="${j.location}" class="form-control" readonly>
                                </div>
                                <div class="col-md-3">
                                    <input type="text" value="${j.category}" class="form-control" readonly>
                                </div>
                                <div class="col-md-3">
                                    <input type="text" value="${j.status}" class="form-control" readonly>
                                </div>
                            </div>
                            <h6>Public Date: <c:out value="${j.pdate}" /></h6>
                            <div class="text-center pb-4">
                                <a href="editjobs?id=${j.id}" class="btn btn-sm btn-success text-white">Edit</a>
                                <a href="delete?id=${j.id}" class="btn btn-sm btn-danger text-white">Delete</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>