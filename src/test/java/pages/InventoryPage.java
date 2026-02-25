package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class InventoryPage extends PageObject {

    @FindBy(className = "app_logo")
    WebElementFacade appLogo;

    public boolean isLogoVisible(){
        return appLogo.isVisible();
    }

    public boolean isUrlInventoryPage(){
        String url = getDriver().getCurrentUrl();
        return url.endsWith("inventory.html");
    }

}
