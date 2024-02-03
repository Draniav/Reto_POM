package pages.signUp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import pages.CommunActions;

import java.util.List;


public class SignUpPage extends CommunActions {


    public SignUpPage(WebDriver webDriver, int seconds) {
        super(webDriver, seconds);
    }

    private By titleLbl = By.id("signInModalLabel");
    private By usernameTxt = By.id("sign-username");
    private By passwordTxt = By.id("sign-password");
    private By closeBtn = By.xpath("//button[text()='Close']");
    private By SignUpBtn = By.xpath("//button[text()='Sign up']");

    public void llenarFormularioSignUp(String emailUser, String passwordUser) throws InterruptedException {
        clearField(webDriver.findElement(usernameTxt));
        clearField(webDriver.findElement(passwordTxt));
        typeOnTextField(webDriver.findElement(usernameTxt), emailUser);
        typeOnTextField(webDriver.findElement(passwordTxt), passwordUser);
        clicSignInBtn();
        Thread.sleep(500);

    }

    public void clicSignInBtn() {

        scrollOn(webDriver.findElement(SignUpBtn));
        clickOnElement(webDriver.findElement(SignUpBtn));
    }

}