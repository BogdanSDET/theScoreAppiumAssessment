package mobile.pages.mainPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainBar {
    public MainBar(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Favorites\")")
    public WebElement favoritesBtn;


    public void validateMainBarPages(WebElement element, String pageName){
        Assert.assertEquals(pageName,element.getText());
        Assert.assertTrue(element.isSelected());

    }
}
