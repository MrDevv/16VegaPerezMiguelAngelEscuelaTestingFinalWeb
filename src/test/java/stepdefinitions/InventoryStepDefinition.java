package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import steps.InventorySteps;

public class InventoryStepDefinition {

    @Steps
    InventorySteps inventorySteps;

    @Dado("que el usuario inicia sesión correctamente")
    public void iniciarSesionCorrectamente(){
        String user = Serenity.environmentVariables().getProperty("credentials.valid.username");
        String password = Serenity.environmentVariables().getProperty("credentials.valid.password");
        inventorySteps.iniciarSesionCorrectamente(user, password);
    }

    @Cuando("agregue un producto al carrito de compras")
    public void agregarProductoCarrito(){
        inventorySteps.agregarProducto();
    }

    @Cuando("agregue 3 productos al carrito de compras")
    public void agregarProductosCarrito(){
        inventorySteps.agregarProductos();
    }

    @Entonces("el carrito debe mostrar {string} producto")
    public void validarCantidadProductosCarrito(String cantidad){
        inventorySteps.validarCantidadProductosCarrito(cantidad);
    }

    @Cuando("luego le de clic en eliminar producto")
    public void eliminarProducto(){
        inventorySteps.eliminarProducto();
    }

    @Entonces("el carrito no debe mostrar ningún producto")
    public void validarCarritoSinCantidadProductos(){
        inventorySteps.validarCarritoSinCantidadProductos();
    }



}
