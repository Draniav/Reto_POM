package pages.checkOut;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;


public class CheckOutPage extends CommunActions {

    private By addToCartBtn = By.xpath("//a[text()='Add to cart']");


    public CheckOutPage(WebDriver webDriver, int seconds) {
        super(webDriver, seconds);
    }

    public void clicAddToCartBtn() {


        scrollOn(webDriver.findElement(addToCartBtn));
        clickOnElement(webDriver.findElement(addToCartBtn));


    }


}
