<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!-- Include necessary CSS and JS files -->
    <%@include file="/WEB-INF/resources/components/alllinks.jsp"%>
</head>
<body>
    <%@include file="/WEB-INF/resources/components/navbar.jsp"%>

    <div class="container p-2 mt-5 p-center">
        <form action="addjob" method="POST">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center text-success">
                                <i class="fas fa-user-friends fa-2x"></i>

                                <c:if test="${not empty succ}">
                                    <div class="alert aleart-success" role="alert">${succ}
                                        <c:remove var="succ" />
                                    </div>
                                </c:if>

                                <h5>Add jobs</h5>
                            </div>

                            <div class="form-group mb-3">
                                <label for="job-title">Enter Title:</label>
                                <input type="text" id="job-title" name="title" required class="form-control">
                            </div>

                            <div class="form-group mb-3">
                                <label for="company-name">Company Name:</label>
                                <input type="text" id="company-name" name="companyname" required class="form-control">
                            </div>

                            <div class="form-group mb-3 d-flex justify-content-between">
                                <div class="form-group me-3">
                                    <label for="job-location">Job Location:</label>
                                    <select id="job-location" class="custom-select form-control" name="location">
                                        <option selected>Choose...</option>
                                        <option value="Pune">Pune</option>
                                        <option value="Mumbai">Mumbai</option>
                                        <option value="Hyderabad">Hyderabad</option>
                                        <option value="Bangalore">Bangalore</option>
                                    </select>
                                </div>

                                <div class="form-group me-3">
                                    <label for="job-category">Category:</label>
                                    <select id="job-category" class="custom-select form-control" name="category">
                                        <option selected>Choose...</option>
                                        <option value="IT">IT</option>
                                        <option value="Developer">Developer</option>
                                        <option value="Banking">Banking</option>
                                        <option value="Engineer">Engineer</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="job-status">Status:</label>
                                    <select id="job-status" class="custom-select form-control" name="status">
                                        <option selected>Choose...</option>
                                        <option value="Active">Active</option>
                                        <option value="Inactive">Inactive</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group mb-3">
                                <label for="job-description">Job Description:</label>
                                <textarea id="job-description" name="description" class="form-control" rows="2" required></textarea>
                            </div>

                            <div class="text-right">
                                <button type="submit" class="btn btn-success mt-1 w-100">Publish</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
