package definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;


import org.junit.jupiter.api.Assertions;
import pages.base.LandingPage;

import pages.signUp.SignUpPage;
import setup.WebUI;

import static util.Constantes.passwordinicial;


public class RealizarRegistroDefinitions extends WebUI {
    private static LandingPage landingPage;
    private static SignUpPage signUpPage;
    private static String name;


    @Dado("que el usuario ingresa a la pagina de registro de la aplicacion")
    public void queElUsuarioIngresaALaPaginaDeRegistroDeLaAplicacion() {
        try {
            generalSetup();
            landingPage = new LandingPage(driver, 10);
            landingPage.clicSingUpBtn();

        } catch (Exception exception) {
            errorManagement(exception);

        }

    }

    @Cuando("ingrese las datos nuevos")
    public void ingreseLasDatosNuevos() throws InterruptedException {

        signUpPage = landingPage.openSignUpPage();

        signUpPage.llenarFormularioSignUp(ramdomname(), passwordinicial);


    }

    @Entonces("podra ver el mensaje de {string}")
    public void podraVerElMensajeDe(String mensaje) {
        try {
            Assertions.assertTrue(
                    mensaje.contains(
                            driver.switchTo().alert().getText()
                    )
            );

            quiteDriver();

        } catch (Exception exception) {
            errorManagement(exception);
            quiteDriver();
        }
    }

    public String ramdomname() {
        Faker faker = new Faker();
        name = faker.name().fullName();
        return (name);

    }


}



