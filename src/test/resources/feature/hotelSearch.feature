Feature: Booking hotel search

  Scenario Outline:
    Given User is on "https://www.booking.com/searchresults.en-gb.html" page
    And The browser is maximized
    When User searches for "<hotelName>"
    Then "<hotelName>" is in the search result
    And "<hotelName>" rating is "<rating>"
    Examples:
      | hotelName            | rating |
      | Wyndham Dubai Marina | 8.1    |


