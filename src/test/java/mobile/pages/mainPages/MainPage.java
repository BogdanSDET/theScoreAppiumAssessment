package mobile.pages.mainPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Leagues\")")
    public WebElement leaguesBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.fivemobile.thescore:id/navigation_bar_item_large_label_view\")")
    public WebElement favoritesBtn;


    public void validateCurrentBarPage(WebElement element, String pageName){
        Assert.assertEquals(pageName,element.getText());
        Assert.assertTrue(element.isSelected());

    }
    public void chooseMainPage(WebElement element){
        element.click();

    }
}
