package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import steps.LoginSteps;
import utils.LoginErrorMessage;

public class LoginStepDefinitions {

    @Steps
    private LoginSteps loginSteps;

    private String user;
    private String password;

    @Dado("que el usuario abre la página de SouceDemo")
    public void abrirPagina(){
        loginSteps.abrirPagina();
    }

    @Cuando("ingresa el usuario válido")
    public void ingresarUsuario(){
        user = Serenity.environmentVariables().getProperty("credentials.valid.username");
        loginSteps.ingresarUsuario(user);
    }

    @Y("la contraseña válida")
    public void ingresarPassword(){
        password = Serenity.environmentVariables().getProperty("credentials.valid.password");
        loginSteps.ingresarPassword(password);
    }

    @Y("hace clic en el botón iniciar sesión")
    public void iniciarSesion(){
        loginSteps.iniciarSesion();
    }

    @Entonces("se muestra la página de inventario")
    public void mostrarPaginaInventario(){
        loginSteps.validarPaginaInventario();
    }

    @Cuando("ingresa el usuario no válido")
    public void ingresarUsuarioInvalido(){
        user = Serenity.environmentVariables().getProperty("credentials.invalid.username");
        loginSteps.ingresarUsuario(user);
    }

    @Y("la contraseña no válida")
    public void ingresarPasswordInvalida(){
        password = Serenity.environmentVariables().getProperty("credentials.invalid.password");
        loginSteps.ingresarPassword(password);
    }

    @Entonces("se muestra un mensaje de error con un texto de credenciales incorrectas")
    public void mostrarMensajeCredencialesIncorrectas(){
        loginSteps.validarMensajeCredencialesIncorrectas(LoginErrorMessage.INVALID_CREDENTIALS.getMessage());
    }

    @Cuando("ingresa el usuario bloqueado")
    public void ingresarUsuarioBloqueado(){
        user = Serenity.environmentVariables().getProperty("credentials.locked.username");
        loginSteps.ingresarUsuario(user);
    }

    @Entonces("se muestra un mensaje de error con un texto de usuario bloqueado")
    public void mostrarMensajeUsuarioBloqueado(){
        loginSteps.validarMensajeUsuarioBloqueado(LoginErrorMessage.LOCKED_OUT_USER.getMessage());
    }



}
