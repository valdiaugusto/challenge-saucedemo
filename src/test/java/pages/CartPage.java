package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By tituloPagina = By.xpath("//div/span[contains(text(),'Your Cart')]");
    private By logoSwagLabs = By.className("app_logo");
    private By productosCarroDeCompras = By.className("inventory_item_name");
    private String productoPorNombre = "//div[@class='cart_list']//div[contains(text(),'%s')]";
    private String precioDelProducto = "//div[contains(text(),'%s')]/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_price']";
    private String cantidadDelProducto = "//div[contains(text(),'%s')]/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']";
    private String botonRemoveDelProducto = "//div[contains(text(),'%s')]/ancestor::div[@class='cart_item']/descendant::button[contains(text(),'Remove')]";

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTituloPagina() {
        return driver.findElement(tituloPagina);
    }

    public WebElement getLogoSwagLabs() {
        return driver.findElement(logoSwagLabs);
    }

    public List<WebElement> getProductosCarroDeCompras() {
        return driver.findElements(productosCarroDeCompras);
    }

    public WebElement getProductoPorNombre(String producto) {
        return driver.findElement(By.xpath(String.format(productoPorNombre, producto)));
    }

    public List<WebElement> getListaProductoPorNombre(String producto) {
        return driver.findElements(By.xpath(String.format(productoPorNombre, producto)));
    }

    public WebElement getPrecioDelProducto(String producto) {
        return driver.findElement(By.xpath(String.format(precioDelProducto, producto)));
    }

    public WebElement getBotonRemoveDelProducto(String producto) {
        return driver.findElement(By.xpath(String.format(botonRemoveDelProducto, producto)));
    }
}
