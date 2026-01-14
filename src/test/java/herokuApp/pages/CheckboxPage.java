package herokuApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.Browser.*;

public class CheckboxPage {

    public void open(){
        visit("https://the-internet.herokuapp.com/checkboxes");
    }
    public void checkTheCheckbox(By locator){
        check(locator);
    }
    public void uncheckTheCheckbox(By locator){
        uncheck(locator);
    }
    public boolean isCheckBoxChecked(By locator){
        return isSelected(locator);
    }

}
