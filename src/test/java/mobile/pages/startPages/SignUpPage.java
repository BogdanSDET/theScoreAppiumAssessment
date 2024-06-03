package mobile.pages.startPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public SignUpPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_secondary")
    public WebElement maybeLaterBtn;

    public void clickMaybeLaterBtn() {
        Assert.assertTrue(maybeLaterBtn.isDisplayed());
        Assert.assertTrue(maybeLaterBtn.isEnabled());
        maybeLaterBtn.click();
    }
}
