# language: es
Característica:  Actualizar usuario

  Como usuario quiero actualizar los datos de un usuario

  Escenario: Actualizar usuario
    Dado que el usuario consuma la Api actualizar datos
    Cuando usa el  id "2" para realizar la actualizacion
    Entonces recibira el codigo de estatus "200" y  respuesta con  la fecha de actualizacion






