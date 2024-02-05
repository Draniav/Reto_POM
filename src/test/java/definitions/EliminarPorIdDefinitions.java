package definitions;


import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import setup.SetUpPage;

import static io.restassured.RestAssured.given;

public class EliminarPorIdDefinitions extends SetUpPage {

    private RequestSpecification request;
    private Response response;


    @Dado("que el usuario consuma la Api para eliminar")
    public void queElUsuarioConsumaLaApiParaEliminar() {

        try {
            generalSetUp();
            request = given();


        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    @Cuando("usa el  numero de id {string} para realizar eliminacion")
    public void usaElNumeroDeIdParaRealizarEliminacion(String id) {
        try {

            response = request.delete(RESOURCE + "/" + id);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @Entonces("deberia recibir el codigo de estatus {string} para eliminar")
    public void deberiaRecibirElCodigoDeEstatusParaEliminar(String statusCode) {
        try {

           response
                   .then()
                   .statusCode(Integer.parseInt(statusCode));



        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }



}


