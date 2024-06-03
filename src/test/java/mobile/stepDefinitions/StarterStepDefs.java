package mobile.stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.pages.mainPages.MainBar;
import mobile.pages.startPages.ChooseFavLeaguePage;
import mobile.pages.startPages.ChooseFavTeamPage;
import mobile.pages.startPages.SignUpPage;
import mobile.pages.startPages.StarterPage;
import mobile.utils.DriverManager;

import java.time.Duration;

public class StarterStepDefs {
    AppiumDriver driver = new DriverManager().getDriver();
    StarterPage starterPage = new StarterPage(driver) ;
    ChooseFavLeaguePage chooseFavLeaguePage = new ChooseFavLeaguePage(driver) ;
    ChooseFavTeamPage chooseFavTeamPage = new ChooseFavTeamPage(driver) ;
    SignUpPage signUpPage = new SignUpPage(driver) ;
    MainBar mainBar = new MainBar(driver) ;



    @Given("User clicks get started button on starter page")
    public void user_clicks_get_started_button_on_starter_page() {
       starterPage.clickGetStartedContinueBtn();
    }
    @And("User swipes {string} to choose {string} and clicks continue")
    public void user_swipes_to_choose_and_clicks_continue(String direction, String favorite) {
        chooseFavLeaguePage.chooseFavorite(driver,chooseFavLeaguePage.allLeaguesXpath,favorite,direction);
        starterPage.clickGetStartedContinueBtn();

    }
    @When("User swipes {string} to choose {string} from recommended")
    public void user_swipes_to_choose_from_recommended(String directions, String favorite) {
        chooseFavTeamPage.choosePopularChoice(driver,chooseFavTeamPage.popularChoices,favorite,directions);
    }

    @And("User swipes {string} to choose {string} to continue")
    public void user_swipes_to_choose_to_continue(String direction, String team) {
        chooseFavLeaguePage.chooseFavorite(driver,chooseFavTeamPage.allTeams,team,direction);
        starterPage.clickGetStartedContinueBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @When("User clicks continue button on starter page Maybe later on SignUp Page")
    public void user_clicks_continue_button_on_starter_page_Maybe_later_on_sign_up_page() {
        starterPage.clickGetStartedContinueBtn();
        signUpPage.clickMaybeLaterBtn();
    }
    @Then("User validates that he is on the {string} Page")
    public void user_validates_that_he_is_on_the_page(String pageName) {
        mainBar.validateMainBarPages(mainBar.favoritesBtn,pageName);
    }


}
