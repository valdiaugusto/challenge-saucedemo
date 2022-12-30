package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseSteps {
    public static WebDriver driver;
    private String navegadorPorDefecto = "Chrome";

    @BeforeMethod
    @Parameters({"tipoNavegador"})
    public void initClass(String tipoNavegador) throws Exception {
        if (tipoNavegador.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver(getChromeOptions());
        } else if (tipoNavegador.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Navegador " + tipoNavegador + " no valido");
        }
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().setSize(new Dimension(1280, 960));
    }

    @AfterMethod
    public void stop() {
        driver.quit();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(false);
        return options;
    }
}
