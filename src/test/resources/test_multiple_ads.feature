Feature: B description

  Scenario Outline: B scenario
    Given website with category "<category>"
    When user add <ads> to favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar
    And close browser

    Examples:
      | category                                         | ads |
      | /transport/cars/audi/_group1/table.html?alladv=1 | 2   |