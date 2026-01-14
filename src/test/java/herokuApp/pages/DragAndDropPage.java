package herokuApp.pages;

import org.openqa.selenium.By;

import static utils.Browser.visit;
import static utils.Browser.isMessageDisplayed;
import static utils.Browser.dragAndDropElements;

public class DragAndDropPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void dragAndDropElement(By sourceId, By targetId){
        dragAndDropElements(sourceId,targetId);
    }

    public boolean checkDragAndDropSuccess(By locator, String msg){
        return isMessageDisplayed(locator,msg);
    }

}
