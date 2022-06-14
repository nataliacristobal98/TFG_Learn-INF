<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Learn-INF / Perfil de Profesor</title>
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

                <c:choose>
                    <c:when test="${alumno != null}">
                        <a href="${mvc.basePath}/perfil" class="nav-link active selectedPlace d-none d-md-block d-lg-block">
                            <i class="bi bi-person-workspace"></i>
                        </a>
                    </c:when>
                    <c:when test="${profesor != null}">
                        <a href="${mvc.basePath}/profesor" class="nav-link active selectedPlace d-none d-md-block d-lg-block">
                            <i class="bi bi-person-workspace"></i>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="${mvc.basePath}/perfil" class="nav-link active selectedPlace d-none d-md-block d-lg-block">
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
            <div class="col-xl-8 col-md-11 col-xs-12 mx-auto bgLearn">

                <section class="container boderProfile">

                    <h3 class="text-black text-center mb-3 mt-3"> Perfil de profesor</h3>

                    <div class="row">

                        <div class="col-xl-12 col-md-12 col-sm-12 px-5">
                            <p class="fw-bold text-black-50 m-0">Nombre:
                                <span class="fw-bold text-white m-0">${profesor.nombre}</span></p>

                            <p class="fw-bold text-black-50 m-0">Código:
                                <span class="fw-bold text-white m-0">${profesor.codigoProfesor}</span></p>

                            <p class="fw-bold text-black-50 m-0">Correo:
                                <span class="fw-bold text-white m-0">${profesor.correo}</span></p>


                            <h5 class="text-center mt-4">Listado de Alumnos:</h5>
                            <table class="table table-hover bg-white rounded-3">
                                <thead>
                                <tr>
                                    <th scope="col">Alumno</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Información</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="alumno" items="${listadoAlumnos}">
                                    <tr>
                                        <td>${alumno.nombre}</td>
                                        <td>${alumno.codigoAlumno}</td>
                                        <td><button type="button" class="buttonCustom buttonPink p-2 mb-2 ms-4 btn-sm" onclick="modalAlumno('${alumno.nombre}', '${alumno.icono}', '${alumno.codigoAlumno}', '${alumno.puntos}' )" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                            Ver Alumno
                                        </button></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>



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
                <h5 class="modal-title">Listado de alumnos</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body bg-white">

                <h3 class="text-black text-center mb-3 mt-3"> Perfil de alumno</h3>

                <div class="row">
                    <div class="col-xl-5 col-md-5 col-sm-12 m-sm-0">
                        <figure class="figure text-center">
                            <img id="imagenModal" class="figure-img img-fluid imgProfile mx-3">
                        </figure>
                    </div>

                    <div class="col-xl-7 col-md-7 col-sm-12 px-5">
                        <h6 id="tituloModal"></h6>
                        <p class="fw-bold text-black-50 m-0">Código</p>
                        <p class="fw-bold text-white m-0" id="codigoModal"></p>
                        <p class="fw-bold text-black-50 m-0">Puntos</p>
                        <p class="fw-bold text-white m-0" id="puntosModal"></p>

                        <p class="fw-bold text-black-50 m-0">Nivel</p>
                        <p class="fw-bold text-white m-0" id="nivelModal"></p>

                    </div>
                </div>
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


        <div class="d-flex justify-content-between text-center pt-4 my-4 border-top">
            <p>Esta web está bajo una <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">licencia de Creative Commons Reconocimiento-NoComercial-SinObraDerivada 4.0 Internacional</a></p>
            <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>
        </div>
    </div>
</footer>
</body>

<!--JavaScript-->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/modalDinamico.js"></script>


</html>