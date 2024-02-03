package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;
import pages.home.HomePage;
import pages.login.LoginPage;
import pages.signUp.SignUpPage;

public class LandingPage extends CommunActions {

    private By home = By.xpath("//a[contains(text(),'Home ')]");

    private By title = By.xpath("//a[contains(text(),'PRODUCT STORE')]");

    private By logIn = By.id("login2");
    private By signUp = By.id("signin2");

    private By nombreDeLaSesion = By.id("nameofuser");


    private By cart = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By product = By.xpath(" //*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]/div/a/span/span/img");
    private By addProductBtn = By.xpath("  //*[@id=\"product-addtocart-button\"]/span");
    private By confirmationMessage = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");
    private By editCart = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span");
    private By remove = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[2]");
    private By register = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");

    private By gearBtn = By.xpath("//*[@id=\"ui-id-6\"]/span[2]");
    private By fitnessEquipment = By.xpath("//a[contains(text(), 'Fitness Equipment')]");


    public LandingPage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
    }


    public HomePage openHomePage() {
        clickOnElement(webDriver.findElement(home));
        return new HomePage(webDriver, 5);
    }

/*
funciones para Logeo
 */

    public void clicLogInBtn() {

        scrollOn(webDriver.findElement(logIn));
        clickOnElement(webDriver.findElement(logIn));

    }

    public LoginPage openLogInForm() {
        clickOnElement(webDriver.findElement(logIn));
        return new LoginPage(webDriver, 10);
    }

    public SignUpPage openSignUpPage() {
        clickOnElement(webDriver.findElement(logIn));
        return new SignUpPage(webDriver, 10);
    }

    public String getNombreDeLaSesion() {

        return getTextFromElement(webDriver.findElement(nombreDeLaSesion));
    }
    public String getMensaje() {

        return getTextFromElement(webDriver.findElement(nombreDeLaSesion));
    }

    public void clicSingUpBtn() {


        scrollOn(webDriver.findElement(signUp));
        clickOnElement(webDriver.findElement(signUp));


    }

    public void clicRemoveBtn() {

        scrollOn(webDriver.findElement(editCart));

        clickOnElement(webDriver.findElement(editCart));

        scrollOn(webDriver.findElement(remove));

        clickOnElement(webDriver.findElement(remove));


    }


    public void clicAddProduct() {

        scrollOn(webDriver.findElement(product));
        clickOnElement(webDriver.findElement(product));
        scrollOn(webDriver.findElement(addProductBtn));
        clickOnElement(webDriver.findElement(addProductBtn));
    }

    public String getConfirmationMessage() {
        return getTextFromElement(webDriver.findElement(confirmationMessage)) + 1;
    }


}
