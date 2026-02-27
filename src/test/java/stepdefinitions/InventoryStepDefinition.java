package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import steps.InventorySteps;
import utils.Helpers;
import utils.constants.ShoppingMessage;

public class InventoryStepDefinition {

    @Steps
    InventorySteps inventorySteps;

    @Dado("que el usuario inicia sesión correctamente")
    public void iniciarSesionCorrectamente(){
        String user = Serenity.environmentVariables().getProperty("credentials.valid.username");
        String password = Serenity.environmentVariables().getProperty("credentials.valid.password");
        inventorySteps.iniciarSesionCorrectamente(user, password);
    }

    @Cuando("ha agregado un producto al carrito de compras")
    public void agregarProductoCarrito(){
        inventorySteps.agregarProducto();
    }

    @Cuando("agrega 3 productos al carrito de compras")
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

    @Cuando("completa el proceso de compra con datos válidos")
    public void completarProcesoDeCompraDatosValidos(){
        String nombres = Serenity.environmentVariables().getProperty("credentials.data_user.name");
        String apellidos = Serenity.environmentVariables().getProperty("credentials.data_user.lastName");
        String codigoPostal = Serenity.environmentVariables().getProperty("credentials.data_user.postalCode");
        inventorySteps.completarDatosDeCompra(nombres, apellidos, codigoPostal);
        inventorySteps.hacerClicContinuar();
        inventorySteps.hacerClicFinalizarCompra();
    }

    @Entonces("debería ver el mensaje de confirmación de compra exitosa")
    public void validarMensajeCompraExitosa() {
        inventorySteps.validarMensajeCompra(ShoppingMessage.MESSAGE_OK.getMessage());
    }

    @Cuando("completa el proceso de compra con datos válidos sin el nombre")
    public void completarProcesoDeCompraDatosValidosSinNombre() {
        String nombres = "";
        String apellidos = Serenity.environmentVariables().getProperty("credentials.data_user.lastName");
        String codigoPostal = Serenity.environmentVariables().getProperty("credentials.data_user.postalCode");
        inventorySteps.completarDatosDeCompra(nombres, apellidos, codigoPostal);
        inventorySteps.hacerClicContinuar();
    }

    @Entonces("debería ver el mensaje de error el nombre es requerido")
    public void validarMensajeNombreRequerido() {
        inventorySteps.validarMensajeError(ShoppingMessage.NAME_REQUIRED.getMessage());
    }

    @Cuando("completa el proceso de compra con datos válidos sin el apellido")
    public void completarProcesoDeCompraDatosValidosSinApellido(){
        String nombres = Serenity.environmentVariables().getProperty("credentials.data_user.name");
        String apellidos = "";
        String codigoPostal = Serenity.environmentVariables().getProperty("credentials.data_user.postalCode");
        inventorySteps.completarDatosDeCompra(nombres, apellidos, codigoPostal);
        inventorySteps.hacerClicContinuar();
    }

    @Entonces("debería ver el mensaje de error el apellido es requerido")
    public void validarMensajeApellidoRequerido() {
        inventorySteps.validarMensajeError(ShoppingMessage.LAST_NAME_REQUIRED.getMessage());
    }

    @Cuando("completa el proceso de compra con datos válidos sin el código postal")
    public void completarProcesoDeCompraDatosValidosSinCodigoPostal(){
        String nombres = Serenity.environmentVariables().getProperty("credentials.data_user.name");
        String apellidos = Serenity.environmentVariables().getProperty("credentials.data_user.lastName");
        String codigoPostal = "";
        inventorySteps.completarDatosDeCompra(nombres, apellidos, codigoPostal);
        inventorySteps.hacerClicContinuar();
    }

    @Entonces("debería ver el mensaje de error el código postal es requerido")
    public void verificarMensajeCodigoPostalRequerido() {
        inventorySteps.validarMensajeError(ShoppingMessage.POSTAL_CODE_REQUIRED.getMessage());
    }

    @Y("complete sus datos")
    public void completarDatosCompra(){
        String nombres = Serenity.environmentVariables().getProperty("credentials.data_user.name");
        String apellidos = Serenity.environmentVariables().getProperty("credentials.data_user.lastName");
        String codigoPostal = Serenity.environmentVariables().getProperty("credentials.data_user.postalCode");
        inventorySteps.completarDatosDeCompra(nombres, apellidos, codigoPostal);
        inventorySteps.hacerClicContinuar();
    }

    @Cuando("le de clic en cancelar")
    public void hacerClicCancelar(){
        inventorySteps.hacerClicCancelar();
    }

    @Entonces("debería volver a la página de inventario")
    public void validarPaginaInvetory(){
        inventorySteps.validarPaginaInvetory();
    }

    @Cuando("seleccione la opción de ordernar por {string} de manera {string}")
    public void ordenarProductos(String opcion, String orden){
        if (opcion.equalsIgnoreCase("nombre")){
            this.ordenarPorNombre(orden);
        }else if(opcion.equalsIgnoreCase("precio")){
            this.ordenarPorPrecio(orden);
        }
    }

    public void ordenarPorNombre(String orden){
        if (orden.equalsIgnoreCase("ascendente")){
            inventorySteps.seleccionarOpcionNombreAsc();
        }else{
            inventorySteps.seleccionarOpcionNombreDesc();
        }
    }

    public void ordenarPorPrecio(String orden){
        if (orden.equalsIgnoreCase("ascendente")){
            inventorySteps.seleccionarOpcionPrecioAsc();
        }else{
            inventorySteps.seleccionarOpcionPrecioDesc();
        }
    }

    @Entonces("debería ver los productos ordenados por {string} de manera {string}")
    public void validarOrdenProductos(String opcion, String orden){
        if (opcion.equalsIgnoreCase("nombre")){
            this.validarPorNombre(orden);
        }else if(opcion.equalsIgnoreCase("precio")){
            this.validarPorPrecio(orden);
        }
    }

    public void validarPorNombre(String orden){
        if (orden.equalsIgnoreCase("ascendente")){
            inventorySteps.validarProductosAscNombre();
        }else{
            inventorySteps.validarProductosDescNombre();
        }
    }

    public void validarPorPrecio(String orden){
        if (orden.equalsIgnoreCase("ascendente")){
            inventorySteps.validarProductosAscPrecio();
        }else{
            inventorySteps.validarProductosDescPrecio();
        }
    }

    @Cuando("revisa los detalles de la compra")
    public void navegarHastaDetalleCompra(){
        String nombres = Serenity.environmentVariables().getProperty("credentials.data_user.name");
        String apellidos = Serenity.environmentVariables().getProperty("credentials.data_user.lastName");
        String codigoPostal = Serenity.environmentVariables().getProperty("credentials.data_user.postalCode");
        inventorySteps.completarDatosDeCompra(nombres, apellidos, codigoPostal);
        inventorySteps.hacerClicContinuar();
    }

    @Entonces("el precio total de los productos debería ser el correcto")
    public void validarPrecioTotalProductos(){
        inventorySteps.validarPrecioTotalProductos();
    }

    @Entonces("el precio total de la compra debería ser el correcto")
    public void validarPrecioTotalCompra(){
        inventorySteps.validarPrecioTotalCompra();
    }

    @Cuando("da clic al título de un producto")
    public void darClicTituloProducto(){
        inventorySteps.darClicTituloProducto();
    }

    @Entonces("debería ver el detalle del producto")
    public void validarDetalleProducto(){
        inventorySteps.validarTituloProductoDetalle();
    }

}
