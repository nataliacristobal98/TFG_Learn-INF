<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>2 - Login</title>
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
                <a href="${mvc.basePath}/mundos/mundo"
                   class="nav-link text-white d-none d-md-block d-lg-block">
                    <i class="bi bi-globe2"></i>
                </a>

                <a href="${mvc.basePath}/perfil" class="nav-link text-white d-none d-md-block d-lg-block">
                    <i class="bi bi-person-workspace"></i>
                </a>

                <a href="#" class="nav-link text-white d-none d-md-block d-lg-block">
                    <i class="bi bi-trophy"></i>
                </a>


                <a href="${mvc.basePath}/login" type="button"
                   class="boton botonLog mt-2 mx-4 me-2 d-none d-sm-block">Login</a>
                <a href="${mvc.basePath}/signup" type="button"
                   class="boton botonSign mt-2 d-none d-sm-block">Sign-up</a>
                <!--<button type="button" class="boton botonSign d-none d-lg-block">Sign-up</button>-->



                <div class="collapse" id="navbarToggleExternalContent">
                    <div class="p-4">
                        <a href="${mvc.basePath}/perfil" type="button" class="boton botonRojo">Perfil</a>
                        <a href="${mvc.basePath}/login" type="button" class="boton botonLog">Login</a>
                        <a href="${mvc.basePath}/signup" type="button" class="boton botonSign">Sign-up</a>
                    </div>
                </div>
                <nav class="navbar navbar-light d-sm-none text-end">
                    <div class="container-fluid">
                        <button class="navbar-toggler botonMenu" type="button" data-bs-toggle="collapse"
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
                <img src="${pageContext.request.contextPath}/resources/img/Login3.png"
                     class="figure-img img-fluid">
            </figure>
        </div>
    </section>

    <section class="py-5 pt-0 container">
        <div class="row">
            <div class="col-xl-8 col-md-11 col-xs-12 mx-auto fondoLearn">



                <section class="container">
                    <div class="row">
                        <div class="col-xl-11 col-md-11 col-sx-11 mx-auto mb-3 py-2 fondoLearn2">

                            <form action="${mvc.basePath}/login/login" method="post" class="px-4 py-2">
                                <div class="text-start">
                                    <p class="mt-1 mb-0 mx-2 fw-bold">Email / Código de Usuario</p>
                                    <input class="form-control" id="codigo" name="codigo"
                                           placeholder="Ej: miemail@gmail.com / A001" required>

                                </div>

                                <div class="text-start">
                                    <p class="mt-3 mb-0 mx-2 fw-bold">Contraseña:</p>
                                    <div class="input-group">
                                        <input id="txtPassword" name="contrasena" type="password"
                                               class="form-control" required>
                                        <span class="input-group-btn">
                                                        <button id="show_password" class="boton botonSign px-3"
                                                                type="button" onclick="mostrarPassword()"><i
                                                                class="bi bi-eye icon"
                                                                style="font-size: larger;"></i></button>
                                                    </span>
                                    </div>
                                </div>


                                <div class="checkbox mb-3 text-center">
                                    <label><input type="checkbox" value="remember-me"> Remember me</label>
                                </div>

                                <div class="text-center">
                                    <button class="btn-lg boton botonSign w-50"
                                            type="submit">Iniciar</button>
                                    <p class="mt-2 mb-3 text-muted small">¿No tienes una cuenta? <a
                                            href="${mvc.basePath}/signup">¡Regístrate ahora!</a></p>
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
                <p>“Learn-INF” consiste en una web interactiva para niños con el objetivo de que aprendan los
                    principios básicos de la programación.
                    Con una dinámica parecida a un videojuego de preguntas y respuestas, pero con logros y un diseño
                    dinámico para ellos.
                    El nombre es una combinación de la palabra “Learn”, cuyo significado es aprender en inglés, y de
                    la abreviatura “INF”,
                    la cual procede de INFormation.</p>

                <div class="text-center gap-2">
                    <a href="#" class="mx-1">
                        <i class="bi bi-discord"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-instagram"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-pinterest"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-twitter"></i>
                    </a>
                    <a href="#" class="mx-1">
                        <i class="bi bi-youtube"></i>
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

<!--JavaScript-->
<script src="${pageContext.request.contextPath}/resources/js/form.js"></script>

</html>