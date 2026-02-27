package utils.constants;

public enum LoginErrorMessage {
    INVALID_CREDENTIALS(
            "Epic sadface: Username and password do not match any user in this service"
    ),
    LOCKED_OUT_USER(
            "Epic sadface: Sorry, this user has been locked out."
    ),
    USERNAE_REQUIRED(
            "Epic sadface: Username is required"
    ),
    PASSWORD_REQUIRED(
            "Epic sadface: Password is required"
    );

    private final String message;

    LoginErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
