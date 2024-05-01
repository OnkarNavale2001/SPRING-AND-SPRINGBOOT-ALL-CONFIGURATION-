<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Food Item Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<style>
.navbar {
    background-color: #F33A6A;
}

.bg {
    background: #F33A6A;
}

input[type="text"], input[type="url"] {
    height: 60px;
    border: 0px;
    border-bottom: 2px solid white;
    background: gray;
    cursor: pointer;
    color: white;
}

textarea {
    height: 80px;
    background: gray;
    cursor: pointer;
    color: white;
}

input[placeholder] {
    font-size: 20px;
}
.card-text {
    font-size: 12px;
}
</style>
</head>
<body class="bg-dark">
    <nav class="navbar ">
        <div class="container-fluid">
            <a class="navbar-brand text-white">Recipe Share Hub</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>

    <button type="button" class="btn  rounded-circle position-fixed bg bottom-0 end-0 m-3" data-bs-toggle="modal"
        data-bs-target="#exampleModal">
        <i class="fas fa-plus text-white"></i>
    </button>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content bg-dark ">
                <div class="d-flex justify-content-end me-2">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="submit" method="POST">
                        <div class="mb-1">
                            <input type="text" id="title" placeholder="Title" name="title" class="w-100 text-white"
                                required>
                        </div>

                        <div class="mb-1">
                            <textarea id="description" name="description" placeholder="Description" class="w-100"
                                required></textarea>
                        </div>

                        <div class="mb-1">
                            <label class="form-label"></label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="vegetarian-modal" name="type"
                                    value="vegetarian" required>
                                <label class="form-check-label text-secondary" for="vegetarian-modal">Vegetarian</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="nonvegetarian-modal" name="type"
                                    value="non-vegetarian">
                                <label class="form-check-label text-secondary" for="nonvegetarian-modal">Non-Vegetarian</label>
                            </div>
                        </div>

                        <div class="mb-1">
                            <input type="url" id="image" name="image" placeholder="Image URL" class="w-100"
                                required>
                        </div>

                        <button type="submit" class="btn bg text-white">Create</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="row row-cols-1 ms-1 mt-3 row-cols-sm-2 row-cols-md-3 row-cols-lg-5">
        <c:forEach var="recipe" items="${model}">
            <div class="col">
                <div class="card  mb-3  border-1 border-light" style="width: 16rem;">
                    <img src="${recipe.image}" class="card-img-top" height="200px" alt="...">
                    <div class="card-body bg-dark">
                        <h6 class="card-title text-white">${recipe.title}</h6>
                        <p class="card-text text-white mt-1 mb-3">${recipe.description}</p>
                        <a href="deletedata?id=${recipe.id}" class="fs-6 text-secondary"><i
                                class="fa-solid fa-trash"></i></a>
                        <a data-bs-toggle="modal" data-bs-target="#exampleModal1-${recipe.id}"
                            class="text-secondary cursor-pointer fs-6"><i class="fa-solid fa-pencil float-end "></i></a>
                        <div class="modal fade" id="exampleModal1-${recipe.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
                            aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content bg-dark">
                                    <div class="d-flex justify-content-end me-2">
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="update" method="POST">
                                            <input type="hidden" id="id" value="${recipe.id}" name="id"
                                                class="form-control" required>
                                            <div class="mb-1">
                                                <input type="text" id="title" value="${recipe.title}"
                                                    placeholder="Title" name="title" class="w-100" required>
                                            </div>

                                            <div class="mb-1">
                                                <textarea id="description" name="description"
                                                    placeholder="Description" class="w-100"
                                                    required>${recipe.description}</textarea>
                                            </div>

                                            <div class="mb-1">
                                                <label class="form-label"></label>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" id="vegetarian-modal"
                                                        name="type" value="vegetarian"
                                                        ${recipe.type == 'vegetarian' ? 'checked' : ''} required>
                                                    <label class="form-check-label text-secondary"
                                                        for="vegetarian-modal">Vegetarian</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" id="nonvegetarian-modal"
                                                        name="type" value="non-vegetarian"
                                                        ${recipe.type == 'non-vegetarian' ? 'checked' : ''} required>
                                                    <label class="form-check-label text-secondary"
                                                        for="nonvegetarian-modal">Non-Vegetarian</label>
                                                </div>
                                            </div>

                                            <div class="mb-1">
                                                <input type="url" id="image" name="image" placeholder="Image URL"
                                                    value="${recipe.image }" class="w-100" required>
                                            </div>

                                            <button type="submit" class="btn bg text-white">Update</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
