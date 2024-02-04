package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;
import pages.home.HomePage;
import pages.login.LoginPage;
import pages.product.ProductPage;
import pages.signUp.SignUpPage;

public class LandingPage extends CommunActions {

    private By home = By.xpath("//a[contains(text(),'Home ')]");

    private By title = By.xpath("//a[contains(text(),'PRODUCT STORE')]");

    private By logIn = By.id("login2");
    private By signUp = By.id("signin2");
    private By nombreDeLaSesion = By.id("nameofuser");
    private By producto1 = By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/a/img");





    public LandingPage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
    }



    public HomePage openHomePage() {
        clickOnElement(webDriver.findElement(home));
        return new HomePage(webDriver, 5);
    }
    public SignUpPage openSignUpPage() {
        clickOnElement(webDriver.findElement(signUp));
        return new SignUpPage(webDriver, 10);
    }

    public LoginPage openLogInForm() {
        clickOnElement(webDriver.findElement(logIn));
        return new LoginPage(webDriver, 10);
    }

    public ProductPage openProductPage() {

        return new ProductPage(webDriver, 10);
    }



    public void clicLogInBtn() {

        scrollOn(webDriver.findElement(logIn));
        clickOnElement(webDriver.findElement(logIn));

    }





    public String getNombreDeLaSesion() {

        return getTextFromElement(webDriver.findElement(nombreDeLaSesion));
    }

    public void clicSingUpBtn() {


        scrollOn(webDriver.findElement(signUp));
        clickOnElement(webDriver.findElement(signUp));


    }

    public void clicEnProducto() {

        scrollOn(webDriver.findElement(producto1));
        clickOnElement(webDriver.findElement(producto1));

    }




}
