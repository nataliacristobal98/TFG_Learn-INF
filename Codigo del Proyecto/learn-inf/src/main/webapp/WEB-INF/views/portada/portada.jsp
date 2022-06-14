<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Learn-INF / Inicio</title>
    <!--Favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/Logo1.png">

    <!--Bootstrap, JavaScript-->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
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
                <img src="${pageContext.request.contextPath}/resources/img/Logo2.png" alt="" style="width: 250px;">
            </a>

            <nav class="nav nav-masthead float-md-end text-white">
                <a  href="${mvc.basePath}/mundos/mundo" class="nav-link d-none d-md-block d-lg-block">
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


                <a href="${mvc.basePath}/login" type="button" class="buttonCustom buttonOrange mt-2 mx-4 me-2 d-none d-sm-block">Login</a>
                <a href="${mvc.basePath}/signup" type="button" class="buttonCustom buttonMint mt-2 d-none d-sm-block">Sign-up</a>
                <!--<button type="button" class="buttonCustom buttonMint d-none d-lg-block">Sign-up</button>-->



                <div class="collapse" id="navbarToggleExternalContent">
                    <div class="p-4">
                        <c:choose>
                            <c:when test="${alumno != null}">
                                <a href="${mvc.basePath}/perfil" type="button" class="buttonCustom buttonRed">Perfil</a>
                            </c:when>
                            <c:when test="${profesor != null}">
                                <a href="${mvc.basePath}/profesor" type="button" class="buttonCustom buttonRed">Perfil</a>

                            </c:when>
                            <c:otherwise>
                                <a href="${mvc.basePath}/perfil" type="button" class="buttonCustom buttonRed">Perfil</a>

                            </c:otherwise>
                        </c:choose>
                        <a href="${mvc.basePath}/login" type="button" class="buttonCustom buttonOrange">Login</a>
                        <a href="${mvc.basePath}/signup" type="button" class="buttonCustom buttonMint">Sign-up</a>
                    </div>
                </div>
                <nav class="navbar navbar-light d-sm-none text-end">
                    <div class="container-fluid">
                        <button class="navbar-toggler buttonMenu" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                    </div>
                </nav>

            </nav>
        </div>
    </div>
</header>

<main>

    <section class="py-5 container">
        <div class="row pt-3">
            <div class="col-lg-10 col-md-12 col-sm-10 mx-auto text-center">
                <h1>¡Bienvenido a Learn-INF!</h1>
                <p class="lead">Esta es la página inicial, para comenzar dale al botón de abajo.</p>
                <p class="lead">
                    <a href="${mvc.basePath}/mundos/mundo" class="buttonCustom buttonOrange ">Empezar a jugar</a>
                </p>
                <figure class="figure text-end">
                    <img src="${pageContext.request.contextPath}/resources/img/Cuervo.png" class="figure-img img-fluid rounded w-50" alt="profesor cuervo donde estas?">
                    <!--<figcaption class="figure-caption">Profesor cuervo.</figcaption>-->
                </figure>

            </div>
        </div>
    </section>


</main>

<footer class="footer mt-auto py-3 text-white">
    <div class="container">

        <div class="row text-center">
            <div class="col">
                <!--<figure class="figure">
                    <img src="${pageContext.request.contextPath}/resources/img/Logo1.png" class="figure-img img-fluid rounded" alt="profesor cuervo donde estas?">
                </figure>-->
            </div>
        </div>


        <div class="row">
            <div class="col-xl-2 col-md-5 col-lg-2 col-xs-1">
                <h5>Nuestro proyecto</h5>
                <ul class="nav flex-column">
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Quiénes somos</a></li>
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Objetivos</a></li>
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Blog</a></li>
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">FAQs</a></li>
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Contacto</a></li>
                </ul>
            </div>

            <div class="col-xl-3 col-md-5 col-lg-2 col-xs-1">
                <h5>Recomendaciones</h5>
                <ul class="nav flex-column">
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Webs de apoyo</a></li>
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Ejercicios extra</a></li>
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Tutoriales</a></li>
                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-white">Clases adicionales</a></li>
                </ul>
            </div>


            <div class="col-xl-7 col-md-12 text-center mt-3">
                <h5>Acerca de Learn-INF</h5>
                <p>“Learn-INF” consiste en una web interactiva para niños con el objetivo de que aprendan los principios básicos de la programación.
                    Con una dinámica parecida a un videojuego de preguntas y respuestas, pero con logros y un diseño dinámico para ellos.
                    El nombre es una combinación de la palabra “Learn”, cuyo significado es aprender en inglés, y de la abreviatura “INF”,
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

        <div class="row">
            <div class="col-lg-6 col-md-12">
                <form class="mt-4">
                    <h5>Suscribete a nuestra newsletter</h5>
                    <p>Para estar al día de nuestras novedades y ofertas que tenemos por ofrecer. ¡Sigue aprendiendo con nosotrxs!</p>
                    <div class="d-flex w-100 gap-1">
                        <label for="newsletter1" class="visually-hidden">Email</label>
                        <input id="newsletter1" type="text" class="form-control" placeholder="Correo electrónico">
                        <button class="buttonCustom buttonMint" type="button">Suscribirse</button>
                    </div>
                </form>
            </div>

        </div>


        <div class="d-flex justify-content-between text-center pt-4 my-4 border-top">
            <p>Esta web está bajo una <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">licencia de Creative Commons Reconocimiento-NoComercial-SinObraDerivada 4.0 Internacional</a></p>
            <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>
        </div>
    </div>
</footer>



<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


</body>
</html>