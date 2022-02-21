Feature: Verified users should be able to login
@Cemil
  Scenario: Login as a verified user
    Given the user is on the login page
    When the user enters the verified information
    Then the user should be able to login