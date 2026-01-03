package herokuApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CrollToBottomtest {
    @Test
    void scrollToBottom() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions actions = new Actions(driver);

        for (int i = 0; i < 10; i++) {
            actions.scrollByAmount(0,1000).perform();
            Thread.sleep(1000);
        }
    }
}
