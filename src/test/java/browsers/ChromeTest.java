package browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v141.emulation.Emulation;
import org.openqa.selenium.devtools.v141.network.Network;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChromeTest {




    @Test
    void defaultMode(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }
    //3 A to consider a proper testcase:
    // - Arrange -pre-conditions
    // - Action - steps 1- n
    // - Assert - verify and Assert

    @Test
    void headlessMode(){
        // Arrange
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        // Action
        driver.get("https://www.selenium.dev/");
        // Assert
        Assert.assertEquals(driver.getTitle(),"Selenium");
        //driver.quit();
    }
    @Test
    void openBrowserWithMobileViewMode(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 344);
        deviceMetrics.put("height", 882);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        //driver.quit();
    }

    @Test
    void openBrowserWithOldVersion(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("145");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        //driver.quit();
    }

    @Test
    void openBrowserWithFakeGeoLocation(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(37.386052),
                Optional.of(-122.083851),
                Optional.of(1),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#lat-value")).getText(),"37.386052");
        Assert.assertEquals(driver.findElement(By.cssSelector("#long-value")).getText(),"-122.083851");

        //driver.quit();
    }

    @Test
    void interceptionNetwork(){
        WebDriver driver = new ChromeDriver();
        DevTools devTool = ((HasDevTools) driver).getDevTools();

        // Open devtool session
        devTool.createSession();
        devTool.send(Network.enable(Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        //Capture Request Payload
        /*
        devTool.addListener(Network.requestWillBeSent(), requestSent -> {
            System.out.println("Request URL => " + requestSent.getRequest().getUrl());
            System.out.println("Request Method => " + requestSent.getRequest().getMethod());
            System.out.println("Request Headers => " + requestSent.getRequest().getHeaders().toString());
            System.out.println("------------------------------------------------------");
        });

        // Capture request response
        devTool.addListener(Network.responseReceived(), responseReceived -> {
            System.out.println("Response Url => " + responseReceived.getResponse().getUrl());
            System.out.println("Response Status => " + responseReceived.getResponse().getStatus());
            System.out.println("Response Headers => " + responseReceived.getResponse().getHeaders().toString());
            System.out.println("Response MIME Type => " + responseReceived.getResponse().getMimeType().toString());
            System.out.println("------------------------------------------------------");
        });
        */
        devTool.addListener(Network.requestWillBeSent(), requestSent -> {
            String url = requestSent.getRequest().getUrl();
            if(url.contains("images/sponsors/lambda-test.png")) {
                System.out.println("Request: " + requestSent.getRequest().getPostData());
                System.out.println("------------------------------------------------------");
            }
        });

        devTool.addListener(Network.responseReceived(), responseReceived -> {;
            String url = responseReceived.getResponse().getUrl();
            if(url.contains("images/sponsors/lambda-test.png")) {
                System.out.println("Response: " + responseReceived.getResponse().getRequestHeaders());
                System.out.println("------------------------------------------------------");
            }
        });


        devTool.addListener(Network.responseReceived(), responseReceived -> {;
            String url = responseReceived.getResponse().getUrl();
            if(url.contains("images/sponsors/lambda-test.png")) {
                String RequestId = responseReceived.getRequestId().toString();
                Network.GetResponseBodyResponse body = devTool.send(
                        Network.getResponseBody(responseReceived.getRequestId()));
                System.out.println("Response Body:" + body.toString());
                System.out.println("------------------------------------------------------");
            }
        });

        driver.get("https://selenium.dev");
    }
}


