package herokuApp;

import herokuApp.pages.LoginPage;
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

import static utils.Browser.launchBrowser;
import static utils.Browser.quit;

public class LoginTest {

    LoginPage loginPage ;

    @BeforeMethod
    public void setUp(){
        launchBrowser("chrome");
        loginPage = new LoginPage();
        loginPage.open();
    }

    @DataProvider(name = "loginData")
    Object[][] loginData(){
        return new Object[][]{
                {"tomsmith","SuperSecretPassword!","You logged into a secure area!"},
        };
    }

    @Test(dataProvider = "loginData")
    void successfullyLoginWithCredential(String username ,String password, String message) {
        loginPage.submitForm(username,password);
        Assert.assertTrue((loginPage.getFlashMessage("success").contains(message)));
    }

    @AfterMethod
    void tearDown(){
        quit();
    }
}
