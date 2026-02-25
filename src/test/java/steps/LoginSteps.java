package steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Step("Abrir SauceDemo")
    public void abrirPagina(){
        loginPage.open();
    }

    @Step("Ingresar el usuario")
    public void ingresarUsuario(String usuario) {
        loginPage.ingresarUsuario(usuario);
    }

    @Step("Ingresar la contraseña")
    public void ingresarPassword(String password) {
        loginPage.ingresarPassword(password);
    }

    @Step("Iniciar sesión")
    public void iniciarSesion() {
        loginPage.hacerClicBotonLogin();
    }

    @Step("Validar pagina de inventario")
    public void validarPaginaInventario() {
        Assert.assertTrue(inventoryPage.isLogoVisible());
        Assert.assertTrue(inventoryPage.isUrlInventoryPage());
    }

    @Step("Validar mensaje de credenciales incorrectas")
    public void validarMensajeCredencialesIncorrectas(String mensajeEsperado) {
        loginPage.validarMensajeErrorVisible();
        loginPage.validarMensajeCredencialesIncorrectas(mensajeEsperado);
    }
}
