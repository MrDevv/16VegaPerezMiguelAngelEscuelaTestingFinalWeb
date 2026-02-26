package steps;

import org.junit.Assert;
import pages.InventoryPage;
import pages.LoginPage;

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
}
