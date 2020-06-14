Feature: Advanced search

  Scenario: Search for an item and add multiple ads to favorites
    When user search for "samsung" item
    And user "add" 2 ads in favorites
    Then ads are displayed on page
    And ads count on page is similar to memo count on toolbar
    And close browser
