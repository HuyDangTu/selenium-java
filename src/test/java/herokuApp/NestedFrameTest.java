package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrameTest {
    @Test
    void verifyNestedFramesContent(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");


        //Switch to a web element frame
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame(driver.findElement(By.name("frame-left")));

        Assert.assertEquals(driver.findElement(By.xpath("/html/body")).getText(),"LEFT");

        //Switch to the parent frame of the current frame
        driver.switchTo().parentFrame();//frame top
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        Assert.assertEquals(driver.findElement(By.id("content")).getText(),"MIDDLE");

        driver.switchTo().parentFrame();//frame top
        driver.switchTo().frame(driver.findElement(By.name("frame-right")));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body")).getText(),"RIGHT");

        // Switch to default content (main html)
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body")).getText(),"BOTTOM");

        driver.quit();

    }
}
