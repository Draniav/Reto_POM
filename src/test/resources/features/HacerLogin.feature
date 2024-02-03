# language: es
Característica:  Hacer Login

 Como usuario  quiero ingresar a la página con  mi  usuario y  contraseña

  Escenario: Ingreso correcto como usuario
    Dado que el cliente entre a la pagina web
    Cuando navega hacia la ventana de logeo
    Cuando ingrese las datos usuario "test@123" y password "1234"
    Entonces podra ver el mensaje de bienvenida "Welcome abc@test"





