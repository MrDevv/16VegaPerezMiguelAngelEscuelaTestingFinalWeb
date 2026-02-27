package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.Helpers;

import java.util.List;

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

    @FindBy(className = "shopping_cart_container")
    WebElementFacade cartContainer;

    @FindBy(id = "checkout")
    WebElementFacade buttonCheckout;

    @FindBy(id = "first-name")
    WebElementFacade inputNombres;

    @FindBy(id = "last-name")
    WebElementFacade inputApellidos;

    @FindBy(id = "postal-code")
    WebElementFacade inputCodigoPostal;

    @FindBy(id = "continue")
    WebElementFacade buttonContinue;

    @FindBy(id = "finish")
    WebElementFacade buttonFinish;

    @FindBy(className = "complete-header")
    WebElementFacade containerMensajeCompra;

    @FindBy(className = "error-message-container")
    WebElementFacade mensajeError;

    @FindBy(id = "cancel")
    WebElementFacade buttonCancelar;

    @FindBy(className = "inventory_item_name")
    List<WebElementFacade> nombresProductos;

    @FindBy(className = "product_sort_container")
    WebElementFacade filtroOrdenamiento;

    @FindBy(className = "inventory_item_price")
    List<WebElementFacade> preciosProductos;

    @FindBy(className = "summary_subtotal_label")
    WebElementFacade precioTotalProductos;

    @FindBy(className = "summary_total_label")
    WebElementFacade precioTotalCompra;

    @FindBy(className = "summary_tax_label")
    WebElementFacade precioTax;

    @FindBy(id = "item_4_title_link")
    WebElementFacade enlaceProducto4;

    String tituloProductoInventoryPage;

    @FindBy(className = "inventory_details_name")
    WebElementFacade tituloDetalleProducto;

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

    public void hacerClicIconoCarritoCompra() {
        cartContainer.click();
    }

    public void hacerClicCheckout() {
        buttonCheckout.click();
    }

    public void ingresarNombres(String nombres){
        inputNombres.type(nombres);
    }

    public void ingresarApellidos(String apellidos){
        inputApellidos.type(apellidos);
    }

    public void ingresarCodigoPostal(String codigo){
        inputCodigoPostal.type(codigo);
    }

    public void hacerClicContinuar() {
        buttonContinue.click();
    }

    public void hacerClicFinalizar(){
        buttonFinish.click();
    }

    public boolean validarMensajeCompra(String mensaje){
        return containerMensajeCompra.containsText(mensaje);
    }

    public boolean validarMensajeError(String mensaje){
        return mensajeError.containsText(mensaje);
    }

    public void hacerClicCancelar() {
        buttonCancelar.click();
    }

    public void seleccionarOpcionNombreAsc(){
        filtroOrdenamiento.selectByValue("az");
    }

    public void seleccionarOpcionNombreDesc(){
        filtroOrdenamiento.selectByValue("za");
    }

    public void seleccionarOpcionPrecioAsc() {
        filtroOrdenamiento.selectByValue("lohi");
    }

    public void seleccionarOpcionPrecioDesc() {
        filtroOrdenamiento.selectByValue("hilo");
    }

    public List<String> obtenerNombresProductos(){
        return Helpers.obtenerNombresProductos(nombresProductos);
    }

    public List<Double> obtenerPreciosProductos(){
        return Helpers.obtenerPreciosProductos(preciosProductos);
    }


    public boolean isPriceTotalProductsOK() {
        double precioTotalProductos = obtenerPreciosProductos().stream().mapToDouble(Double::doubleValue).sum();
        double precioTotalPage = Double.parseDouble(
                this.precioTotalProductos.getText().split(" ")[2]
                        .replace("$", ""));
        return precioTotalProductos == precioTotalPage;
    }

    public boolean isPriceTotalPurchaseOK(){
        double precioTotalProductsPage = Double.parseDouble(
                this.precioTotalProductos.getText().split(" ")[2]
                        .replace("$", ""));

        double precioTaxPage = Double.parseDouble(
                  this.precioTax.getText().split(" ")[1]
                          .replace("$", ""));

        double precioTotalPage = Double.parseDouble(
                this.precioTotalCompra.getText().split(" ")[1]
                        .replace("$", ""));

        return precioTotalPage == (precioTotalProductsPage + precioTaxPage);
    }

    public void hacerClicTituloProducto() {
        tituloProductoInventoryPage = enlaceProducto4.getElement().getText();
        enlaceProducto4.click();
    }

    public boolean validarTituloProducto(){
        return tituloProductoInventoryPage.equalsIgnoreCase(tituloDetalleProducto.getText());
    }
}
