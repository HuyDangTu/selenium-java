package herokuApp;

import core.BaseTest;
import herokuApp.pages.BrokenImgPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static utils.Browser.launchBrowser;

public class BrokenImgTest extends BaseTest {
    @BeforeClass
    void setUp(){
        launchBrowser("chrome");
    }
    @Test
    void BrokenImgTest(){

        BrokenImgPage brokenImgPage = new BrokenImgPage();
        brokenImgPage.open();

        Assert.assertTrue(brokenImgPage.checkImageBroken(By.xpath("//div/img[3]")));
        Assert.assertEquals(brokenImgPage.checkImagesBroken(By.xpath("//div/img")), List.of(false,false,true));
    }

}
