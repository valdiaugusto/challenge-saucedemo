package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private By tituloPagina = By.xpath("//div/span[contains(text(),'Products')]");
    private By logoSwagLabs = By.className("app_logo");
    private By productosInventario = By.className("inventory_item_name");
    private By carroDeCompras = By.className("shopping_cart_link");
    private By cantidadEnCarroDeCompras = By.className("shopping_cart_badge");
    private String agregarAlCarroProducto = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::div/button[text()='Add to cart']";
    private String precioDelProducto = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::div[contains(@class,'inventory_item_price')]";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTituloPagina() {
        return driver.findElement(tituloPagina);
    }

    public WebElement getLogoSwagLabs() {
        return driver.findElement(logoSwagLabs);
    }

    public List<WebElement> getProductosInventario() {
        return driver.findElements(productosInventario);
    }

    public WebElement getAgregarAlCarroProductoPorPosicion(int posicion) {
        return driver.findElement(By.xpath(String.format(agregarAlCarroProducto, getProductosInventario().get(posicion).getText())));
    }

    public List<WebElement> getListaAgregarAlCarroProductoPorPosicion(int posicion) {
        return driver.findElements(By.xpath(String.format(agregarAlCarroProducto, getProductosInventario().get(posicion).getText())));
    }

    public WebElement getPrecioDelProducto(String producto) {
        return driver.findElement(By.xpath(String.format(precioDelProducto, producto)));
    }

    public WebElement getCarroDeCompras() {
        return driver.findElement(carroDeCompras);
    }

    public WebElement getCantidadEnCarroDeCompras() {
        return driver.findElement(cantidadEnCarroDeCompras);
    }
}
