package pages.cart;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;


public class CartPage extends CommunActions {

    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");


    public CartPage(WebDriver webDriver, int seconds) {
        super(webDriver, seconds);
    }

    public void clicAddToCartBtn() {


        scrollOn(webDriver.findElement(placeOrderBtn));
        clickOnElement(webDriver.findElement(placeOrderBtn));

        webDriverImplicitWait(webDriver, 500);
    }


}
