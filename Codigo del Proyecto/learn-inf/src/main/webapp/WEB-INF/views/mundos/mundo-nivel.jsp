<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Learn-INF / Niveles</title>
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
                   class="nav-link active selectedPlace d-none d-md-block d-lg-block">
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

    <div class="container">
        <div class="row m-3 text-center">

            <c:forEach var="nivel" items="${niveles}">
                <div class="col-xl-4 col-md-6 col-sm-12">
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <h3 class="my-0 fw-normal">Nivel ${nivel.id}</h3>
                        </div>
                        <div class="card-body">
                            <c:choose>
                                <c:when test="${alumno.puntos >= nivel.puntosDesbloqueo}">
                                    <a href="${mvc.basePath}/niveles/nivel/${nivel.id}" type="button"
                                       class="buttonCustom buttonBrown w-75">Jugar</a>
                                </c:when>
                                <c:when test="${profesor != null}">
                                    <a href="${mvc.basePath}/niveles/nivel/${nivel.id}" type="button"
                                       class="buttonCustom buttonBrown w-75">Jugar</a>
                                </c:when>
                                <c:otherwise>
                                    <button type="button" class="buttonCustom buttonBrown w-75"
                                            disabled="disabled">Jugar</button>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </c:forEach>




        </div>

        <div class="text-center my-4">
            <a href="${mvc.basePath}/mundos/mundo" type="button"
               class="buttonCustom buttonRed">Volver a Mundos</a>
        </div>

    </div>


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


        <div class="d-flex justify-content-between text-center pt-4 my-4 border-top">
            <p>Esta web está bajo una <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">licencia de Creative Commons Reconocimiento-NoComercial-SinObraDerivada 4.0 Internacional</a></p>
            <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>
        </div>
    </div>
</footer>



<script src="/docs/5.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


</body>

</html>