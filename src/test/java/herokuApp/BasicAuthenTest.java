package herokuApp;

import core.BaseTest;
import herokuApp.pages.BasicAuthenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static utils.Browser.launchBrowser;

public class BasicAuthenTest extends BaseTest {

    @BeforeClass
    void setUp(){
        launchBrowser("chrome");
    }
    @Test
    void loginSuccessfully(){
        BasicAuthenPage basicAuthenPage = new BasicAuthenPage();
        basicAuthenPage.open();
        Assert.assertTrue(basicAuthenPage.isAuthenSuccessfull(By.cssSelector(".example p"),"Congratulations! You must have the proper credentials."));
    }
}
