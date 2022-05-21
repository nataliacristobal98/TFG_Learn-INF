function modalAlumno(nombre, imagen, codigo, puntos){
    let titulo = document.getElementById("tituloModal");
    titulo.innerHTML = nombre;

    let imagenModal = document.getElementById("imagenModal");
    imagenModal.src = imagen;

    let codigoModal = document.getElementById("codigoModal");
    codigoModal.innerHTML = codigo;

    let puntosModal = document.getElementById("puntosModal");
    puntosModal.innerHTML = puntos;

    let nivelModal = document.getElementById("nivelModal");

    if(puntos >= 10){
        nivelModal.innerHTML = "Intermedio";
    }else{
        nivelModal.innerHTML = "Básico";
    }
}