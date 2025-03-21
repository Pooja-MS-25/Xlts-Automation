Feature: User Authentication and Blockchain Request Submission

  Scenario: User Sign Up
    Given the user is on the sign-up page
    When the user enters a valid email "AutoTesing@gmail.com" and password "Password123"
    And the user clicks on "Sign Up"
    Then the user should be redirected to the dashboard

  Scenario: User Sign Up with Existing Email
    Given the user is on the sign-up page
    When the user enters an existing email "AutoTesing@gmail.com" and password "Password123"
    And the user clicks on "Sign Up"
    Then the "Sign Up" button should be disabled

  Scenario: User Sign In
    Given the user is on the sign-in page
    When the user enters a valid email "AutoTesing@gmail.com" and password "Password123"
    And the user clicks on "Sign In"
    Then the user should be redirected to the dashboard

  Scenario: Sign Out
    Given I am logged in
    When I click on "Sign Out"
    Then the user should be redirected to the dashboard

  Scenario: Sign Up Invalid
    Given I am on the sign-up page
    When I do not enter any email " " or password " "
    Then the "Sign Up" button should be disabled

  Scenario: Sign In Invalid
    Given I am on the sign-in page
    When I do not enter any email " " or password " "
    Then the "Sign In" button should be disabled
