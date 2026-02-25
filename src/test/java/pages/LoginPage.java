package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade inputUsuario;

    @FindBy(id = "password")
    WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    WebElementFacade buttonLogin;

    @FindBy(css = "[data-test='error']")
    WebElementFacade mensajeError;

    public void ingresarUsuario(String usuario) {
        this.inputUsuario.type(usuario);
    }

    public void ingresarPassword(String password) {
        this.inputPassword.type(password);
    }

    public void hacerClicBotonLogin() {
        buttonLogin.click();
    }

    public void validarMensajeErrorVisible(){
        mensajeError.shouldBeVisible();
    }

    public void validarMensajeError(String mensajeEsperado) {
        mensajeError.shouldContainText(mensajeEsperado);
    }
}
