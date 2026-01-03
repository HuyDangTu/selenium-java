package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSlideBarTest {
    @Test
    void slider (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions actions = new Actions(driver);
        WebElement input = driver.findElement(By.cssSelector(".sliderContainer input"));
        int width = input.getSize().getWidth();

        actions.clickAndHold(input)
                .moveByOffset(width, 0)
                .perform();

        Assert.assertEquals(driver.findElement(By.id("range")).getText(), "5");

    }
}
