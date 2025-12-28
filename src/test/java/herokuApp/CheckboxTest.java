package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest {

    WebDriver driver;

    @BeforeMethod
    void setUp(){
         driver = new ChromeDriver();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

    @Test
    void successfullyCheckCheckboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        check(By.cssSelector("#checkboxes > input:nth-child(1)"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)")).isSelected());

        check(By.cssSelector("#checkboxes > input:nth-child(3)"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)")).isSelected());
    }

    @Test
    void successfullyUncheckCheckboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        unCheck(By.cssSelector("#checkboxes > input:nth-child(1)"));
        Assert.assertFalse(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)")).isSelected());

        unCheck(By.cssSelector("#checkboxes > input:nth-child(3)"));
        Assert.assertFalse(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)")).isSelected());
    }

    void check(By locator ) {
        WebElement checkbox1 = driver.findElement(locator);
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    void unCheck(By locator){
        WebElement checkbox1 =  driver.findElement(locator);
        if(checkbox1.isSelected()){
            checkbox1.click();
        }
    }
}

