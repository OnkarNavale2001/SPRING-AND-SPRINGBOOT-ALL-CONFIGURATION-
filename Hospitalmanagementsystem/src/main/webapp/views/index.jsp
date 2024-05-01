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
	
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
    <ol class="carousel-indicators">
        <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></li>
        <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
        <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/build.jpg" class="d-block w-100" alt="First slide" height="400px">
        </div>
        <div class="carousel-item">
            <img src="img/dtn1.jpg" class="d-block w-100" alt="Second slide" height="400px">
        </div>
        <div class="carousel-item">
            <img src="img/dtn2.jpg" class="d-block w-100" alt="Third slide" height="400px">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<div class="container p-3">
    <h4 class="text-center fs-2">Key Features of our Hospital</h4>
    <div class="row">
        <div class="col-md-8 p-5">
            <div class="row">
                <div class="col-md-6">
                    <div class="card point-card">
                        <div class="card-body">
                            <p class="fs-5">100% Safety</p>
                            <p>Providing Quality Healthcare: One of the primary goals of hospitals is to deliver high-quality healthcare services to patients. This involves ensuring accurate diagnosis, effective treatment, and compassionate care</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card point-card">
                        <div class="card-body">
                            <p class="fs-5">Clean Environment</p>
                            <p>Maintaining a clean environment helps keep diseases away and fosters growth and development of children.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 mt-4">
                    <div class="card point-card">
                        <div class="card-body">
                            <p class="fs-5">Friendly Doctors</p>
                            <p>Doctors build friendly relations with patients to make them comfortable. Doctors always have to be alert on their duty. Doctors cannot afford to make any single mistake, because one of their mistakes can lose patient life.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card point-card">
                        <div class="card-body">
                            <p class="fs-5">Medical Research</p>
                            <p>Medical research also known as health research, refers to the process of using scientific methods with the aim to produce knowledge about human diseases, the prevention and treatment of illness, and the promotion of health.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <img src="img/docter.png" alt="">
        </div>
    </div>
</div>

<hr>

<div class="container p-2">
    <h4 class="text-center fs-2">Our Team</h4>
    <div class="row">
        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/new4.jpeg" width="250px" height="300px" alt="">
                    <p class="fw-bold fs-5">Raj Dongari</p>
                    <p class="fs-7">(CEO & Chairman)</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/docto2.png" width="250px" height="300px" alt="">
                    <p class="fw-bold fs-5">Dr. Purva Zapke</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/doctor3.png" width="250px" height="300px" alt="">
                    <p class="fw-bold fs-5">Dr. Sumedh Kedari</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/doctor4.jpeg" width="250px" height="300px" alt="">
                    <p class="fw-bold fs-5">Dr. Smiti</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>