package mobile.pages.mainPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaguesPage {

    public LeaguesPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.fivemobile.thescore:id/navigation_bar_item_large_label_view")
    public WebElement chosenLeaguesBtn;


    public String allLeagueNamesXpath = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/league_name_text\"]";

    @AndroidFindBy(id="com.fivemobile.thescore:id/titleTextView")
    public WebElement leagueTitle;

    String title;

    public String allSubTabs = "//android.widget.TextView[@text=\""+title+"\"]";

    public void checkLeaguesSubTabs(AppiumDriver driver,String allSubTabs){
        String[] listTitles = allSubTabs.split(" ");
        String xpath;
        for(String subTab : listTitles){
            xpath="//android.widget.TextView[@text="+"\""+subTab+"\""+"]";
            System.out.println(xpath);

//            Assert.assertEquals(subTab,driver.findElement(By.xpath(xpath)).getText().trim());
        }


    }







}

