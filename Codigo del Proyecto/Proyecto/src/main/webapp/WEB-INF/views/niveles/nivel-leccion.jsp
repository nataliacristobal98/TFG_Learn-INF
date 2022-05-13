<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>8 - Test</title>
    <!--Favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/Logo1.png">

    <!--Bootstrap, JavaScript-->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-icons/font/bootstrap-icons.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

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
                <a href="${mvc.basePath}/mundos/mundo" class="nav-link active selectedPlace d-none d-md-block d-lg-block">
                    <i class="bi bi-globe2"></i>
                </a>

                <a href="${mvc.basePath}/perfil" class="nav-link d-none d-md-block d-lg-block">
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
                <img src="img/Login3.png" class="figure-img img-fluid">
            </figure>
        </div>
    </section>

    <section class="py-5 pt-0 container">
        <div class="row">
            <div class="col-xl-12 col-md-11 col-xs-12 mx-auto bgLearn3">

                <section class="container">
                    <div class="row">
                        <div class="col-xl-12 col-md-11 col-sx-11mb-3 p-5 bgLearn2 text-center">
                            <h2>${leccion.tituloLeccion}</h2>

                            <p class="text-start fs-5">
                                ${leccion.contenido1}
                            </p>

                            <figure class="figure text-center col-xl-5 col-md-8 col-sx-10 mx-auto mb-0">
                                <img src="${leccion.imagenLeccion}" class="figure-img img-fluid">
                            </figure>

                            <p class="text-start fs-5">
                                ${leccion.contenido2}
                            </p>

                            <div>
                                <a href="${mvc.basePath}/mundos/mundo/${mundo}"><i class="bi bi-arrow-left-circle-fill colorRed"></i></a>
                                <span class="lead text-end">

                                    <c:choose>
                                        <c:when test="${alumno.puntos <= nivel.puntosDesbloqueo}">
                                            <a href="${mvc.basePath}/niveles/nivel/${nivel.id}/${test.id}"><i class="bi bi-arrow-right-circle-fill colorPink"></i></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="${mvc.basePath}/niveles/nivel/${nivel.id}/${test.id}" style="pointer-events: none; opacity: 70%"><i class="bi bi-arrow-right-circle-fill colorPink"></i></a>
                                            <p>Ya superaste el test, ¡enhorabuena!</p>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </div>


                        </div>
                    </div>
                </section>

            </div>
        </div>
    </section>


</main>

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



<script src="/docs/5.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


</body>

</html>