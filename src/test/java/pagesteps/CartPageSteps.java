package pagesteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;

public class CartPageSteps {
    private final String NOMBRE_PAGINA = "Carro de Compras: ";
    private WebDriver driver;
    private CartPage pagina;

    public CartPageSteps(WebDriver driver) {
        this.driver = driver;
        pagina = new CartPage(driver);
        validarTituloYLogo();
    }

    @Step(NOMBRE_PAGINA + "Se valida el titulo y logo")
    public void validarTituloYLogo() {
        Assert.assertTrue(pagina.getTituloPagina().isDisplayed(), "El titúlo de la p\u00E1gina 'Your Cart' no fue encontrado");
        Assert.assertTrue(pagina.getLogoSwagLabs().isDisplayed(), "El logo 'SwagLabs' no fue encontrado");
    }

    @Step(NOMBRE_PAGINA + "Se valida la cantidad de productos en el carro de compras")
    public void validarCantidadProductos(int cantidad) {
        Assert.assertEquals(cantidad, pagina.getProductosCarroDeCompras().size(), "La cantidad de productos en el carro de compras no coincide con el establecido de '" + cantidad + "'");
    }

    @Step(NOMBRE_PAGINA + "Se valida el nombre del producto {nombreProducto}")
    public void validarNombreProducto(String nombreProducto) {
        Assert.assertEquals(nombreProducto, pagina.getProductoPorNombre(nombreProducto).getText(), "El nombre del producto en el carro de compras no coincide con el establecido de '" + nombreProducto + "'");
    }

    @Step(NOMBRE_PAGINA + "Se valida el precio del producto {nombreProducto}")
    public void validarPrecioProducto(String nombreProducto, String precioProducto) {
        Assert.assertEquals(precioProducto, pagina.getPrecioDelProducto(nombreProducto).getText(), "El precio del producto en el carro de compras no coincide con el establecido de '" + precioProducto + "'");
    }

    @Step(NOMBRE_PAGINA + "El usuario elimina un producto '{nombreProducto}' del carro de compras ")
    public void clickRemoveProducto(String nombreProducto) {
        Assert.assertTrue(pagina.getListaProductoPorNombre(nombreProducto).size() > 0, "No se encontro el producto con nombre " + nombreProducto);
        Assert.assertTrue(pagina.getBotonRemoveDelProducto(nombreProducto).isDisplayed(), "El botón REMOVE del producto " + nombreProducto + "no esta visible");
        pagina.getBotonRemoveDelProducto(nombreProducto).click();
    }

    @Step(NOMBRE_PAGINA + "Se valida la no existencia de un producto '{nombreProducto}' del carro de compras ")
    public void validarEliminacionProdcuto(String nombreProducto) {
        Assert.assertEquals(0, pagina.getListaProductoPorNombre(nombreProducto).size(), "Se encontro el producto con nombre " + nombreProducto + " la eliminacion del producto del carro de compras no fue correcta");
    }
}
