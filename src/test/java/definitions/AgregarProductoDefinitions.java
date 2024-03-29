package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;
import pages.base.LandingPage;
import pages.product.ProductPage;
import setup.WebUI;

public class AgregarProductoDefinitions extends WebUI {

    private static LandingPage landingPage;
    private static ProductPage productPage;

    @Dado("que el usuario selecciona un producto en la aplicacion")
    public void que_el_usuario_selecciona_un_producto_en_la_aplicacion() throws InterruptedException {
        System.out.println("1");
        try {
            generalSetup();
            landingPage = new LandingPage(driver, 10);

            landingPage.clicEnProducto();
        } catch (Exception exception) {
            errorManagement(exception);
            quiteDriver();
        }
    }

    @Cuando("hace clic en add to cart")
    public void hace_clic_en_add_to_cart() {
        try {
            System.out.println("2");
            productPage = landingPage.openProductPage();

            productPage.clicAddToCartBtn();
        } catch (Exception exception) {
            errorManagement(exception);
            quiteDriver();
        }

    }

    @Entonces("sera notificado con el mensaje {string}")
    public void sera_notificado_con_el_mensaje(String mensaje) {
        System.out.println("3");
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


}
