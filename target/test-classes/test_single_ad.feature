Feature: A description

  Scenario: A scenario
    Given website with category "/transport/cars/audi/_group1/table.html?alladv=1"
    When user open single ad
    And add to favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar
    And close browser
