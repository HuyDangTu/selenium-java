package herokuApp;

import herokuApp.pages.DragAndDropPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static utils.Browser.launchBrowser;

public class DragDropTest {

    @BeforeClass
    void setUp(){
        launchBrowser("chrome");
    }

    @Test
    void dragDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.open();
        dragAndDropPage.dragAndDropElement(By.id("column-a"),By.id("column-b"));

        Assert.assertTrue(dragAndDropPage.checkDragAndDropSuccess(By.cssSelector("#column-a header"),"B"));
        Assert.assertTrue(dragAndDropPage.checkDragAndDropSuccess(By.cssSelector("#column-b header"),"A"));
    }
}
