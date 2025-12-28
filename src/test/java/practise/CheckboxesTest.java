package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {

    ChromeOptions option = new ChromeOptions();

    WebDriver driver = new ChromeDriver(option);

    @Test
    void checkbox2IsCheckedByDefault(){

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is NOT selected by default");
        driver.quit();
    }
    @Test
    void selectOnlyCheckbox1(){

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        check(checkbox1);

        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        uncheck(checkbox2);

        Assert.assertTrue(checkbox1.isSelected(),"Checkbox1 is not selected");
        Assert.assertFalse(checkbox2.isSelected(),"Checkbox2 is selected");
        driver.quit();
    }
    @Test
    void selectOnlyCheckbox2(){

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        uncheck(checkbox1);

        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        check(checkbox2);

        Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is not selected");
        Assert.assertFalse(checkbox1.isSelected(),"Checkbox1 is selected");
        driver.quit();
    }
    @Test
    void selectAllCheckbox1(){

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        check(checkbox1);

        WebElement checkbox2 =  driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        check(checkbox1);

        Assert.assertTrue(checkbox1.isSelected(),"Checkbox1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is not selected");
        driver.quit();
    }

    void check(WebElement checkbox){
        if(!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    void uncheck(WebElement checkbox){
        if(checkbox.isSelected()) {
            checkbox.click();
        }
    }

}
