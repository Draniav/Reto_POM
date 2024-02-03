package definitions;


import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;


import pages.base.LandingPage;
import pages.home.HomePage;
import setup.WebUI;


public class IngresarAPaginaPrincipalDefinitions extends WebUI {

    private static LandingPage landingPage;

    private static HomePage homePage;


    @Dado("que el cliente entre a la pagina web")
    public void queElClienteEntreALaPaginaWeb() {

        try {
            generalSetup();
            setUpLog4j2();
            landingPage = new LandingPage(driver, 10);

        } catch (Exception exception) {
            errorManagement(exception);
        }

    }


    @Cuando("navegue en  la pagina")
    public void navegueEnLaPagina() {


        try {
            homePage = landingPage.openHomePage();
        } catch (Exception exception) {
            errorManagement(exception);
        }


    }

    @Entonces("podra ver el titulo de la pagina {string}")
    public void podraVerElTituloDeLaPagina(String TITLE) {



  try {
            Assertions.assertTrue(
                    TITLE.contains(
                            homePage.getTitle()
                    )
            );

            quiteDriver();

        } catch (Exception exception) {
            errorManagement(exception);
            quiteDriver();
        }



    }


}
