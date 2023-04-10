package by.teachmeskills.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {
    private static final By HOTEL_CARD_LOCATOR =
            By.xpath("//div[@data-testid='property-card']//div[@data-testid='title']");
    private static final String HOTEL_RATING_LOCATOR = "//div[@data-testid='title' and text() = '%s']"
            + "/ancestor::div[@data-testid='property-card']//span/div[@data-testid='review-score']";

    private ElementsCollection getSearchResults() {
        return $$(HOTEL_CARD_LOCATOR);
    }

    public boolean isElementInSearchResult(String hotelName) {
        return getSearchResults().texts().contains(hotelName);
    }

    public String getRating(String hotelName) {
        return $x(String.format(HOTEL_RATING_LOCATOR, hotelName)).text();
    }
}
