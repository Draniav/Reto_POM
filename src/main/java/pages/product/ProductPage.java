package pages.product;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;

import java.util.concurrent.TimeUnit;


public class ProductPage extends CommunActions {

    private By addToCartBtn = By.xpath("//a[text()='Add to cart']");


    public ProductPage(WebDriver webDriver, int seconds) {
        super(webDriver, seconds);
    }

    public void clicAddToCartBtn() {


        scrollOn(webDriver.findElement(addToCartBtn));
        clickOnElement(webDriver.findElement(addToCartBtn));


    }


}
