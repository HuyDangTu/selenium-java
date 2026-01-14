package herokuApp.pages;

import org.openqa.selenium.By;

import static utils.Browser.isMessageDisplayed;
import static utils.Browser.visit;

public class BasicAuthenPage {

    public void open(){
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    public boolean isAuthenSuccessfull(By locator, String text){
        return isMessageDisplayed(locator,text);
    }
}
