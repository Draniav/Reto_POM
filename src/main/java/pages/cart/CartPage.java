package pages.cart;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommunActions;


public class CartPage extends CommunActions {

    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    private By name = By.id("name");
    private By city = By.id("city");
    private By country = By.id("country");
    private By credidCart = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");
    private By pursacheBtn = By.xpath("//button[text()='Purchase']");
    private By confirmacionDeCompra = By.xpath("//h2[text()='Thank you for your purchase!']");


    public CartPage(WebDriver webDriver, int seconds) {
        super(webDriver, seconds);
    }

    public void clicAddToCartBtn() {


        scrollOn(webDriver.findElement(placeOrderBtn));
        clickOnElement(webDriver.findElement(placeOrderBtn));

        webDriverImplicitWait(webDriver, 500);
    }


    public void llenarFormularioCorrectamente() {


        Faker faker = new Faker();


        clearField(webDriver.findElement(name));
        clearField(webDriver.findElement(city));
        clearField(webDriver.findElement(country));
        clearField(webDriver.findElement(credidCart));
        clearField(webDriver.findElement(month));
        clearField(webDriver.findElement(year));

        typeOnTextField(webDriver.findElement(name), faker.name().fullName());
        typeOnTextField(webDriver.findElement(city), faker.address().cityName());
        typeOnTextField(webDriver.findElement(country), faker.country().name());
        typeOnTextField(webDriver.findElement(credidCart), String.valueOf(faker.number().numberBetween(0, 9999)));
        typeOnTextField(webDriver.findElement(month), (String.valueOf(faker.date().birthday())));
        typeOnTextField(webDriver.findElement(year), String.valueOf(faker.number().numberBetween(2000, 2024)));

        clicPurchaseBtn();
        webDriverImplicitWait(webDriver, 500);

    }

    public void clicPurchaseBtn() {


        scrollOn(webDriver.findElement(pursacheBtn));
        clickOnElement(webDriver.findElement(pursacheBtn));


    }


    public String getConfirmacionDeCompra() {

        return getTextFromElement(webDriver.findElement(confirmacionDeCompra));
    }


}
