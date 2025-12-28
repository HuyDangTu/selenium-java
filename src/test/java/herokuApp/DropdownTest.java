package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {

    @Test
    void successfullySelectOption1(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        driver.findElement(By.cssSelector("#dropdown")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();

        //Assert.assertTrue(driver.findElement(By.cssSelector("option[value='1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());

        driver.quit();
    }

    @Test
    void successfullySelectOption2(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.cssSelector("#dropdown")));
        //select.selectByValue("2");
        select.selectByVisibleText("Option 2");

        //Assert.assertTrue(driver.findElement(By.cssSelector("option[value='1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 2']")).isSelected());

        driver.quit();
    }


    @Test
    void successfullySelectMultipleOption() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());

        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());
    }

    private By getOption(String visibleText) {
        return By.cssSelector(String.format("//option[.='%s']", visibleText));
    }

    public boolean isSelected(By locator){
        WebDriver driver = new ChromeDriver();
        return driver.findElement(locator).isSelected();
    }

}
