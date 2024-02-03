package pages.home;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;


public class HomePage extends CommunActions {

    private By title = By.xpath("//a[contains(text(),'PRODUCT STORE')]");


    public HomePage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
    }


    public String getTitle() {

        return getTextFromElement(webDriver.findElement(title));
    }


}
