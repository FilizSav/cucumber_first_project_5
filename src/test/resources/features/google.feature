@Google
Feature: Google Search Functionality

  @Smoke
  Scenario: Validate Google Search
    Given user navigates to "https://www.google.com/"
    When user search for "Tesla"
    Then user should see "Tesla" in the url
    And user should see "Tesla" in the title

  @Regression
  Scenario Outline: Validate Google Search Results
    Given user navigates to <url>
    When user search for <key>
    Then user should see results are more than <results>
    Examples:
      | url                       | key     | results |
      | "https://www.google.com/" | "Apple" | 0       |