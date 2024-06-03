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
import java.util.LinkedList;
import java.util.List;

public class StarterPage   {

    public StarterPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
    public WebElement getStartedBtn;

    List<WebElement> allLeagues;
    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
    public WebElement continueBtn;





//    public void chooseFavoriteLeague(AppiumDriver driver,String listXpath, String favorite, String direction) {
//        int leagueCount = 0;
//        int leagueSize = 48;
//        boolean checked = false;
//        List<String> lastList = new LinkedList<>();
//        do {
//            if(checked){break;}  //checks if league is chosen
//            if (leagueCount != 0) {
//                MobileUtils.swipeShort(driver, direction);//swipes to make new list of leagues visible
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0, 3));//initialize new list
//            }
//            List<WebElement>allFavorites = driver.findElements(By.xpath(listXpath));
//            for (WebElement fav : allFavorites) {
//
//                if (favorite.equals(MobileUtils.getText(fav))  //if specific league is visible we check
//                ) {
//                    fav.click();
//                    checked = true;
//                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0, 3));
//                    break;
//                }
//                {
//                    leagueCount++;
//                }
//            }
//        } while ((leagueCount < leagueSize));
//    }
//public void chooseFavorite(AppiumDriver driver, String listXpath, String favorite, String direction) {
//    boolean checked = false;
//    List<WebElement> previousList = null;
//    do {
//        if (checked || (previousList != null && previousList.equals(driver.findElements(By.xpath(listXpath))))) {
//            break;  // Exit the loop if the league is chosen or end of page reached
//        }
//        MobileUtils.swipeShort(driver, direction); // Swipe to make new list of leagues visible
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0, 3)); // Initialize new list
//        List<WebElement> allFavorites = driver.findElements(By.xpath(listXpath));
//        for (WebElement fav : allFavorites) {
//            if (favorite.equals(MobileUtils.getText(fav))) { // If specific league is visible, we check
//                fav.click();
//                checked = true;
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0, 3));
//                break;
//            }
//        }
//        previousList = allFavorites;
//    } while (true); // Continue until the league is found or end of page reached
//}
//    public void clickOnContinueBtn() {
//        continueBtn.click();
//    }




    public void clickGetStartedContinueBtn() {   //used in all starter pages
        Assert.assertTrue(getStartedBtn.isDisplayed());
        getStartedBtn.click();
    }





}
