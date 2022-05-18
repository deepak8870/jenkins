Feature: facebook functionality testing

  Scenario: facebook login page testing
    Given user is on the facebook login page
    When user should enter the username and password
    Then user should click the login button
    And user should verify the success message
