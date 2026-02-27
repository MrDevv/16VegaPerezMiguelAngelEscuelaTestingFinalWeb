package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.List;

public class InventorySteps {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Step("iniciar sesión correctamente")
    public void iniciarSesionCorrectamente(String user, String password) {
        loginPage.open();
        loginPage.ingresarUsuario(user);
        loginPage.ingresarPassword(password);
        loginPage.hacerClicBotonLogin();
    }

    @Step("agregar un producto")
    public void agregarProducto() {
        inventoryPage.agregarProducto();
    }

    @Step("validar la cantidad de productos del carrito")
    public void validarCantidadProductosCarrito(String cantidad) {
        Assert.assertEquals(cantidad, inventoryPage.obtenerCantidadProductosCarrito());
    }

    @Step("agregar varios productos")
    public void agregarProductos() {
        inventoryPage.agregarProductos();
    }

    @Step("eliminar un producto")
    public void eliminarProducto() {
        inventoryPage.hacerClicEnEliminarProducto();
    }

    @Step("validar carrito de compra sin productos")
    public void validarCarritoSinCantidadProductos() {
        Assert.assertFalse(inventoryPage.isCantidadProductosCarritoVisible());
    }

    @Step("completar datos de compra")
    public void completarDatosDeCompra(String nombres, String apellidos, String codigo){
        inventoryPage.hacerClicIconoCarritoCompra();
        inventoryPage.hacerClicCheckout();
        inventoryPage.ingresarNombres(nombres);
        inventoryPage.ingresarApellidos(apellidos);
        inventoryPage.ingresarCodigoPostal(codigo);
    }

    @Step("dar clic en el botón de continuar")
    public void hacerClicContinuar(){
        inventoryPage.hacerClicContinuar();
    }

    @Step("dar clic en el botón finalizar compra")
    public void hacerClicFinalizarCompra() {
        inventoryPage.hacerClicFinalizar();
    }

    @Step("validar mensaje de compra")
    public void validarMensajeCompra(String mensaje){
        Assert.assertTrue(inventoryPage.validarMensajeCompra(mensaje));
    }

    @Step("validar mensaje de error")
    public void validarMensajeError(String mensaje){
        Assert.assertTrue(inventoryPage.validarMensajeError(mensaje));
    }

    @Step("dar clic en cancelar compra")
    public void hacerClicCancelar() {
        inventoryPage.hacerClicCancelar();
    }

    @Step("validar que se encuentre en la página de inventario")
    public void validarPaginaInvetory() {
        Assert.assertTrue(Serenity.getDriver().getCurrentUrl().endsWith("/inventory.html"));
    }

    @Step("seleccionar opcion ordenar por nombre de forma ascendente")
    public void seleccionarOpcionNombreAsc() {
        inventoryPage.seleccionarOpcionNombreAsc();
    }

    @Step("seleccionar opcion ordenar por nombre de forma descendente")
    public void seleccionarOpcionNombreDesc() {
        inventoryPage.seleccionarOpcionNombreDesc();
    }

    @Step("seleccionar opción ordenar por precio de forma ascedente")
    public void seleccionarOpcionPrecioAsc() {
        inventoryPage.seleccionarOpcionPrecioAsc();
    }

    @Step("seleccionar opción ordenar por precio de forma descedente")
    public void seleccionarOpcionPrecioDesc() {
        inventoryPage.seleccionarOpcionPrecioDesc();
    }

    @Step("validar orden de productos por nombre de forma ascendente")
    public void validarProductosAscNombre() {
        List<String> nombreProductos = inventoryPage.obtenerNombresProductos();
        List<String> nombreProductosOrdenadosAsc = nombreProductos.stream().sorted().toList();
        Assert.assertEquals(nombreProductos, nombreProductosOrdenadosAsc);
    }

    @Step("validar orden de productos por nombre de forma descendente")
    public void validarProductosDescNombre() {
        List<String> nombreProductos = inventoryPage.obtenerNombresProductos();
        List<String> nombreProductosOrdenadosDesc = nombreProductos.stream().unordered().toList();
        Assert.assertEquals(nombreProductos, nombreProductosOrdenadosDesc);
    }

    @Step("validar orden de productos por precio de forma ascendente")
    public void validarProductosAscPrecio() {
        List<Double> precioProductos = inventoryPage.obtenerPreciosProductos();
        List<Double> precioProductosOrdenadosAsc = precioProductos.stream().sorted().toList();
        Assert.assertEquals(precioProductos, precioProductosOrdenadosAsc);
    }

    @Step("validar orden de productos por precio de forma descendente")
    public void validarProductosDescPrecio() {
        List<Double> precioProductos = inventoryPage.obtenerPreciosProductos();
        List<Double> precioProductosOrdenadosDesc = precioProductos.stream().unordered().toList();
        Assert.assertEquals(precioProductos, precioProductosOrdenadosDesc);
    }

    @Step("validar precio total de los productos")
    public void validarPrecioTotalProductos() {
        Assert.assertTrue(inventoryPage.isPriceTotalProductsOK());
    }

    @Step("validar precio total de compra")
    public void validarPrecioTotalCompra() {
        Assert.assertTrue(inventoryPage.isPriceTotalPurchaseOK());
    }

    @Step("dar clic en el título de un producto en la página de inventario")
    public void darClicTituloProducto() {
        inventoryPage.hacerClicTituloProducto();
    }

    @Step("validar título en la página de detalle producto")
    public void validarTituloProductoDetalle(){
        Assert.assertTrue(inventoryPage.validarTituloProducto());
    }
}
