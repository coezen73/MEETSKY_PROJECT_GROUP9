
Feature: Verified users should be able to login

Background:
  Given the user is on the login page

  @Happy
  Scenario: Login as a verified user
    When the user enters the verified information
    Then the user should be able to login

  @Negative
  Scenario Outline: Login with invalid credentials
    When the the user logged in "<username>" and "<password>"
    Then the user should see the message "Wrong username or password."

    Examples:
      | username      | password      |
      | wrongUsername | wrongPassword |
      | wrongUsername | password      |
      | username      | wrongPassword |




