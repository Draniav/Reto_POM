package definitions;


import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import setup.SetUpPage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class ConsultaListadoDefinitions extends SetUpPage {

    private RequestSpecification request;
    private Response response;

    private int pageNumber, perPageNumber;


    @Dado("que el usuario consuma la Api para realizar la consultar un listado")
    public void queElUsuarioConsumaLaApiParaRealizarLaConsultarUnListado() {

        try {
            generalSetUp();
            request = given();


        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            System.out.println(e.getMessage());
        }

    }

    @Cuando("usa el  solicita la pagina {string} con la cantidad  {int}")
    public void usaElSolicitaLaPaginaConLaCantidad(String page, Integer cant) {
        try {
            pageNumber = Integer.parseInt(page);
            perPageNumber=cant;
            response = request.get(RESOURCE + "?page=" + page + "&per_page=" + cant);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("deberia recibir el codigo de estatus {string} con respuesta de consulta")
    public void deberiaRecibirElCodigoDeEstatusConRespuestaDeConsulta(String statusCode) {
        try {

            response.print();
            response.then()
                    .statusCode(Integer.parseInt(statusCode))
                    .body("page", equalTo(pageNumber))
                    .body("per_page", equalTo(perPageNumber));

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


}


