package definitions;


import com.sun.jdi.LongValue;
import org.junit.Assert;
import setup.SetUpPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ConsultaPorIdDefinitions extends SetUpPage {

    private RequestSpecification request;
    private Response response;
    private int idVerificacion;


    @Dado("que el usuario consuma la Api")
    public void queElUsuarioConsumaLaApi() {

        try {
            generalSetUp();
            request = given();


        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Cuando("usa el  numero de id {string} para realizar una busqueda")
    public void usaElNumeroDeParaRealizarUnaBusqueda(String id) {
        try {
            idVerificacion = Integer.parseInt(id);
            response = request.get(RESOURCE + "/" + id);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @Entonces("deberia recibir el codigo de estatus {string}")
    public void deberiaRecibirElCodigoDeEstatus(String statusCode) {
        try {

            response.print();
            response
                    .then()
                    .statusCode(Integer.parseInt(statusCode))
                    .body("data.id", equalTo(idVerificacion));

            System.out.println("Status Code:" + response.statusCode());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


}


