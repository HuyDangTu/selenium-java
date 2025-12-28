package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperlinkTest {

    @Test
    void successfullyFollowHyperlink(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/200"));
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'200 status')]")).isDisplayed());
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/301"));
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'301 status')]")).isDisplayed());
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/404"));
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'404 status')]")).isDisplayed());
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes/500"));
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'500 status')]")).isDisplayed());
        driver.findElement(By.linkText("here")).click();
    }
}
