package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertTest {

    @Test
    void JSAlertPopUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");
        driver.quit();
    }

    @Test
    void JSConfirmPopUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        driver.switchTo().alert().dismiss();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Cancel");
        driver.quit();
    }

    @Test
    void JSPromptPopUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You entered: hello");
        driver.quit();
    }
}
