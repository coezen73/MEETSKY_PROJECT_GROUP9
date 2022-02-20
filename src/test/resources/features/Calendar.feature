@ETSKY-341
Feature: Default

	#*{color:#de350b}US{color}*
	#
	#As a user, I should be able to see the Daily-Weekly-Monthly calendar view under the Calendar module
	#
	# 
	#
	#*{color:#de350b}AC{color}*
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
		Given the user logged in
		When navigate to Calendar module
		And display all Day, Week, Month, List Options under the Hamburger menu
		And clicking on Day, should display Daily calendar view
		And clicking on Week, should display Weekly calendar view
		And clicking on Month, should display Monthly calendar view
		And clicking on List, should display List of calendar events