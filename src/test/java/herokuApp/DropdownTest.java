package herokuApp;

import core.BaseTest;
import herokuApp.pages.DropdownPage;
import herokuApp.pages.MultipleSelectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Browser;

import java.util.List;

import static utils.Browser.launchBrowser;
import static utils.Browser.quit;

public class DropdownTest extends BaseTest {

    @BeforeClass
    void setUp(){
        launchBrowser("chrome");
    }

    @DataProvider
    Object[][] options(){
        return new Object[][]{
                {"Option 1"},
                {"Option 2"}
        };
    }

    @Test(dataProvider="options")
    void successfullySelectOption(String option){
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.open();
        dropdownPage.selectOption(option);
        Assert.assertTrue(dropdownPage.isOptionSelected(option));
    }

    @Test
    void successfullySelectMultipleOption() {
        MultipleSelectPage multipleSelectPage = new MultipleSelectPage();
        multipleSelectPage.open();

        multipleSelectPage.selectOptions(List.of("Banana","Apple"));
        Assert.assertEquals(multipleSelectPage.isOptionsSelected(List.of("Banana","Apple")),List.of(true,true));

        multipleSelectPage.deselectAll();
        Assert.assertEquals(multipleSelectPage.isOptionsSelected(List.of("Banana","Apple","Orange","Grape")),List.of(false,false,false,false));
    }
}
