package herokuApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Browser;
import utils.Browser.*;

import static utils.Browser.*;

public class LoginPage {

    public void open(){
        visit("https://the-internet.herokuapp.com/login");
    }

    public void submitForm(String username, String password){
        fill(By.id("username"), username);
        fill(By.id("password"), password);
        click(By.cssSelector("button[type='submit']"));
    }

    public String getFlashMessage(String type){
        return getText(By.className(type));
    }
}
