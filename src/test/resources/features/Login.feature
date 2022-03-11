
Feature: Login Functionalities

Background:
   Given the user is on the login page

#US:
	#As a user I should be able to login with valid credentials.
	#AC: 
	#All users can login with valid credentials.No one should login with +invalid+ credentials.
  @ETSKY-382
  Scenario: Verified users should be able to login
      When the user enters the verified information
      Then the user should be able to login

  @ETSKY-391
  Scenario Outline: Login with invalid credentials
    When the the user logged in "<username>" and "<password>"
    Then the user should see the message "Wrong username or password."

    Examples:
      | username      | password      |
      | wrongUsername | wrongPassword |
      | wrongUsername | password      |
      | username      | wrongPassword |





