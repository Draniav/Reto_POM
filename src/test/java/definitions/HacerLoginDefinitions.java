package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import pages.base.LandingPage;
import pages.login.LoginPage;
import setup.WebUI;

public class HacerLoginDefinitions extends WebUI {


    private static LandingPage landingPage;

    private static LoginPage loginPage;

    @Dado("que el cliente navega hacia la ventana de logeo")
    public void queElClienteNavegaHaciaLaVentanaDeLogeo() {
        try {
            generalSetup();
            setUpLog4j2();
            landingPage = new LandingPage(driver, 10);
            landingPage.clicLogInBtn();

        } catch (Exception exception) {
            errorManagement(exception);

        }

    }

    @Cuando("ingrese las datos usuario {string} y password {string}")
    public void ingreseLasDatosUsuarioYPassword(String usuario, String password) {
        loginPage = landingPage.openLogInForm();
        loginPage.llenarFormularioLogIn(usuario, password);
    }

    @Entonces("podra ver el mensaje de bienvenida {string}")
    public void podraVerElMensajeDeBienvenida(String Mensaje) {

        try {
            Assertions.assertTrue(
                    Mensaje.contains(
                            landingPage.getNombreDeLaSesion()
                    )
            );

            quiteDriver();

        } catch (Exception exception) {
            errorManagement(exception);
            quiteDriver();
        }


    }


}
