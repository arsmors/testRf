Feature: C description

  Scenario Outline: C scenario
    When user search for "<item>" item
    And user add <ads> to favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar

    Examples:
      | item | ads |
      | ford | 2   |