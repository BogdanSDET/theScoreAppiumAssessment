package mobile.pages.startPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.utils.MobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseFavLeaguePage {
    public ChooseFavLeaguePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
    public WebElement continueBtn;
    public String allLeaguesXpath="//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\"]";

    public List<WebElement> allLeagues;

//    public void chooseFavoriteLeague(AppiumDriver driver, String leagueName) {
//        int leagueSize = 48;
//        int leagueCount = 0;
//        boolean checked = false;
//
//        do {
//            if(checked){break;}  //checks if league is chosen
//            if (leagueCount != 0) {
//                    MobileUtils.swipeShort(driver, "up");//swipes to make new list of leagues visible
//                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0, 3));//initialize new list
//            }
//            allLeagues = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\"]"));
//            for (WebElement league : allLeagues) {
//                if (leagueName.equals(MobileUtils.getText(league))  //if specific league is visible we check
//                ) {
//                    league.click();
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
public void chooseFavorite(AppiumDriver driver, String listXpath, String favorite, String direction) {
    boolean checked = true;

    Map<String, Integer> elementMap = new HashMap<>();
    int count = 0;
    do {
        if (!checked) {
            break;  // Exit the loop if the league is chosen or end of page reached
        }
        if (count!=0){//not swiping in first round
        MobileUtils.swipeShort(driver, direction); // Swipe to make new list of leagues visible
        } // Initialize new list

        List<WebElement> allFavorites = driver.findElements(By.xpath(listXpath));

        for (WebElement fav : allFavorites) {
            String leagueName = MobileUtils.getText(driver,fav);
            count++;
            if (!elementMap.containsKey(leagueName))
            {elementMap.put(leagueName,1);}
            else
            {elementMap.put(leagueName,elementMap.get(leagueName)+1);
            }
             // Add the league name to the map, if map contains we check

            if (favorite.equals(leagueName)) { // If specific league is visible, we check
                fav.click();
                checked = false;
                break;
            }
            if(elementMap.get(leagueName)==3){//if the element appears third time we check
                checked = false;
                System.out.println("There is no such league");
                break; //if element appears third time we check
            }
        }

    } while (checked); // Continue until the league is found or end of page reached
}
    public void clickOnContinueBtn() {
        continueBtn.click();
    }
}
