package herokuApp;

import herokuApp.pages.ContextMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenuTest {
    @Test
    void rightClick(){

        ContextMenuPage contextMenuPage = new ContextMenuPage();

        contextMenuPage.open();
        contextMenuPage.clickContextMenu(By.id("hot-spot"));
        contextMenuPage.confirmAlert();
    }
}
