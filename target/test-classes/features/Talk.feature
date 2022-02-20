@ETSKY-339
Feature: Default

	#{color:#de350b}*US*{color}
	#As a MeetSky application basic user, I should be able to create a new conversation
	#
	#{color:#de350b}*AC*{color}
	#
	#Display all conversation lists under the Talk module
	#
	#When clicking on + sign on the left panel, a pop-up should appear
	#A pop-up should ask the user to enter the conversation name
	#A pop-up should ask the user to add participants
	#When clicking on Create button/link, the user should see the newly created conversation on the left
	@ETSKY-336
	Scenario: Talk Functionality Create a New Conversation - Cucumber S3
		Given the user logged in
		When navigate to Talk module
		And display all conversation list under the Talk module
		And click on +sign button
		And enter conversation name and add click participants button
		Then user created new conversation