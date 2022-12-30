package pagesteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ProductsPage;
import utils.NumberUtils;

public class ProductsPageSteps {
    private static final String NOMBRE_PAGINA = "Productos: ";
    private ProductsPage pagina;
    private int posicionProducto;

    public ProductsPageSteps(WebDriver driver) {
        pagina = new ProductsPage(driver);
        validarTituloYLogo();
    }

    @Step(NOMBRE_PAGINA + "Se valida el titulo y logo")
    public void validarTituloYLogo() {
        Assert.assertTrue(pagina.getTituloPagina().isDisplayed(), "El titúlo de la p\u00E1gina 'Products' no fue encontrado");
        Assert.assertTrue(pagina.getLogoSwagLabs().isDisplayed(), "El logo 'SwagLabs' no fue encontrado");
    }

    @Step(NOMBRE_PAGINA + "Se valida la existencia de productos en el inventario para la compra")
    public void validarProductosDisponiblesInventarioDeCompra() {
        Assert.assertTrue(pagina.getProductosInventario().size() != 0, "No se encontraron productos en el inventario para la compra");
    }

    @Step(NOMBRE_PAGINA + "El usuario agrega al carro de compras un producto")
    public void clickAddToCartProductoAleatorio() {
        posicionProducto = NumberUtils.generarNumeroAleatorio(pagina.getProductosInventario().size());
        Assert.assertTrue(pagina.getAgregarAlCarroProductoPorPosicion(posicionProducto).isDisplayed(), "No se encontro el botón ADD TO CART del producto");
        pagina.getAgregarAlCarroProductoPorPosicion(posicionProducto).click();
    }

    @Step(NOMBRE_PAGINA + "El usuario agrega al carro un mismo producto dos veces")
    public void clickAddToCartUnMismoProductoAleatorioDosVeces() {
        posicionProducto = NumberUtils.generarNumeroAleatorio(pagina.getProductosInventario().size());
        Assert.assertTrue(pagina.getListaAgregarAlCarroProductoPorPosicion(posicionProducto).size() > 0, "No se encontro el botón ADD TO CART del producto agregando la primera unidad");
        Assert.assertTrue(pagina.getAgregarAlCarroProductoPorPosicion(posicionProducto).isDisplayed(), "El botón ADD TO CART del producto agregando la primera unidad no esta visible");
        pagina.getAgregarAlCarroProductoPorPosicion(posicionProducto).click();
        Assert.assertTrue(pagina.getListaAgregarAlCarroProductoPorPosicion(posicionProducto).size() > 0, "No se encontro el botón ADD TO CART del producto agregando la segunda unidad");
        Assert.assertTrue(pagina.getAgregarAlCarroProductoPorPosicion(posicionProducto).isDisplayed(), "El botón ADD TO CART del producto agregando la segunda unidad no esta visible");
        pagina.getAgregarAlCarroProductoPorPosicion(posicionProducto).click();
    }

    @Step(NOMBRE_PAGINA + "El usuario hace click en el carro de compras")
    public void clickCarroDeCompras() {
        Assert.assertTrue(pagina.getCarroDeCompras().isDisplayed(), "No se encontro el ícono del carro de compras");
        pagina.getCarroDeCompras().click();
    }

    @Step(NOMBRE_PAGINA + "Se valida la cantidad de {cantidad} productos en el carro de compras")
    public void validarCantidadDeProductosEnCarroDeCompras(int cantidad) {
        Assert.assertEquals(cantidad, Integer.parseInt(pagina.getCantidadEnCarroDeCompras().getText()), "La cantidad de productos agregados al carro de compras no coincide con el establecido de '" + cantidad + "'");
    }

    @Step(NOMBRE_PAGINA + "Se obtiene el nombre del producto en posicion {pos}")
    public String obtenerNombreDeProductoPorPosicion() {
        return pagina.getProductosInventario().get(posicionProducto).getText();
    }

    @Step(NOMBRE_PAGINA + "Se obtiene el precio del producto en posicion {pos}")
    public String obtenerPrecioDeProductoPorPosicion() {
        String nombreProducto = pagina.getProductosInventario().get(posicionProducto).getText();
        return pagina.getPrecioDelProducto(nombreProducto).getText();
    }
}
