package by.teachmeskills.steps;

import by.teachmeskills.pages.BookingSearchPage;
import by.teachmeskills.pages.SearchResultPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingSearchSteps {

    @Given("User is on {string} page")
    public void userIsOnPage(String pageAddress) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = chromeOptions;
        open(pageAddress);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @When("User searches for {string}")
    public void userSearchesFor(String hotelName) {
        new BookingSearchPage()
                .enterHotelName(hotelName)
                .chooseHotelNameFromDropdown(hotelName)
                .clickSearch();
    }

    @And("{string} rating is {string}")
    public void ratingIs(String hotelName, String rating) {
        assertThat(new SearchResultPage().getRating(hotelName))
                .as("Rating should be equal to expected")
                .contains(rating);
    }

    @Then("{string} is in the search result")
    public void isInTheSearchResult(String hotelName) {
        assertThat(new SearchResultPage().isElementInSearchResult(hotelName))
                .as("HotelName should be in the search result")
                .isTrue();
    }
}
