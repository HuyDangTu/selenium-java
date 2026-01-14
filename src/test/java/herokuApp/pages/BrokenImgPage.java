package herokuApp.pages;

import org.openqa.selenium.By;

import java.util.List;

import static utils.Browser.*;

public class BrokenImgPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/broken_images");
    }

    public boolean checkImageBroken(By locator){
        return isImageBroken(locator) ;
    }

    public List<Boolean> checkImagesBroken(By locator){
        return isImagesBroken(locator) ;
    }
}


