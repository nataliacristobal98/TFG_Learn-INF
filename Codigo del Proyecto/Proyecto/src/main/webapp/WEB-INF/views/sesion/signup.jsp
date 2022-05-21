<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>3 - Sign Up</title>
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
                <a href="${mvc.basePath}/mundos/mundo" class="nav-link d-none d-md-block d-lg-block">
                    <i class="bi bi-globe2"></i>
                </a>

                <c:choose>
                    <c:when test="${alumno != null}">
                        <a href="${mvc.basePath}/perfil" class="nav-link d-none d-md-block d-lg-block">
                            <i class="bi bi-person-workspace"></i>
                        </a>
                    </c:when>
                    <c:when test="${profesor != null}">
                        <a href="${mvc.basePath}/profesor" class="nav-link d-none d-md-block d-lg-block">
                            <i class="bi bi-person-workspace"></i>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="${mvc.basePath}/perfil" class="nav-link d-none d-md-block d-lg-block">
                            <i class="bi bi-person-workspace"></i>
                        </a>
                    </c:otherwise>
                </c:choose>

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
                <img src="${pageContext.request.contextPath}/resources/img/SignUp3.png"
                     class="figure-img img-fluid w-75">
            </figure>
        </div>
    </section>

    <section class="py-5 pt-0 container">
        <div class="row">
            <div class="col-xl-8 col-md-11 col-xs-12 mx-auto bgLearn">



                <section class="container">
                    <div class="row">
                        <div class="col-xl-11 col-md-11 col-sx-11 mx-auto mb-3 py-2 bgLearn2">

                            <form action="${mvc.basePath}/signup/signup" method="post" class="px-4 py-2">

                                <div class="text-start">
                                    <p class="mt-3 mb-0 mx-2 fw-bold">Icono:</p>

                                    <div class="form-check text-center" id="icono">
                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon1.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono1">
                                        </div>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon2.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono2">
                                        </div>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon3.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono3">
                                        </div>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon4.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono4">
                                        </div>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon5.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono5">
                                        </div>

                                        </br>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon6.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono6">
                                        </div>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon7.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono7">
                                        </div>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon8.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono8">
                                        </div>

                                        <div class="d-inline-block text-center">
                                            <img src="${pageContext.request.contextPath}/resources/img/icon9.jpg"
                                                 height="100" width="100">
                                            <br><input type="radio" name="icono" value="icono9">
                                        </div>
                                    </div>
                                </div>

                                <div class="text-start">
                                    <p class="mt-1 mb-0 mx-2 fw-bold">Nombre y apellidos:</p>
                                    <input class="form-control" id="nombre" name="nombre"
                                           placeholder="Ej: Rosario Martinez Garcia" required>
                                </div>

                                <div class="text-start">
                                    <p class="mt-3 mb-0 mx-2 fw-bold">Email:</p>
                                    <input class="form-control" id="email" name="email"
                                           placeholder="Ej: miemail@gmail.com" required pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}">

                                    <c:choose>
                                    <c:when test="${mensajeError == true}">
                                        <div class="text-danger fw-bolder">
                                            <p>Uy, parece que este correo ya ha sido usado...</p>
                                        </div>
                                    </c:when>
                                </c:choose>
                                </div>


                                <div class="text-start">
                                    <p class="mt-3 mb-0 mx-2 fw-bold">Contraseña:</p>
                                    <div class="input-group">
                                        <input id="txtPassword" name="contrasena" type="password"
                                               class="form-control" required>
                                        <span class="input-group-btn">
                                                        <button id="show_password" class="buttonCustom buttonMint px-3"
                                                                type="button" onclick="mostrarPassword()"><i
                                                                class="bi bi-eye icon"
                                                                style="font-size: larger;"></i></button>
                                                    </span>
                                    </div>
                                </div>

                                <div class="text-start mb-5">
                                    <p class="mt-3 mb-0 mx-2 fw-bold">Profesor asignado:</p>
                                    <select class="form-select" id="profesor" name="profesor" required>
                                        <option selected disabled value="">Selecciona un profesor</option>
                                        <c:forEach var="profesor" items="${profesores}">
                                            <option value="${profesor.id}">${profesor.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>


                                <div class="text-center">
                                    <button class="btn-lg buttonCustom buttonMint"
                                            onclick="validateEmail()">Registrarse</button>
                                    <p class="mt-2 mb-3 text-muted small">*¿Ya tienes cuenta? <a
                                            href="${mvc.basePath}/login">¡Inicia
                                        sesión!</a></p>
                                </div>

                            </form>



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
                <p>“Learn-INF” consiste en una web interactiva para niños con el objetivo de que aprendan
                    los
                    principios básicos de la programación.
                    Con una dinámica parecida a un videojuego de preguntas y respuestas, pero con logros y
                    un diseño
                    dinámico para ellos.
                    El nombre es una combinación de la palabra “Learn”, cuyo significado es aprender en
                    inglés, y de
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
<script src="${pageContext.request.contextPath}/resources/js/form.js"></script>

</html>