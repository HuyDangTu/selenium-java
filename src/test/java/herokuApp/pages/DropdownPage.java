package herokuApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utils.Browser.*;

public class DropdownPage {

    public void open(){
        visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String optionName){
        Select select = new Select(getElement(By.cssSelector("#dropdown")));
        select.selectByVisibleText(optionName);
    }

    public boolean isOptionSelected(String optionName){
        return isSelected(By.xpath(String.format("//option[.='%s']",optionName)));
    }
}
