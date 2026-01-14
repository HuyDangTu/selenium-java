package herokuApp.pages;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class ContextMenuPage {

    public void open(){
        visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void clickContextMenu(By locator){
        rightClickContextMenu(locator);
    }

    public void confirmAlert(){
        acceptAlert();
    }

}
