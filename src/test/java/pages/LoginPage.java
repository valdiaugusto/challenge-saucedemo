package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By loginLogo = By.className("login_logo");
    private By campoUsername = By.id("user-name");
    private By campoPassword = By.id("password");
    private By botonLogin = By.id("login-button");
    private By errorMessageContainer = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginLogo() {
        return driver.findElement(loginLogo);
    }

    public WebElement getCampoUsername() {
        return driver.findElement(campoUsername);
    }

    public WebElement getCampoPassword() {
        return driver.findElement(campoPassword);
    }

    public WebElement getBotonLogin() {
        return driver.findElement(botonLogin);
    }

    public WebElement getErrorMessageContainer() {
        return driver.findElement(errorMessageContainer);
    }
}
