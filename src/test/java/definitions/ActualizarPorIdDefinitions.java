package definitions;


import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import setup.SetUpPage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;


public class ActualizarPorIdDefinitions extends SetUpPage {


    private RequestSpecification request;

    private Response response;


    @Dado("que el usuario consuma la Api actualizar datos")
    public void queElUsuarioConsumaLaApiActualizarDatos() {
        try {
            generalSetUp();
            request = given();


        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Cuando("usa el  id {string} para realizar la actualizacion")
    public void usaElIdParaRealizarLaActualizacion(String id) {
        try {

            response = request.patch(RESOURCE + "/" + id);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("recibira el codigo de estatus {string} y  respuesta con  la fecha de actualizacion")
    public void recibiraElCodigoDeEstatusYRespuestaConLaFechaDeActualizacion(String statusCode) {
        try {

            response.body().prettyPeek();
            response
                    .then()
                    .statusCode(Integer.parseInt(statusCode))
                    .body("updatedAt", notNullValue());



            System.out.println("Status Code:" + response.statusCode());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


}


