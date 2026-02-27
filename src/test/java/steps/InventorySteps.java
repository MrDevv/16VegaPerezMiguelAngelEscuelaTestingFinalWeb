package steps;

import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.Arrays;
import java.util.List;

public class InventorySteps {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public void iniciarSesionCorrectamente(String user, String password) {
        loginPage.open();
        loginPage.ingresarUsuario(user);
        loginPage.ingresarPassword(password);
        loginPage.hacerClicBotonLogin();
    }

    public void agregarProducto() {
        inventoryPage.agregarProducto();
    }

    public void validarCantidadProductosCarrito(String cantidad) {
        Assert.assertEquals(cantidad, inventoryPage.obtenerCantidadProductosCarrito());
    }

    public void agregarProductos() {
        inventoryPage.agregarProductos();
    }

    public void eliminarProducto() {
        inventoryPage.hacerClicEnEliminarProducto();
    }

    public void validarCarritoSinCantidadProductos() {
        Assert.assertFalse(inventoryPage.isCantidadProductosCarritoVisible());
    }

    public void completarDatosDeCompra(String nombres, String apellidos, String codigo){
        inventoryPage.hacerClicIconoCarritoCompra();
        inventoryPage.hacerClicCheckout();
        inventoryPage.ingresarNombres(nombres);
        inventoryPage.ingresarApellidos(apellidos);
        inventoryPage.ingresarCodigoPostal(codigo);
    }

    public void hacerClicContinuar(){
        inventoryPage.hacerClicContinuar();
    }

    public void hacerClicFinalizarCompra() {
        inventoryPage.hacerClicFinalizar();
    }

    public void validarMensajeCompra(String mensaje){
        Assert.assertTrue(inventoryPage.validarMensajeCompra(mensaje));
    }

    public void validarMensajeError(String mensaje){
        Assert.assertTrue(inventoryPage.validarMensajeError(mensaje));
    }

    public void hacerClicCancelar() {
        inventoryPage.hacerClicCancelar();
    }

    public void validarPaginaInvetory() {
        Assert.assertTrue(Serenity.getDriver().getCurrentUrl().endsWith("/inventory.html"));
    }

    public void seleccionarOpcionNombreAsc() {
        inventoryPage.seleccionarOpcionNombreAsc();
    }

    public void seleccionarOpcionNombreDesc() {
        inventoryPage.seleccionarOpcionNombreDesc();
    }

    public void seleccionarOpcionPrecioAsc() {
        inventoryPage.seleccionarOpcionPrecioAsc();
    }

    public void seleccionarOpcionPrecioDesc() {
        inventoryPage.seleccionarOpcionPrecioDesc();
    }

    public void validarProductosAscNombre() {
        List<String> nombreProductos = inventoryPage.obtenerNombresProductos();
        List<String> nombreProductosOrdenadosAsc = nombreProductos.stream().sorted().toList();
        Assert.assertEquals(nombreProductos, nombreProductosOrdenadosAsc);
    }

    public void validarProductosDescNombre() {
        List<String> nombreProductos = inventoryPage.obtenerNombresProductos();
        List<String> nombreProductosOrdenadosDesc = nombreProductos.stream().unordered().toList();
        Assert.assertEquals(nombreProductos, nombreProductosOrdenadosDesc);
    }

    public void validarProductosAscPrecio() {
        List<Double> precioProductos = inventoryPage.obtenerPreciosProductos();
        List<Double> precioProductosOrdenadosAsc = precioProductos.stream().sorted().toList();
        Assert.assertEquals(precioProductos, precioProductosOrdenadosAsc);
    }

    public void validarProductosDescPrecio() {
        List<Double> precioProductos = inventoryPage.obtenerPreciosProductos();
        List<Double> precioProductosOrdenadosDesc = precioProductos.stream().unordered().toList();
        Assert.assertEquals(precioProductos, precioProductosOrdenadosDesc);
    }

    public void validarPrecioTotalProductos() {
        Assert.assertTrue(inventoryPage.isPriceTotalProductsOK());
    }

    public void validarPrecioTotalCompra() {
        Assert.assertTrue(inventoryPage.isPriceTotalPurchaseOK());
    }

    public void darClicTituloProducto() {
        inventoryPage.hacerClicTituloProducto();
    }

    public void validarTituloProductoDetalle(){
        Assert.assertTrue(inventoryPage.validarTituloProducto());
    }
}
