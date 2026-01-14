package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Browser {
    private static WebDriver driver;
    private static int MAX_TIMEOUT_SECOND = 20;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void launchBrowser(String name){
        switch (name.toLowerCase()){
            case "chrome":{
                driver =  new ChromeDriver();
                break;
            }
            case "firefox": {
                driver =  new FirefoxDriver();
                break;
            }
            case "edge" : {
                driver = new EdgeDriver();
                break;
            }
            case "safari": {
                driver =  new SafariDriver();
                break;
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT_SECOND));
        actions = new Actions(driver);
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
        }
    }
    public static void visit(String url){
        driver.get(url);
    }

    public static void click(By locator){
        driver.findElement(locator).click();
    }

    public static void fill(By locator, CharSequence... withText){
        driver.findElement(locator).sendKeys(withText);
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static void check(By locator){
        if(!isSelected(locator)){
            click(locator);
        }
    }

    public static void uncheck(By locator){
        if(isSelected(locator)){
            click(locator);
        }
    }
    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public static boolean isDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }

    public static void hover(By locator){
        actions.moveToElement(getElement(locator)).perform();
    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static void dragDrop(By source, By target){
        actions.dragAndDrop(getElement(source),getElement(target)).perform();
    }

    public static void captureScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void rightClickContextMenu(By locator){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(locator)).perform();
    }

    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public static boolean isMessageDisplayed(By locator, String text){
        return driver.findElement(locator)
                .getText()
                .contains(text);
    }

    public static boolean isImageBroken(By locator){
        WebElement img = driver.findElement(locator);
        int natureHeight = Integer.parseInt(img.getDomProperty("naturalHeight"));
        int natureWidth = Integer.parseInt(img.getDomProperty("naturalWidth"));
        return natureWidth>0 && natureHeight>0;
    }

    public static List<Boolean> isImagesBroken(By locator){

        List <Boolean> results = new ArrayList();
        driver.findElements(locator).forEach(img -> {
            int natureHeight = Integer.parseInt(img.getDomProperty("naturalHeight"));
            int natureWidth = Integer.parseInt(img.getDomProperty("naturalWidth"));
            if (natureWidth>0 && natureHeight>0) {
                results.add(true);
            } else {
                results.add(false);
            }
        });
        return results;
    }

    public static void dragAndDropElements(By source, By target){
        Actions actions = new Actions(driver);
        WebElement sourceE = driver.findElement(source);
        WebElement targetE = driver.findElement(target);
        actions.dragAndDrop(sourceE, targetE).perform();
    }


    public static void scrollToBotton(int offset) throws InterruptedException {
        Actions actions = new Actions(driver);

        for (int i = 0; i < offset; i++) {
            actions.scrollByAmount(0,1000).perform();
            Thread.sleep(1000);
        }
    }


}