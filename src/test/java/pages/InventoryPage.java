package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class InventoryPage extends PageObject {

    @FindBy(className = "app_logo")
    WebElementFacade appLogo;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElementFacade buttonAddProductBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElementFacade buttonAddProductBackPack;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElementFacade buttonAddProductBolTShirt;

    @FindBy(className = "shopping_cart_badge")
    WebElementFacade spanCantidadCarrito;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElementFacade buttonRemoveBikeLight;

    @FindBy(className = "shopping_cart_badge")
    WebElementFacade spanCantidadProductos;

    public boolean isLogoVisible(){
        return appLogo.isVisible();
    }

    public boolean isUrlInventoryPage(){
        String url = getDriver().getCurrentUrl();
        return url.endsWith("inventory.html");
    }

    public void agregarProducto(){
        buttonAddProductBikeLight.click();
    }

    public String obtenerCantidadProductosCarrito(){
        return spanCantidadCarrito.getText();
    }

    public void agregarProductos() {
        buttonAddProductBikeLight.click();
        buttonAddProductBackPack.click();
        buttonAddProductBolTShirt.click();
    }

    public void hacerClicEnEliminarProducto() {
        buttonRemoveBikeLight.click();
    }

    public boolean isCantidadProductosCarritoVisible(){
        return spanCantidadProductos.isVisible();
    }
}
