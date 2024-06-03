package mobile.stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.pages.mainPages.FavoritesPage;
import mobile.pages.mainPages.LeaguesPage;
import mobile.pages.mainPages.MainPage;
import mobile.pages.startPages.ChooseFavLeaguePage;
import mobile.pages.startPages.ChooseFavTeamPage;
import mobile.pages.startPages.SignUpPage;
import mobile.pages.startPages.StarterPage;
import mobile.utils.DriverManager;
import mobile.utils.MobileUtils;
import org.junit.Assert;

import java.time.Duration;

public class LeagueStepDef {

    AppiumDriver driver = new DriverManager().getDriver();
    StarterPage starterPage = new StarterPage(driver);
    ChooseFavTeamPage chooseFavTeamPage = new ChooseFavTeamPage(driver);
    FavoritesPage favoritesPage = new FavoritesPage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    LeaguesPage leaguesPage = new LeaguesPage(driver);
    MainPage mainPage = new MainPage(driver);
    ChooseFavLeaguePage chooseFavLeaguePage = new ChooseFavLeaguePage(driver);


    @Given("User clicks get started button on starter page")
    public void user_clicks_get_started_button_on_starter_page() {
        starterPage.clickGetStartedContinueBtn();
    }
    @And("User swipes {string} to choose {string} and clicks continue")

    public void user_swipes_to_choose_and_clicks_continue(String direction, String favorite) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
        mainPage.validateCurrentBarPage(favoritesPage.chosenFavoritesBtn,pageName);
    }

    @When("User clicks on Leagues tab")
    public void user_clicks_on_leagues_tab() {
      mainPage.chooseMainPage(mainPage.leaguesBtn);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @Then("User validates that he is on the {string} tab")
    public void user_validates_that_he_is_on_the_tab(String pageName) {
      mainPage.validateCurrentBarPage(leaguesPage.chosenLeaguesBtn, pageName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @When("User use scroll {string} and chooses {string} from leagues")
    public void user_use_scroll_and_chooses_from_leagues(String direction, String leagueName) {
        chooseFavLeaguePage.chooseFavorite(driver,leaguesPage.allLeagueNamesXpath,leagueName,direction);
    }
    @Then("User validates that he is {string} page")
    public void user_validates_that_he_is_page(String title) {
        Assert.assertEquals(title, MobileUtils.getText(driver,leaguesPage.leagueTitle));
    }
    @Then("User validates {string} as sub tabs")
    public void user_validates_as_sub_tabs(String subTabs) {
        leaguesPage.checkLeaguesSubTabs(driver,subTabs);
    }





}
