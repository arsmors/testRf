import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseFunc;
import pages.FavoritesPage;
import pages.HomePage;
import pages.SearchPage;

public class MyStepdefs {
    BaseFunc baseFunc = new BaseFunc();
    HomePage homePage = new HomePage(baseFunc);
    SearchPage searchPage = new SearchPage(baseFunc);
    FavoritesPage favoritesPage = new FavoritesPage(baseFunc);

    @Given("website with category {string}")
    public void websiteWithCategory(String category) {
        homePage.openHomePage(category);
    }

    @When("user open single ad")
    public void userDrilldownIntoAd() throws InterruptedException {
        homePage.chooseRandomAdFromList();
    }

    @And("add to favorites")
    public void addToFavorites() throws InterruptedException {
        favoritesPage.addToFavorites();
    }

    @Then("ads are displayed on page")
    public void adsAreDisplayedOnPage() throws InterruptedException {
        homePage.openHomePage("/favorites.html");
        favoritesPage.checkAllAdsDisplayedOnPage();
    }

    @Then("ads count on page is similar to memo count on toolbar")
    public void adsCountOnPageIsSimilarToMemoCountOnToolbar() throws InterruptedException {
        favoritesPage.checkMemoToolbarHasCount();
    }

    @When("user {string} {int} ads in favorites")
    public void userAddAdsToFavorites(String addRemove, int ads) throws InterruptedException {
        homePage.addAds(addRemove, ads);

    }

    @When("user search for {string} item")
    public void searchForItem(String item) {
        homePage.openHomePage("data/advsearch.html?cat=&sc_id=0");
        searchPage.enterSearchDetails(item);
    }

    @And("close browser")
    public void closeBrowser() {
        baseFunc.closePage();
    }
}
