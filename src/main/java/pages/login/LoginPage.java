package pages.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;


public class LoginPage extends CommunActions {

    private By titleLbl = By.id("logInModalLabel");
    private By usernameTxt = By.id("loginusername");
    private By passwordTxt = By.id("loginpassword");
    private By closeBtn = By.xpath("//button[text()='Close']");
    private By loginBtn = By.xpath("//button[text()='Log in']");


    public LoginPage(WebDriver webDriver, int seconds) {
        super(webDriver, seconds);
    }

    public void llenarFormularioLogIn(String emailUser, String passwordUser) {
        clearField(webDriver.findElement(usernameTxt));
        clearField(webDriver.findElement(passwordTxt));
        typeOnTextField(webDriver.findElement(usernameTxt), emailUser);
        typeOnTextField(webDriver.findElement(passwordTxt), passwordUser);
        clicSignInBtn();


    }

    public void clicSignInBtn() {

        scrollOn(webDriver.findElement(loginBtn));
        clickOnElement(webDriver.findElement(loginBtn));
    }


}
