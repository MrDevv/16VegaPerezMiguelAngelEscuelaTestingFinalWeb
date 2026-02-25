package utils;

public enum LoginErrorMessage {
    INVALID_CREDENTIALS(
            "Epic sadface: Username and password do not match any user in this service"
    ),
    LOCKED_OUT_USER(
            "Epic sadface: Sorry, this user has been locked out."
    );

    private final String message;

    LoginErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
