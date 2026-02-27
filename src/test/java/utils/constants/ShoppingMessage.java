package utils.constants;

public enum ShoppingMessage {

    MESSAGE_OK(
            "Thank you for your order!"
    ),
    NAME_REQUIRED(
            "Error: First Name is required"
    ),
    LAST_NAME_REQUIRED(
            "Error: Last Name is required"
    ),
    POSTAL_CODE_REQUIRED(
            "Error: Postal Code is required"
    );

    private String message;

    ShoppingMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }



}
