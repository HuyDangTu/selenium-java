package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest {

    @Test
    void hoverTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WebElement user1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));

        actions.moveToElement(user1).perform(); // hover to user avatar 1

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='figure'][1]/div[@class='figcaption']")).isDisplayed());
    }
}
