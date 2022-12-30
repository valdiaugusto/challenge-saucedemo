package tests;

import base.BaseSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pagesteps.CartPageSteps;
import pagesteps.LoginPageSteps;
import pagesteps.ProductsPageSteps;

@Epic("Products")
public class ProductsTest extends BaseSteps {
    private ProductsPageSteps productsPageSteps;
    private CartPageSteps cartPageSteps;
    private String nombreProducto;
    private String precioProducto;

    @Test(description = "SDEMO-008: Agregar un producto al carro de compras")
    @Description("Agregar un producto al carro de compras y verificar que el producto agregado sea el designado con el precio correcto.")
    public void products_SDEMO_008() {
        int cantidadProductos = 1;
        inicioSesion();
        productsPageSteps = new ProductsPageSteps(driver);
        productsPageSteps.validarProductosDisponiblesInventarioDeCompra();
        productsPageSteps.clickAddToCartProductoAleatorio();
        nombreProducto = productsPageSteps.obtenerNombreDeProductoPorPosicion();
        precioProducto = productsPageSteps.obtenerPrecioDeProductoPorPosicion();
        productsPageSteps.validarCantidadDeProductosEnCarroDeCompras(cantidadProductos);
        productsPageSteps.clickCarroDeCompras();
        cartPageSteps = new CartPageSteps(driver);
        cartPageSteps.validarCantidadProductos(cantidadProductos);
        cartPageSteps.validarNombreProducto(nombreProducto);
        cartPageSteps.validarPrecioProducto(nombreProducto, precioProducto);
    }

    @Test(description = "SDEMO-010: Eliminar un producto del carro de compras")
    @Description("Eliminar un producto previamente añadido al carro de compras.")
    public void products_SDEMO_010() {
        products_SDEMO_008();
        cartPageSteps.clickRemoveProducto(nombreProducto);
        cartPageSteps.validarEliminacionProdcuto(nombreProducto);
    }

    @Test(description = "SDEMO-011: Agregar un mismo producto dos veces")
    @Description("Agregar un mismo producto dos veces y verificar que sea el mismo producto el agregado al carro de compras con la suma de cantidad del producto y el precio total correcto")
    public void products_SDEMO_011() {
        int cantidadProductos = 2;
        inicioSesion();
        productsPageSteps = new ProductsPageSteps(driver);
        productsPageSteps.validarProductosDisponiblesInventarioDeCompra();
        productsPageSteps.clickAddToCartUnMismoProductoAleatorioDosVeces();
        nombreProducto = productsPageSteps.obtenerNombreDeProductoPorPosicion();
        precioProducto = productsPageSteps.obtenerPrecioDeProductoPorPosicion();
        productsPageSteps.validarCantidadDeProductosEnCarroDeCompras(cantidadProductos);
        productsPageSteps.clickCarroDeCompras();
        cartPageSteps = new CartPageSteps(driver);
        cartPageSteps.validarCantidadProductos(cantidadProductos);
        cartPageSteps.validarNombreProducto(nombreProducto);
        cartPageSteps.validarPrecioProducto(nombreProducto, precioProducto);
    }

    @Step("El usuario inicia sesion satisfactoriamente")
    public void inicioSesion() {
        String username = "standard_user";
        String password = "secret_sauce";
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.ingresarUsername(username);
        loginPageSteps.ingresarContrasenia(password);
        loginPageSteps.clickLogin();
    }
}
