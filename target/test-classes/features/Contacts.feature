@Contacts
Feature: Contacts Module Functions

	#*US:*
	#As a user, I should be able to create a new contact under Contacts module
	#
	#*AC:*
	#* User can create a new contact by clicking "+ New contact" button
	#* Fullname and Email information must be filled
	#* Fullname should consist at least 4 alphabetical character
	#* Fullname should not accept numeric char or other sign 
	#* Email should contain at least 3 numeric and/or alphabetical char
	#* Email should contain '@' char
	#* Email should bellong .net, .com, .org domain
	#* Created contact should be shown in list
	#* When click on a contact user can see detail information page
  @ETSKY-333
  Scenario: User can create a new contact via "+New contact" button
    Given the user accesses the Log in page
    And the user login with valid credential "Employee7" "Employee123"
    When Navigate to "Contacts" module
    And Click "+ New contact" button
    And Enter a "Andriana Grande" into fullname inbox
    And Enter an "adrn@cydeo.com" into Email inbox
    And Click any empty area
    Then Verify new contact is shown in contact list

  @ETSKY-383
  Scenario: User can create a new contact via "+New contact" button
    Given the user accesses the Log in page
    And the user login with valid credential "Employee17" "Employee123"
    When Navigate to "Contacts" module
    And Click "+ New contact" button
    And Enter a "Tom Cruise" into fullname inbox
    And Enter an "tmc@cydeo.com" into Email inbox
    And Click any empty area
    Then Verify new contact is shown in contact list