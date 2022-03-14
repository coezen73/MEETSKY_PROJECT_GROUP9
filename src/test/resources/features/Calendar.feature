@Calendar @Regression
Feature: Calendar Module

# US: As a user, I should be able to create a new event by using +New event button
# AC: When I click on +New event button, a pop-up will appear and create a new event by filling out the form


Background:
Given the user is on the login page
When the user enters the verified information
Then the user should be able to login


@Eric
Scenario: Users should be able to create a new event by using +New event button
Given the user can click calendar button
When the user can click "+New event" button
And the user should be able to see pop up page
Then the user should be able to write "Grooming Meeting" in the Event title line
And the user should be able to write date from "03/15/2022 10:00 AM"
And the user should be able to write date to "03/15/2022 11:00 AM"
When the user can click the save button



	#As a user, I should be able to see the Daily-Weekly-Monthly calendar view under the Calendar module
	#
	# 
	#
	#Under the Calendar module, a pop-up should appear when I click on the Hamburger menu
	#The Hamburger menu should include Day, Week, Month, List options
	#When clicking on Day, should display Daily calendar view
	#When clicking on Week, should display Weekly calendar view
	#When clicking on Month, should display Monthly calendar view
	#When clicking on List, should display List of calendar events
	#
	# 


@ETSKY-338

	Scenario: Calendar Display Functionality
#		Given the user logged in
		When navigate to Calendar module
		And display all Day, Week, Month, List Options under the Hamburger menu
		And clicking on Day, should display Daily calendar view
		And clicking on Week, should display Weekly calendar view
		And clicking on Month, should display Monthly calendar view
		And clicking on List, should display List of calendar events




