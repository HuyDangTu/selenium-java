package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenImgTest {

    @Test
    void BrokenImgTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");

        driver.findElements(By.xpath("//div/img")).forEach(img -> {
            int natureHeight = Integer.parseInt(img.getDomProperty("naturalHeight"));
            int natureWeight = Integer.parseInt(img.getDomProperty("naturalHeight"));
            Assert.assertTrue(natureWeight>0);
            Assert.assertTrue(natureHeight>0);
        });
        driver.quit();
    }

}
