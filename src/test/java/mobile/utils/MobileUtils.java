package mobile.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.FileChooserUI;
import javax.swing.text.Element;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class MobileUtils {

    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static String getText(WebDriver driver, WebElement element) {
        return element.getText().trim();
    }
    public static String getText(WebElement element) {
        String text;
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                text = element.getAttribute("text");
                break;
            case "iOS":
                text = element.getAttribute("label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }

        return text.trim();
    }

    public static void tapElement (AppiumDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().perform();

    }



    public static void swipeShort(AppiumDriver driver, String direction) {
        Dimension size = driver.manage().window().getSize();
        int startX, startY, endX, endY;

        switch (direction) {
            case "up":
                startX = size.width / 2;
                startY = (int) (size.height * 0.65);
                endX = startX;
                endY = (int) (size.height * 0.35);
                break;
            case "down":
                startX = size.width / 2;
                startY = (int) (size.height * 0.35);
                endX = startX;
                endY = (int) (size.height * 0.65);
                break;
            case "left":
                startX = (int) (size.width * 0.65);
                startY = size.height / 2;
                endX = (int) (size.width * 0.35);
                endY = startY;
                break;
            case "right":
                startX = (int) (size.width * 0.35);
                startY = size.height / 2;
                endX = (int) (size.width * 0.65);
                endY = startY;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
            Actions action = new Actions(driver);
            action.moveToLocation(startX, startY).
                    clickAndHold()
                    .moveToLocation(endX, endY)
                    .release()
                    .perform();
    }



    public static void switchToWebView(AppiumDriver driver) {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        String context = null;
        for (String ctx : androidDriver.getContextHandles()) {
            if (ctx.contains("FrameLayout")) {
                context = ctx;
                break;
            }
        }
    }


//    public static void getScreenShotWithCucumber(AppiumDriver driver, Scenario scenario) {
//        Date date = new Date();
//        String screenShotFileName=date.toString().replace("","-")
//                .replace(":","-");
//        if(scenario.isFailed()) {
//            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            try{
//                FileUti(screenShotFile,new File("src/test/java/screenshot/"
//                        +screenShotFileName+".png"));
//            }
//        }catch(IOException e){
//            throw  new RuntimeException(e);
//        }
//    }
}
