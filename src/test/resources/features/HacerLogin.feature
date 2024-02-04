# language: es
Característica:  Hacer Login

  Como usuario quiero ingresar a la página con mi usuario y contraseña.

  Escenario: Ingreso correcto como usuario
    Dado que el cliente navega hacia la ventana de logeo
    Cuando ingrese las datos usuario "abc@Test" y password "0000"
    Entonces podra ver el mensaje de bienvenida "Welcome abc@Testi"





