package setup;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static util.Constantes.URL_FRONT;
import static util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;


public class WebUI {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    //Ruta al Webdriver
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/drivers/chromedriver.exe";
    //URL de la Landing Page
    private static final String QA_URL = URL_FRONT;

    private static final Logger LOGGER = Logger.getLogger(WebUI.class);

    protected WebDriver driver;

    private void setUpWebdriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER,WEBDRIVER_CHROME_DRIVER_PATH);
    }


    private void setUpWebdriverUrl(){
        driver = new ChromeDriver();
        driver.get(QA_URL);
        driver.manage().window().maximize();
    }

    protected void generalSetup(){
        setUpWebdriver();
        setUpWebdriverUrl();

    }

    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
    protected void quiteDriver() {
        driver.quit();
    }



    public void errorManagement(Exception exception){
        Assertions.fail(exception.getMessage(), exception);
        LOGGER.error(exception.getMessage(), exception);
        quiteDriver();
    }




}


