Feature: insta functionality testing

  Scenario Outline: insta login page testing
    Given user is on the insta login page
    When user should enter the  "<username>" and "<password>"
    Then user should click the login button
    And user should verify the success message

    Examples: 
      | username       |  | password |
      | deepak_tricker |  | 88708574 |
