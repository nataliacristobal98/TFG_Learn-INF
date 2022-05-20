<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Perfil de Profesor</title>
    <!--Favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/Logo1.png">

    <!--Bootstrap-->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-icons/font/bootstrap-icons.css"
          rel="stylesheet">

    <!--CSS-->
    <link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">
</head>

<body class="d-flex flex-column h-100">


<header>
    <div class="navbar navbar-dark shadow-sm">
        <div class="container">
            <a href="${mvc.basePath}/portada">
                <img src="${pageContext.request.contextPath}/resources/img/Logo2.png" alt=""
                     style="width: 250px;">
            </a>

            <nav class="nav nav-masthead float-md-end text-white">
                <a href="${mvc.basePath}/mundos/mundo"
                   class="nav-link d-none d-md-block d-lg-block">
                    <i class="bi bi-globe2"></i>
                </a>

                <a href="#" class="nav-link active selectedPlace d-none d-md-block d-lg-block">
                    <i class="bi bi-person-workspace"></i>
                </a>

                <a href="${mvc.basePath}/recompensa" class="nav-link d-none d-md-block d-lg-block">
                    <i class="bi bi-trophy"></i>
                </a>


                <a href="${mvc.basePath}/login" type="button"
                   class="buttonCustom buttonOrange mt-2 mx-4 me-2 d-none d-sm-block">Login</a>
                <a href="${mvc.basePath}/signup" type="button"
                   class="buttonCustom buttonMint mt-2 d-none d-sm-block">Sign-up</a>
                <!--<button type="button" class="buttonCustom buttonMint d-none d-lg-block">Sign-up</button>-->



                <div class="collapse" id="navbarToggleExternalContent">
                    <div class="p-4">
                        <button href="${mvc.basePath}/perfil" type="button"
                                class="buttonCustom buttonRed">Perfil</button>
                        <button href="${mvc.basePath}/login" type="button"
                                class="buttonCustom buttonOrange">Login</button>
                        <button href="${mvc.basePath}/signup" type="button"
                                class="buttonCustom buttonMint">Sign-up</button>
                    </div>
                </div>
                <nav class="navbar navbar-light d-sm-none text-end">
                    <div class="container-fluid">
                        <button class="navbar-toggler buttonMenu" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarToggleExternalContent"
                                aria-controls="navbarToggleExternalContent" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                    </div>
                </nav>

            </nav>
        </div>
    </div>
</header>
<main>
    <section class="container mt-4">
        <div class="row">
            <figure class="figure text-center col-xl-5 col-md-8 col-sx-10 mx-auto mb-0">
                <img src="${pageContext.request.contextPath}/resources/img/Perfil.png" class="figure-img img-fluid w-50">
            </figure>
        </div>
    </section>

    <section class="py-5 pt-0 container">
        <div class="row">
            <div class="col-xl-6 col-md-11 col-xs-12 mx-auto bgLearn">

                <section class="container boderProfile">

                    <h3 class="text-black text-center mb-3 mt-3"> Perfil de profesor</h3>

                    <div class="row">

                        <div class="col-xl-7 col-md-7 col-sm-12 px-5">
                            <h6>${profesor.nombre}</h6>
                            <p class="fw-bold text-black-50 m-0">Código</p>
                            <p class="fw-bold text-white m-0">${profesor.codigoProfesor}</p>
                            <p class="fw-bold text-black-50 m-0">Correo</p>
                            <p class="fw-bold text-white m-0">${profesor.correo}</p>

                            <c:forEach var="alumno" items="${listadoAlumnos}">
                                <p>${alumno.nombre}</p><span><button type="button" class="buttonCustom buttonBrown p-2 mb-2 ms-4" onclick="modalProducto('${alumno.nombre}', '${alumno.icono}' )" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    Ver Alumno
                                </button></span>
                            </c:forEach>

                        </div>
                    </div>

                    <div class="row">
                        <div class="text-center">
                            <a href="${mvc.basePath}/mundos/mundo" type="button" class="buttonCustom buttonMint m-4 mt-xl-0 mt-sm-3">Ir a Mundos</a>
                            <a href="${mvc.basePath}/profesor/cerrar" type="button" class="buttonCustom buttonRed m-4 mt-0">Cerrar sesión</a>
                        </div>
                    </div>


                </section>

            </div>
        </div>
    </section>

</main>

<!-- Modal dinámico -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="tituloModal"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <img id="imagenModal" alt="" style="width: 100%;">
            </div>
        </div>
    </div>
</div>

<footer class="footer mt-auto py-3 text-white">
    <div class="container">


        <div class="row">
            <div class="col-xl-12 col-md-12 text-center mt-3">
                <h5>Acerca de Learn-INF</h5>
                <p>“Learn-INF” consiste en una web interactiva para niños con el objetivo de que aprendan los
                    principios básicos de la programación.
                    Con una dinámica parecida a un videojuego de preguntas y respuestas, pero con logros y un diseño
                    dinámico para ellos.
                    El nombre es una combinación de la palabra “Learn”, cuyo significado es aprender en inglés, y de
                    la abreviatura “INF”,
                    la cual procede de INFormation.</p>

                <div class="text-center gap-2">
                    <a href="#" class="mx-1">
                        <i class="bi bi-discord socialMedia"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-instagram socialMedia"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-pinterest socialMedia"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-twitter socialMedia"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-youtube socialMedia"></i>
                    </a>
                </div>

            </div>
        </div>


        <div class="d-flex justify-content-between pt-4 my-4 border-top">
            <p>© 2022 Learn-INF. All rights reserved.</p>
        </div>
    </div>
</footer>
</body>

<!--JavaScript-->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<script>
    function modalProducto(nombre, imagen){
        let titulo = document.getElementById("tituloModal");
        titulo.innerHTML = nombre;

        let imagenModal = document.getElementById("imagenModal");
        imagenModal.src = imagen;
    }
</script>

</html>