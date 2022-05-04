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
                <a href="${mvc.basePath}/mundos/mundo" class="nav-link d-none d-md-block d-lg-block">
                    <i class="bi bi-globe2"></i>
                </a>

                <a href="${mvc.basePath}/perfil" class="nav-link d-none d-md-block d-lg-block">
                    <i class="bi bi-person-workspace"></i>
                </a>

                <a href="#" class="nav-link d-none d-md-block d-lg-block">
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
                        <% int cont = 0; %>
                        <form method="post" id="formulario" onsubmit="recogerValores(event)">
                            <c:forEach var="pregunta" items="${preguntas}">
                                <p id="preguntas" style="display: none">${totalPreguntas}</p>

                                <div class="col-xl-12 col-md-12 col-sm-12">
                                    <div class="card mb-4">
                                        <div class="card-header py-3">
                                            <h3 class="my-0 fw-normal text-center">${pregunta.textoPregunta}</h3>

                                            <div class="mt-3 mb-1 text-center">
                                                <c:choose>
                                                    <c:when test="${pregunta.imagenPregunta != null}">
                                                        <img class="mt-2" src="${pregunta.imagenPregunta}">
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                        <div class="card-body bg-white textBrown">

                                            <div class="row m-3 justify-content-center">
                                                <c:forEach var="respuesta" items="${respuestas}">
                                                    <c:choose>
                                                        <c:when test="${respuesta.pregunta.id == pregunta.id}">
                                                            <div class="col-5 responseTest m-2 rounded-3">

                                                                <div class="form-check" id="${respuesta.id}">
                                                                    <input class="form-check-input" type="radio"
                                                                           name="grupo<%=cont%>" value="${respuesta.id}"
                                                                           id="${respuesta.id}" required>
                                                                    <label class="form-check-label" for="grupo<%=cont%>">
                                                                            ${respuesta.textoRespuesta}
                                                                    </label>
                                                                </div>

                                                            </div>
                                                        </c:when>
                                                    </c:choose>
                                                </c:forEach>
                                            </div>
                                            <% cont++; %>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            <div class="text-center mt-3">
                                <button class="buttonCustom buttonPink">Enviar</button>
                            </div>
                        </form>




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

<script>

    function recogerValores(event) {
        event.preventDefault();
        var preguntas = parseInt(document.getElementById("preguntas").textContent);

        var respuestasSelect = [];

        for (let i = 0; i <= preguntas - 1; i++) {
            var boton = document.querySelector(`input[name="grupo` + CSS.escape(i) + `"]:checked`).value;
            console.log(boton)
            respuestasSelect.push(boton);

        }

        $.ajax({
            type: "POST",
            url: "${mvc.basePath}/niveles/nivel/resultTest",
            data: {respuestas: respuestasSelect},
            success: function (result) {
                console.log("ok")
                window.location.href = "${mvc.basePath}/niveles/nivel/testSuperado";
            },
            error: function (result) {
                console.log("error")
            }
        })
    }

</script>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</html>