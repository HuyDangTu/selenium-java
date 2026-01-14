package herokuApp;

import core.BaseTest;
import herokuApp.pages.ScrollToBottomPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static utils.Browser.launchBrowser;

public class SrollToBottomTest extends BaseTest {
    @BeforeClass
    void setUp(){
        launchBrowser("chrome");
    }

    @Test
    void scrollToBottom() throws InterruptedException {
        ScrollToBottomPage scrollToBottomPage = new ScrollToBottomPage();
        scrollToBottomPage.open();
        scrollToBottomPage.scrollToBottom(10);
    }
}
