package mobile.pages.startPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.utils.MobileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ChooseFavTeamPage {
    public ChooseFavTeamPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    public WebElement continueButton;

    public String popularChoices = "//android.widget.TextView";

    public String allTeams = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\"]";

    public void choosePopularChoice(AppiumDriver driver, String popularChoices, String favorite, String direction) {
        boolean checked = true;
        int maxSwipes = 20; // Maximum number of swipes
        int swipeCount = 0; // Initialize swipe count

        do {
            if (swipeCount != 0) {
                MobileUtils.swipeShort(driver, direction); // Swipe to make new list of leagues visible
                }
                swipeCount++; // Increment swipe count}
                // Initialize new list
                List<WebElement> allFavorites = driver.findElements(By.xpath(popularChoices));

                for (WebElement fav : allFavorites) {
                    String favName = MobileUtils.getText(driver, fav);
                    if (fav.isSelected() & favName.equalsIgnoreCase(favorite)) {
                        checked = false;
                        break;
                    }
                    if (swipeCount >= maxSwipes) {//max swipes reached
                        checked = false;
                        System.out.println("There is no such recommended");
                        break;
                    }
                }



        }while (checked) ; // Continue until the league is found or max swipes reached
    }
    public void continueButtonClick(){
        Assert.assertTrue(continueButton.isDisplayed());
    }

}

