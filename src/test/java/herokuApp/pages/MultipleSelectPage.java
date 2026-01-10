package herokuApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.Browser.*;

public class MultipleSelectPage  {

    Select select;
    public void open(){
        visit("https://output.jsbin.com/osebed/2");
        select = new Select(getElement(By.id("fruits")));
    }

    public void selectOptions(List<String> options){
        options.forEach(select::selectByVisibleText);
    }

    public void deselectAll(){
        select.deselectAll();
    }

    public List<Boolean> isOptionsSelected(List<String> options){
        return options
                .stream()
                .map(option -> isSelected(By.xpath(String.format("//option[.='%s']",option))))
                .toList();
    }
}
