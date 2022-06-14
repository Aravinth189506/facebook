Feature: To verify login functionality of facebook application

  Background: 
    Given User should hit the url of facebook application in Gc browser

  Scenario Outline: to verify the login functionality of facebook application with valid credentials
    When User should enter "<username>" and "<password>"
    And User should click login button
    Then User should quit the browser

    Examples: 
      | username |  | password |
      | user1    |  |    12345 |
      | user2    |  |     6789 |
      | user3    |  |     4567 |

  Scenario: To verify the create new account functionality off facebook application with valid credentials
    When User should click create new account button
    And User should click the male button
    Then User should quit the browser
