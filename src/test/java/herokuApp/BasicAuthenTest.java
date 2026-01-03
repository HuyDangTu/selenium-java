package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthenTest {

    @Test
    void loginSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(driver.findElement(By.cssSelector(".example p")).getText().contains("Congratulations! You must have the proper credentials."));
        driver.quit();
    }
}
