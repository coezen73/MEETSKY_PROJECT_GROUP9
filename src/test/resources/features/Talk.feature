@Talk
Feature: Talk Module Functions

	#*US:*
	#User can start a call by clicking "Start call" button.
	#
	#*AC:*
	#* When clicking on any conversation on the left panel, a video call  tab should appear on the right
	#* When user clicking on the Start Call button on the right, should be able to start the video call
	#* Video call should start with unmute as a default.
	#* All participant should be shown under participant tab on right sidebar.
	#* After start video call, chat box will shown on the right sidebar as a default.
	#* When video call start, "no camera" option should be available.
	#* When video call start, "Enable Screensharing" option should be available
	#* When clicking on the Leave Call button on the right, user should be able to Stop the call
	#* A summary of the call history should appear after user stop the call
  @ETSKY-337
  Scenario: User can start a call by clicking "Start call" button.
    Given the user accesses the Log in page
    And the user login with valid credential "Employee29" "Employee123"
    When Navigate to "Talk" module
    And Enter "Employee101" into Search conversations or users inbox
    And Select user "Employee101"
    And Click on Start call button
    Then Verify video call page is shown.
    When Click on "Participants" option on the right sidebar.
    Then Verify user "Employee29" and participant "Employee101" are shown on participant tab.