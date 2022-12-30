package tests;

import base.BaseSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pagesteps.LoginPageSteps;
import pagesteps.ProductsPageSteps;

@Epic("Login")
@Feature("Login Test Suite")
public class LoginTest extends BaseSteps {
    private LoginPageSteps loginPageSteps;
    private String username;
    private String password;

    @Test(description = "SDEMO-001: Login con usuario y contraseña válidos")
    @Description("Inicio de sesión desde la página principal un usuario y contraseña validas.")
    public void login_SDEMO_001() {
        username = "standard_user";
        password = "secret_sauce";
        loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.ingresarUsername(username);
        loginPageSteps.ingresarContrasenia(password);
        loginPageSteps.clickLogin();
        new ProductsPageSteps(driver);
    }

    @Test(description = "SDEMO-002: Login con usuario valido y contraseña invalida")
    @Description("Inicio de sesión desde la página principal un usuario valido y contraseña invalida para el usuario.")
    public void login_SDEMO_002() {
        username = "standard_user";
        password = "invalidpassword";
        loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.ingresarUsername(username);
        loginPageSteps.ingresarContrasenia(password);
        loginPageSteps.clickLogin();
        loginPageSteps.validarMensajeErrorContraseniaIncorrecta();
    }

    @Test(description = "SDEMO-005: Login con usuario vacio y contraseña vacia")
    @Description("Inicio de sesión desde la página principal no ingresando usuario ni contraseña en los campos definidos.")
    public void login_SDEMO_005() {
        username = "";
        password = "";
        loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.ingresarUsername(username);
        loginPageSteps.ingresarContrasenia(password);
        loginPageSteps.clickLogin();
        loginPageSteps.validarMensajeErrorUsernameRequired();
    }
}
