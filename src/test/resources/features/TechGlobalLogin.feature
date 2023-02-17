Feature: TechGlobal Training Functionalities

  Scenario: Validate login
    Given user navigates to "https://techglobal-training.netlify.app/"
    When user clicks on "Practices" dropdown in the header
    And user selects the "Frontend Testing" option
    And user selects the "Login Form" card
    Then user should see "Login Form" headings
    When user enters username  "johndoe" and password  "123456"
    Then user should see a "Invalid Username entered!" message