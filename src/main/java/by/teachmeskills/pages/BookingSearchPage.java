package by.teachmeskills.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BookingSearchPage {
    private static final By HOTEL_NAME_INPUT = By.xpath("//input[@name='ss']");
    private static final String HOTELS_NAME_DROPDOWN =
            "//ul[@data-testid='autocomplete-results']//div[text()='%s']";
    private static final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");

    public BookingSearchPage enterHotelName(String hotelName) {
        $(HOTEL_NAME_INPUT).shouldBe(enabled).sendKeys(hotelName);
        return this;
    }

    public BookingSearchPage chooseHotelNameFromDropdown(String hotelName) {
        $x(String.format(HOTELS_NAME_DROPDOWN, hotelName)).shouldBe(visible).click();
        return this;
    }

    public SearchResultPage clickSearch() {
        $(SEARCH_BUTTON).shouldBe(visible, enabled).click();
        return new SearchResultPage();
    }
}
