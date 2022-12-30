package pagesteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageSteps {
    private final String NOMBRE_PAGINA = "Página Login: ";
    private WebDriver driver;
    private LoginPage pagina;

    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        pagina = new LoginPage(driver);
        validarLogoHome();
    }

    @Step(NOMBRE_PAGINA + "Se valida el logo de home")
    public void validarLogoHome() {
        Assert.assertTrue(pagina.getLoginLogo().isDisplayed(), "El logo de la p\u00E1gina de inicio no fue encontrado");
    }

    @Step(NOMBRE_PAGINA + "Se ingresa el nombre de usuario 'username'")
    public void ingresarUsername(String username) {
        Assert.assertTrue(pagina.getCampoUsername().isDisplayed(), "El campo 'Username' no fue encontrado");
        pagina.getCampoUsername().sendKeys(username);
    }

    @Step(NOMBRE_PAGINA + "Se ingresa el password '{contrasenia}'")
    public void ingresarContrasenia(String contrasenia) {
        Assert.assertTrue(pagina.getCampoPassword().isDisplayed(), "El campo 'Contrase\u00F1a' no fue encontrado");
        pagina.getCampoPassword().sendKeys(contrasenia);
    }

    @Step(NOMBRE_PAGINA + "El usuario hace click en login")
    public void clickLogin() {
        Assert.assertTrue(pagina.getBotonLogin().isDisplayed(), "El bot\u00F3n 'LOGIN' no fue encontrado");
        pagina.getBotonLogin().click();
    }

    @Step(NOMBRE_PAGINA + "Se valida el mensaje de error de contraseña incorrecta")
    public void validarMensajeErrorContraseniaIncorrecta() {
        Assert.assertTrue(pagina.getErrorMessageContainer().getText().contains("Username and password do not match"), "El mensaje de error de contraseña incorrecta no fue encontrado");
    }

    @Step(NOMBRE_PAGINA + "Se valida el mensaje de error de nombre de usuario requerido")
    public void validarMensajeErrorUsernameRequired() {
        Assert.assertTrue(pagina.getErrorMessageContainer().getText().contains("Username is required"), "El mensaje de error de nombre de usuario requerido no fue encontrado");
    }
}
