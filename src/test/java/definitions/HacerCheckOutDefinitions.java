package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;
import pages.base.LandingPage;
import pages.cart.CartPage;
import pages.product.ProductPage;
import setup.WebUI;

public class HacerCheckOutDefinitions extends WebUI {

    private static LandingPage landingPage;
    private static ProductPage productPage;

    private static CartPage cartPage;

    @Dado("que el usuario agrega un producto en la aplicacion")
    public void queElUsuarioAgregaUnProductoEnLaAplicacion() {

        try {
            generalSetup();
            landingPage = new LandingPage(driver, 10);
            landingPage.clicEnProducto();
            productPage = landingPage.openProductPage();
            productPage.clicAddToCartBtn();
            webDriverImplicitWait(driver, 500);
        } catch (Exception exception) {
            errorManagement(exception);

        }
    }

    @Cuando("llena el formulario de compra exitosamente")
    public void llenaElFormularioDeCompraExitosamente() {
        try {
            System.out.println("2");
            cartPage = landingPage.openCartPage();
            webDriverImplicitWait(driver, 500);
            cartPage.clicAddToCartBtn();

        } catch (Exception exception) {
            errorManagement(exception);
            quiteDriver();
        }

    }

    @Entonces("el sistema notificara con el mensaje {string}")
    public void elSistemaNotificaraConElMensaje(String mensaje) {
        System.out.println("3");
        try {
            webDriverImplicitWait(driver, 500);
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


}
