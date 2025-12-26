package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    @Test
    void checkbox2IsCheckedByDefault(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is NOT selected by default");
        driver.quit();
    }
    @Test
    void selectOnlyCheckbox1(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }

        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        if(checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertTrue(checkbox1.isSelected(),"Checkbox1 is not selected");
        Assert.assertFalse(checkbox2.isSelected(),"Checkbox2 is selected");
        driver.quit();
    }
    @Test
    void selectOnlyCheckbox2(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        if(checkbox1.isSelected()){
            checkbox1.click();
        }

        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        if(!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is not selected");
        Assert.assertFalse(checkbox1.isSelected(),"Checkbox1 is selected");
        driver.quit();
    }
    @Test
    void selectAllCheckbox1(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }

        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertTrue(checkbox1.isSelected(),"Checkbox1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is not selected");
        driver.quit();
    }

}
