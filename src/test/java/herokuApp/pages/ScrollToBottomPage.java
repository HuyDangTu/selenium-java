package herokuApp.pages;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class ScrollToBottomPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/infinite_scroll");
    }

    public void scrollToBottom(int offset) throws InterruptedException {
        scrollToBotton(offset);
    }

    public boolean isScrolledToBottom(By locator, String msg) throws InterruptedException {
        return isMessageDisplayed(locator, msg);
    }

}

