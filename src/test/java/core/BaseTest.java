package core;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import utils.Browser;

import static utils.Browser.captureScreenShot;
import static utils.Browser.quit;

public class BaseTest {
    @AfterMethod(alwaysRun = true)
    protected void captureScreenshotWhenFailed(ITestResult testResult){
        if(!testResult.isSuccess()){
            captureScreenShot(testResult.getMethod().getMethodName());
        }
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown(){
        quit();
    }
}
