Feature: A description

  Scenario Outline: A scenario
    Given website with category "<category>"
    When user open single ad
    And add to favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar
    And close browser

    Examples:
      | category                                                                 |
      | /transport/cars/audi/_group1/table.html?alladv=1 |