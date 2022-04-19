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