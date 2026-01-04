package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {


    WebDriver driver;




    @AfterMethod
    void tearDown(){
        driver.quit();
    }

    @DataProvider
    Object[][] browserDataProvider() {
        return new Object[][]{
                {"chrome","--headless"},
                {"edge","--headless"},
                {"firefox",""}
        };
    }

    void setUp(String browser,String option){
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOption = new ChromeOptions();
                chromeOption.addArguments(option);
                driver = new ChromeDriver(chromeOption);
                break;
            case "edge":
                EdgeOptions edgeOption = new EdgeOptions();
                edgeOption.addArguments(option);
                driver = new EdgeDriver(edgeOption);
                break;
            case "firefox":
                FirefoxOptions firefoxOption = new FirefoxOptions();
                firefoxOption.addArguments(option);
                driver = new FirefoxDriver(firefoxOption);
                break;
        }
    }

    @Test(dataProvider = "browserDataProvider")
    void successfullyLoginWithCredential(String browser,String options) throws InterruptedException {

        setUp(browser,options);
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("button[type=submit")).click();
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
    }

    @Test(dataProvider = "browserDataProvider")
    void failedToLoginWithInvalidUsername(String browser,String options) {
        setUp(browser,options);
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("InvalidUsername");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
    }

    @Test(dataProvider = "browserDataProvider")
    void failedToLoginWithInvalidPassword(String browser,String options) {
        setUp(browser,options);
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("InvalidPassword!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
    }

}
