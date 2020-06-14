Feature: D description

  Scenario: D scenario
    Given website with category "/transport/cars/audi/_group1/table.html?alladv=1"
    When user "add" 2 ads in favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar
    When user "delete" 1 ads in favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar
    And close browser