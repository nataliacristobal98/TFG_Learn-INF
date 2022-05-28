
// Función de mostrar o esconder contraseña en el registro y login
 function mostrarPassword(){
    var cambio = document.getElementById("txtPassword");
    if(cambio.type === "password"){
    cambio.type = "text";
    $('.icon').removeClass('bi bi-eye').addClass('bi bi-eye-slash');
}else{
    cambio.type = "password";
    $('.icon').removeClass('bi bi-eye-slash').addClass('bi bi-eye');
}
}

    $(document).ready(function () {
    //CheckBox mostrar contraseña
    $('#ShowPassword').click(function () {
        $('#Password').attr('type', $(this).is(':checked') ? 'text' : 'password');
    });
});


// Personalización de los mensajes del formulario
 var nombre = document.getElementById('nombre');
 nombre.addEventListener('input', function(evt) {
     this.setCustomValidity('');
 });
 nombre.addEventListener('invalid', function(evt) {
     // Required
     if (this.validity.valueMissing) {
         this.setCustomValidity('¡Introduce tu nombre!');
     }
 });

 var email = document.getElementById('email');
 email.addEventListener('input', function(evt) {
     this.setCustomValidity('');
 });
 email.addEventListener('invalid', function(evt) {
     // Required
     if (this.validity.valueMissing) {
         this.setCustomValidity('¡Intruduce tu email!');
     }
 });

 var pass = document.getElementById('txtPassword');
 pass.addEventListener('input', function(evt) {
     this.setCustomValidity('');
 });
 pass.addEventListener('invalid', function(evt) {
     // Required
     if (this.validity.valueMissing) {
         this.setCustomValidity('¡Elige tu contraseña!');
     }
 });

 var pass = document.getElementById('profesor');
 pass.addEventListener('input', function(evt) {
     this.setCustomValidity('');
 });
 pass.addEventListener('invalid', function(evt) {
     // Required
     if (this.validity.valueMissing) {
         this.setCustomValidity('¿Qué profesor quieres tener?');
     }
 });

