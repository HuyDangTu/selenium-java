package herokuApp;

import core.BaseTest;
import herokuApp.pages.CheckboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.Browser.launchBrowser;

public class CheckboxTest extends BaseTest {

    //WebDriver driver;
    //CheckboxPage checkboxPage;
    @BeforeClass
    void setUp(){
        launchBrowser("chrome");
    }

    @Test
    void successfullyCheckCheckboxes(){
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();

        checkboxPage.checkTheCheckbox(By.cssSelector("#checkboxes > input:nth-child(1)"));
        Assert.assertTrue(checkboxPage.isCheckBoxChecked(By.cssSelector("#checkboxes > input:nth-child(2)")));

        checkboxPage.checkTheCheckbox(By.cssSelector("#checkboxes > input:nth-child(3)"));
        Assert.assertTrue(checkboxPage.isCheckBoxChecked(By.cssSelector("#checkboxes > input:nth-child(3)")));
    }

    @Test
    void successfullyUncheckCheckboxes(){
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();

        checkboxPage.uncheckTheCheckbox(By.cssSelector("#checkboxes > input:nth-child(1)"));
        Assert.assertFalse(checkboxPage.isCheckBoxChecked(By.cssSelector("#checkboxes > input:nth-child(1)")));

        checkboxPage.uncheckTheCheckbox(By.cssSelector("#checkboxes > input:nth-child(3)"));
        Assert.assertFalse(checkboxPage.isCheckBoxChecked(By.cssSelector("#checkboxes > input:nth-child(3)")));
    }

}

